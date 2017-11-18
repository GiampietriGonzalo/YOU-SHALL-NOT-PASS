package GUI;

import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Logica.*;
import Creador.*;
import ObjetosComprables.*;


/**
 * Interfaz gráfica del juego. incluye el mapa, la tienda y la compra/venta de personajes. 
 * */
public class GUI_ extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frmYouShallNot;
	private Juego juego;
	protected PanelMapa panelMapa;
	private CreadorAliado creadorPersonajes;
	private JLabel lblMonedas;
	private JLabel lblPuntos;
	protected Aritmetica ari;
	private GameObject temporal;
	protected Manipulador mani;

	/**
	 * Constructor de la GUI.
	 */
	public GUI_() {
		frmYouShallNot=new JFrame();
		frmYouShallNot.setTitle("YOU SHALL NOT PASS!");
		frmYouShallNot.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_.class.getResource("/Imagenes/icono.jpg")));
		frmYouShallNot.setBounds(20, 20, 868, 683);
		frmYouShallNot.setVisible(true);
		
		panelMapa = new PanelMapa();
		panelMapa.setForeground(null);
		
		
		ari= new Aritmetica(0,50);
		mani= new Manipulador();
		juego=new Juego(panelMapa,mani,ari);
		mani.setJuego(juego);
		mani.colocarTorres();
		
		
		panelMapa.setBounds(17, 232,10*64, 6*64);
		
		
		
		lblMonedas = new JLabel("Monedas: "+ari.getMonedas());
		lblPuntos = new JLabel("Puntos: "+ari.getPuntos());
		
		Hilo hiloPrincipal=new Hilo(juego);
		hiloPrincipal.start();
		initialize();
	}

	public void setAritmerica(Aritmetica ari) {this.ari=ari;}
	public void setManipulador(Manipulador mani) {this.mani=mani;}
	
	/**
	 * Crea el contenido de la GUI.
	 */
	private void initialize() {
		frmYouShallNot.getContentPane().setBackground(Color.WHITE);
		frmYouShallNot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYouShallNot.setResizable(false);
		
		
		//Creacion panel de seleccion de personajes
		JPanel panel_personajes = new JPanel();
		panel_personajes.setOpaque(false);
		panel_personajes.setBounds(0, 620, 862, 34);
		panel_personajes.setLayout(new GridLayout(0, 6, 0, 0));
		
		JButton btnHumano = new JButton("(15)");
		btnHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorHumano(juego);
			}
		});
		btnHumano.setToolTipText("HUMANO");
		btnHumano.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonHumano.png")));
		
		JButton btnHobbit = new JButton("(10)");
		btnHobbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorHobbit(juego);
			}
		});
		
		btnHobbit.setToolTipText("HOBBIT");
		btnHobbit.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonHobbit.png")));
		panel_personajes.add(btnHobbit);
		panel_personajes.add(btnHumano);
		
		JButton btnElfo = new JButton("(12)");
		btnElfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorElfo(juego);
			}
		});
		
		btnElfo.setToolTipText("ELFO");
		btnElfo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonElfo.png")));
		panel_personajes.add(btnElfo);
		
		JButton btnEnano = new JButton("(16)");
		btnEnano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorEnano(juego);
			}
		});
		
		btnEnano.setToolTipText("ENANO");
		btnEnano.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonEnano.png")));
		panel_personajes.add(btnEnano);
		
		JButton btnMago = new JButton("(20)");
		btnMago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorMago(juego);
			}
		});
		
		btnMago.setToolTipText("MAGO");
		btnMago.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonMago.png")));
		panel_personajes.add(btnMago);
		
		//Creacion panel tienda
		JPanel panel_tienda = new JPanel();
		
		
		panel_tienda.setBackground(null);
		panel_tienda.setBounds(667, 136, 195, 479);
		panel_tienda.setOpaque(false);
		panel_tienda.setLayout(null);
		
		JButton btnGimli = new JButton("");
		btnGimli.setBackground(new Color(139, 69, 19));
		btnGimli.setBounds(5, 58, 167, 103);
		btnGimli.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/hachaGimli.png")));
		btnGimli.setToolTipText("Coloca un Enano potenciado");
		btnGimli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorEnanoPotenciado(juego);
			}
		});
		panel_tienda.add(btnGimli);
		
		JButton btnAragorn = new JButton("");
		btnAragorn.setBackground(new Color(47, 79, 79));
		btnAragorn.setBounds(5, 168, 167, 103);
		btnAragorn.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/coronaAragorn.png")));
		btnAragorn.setToolTipText("Aumenta el danio de todos los aliados en n 30% durante 5s");
		panel_tienda.add(btnAragorn);
		btnAragorn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComprableTemporal corona= new CoronaReyAragorn(juego);
				if(ari.getMonedas()>=corona.getPrecio()){	
					ari.sumarMonedas(-corona.getPrecio());
					corona.efecto();
				}
				else
					JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		JButton btnGandalf = new JButton("");
		btnGandalf.setBackground(Color.LIGHT_GRAY);
		btnGandalf.setBounds(5, 277, 167, 101);
		btnGandalf.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/baculoGandalf.png")));
		btnGandalf.setToolTipText("Coloca un mago potenciado");
		btnGandalf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorMagoPotenciado(juego);
			}
		});
		panel_tienda.add(btnGandalf);
		
		JButton btnLegolas = new JButton("");
		btnLegolas.setBackground(new Color(0, 128, 0));
		btnLegolas.setBounds(5, 384, 167, 103);
		btnLegolas.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/arcoLegolas.png")));
		btnLegolas.setToolTipText("Aumenta el alcance de todos los Aliados en un 50% durante 15s");
		panel_tienda.add(btnLegolas);
		btnLegolas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComprableTemporal arco= new ArcoLegolas(juego);
				if(ari.getMonedas()>= arco.getPrecio()){
					ari.sumarMonedas(-arco.getPrecio());
					arco.efecto();
				}
				else
					JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
			}
			}
		);
		
		
		panelMapa.setLayout(null);
		panelMapa.setBorder(null);
		panelMapa.setVisible(true);
		frmYouShallNot.getContentPane().setLayout(null);
		frmYouShallNot.getContentPane().add(panel_personajes);
		
		
		JButton btnEnt = new JButton("(25)");
		btnEnt.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonEnt.png")));
		btnEnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorEnt(juego);
			}
		});
		
		btnEnt.setToolTipText("ENT");
		panel_personajes.add(btnEnt);
		frmYouShallNot.getContentPane().add(panel_tienda);
		
		JLabel lblNewLabel_1 = new JLabel(" TIENDA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(37, 22, 104, 33);
		panel_tienda.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Ringbearer", Font.BOLD, 18));
		
		//Creacion panel puntos
		JPanel panel_puntos = new JPanel();
		panel_puntos.setOpaque(false);
		panel_puntos.setBackground(Color.WHITE);
		panel_puntos.setBounds(667, 11, 185, 92);
		frmYouShallNot.getContentPane().add(panel_puntos);

		lblPuntos.setForeground(new Color(255, 255, 0));
		lblPuntos.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblPuntos);

		lblMonedas.setForeground(new Color(255, 255, 0));
		lblMonedas.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblMonedas);
		
		frmYouShallNot.getContentPane().add(panelMapa);
		
		JPanel panel_bg = new JPanel();
		panel_bg.setBackground(null);
		panel_bg.setBounds(17, 21, 640, 213);
		panel_bg.setOpaque(false);
		frmYouShallNot.getContentPane().add(panel_bg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/fondomonta\u00F1a.png")));
		panel_bg.add(lblNewLabel);
		
		JButton btnVender = new JButton("VENDER PERSONAJE");
		btnVender.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVender.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/Moneda.png")));
		
		panelMapa.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
						int x=e.getX()-e.getX() % 64;
						int y=e.getY()-e.getY() % 64;
						
						if(creadorPersonajes!=null){ //Se coloca un aliado
							creadorPersonajes.crear(e.getX()/64,e.getY()/64);
							lblMonedas.setText("Monedas: "+ari.getMonedas());
							creadorPersonajes=null;
						}
						else{ //Reaccion de un power up
							if(juego.getMapa().getObject(x/64, y/64)!=null) 
								mani.reaccionar(x/64,y/64);
						}
					}
		});
		
		panelMapa.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent e) {
						int x=e.getX()-e.getX() % 64;
						int y=e.getY()-e.getY() % 64;
						temporal = juego.getMapa().getObject(x/64,y/64);
			}
		});
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					juego.venderPersonaje(temporal);
					temporal=null;
			}	
		});
		btnVender.setBounds(667, 110, 185, 34);
		frmYouShallNot.getContentPane().add(btnVender);
		
		JLabel labelFondo = new JLabel("");

		labelFondo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/FondoPanel.jpg")));
		labelFondo.setBounds(0, 0, 862, 654);
		frmYouShallNot.getContentPane().add(labelFondo);
		
	}
	
	//Hilo que actualiza los puntos y monedas
	public class Hilo extends Thread{
		
		private AudioClip musica_ganar = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/Medley.WAV"));
		private AudioClip musica_perder = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/game_over.wav"));

		private Juego elJuego;
		protected volatile boolean terminar = false;
		protected volatile boolean ganar = false;
		
		Hilo(Juego j) {
			elJuego = j;
		}
		public void run() {
			
			while(true){
				elJuego.actualizar();
				lblMonedas.setText("Monedas: "+ari.getMonedas());
				lblPuntos.setText("Puntos: "+ari.getPuntos());
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(elJuego.perder()) {
					musica_perder.play();
					String nl = System.getProperty("line.separator");
					int reinicio=JOptionPane.showConfirmDialog(null,"Perdiste!" + nl + "PUNTUACION:"+ari.getPuntos() + nl + "Queres reiniciar el juego?","Game Over",JOptionPane.YES_NO_OPTION);
					if(reinicio==0) {
						musica_perder.stop();
						panelMapa.repaint();
						elJuego.reiniciar();
					}
					else System.exit(0);
				}	
				else{
					if (elJuego.ganar()){
						musica_ganar.play();
						String nl = System.getProperty("line.separator");
						int reinicio1=JOptionPane.showConfirmDialog(null,"Ganaste!" + nl + "PUNTUACION:"+ari.getPuntos() + nl + "Queres reiniciar el juego?","Mision Cumplida",JOptionPane.YES_NO_OPTION);						
						if(reinicio1==0) {
							musica_ganar.stop();
							elJuego.reiniciar();
							panelMapa.repaint();
						}
						else System.exit(0);	
					}
				}
			}
		}
	}
}
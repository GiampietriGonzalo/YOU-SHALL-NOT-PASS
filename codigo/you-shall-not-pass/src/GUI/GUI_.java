package GUI;

//Importaciones
import java.awt.*;
import javax.swing.*;

import Creador.*;
import Logica.Juego;
import Logica.Mapa;
import Personajes.Aliado;

import java.awt.event.*;


public class GUI_ extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frmYouShallNot;
	private Juego juego;
	private JPanel panel_mapa;
	private CreadorAliado creadorPersonajes;
	private JLabel lblMonedas;
	private JLabel lblPuntos;
	Aliado a;


	/**
	 * Constructor de la GUI.
	 */
	public GUI_() {
		frmYouShallNot=new JFrame();
		frmYouShallNot.setTitle("YOU SHALL NOT PASS!");
		frmYouShallNot.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_.class.getResource("/Imagenes/icono.jpg")));
		frmYouShallNot.setBounds(20, 20, 868, 683);
		frmYouShallNot.setVisible(true);
		panel_mapa = new JPanel();
		panel_mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						int x=e.getX()-e.getX() % 64;
						int y=e.getY()-e.getY() % 64;
						
						if(creadorPersonajes!=null){ //Se coloca un aliado
							creadorPersonajes.crear(e.getX()/64,e.getY()/64);
							lblMonedas.setText("Monedas: "+juego.getMonedas());
							creadorPersonajes=null;
						}
						else{ //Reaccion de un power up
							if(juego.getMapa().getObject(x/64, y/64)!=null) 
								juego.reaccionar(x/64,y/64);
						}
					}
		});
		panel_mapa.setBounds(17, 232,10*64, 6*64);
		juego=new Juego(panel_mapa);
		lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		lblPuntos = new JLabel("Puntos: "+juego.getPuntos());
		ContadorPrueba contP=new ContadorPrueba(juego);
		contP.start();
		initialize();
	}

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
		
		
		JButton btnEnt = new JButton("(20)");
		btnEnt.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonEnt.png")));
		btnEnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creadorPersonajes=new CreadorEnt(juego);
			}
		});
		btnEnt.setToolTipText("ENT");
		panel_personajes.add(btnEnt);
		
		JButton btnMago = new JButton("(50)");
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
		btnGimli.setToolTipText("Aumenta el danio y la resistencia de todos los Enanos aliados durante 8s");
		panel_tienda.add(btnGimli);
		JButton btnAragorn = new JButton("");
		btnAragorn.setBackground(new Color(47, 79, 79));
		btnAragorn.setBounds(5, 168, 167, 103);
		btnAragorn.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/coronaAragorn.png")));
		btnAragorn.setToolTipText("Aumenta el danio de todos los Humanos aliados durante 10s");
		panel_tienda.add(btnAragorn);
		JButton btnGandalf = new JButton("");
		btnGandalf.setBackground(Color.LIGHT_GRAY);
		btnGandalf.setBounds(5, 277, 167, 101);
		btnGandalf.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/baculoGandalf.png")));
		btnGandalf.setToolTipText("Aumenta la resistencia y el alcance de todos los Magos aliados durante 5s");
		panel_tienda.add(btnGandalf);
		JButton btnLegolas = new JButton("");
		
		btnLegolas.setBackground(new Color(0, 128, 0));
		btnLegolas.setBounds(5, 384, 167, 103);
		btnLegolas.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/arcoLegolas.png")));
		btnLegolas.setToolTipText("Aumenta el alcance y el danio de todos los Elfos aliados durante 8s");
		panel_tienda.add(btnLegolas);
		
		panel_mapa.setBackground(new Color(0, 0, 0));
		
		panel_mapa.setLayout(null);
		panel_mapa.setBorder(null);
		panel_mapa.setVisible(true);
		frmYouShallNot.getContentPane().setLayout(null);
		frmYouShallNot.getContentPane().add(panel_personajes);
		frmYouShallNot.getContentPane().add(panel_tienda);
		
		JLabel lblNewLabel_1 = new JLabel(" TIENDA RAPIDA");
		lblNewLabel_1.setBounds(5, 22, 167, 33);
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
		
		//lblPuntos = new JLabel("Puntos: "+juego.getPuntos());
		lblPuntos.setForeground(new Color(255, 255, 0));
		lblPuntos.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblPuntos);
		
		//lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		lblMonedas.setForeground(new Color(255, 255, 0));
		lblMonedas.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblMonedas);
		
		frmYouShallNot.getContentPane().add(panel_mapa);
		
		JPanel panel_bg = new JPanel();
		panel_bg.setBackground(null);
		panel_bg.setBounds(17, 21, 640, 213);
		panel_bg.setOpaque(false);
		frmYouShallNot.getContentPane().add(panel_bg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/fondomonta\u00F1a.png")));
		panel_bg.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VENDER PERSONAJE");
		panel_mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						int x=e.getX()-e.getX() % 64;
						int y=e.getY()-e.getY() % 64;
						 a = (Aliado) juego.getMapa().getObject(x/64,y/64);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					juego.venderPersonaje(a);
			}	
		});
		btnNewButton.setBounds(677, 110, 163, 34);
		frmYouShallNot.getContentPane().add(btnNewButton);
		
		JLabel labelFondo = new JLabel("");

		labelFondo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/FondoPanel.jpg")));
		labelFondo.setBounds(0, 0, 862, 654);
		frmYouShallNot.getContentPane().add(labelFondo);
		lblNewLabel.setOpaque(true);
		
	}
	
	//Hilo que actualiza los puntos y monedas
	public class ContadorPrueba extends Thread{
		
		private Juego elJuego;
		protected volatile boolean terminar = false;
		protected volatile boolean ganar = false;
		
		ContadorPrueba(Juego j) {
			elJuego = j;
		}
		public void run() {
			
			while(true){
				elJuego.actualizar();
				lblMonedas.setText("Monedas: "+juego.getMonedas());
				lblPuntos.setText("Puntos: "+juego.getPuntos());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(elJuego.perder()) {
					String nl = System.getProperty("line.separator");
					int reinicio=JOptionPane.showConfirmDialog(null,"Perdiste!" + nl + "PUNTUACION:"+juego.getPuntos() + nl + "Queres reiniciar el juego?","Game Over",JOptionPane.YES_NO_OPTION);
					if(reinicio==0) {
						panel_mapa.repaint();
						elJuego.reiniciar();
					}
					else System.exit(0);
				}	
				else{
					if (elJuego.ganar()){
						String nl = System.getProperty("line.separator");
						int reinicio1=JOptionPane.showConfirmDialog(null,"Ganaste!" + nl + "PUNTUACION:"+juego.getPuntos() + nl + "Queres reiniciar el juego?","Mision Cumplida",JOptionPane.YES_NO_OPTION);						
						if(reinicio1==0) {
							elJuego.reiniciar();
							panel_mapa.repaint();
						}
						else System.exit(0);	
					}
				}
			}
		}
	}
}
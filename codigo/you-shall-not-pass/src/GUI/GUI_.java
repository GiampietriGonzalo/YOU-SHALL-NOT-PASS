package GUI;

//Importaciones
import java.awt.*;
import javax.swing.*;

import Logica.Juego;
import Personajes.*;
import java.awt.event.*;
import java.util.Random;


public class GUI_ extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmYouShallNot;
	private Juego juego;
	private JPanel panel_mapa;
	private Aliado temporal;
	private Contador contador;
	private JLabel lblMonedas;
	private JLabel lblPuntos;

	/**
	 * Constructor de la GUI.
	 */
	public GUI_() {
		frmYouShallNot=new JFrame();
		frmYouShallNot.setTitle("YOU SHALL NOT PASS!");
		frmYouShallNot.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_.class.getResource("/Imagenes/icono.jpg")));
		frmYouShallNot.setVisible(true);
		panel_mapa = new JPanel();
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
					
		frmYouShallNot.setBounds(20, 20, 868, 683);
		frmYouShallNot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYouShallNot.setResizable(false);
		
		//Creacion panel de seleccion de personajes
		JPanel panel_personajes = new JPanel();
		panel_personajes.setOpaque(false);
		panel_personajes.setBounds(0, 620, 862, 34);
		panel_personajes.setLayout(new GridLayout(0, 5, 0, 0));
		
		ActionListener oyenteBtnAliado= new oyenteBotonesCrear();
		JButton btnHumano = new JButton("(15)");
		btnHumano.setToolTipText("HUMANO");
		btnHumano.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonHumano.png")));
		btnHumano.addActionListener(oyenteBtnAliado);
		
		JButton btnHobbit = new JButton("(10)");
		btnHobbit.addActionListener(oyenteBtnAliado);
		btnHobbit.setToolTipText("HOBBIT");
		btnHobbit.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonHobbit.png")));
		panel_personajes.add(btnHobbit);
		panel_personajes.add(btnHumano);
		
		JButton btnElfo = new JButton("(12)");
		btnElfo.setToolTipText("ELFO");
		btnElfo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonElfo.png")));
		btnElfo.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnElfo);
		
		JButton btnEnano = new JButton("(16)");
		btnEnano.addActionListener(oyenteBtnAliado);
		btnEnano.setToolTipText("ENANO");
		btnEnano.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonEnano.png")));
		panel_personajes.add(btnEnano);
		
		JButton btnMago = new JButton("(50)");
		btnMago.setToolTipText("MAGO");
		btnMago.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonMago.png")));
		btnMago.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnMago);
		
		//Creacion panel tienda
		JPanel panel_tienda = new JPanel();
		
		
		panel_tienda.setBackground(null);
		panel_tienda.setBounds(667, 128, 195, 487);
		panel_tienda.setOpaque(false);
				panel_tienda.setLayout(null);
		
				JButton btnGimli = new JButton("");
				btnGimli.setBackground(new Color(139, 69, 19));
				btnGimli.setBounds(5, 11, 167, 103);
				btnGimli.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/hachaGimli.png")));
				btnGimli.setToolTipText("Aumenta el daño y la resistencia de todos los Enanos aliados durante 8s");
				panel_tienda.add(btnGimli);
				JButton btnAragorn = new JButton("");
				btnAragorn.setBackground(new Color(47, 79, 79));
				btnAragorn.setBounds(5, 125, 167, 103);
				btnAragorn.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/coronaAragorn.png")));
				btnAragorn.setToolTipText("Aumenta el daño de todos los Humanos aliados durante 10s");
				panel_tienda.add(btnAragorn);
				JButton btnGandalf = new JButton("");
				btnGandalf.setBackground(Color.LIGHT_GRAY);
				btnGandalf.setBounds(5, 239, 167, 101);
				btnGandalf.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/baculoGandalf.png")));
				btnGandalf.setToolTipText("Aumenta la resistencia y el alcance de todos los Magos aliados durante 5s");
				panel_tienda.add(btnGandalf);
				JButton btnLegolas = new JButton("");
				btnLegolas.setBackground(new Color(0, 128, 0));
				btnLegolas.setBounds(5, 351, 167, 103);
				btnLegolas.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/arcoLegolas.png")));
				btnLegolas.setToolTipText("Aumenta el alcance y el daño de todos los Elfos aliados durante 8s");
				panel_tienda.add(btnLegolas);
		//aca
		
		
		
		
		oyenteMouse oyenteM= new oyenteMouse();
		panel_mapa.setBackground(new Color(0, 0, 0));
		panel_mapa.addMouseListener(oyenteM);
		
		panel_mapa.setLayout(null);
		panel_mapa.setBorder(null);
		panel_mapa.setVisible(true);
		frmYouShallNot.getContentPane().setLayout(null);
		frmYouShallNot.getContentPane().add(panel_personajes);
		frmYouShallNot.getContentPane().add(panel_tienda);
		
		//Creacion panel puntos
		JPanel panel_puntos = new JPanel();
		panel_puntos.setBackground(Color.WHITE);
		panel_puntos.setBounds(667, 26, 185, 97);
		frmYouShallNot.getContentPane().add(panel_puntos);
		
		//lblPuntos = new JLabel("Puntos: "+juego.getPuntos());
		lblPuntos.setForeground(Color.DARK_GRAY);
		lblPuntos.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblPuntos);
		
		//lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		lblMonedas.setForeground(Color.DARK_GRAY);
		lblMonedas.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblMonedas);
		
		frmYouShallNot.getContentPane().add(panel_mapa);
		
		JLabel lblTorre = new JLabel("");
		lblTorre.setBounds(0, 0, 64, 384);
		panel_mapa.add(lblTorre);
		
		JPanel panel_bg = new JPanel();
		panel_bg.setBackground(null);
		panel_bg.setBounds(10, 21, 647, 213);
		panel_bg.setOpaque(false);
		frmYouShallNot.getContentPane().add(panel_bg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/fondomonta\u00F1a.png")));
		panel_bg.add(lblNewLabel);
		
		JLabel labelFondo = new JLabel("");

		labelFondo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/FondoPanel.jpg")));
		labelFondo.setBounds(0, 0, 862, 654);
		frmYouShallNot.getContentPane().add(labelFondo);
		//Para testear
		JButton btnAgregarEnemigo = new JButton("Agregar enemigo");
		btnAgregarEnemigo.setBounds(0, 464, 115, 23);
		panel_tienda.add(btnAgregarEnemigo);
		btnAgregarEnemigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random rdm=new Random(System.currentTimeMillis());
				int i=rdm.nextInt(6);
				Orco mago=new Orco();
				mago.setPosGrafic(0, i*64);
				juego.colocarEnemigo(mago,0, i);
				
			}
		});
		
	}
	
	
	//OYENTES
	public class oyenteBotonesCrear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			JButton aux=(JButton) e.getSource();
			
			switch (aux.getToolTipText()) {
			
			case "ELFO":{
				temporal=new Elfo(); break;
				}
			case "HUMANO":{
				temporal=new Humano(); break;
				}
			case "MAGO":{
				temporal=new Mago();break;
			}
			case "ENANO":{
				temporal=new Enano();break;
			}
			case "HOBBIT":{
				temporal=new Hobbit();break;
			}
			}
		}
	}
	
	public class oyenteMouse extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			if(temporal!=null) {
				int x=e.getX()-e.getX() % 64;
				int y=e.getY()-e.getY() % 64;
				temporal.setX(x/64);
				temporal.setY(y/64);
				temporal.setPosGrafic(x, y);
				juego.colocarAliado(temporal,e.getX()/64,e.getY()/64 );
				lblMonedas.setText("Monedas: "+juego.getMonedas());
				temporal=null;
			}		
		}
	}
	
	//Hilo que actualiza los puntos y monedas
	public class ContadorPrueba extends Thread{
		
		private Juego elJuego;
		protected volatile boolean terminar = false;
		
		ContadorPrueba(Juego j) {
			elJuego = j;
		}
		public void run() {
			while(true){
				elJuego.actualizar();
				lblMonedas.setText("Monedas: "+juego.getMonedas());
				lblPuntos.setText("Puntos: "+juego.getPuntos());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				terminar=elJuego.termino();
				if(terminar) {
					int reinicio=JOptionPane.showConfirmDialog(null,"Perdiste! Queres reiniciar el juego?","Game Over",JOptionPane.YES_NO_OPTION);
			
					if(reinicio==0) {
						elJuego.reiniciar();
						panel_mapa.repaint();
					}
					else System.exit(0);
				}
			}
			
			
		}
	}

}
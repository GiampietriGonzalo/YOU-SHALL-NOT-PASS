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
	private JFrame frame;
	private Juego juego;
	private JPanel panel_mapa;
	private Aliado temporal;
	private Contador contador;
	private JLabel lblMonedas;
	private JLabel lblPuntos;
	

	/**
	 * Inicializa la GUI y ejecuta la aplicaciÃ³n.
	 */
	public static void main(String[] args) {
		
		try {
			GUI_ window = new GUI_();
			window.frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * Constructor de la GUI.
	 */
	public GUI_() {
		
		panel_mapa = new JPanel();
		panel_mapa.setBounds(17, 232,10*64, 6*64);
		juego=new Juego(panel_mapa);
		contador=new Contador(juego);
		contador.start();
		initialize();
	}

	/**
	 * Crea el contenido de la GUI.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
					
		frame.setBounds(220, 20, 868, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		//Creacion panel de seleccion de personajes
		JPanel panel_personajes = new JPanel();
		panel_personajes.setOpaque(false);
		panel_personajes.setBounds(0, 620, 862, 34);
		panel_personajes.setLayout(new GridLayout(0, 5, 0, 0));
		
		ActionListener oyenteBtnAliado= new oyenteBotonesCrear();
		JButton btnHumano = new JButton("");
		btnHumano.setToolTipText("HUMANO");
		btnHumano.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonHumano.png")));
		btnHumano.addActionListener(oyenteBtnAliado);
		
		JButton btnHobbit = new JButton("");
		btnHobbit.addActionListener(oyenteBtnAliado);
		btnHobbit.setToolTipText("HOBBIT");
		btnHobbit.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonHobbit.png")));
		panel_personajes.add(btnHobbit);
		panel_personajes.add(btnHumano);
		
		JButton btnElfo = new JButton("");
		btnElfo.setToolTipText("ELFO");
		btnElfo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonElfo.png")));
		btnElfo.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnElfo);
		
		JButton btnEnano = new JButton("");
		btnEnano.addActionListener(oyenteBtnAliado);
		btnEnano.setToolTipText("ENANO");
		btnEnano.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonEnano.png")));
		panel_personajes.add(btnEnano);
		
		JButton btnMago = new JButton("");
		btnMago.setToolTipText("MAGO");
		btnMago.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonMago.png")));
		btnMago.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnMago);
		
		//Creacion panel tienda
		JPanel panel_tienda = new JPanel();
		panel_tienda.setBackground(null);
		panel_tienda.setBounds(657, 64, 195, 82);
		FlowLayout flowLayout = (FlowLayout) panel_tienda.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_tienda.setOpaque(false);
		
		//Panel de la tienda
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame frame_tienda = new JFrame();
				frame_tienda.setBounds(0, 0, 500, 500);
				frame_tienda.getContentPane().setBackground(Color.WHITE);
				frame_tienda.setResizable(false);
				
				JPanel panel_tienda = new JPanel();
				
				JButton btnGimli = new JButton("Hacha de Gimli");
				btnGimli.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/hachaGimli.png")));
				btnGimli.setToolTipText("Aumenta el daño y la resistencia de todos los Enanos aliados durante 8s");
				panel_tienda.add(btnGimli);
				JButton btnAragorn = new JButton("Corona del Rey Aragorn");
				btnAragorn.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/coronaAragorn.png")));
				btnAragorn.setToolTipText("Aumenta el daño de todos los Humanos aliados durante 10s");
				panel_tienda.add(btnAragorn);
				JButton btnGandalf = new JButton("Baculo de Gandalf");
				btnGandalf.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/baculoGandalf.png")));
				btnGandalf.setToolTipText("Aumenta la resistencia y el alcance de todos los Magos aliados durante 5s");
				panel_tienda.add(btnGandalf);
				JButton btnLegolas = new JButton("Arco de Legolas");
				btnLegolas.setIcon(new ImageIcon (this.getClass().getResource("/Imagenes/arcoLegolas.png")));
				btnLegolas.setToolTipText("Aumenta el alcance y el daño de todos los Elfos aliados durante 8s");
				panel_tienda.add(btnLegolas);
				
				panel_tienda.setLayout(new GridLayout(0, 1, 0, 0));
				frame_tienda.getContentPane().add(panel_tienda);
				frame_tienda.setVisible(true);
			}
		});
		btnTienda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_tienda.add(btnTienda);
		
		oyenteMouse oyenteM= new oyenteMouse();
		panel_mapa.setBackground(new Color(0, 0, 0));
		panel_mapa.addMouseListener(oyenteM);
		
		panel_mapa.setLayout(null);
		panel_mapa.setBorder(null);
		panel_mapa.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel_personajes);
		frame.getContentPane().add(panel_tienda);
		
		JButton btnAgregarEnemigo = new JButton("Agregar enemigo");
		panel_tienda.add(btnAgregarEnemigo);
		btnAgregarEnemigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random rdm=new Random(System.currentTimeMillis());
				int i=rdm.nextInt(6);
				MagoOscuro mago=new MagoOscuro(juego);
				mago.setPosGrafic(0, i*64);
				juego.colocarEnemigo(mago,0, i);
				
			}
		});
		
		//Creacion panel puntos
		JPanel panel_puntos = new JPanel();
		panel_puntos.setBackground(Color.WHITE);
		panel_puntos.setBounds(667, 340, 185, 112);
		frame.getContentPane().add(panel_puntos);
		
		lblPuntos = new JLabel("Puntos: "+juego.getPuntos());
		lblPuntos.setForeground(Color.DARK_GRAY);
		lblPuntos.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblPuntos);
		
		lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		lblMonedas.setForeground(Color.DARK_GRAY);
		lblMonedas.setFont(new Font("Aniron", Font.PLAIN, 20));
		panel_puntos.add(lblMonedas);
		
		frame.getContentPane().add(panel_mapa);
		
		JLabel lblTorre = new JLabel("");
		lblTorre.setBounds(0, 0, 64, 384);
		panel_mapa.add(lblTorre);
		
		JPanel panel_bg = new JPanel();
		panel_bg.setBackground(null);
		panel_bg.setBounds(10, 21, 647, 213);
		panel_bg.setOpaque(false);
		frame.getContentPane().add(panel_bg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/fondomonta\u00F1a.png")));
		panel_bg.add(lblNewLabel);
		
		JLabel labelFondo = new JLabel("");

		labelFondo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/FondoPanel.jpg")));
		labelFondo.setBounds(0, 0, 862, 654);
		frame.getContentPane().add(labelFondo);
		
		ContadorPuntos contP=new ContadorPuntos();
		contP.start();
	}
	
	
	//OYENTES
	public class oyenteBotonesCrear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			JButton aux=(JButton) e.getSource();
			
			switch (aux.getToolTipText()) {
			
			case "ELFO":{
				temporal=new Elfo(juego); break;
				}
			case "HUMANO":{
				temporal=new Humano(juego); break;
				}
			case "MAGO":{
				temporal=new Mago(juego);break;
			}
			case "ENANO":{
				temporal=new Enano(juego);break;
			}
			case "HOBBIT":{
				temporal=new Hobbit(juego);break;
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
	public class ContadorPuntos extends Thread{
		
		public void run(){
			while(true){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lblMonedas.setText("Monedas: "+juego.getMonedas());
				lblPuntos.setText("Puntos: "+juego.getPuntos());
			}
		}
		
	}
}
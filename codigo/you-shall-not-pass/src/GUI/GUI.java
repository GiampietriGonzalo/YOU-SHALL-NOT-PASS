package GUI;

//Importaciones
import java.awt.*;
import javax.swing.*;

import Logica.Juego;
import Personajes.*;
import java.awt.event.*;
import java.util.Random;


public class GUI extends JFrame{

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
	 * Inicializa la GUI y ejecuta la aplicación.
	 */
	public static void main(String[] args) {
		
		try {
			GUI window = new GUI();
			window.frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * Constructor de la GUI.
	 */
	public GUI() {
		
		panel_mapa = new JPanel();
		panel_mapa.setBounds(17, 53,10*64, 6*64);
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
					
		frame.setBounds(100, 100, 868, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		//Creacion panel de seleccion de personajes
		JPanel panel_personajes = new JPanel();
		panel_personajes.setBounds(0, 448, 862, 23);
		panel_personajes.setLayout(new GridLayout(0, 5, 0, 0));
		
		ActionListener oyenteBtnAliado= new oyenteBotonesCrear();
		JButton btnHumano = new JButton("Humano");
		btnHumano.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnHumano);
		
		JButton btnElfo = new JButton("Elfo");
		btnElfo.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnElfo);
		
		JButton btnHobbit = new JButton("Hobbit");
		panel_personajes.add(btnHobbit);
		
		JButton btnEnano = new JButton("Enano");
		panel_personajes.add(btnEnano);
		
		JButton btnMago = new JButton("Mago");
		btnMago.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnMago);
		
		//Creacion panel tienda
		JPanel panel_tienda = new JPanel();
		panel_tienda.setBackground(Color.WHITE);
		panel_tienda.setBounds(667, 53, 195, 153);
		FlowLayout flowLayout = (FlowLayout) panel_tienda.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_tienda.add(btnTienda);
		
		oyenteMouse oyenteM= new oyenteMouse();
		panel_mapa.setBackground(new Color(0, 0, 51));
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
		panel_puntos.setBounds(28, 0, 767, 24);
		frame.getContentPane().add(panel_puntos);
		
		lblPuntos = new JLabel("Puntos: "+juego.getPuntos());
		panel_puntos.add(lblPuntos);
		
		lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		panel_puntos.add(lblMonedas);
		
		frame.getContentPane().add(panel_mapa);
		
		JLabel lblTorre = new JLabel("");
		lblTorre.setBounds(0, 0, 64, 384);
		panel_mapa.add(lblTorre);
		
		ContadorPuntos contP=new ContadorPuntos();
		contP.start();
	}
	
	
	//OYENTES
	public class oyenteBotonesCrear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			JButton aux=(JButton) e.getSource();
			
			switch (aux.getText()) {
			
			case "Elfo":{
				temporal=new Elfo(juego); break;
				}
			case "Humano":{
				temporal=new Humano(juego); break;
				}
			case "Mago":{
				temporal=new Mago(juego);break;
			}
			//COMPLETAR CON EL RESTO DE LAS RAZAS
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
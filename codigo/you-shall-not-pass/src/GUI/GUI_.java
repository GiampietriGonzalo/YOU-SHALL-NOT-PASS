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
	 * Inicializa la GUI y ejecuta la aplicación.
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
					
		frame.setBounds(100, 100, 868, 683);
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
		panel_personajes.add(btnHumano);
		
		JButton btnElfo = new JButton("");
		btnElfo.setToolTipText("ELFO");
		btnElfo.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonElfo.png")));
		btnElfo.addActionListener(oyenteBtnAliado);
		panel_personajes.add(btnElfo);
		
		JButton btnHobbit = new JButton("");
		btnHobbit.setToolTipText("HOBBIT");
		btnHobbit.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/BotonHobbit.png")));
		panel_personajes.add(btnHobbit);
		
		JButton btnEnano = new JButton("");
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
		
		JButton btnTienda = new JButton("Tienda");
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
		panel_puntos.setBackground(null);
		panel_puntos.setBounds(667, 377, 185, 85);
		frame.getContentPane().add(panel_puntos);
		panel_puntos.setOpaque(false);
		
		lblPuntos = new JLabel("Puntos: "+juego.getPuntos());
		lblPuntos.setForeground(Color.YELLOW);
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_puntos.add(lblPuntos);
		
		lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		lblMonedas.setForeground(Color.YELLOW);
		lblMonedas.setFont(new Font("Tahoma", Font.PLAIN, 25));
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");

		lblNewLabel_1.setIcon(new ImageIcon(GUI_.class.getResource("/Imagenes/FondoPanel.jpg")));
		lblNewLabel_1.setBounds(0, 0, 862, 654);
		frame.getContentPane().add(lblNewLabel_1);
		
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
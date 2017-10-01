package GUI;

//Importaciones
import java.awt.*;
import javax.swing.*;
import Logica.Juego;
import Personajes.*;
import java.awt.event.*;

public class GUI extends JFrame{

	private JFrame frame;
	private Juego juego;
	private JPanel panel_mapa;
	private Aliado temporal;
	private Enemigo temporalE;
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
		temporalE=new Orco(juego);
		juego.colocarEnemigo(temporalE, 0, 0);
					
		frame.setBounds(100, 100, 868, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		//Creacion panel de seleccion de personajes
		JPanel panel_personajes = new JPanel();
		panel_personajes.setLayout(new GridLayout(0, 5, 0, 0));
		
		ActionListener oyenteBtnHumano= new oyenteBotonesCrear();
		JButton btnHumano = new JButton("Humano");
		btnHumano.addActionListener(oyenteBtnHumano);
		panel_personajes.add(btnHumano);
		
		ActionListener oyenteBtnElfo= new oyenteBotonesCrear(); 
		JButton btnElfo = new JButton("Elfo");
		btnElfo.addActionListener(oyenteBtnElfo);
		panel_personajes.add(btnElfo);
		
		JButton btnHobbit = new JButton("Hobbit");
		panel_personajes.add(btnHobbit);
		
		JButton btnEnano = new JButton("Enano");
		panel_personajes.add(btnEnano);
		
		JButton btnMago = new JButton("Mago");
		panel_personajes.add(btnMago);
		
		//Creacion panel tienda
		JPanel panel_tienda = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_tienda.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_tienda.add(btnTienda);
		
		oyenteMouse oyenteM= new oyenteMouse();
		panel_mapa.setBackground(Color.WHITE);
		panel_mapa.addMouseListener(oyenteM);
		
		panel_mapa.setLayout(null);
		panel_mapa.setBorder(null);
		panel_mapa.setVisible(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel_personajes, BorderLayout.SOUTH);
		frame.getContentPane().add(panel_tienda, BorderLayout.EAST);
		
		JButton btnAgregarEnemigo = new JButton("Agregar enemigo");
		panel_tienda.add(btnAgregarEnemigo);
		btnAgregarEnemigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		//Creacion panel puntos
		JPanel panel_puntos = new JPanel();
		frame.getContentPane().add(panel_puntos, BorderLayout.NORTH);
		
		lblPuntos = new JLabel("Puntos: "+juego.getPuntos());
		panel_puntos.add(lblPuntos);
		
		lblMonedas = new JLabel("Monedas: "+juego.getMonedas());
		panel_puntos.add(lblMonedas);
		
		
		frame.getContentPane().add(panel_mapa);
		
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
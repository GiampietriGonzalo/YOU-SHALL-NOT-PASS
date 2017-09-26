package GUI;

//Importaciones
import java.awt.*;
import javax.swing.*;
import Logica.Juego;
import Personajes.*;
import java.awt.event.*;


//MI RAMA
public class GUI extends JFrame{

	private JFrame frame;
	private Juego juego;
	private JPanel panel_mapa;
	private Aliado temporal;
	private Enemigo temporalE;
	private final Icon spriteHumano=new ImageIcon("humano.png");
	private Contador contador;
	
	

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
		temporalE=new Orco(0,0);
		juego.colocarEnemigo(temporalE, 0, 0);
					
					
		frame.setBounds(100, 100, 868, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel_personajes = new JPanel();
		panel_personajes.setBounds(10, 406, 640, 44);
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
		
		JPanel panel_tienda = new JPanel();
		panel_tienda.setBounds(687, 26, 75, 33);
		FlowLayout flowLayout = (FlowLayout) panel_tienda.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_tienda.add(btnTienda);
		
		
		oyenteMouse oyenteM= new oyenteMouse();
		panel_mapa.setLocation(10, 11);
		panel_mapa.setSize(juego.getMapa().getAnch()*64,juego.getMapa().getAlt()*64);
		panel_mapa.setBackground(Color.WHITE);
		panel_mapa.addMouseListener(oyenteM);
		
		
		panel_mapa.setLayout(null);
		panel_mapa.setBorder(null);
		panel_mapa.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel_personajes);
		frame.getContentPane().add(panel_tienda);
		frame.getContentPane().add(panel_mapa);
		
		JLabel lblGandalf = new JLabel("");
		lblGandalf.setIcon(new ImageIcon(this.getClass().getResource("/GUI/you-shall-not-pass.jpg")));
		lblGandalf.setBounds(660, 87, 226, 348);
		frame.getContentPane().add(lblGandalf);
	}
	
	
	
	//OYENTES
	public class oyenteBotonesCrear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			JButton aux=(JButton) e.getSource();
			
			switch (aux.getText()) {
			
			case "Elfo":{
				temporal=new Elfo(0,0); break;
				}
			case "Humano":{
				temporal=new Humano(0,0); break;
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
				temporal.setX(x);
				temporal.setY(y);
				juego.colocarAliado(temporal, e.getX()/64,e.getY()/64 );
				temporal=null;
			}		
		}
	}
	
}
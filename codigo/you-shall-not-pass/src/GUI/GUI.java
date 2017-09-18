package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Logica.Juego;
import Mapa.Mapa;
import Personajes.*;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;

public class GUI {

	private JFrame frame;
	private Juego juego;
	private JPanel panel_mapa;
	private Personaje temporal;
	private JLabel[][] grillaPersonajes;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		juego=new Juego(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_personajes = new JPanel();
		frame.getContentPane().add(panel_personajes, BorderLayout.SOUTH);
		panel_personajes.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnHumano = new JButton("Humano");
		btnHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temporal=new Humano();
			}
		});
		panel_personajes.add(btnHumano);
		
		JButton btnElfo = new JButton("Elfo");
		panel_personajes.add(btnElfo);
		
		JButton btnHobbit = new JButton("Hobbit");
		panel_personajes.add(btnHobbit);
		
		JButton btnEnano = new JButton("Enano");
		panel_personajes.add(btnEnano);
		
		JButton btnMago = new JButton("Mago");
		panel_personajes.add(btnMago);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnTienda);
		
		panel_mapa = new JPanel();
		panel_mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(temporal!=null){
					Point punto=e.getPoint();
					temporal.setX(punto.x);
					temporal.setY(punto.y);
					juego.colocarPersonaje(temporal, punto.x,punto.y);
					//grillaPersonajes[punto.x][punto.y].setIcon(temporal.getImg());
					
				}
				
			}
		});
		frame.getContentPane().add(panel_mapa, BorderLayout.CENTER);
		
		panel_mapa.setLayout(new GridLayout(10, 6, 0, 0));
		
		grillaPersonajes=new JLabel[juego.getMapa().getAnch()][juego.getMapa().getAlt()];
		for(int i=juego.getMapa().getAnch();i<grillaPersonajes.length;i++){
			for(int j=juego.getMapa().getAlt();j<grillaPersonajes[0].length;j++){
				grillaPersonajes[i][j]=new JLabel();
				panel_mapa.add(grillaPersonajes[i][j]);
			}
		}

	}
	
}

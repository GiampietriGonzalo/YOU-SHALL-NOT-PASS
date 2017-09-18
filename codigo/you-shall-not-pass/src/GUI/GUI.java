package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Logica.Juego;
import Mapa.Mapa;
import Personajes.*;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI {

	private JFrame frame;
	private Juego juego;
	private JPanel panel_mapa;
	private Aliado temporal;
	private JLabel[][] grillaPersonajes;
	private final Icon spriteHumano=new ImageIcon("humano.png");
	
	

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
		juego=new Juego();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel_personajes = new JPanel();
		panel_personajes.setBounds(10, 406, 640, 44);
		panel_personajes.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnHumano = new JButton("Humano");
		btnHumano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temporal=new Humano();
			}
		});
		panel_personajes.add(btnHumano);
		
		JButton btnElfo = new JButton("Elfo");
		btnElfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temporal=new Elfo();
			}
		});
		panel_personajes.add(btnElfo);
		
		JButton btnHobbit = new JButton("Hobbit");
		panel_personajes.add(btnHobbit);
		
		JButton btnEnano = new JButton("Enano");
		panel_personajes.add(btnEnano);
		
		JButton btnMago = new JButton("Mago");
		panel_personajes.add(btnMago);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(687, 26, 75, 33);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnTienda);
		
		panel_mapa = new JPanel();
		panel_mapa.setLocation(10, 11);
		panel_mapa.setSize(juego.getMapa().getAnch()*64,juego.getMapa().getAlt()*64);
		panel_mapa.setBackground(Color.WHITE);
		panel_mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(temporal!=null) {
					int x=e.getX()-e.getX() % 64;
					int y=e.getY()-e.getY() % 64;
					juego.colocarPersonaje(temporal, e.getX()/64,e.getY()/64 );
					
					JLabel bicho=new JLabel();
					panel_mapa.add(bicho);
					bicho.setBackground(temporal.getColor());
					bicho.setBounds(x, y, 64, 64);
					bicho.setVisible(true);
					bicho.setOpaque(true);
					temporal=null;
				}
			}
		});
		
		panel_mapa.setLayout(null);
		panel_mapa.setBorder(null);
		panel_mapa.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel_personajes);
		frame.getContentPane().add(panel_1);
		frame.getContentPane().add(panel_mapa);
	}
	
}

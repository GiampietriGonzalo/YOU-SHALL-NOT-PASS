package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Bienvenida {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Bienvenida window = new GUI_Bienvenida();
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
	public GUI_Bienvenida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(20, 20, 868, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				GUI_ juegoPrincipal=new GUI_();
				
			}
		});
		btnJugar.setBounds(74, 537, 167, 67);
		frame.getContentPane().add(btnJugar);
		
		JButton btnSobreElJuego = new JButton("Sobre el juego");
		btnSobreElJuego.setBounds(339, 531, 167, 78);
		frame.getContentPane().add(btnSobreElJuego);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(599, 537, 167, 67);
		frame.getContentPane().add(btnSalir);
		
		JLabel lblImagen = new JLabel("imagen");
		lblImagen.setBackground(Color.BLACK);
		lblImagen.setBounds(149, 105, 560, 226);
		lblImagen.setOpaque(true);
		frame.getContentPane().add(lblImagen);
	}
}

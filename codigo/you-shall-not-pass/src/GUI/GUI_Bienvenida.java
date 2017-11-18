package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * Interfaz gráfica de la bienvenida al juego. 
 * */

public class GUI_Bienvenida {

	private JFrame frmYouShallNot;
	private String[] arreglomain;
	private AudioClip clip = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/Medley.WAV"));

	
	//Inicia la aplicacion.
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Bienvenida window = new GUI_Bienvenida();
					window.frmYouShallNot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GUI_Bienvenida() {
		initialize();
	}

	
	private void initialize() {
		frmYouShallNot = new JFrame();
		frmYouShallNot.setTitle("YOU SHALL NOT PASS!");
		frmYouShallNot.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Bienvenida.class.getResource("/Imagenes/icono.jpg")));
		frmYouShallNot.setBounds(20, 20, 868, 683);
		clip.loop();
		frmYouShallNot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYouShallNot.getContentPane().setLayout(null);
		
		JButton btnJugar = new JButton("");
		btnJugar.setIcon(new ImageIcon(GUI_Bienvenida.class.getResource("/Imagenes/jugar.png")));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmYouShallNot.dispose();
				clip.stop();
				@SuppressWarnings("unused")
				GUI_ juegoPrincipal=new GUI_();
				
			}
		});
		btnJugar.setBounds(74, 537, 167, 67);
		frmYouShallNot.getContentPane().add(btnJugar);
		
		JButton btnSobreElJuego = new JButton("");
		btnSobreElJuego.setIcon(new ImageIcon(GUI_Bienvenida.class.getResource("/Imagenes/sobre.png")));
		btnSobreElJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmYouShallNot.dispose();
				GUI_Info.main(arreglomain);;
			}
		});
		btnSobreElJuego.setBounds(339, 537, 167, 72);
		frmYouShallNot.getContentPane().add(btnSobreElJuego);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(GUI_Bienvenida.class.getResource("/Imagenes/salir.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(599, 537, 167, 72);
		frmYouShallNot.getContentPane().add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUI_Bienvenida.class.getResource("/Imagenes/imagenprincipal.png")));
		lblNewLabel.setBounds(376, 48, 436, 258);
		frmYouShallNot.getContentPane().add(lblNewLabel);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(GUI_Bienvenida.class.getResource("/Imagenes/FondoPrincipal.jpg")));
		lblImagen.setBackground(Color.BLACK);
		lblImagen.setBounds(0, 0, 852, 644);
		lblImagen.setOpaque(true);
		frmYouShallNot.getContentPane().add(lblImagen);
	}
}

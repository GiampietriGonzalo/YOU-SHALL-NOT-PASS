package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Info {

	private JFrame frmInfo;
	private String[] arreglomain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Info window = new GUI_Info();
					window.frmInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		public GUI_Info() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frmInfo = new JFrame();
			frmInfo.getContentPane().setBackground(Color.BLACK);
			frmInfo.setTitle("SOBRE EL JUEGO");
			frmInfo.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_Bienvenida.class.getResource("/Imagenes/icono.jpg")));
			frmInfo.setBounds(20, 20, 1200, 683);
			//clip.loop();
			frmInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmInfo.getContentPane().setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 1164, 544);
			frmInfo.getContentPane().add(scrollPane);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setIcon(new ImageIcon(GUI_Info.class.getResource("/Imagenes/info.png")));
			scrollPane.setViewportView(lblNewLabel);
			
			JButton btnNewButton = new JButton("VOLVER");
			btnNewButton.setFont(new Font("Aniron", Font.PLAIN, 14));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					frmInfo.dispose();
					GUI_Bienvenida.main(arreglomain);
					
				}
			});
			btnNewButton.setBounds(959, 567, 151, 66);
			frmInfo.getContentPane().add(btnNewButton);

		}
	}


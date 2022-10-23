package interfaz;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;
	private JPanel panel;
	private JButton btnNewButton;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crearMenu();
		 
		eventoBotonIniciar();
		
		

	}
	private void crearMenu(){
       crearFrame();
		
		crearPanel();
		
		crearLabels();
		
		crearbotonDeIniciar();
		
		crearcombobox();
	}
	private void crearFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearPanel() {
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(10, 10, 604, 497);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
	}
	private void crearLabels() {
		JLabel lblNewLabel = new JLabel("FIFA World Cup");
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblNewLabel.setBounds(200, 11, 234, 72);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Qatar 2022");
		lblNewLabel_1.setFont(new Font("Cooper Black", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(238, 54, 162, 72);
		panel.add(lblNewLabel_1);
		
	}
	
	private void crearcombobox() {
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(212, 138, 239, 22);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Un solo usuario", "N usuarios que donan figuritas", "N usuarios que intercambian figuritas" }));
		
	}
	private void crearbotonDeIniciar() {
		btnNewButton = new JButton("Iniciar Simulación");
		btnNewButton.setBounds(217, 353, 234, 44);
		panel.add(btnNewButton);
	}
	
	private void eventoBotonIniciar() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new SimuladorInterface();
				frame.setVisible(false);

			}
		});

	}
	
}

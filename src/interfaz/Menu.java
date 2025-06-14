package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import escenarios.Escenario;
import escenarios.Escenario1;
import escenarios.Escenario2;
import escenarios.Escenario3;

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
	private JButton btnIniciarSimulador;
	private JLabel txtFifa;
	private JLabel txtQatar;
	private JComboBox<String> comboBox;

	private JLabel txtCantUsuarios;
	private JTextField cantidadFiguritasXPaquete;
	private JLabel txtCantidadFiguritasXPaquete;
	private JTextField cantidadFiguritasTotal;
	private JLabel txtCantidadFiguritasTotal;
	private JTextField cantidadUsuarios;
	private JLabel txtCantidadSimulaciones;
	private JTextField cantSimulaciones;

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

	public Menu() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		crearMenu();

	}

	private void crearMenu() {
		crearFrame();
		crearPanel();
		crearLabels();
		crearSeleccionCantidades();
		crearbotonDeIniciar();
		crearcombobox();
		eventoBotonIniciar();
		

	}

	private void crearFrame() {
		frame = new JFrame("Simulador");
		frame.setBounds(450, 150, 639, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
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
		txtFifa = new JLabel("Simulador FIFA World Cup");
		txtFifa.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		txtFifa.setBounds(129, 10, 395, 72);
		panel.add(txtFifa);

		txtQatar = new JLabel("Qatar 2022");
		txtQatar.setFont(new Font("Cooper Black", Font.PLAIN, 22));
		txtQatar.setBounds(238, 54, 162, 72);
		panel.add(txtQatar);

	}

	private void crearcombobox() {
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Consolas", Font.BOLD, 13));
		comboBox.setBounds(189, 138, 277, 36);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Un solo usuario",
				"N usuarios que donan figuritas", "N usuarios que intercambian figuritas" }));

	}

	private void crearbotonDeIniciar() {
		btnIniciarSimulador = new JButton("Iniciar Simulador");
		btnIniciarSimulador.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnIniciarSimulador.setBounds(201, 353, 234, 44);
		panel.add(btnIniciarSimulador);
	}

	private void eventoBotonIniciar() {
		btnIniciarSimulador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cantFiguritasXpaquete = getCantFiguritasXPaquete();
				int cantFiguritas = getCantFiguritas();
				int cantSimulaciones = getCantSimulaciones();

				Escenario escenario = getEscenario();

				new SimuladorInterface(cantFiguritas, cantFiguritasXpaquete, escenario, cantSimulaciones);
				frame.setVisible(false);

			}

		});

	}

	private void crearSeleccionCantidades() {
		txtCantUsuarios = new JLabel("Cantidad de usuarios:");
		txtCantUsuarios.setForeground(new Color(255, 255, 255));
		txtCantUsuarios.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		txtCantUsuarios.setBounds(10, 205, 147, 22);
		panel.add(txtCantUsuarios);

		cantidadUsuarios = new JTextField("1");
		cantidadUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantidadUsuarios.setColumns(10);
		cantidadUsuarios.setBounds(270, 205, 49, 20);
		panel.add(cantidadUsuarios);

		txtCantidadFiguritasTotal = new JLabel("Cantidad total de figuritas del album:");
		txtCantidadFiguritasTotal.setForeground(Color.WHITE);
		txtCantidadFiguritasTotal.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		txtCantidadFiguritasTotal.setBounds(10, 237, 253, 22);
		panel.add(txtCantidadFiguritasTotal);

		cantidadFiguritasTotal = new JTextField("638");
		cantidadFiguritasTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantidadFiguritasTotal.setColumns(10);
		cantidadFiguritasTotal.setBounds(270, 237, 49, 20);
		panel.add(cantidadFiguritasTotal);

		txtCantidadFiguritasXPaquete = new JLabel("Cantidad de figuritas por paquete:");
		txtCantidadFiguritasXPaquete.setForeground(Color.WHITE);
		txtCantidadFiguritasXPaquete.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		txtCantidadFiguritasXPaquete.setBounds(10, 269, 247, 22);
		panel.add(txtCantidadFiguritasXPaquete);

		cantidadFiguritasXPaquete = new JTextField("5");
		cantidadFiguritasXPaquete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantidadFiguritasXPaquete.setBounds(270, 269, 49, 20);
		panel.add(cantidadFiguritasXPaquete);
		cantidadFiguritasXPaquete.setColumns(10);

		txtCantidadSimulaciones = new JLabel("Cantidad de simulaciones:");
		txtCantidadSimulaciones.setForeground(Color.WHITE);
		txtCantidadSimulaciones.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		txtCantidadSimulaciones.setBounds(10, 302, 247, 22);
		panel.add(txtCantidadSimulaciones);

		cantSimulaciones = new JTextField("5");
		cantSimulaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cantSimulaciones.setColumns(10);
		cantSimulaciones.setBounds(270, 300, 49, 20);
		panel.add(cantSimulaciones);

	}

	public Escenario getEscenario() {

		Escenario escenario;
		if (getEscenarioSeleccionado() == 0)
			escenario = new Escenario1();
		else if (getEscenarioSeleccionado() == 1)
			escenario = new Escenario2(getCantUsuarios());
		else
			escenario = new Escenario3(getCantUsuarios());
		return escenario;
	}

	private int getEscenarioSeleccionado() {
		return comboBox.getSelectedIndex();
	}

	public int getCantFiguritas() {
		int cantFiguritas = Integer.parseInt(cantidadFiguritasTotal.getText());
		return cantFiguritas;
	}

	public int getCantSimulaciones() {
		int cantSimulacion = Integer.parseInt(cantSimulaciones.getText());
		return cantSimulacion;
	}

	public int getCantFiguritasXPaquete() {
		int cantFiguritasXpaquete = Integer.parseInt(cantidadFiguritasXPaquete.getText());
		return cantFiguritasXpaquete;
	}

	private int getCantUsuarios() {
		return Integer.parseInt(cantidadUsuarios.getText());
	}
}

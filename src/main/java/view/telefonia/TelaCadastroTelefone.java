package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroTelefone {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
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
	public TelaCadastroTelefone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDDD = new JLabel("DDD:");
		lblDDD.setBounds(10, 15, 46, 15);
		frame.getContentPane().add(lblDDD);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(10, 45, 46, 15);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblNewLabel = new JLabel("Ativo:");
		lblNewLabel.setBounds(10, 75, 45, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(55, 12, 65, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 41, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}

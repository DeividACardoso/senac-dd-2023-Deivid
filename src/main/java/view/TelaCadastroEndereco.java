package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.vo.telefonia.Endereco;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroEndereco {

	private JFrame frmCadastroDeEndereco;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JLabel lblCep;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JComboBox comboBoxEstado;

	private String[] estados = {"Paraná", "Rio Grande do Sul"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco window = new TelaCadastroEndereco();
					window.frmCadastroDeEndereco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeEndereco = new JFrame();
		frmCadastroDeEndereco.setTitle("Cadastro de Endereço");
		frmCadastroDeEndereco.setBounds(100, 100, 387, 250);
		frmCadastroDeEndereco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeEndereco.getContentPane().setLayout(null);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(15, 15, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(75, 12, 282, 20);
		frmCadastroDeEndereco.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(15, 40, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(15, 65, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblNumero);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(15, 90, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblBairro);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(15, 115, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblCidade);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(15, 140, 45, 14);
		frmCadastroDeEndereco.getContentPane().add(lblEstado);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(75, 37, 282, 20);
		frmCadastroDeEndereco.getContentPane().add(txtRua);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(75, 62, 282, 20);
		frmCadastroDeEndereco.getContentPane().add(txtNumero);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(75, 87, 282, 20);
		frmCadastroDeEndereco.getContentPane().add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(75, 112, 282, 20);
		frmCadastroDeEndereco.getContentPane().add(txtCidade);
		
		comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setSelectedIndex(-1);
		comboBoxEstado.setBounds(75, 136, 282, 22);
		frmCadastroDeEndereco.getContentPane().add(comboBoxEstado);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Endereco endereco = new Endereco();
				endereco.setRua(txtRua.getText());
				endereco.setCep(txtCep.getText());
				endereco.setCidade(txtCidade.getText());
				endereco.setEstado((String) comboBoxEstado.getSelectedItem());
				endereco.setNumero(txtNumero.getText());
				endereco.setBairro(txtBairro.getText());
				
				EnderecoController controller = new EnderecoController();
				controller.inserir(endereco);
			}
		});
		btnSalvar.setBounds(138, 169, 90, 31);
		frmCadastroDeEndereco.getContentPane().add(btnSalvar);
		
	}
}

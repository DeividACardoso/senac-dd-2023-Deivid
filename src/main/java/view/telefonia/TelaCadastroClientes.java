package view.telefonia;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

import model.dao.telefonia.EnderecoDAO;
import model.vo.telefonia.Endereco;

public class TelaCadastroClientes {

	private JFrame frmCadastroCliente;
	private JFormattedTextField formattedTextFieldCpf;
	private MaskFormatter mascaraCpf;
	private EnderecoDAO dao;
	private ArrayList<Endereco> listaDeEnderecos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroClientes window = new TelaCadastroClientes();
					window.frmCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroCliente = new JFrame();
		frmCadastroCliente.setBounds(100, 100, 450, 300);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroCliente.getContentPane().setLayout(null);
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");

			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(15, 15, 70, 20);
			frmCadastroCliente.getContentPane().add(lblNome);
			
			JLabel lblCpf = new JLabel("CPF: ");
			lblCpf.setBounds(15, 45, 70, 20);
			frmCadastroCliente.getContentPane().add(lblCpf);
			
			JLabel lblEndereco = new JLabel("Endereço: ");
			lblEndereco.setBounds(15, 75, 70, 20);
			frmCadastroCliente.getContentPane().add(lblEndereco);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(75, 15, 300, 20);
			frmCadastroCliente.getContentPane().add(textArea);
			
			formattedTextFieldCpf = new JFormattedTextField(mascaraCpf);
			formattedTextFieldCpf.setBounds(75, 45, 125, 20);
			frmCadastroCliente.getContentPane().add(formattedTextFieldCpf);
			
			listaDeEnderecos.addAll(dao.consultarTodos());
			JComboBox cbEnderecos = new JComboBox();
			cbEnderecos.setToolTipText("Selecione");
			cbEnderecos.setBounds(75, 75, 300, 20);
			frmCadastroCliente.getContentPane().add(cbEnderecos);
			
			
			
			mascaraCpf.setValueContainsLiteralCharacters(false);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

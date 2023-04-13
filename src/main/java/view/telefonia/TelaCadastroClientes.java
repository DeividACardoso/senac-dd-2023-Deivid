package view.telefonia;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EnderecoController;
import model.exception.CampoInvalidoException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;

public class TelaCadastroClientes {

	private JFrame frmCadastroCliente;
	private JFormattedTextField fTxtCpf;
	private MaskFormatter mascaraCpf;
	private EnderecoController controller = new EnderecoController();
	private List<Endereco> listaDeEnderecos = new ArrayList<Endereco>();
	private JComboBox cbEnderecos;
	private JTextArea txtNome;
	private JLabel lblEndereco;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JButton btnSalvar;
	

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
		frmCadastroCliente.setBounds(100, 100, 450, 175);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroCliente.getContentPane().setLayout(null);
		
			
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 15, 70, 20);
		frmCadastroCliente.getContentPane().add(lblNome);
			
		lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(15, 45, 70, 20);
		frmCadastroCliente.getContentPane().add(lblCpf);
		
		lblEndereco = new JLabel("Endereço: ");
		lblEndereco.setBounds(15, 75, 70, 20);
		frmCadastroCliente.getContentPane().add(lblEndereco);
		
		txtNome = new JTextArea();
		txtNome.setBounds(75, 15, 349, 20);
		frmCadastroCliente.getContentPane().add(txtNome);
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			
			mascaraCpf.setValueContainsLiteralCharacters(false);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fTxtCpf = new JFormattedTextField(mascaraCpf);
		fTxtCpf.setBounds(75, 45, 349, 20);
		frmCadastroCliente.getContentPane().add(fTxtCpf);
		
		listaDeEnderecos = controller.consultarTodos();
		
		cbEnderecos = new JComboBox(listaDeEnderecos.toArray());
		cbEnderecos.setToolTipText("Selecione");
		cbEnderecos.setBounds(75, 75, 349, 20);
		frmCadastroCliente.getContentPane().add(cbEnderecos);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				try {
					String cpfSemMascara = (String) mascaraCpf.stringToValue(fTxtCpf.getText());
					cliente.setCpf(cpfSemMascara);
				} catch (ParseException e2) {
					JOptionPane.showMessageDialog(null,
					"Erro ao converter o CPF: \n" + e2.getMessage(), 
					"Erro", JOptionPane.WARNING_MESSAGE);
				}
				cliente.setEndereco((Endereco) cbEnderecos.getSelectedItem());
				
				ClienteController controllerCliente = new ClienteController();
				
				try {
					controllerCliente.inserir(cliente);
					JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (CpfJaUtilizadoException e1) {
					JOptionPane.showMessageDialog(null, 
							"CPF já utilizado: \n" + e1.getMessage(), 
							"Atenção", JOptionPane.WARNING_MESSAGE);
				} catch (EnderecoInvalidoException e1) {
					JOptionPane.showMessageDialog(null, 
							"Endereço inválido: \n" + e1.getMessage(), 
							"Atenção", JOptionPane.WARNING_MESSAGE);
				} catch (CampoInvalidoException e1) {
					JOptionPane.showMessageDialog(null, 
							"Preencha os seguintes campos: \n" + e1.getMessage(), 
							"Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		btnSalvar.setBounds(335, 106, 89, 23);
		frmCadastroCliente.getContentPane().add(btnSalvar);
			
		
	}
}

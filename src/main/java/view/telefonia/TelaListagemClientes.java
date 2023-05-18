package view.telefonia;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.exception.ClienteComTelefoneException;
import model.vo.telefonia.Cliente;

public class TelaListagemClientes {

	private JFrame frmClientes;
	private JTable tblClientesBuscados;
	private JButton btnBuscarTodos;
	private JButton btnExcluir;
	private JButton btnEditar;
	private ArrayList<Cliente> clientes;
	private String[] nomesColunas = { "#", "Nome", "CPF", "Ativo", "ID Endereço" };
	private ClienteController controller = new ClienteController();
	
	private Cliente clienteSelecionado;

	private void limparTabela() {
		tblClientesBuscados.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}
	
	private void atualizarTabelaClientes() {
		this.limparTabela();
		
		ClienteController controller = new ClienteController();
		clientes = (ArrayList<Cliente>) controller.consultarTodos();
		
		DefaultTableModel model = (DefaultTableModel) tblClientesBuscados.getModel();
		for (Cliente e : clientes) {
			Object[] novaLinhaDaTabela = new Object[5];
			
			novaLinhaDaTabela[0] = e.getId();
			novaLinhaDaTabela[1] = e.getNome();
			novaLinhaDaTabela[2] = e.getCpf();
			novaLinhaDaTabela[3] = e.getTelefones();
			novaLinhaDaTabela[4] = e.getEndereco().getId();
			
			model.addRow(novaLinhaDaTabela);
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemClientes window = new TelaListagemClientes();
					window.frmClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagemClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientes = new JFrame();
		frmClientes.setBounds(100, 100, 700, 525);
		frmClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientes.getContentPane().setLayout(null);
		
		tblClientesBuscados = new JTable();
		this.limparTabela();
		tblClientesBuscados.setBounds(15, 70, 655, 350);
		frmClientes.getContentPane().add(tblClientesBuscados);
		tblClientesBuscados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblClientesBuscados.getSelectedRow();
				
				if(indiceSelecionado > 0) {
					clienteSelecionado = clientes.get(indiceSelecionado - 1);
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				}
			}
		});
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabelaClientes();
			}
		});
		btnBuscarTodos.setBounds(294, 11, 100, 45);
		frmClientes.getContentPane().add(btnBuscarTodos);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(570, 431, 100, 45);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do cliente selecionado?");
				
				if(opcaoSelecionada == JOptionPane.YES_OPTION) {
					try {
						controller.excluir(opcaoSelecionada);
						JOptionPane.showMessageDialog(null, "Cliente excluído!",
								"Sucesso", JOptionPane.INFORMATION_MESSAGE);
						
						atualizarTabelaClientes();
					} catch (ClienteComTelefoneException excecao) {
						JOptionPane.showMessageDialog(null, excecao.getMessage(),
								"Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroClientes telaEdicaoCliente = new TelaCadastroClientes(clienteSelecionado);
				
			}
		});
		btnEditar.setBounds(460, 431, 100, 45);
		
		
		frmClientes.getContentPane().add(btnExcluir);
		frmClientes.getContentPane().add(btnEditar);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
}

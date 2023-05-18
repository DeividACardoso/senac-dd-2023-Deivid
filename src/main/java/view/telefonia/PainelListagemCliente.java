package view.telefonia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.ClienteController;
import controller.TelefoneController;
import model.vo.telefonia.Cliente;

public class PainelListagemCliente extends JPanel {
	private JTable tblClientes;
	private String[] nomesColunas = { "ID", "Nome", "CPF", "Endereço" };
	private List<Cliente> clientes = new ArrayList();
	private ClienteController controller = new ClienteController();

	private void limparTabela() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabela() {
		this.limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

		for(Cliente c : this.clientes) {

		Object[] novaLinhaDaTabela = new Object[4];
		novaLinhaDaTabela[0] = c.getId();
		novaLinhaDaTabela[1] = c.getNome();
		novaLinhaDaTabela[2] = c.getCpf();
		novaLinhaDaTabela[3] = c.getEndereco();

		model.addRow(novaLinhaDaTabela);
		}
	}

	private void buscarClientes() {
		this.clientes = controller.consultarTodos();
		this.atualizarTabela();
	}

	public PainelListagemCliente() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(7dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));


		tblClientes = new JTable();
		add(tblClientes, "1, 4, fill, fill");
		buscarClientes();
	}
}
package view.telefonia;

import java.util.ArrayList;

import javax.swing.JLabel;
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
import model.vo.telefonia.Telefone;

	
public class TelaListagemTelefone extends JPanel {
	private JTable tabelaTelefones;
	private String[] nomeColunas = {"Número Completo", "DDD", "Nome Cliente", "Ativo?"};
	private ArrayList<Telefone> telefones;
	
	
	private void limparTabela() {
		tabelaTelefones.setModel(new DefaultTableModel(new Object[][] { nomeColunas, }, nomeColunas));
	}
	
	private void atualizarTabelaClientes() {
		this.limparTabela();
		Telefone telefone = new Telefone();
		TelefoneController t = new TelefoneController();
		telefones = (ArrayList<Telefone>) t.consultarTodos();
		
		String nomeCompleto = "Sem nome.";
		if(nomeCompleto != null) {
			ClienteController clienteController = new ClienteController();
			
			Cliente clienteBuscado = clienteController.consultarPorId(telefone.getIdCliente());
			nomeCompleto = clienteBuscado.getNome();
		}
		
		DefaultTableModel model = (DefaultTableModel) tabelaTelefones.getModel();
		for (Telefone e : telefones) {
			Object[] novaLinhaDaTabela = new Object[4];
			
			novaLinhaDaTabela[0] = e.getNumero();
			novaLinhaDaTabela[1] = e.getDdd();
			novaLinhaDaTabela[2] = nomeCompleto;
			novaLinhaDaTabela[3] = e.isAtivo();
			
			model.addRow(novaLinhaDaTabela);
		}
	}
	
	/**
	 * Create the panel.
	 */
	public TelaListagemTelefone() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(298dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "2, 2, fill, fill");
		
		tabelaTelefones = new JTable();
		add(tabelaTelefones, "2, 4, fill, fill");
		atualizarTabelaClientes();
	}

}

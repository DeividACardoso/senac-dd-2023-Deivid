package view.telefonia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.TelefoneController;
import model.exception.TelefoneJaUtilizadoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Telefone;

public class TelaCadastroTelefone {

	private JFrame frmNovoTelefone;
	private JLabel lblTipo;
	private JLabel lblNumero;
	private JLabel lblCliente;
	private JRadioButton rbMovel;
	private JRadioButton rbFixo;
	private JButton btnSalvar;
	private JComboBox cbClientes;

	private MaskFormatter mascaraTelefoneFixo;
	private MaskFormatter mascaraTelefoneMovel;
	private JFormattedTextField txtTelefoneFixo;
	private JFormattedTextField txtTelefoneMovel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
					window.frmNovoTelefone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Método que será chamado ao iniciar a tela
	 * escondendo todos os componentes exceto os ratiobuttons "Fixo" e "Móvel"
	 * @throws ParseException 
	 */
	public TelaCadastroTelefone() throws ParseException {
		initialize();
		esconderTodosOsComponentes();
	}

	private void esconderTodosOsComponentes() {
		lblNumero.setVisible(false);
		txtTelefoneFixo.setVisible(false);
		lblCliente.setVisible(false);
		cbClientes.setVisible(false);
		btnSalvar.setEnabled(false);
	}
	/*
	 * Mostra todos os componentes ao clicar em "Fixo" ou "Móveç"
	 */
	private void mostrarComponentesComuns() {
		lblNumero.setVisible(true);
		lblCliente.setVisible(true);
		cbClientes.setVisible(true);
		btnSalvar.setEnabled(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frmNovoTelefone = new JFrame();
		frmNovoTelefone.setTitle("Novo Telefone");
		frmNovoTelefone.setBounds(100, 100, 401, 251);
		frmNovoTelefone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNovoTelefone.getContentPane().setLayout(null);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(30, 30, 45, 14);
		frmNovoTelefone.getContentPane().add(lblTipo);

		lblNumero = new JLabel("Número");
		lblNumero.setBounds(30, 60, 45, 14);
		frmNovoTelefone.getContentPane().add(lblNumero);

		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(30, 90, 45, 14);
		frmNovoTelefone.getContentPane().add(lblCliente);

		mascaraTelefoneFixo = new MaskFormatter("(##)####-####");
		mascaraTelefoneMovel = new MaskFormatter("(##)9####-####");
		
		mascaraTelefoneFixo.setValueContainsLiteralCharacters(false);
		mascaraTelefoneMovel.setValueContainsLiteralCharacters(false);

		rbMovel = new JRadioButton("Móvel");
		rbMovel.setBounds(260, 25, 100, 23);
		rbMovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarComponentesComuns();
				txtTelefoneMovel.setVisible(true);
				txtTelefoneFixo.setVisible(false);
			}
		});
		frmNovoTelefone.getContentPane().add(rbMovel);

		rbFixo = new JRadioButton("Fixo");
		rbFixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarComponentesComuns();
				txtTelefoneMovel.setVisible(false);
				txtTelefoneFixo.setVisible(true);
			}
		});
		rbFixo.setBounds(90, 26, 100, 23);
		frmNovoTelefone.getContentPane().add(rbFixo);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbFixo);
		grupo.add(rbMovel);

		txtTelefoneFixo = new JFormattedTextField(mascaraTelefoneFixo);
		txtTelefoneFixo.setBackground(new Color(192, 192, 192));
		txtTelefoneFixo.setForeground(new Color(255, 0, 255));
		txtTelefoneFixo.setBounds(90, 60, 270, 20);
		frmNovoTelefone.getContentPane().add(txtTelefoneFixo);

		txtTelefoneMovel = new JFormattedTextField(mascaraTelefoneMovel);
		txtTelefoneMovel.setForeground(Color.BLUE);
		txtTelefoneMovel.setBounds(90, 60, 270, 20);
		txtTelefoneMovel.setVisible(false);
		frmNovoTelefone.getContentPane().add(txtTelefoneMovel);

		ClienteController cliController = new ClienteController();
		cbClientes = new JComboBox(cliController.consultarTodos().toArray());
		cbClientes.setBounds(90, 90, 270, 22);
		cbClientes.setSelectedItem(null); //Inicia sem preenchimento
		frmNovoTelefone.getContentPane().add(cbClientes);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(30, 123, 330, 62);
		frmNovoTelefone.getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Telefone novoTelefone = new Telefone();
				novoTelefone.setMovel(rbMovel.isSelected());				
				preencherNumeroDDD(novoTelefone);
				
				Cliente clienteSelecionado = (Cliente) cbClientes.getSelectedItem();
				if(clienteSelecionado != null) {
					novoTelefone.setIdCliente(clienteSelecionado.getId());
				}
				TelefoneController telController = new TelefoneController();
				try {
					telController.inserir(novoTelefone);
				} catch (TelefoneJaUtilizadoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Atenção!", JOptionPane.ERROR_MESSAGE);
				}	
				JOptionPane.showMessageDialog(null, "Telefone Salvo", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				limparTela();
			}
		});
		
	}

	protected void limparTela() {
		this.rbFixo.setSelected(false);
		this.rbMovel.setSelected(false);
		this.txtTelefoneFixo.setText("");
		this.txtTelefoneMovel.setText("");
		this.cbClientes.setSelectedIndex(-1);
	}

	protected void preencherNumeroDDD(Telefone novoTelefone) {
		String numeroCompletoDigitado = "";
		if(novoTelefone.isMovel()) {
			try {
				numeroCompletoDigitado = mascaraTelefoneMovel.stringToValue(txtTelefoneMovel.getText()) + "\n";
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			novoTelefone.setNumero(null);
		} else {
			try {
				numeroCompletoDigitado = mascaraTelefoneFixo.stringToValue(txtTelefoneFixo.getText()) + "\n";
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		String ddd = numeroCompletoDigitado.substring(0, 2);
		String numero = numeroCompletoDigitado.substring(2);
		novoTelefone.setDdd(ddd);
		novoTelefone.setNumero(numero);
	}
}
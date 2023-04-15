package view.telefonia;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import controller.TelefoneController;
import model.vo.telefonia.Telefone;

public class TelaCadastroTelefone {

	private JFrame frame;
	private MaskFormatter mascaraDDD;
	private MaskFormatter mascaraNumero;
	private JLabel lblDDD;
	private JLabel lblNumero;
	private JLabel lblNewLabel;
	private JCheckBox chckbxAtivo;
	private JButton btnSalvar;
	private JFormattedTextField fTxtDDD;
	private JFormattedTextField fTxtNumero;

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
		frame.setBounds(100, 100, 230, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			mascaraDDD = new MaskFormatter("##");
			mascaraNumero = new MaskFormatter("#####-####");
			
			mascaraDDD.setValueContainsLiteralCharacters(false);
			mascaraNumero.setValueContainsLiteralCharacters(false);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		lblDDD = new JLabel("DDD:");
		lblDDD.setBounds(10, 15, 46, 20);
		frame.getContentPane().add(lblDDD);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(10, 45, 46, 20);
		frame.getContentPane().add(lblNumero);
		
		lblNewLabel = new JLabel("Móvel?");
		lblNewLabel.setBounds(10, 75, 45, 20);
		frame.getContentPane().add(lblNewLabel);
		
		chckbxAtivo = new JCheckBox("Sim");
		chckbxAtivo.setBounds(55, 75, 97, 20);
		frame.getContentPane().add(chckbxAtivo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(99, 105, 105, 20);
		frame.getContentPane().add(btnSalvar);
		
		fTxtDDD = new JFormattedTextField(mascaraDDD);
		fTxtDDD.setBounds(60, 12, 46, 20);
		frame.getContentPane().add(fTxtDDD);
		
		fTxtNumero = new JFormattedTextField(mascaraNumero);
		fTxtNumero.setBounds(60, 45, 144, 20);
		frame.getContentPane().add(fTxtNumero);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Telefone telefone = new Telefone();
				try {
					String dddSemMascara = (String) mascaraDDD.stringToValue(fTxtDDD.getText());
					telefone.setDdd(dddSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null,
							"Erro ao converter o DDD: \n" + e1.getMessage(), 
							"Erro", JOptionPane.WARNING_MESSAGE);
				}
				try {
					String numeroSemMascara = (String) mascaraNumero.stringToValue(fTxtDDD.getText());
					telefone.setNumero(numeroSemMascara);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null,
							"Erro ao converter o Número: \n" + e1.getMessage(), 
							"Erro", JOptionPane.WARNING_MESSAGE);
				}
				if(chckbxAtivo.isSelected()) {
					telefone.setMovel(false);
				}
				
				telefone.setAtivo(false);
				
				TelefoneController controllerTelefone = new TelefoneController();	
				
				controllerTelefone.inserir(telefone);
			}
		});
		
	}
}

package view.telefonia;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class MenuTelefonia {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTelefonia window = new MenuTelefonia();
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public MenuTelefonia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 240, 240));
		menuBar.setForeground(new Color(240, 240, 240));
		frame.setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-usuário-32.png")));
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCadastroCliente painelCadastroCliente = new PainelCadastroCliente(null);
				frame.setContentPane(painelCadastroCliente);
				painelCadastroCliente.setVisible(true);
				frame.revalidate();
			}
		});
		mntmCadastrarCliente.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-adicionar-usuário-masculino-32.png")));
		mntmCadastrarCliente.setBackground(new Color(240, 240, 240));
		mnCliente.add(mntmCadastrarCliente);
		
		JMenuItem mntmEditarCliente = new JMenuItem("Editar Cliente");
		mntmEditarCliente.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-editar-32.png")));
		mnCliente.add(mntmEditarCliente);
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar Cliente(s)");
		mntmListarClientes.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-lista-32.png")));
		mnCliente.add(mntmListarClientes);
		
		JMenu mnEndereco = new JMenu("Endereço");
		mnEndereco.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-endereço-32.png")));
		menuBar.add(mnEndereco);
		
		JMenuItem mntmCadastrarEndereco = new JMenuItem("Cadastrar Endereço");
		mntmCadastrarEndereco.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-endereço-32 (1).png")));
		mnEndereco.add(mntmCadastrarEndereco);
		
		JMenu mnTelefone = new JMenu("Telefone");
		mnTelefone.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-telefone-32.png")));
		menuBar.add(mnTelefone);
		
		JMenuItem mntmCadastrarTelefone = new JMenuItem("Cadastrar Telefone");
		mntmCadastrarTelefone.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-telefone-32 (1).png")));
		mnTelefone.add(mntmCadastrarTelefone);
		
		JMenuItem mntmListarTelefones = new JMenuItem("Listar Telefones");
		mntmListarTelefones.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-lista-32.png")));
		mnTelefone.add(mntmListarTelefones);
		mntmListarTelefones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Evento de clique no botão -> instancia o painel e troca
				PainelListagemTelefone painelListagemTelefone = new PainelListagemTelefone();
				frame.setContentPane(painelListagemTelefone);
				painelListagemTelefone.setVisible(true);
				frame.revalidate();
			}
		});
		
		PainelCadastroCliente painelCadastroCliente = new PainelCadastroCliente(null);
		painelCadastroCliente.getBtnSalvar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PainelListagemCliente painelListagemCliente = new PainelListagemCliente();
				frame.setContentPane(painelListagemCliente);
				painelListagemCliente.setVisible(true);
				frame.revalidate();
			}
			
		});
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Sobre batatas.", "Sobre", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnSobre.setIcon(new ImageIcon(MenuTelefonia.class.getResource("/icones/icons8-sobre-32.png")));
		menuBar.add(mnSobre);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
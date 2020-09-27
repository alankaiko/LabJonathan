package br.tela.principal.tela;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.com.laboratorio.modelo.Usuario;
import br.tela.principal.listeners.BarraStatusListener;
import br.tela.principal.listeners.TelaPrincipalClassicListener;

public class TelaPrincipalClassic extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel tela, panelPrincipal;
	private JMenuBar menuBar;
	private JMenu menuArquivo, menuCadastro, menuRelatorio;
	private JMenuItem arquivoSair, cadastroConvenio, cadastroPaciente, cadastroFuncionario, cadastroUsuario;
	private JMenuItem relatorioConvenio, relatorioPaciente, relatorioFuncionario;
	private JLabel LStatusUsuario, LStatusData, LStatusHora;
	private JPanel panelStatus;
	private TelaPrincipalClassicListener listener;
	private Usuario usuario;
	private BarraStatusListener barra;

	public TelaPrincipalClassic() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipalClassic.class.getResource("/imagens/icons8-treatment-filled-15.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 580);

		tela = new JPanel();
		tela.setBorder(null);
		setContentPane(tela);
		setTitle("Door - Gas v 1.0.0");
		setResizable(false);
		tela.setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.inactiveCaption);
		panelPrincipal.setBounds(0, 0, 884, 552);
		tela.add(panelPrincipal);
		panelPrincipal.setLayout(null);

	}

	public void IniciaComponentesSecundarios() {
		CriaComponentes();
		listener = new TelaPrincipalClassicListener(this);
		barra = new BarraStatusListener(this);
	}

	private void CriaComponentes() {
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 884, 21);
		panelPrincipal.add(menuBar);

		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);

		arquivoSair = new JMenuItem("Sair");
		menuArquivo.add(arquivoSair);

		menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);

		cadastroConvenio = new JMenuItem("Gerenciar Convênios");
		menuCadastro.add(cadastroConvenio);

		cadastroPaciente = new JMenuItem("Gerenciar Pacientes");
		menuCadastro.add(cadastroPaciente);

		cadastroFuncionario = new JMenuItem("Gerenciar Profissional Executante");
		menuCadastro.add(cadastroFuncionario);

		cadastroUsuario = new JMenuItem("Gerenciar Usuários");
		menuCadastro.add(cadastroUsuario);

		menuRelatorio = new JMenu("Relatórios");
		menuBar.add(menuRelatorio);


		relatorioConvenio = new JMenuItem("Relatório de Convênios/Planos");
		menuRelatorio.add(relatorioConvenio);

		relatorioPaciente = new JMenuItem("Relatório de Pacientes");
		menuRelatorio.add(relatorioPaciente);

		relatorioFuncionario = new JMenuItem("Relatório de Funcionários");
		menuRelatorio.add(relatorioFuncionario);

		panelStatus = new JPanel();
		panelStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelStatus.setBounds(0, 531, 884, 21);
		panelPrincipal.add(panelStatus);
		panelStatus.setLayout(null);

		LStatusUsuario = new JLabel("Usuário: ");
		LStatusUsuario.setBounds(10, 0, 282, 21);
		panelStatus.add(LStatusUsuario);

		LStatusData = new JLabel("Data: ");
		LStatusData.setBounds(336, 0, 214, 21);
		panelStatus.add(LStatusData);

		LStatusHora = new JLabel("Hora: ");
		LStatusHora.setBounds(581, 0, 239, 21);
		panelStatus.add(LStatusHora);

	}

	public JLabel getLStatusUsuario() {
		return LStatusUsuario;
	}

	public void setLStatusUsuario(JLabel lStatusUsuario) {
		LStatusUsuario = lStatusUsuario;
	}

	public JLabel getLStatusData() {
		return LStatusData;
	}

	public void setLStatusData(JLabel lStatusData) {
		LStatusData = lStatusData;
	}

	public JLabel getLStatusHora() {
		return LStatusHora;
	}

	public void setLStatusHora(JLabel lStatusHora) {
		LStatusHora = lStatusHora;
	}

	public JMenu getMenuArquivo() {
		return menuArquivo;
	}

	public void setMenuArquivo(JMenu menuArquivo) {
		this.menuArquivo = menuArquivo;
	}

	public JMenu getMenuCadastro() {
		return menuCadastro;
	}

	public void setMenuCadastro(JMenu menuCadastro) {
		this.menuCadastro = menuCadastro;
	}

	public JMenu getMenuRelatorio() {
		return menuRelatorio;
	}

	public void setMenuRelatorio(JMenu menuRelatorio) {
		this.menuRelatorio = menuRelatorio;
	}

	public JMenuItem getArquivoSair() {
		return arquivoSair;
	}
	
	public void setArquivoSair(JMenuItem arquivoSair) {
		this.arquivoSair = arquivoSair;
	}

	public JMenuItem getCadastroConvenio() {
		return cadastroConvenio;
	}

	public void setCadastroConvenio(JMenuItem cadastroConvenio) {
		this.cadastroConvenio = cadastroConvenio;
	}

	public JMenuItem getCadastroPaciente() {
		return cadastroPaciente;
	}

	public void setCadastroPaciente(JMenuItem cadastroPaciente) {
		this.cadastroPaciente = cadastroPaciente;
	}

	public JMenuItem getCadastroFuncionario() {
		return cadastroFuncionario;
	}
	
	public void setCadastroFuncionario(JMenuItem cadastroFuncionario) {
		this.cadastroFuncionario = cadastroFuncionario;
	}

	public JMenuItem getRelatorioFuncionario() {
		return relatorioFuncionario;
	}

	public void setRelatorioFuncionario(JMenuItem relatorioFuncionario) {
		this.relatorioFuncionario = relatorioFuncionario;
	}

	public JMenuItem getRelatorioPaciente() {
		return relatorioPaciente;
	}

	public void setRelatorioPaciente(JMenuItem relatorioPaciente) {
		this.relatorioPaciente = relatorioPaciente;
	}

	public JPanel getTela() {
		return tela;
	}

	public void setTela(JPanel tela) {
		this.tela = tela;
	}

	public JMenuItem getCadastroUsuario() {
		return cadastroUsuario;
	}
	
	public void setCadastroUsuario(JMenuItem cadastroUsuario) {
		this.cadastroUsuario = cadastroUsuario;
	}

	public TelaPrincipalClassicListener getListener() {
		return listener;
	}

	public void setListener(TelaPrincipalClassicListener listener) {
		this.listener = listener;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public JMenuItem getRelatorioConvenio() {
		return relatorioConvenio;
	}

	public void setRelatorioConvenio(JMenuItem relatorioConvenio) {
		this.relatorioConvenio = relatorioConvenio;
	}
}

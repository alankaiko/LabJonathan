package br.com.laboratorio.atela;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.laboratorio.listeners.BarraStatusListener;
import br.com.laboratorio.listeners.TelaPrincipalClassicListener;

public class TelaPrincipalClassic extends JFrame {

	private JPanel tela, panelPrincipal;
	private JMenuBar menuBar;
	private JMenu menuArquivo,menuAtendimento, menuCadastro, menuUsuario, menuFarmacia, menuRelatorio;
	private JMenuItem arquivoAgCli, arquivoConAte, arquivoAcomodacoes, cadastroConvenio;
	private JMenuItem cadastroClinica, cadastroPaciente, relatorioFuncionario, relatorioProntuario;
	private JMenuItem usuarioFuncionario, usuarioConFun, usuarioUser;
	private JMenuItem farmaciaFabricante, farmaciaGruProduto, relatorioClinica;
	private JMenuItem farmaciaProduto, farmaciaDevolucoes, relatorioItens, relatorioFornecedores, relatorioConvenio;
	private JMenuItem relatorioGruItens, relatorioPaciente, atendimentoCadCliente,atendimentoProntuario;
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
		tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tela);
		setTitle("G-Doctor's");
		setResizable(false);
		tela.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBounds(0, 0, 884, 552);
		tela.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		
	}
	
	public void IniciaComponentesSecundarios(){
		CriaComponentes();	
		listener = new TelaPrincipalClassicListener(this);
		barra = new BarraStatusListener(this);
	}
	
	
	private void CriaComponentes(){
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 884, 21);
		panelPrincipal.add(menuBar);
		
		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		arquivoAgCli = new JMenuItem("Agenda Clínica");
		menuArquivo.add(arquivoAgCli);
		
		arquivoConAte = new JMenuItem("Consulta Atendimentos");
		menuArquivo.add(arquivoConAte);
		
		arquivoAcomodacoes = new JMenuItem("Acomodações");
		menuArquivo.add(arquivoAcomodacoes);
		
		menuAtendimento = new JMenu("Atendimento");
		menuBar.add(menuAtendimento);
		
		atendimentoProntuario = new JMenuItem("Gerenciar Prontuários");
		menuAtendimento.add(atendimentoProntuario);
		
		atendimentoCadCliente = new JMenuItem("Incluir Paciente");
		menuAtendimento.add(atendimentoCadCliente);
		
		menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);
		
		cadastroConvenio = new JMenuItem("Gerenciar Convênios");
		menuCadastro.add(cadastroConvenio);
		
		cadastroClinica = new JMenuItem("Gerenciar Clínicas");
		menuCadastro.add(cadastroClinica);
		
		cadastroPaciente = new JMenuItem("Gerenciar Pacientes");
		menuCadastro.add(cadastroPaciente);
		
		menuUsuario = new JMenu("Usuário");
		menuBar.add(menuUsuario);
		
		usuarioFuncionario = new JMenuItem("Cadastro de Funcionários");
		menuUsuario.add(usuarioFuncionario);
		
		usuarioConFun = new JMenuItem("Gerenciar Funcionários");
		menuUsuario.add(usuarioConFun);
		
		usuarioUser = new JMenuItem("Gerenciar Usuários");
		menuUsuario.add(usuarioUser);
		
		menuFarmacia = new JMenu("Farmácia");
		menuBar.add(menuFarmacia);
		
		farmaciaFabricante = new JMenuItem("Cadastro de Fabricantes");
		menuFarmacia.add(farmaciaFabricante);
		
		farmaciaGruProduto = new JMenuItem("Grupo de Produtos");
		menuFarmacia.add(farmaciaGruProduto);
		
		farmaciaProduto = new JMenuItem("Cadastro de Produto");
		menuFarmacia.add(farmaciaProduto);
		
		farmaciaDevolucoes = new JMenuItem("Motivos de Devoluções");
		menuFarmacia.add(farmaciaDevolucoes);
		
		menuRelatorio = new JMenu("Relatórios");
		menuBar.add(menuRelatorio);
		
		relatorioItens = new JMenuItem("Relatório de Itens");
		menuRelatorio.add(relatorioItens);
		
		relatorioConvenio = new JMenuItem("Relatório de Convênios/Planos");
		menuRelatorio.add(relatorioConvenio);
		
		relatorioFornecedores = new JMenuItem("Relatório de Fornecedores");
		menuRelatorio.add(relatorioFornecedores);
		
		relatorioGruItens = new JMenuItem("Relatório de Grupo de Itens");
		menuRelatorio.add(relatorioGruItens);
		
		relatorioPaciente = new JMenuItem("Relatório de Pacientes");
		menuRelatorio.add(relatorioPaciente);
		
		relatorioFuncionario = new JMenuItem("Relatório de Funcionários");
		menuRelatorio.add(relatorioFuncionario);
		
		relatorioClinica = new JMenuItem("Relatório de Clínicas");
		menuRelatorio.add(relatorioClinica);
		
		relatorioProntuario = new JMenuItem("Relatório de Prontuários");
		menuRelatorio.add(relatorioProntuario);
		
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



	public JMenu getMenuAtendimento() {
		return menuAtendimento;
	}



	public void setMenuAtendimento(JMenu menuAtendimento) {
		this.menuAtendimento = menuAtendimento;
	}



	public JMenu getMenuCadastro() {
		return menuCadastro;
	}



	public void setMenuCadastro(JMenu menuCadastro) {
		this.menuCadastro = menuCadastro;
	}



	public JMenu getMenuUsuario() {
		return menuUsuario;
	}



	public void setMenuUsuario(JMenu menuUsuario) {
		this.menuUsuario = menuUsuario;
	}



	public JMenu getMenuFarmacia() {
		return menuFarmacia;
	}



	public void setMenuFarmacia(JMenu menuFarmacia) {
		this.menuFarmacia = menuFarmacia;
	}



	public JMenu getMenuRelatorio() {
		return menuRelatorio;
	}



	public void setMenuRelatorio(JMenu menuRelatorio) {
		this.menuRelatorio = menuRelatorio;
	}




	public JMenuItem getArquivoAgCli() {
		return arquivoAgCli;
	}



	public void setArquivoAgCli(JMenuItem arquivoAgCli) {
		this.arquivoAgCli = arquivoAgCli;
	}



	public JMenuItem getArquivoConAte() {
		return arquivoConAte;
	}



	public void setArquivoConAte(JMenuItem arquivoConAte) {
		this.arquivoConAte = arquivoConAte;
	}



	public JMenuItem getArquivoAcomodacoes() {
		return arquivoAcomodacoes;
	}



	public void setArquivoAcomodacoes(JMenuItem arquivoAcomodacoes) {
		this.arquivoAcomodacoes = arquivoAcomodacoes;
	}



	public JMenuItem getCadastroConvenio() {
		return cadastroConvenio;
	}



	public void setCadastroConvenio(JMenuItem cadastroConvenio) {
		this.cadastroConvenio = cadastroConvenio;
	}



	public JMenuItem getCadastroClinica() {
		return cadastroClinica;
	}



	public void setCadastroClinica(JMenuItem cadastroClinica) {
		this.cadastroClinica = cadastroClinica;
	}



	public JMenuItem getCadastroPaciente() {
		return cadastroPaciente;
	}



	public void setCadastroPaciente(JMenuItem cadastroPaciente) {
		this.cadastroPaciente = cadastroPaciente;
	}




	public JMenuItem getUsuarioFuncionario() {
		return usuarioFuncionario;
	}



	public void setUsuarioFuncionario(JMenuItem usuarioFuncionario) {
		this.usuarioFuncionario = usuarioFuncionario;
	}



	public JMenuItem getUsuarioConFun() {
		return usuarioConFun;
	}



	public void setUsuarioConFun(JMenuItem usuarioConFun) {
		this.usuarioConFun = usuarioConFun;
	}



	public JMenuItem getFarmaciaFabricante() {
		return farmaciaFabricante;
	}



	public void setFarmaciaFabricante(JMenuItem farmaciaFabricante) {
		this.farmaciaFabricante = farmaciaFabricante;
	}



	public JMenuItem getFarmaciaGruProduto() {
		return farmaciaGruProduto;
	}



	public void setFarmaciaGruProduto(JMenuItem farmaciaGruProduto) {
		this.farmaciaGruProduto = farmaciaGruProduto;
	}



	public JMenuItem getFarmaciaProduto() {
		return farmaciaProduto;
	}



	public void setFarmaciaProduto(JMenuItem farmaciaProduto) {
		this.farmaciaProduto = farmaciaProduto;
	}



	public JMenuItem getFarmaciaDevolucoes() {
		return farmaciaDevolucoes;
	}



	public void setFarmaciaDevolucoes(JMenuItem farmaciaDevolucoes) {
		this.farmaciaDevolucoes = farmaciaDevolucoes;
	}



	public JMenuItem getRelatorioFuncionario() {
		return relatorioFuncionario;
	}



	public void setRelatorioFuncionario(JMenuItem relatorioFuncionario) {
		this.relatorioFuncionario = relatorioFuncionario;
	}



	public JMenuItem getRelatorioClinica() {
		return relatorioClinica;
	}



	public void setRelatorioClinica(JMenuItem relatorioClinica) {
		this.relatorioClinica = relatorioClinica;
	}



	public JMenuItem getRelatorioItens() {
		return relatorioItens;
	}



	public void setRelatorioItens(JMenuItem relatorioItens) {
		this.relatorioItens = relatorioItens;
	}



	public JMenuItem getRelatorioFornecedores() {
		return relatorioFornecedores;
	}



	public void setRelatorioFornecedores(JMenuItem relatorioFornecedores) {
		this.relatorioFornecedores = relatorioFornecedores;
	}



	public JMenuItem getRelatorioGruItens() {
		return relatorioGruItens;
	}



	public void setRelatorioGruItens(JMenuItem relatorioGruItens) {
		this.relatorioGruItens = relatorioGruItens;
	}



	public JMenuItem getRelatorioPaciente() {
		return relatorioPaciente;
	}



	public void setRelatorioPaciente(JMenuItem relatorioPaciente) {
		this.relatorioPaciente = relatorioPaciente;
	}


	public JMenuItem getAtendimentoCadCliente() {
		return atendimentoCadCliente;
	}

	public void setAtendimentoCadCliente(JMenuItem atendimentoCadCliente) {
		this.atendimentoCadCliente = atendimentoCadCliente;
	}

	public JMenuItem getAtendimentoProntuario() {
		return atendimentoProntuario;
	}



	public void setAtendimentoProntuario(JMenuItem atendimentoProntuario) {
		this.atendimentoProntuario = atendimentoProntuario;
	}



	public JPanel getTela() {
		return tela;
	}



	public void setTela(JPanel tela) {
		this.tela = tela;
	}



	public JMenuItem getUsuarioUser() {
		return usuarioUser;
	}



	public void setUsuarioUser(JMenuItem usuarioUser) {
		this.usuarioUser = usuarioUser;
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

	public JMenuItem getRelatorioProntuario() {
		return relatorioProntuario;
	}

	public void setRelatorioProntuario(JMenuItem relatorioProntuario) {
		this.relatorioProntuario = relatorioProntuario;
	}

	public JMenuItem getRelatorioConvenio() {
		return relatorioConvenio;
	}

	public void setRelatorioConvenio(JMenuItem relatorioConvenio) {
		this.relatorioConvenio = relatorioConvenio;
	}
}









package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.laboratorio.listeners.IncluirUsuarioListener;
import br.com.laboratorio.util.ConverteDadosUtil;

public class IncluirUsuarioForm extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private Long codigo;
	private JTextField TFuncionario, TCpf, TRg, TLogin;
	private JLabel LFuncionario, LCpf, LRg, LAdicionar, LLogin, LSenha;
	private JPasswordField TSenha;
	private JButton BGravar, BCancelar, BPesquisar;
	private JFormattedTextField JCpf;
	private IncluirUsuarioListener listener;


	public IncluirUsuarioForm() {
		setTitle("Código");
		setModal(true);
		setBounds(100, 100, 516, 330);
		setResizable(false);
		tela.setLayout(null);
		tela.add(panel, BorderLayout.CENTER);

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		DadosUser();
		listener = new IncluirUsuarioListener(this);
	}
	
	public void DadosUser() {
		LFuncionario = new JLabel();
		LFuncionario.setText("Funcionário");
		LFuncionario.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LFuncionario.setBounds(39, 34, 112, 14);
		tela.add(LFuncionario);
		
		TFuncionario = new JTextField();
		TFuncionario.setBorder(new LineBorder(Color.BLACK));
		TFuncionario.setBounds(39, 48, 375, 20);
		TFuncionario.setColumns(10);
		TFuncionario.setEditable(false);
		TFuncionario.setToolTipText("Clique no Botão Pesquisar");
		tela.add(TFuncionario);
		
		LCpf = new JLabel();
		LCpf.setText("CPF");
		LCpf.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LCpf.setBounds(39, 79, 46, 14);
		tela.add(LCpf);
		
		TCpf = new JTextField();
		TCpf.setBorder(new LineBorder(Color.BLACK));
		TCpf.setBounds(40, 93, 229, 20);
		TCpf.setColumns(10);
		TCpf.setEditable(false);
		TCpf.setToolTipText("Clique no Botão Pesquisar");
		tela.add(TCpf);
		JCpf = new JFormattedTextField(ConverteDadosUtil.FormataCPF());
					
		LRg = new JLabel();
		LRg.setText("RG");
		LRg.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LRg.setBounds(293, 79, 46, 14);
		tela.add(LRg);
		
		TRg = new JTextField();
		TRg.setBorder(new LineBorder(Color.BLACK));
		TRg.setBounds(293, 93, 121, 20);
		TRg.setColumns(10);
		TRg.setEditable(false);
		TRg.setToolTipText("Clique no Botão Pesquisar");
		tela.add(TRg);
		
		LAdicionar = new JLabel();
		LAdicionar.setText("Adicionar Login de Usuário");
		LAdicionar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		LAdicionar.setBounds(39, 147, 205, 14);
		tela.add(LAdicionar);
		
		LLogin = new JLabel();
		LLogin.setText("Login");
		LLogin.setBounds(39, 172, 46, 14);
		tela.add(LLogin);
		
		LSenha = new JLabel();
		LSenha.setText("Senha");
		LSenha.setBounds(293, 172, 46, 14);
		tela.add(LSenha);
		
		TLogin = new JTextField();
		TLogin.setBorder(new LineBorder(Color.BLACK));
		TLogin.setBounds(39, 188, 230, 20);
		TLogin.setColumns(10);
		tela.add(TLogin);
		
		
		
		
		
		
		TSenha = new JPasswordField();
		TSenha.setBorder(new LineBorder(Color.BLACK));
		TSenha.setBounds(293, 188, 121, 20);
		tela.add(TSenha);
		
		BGravar = new JButton();
		BGravar.setText("Gravar");
		BGravar.setBounds(142, 256, 100	, 23);
		tela.add(BGravar);
		
		BCancelar = new JButton();
		BCancelar.setText("Cancelar");
		BCancelar.setBounds(252, 256, 100, 23);
		tela.add(BCancelar);
		
		BPesquisar = new JButton();
		BPesquisar.setText("Pesquisar");
		BPesquisar.setIcon(new ImageIcon(IncluirUsuarioForm.class.getResource("/imagens/icons8-pesquisar-15.png")));
		BPesquisar.setBackground(SystemColor.menu);
		BPesquisar.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		BPesquisar.setMargin(new Insets(2, 0, 2, 0));
		BPesquisar.setBorder(null);
		BPesquisar.setBounds(421, 47, 73, 23);
		tela.add(BPesquisar);
	}
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Container getTela() {
		return tela;
	}

	public void setTela(Container tela) {
		this.tela = tela;
	}

	public JTextField getTFuncionario() {
		return TFuncionario;
	}

	public void setTFuncionario(JTextField tFuncionario) {
		TFuncionario = tFuncionario;
	}

	public JTextField getTCpf() {
		return TCpf;
	}

	public void setTCpf(JTextField tCpf) {
		TCpf = tCpf;
	}

	public JTextField getTRg() {
		return TRg;
	}

	public void setTRg(JTextField tRg) {
		TRg = tRg;
	}

	public JTextField getTLogin() {
		return TLogin;
	}

	public void setTLogin(JTextField tLogin) {
		TLogin = tLogin;
	}

	public JLabel getLFuncionario() {
		return LFuncionario;
	}

	public void setLFuncionario(JLabel lFuncionario) {
		LFuncionario = lFuncionario;
	}

	public JLabel getLCpf() {
		return LCpf;
	}

	public void setLCpf(JLabel lCpf) {
		LCpf = lCpf;
	}

	public JLabel getLRg() {
		return LRg;
	}

	public void setLRg(JLabel lRg) {
		LRg = lRg;
	}

	public JLabel getLLogin() {
		return LLogin;
	}

	public void setLLogin(JLabel lLogin) {
		LLogin = lLogin;
	}

	public JLabel getLSenha() {
		return LSenha;
	}

	public void setLSenha(JLabel lSenha) {
		LSenha = lSenha;
	}

	public JPasswordField getTSenha() {
		return TSenha;
	}

	public void setTSenha(JPasswordField tSenha) {
		TSenha = tSenha;
	}

	public JButton getBGravar() {
		return BGravar;
	}

	public void setBGravar(JButton bGravar) {
		BGravar = bGravar;
	}

	public JButton getBCancelar() {
		return BCancelar;
	}

	public void setBCancelar(JButton bCancelar) {
		BCancelar = bCancelar;
	}

	public JButton getBPesquisar() {
		return BPesquisar;
	}

	public void setBPesquisar(JButton bPesquisar) {
		BPesquisar = bPesquisar;
	}

	public JFormattedTextField getJCpf() {
		return JCpf;
	}

	public void setJCpf(JFormattedTextField jCpf) {
		JCpf = jCpf;
	}

	public IncluirUsuarioListener getListener() {
		return listener;
	}

	public void setListener(IncluirUsuarioListener listener) {
		this.listener = listener;
	}

	public JLabel getLAdicionar() {
		return LAdicionar;
	}

	public void setLAdicionar(JLabel lAdicionar) {
		LAdicionar = lAdicionar;
	}
}

package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.laboratorio.listeners.DetalhesUsuarioListener;
import br.com.laboratorio.util.ConverteDadosUtil;

public class DetalhesUsuarioDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JLabel TFuncionario, TCpf, TRg, TLogin;
	private JLabel LFuncionario, LCpf, LRg, LAdicionar, LLogin, LSenha;
	private JPasswordField TSenha;
	private JButton BCancelar;
	private JFormattedTextField JCpf;
	private DetalhesUsuarioListener listener;


	public DetalhesUsuarioDialog() {
		setTitle("Código");
		setModal(true);
		setBounds(100, 100, 516, 330);
		setResizable(false);
		tela.setLayout(null);
		tela.add(panel, BorderLayout.CENTER);

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		DadosUser();
		listener = new DetalhesUsuarioListener(this);
	}
	
	public void DadosUser() {
		LFuncionario = new JLabel();
		LFuncionario.setText("Funcionário");
		LFuncionario.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LFuncionario.setBounds(39, 34, 112, 14);
		tela.add(LFuncionario);
		
		TFuncionario = new JLabel();
		TFuncionario.setBorder(new LineBorder(Color.BLACK));
		TFuncionario.setBounds(39, 48, 375, 20);
		TFuncionario.setToolTipText("Clique no Botão Pesquisar");
		tela.add(TFuncionario);
		
		LCpf = new JLabel();
		LCpf.setText("CPF");
		LCpf.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LCpf.setBounds(39, 79, 46, 14);
		tela.add(LCpf);
		
		TCpf = new JLabel();
		TCpf.setBorder(new LineBorder(Color.BLACK));
		TCpf.setBounds(40, 93, 229, 20);
		TCpf.setToolTipText("Clique no Botão Pesquisar");
		tela.add(TCpf);
		JCpf = new JFormattedTextField(ConverteDadosUtil.FormataCPF());
					
		LRg = new JLabel();
		LRg.setText("RG");
		LRg.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LRg.setBounds(293, 79, 46, 14);
		tela.add(LRg);
		
		TRg = new JLabel();
		TRg.setBorder(new LineBorder(Color.BLACK));
		TRg.setBounds(293, 93, 121, 20);
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
		
		TLogin = new JLabel();
		TLogin.setBorder(new LineBorder(Color.BLACK));
		TLogin.setBounds(39, 188, 230, 20);
		tela.add(TLogin);
	
		TSenha = new JPasswordField();
		TSenha.setBorder(new LineBorder(Color.BLACK));
		TSenha.setBounds(293, 188, 121, 20);
		tela.add(TSenha);
		
		BCancelar = new JButton();
		BCancelar.setText("Cancelar");
		BCancelar.setBounds(252, 256, 100, 23);
		tela.add(BCancelar);
	}

	public JLabel getTFuncionario() {
		return TFuncionario;
	}

	public void setTFuncionario(JLabel tFuncionario) {
		TFuncionario = tFuncionario;
	}

	public JLabel getTCpf() {
		return TCpf;
	}

	public void setTCpf(JLabel tCpf) {
		TCpf = tCpf;
	}

	public JLabel getTRg() {
		return TRg;
	}

	public void setTRg(JLabel tRg) {
		TRg = tRg;
	}

	public JLabel getTLogin() {
		return TLogin;
	}

	public void setTLogin(JLabel tLogin) {
		TLogin = tLogin;
	}

	public JPasswordField getTSenha() {
		return TSenha;
	}

	public void setTSenha(JPasswordField tSenha) {
		TSenha = tSenha;
	}

	public JButton getBCancelar() {
		return BCancelar;
	}

	public void setBCancelar(JButton bCancelar) {
		BCancelar = bCancelar;
	}

	public JFormattedTextField getJCpf() {
		return JCpf;
	}

	public void setJCpf(JFormattedTextField jCpf) {
		JCpf = jCpf;
	}

	public DetalhesUsuarioListener getListener() {
		return listener;
	}

	public void setListener(DetalhesUsuarioListener listener) {
		this.listener = listener;
	}	
}

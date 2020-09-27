package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.DetalhesUsuarioListener;

public class DetalhesUsuarioDialog extends JDialog {
	private DetalhesUsuarioListener listener;
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private Long codigo;
	private JButton BCancelar;
	private JLabel TFuncionario, TCpf, TRg, TLogin;
	private JLabel LFuncionario, LCpf, LRg, LAdicionar, LLogin;
	private JFormattedTextField JCpf;
	
	
	
	
	public DetalhesUsuarioDialog() {
		setTitle("Código");
		setModal(true);
		setBounds(100, 100, 516, 330);
		setResizable(false);
		tela.setLayout(null);
		tela.add(panel, BorderLayout.CENTER);

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		
		Dados();
		listener = new DetalhesUsuarioListener(this);
	}
	
	public void Dados() {
		LFuncionario = new JLabel();
		LFuncionario.setText("Funcionário");
		LFuncionario.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LFuncionario.setBounds(39, 34, 112, 14);
		tela.add(this.LFuncionario);

		TFuncionario = new JLabel();
		TFuncionario.setBounds(39, 48, 375, 20);
		tela.add(this.TFuncionario);

		LCpf = new JLabel();
		LCpf.setText("CPF");
		LCpf.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LCpf.setBounds(39, 79, 46, 14);
		tela.add(this.LCpf);
		
		TCpf = new JLabel();
		TCpf.setBounds(40, 93, 229, 20);
		tela.add(this.TCpf);
				
		LRg = new JLabel();
		LRg.setText("RG");
		LRg.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		LRg.setBounds(293, 79, 46, 14);
		tela.add(this.LRg);

		TRg = new JLabel();
		TRg.setBounds(293, 93, 121, 20);
		tela.add(this.TRg);

		LAdicionar = new JLabel();
		LAdicionar.setText("Detalhe Login");
		LAdicionar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		LAdicionar.setBounds(39, 147, 205, 20);
		tela.add(this.LAdicionar);
		
		LLogin = new JLabel();
		LLogin.setText("Login");
		LLogin.setBounds(39, 172, 46, 14);
		tela.add(this.LLogin);

		TLogin = new JLabel();
		TLogin.setBounds(39, 188, 230, 20);
		tela.add(this.TLogin);
		
		BCancelar = new JButton();
		BCancelar.setText("Cancelar");
		BCancelar.setFont(new Font("Calibri", Font.PLAIN, 12));
		BCancelar.setBounds(208, 268, 89, 23);
		tela.add(this.BCancelar);
	}
	

	
	public Container getTela() {
		return tela;
	}

	public void setTela(Container tela) {
		this.tela = tela;
	}

	public JFormattedTextField getJCpf() {
		return JCpf;
	}

	public void setJCpf(JFormattedTextField jCpf) {
		JCpf = jCpf;
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getTFuncionario() {
		return TFuncionario;
	}

	public void setTFuncionario(JLabel tFuncionario) {
		TFuncionario = tFuncionario;
	}

	public JLabel getTLogin() {
		return TLogin;
	}

	public void setTLogin(JLabel tLogin) {
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

	public JLabel getLAdicionar() {
		return LAdicionar;
	}

	public void setLAdicionar(JLabel lAdicionar) {
		LAdicionar = lAdicionar;
	}

	public JLabel getLLogin() {
		return LLogin;
	}

	public void setLLogin(JLabel lLogin) {
		LLogin = lLogin;
	}

	public JButton getBCancelar() {
		return BCancelar;
	}

	public void setBCancelar(JButton bCancelar) {
		BCancelar = bCancelar;
	}

	public DetalhesUsuarioListener getListener() {
		return listener;
	}

	public void setListener(DetalhesUsuarioListener listener) {
		this.listener = listener;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



}

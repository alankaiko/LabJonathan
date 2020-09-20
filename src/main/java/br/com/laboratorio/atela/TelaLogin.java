package br.com.laboratorio.atela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.laboratorio.listeners.TelaLoginListener;

public class TelaLogin extends JFrame{

	private JPanel PainelPrincipal, PainelLogo;
	private JTextField campoTexto;
	private JLabel labelGas, usuario, senha, botaoFechar;
	private JButton botaoEntrar;
	private JPasswordField campoSenha;
	private TelaLoginListener listener;
	private JPanel painelDrag;
	private int xx,xy;
	

	public TelaLogin() {
		CriaTela();
		CriaComponentes();
		listener = new TelaLoginListener(this);
	}

	
	private void CriaTela() {
		setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		this.setLocationRelativeTo(null);
		PainelPrincipal = new JPanel();
		PainelPrincipal.setBackground(Color.WHITE);
		PainelPrincipal.setBorder(new LineBorder(new Color(71,120,197)));
		setContentPane(PainelPrincipal);
		PainelPrincipal.setLayout(null);
	}

	private void CriaComponentes() {
		PainelLogo = new JPanel();
		PainelLogo.setBackground(new Color(71,120,197));
		PainelLogo.setBounds(0, 0, 233, 300);
		PainelPrincipal.add(PainelLogo);
		PainelLogo.setLayout(null);

		labelGas = new JLabel("Gestão Hospitalar");
		labelGas.setForeground(Color.WHITE);
		labelGas.setFont(new Font("Utsaah", Font.PLAIN, 35));
		labelGas.setBounds(10, 26, 213, 35);
		PainelLogo.add(labelGas);
		
		

		botaoEntrar = new JButton("Entrar");
		botaoEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		botaoEntrar.setForeground(Color.WHITE);
		botaoEntrar.setBackground(Color.DARK_GRAY);
		botaoEntrar.setBounds(239, 219, 215, 22);
		PainelPrincipal.add(botaoEntrar);

		campoTexto = new JTextField();
		campoTexto.setBorder(new LineBorder(Color.DARK_GRAY));
		campoTexto.setBounds(243, 69, 211, 20);
		PainelPrincipal.add(campoTexto);
		campoTexto.setColumns(10);

		campoSenha = new JPasswordField();
		campoSenha.setBorder(new LineBorder(Color.DARK_GRAY));
		campoSenha.setBounds(243, 137, 209, 20);
		PainelPrincipal.add(campoSenha);
		campoSenha.setColumns(10);
		
		

		usuario = new JLabel("USU\u00C1RIO");
		usuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		usuario.setBounds(243, 44, 88, 14);
		PainelPrincipal.add(usuario);

		senha = new JLabel("SENHA");
		senha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		senha.setBounds(243, 112, 58, 14);
		PainelPrincipal.add(senha);

		botaoFechar = new JLabel();
		botaoFechar.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/icons8-fechar-janela-filled-20.png")));
		botaoFechar.setBounds(452, 0, 26, 31);
		PainelPrincipal.add(botaoFechar);
		
		painelDrag = new JPanel();
		painelDrag.setBackground(Color.WHITE);
		painelDrag.setBounds(1, 1, 477, 25);
		PainelPrincipal.add(painelDrag);
		
	}

	
	
	
	public JTextField getCampoTexto() {
		return campoTexto;
	}

	public void setCampoTexto(JTextField campoTexto) {
		this.campoTexto = campoTexto;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

	public JLabel getSenha() {
		return senha;
	}

	public void setSenha(JLabel senha) {
		this.senha = senha;
	}

	public JLabel getBotaoFechar() {
		return botaoFechar;
	}

	public void setBotaoFechar(JLabel botaoFechar) {
		this.botaoFechar = botaoFechar;
	}

	public JButton getBotaoEntrar() {
		return botaoEntrar;
	}

	public void setBotaoEntrar(JButton botaoEntrar) {
		this.botaoEntrar = botaoEntrar;
	}


	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}

	public JPanel getPainelDrag() {
		return painelDrag;
	}

	public void setPainelDrag(JPanel painelDrag) {
		this.painelDrag = painelDrag;
	}
	public int getXx() {
		return xx;
	}

	public void setXx(int xx) {
		this.xx = xx;
	}
	
	public int getXy() {
		return xy;
	}

	public void setXy(int xy) {
		this.xy = xy;
	}


	
}

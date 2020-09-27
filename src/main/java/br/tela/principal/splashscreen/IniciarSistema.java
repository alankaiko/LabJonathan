package br.tela.principal.splashscreen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class IniciarSistema extends JFrame {

	private JPanel panel;
	public JProgressBar barra;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSistema frame = new IniciarSistema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public IniciarSistema() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		panel = new JPanel();
		panel.setBackground(new Color(58,135,242));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		barra = new JProgressBar();
		barra.setBorder(new LineBorder(new Color(201,203,242)));
		barra.setBackground(new Color(58,135,242));
		barra.setForeground(new Color(201,203,242));
		barra.setBounds(40, 237, 360, 30);
		panel.add(barra);
		
		JLabel lblIniciandoSistema = new JLabel("Iniciando Sistema");
		lblIniciandoSistema.setForeground(new Color(201,203,242));
		lblIniciandoSistema.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblIniciandoSistema.setBounds(10, 11, 206, 34);
		panel.add(lblIniciandoSistema);
		
		JLabel lblCarregandoBanco = new JLabel("Carregando Banco...");
		lblCarregandoBanco.setForeground(Color.WHITE);
		lblCarregandoBanco.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		lblCarregandoBanco.setBounds(40, 217, 115, 14);
		panel.add(lblCarregandoBanco);
		
		JLabel gdoctor = new JLabel("Laboratório");
		gdoctor.setForeground(Color.WHITE);
		gdoctor.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 28));
		gdoctor.setBounds(100, 129, 241, 34);
		panel.add(gdoctor);
		
		JLabel lblBeta = new JLabel("Beta");
		lblBeta.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblBeta.setForeground(Color.WHITE);
		lblBeta.setBounds(305, 167, 31, 14);
		panel.add(lblBeta);
		
		Carregar();
	}
	
	private void Carregar(){
		barra.setIndeterminate(true);
		
		CarregaBanco carregando = new CarregaBanco(this);
		carregando.execute();
		
		this.setVisible(true);
	}
}
















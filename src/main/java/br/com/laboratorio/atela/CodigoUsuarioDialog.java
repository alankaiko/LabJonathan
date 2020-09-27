package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.laboratorio.listeners.CodigoUsuarioListener;

public class CodigoUsuarioDialog extends JDialog {
	private JPanel panel = new JPanel();
	private JButton ok, cancelar;
	private Container tela = getContentPane();
	private JTextField TBuscar;
	private CodigoUsuarioListener listener;
	private String login;
	

	public CodigoUsuarioDialog() {
		setTitle("Buscar Login");
		setModal(true);
		setBounds(100, 100, 281, 124);
		setResizable(false);
		tela.setLayout(null);
		tela.add(panel, BorderLayout.CENTER);

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		CriaTela();
		listener = new CodigoUsuarioListener(this);
	}
	
	public void CriaTela() {
		TBuscar = new JTextField();
		TBuscar.setBorder(new LineBorder(Color.BLACK));
		TBuscar.setBounds(50, 13, 171, 23);
		TBuscar.setFont(new Font("Arial", Font.BOLD, 10));
		tela.add(this.TBuscar);

		ok = new JButton();
		ok.setText("Buscar");
		ok.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		ok.setBounds(41, 67, 85, 18);
		tela.add(this.ok);

		cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cancelar.setBounds(136, 67, 85, 18);	
		tela.add(this.cancelar);
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JTextField getTBuscar() {
		return TBuscar;
	}

	public void setTBuscar(JTextField tBuscar) {
		TBuscar = tBuscar;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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


	
}

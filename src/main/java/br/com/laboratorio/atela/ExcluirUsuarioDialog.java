package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.ExcluirUsuarioListener;
import br.com.laboratorio.modelo.Usuario;

public class ExcluirUsuarioDialog extends JDialog{
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JButton ok, cancelar;
	private JLabel excluir;
	private JSeparator separa;
	private Usuario usuario;
	private ExcluirUsuarioListener listener;
	
	
	public ExcluirUsuarioDialog(Usuario usuario) {
		setBounds(100, 100,320, 100);
		tela.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tela.add(panel, BorderLayout.CENTER);
		
		setTitle("Excluir Paciente");
		setModal(true);
		setResizable(false);
		tela.setLayout(null);		
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.usuario = usuario;
		DefineComponentes();
		listener = new ExcluirUsuarioListener(this);
	}

	public void DefineComponentes(){
		excluir = new JLabel();
		excluir.setText("Excluir: "+ usuario.getLogin() +" ?");
		excluir.setForeground(Color.black);
		excluir.setBounds(10, 10, 300, 18);
		tela.add(this.excluir);
			
		ok = new JButton();
		ok.setText("OK");
		ok.setBounds(45, 50, 90, 18);
		tela.add(this.ok);
			
		cancelar = new JButton();
		cancelar.setText("cancelar");
		cancelar.setBounds(140, 50, 90, 18);	
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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





	public JLabel getExcluir() {
		return excluir;
	}





	public void setExcluir(JLabel excluir) {
		this.excluir = excluir;
	}


	public JSeparator getSepara() {
		return separa;
	}


	public void setSepara(JSeparator separa) {
		this.separa = separa;
	}
	
}

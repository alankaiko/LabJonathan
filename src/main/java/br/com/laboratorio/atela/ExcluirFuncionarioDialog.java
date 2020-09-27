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

import br.com.laboratorio.listeners.ExcluirFuncionarioListener;
import br.com.laboratorio.modelo.Funcionario;

public class ExcluirFuncionarioDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JButton ok, cancelar;
	private JLabel excluir;
	private JSeparator separa;
	private Funcionario funcionario;
	private ExcluirFuncionarioListener listener;
	
	
	public ExcluirFuncionarioDialog(Funcionario funcionario) {
		setBounds(100, 100,320, 100);
		tela.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tela.add(panel, BorderLayout.CENTER);
		
		setTitle("Excluir Funcionário");
		setModal(true);
		setResizable(false);
		tela.setLayout(null);		
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.funcionario = funcionario;
		
		DefineComponentes();
		listener = new ExcluirFuncionarioListener(this);
	}
	
	public void DefineComponentes(){
		excluir = new JLabel();
		excluir.setText("Excluir: "+ funcionario.getNome() +" ?");
		excluir.setForeground(Color.black);
		excluir.setBounds(10, 10, 300, 18);
		tela.add(this.excluir);
		
		ok = new JButton();
		getRootPane().setDefaultButton(ok); 
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
	
	public Funcionario getFuncionario() {
		return funcionario;
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


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void setSepara(JSeparator separa) {
		this.separa = separa;
	}
	
	public JSeparator getSepara() {
		return separa;
	}
	
}

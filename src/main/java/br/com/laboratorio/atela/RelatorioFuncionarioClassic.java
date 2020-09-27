package br.com.laboratorio.atela;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.com.laboratorio.listeners.RelatorioFuncionarioListener;

public class RelatorioFuncionarioClassic extends JDialog {
	private JPanel panel = new JPanel();
	private JRadioButton radioFuncionario, radioRegCoren;
	private JButton BTGerar, BTCancelar;
	private ButtonGroup grupo;
	private RelatorioFuncionarioListener listener;
	
	public RelatorioFuncionarioClassic() {
		setBounds(100, 100, 382, 131);
		getContentPane().setLayout(null);
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 371, 93);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		CriaComponentes();
		IniciaComponentes();
		listener = new RelatorioFuncionarioListener(this);
	}
	
	private void CriaComponentes(){
		grupo = new ButtonGroup();
		radioFuncionario = new JRadioButton("Relação de Funcionários");
		radioFuncionario.setBackground(Color.WHITE);
		radioFuncionario.setBounds(6, 23, 180, 23);
		grupo.add(radioFuncionario);
		
		radioRegCoren = new JRadioButton("Relação por Registro Coren");
		radioRegCoren.setBackground(Color.WHITE);
		radioRegCoren.setBounds(168, 23, 197, 23);
		grupo.add(radioRegCoren);
		
		BTGerar = new JButton("Gerar");
		BTGerar.setBounds(79, 53, 101, 23);
		
		BTCancelar = new JButton("Cancelar");
		BTCancelar.setBounds(190, 53, 101, 23);
	}
	
	private void IniciaComponentes(){
		panel.add(radioFuncionario);
		panel.add(radioRegCoren);		
		panel.add(BTGerar);
		panel.add(BTCancelar);
	}

	
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JRadioButton getRadioFuncionario() {
		return radioFuncionario;
	}

	public void setRadioFuncionario(JRadioButton radioFuncionario) {
		this.radioFuncionario = radioFuncionario;
	}

	public JRadioButton getRadioRegCoren() {
		return radioRegCoren;
	}

	public void setRadioRegCoren(JRadioButton radioRegCoren) {
		this.radioRegCoren = radioRegCoren;
	}

	public JButton getBTGerar() {
		return BTGerar;
	}

	public void setBTGerar(JButton bTGerar) {
		BTGerar = bTGerar;
	}

	public JButton getBTCancelar() {
		return BTCancelar;
	}

	public void setBTCancelar(JButton bTCancelar) {
		BTCancelar = bTCancelar;
	}
	
}

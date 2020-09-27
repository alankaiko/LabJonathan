package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.DetalhesConvenioListener;

public class DetalhesConvenioDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JLabel LId, LConvenio;
	private JLabel TId, TConvenio;
	private JButton cancelar;
	private DetalhesConvenioListener listener;
	

	public DetalhesConvenioDialog() {
		setTitle("Dados de Convenio ");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 323, 174);
		
		tela.setLayout(null);		
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		CriaTela();
		listener = new DetalhesConvenioListener(this);
	}
	
	public void CriaTela() {
		LId = new JLabel();
		LId.setText("Código");
		LId.setBounds(37, 30, 50, 20);
		LId.setFont(new Font("Arial", Font.BOLD, 11));
		tela.add(this.LId);
			
		TId = new JLabel();
		TId.setBounds(83, 31, 84, 20);
		TId.setBackground(new Color(255, 255, 204));
		TId.setFont(new Font("Arial", Font.BOLD, 10));
		TId.setForeground(Color.black);
		tela.add(this.TId);

		LConvenio = new JLabel();
		LConvenio.setText("Convênio ");
		LConvenio.setBounds(22, 62, 97, 20);
		LConvenio.setFont(new Font("Arial", Font.BOLD, 11));
		tela.add(this.LConvenio );
		
		TConvenio = new JLabel();
		TConvenio.setBounds(83, 63, 239, 19);
		TConvenio.setFont(new Font("Arial", Font.BOLD, 10));
		tela.add(this.TConvenio);
					
		cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setFont(new Font("Calibri", Font.PLAIN, 12));
		cancelar.setBounds(123, 107, 89, 23);		
		tela.add(this.cancelar);	
	}
	
		

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public Container getTela() {
		return tela;
	}

	public void setTela(Container tela) {
		this.tela = tela;
	}

	public JLabel getTId() {
		return TId;
	}

	public void setTId(JLabel tId) {
		TId = tId;
	}

	public JLabel getLConvenio() {
		return LConvenio;
	}

	public void setLConvenio(JLabel lConvenio) {
		LConvenio = lConvenio;
	}

	public JLabel getTConvenio() {
		return TConvenio;
	}

	public void setTConvenio(JLabel tConvenio) {
		TConvenio = tConvenio;
	}

	public DetalhesConvenioListener getListener() {
		return listener;
	}
	
	public void setListener(DetalhesConvenioListener listener) {
		this.listener = listener;
	}

	public JLabel getLId() {
		return LId;
	}

	public void setLId(JLabel lId) {
		LId = lId;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	
}

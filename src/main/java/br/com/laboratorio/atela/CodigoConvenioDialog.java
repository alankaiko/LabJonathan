package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.CodigoConvenioListener;

public class CodigoConvenioDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela= getContentPane();
	private JButton ok, cancelar;
	private JTextField TBuscar;
	private CodigoConvenioListener listener;
	private Long codigo;

	
	
	public CodigoConvenioDialog() {
		setTitle("Código");
		setModal(true);
		setBounds(100, 100, 200, 120);
		setResizable(false);
		tela.setLayout(null);
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		CriaComponentes();
		listener = new CodigoConvenioListener(this);	
	}	
	
	public void CriaComponentes() {
		TBuscar = new JTextField();
		TBuscar.setBounds(50,13,100,23);
		TBuscar.setFont(new Font("Arial",Font.BOLD,10));
		tela.add(this.TBuscar);
		
		ok = new JButton();
		ok.setText("Buscar");
		ok.setBounds(7, 60, 85, 18);
		tela.add(this.ok);
		
		cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setBounds(102, 60, 85, 18);
		tela.add(this.cancelar);
		
	}
	


	public JPanel getPanel() {
		return panel;
	}



	public void setPanel(JPanel panel) {
		this.panel = panel;
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



	public Container getTela() {
		return tela;
	}



	public void setTela(Container tela) {
		this.tela = tela;
	}



	public JTextField getTBuscar() {
		return TBuscar;
	}



	public void setTBuscar(JTextField tBuscar) {
		TBuscar = tBuscar;
	}



	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


}

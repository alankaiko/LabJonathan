package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.DetalhesConvenioDialog;
import br.com.laboratorio.modelo.Convenio;

public class DetalhesConvenioListener implements ActionListener{
	private Convenio convenio;
	private DetalhesConvenioDialog formulario;

	
	public DetalhesConvenioListener(DetalhesConvenioDialog formulario) {
		this.formulario = formulario;
		AdicionarListener();
		TeclaEsc();
	}

	
	public void AdicionarListener(){
		this.formulario.getCancelar().addActionListener(this);
	}
	
	
	
	public void Detalhar(){
		this.formulario.getTId().setText(String.valueOf(this.convenio.getCodigo()));
		this.formulario.getTConvenio().setText(this.convenio.getNome());
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.formulario.getCancelar())){
			this.formulario.dispose();
		}
	}
	
	
	
	public void TeclaEsc(){
        JRootPane meurootpane = this.formulario.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            public void actionPerformed(ActionEvent e) {  
            	formulario.dispose();  
            }  
        });  
    } 

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public Convenio getConvenio() {
		return convenio;
	}
}

package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.CodigoFuncionarioDialog;

public class CodigoFuncionarioListener implements ActionListener{
	private CodigoFuncionarioDialog formulario;
	
	public CodigoFuncionarioListener(CodigoFuncionarioDialog formulario) {
		this.formulario = formulario;
		AdicionaComponentes();
		UsandoTAB();
		TeclaEsc();
	}
	
	
	
	private void AdicionaComponentes(){
		formulario.getOk().addActionListener(this);
		formulario.getCancelar().addActionListener(this);
	}


	
	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getOk());
		this.formulario.getOk().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getOk().doClick();  
                }  
            }  
        });
		
		this.formulario.getCancelar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getCancelar().doClick();  
                }  
            }  
        });

	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.formulario.getOk())){
			this.formulario.setCodigo(Long.parseLong(this.formulario.getTBuscar().getText()));
			this.formulario.dispose();
		}
		if(event.getSource().equals(this.formulario.getCancelar())){
			this.formulario.dispose();
		};
		
		
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
	
	
	
	
	
	
	
	
	
	
	
}

package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.DetalhesUsuarioDialog;
import br.com.laboratorio.modelo.Usuario;

public class DetalhesUsuarioListener implements ActionListener{
	private Usuario usuario;
	private DetalhesUsuarioDialog formulario;

	
	public DetalhesUsuarioListener(DetalhesUsuarioDialog formulario) {
		this.formulario = formulario;
		AdicionarListener();
		UsandoTAB();
		TeclaEsc();
	}

	
	public void AdicionarListener(){
		this.formulario.getBCancelar().addActionListener(this);
	}
	
	
	
	public void Detalhar(){
		this.formulario.getTFuncionario().setText(this.usuario.getFuncionario().getNome());
		this.formulario.getTCpf().setText(this.usuario.getFuncionario().getCpf());
		this.formulario.getTRg().setText(this.usuario.getFuncionario().getRg());
		this.formulario.getTLogin().setText(this.usuario.getLogin());
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.formulario.getBCancelar())){
			this.formulario.dispose();
		}
	}
	
	
	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getBCancelar());
		this.formulario.getBCancelar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBCancelar().doClick();  
                }  
            }  
        });
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 


	
}

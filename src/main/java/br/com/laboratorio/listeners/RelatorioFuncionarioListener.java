package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.RelatorioFuncionarioClassic;
import br.com.laboratorio.relatorios.RelatorioFuncionario;
import br.com.laboratorio.relatorios.RelatorioFuncionarioRegistro;

import com.itextpdf.text.DocumentException;

public class RelatorioFuncionarioListener implements ActionListener{
	private RelatorioFuncionarioClassic formulario;
	
	public RelatorioFuncionarioListener(RelatorioFuncionarioClassic formulario) {
		this.formulario = formulario;
		AdicionaComponentes();
		UsandoTAB();
		TeclaEsc();
	}
	
	
	
	private void AdicionaComponentes(){
		formulario.getBTGerar().addActionListener(this);
		formulario.getBTCancelar().addActionListener(this);
	}


	
	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getBTGerar());
		this.formulario.getBTGerar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBTGerar().doClick();  
                }  
            }  
        });
		
		this.formulario.getBTCancelar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBTCancelar().doClick();  
                }  
            }  
        });

	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.formulario.getBTGerar())){
			if(this.formulario.getRadioFuncionario().isSelected())
				RelatorioFun();
			
			if(this.formulario.getRadioRegCoren().isSelected())
				RelatorioRegFun();
			
			this.formulario.dispose();
		}
		
		if(event.getSource().equals(this.formulario.getBTCancelar())){
			this.formulario.dispose();
		}
	}
	
	
	private void RelatorioFun(){
		try {
			RelatorioFuncionario relFun = new RelatorioFuncionario();
			relFun.Iniciar();
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private void RelatorioRegFun(){
		try {
			RelatorioFuncionarioRegistro relFun = new RelatorioFuncionarioRegistro();
			relFun.Iniciar();
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
}

package br.com.laboratorio.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import br.com.laboratorio.atela.BuscarFuncionarioDialog;
import br.com.laboratorio.util.SomenteNumerosUtil;

public class RadioListenerFuncionario implements ItemListener{
	private BuscarFuncionarioDialog formulario;
	private SomenteNumerosUtil soNumeros;
	
	
	public RadioListenerFuncionario(BuscarFuncionarioDialog formulario) {
		this.formulario = formulario;
		AdicionaListener();
		soNumeros = new SomenteNumerosUtil();		
	}
	
	private void AdicionaListener(){
		this.formulario.getBuscaCodigo().addItemListener(this);
		this.formulario.getBuscaNome().addItemListener(this);
		this.formulario.getBuscaCpf().addItemListener(this);
		this.formulario.getBuscaRg().addItemListener(this);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent event) {
		if(this.formulario.getBuscaCodigo().isSelected()){
			this.formulario.getTextoBuscar().setText("");
			SomenteNumeros();
		}
		if(this.formulario.getBuscaNome().isSelected()){
			this.formulario.getTextoBuscar().setText("");
			TextoEmGeral();
		}
		if(this.formulario.getBuscaCpf().isSelected()){
			this.formulario.getTextoBuscar().setText("");
			SomenteNumeros();
		}
		if(this.formulario.getBuscaRg().isSelected()){
			this.formulario.getTextoBuscar().setText("");
			SomenteNumeros();
		}
		
	}
	
	
	private void SomenteNumeros(){
		formulario.getTextoBuscar().addKeyListener(soNumeros);
	}
	
	private void TextoEmGeral(){
		formulario.getTextoBuscar().removeKeyListener(soNumeros);
	}

}

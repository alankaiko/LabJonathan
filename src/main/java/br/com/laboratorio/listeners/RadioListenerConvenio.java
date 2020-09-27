package br.com.laboratorio.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import br.com.laboratorio.atela.BuscarConvenioDialog;
import br.com.laboratorio.util.SomenteNumerosUtil;

public class RadioListenerConvenio implements ItemListener{
	private BuscarConvenioDialog formulario;
	private SomenteNumerosUtil soNumeros;
	
	
	public RadioListenerConvenio(BuscarConvenioDialog formulario) {
		this.formulario = formulario;
		AdicionaListener();
		soNumeros = new SomenteNumerosUtil();		
	}
	
	private void AdicionaListener(){
		this.formulario.getBuscaId().addItemListener(this);
		this.formulario.getBuscaNome().addItemListener(this);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent event) {
		if(this.formulario.getBuscaId().isSelected()){
			this.formulario.getTextoBuscar().setText("");
			SomenteNumeros();
		}
		if(this.formulario.getBuscaNome().isSelected()){
			this.formulario.getTextoBuscar().setText("");
			TextoEmGeral();
		}
		
	}
	
	
	private void SomenteNumeros(){
		formulario.getTextoBuscar().addKeyListener(soNumeros);
	}
	
	private void TextoEmGeral(){
		formulario.getTextoBuscar().removeKeyListener(soNumeros);
	}

}

package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.laboratorio.atela.CadastroPacienteTela;

public class PacienteListener implements ActionListener {
	private CadastroPacienteTela tela;
	
	public PacienteListener(CadastroPacienteTela tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
	}

}

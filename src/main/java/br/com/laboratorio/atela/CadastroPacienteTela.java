package br.com.laboratorio.atela;

import javax.swing.JDialog;

import br.com.laboratorio.listeners.PacienteListener;
import br.com.laboratorio.service.PacienteService;

public class CadastroPacienteTela extends JDialog {
	private PacienteListener listener;
	
	public CadastroPacienteTela() {
		this.listener = new PacienteListener(this);
		PacienteService service = new PacienteService();
		service.Listar();
	}
}

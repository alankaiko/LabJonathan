package br.com.laboratorio.service;

import java.util.List;

import br.com.laboratorio.modelo.Convenio;
import br.com.laboratorio.modelo.Paciente;
import br.com.laboratorio.repository.PacienteRepository;

public class PacienteService {
	private PacienteRepository repositorio = new PacienteRepository();

	
	public void Salvar(Paciente paciente){
		this.repositorio.Guardar(paciente);
	}
	
	public void Remover(Paciente paciente){
		this.repositorio.Remover(paciente);
	}
	
	public List<Paciente> ListandoPacientes(){
		return repositorio.ListarPacientes();
	}
	
	public Long VerificaQtd(){
		return this.repositorio.VerificaQTDRegistro();
	}
	
	public Paciente BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Paciente> BuscandoPeloNome(String nome){
		return this.repositorio.BuscarPeloNome(nome);
	}
	
	//Acessa o método Service do Objeto Fabricante para retornar uma lista completa de todos os Fabricantes
	public List<Convenio> ConvenioListaCompleta(){
		ConvenioService serviceFab = new ConvenioService();
		return serviceFab.ListandoConvenios();
	}
}

package br.com.laboratorio.service;

import java.util.List;

import br.com.laboratorio.modelo.Paciente;
import br.com.laboratorio.repositoy.PacienteRepository;

public class PacienteService {
	private PacienteRepository dao;
	
	public PacienteService() {
		this.dao = new PacienteRepository();
	}
	
	public List<Paciente> Listar() {
		return this.dao.ListarPacientes();
	}
	
	public void Criar (Paciente paciente) {
		this.dao.Guardar(paciente);
	}
	
	public void Deletar (Paciente paciente) {
		this.dao.Remover(paciente);
	}
	
	public Paciente BuscandoPeloCodigo(Long codigo) {
		return this.dao.BuscarPorId(codigo);
	}
	
	public List<Paciente> ListarPorNomes(String nome) {
		return this.dao.BuscarPeloNome(nome);
	}
	
	public String BuscarPeloCpf(String cpf) {
		return this.dao.BuscarPorCpf(cpf);
	}
	
	public Paciente BuscarPorNomeUnico(String nome) {
		return this.dao.BuscarPorNomeUnico(nome);
	}
}

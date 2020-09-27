package br.com.laboratorio.service;

import java.util.List;

import br.com.laboratorio.modelo.Convenio;
import br.com.laboratorio.repository.ConvenioRepository;

public class ConvenioService {
	private ConvenioRepository repositorio = new ConvenioRepository();

	
	public void Salvar(Convenio convenio){
		this.repositorio.Guardar(convenio);
	}
	
	public void Remover(Convenio convenio){
		this.repositorio.Remover(convenio);
	}
	
	public List<Convenio> ListandoConvenios(){
		return repositorio.ListarConvenio();
	}
	
	public Convenio BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Convenio> BuscandoPeloNome(String nome){
		return this.repositorio.BuscarPeloNome(nome);
	}
	

}

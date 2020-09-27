package br.com.laboratorio.service;

import java.util.List;

import br.com.laboratorio.modelo.Usuario;
import br.com.laboratorio.repository.UsuarioRepository;

public class UsuarioService {
	private UsuarioRepository repositorio = new UsuarioRepository();

	
	public void Salvar(Usuario usuario){
		this.repositorio.Guardar(usuario);
	}
	
	public void Remover(Usuario usuario){
		this.repositorio.Remover(usuario);
	}
	
	public List<Usuario> ListandoUsuarios(){
		return this.repositorio.ListarUsuario();
	}
	
	public Usuario Autenticando(String login, String senha){
		return this.repositorio.Autenticar(login, senha);
	}
	
	public Usuario BuscandoPeloLogin(String login){
		return this.repositorio.BuscarPeloLogin(login);
	}
	
	public List<Usuario> ListandoPorNome(String nome){
		return repositorio.BuscarPeloNome(nome);
	}
	

}

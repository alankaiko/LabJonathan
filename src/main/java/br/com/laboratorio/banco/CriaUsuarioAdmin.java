package br.com.laboratorio.banco;

import br.com.laboratorio.modelo.Contato;
import br.com.laboratorio.modelo.Endereco;
import br.com.laboratorio.modelo.Funcionario;
import br.com.laboratorio.modelo.RegistroCoren;
import br.com.laboratorio.modelo.Usuario;
import br.com.laboratorio.service.UsuarioService;

public class CriaUsuarioAdmin {
	private Usuario usuario;
	private Funcionario funcionario;
	private UsuarioService service;
	private Contato contato;
	private Endereco endereco;
	private RegistroCoren coren;
	
	public CriaUsuarioAdmin() {
		service = new UsuarioService();
		contato = new Contato();
		endereco = new Endereco();
		coren = new RegistroCoren();
		usuario = new Usuario();
		
		FormToFuncionario();
		AtrelarObjetos();
		FormToUsuario();
		Gravar();
	}

	
	
	private void FormToFuncionario(){
		funcionario = new Funcionario();
		funcionario.setNome("Admin");
		funcionario.setCpf("00000000000");
		funcionario.setRg("0000000");
	}
	
	
	private void FormToUsuario(){
		usuario.setLogin("admin");
		usuario.setSenha("123");
		usuario.setFuncionario(funcionario);
	}
	
	
	
	private void AtrelarObjetos(){
		this.funcionario.setRegistroCoren(this.coren);
		this.funcionario.setContato(this.contato);
		this.funcionario.setEndereco(this.endereco);		
	}	

	private void Gravar(){
		service.Salvar(this.usuario);
	}
}

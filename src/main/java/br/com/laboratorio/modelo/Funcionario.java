package br.com.laboratorio.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario order by codigo"),
	@NamedQuery(name = "Funcionario.buscarPorId", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.codigo= :codigo"),
	@NamedQuery(name = "Funcionario.buscarPeloNome", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.nome LIKE :nome"),
	@NamedQuery(name = "Funcionario.buscarCrm", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.registroCoren.coren= :coren")
})
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private String cpf;
	private String rg;
	private Contato contato;
	private Endereco endereco;
	private RegistroCoren registroCoren;

	public Funcionario() {
		nome = new String();
		cpf = new String();
		rg = new String();
		contato = new Contato();
		endereco = new Endereco();
		registroCoren = new RegistroCoren();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(nullable = false, unique = true, length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, unique = true, length = 15)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_contato_id", referencedColumnName = "codigo")
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_endereco_id", referencedColumnName = "codigo")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_registrocoren_id", referencedColumnName = "codigo")
	public RegistroCoren getRegistroCoren() {
		return registroCoren;
	}

	public void setRegistroCoren(RegistroCoren registroCoren) {
		this.registroCoren = registroCoren;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf="
				+ cpf + ", rg=" + rg + ", contato=" + contato + ", endereco="
				+ endereco + ", registroCoren=" + registroCoren + "]";
	}

}

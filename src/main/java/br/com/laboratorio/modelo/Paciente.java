package br.com.laboratorio.modelo;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name="Paciente.listar", query="SELECT paciente FROM Paciente paciente order by codigo"),
	@NamedQuery(name="Paciente.buscarPorId", query="SELECT paciente FROM Paciente paciente WHERE paciente.id= :codigo"),
	@NamedQuery(name = "Paciente.VerificaCpf", query = "SELECT paciente.cpf FROM Paciente paciente WHERE paciente.cpf= :cpf"),
	@NamedQuery(name="Paciente.buscarPeloNome", query="SELECT paciente FROM Paciente paciente WHERE paciente.nome LIKE :nome")
})
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private String cpf;
	private String rg;
	private Date datanasc;
	private Date datacad;
	private Contato contato;
	private Endereco endereco;
	private String observacao;
	
	public Paciente() {
		nome = new String();
		cpf = new String();
		rg = new String();
		contato = new Contato();
		endereco = new Endereco();
		observacao = new String();
	}
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(nullable=false, unique=true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable=false, unique=true, length=15)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(length = 9)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public Date getDatacad() {
		return datacad;
	}
	
	public void setDatacad(Date datacad) {
		this.datacad = datacad;
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

	@Column(columnDefinition="text")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		Paciente other = (Paciente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Paciente [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf
				+ ", rg=" + rg + ", datanasc=" + datanasc + ", datacad="
				+ datacad + ", contato=" + contato + ", endereco=" + endereco
				+ ", observacao=" + observacao + "]";
	}
	
}

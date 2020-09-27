package br.com.laboratorio.modelo;

public enum EnumSexo {
	Masculino("Masculino"), Feminino("Feminino"), Outros("Outros");
	
	private String descricao;
	
	private EnumSexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

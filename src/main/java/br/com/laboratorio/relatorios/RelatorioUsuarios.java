package br.com.laboratorio.relatorios;

import java.io.IOException;
import java.util.List;

import br.com.laboratorio.modelo.Usuario;
import br.com.laboratorio.service.UsuarioService;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

public class RelatorioUsuarios extends  AbstractRelatorios{
	private UsuarioService service;
	private List<Usuario> lista;
	private String tituloUsuario= "Relatório de Usuários Cadastrados";
	private PdfPCell celulaLogin, celulaNome, celulaCoren;
	private float [ ] colunaLargura = { 1.50f , 5.50f , 3 };
	
	
	public RelatorioUsuarios(){
		service = new UsuarioService();
		this.lista = service.ListandoUsuarios();		
	}

	@Override
	public void Iniciar() throws IOException, DocumentException {
		this.NomeArquivo("relusuarios");
		this.NomeColunas(tituloUsuario);
		this.CriarTabela(colunaLargura);
		this.CriaTitulos();
		PopularTabela();
		this.CriaDocumento();	
	}

	@Override
	protected void CriaTitulos() {
		celulaLogin = new PdfPCell(new Paragraph("LOGIN", fonteCabecalho));
		celulaLogin.setBorder(PdfPCell.NO_BORDER);
		
		celulaNome = new PdfPCell(new Paragraph("NOME DO FUNCIONÃ�RIO", fonteCabecalho));
		celulaNome.setBorder(PdfPCell.NO_BORDER);
		
		celulaCoren = new PdfPCell(new Paragraph("COREN/CRF/CRM", fonteCabecalho));
		celulaCoren.setBorder(PdfPCell.NO_BORDER);
		
		PdfPCell espaco = new PdfPCell();
		espaco.setColspan(5);
		
		tabela.addCell(celulaLogin);
		tabela.addCell(celulaNome);
		tabela.addCell(celulaCoren);
		tabela.addCell(espaco);		
	}

	@Override
	protected void PopularTabela() {
		for(Usuario usuario : lista){
			celulaLogin = new PdfPCell(new Paragraph(usuario.getLogin()+"", fonte));				
			celulaNome = new PdfPCell(new Paragraph(usuario.getFuncionario().getNome(), fonte));
			celulaCoren = new PdfPCell(new Paragraph(usuario.getFuncionario().getRegistroCoren().getCoren()
				+" "+usuario.getFuncionario().getRegistroCoren().getInscricao()
				+" "+usuario.getFuncionario().getRegistroCoren().getUf(), fonte));
			
			celulaLogin.setHorizontalAlignment(Element.ALIGN_LEFT);
			celulaLogin.setBorder(PdfPCell.NO_BORDER);
			celulaNome.setBorder(PdfPCell.NO_BORDER);
			celulaCoren.setBorder(PdfPCell.NO_BORDER);
			
			this.tabela.addCell(celulaLogin);
			this.tabela.addCell(celulaNome);
			this.tabela.addCell(celulaCoren);
			
		}		
	}
	
}

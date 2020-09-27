package br.com.laboratorio.relatorios;

import java.io.IOException;
import java.util.List;

import br.com.laboratorio.modelo.Funcionario;
import br.com.laboratorio.service.FuncionarioService;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

public class RelatorioFuncionario extends AbstractRelatorios {
	private FuncionarioService service;
	private List<Funcionario> lista;
	private String tituloFuncionario= "Relatório de Funcionários";
	private PdfPCell celulaCodigo, celulaNome, celulaCoren, celulaCidade;
	private float [ ] colunaLargura = { 1.50f , 5.50f , 4, 4 };
	
	public RelatorioFuncionario(){
		service = new FuncionarioService();
		this.lista = service.ListandoFuncionarios();	
	}
	
	@Override
	public void Iniciar() throws IOException, DocumentException {
		this.NomeArquivo("relfuncio");
		this.NomeColunas(tituloFuncionario);
		this.CriarTabela(colunaLargura);
		this.CriaTitulos();
		PopularTabela();
		this.CriaDocumento();
	}

	@Override
	protected void CriaTitulos() {
		celulaCodigo = new PdfPCell(new Paragraph("CÓDIGO", fonteCabecalho));
		celulaCodigo.setBorder(PdfPCell.NO_BORDER);
		
		celulaNome = new PdfPCell(new Paragraph("NOME", fonteCabecalho));
		celulaNome.setBorder(PdfPCell.NO_BORDER);
		
		celulaCoren = new PdfPCell(new Paragraph("COREN", fonteCabecalho));
		celulaCoren.setBorder(PdfPCell.NO_BORDER);
		
		celulaCidade = new PdfPCell(new Paragraph("CIDADE", fonteCabecalho));
		celulaCidade.setBorder(PdfPCell.NO_BORDER);
		
		PdfPCell espaco = new PdfPCell();
		espaco.setColspan(5);
		
		tabela.addCell(celulaCodigo);
		tabela.addCell(celulaNome);
		tabela.addCell(celulaCoren);
		tabela.addCell(celulaCidade);
		tabela.addCell(espaco);
		
	}

	@Override
	protected void PopularTabela() {
		for(Funcionario funcionario : lista){
			celulaCodigo = new PdfPCell(new Paragraph(funcionario.getCodigo()+"", fonte));				
			celulaNome = new PdfPCell(new Paragraph(funcionario.getNome(), fonte));
			celulaCoren = new PdfPCell(new Paragraph(funcionario.getRegistroCoren().getCoren()
					+funcionario.getRegistroCoren().getInscricao()
					+funcionario.getRegistroCoren().getUf(), fonte));
			celulaCidade = new PdfPCell(new Paragraph(funcionario.getEndereco().getCidade(), fonte));
		
			celulaCodigo.setHorizontalAlignment(Element.ALIGN_LEFT);
			celulaCodigo.setBorder(PdfPCell.NO_BORDER);
			celulaNome.setBorder(PdfPCell.NO_BORDER);
			celulaCoren.setBorder(PdfPCell.NO_BORDER);
			celulaCidade.setBorder(PdfPCell.NO_BORDER);
			
			this.tabela.addCell(celulaCodigo);
			this.tabela.addCell(celulaNome);
			this.tabela.addCell(celulaCoren);
			this.tabela.addCell(celulaCidade);
		}
		
	}

}

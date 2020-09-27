package br.com.laboratorio.relatorios;

import java.io.IOException;
import java.util.List;

import br.com.laboratorio.modelo.Paciente;
import br.com.laboratorio.service.PacienteService;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

public class RelatorioPaciente extends AbstractRelatorios{
	private PacienteService service;
	private List<Paciente> lista;
	private String tituloPaciente= "Relatório de Pacientes";
	private PdfPCell celulaCodigo, celulaNome, celulaTelefone, celulaConvenio, celulaCidade;
	private float [ ] colunaLargura = { 1.50f , 5.50f , 3, 4, 4 };
	

	public RelatorioPaciente(){
		service = new PacienteService();
		this.lista = service.ListandoPacientes();		
	}
	
	@Override
	public void Iniciar() throws IOException, DocumentException {
		this.NomeArquivo("relpacien");
		this.NomeColunas(tituloPaciente);
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
		
		celulaTelefone = new PdfPCell(new Paragraph("TELEFONE", fonteCabecalho));
		celulaTelefone.setBorder(PdfPCell.NO_BORDER);
		
		celulaConvenio = new PdfPCell(new Paragraph("CONVÊNIO", fonteCabecalho));
		celulaConvenio.setBorder(PdfPCell.NO_BORDER);
		
		celulaCidade = new PdfPCell(new Paragraph("CIDADE", fonteCabecalho));
		celulaCidade.setBorder(PdfPCell.NO_BORDER);
		
		PdfPCell espaco = new PdfPCell();
		espaco.setColspan(5);
		
		tabela.addCell(celulaCodigo);
		tabela.addCell(celulaNome);
		tabela.addCell(celulaTelefone);
		tabela.addCell(celulaConvenio);
		tabela.addCell(celulaCidade);
		tabela.addCell(espaco);		
	}


	@Override
	protected void PopularTabela() {
		for(Paciente paciente : lista){
			celulaCodigo = new PdfPCell(new Paragraph(paciente.getCodigo()+"", fonte));				
			celulaNome = new PdfPCell(new Paragraph(paciente.getNome(), fonte));
			celulaTelefone = new PdfPCell(new Paragraph(paciente.getContato().getCelular(), fonte));
			celulaConvenio = new PdfPCell(new Paragraph(paciente.getConvenio().getNome(), fonte));
			celulaCidade = new PdfPCell(new Paragraph(paciente.getEndereco().getCidade(), fonte));
		
			celulaCodigo.setHorizontalAlignment(Element.ALIGN_LEFT);
			celulaCodigo.setBorder(PdfPCell.NO_BORDER);
			celulaNome.setBorder(PdfPCell.NO_BORDER);
			celulaTelefone.setBorder(PdfPCell.NO_BORDER);
			celulaConvenio.setBorder(PdfPCell.NO_BORDER);
			celulaCidade.setBorder(PdfPCell.NO_BORDER);
			
			this.tabela.addCell(celulaCodigo);
			this.tabela.addCell(celulaNome);
			this.tabela.addCell(celulaTelefone);
			this.tabela.addCell(celulaConvenio);
			this.tabela.addCell(celulaCidade);
		}		
	}

	
}

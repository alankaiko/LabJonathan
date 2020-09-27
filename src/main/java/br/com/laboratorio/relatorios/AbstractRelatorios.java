package br.com.laboratorio.relatorios;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import br.com.laboratorio.util.ValidaCampos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractRelatorios {
	public abstract void Iniciar() throws IOException, DocumentException;
	protected abstract void CriaTitulos();
	protected abstract void PopularTabela();
	protected String nome;
	private String titulo;
	private Document documento;
	protected PdfPTable tabela;
	protected Font fonteCabecalho = new Font(FontFamily.COURIER, 8, Font.BOLD, GrayColor.GRAYBLACK);
	protected Font fonteTitulo = new Font(FontFamily.HELVETICA, 14, Font.BOLD, GrayColor.GRAYBLACK);
	protected Font fonte = new Font(FontFamily.COURIER, 7, Font.NORMAL, GrayColor.GRAYBLACK);
	protected Font fonteProntuario = new Font(FontFamily.TIMES_ROMAN, 6, Font.NORMAL, GrayColor.GRAYBLACK);
	public static final String destino = "C:/temp/";
	
	
	protected void NomeArquivo(String nome){
		if(ValidaCampos.ValidaSistemaOperacional(System.getProperty("os.name")))
			this.nome= destino+nome+Calendar.getInstance().getTimeInMillis()+".pdf";
		else
			this.nome= nome+Calendar.getInstance().getTimeInMillis()+".pdf";
	}
	
	
	protected void NomeColunas(String titulo){
		this.titulo = titulo;
	}
	
	protected void CriarTabela(float[] colu){
		tabela = new PdfPTable(colu);
		tabela.setWidthPercentage(100);
		tabela.getDefaultCell().setUseAscender(true);
		tabela.getDefaultCell().setUseDescender(true);
		tabela.getDefaultCell().setBorderWidth(0.40f);
		
	}
	
	
		
	
	
	protected void CriaDocumento()throws IOException, DocumentException{
		documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, new FileOutputStream(nome));
		documento.open();
		
		Paragraph paragrafo = new Paragraph(this.titulo, fonteTitulo);
		//paragrafo.setAlignment(1);
		documento.add(paragrafo);
		
		paragrafo = new Paragraph("     ");
		documento.add(paragrafo);		
		
		documento.add(tabela);
		documento.close();
		Desktop.getDesktop().open(new File(nome));
	}
	
	
	
	
}

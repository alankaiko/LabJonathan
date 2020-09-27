package br.tela.principal.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.GerenciaTelaConvenio;
import br.com.laboratorio.atela.GerenciaTelaFuncionario;
import br.com.laboratorio.atela.GerenciaTelaPaciente;
import br.com.laboratorio.atela.GerenciaTelaUsuario;
import br.com.laboratorio.atela.RelatorioFuncionarioClassic;
import br.com.laboratorio.relatorios.RelatorioConvenio;
import br.com.laboratorio.relatorios.RelatorioPaciente;
import br.tela.principal.tela.TelaPrincipalClassic;

import com.itextpdf.text.DocumentException;

public class TelaPrincipalClassicListener implements ActionListener{
	private TelaPrincipalClassic tela;
	
	public TelaPrincipalClassicListener(TelaPrincipalClassic tela) {
		this.tela = tela;
		AdicionaListener();
	}
	
	private void AdicionaListener(){	
		this.tela.getMenuArquivo().addActionListener(this);
		this.tela.getMenuCadastro().addActionListener(this);
	
		this.tela.getArquivoSair().addActionListener(this);
		
		this.tela.getCadastroConvenio().addActionListener(this);
		this.tela.getCadastroPaciente().addActionListener(this);
		
		this.tela.getCadastroFuncionario().addActionListener(this);
		this.tela.getCadastroUsuario().addActionListener(this);
	
		this.tela.getRelatorioPaciente().addActionListener(this);
		this.tela.getRelatorioFuncionario().addActionListener(this);
		this.tela.getRelatorioConvenio().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.tela.getArquivoSair())){
			System.exit(0);
		}
	
		if(event.getSource().equals(this.tela.getCadastroConvenio())){
			AbreCadConvenio();
		}
		
		if(event.getSource().equals(this.tela.getCadastroPaciente())){
			AbreCadPaciente();
		}
		
		if(event.getSource().equals(this.tela.getCadastroFuncionario())){
			AbreFuncionarioConsulta();
		}
		
		if(event.getSource().equals(this.tela.getCadastroUsuario())){
			AbreUsuarioConsulta();
		}
	
		if(event.getSource().equals(this.tela.getRelatorioFuncionario())){
			AbreRelatorioFuncionario();
		}
	
		if(event.getSource().equals(this.tela.getRelatorioConvenio())){
			AbreRelatorioConvenio();
		}
	
		if(event.getSource().equals(this.tela.getRelatorioPaciente())){
			AbreRelatorioPaciente();
		}				
			
	}
	
	private void AbreCadConvenio(){
		GerenciaTelaConvenio convenio = new GerenciaTelaConvenio();
		convenio.setLocationRelativeTo(this.tela.getTela());
		convenio.setVisible(true);
	}
	
	private void AbreCadPaciente(){
		GerenciaTelaPaciente paciente = new GerenciaTelaPaciente();
		paciente.getListener().setFuncionario(this.tela.getUsuario().getFuncionario());
		paciente.setLocationRelativeTo(this.tela.getTela());
		paciente.setVisible(true);
	}
	
	private void AbreFuncionarioConsulta(){
		GerenciaTelaFuncionario funcionario = new GerenciaTelaFuncionario();
		funcionario.setLocationRelativeTo(this.tela.getTela());
		funcionario.setVisible(true);
	}
	
	private void AbreUsuarioConsulta(){
		GerenciaTelaUsuario funcionario = new GerenciaTelaUsuario();
		funcionario.setLocationRelativeTo(this.tela.getTela());
		funcionario.setVisible(true);
	}
	
	private void AbreRelatorioFuncionario(){
		RelatorioFuncionarioClassic rel = new RelatorioFuncionarioClassic();
		rel.setLocationRelativeTo(this.tela.getTela());
		rel.setVisible(true);
	}
	
	private void AbreRelatorioConvenio(){
		try {
			RelatorioConvenio rel = new RelatorioConvenio();
			rel.Iniciar();
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private void AbreRelatorioPaciente(){
		try {
			RelatorioPaciente rel = new RelatorioPaciente();
			rel.Iniciar();
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("serial")
	public void TeclaEsc(){
        JRootPane meurootpane = this.tela.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            public void actionPerformed(ActionEvent e) {  
            	System.exit(0);
            }  
        });  
    }  
}


















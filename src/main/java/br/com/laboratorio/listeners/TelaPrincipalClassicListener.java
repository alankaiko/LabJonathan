package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import org.dom4j.DocumentException;

import br.com.laboratorio.atela.TelaPrincipalClassic;

public class TelaPrincipalClassicListener implements ActionListener{
	private TelaPrincipalClassic tela;
	
	public TelaPrincipalClassicListener(TelaPrincipalClassic tela) {
		this.tela = tela;
		AdicionaListener();
	}
	
	private void AdicionaListener(){	
		this.tela.getMenuArquivo().addActionListener(this);
		this.tela.getMenuAtendimento().addActionListener(this);
		this.tela.getMenuCadastro().addActionListener(this);
		this.tela.getMenuUsuario().addActionListener(this);
		this.tela.getMenuFarmacia().addActionListener(this);
		this.tela.getMenuRelatorio().addActionListener(this);
		
		this.tela.getAtendimentoCadCliente().addActionListener(this);
		this.tela.getAtendimentoProntuario().addActionListener(this);
		
		this.tela.getArquivoAgCli().addActionListener(this);
		this.tela.getArquivoConAte().addActionListener(this);
		this.tela.getArquivoAcomodacoes().addActionListener(this);
		
		this.tela.getCadastroConvenio().addActionListener(this);
		this.tela.getCadastroClinica().addActionListener(this);
		this.tela.getCadastroPaciente().addActionListener(this);
		
		this.tela.getUsuarioConFun().addActionListener(this);
		this.tela.getUsuarioFuncionario().addActionListener(this);
		this.tela.getUsuarioUser().addActionListener(this);
	
		this.tela.getFarmaciaFabricante().addActionListener(this);
		this.tela.getFarmaciaGruProduto().addActionListener(this);
		this.tela.getFarmaciaProduto().addActionListener(this);
		this.tela.getFarmaciaDevolucoes().addActionListener(this);
	
		this.tela.getRelatorioItens().addActionListener(this);
		this.tela.getRelatorioFornecedores().addActionListener(this);
		this.tela.getRelatorioGruItens().addActionListener(this);
		this.tela.getRelatorioPaciente().addActionListener(this);
		this.tela.getRelatorioFuncionario().addActionListener(this);
		this.tela.getRelatorioClinica().addActionListener(this);
		this.tela.getRelatorioConvenio().addActionListener(this);
		this.tela.getRelatorioProntuario().addActionListener(this);
				
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.tela.getArquivoAgCli())){
			AbreAgendaClinica();
		}
		
		if(event.getSource().equals(this.tela.getAtendimentoCadCliente())){
			AbreIncluirPaciente();
		}
		
		if(event.getSource().equals(this.tela.getAtendimentoProntuario())){
			AbreAgendaProntuario();
		}
		
		if(event.getSource().equals(this.tela.getCadastroConvenio())){
			AbreCadConvenio();
		}
		
		if(event.getSource().equals(this.tela.getCadastroPaciente())){
			AbreCadPaciente();
		}
		
		if(event.getSource().equals(this.tela.getUsuarioConFun())){
			AbreUsuConsulta();
		}
		
		if(event.getSource().equals(this.tela.getUsuarioFuncionario())){
			AbreIncluFuncionario();
		}
		
		if(event.getSource().equals(this.tela.getFarmaciaFabricante())){
			AbreCadFabricante();
		}
		
		if(event.getSource().equals(this.tela.getFarmaciaProduto())){
			AbreCadProdutos();
		}
		
		if(event.getSource().equals(this.tela.getUsuarioUser())){
			AbreCadUsuarios();
		}
		
		if(event.getSource().equals(this.tela.getRelatorioFuncionario())){
			AbreRelatorioFuncionario();
		}
		
		if(event.getSource().equals(this.tela.getRelatorioProntuario())){
			AbreRelatorioProntuario();
		}
		
		if(event.getSource().equals(this.tela.getRelatorioItens())){
			AbreRelatorioItens();
		}
		
		if(event.getSource().equals(this.tela.getRelatorioConvenio())){
			AbreRelatorioConvenio();
		}
			
		if(event.getSource().equals(this.tela.getRelatorioFornecedores())){
			AbreRelatorioFornecedor();
		}
			
		if(event.getSource().equals(this.tela.getRelatorioPaciente())){
			AbreRelatorioPaciente();
		}				
			
	}
	
	private void AbreAgendaClinica(){
		GerenciarAgenda gerencia = new GerenciarAgenda();
		gerencia.setLocationRelativeTo(this.tela.getTela());
		gerencia.setVisible(true);
	}
	
	private void AbreIncluirPaciente(){
		IncluirPacienteForm inclui = new IncluirPacienteForm();
		inclui.getListener().IniciarObjetos();
		inclui.setLocationRelativeTo(this.tela.getTela());
		inclui.setVisible(true);		
	}
	
	private void AbreAgendaProntuario(){
		GerenciaProntuarios formulario = new GerenciaProntuarios();
		formulario.getListener().ResetarLista();
		formulario.setLocationRelativeTo(this.tela.getTela());
		formulario.setVisible(true);
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
	
	private void AbreUsuConsulta(){
		GerenciaTelaFuncionario funcionario = new GerenciaTelaFuncionario();
		funcionario.setLocationRelativeTo(this.tela.getTela());
		funcionario.setVisible(true);
	}
	
	private void AbreIncluFuncionario(){
		IncluirFuncionariosForm incluirFunc =  new IncluirFuncionariosForm();
		incluirFunc.getListener().IniciaObjeto();
		incluirFunc.setLocationRelativeTo(this.tela.getTela());
		incluirFunc.setVisible(true);
	}
	
	private void AbreCadFabricante(){
		GerenciaTelaFabricante fabricante = new GerenciaTelaFabricante();
		fabricante.setLocationRelativeTo(this.tela.getTela());
		fabricante.setVisible(true);
	}
	
	private void AbreCadProdutos(){
		GerenciaTelaProdutos produtos = new GerenciaTelaProdutos();
		produtos.setLocationRelativeTo(this.tela.getTela());
		produtos.setVisible(true);
	}
	
	private void AbreCadUsuarios(){
		GerenciaTelaUsuario user = new GerenciaTelaUsuario();
		user.setLocationRelativeTo(this.tela.getTela());
		user.setVisible(true);
	}
	
	private void AbreRelatorioFuncionario(){
		RelatorioFuncionarioClassic rel = new RelatorioFuncionarioClassic();
		rel.setLocationRelativeTo(this.tela.getTela());
		rel.setVisible(true);
	}
	
	private void AbreRelatorioProntuario(){
		RelatorioProntuarioClassic rel = new RelatorioProntuarioClassic();
		rel.setLocationRelativeTo(this.tela.getTela());
		rel.setVisible(true);
	}
	
	private void AbreRelatorioItens(){
		try {
			RelatorioProdutos rel = new RelatorioProdutos();
			rel.Iniciar();
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private void AbreRelatorioConvenio(){
		try {
			RelatorioConvenio rel = new RelatorioConvenio();
			rel.Iniciar();
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private void AbreRelatorioFornecedor(){
		try {
			RelatorioFornecedores rel = new RelatorioFornecedores();
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


















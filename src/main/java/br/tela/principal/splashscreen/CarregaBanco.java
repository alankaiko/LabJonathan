package br.tela.principal.splashscreen;

import java.io.File;

import javax.swing.SwingWorker;

import br.com.laboratorio.util.HibernateUtil;
import br.com.laboratorio.util.ValidaCampos;
import br.com.laboratorio.zbanco.CriaUsuarioAdmin;
import br.tela.principal.tela.TelaLogin;

public class CarregaBanco extends SwingWorker<Void, Integer> {
	private IniciarSistema sistema;
	private TelaLogin telaLogin;
	
	public CarregaBanco(IniciarSistema sistema) {
		this.sistema = sistema;
	}	
	
	@Override
	protected Void doInBackground() throws Exception {
		IniciaBanco();
		DiretorioPadrao();
		this.sistema.dispose();
		
		telaLogin = new TelaLogin();
		Thread.sleep(1000);
		telaLogin.setVisible(true);
		
		return null;
	}
	
	
	private void IniciaBanco(){
		HibernateUtil.getSessionFactory();
		//CriarBancoDoZero();
	}
	
	@SuppressWarnings("unused")
	private void CriarBancoDoZero(){
		CriaUsuarioAdmin admin = new CriaUsuarioAdmin();
	}
	
	
	private void DiretorioPadrao(){
		if(ConferindoSistema()){
			File diretorio = new File("C:\\temp");
			if (!diretorio.exists()) {
			   diretorio.mkdirs(); 
			}
		}		
	}
	
	private boolean ConferindoSistema(){
		return ValidaCampos.ValidaSistemaOperacional(System.getProperty("os.name"));
	}
	
}

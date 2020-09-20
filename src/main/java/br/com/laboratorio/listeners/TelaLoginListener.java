package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import br.com.laboratorio.atela.TelaLogin;
import br.com.laboratorio.atela.TelaPrincipalClassic;
import br.com.laboratorio.util.MensagemPainelUtil;

public class TelaLoginListener implements ActionListener, MouseListener{
	private TelaLogin formulario;
	private Usuario usuario;
	
	public TelaLoginListener(TelaLogin formulario) {
		this.formulario = formulario;
		AdicionarListener();
		UsandoTAB();
		ArrastandoPainel();
	}

	private void AdicionarListener(){
		this.formulario.getBotaoEntrar().addActionListener(this);
		this.formulario.getBotaoFechar().addMouseListener(this);
	}
	
	private void VerificarLogin(){
		Autenticando();
		
		if(this.usuario != null){
			this.formulario.dispose();
			SelecaoClassic();
		}else{
			MensagemPainelUtil.AutenticaUsuario();
		}
	}
	
	
	private void Autenticando(){
		UsuarioController control = new UsuarioController();
		
		String login = this.formulario.getCampoTexto().getText();
		String senha = this.formulario.getCampoSenha().getText();
		
		this.usuario = control.AutenticaLogin(login, senha);
	}
	
	
	private void SelecaoClassic(){
		TelaPrincipalClassic classic = new TelaPrincipalClassic();
		classic.setUsuario(this.usuario);
		classic.IniciaComponentesSecundarios();
		classic.setLocationRelativeTo(this.formulario.getContentPane());
		classic.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource().equals(this.formulario.getBotaoFechar())){
			System.exit(0);
		}
	}
	@Override
	public void mousePressed(MouseEvent event) {
	}
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	@Override
	public void mouseExited(MouseEvent event) {
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.formulario.getBotaoEntrar())){
			VerificarLogin();			
		}
		
	}
	
	
	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getBotaoEntrar());
		this.formulario.getBotaoEntrar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBotaoEntrar().doClick();
                }  
            }  
        });
	}
	
	
	
	
	private void ArrastandoPainel(){
		
		this.formulario.getPainelDrag().addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                arrastaPainel(evt);
            }
        });
		
		this.formulario.getPainelDrag().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                arrastaPressionado(evt);
            }
        });
	}
	
	private void arrastaPressionado(MouseEvent evt) {
		this.formulario.setXx(evt.getX());
		this.formulario.setXy(evt.getY());
        //this.formulario.xx = evt.getX();
        //this.formulario.xy = evt.getY();
    }

    private void arrastaPainel(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.formulario.setLocation(x-this.formulario.getXx(),y-this.formulario.getXy());
    }
	
		
}

package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.IncluirFuncionariosForm;
import br.com.laboratorio.modelo.Funcionario;
import br.com.laboratorio.service.FuncionarioService;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.MensagemPainelUtil;
import br.com.laboratorio.util.ValidaCampos;


public class IncluirFuncionarioListener implements ActionListener{

	private IncluirFuncionariosForm formulario;
	private FuncionarioService service;
	private Funcionario funcionario;
	
	
	public IncluirFuncionarioListener(IncluirFuncionariosForm formulario) {
		this.formulario = formulario;
		service = new FuncionarioService();
		AdicionarListener();
		TeclaEsc();
		UsandoTAB();
		LimitaCaracteres();
	}
	
	public void IniciaObjeto(){
		this.funcionario = new Funcionario();
	}
	
	
	private void Salvar(){
		PegarDados();
		service.Salvar(funcionario);
	}
	
	
	//Classe pega os botoes do formulario e atrela à esta classe controller aqui (propria classe ClienteActionListener)
	private void AdicionarListener(){
		formulario.getBTGravar().addActionListener(this);
		formulario.getBTCancelar().addActionListener(this);
	}
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	/*-------------------CLASSES INTERNAS QUE CAPTURAM AS INFORMACOES E INSEREM NOS RESPECTIVOS OBJETOS ---------------*/
	private void PegarDados(){
		funcionario.setNome(this.formulario.getTNome().getText());
		funcionario.setCpf(this.formulario.getJCpf().getText().replaceAll("[_.-]", ""));
		funcionario.setRg(this.formulario.getTRg().getText());
		
		funcionario.getContato().setEmail(this.formulario.getTEmail().getText());
		funcionario.getContato().setCelular(this.formulario.getTCelular().getText());
		funcionario.getContato().setTelefone(this.formulario.getTTelefone().getText());
		
		funcionario.getEndereco().setLogradouro(this.formulario.getTLogradouro().getText());
		funcionario.getEndereco().setComplemento(this.formulario.getTComplemento().getText());
		funcionario.getEndereco().setNumero(ConverteDadosUtil.RetornaInt(this.formulario.getTNumero().getText()));
		funcionario.getEndereco().setBairro(this.formulario.getTBairro().getText());
		funcionario.getEndereco().setCidade(this.formulario.getTCidade().getText());
		funcionario.getEndereco().setEstado((String)this.formulario.getComboEstado().getSelectedItem());
		funcionario.getEndereco().setCep(this.formulario.getJCep().getText().replaceAll("[_.-]", ""));
		
		funcionario.getRegistroCoren().setCoren((String) this.formulario.getComboCoren().getSelectedItem());
		funcionario.getRegistroCoren().setInscricao(this.formulario.getTCoren().getText());
		funcionario.getRegistroCoren().setUf((String) this.formulario.getComboCorenEst().getSelectedItem());
	}
		
	
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	/*---------------------------------------CLASSES PARA EDICAO DOS OBJETOS-------------------------------------------*/
	public void AlterandoObjetos(){
		this.formulario.getTId().setText(String.valueOf(this.funcionario.getCodigo()));
		this.formulario.getTNome().setText(this.funcionario.getNome());
		this.formulario.getTRg().setText(this.funcionario.getRg());
		this.formulario.getJCpf().setText(this.funcionario.getCpf());
		this.formulario.getTLogradouro().setText(this.funcionario.getEndereco().getLogradouro());
		this.formulario.getTComplemento().setText(this.funcionario.getEndereco().getComplemento());
		this.formulario.getTNumero().setText(String.valueOf(this.funcionario.getEndereco().getNumero()));
		this.formulario.getTBairro().setText(this.funcionario.getEndereco().getBairro());
		this.formulario.getTCidade().setText(this.funcionario.getEndereco().getCidade());
		this.formulario.getComboEstado().setSelectedItem(this.funcionario.getEndereco().getEstado());
		this.formulario.getJCep().setText(this.funcionario.getEndereco().getCep());
		this.formulario.getTEmail().setText(this.funcionario.getContato().getEmail());
		this.formulario.getTCelular().setText(this.funcionario.getContato().getCelular());
		this.formulario.getTTelefone().setText(this.funcionario.getContato().getTelefone());
		this.formulario.getComboCoren().setSelectedItem(this.funcionario.getRegistroCoren().getCoren());
		this.formulario.getTCoren().setText(this.funcionario.getRegistroCoren().getInscricao());
		this.formulario.getComboCorenEst().setSelectedItem(this.funcionario.getRegistroCoren().getUf());
	}

	
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	/*-------------------CLASSES QUE POSSUI AS ACOES DOS BOTOES ---------------*/
	
	//Classe que possui eventos dos botoes da TELA
	public void actionPerformed(ActionEvent event) {		
		
		if(event.getSource().equals(this.formulario.getBTGravar()) && Validando()){
			Salvar();
			
			this.formulario.dispose();
		}else if(event.getSource().equals(this.formulario.getBTCancelar())){
			this.formulario.dispose();
		}
		else
			MensagemPainelUtil.ErroDuplicacao("Campos Nome, Cpf e Rg devem ser preenchido");
	}
	
	
	private boolean Validando(){
		return ValidaCampos.Validar(this.formulario.getTNome().getText())
				&& ValidaCampos.Validar(this.formulario.getTRg().getText())
				&& ValidaCampos.Validar(this.formulario.getJCpf().getText());
	}
	
	
	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getBTGravar());
		this.formulario.getBTGravar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBTGravar().doClick();
                }  
            }  
        });
		
		
		
		this.formulario.getBTCancelar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBTCancelar().doClick();  
                }  
            }  
        });
	}
	
	
	
	private void LimitaCaracteres(){
		this.formulario.getTRg().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {			    
                if ((formulario.getTRg().getText().length() > 8)) {
                	e.setKeyChar((char) KeyEvent.VK_CLEAR);      
			    } 
			}
		});
		
		this.formulario.getTTelefone().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {			    
                if ((formulario.getTTelefone().getText().length() > 11)) {
                	e.setKeyChar((char) KeyEvent.VK_CLEAR);      
			    } 
			}
		});
		
		this.formulario.getTCelular().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {			    
                if ((formulario.getTCelular().getText().length() > 11)) {
                	e.setKeyChar((char) KeyEvent.VK_CLEAR);      
			    } 
			}
		});
	}
	
	
	public void TeclaEsc(){
        JRootPane meurootpane = this.formulario.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            public void actionPerformed(ActionEvent e) {  
            	formulario.dispose();  
            }  
        });  
    }  

	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}

package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.DetalhesFuncionariDialog;
import br.com.laboratorio.modelo.Funcionario;

public class DetalhesFuncionariListener implements ActionListener{
	private Funcionario funcionario;
	private DetalhesFuncionariDialog formulario;

	
	public DetalhesFuncionariListener(DetalhesFuncionariDialog formulario) {
		this.formulario = formulario;
		AdicionarListener();
		UsandoTAB();
		TeclaEsc();
	}

	
	public void AdicionarListener(){
		this.formulario.getBTCancelar().addActionListener(this);
	}
	
	
	
	public void Detalhar(){
		this.formulario.getTCodigo().setText(String.valueOf(this.funcionario.getCodigo()));
		this.formulario.getTRegistro().setText(this.funcionario.getRegistroCoren().getCoren()
				+" "+this.funcionario.getRegistroCoren().getInscricao()
				+" "+this.funcionario.getRegistroCoren().getUf());
		this.formulario.getTNome().setText(this.funcionario.getNome());
		this.formulario.getTRg().setText(this.funcionario.getRg());
		this.formulario.getJCpf().setText(this.funcionario.getCpf());
		this.formulario.getTCpf().setText(this.formulario.getJCpf().getText());
		this.formulario.getTLogradouro().setText(this.funcionario.getEndereco().getLogradouro());
		this.formulario.getTComplemento().setText(this.funcionario.getEndereco().getComplemento());
		this.formulario.getTNumero().setText(String.valueOf(this.funcionario.getEndereco().getNumero()));
		this.formulario.getTBairro().setText(this.funcionario.getEndereco().getBairro());
		this.formulario.getTCidade().setText(this.funcionario.getEndereco().getCidade());
		this.formulario.getTEstado().setText(this.funcionario.getEndereco().getEstado());
		this.formulario.getJCep().setText(this.funcionario.getEndereco().getCep());
		this.formulario.getTCep().setText(this.formulario.getJCep().getText());
		this.formulario.getTEmail().setText(this.funcionario.getContato().getEmail());
		this.formulario.getTCelular().setText(this.funcionario.getContato().getCelular());
		this.formulario.getTTelefone().setText(this.funcionario.getContato().getTelefone());
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.formulario.getBTCancelar())){
			this.formulario.dispose();
		}
	}
	
	
	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getBTCancelar());
		this.formulario.getBTCancelar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBTCancelar().doClick();  
                }  
            }  
        });
	}
	
	
	
	@SuppressWarnings("serial")
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

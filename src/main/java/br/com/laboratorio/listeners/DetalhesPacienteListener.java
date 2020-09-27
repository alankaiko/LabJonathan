package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.DetalhesPacienteDialog;
import br.com.laboratorio.modelo.Funcionario;
import br.com.laboratorio.modelo.Paciente;
import br.com.laboratorio.util.ConverteDadosUtil;

public class DetalhesPacienteListener implements ActionListener{
	private Paciente paciente;
	private DetalhesPacienteDialog formulario;
	private Funcionario funcionario;

	
	public DetalhesPacienteListener(DetalhesPacienteDialog formulario) {
		this.formulario = formulario;
		AdicionarListener();
		UsandoTAB();
		TeclaEsc();
	}

	
	public void AdicionarListener(){
		this.formulario.getCancelar().addActionListener(this);
	}
	
	
	
	public void Detalhar(){
		this.formulario.getTId().setText(String.valueOf(this.paciente.getCodigo()));
		this.formulario.getTNome().setText(this.paciente.getNome());
		this.formulario.getTRg().setText(this.paciente.getRg());
		this.formulario.getJCpf().setText(this.paciente.getCpf());
		this.formulario.getTCpf().setText(this.formulario.getJCpf().getText());
		this.formulario.getTConvenio().setText(this.paciente.getConvenio().getNome());
		this.formulario.getTObservacao().setText(this.paciente.getObservacao());
		this.formulario.getJDataNasc().setText(ConverteDadosUtil.TransformandoEmString(this.paciente.getDataNasc()));
		this.formulario.getTDataNasc().setText(this.formulario.getJDataNasc().getText());
		this.formulario.getJDataCadastro().setText(ConverteDadosUtil.TransformandoEmString(this.paciente.getDataCad()));
		this.formulario.getTDataCadastro().setText(this.formulario.getJDataCadastro().getText());
		this.formulario.getTLogradouro().setText(this.paciente.getEndereco().getLogradouro());
		this.formulario.getTComplemento().setText(this.paciente.getEndereco().getComplemento());
		this.formulario.getTNumero().setText(String.valueOf(this.paciente.getEndereco().getNumero()));
		this.formulario.getTBairro().setText(this.paciente.getEndereco().getBairro());
		this.formulario.getTCidade().setText(this.paciente.getEndereco().getCidade());
		this.formulario.getTComboEstado().setText(this.paciente.getEndereco().getEstado());
		this.formulario.getJCep().setText(this.paciente.getEndereco().getCep());
		this.formulario.getTCep().setText(this.formulario.getJCep().getText());
		this.formulario.getTEmail().setText(this.paciente.getContato().getEmail());
		this.formulario.getTCelular().setText(this.paciente.getContato().getCelular());
		this.formulario.getTTelefone().setText(this.paciente.getContato().getTelefone());
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(this.formulario.getCancelar())){
			this.formulario.dispose();
		}
	}
	

	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getCancelar());
		this.formulario.getCancelar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getCancelar().doClick();  
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


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

}

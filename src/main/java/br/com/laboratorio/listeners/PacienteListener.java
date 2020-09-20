package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.CadastroPacienteTela;
import br.com.laboratorio.modelo.Paciente;
import br.com.laboratorio.service.PacienteService;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.MensagemPainelUtil;
import br.com.laboratorio.util.ValidaCampos;

public class PacienteListener implements ActionListener {
	private CadastroPacienteTela formulario;
	private Paciente paciente;
	private PacienteService service;
	
	public PacienteListener(CadastroPacienteTela formulario) {
		this.formulario = formulario;
		this.service = new PacienteService();
		
		
		this.AdicionarListener();
		this.UsandoTAB();
		this.LimitaCaracteres();
		this.TeclaEsc();
	}
	
	public void IniciarObjetos() {
		this.paciente = new Paciente();
	}
	
	private void Salvar(){
		PegarDados();
		this.service.Criar(this.paciente);
	}
	
	
	private void AdicionarListener(){
		this.formulario.getBotaocancelar().addActionListener(this);
		this.formulario.getBotaogravar().addActionListener(this);
	}
	
	public void PegarDados(){
		this.paciente.setNome(this.formulario.getTNome().getText());
		this.paciente.setCpf(this.formulario.getJCpf().getText().replaceAll("[_.-]", ""));
		this.paciente.setRg(this.formulario.getTRg().getText());
		this.paciente.setDatacad(new Date());
		this.paciente.setDatanasc(ConverteDadosUtil.TransformandoEmDate(this.formulario.getJDatanascimento().getText()));
		this.paciente.setObservacao(this.formulario.getTObservacao().getText());
		
		this.paciente.getContato().setEmail(this.formulario.getTEmail().getText());
		this.paciente.getContato().setCelular(this.formulario.getTCelular().getText());
		this.paciente.getContato().setTelefone(this.formulario.getTTelefone().getText());
		
		this.paciente.getEndereco().setLogradouro(this.formulario.getTLogradouro().getText());
		this.paciente.getEndereco().setComplemento(this.formulario.getTComplemento().getText());
		this.paciente.getEndereco().setBairro(this.formulario.getTBairro().getText());
		this.paciente.getEndereco().setCidade(this.formulario.getTCidade().getText());
		this.paciente.getEndereco().setEstado((String)this.formulario.getComboEstado().getSelectedItem());
		this.paciente.getEndereco().setCep(this.formulario.getJCep().getText().replaceAll("[_.-]", ""));
	}
	
	public void EditarDados(){
		this.formulario.getTCodigo().setText(String.valueOf(this.paciente.getCodigo()));
		this.formulario.getTNome().setText(this.paciente.getNome());
		this.formulario.getTRg().setText(this.paciente.getRg());
		this.formulario.getJCpf().setText(this.paciente.getCpf());
		this.formulario.getTObservacao().setText(this.paciente.getObservacao());
		this.formulario.getJDatanascimento().setText(ConverteDadosUtil.TransformandoEmString(this.paciente.getDatanasc()));
		this.formulario.getJDatacadastro().setText(ConverteDadosUtil.TransformandoEmString(this.paciente.getDatacad()));
		this.formulario.getTLogradouro().setText(this.paciente.getEndereco().getLogradouro());
		this.formulario.getTComplemento().setText(this.paciente.getEndereco().getComplemento());
		this.formulario.getTBairro().setText(this.paciente.getEndereco().getBairro());
		this.formulario.getTCidade().setText(this.paciente.getEndereco().getCidade());
		this.formulario.getComboEstado().setSelectedItem(this.paciente.getEndereco().getEstado());
		this.formulario.getJCep().setText(this.paciente.getEndereco().getCep());
		this.formulario.getTEmail().setText(this.paciente.getContato().getEmail());
		this.formulario.getTCelular().setText(this.paciente.getContato().getCelular());
		this.formulario.getTTelefone().setText(this.paciente.getContato().getTelefone());
	}
	

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource().equals(this.formulario.getBotaogravar()) && ValidandoField()){
			Salvar();

			this.formulario.dispose();
		}else if(evento.getSource().equals(this.formulario.getBotaocancelar())){
			this.formulario.dispose();
		}else{
			MensagemPainelUtil.CampoVazio("Nome, Cpf e Rg devem ser preenchidos");
		}
	}
	
	private boolean ValidandoField(){
		return ValidaCampos.Validar(this.formulario.getTNome().getText())
				&& ValidaCampos.Validar(this.formulario.getTRg().getText())
				&& ValidaCampos.Validar(this.formulario.getJCpf().getText());
	}
	
	private void UsandoTAB(){
		this.formulario.getRootPane().setDefaultButton(this.formulario.getBotaogravar());
		
		this.formulario.getBotaogravar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBotaogravar().doClick();
                }  
            }  
        });
		
		
		
		this.formulario.getBotaocancelar().addKeyListener(new KeyAdapter() {  
            public void keyPressed(KeyEvent e) {  
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                	formulario.getBotaocancelar().doClick();  
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
	
	
	private void TeclaEsc(){
        JRootPane meurootpane = this.formulario.getRootPane();  
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");  
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {  
  
            public void actionPerformed(ActionEvent e) {  
            	formulario.dispose();  
            }  
        });  
    }  

	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}

package br.com.laboratorio.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import br.com.laboratorio.atela.IncluirConvenioForm;
import br.com.laboratorio.modelo.Convenio;
import br.com.laboratorio.service.ConvenioService;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.MensagemPainelUtil;
import br.com.laboratorio.util.ValidaCampos;

public class IncluirConvenioListener implements ActionListener {
	private IncluirConvenioForm formulario;
	private ConvenioService service;
	private Convenio convenio;

	public IncluirConvenioListener(IncluirConvenioForm formulario) {
		this.formulario = formulario;
		service = new ConvenioService();
		AdicionarListener();
		TeclaEsc();
		UsandoTAB();
	}

	private void Salvar() {
		FormToConvenio();
		service.Salvar(convenio);
	}

	// Classe pega os botoes do formulario e atrela à esta classe controller
	// aqui (propria classe ClienteActionListener)
	private void AdicionarListener() {
		formulario.getBTGravar().addActionListener(this);
		formulario.getBTCancelar().addActionListener(this);
	}

	/*-----------------------------------------------------------------------------------------------------------------*/
	/*-------------------CLASSES INTERNAS QUE CAPTURAM AS INFORMACOES E INSEREM NOS RESPECTIVOS OBJETOS ---------------*/

	// Método que pega informacoes do cliente e joga dentro do objeto Cliente
	private void FormToConvenio() {
		convenio = new Convenio();
		convenio.setNome(this.formulario.getTConvenio().getText());
		convenio.setAtivo(this.formulario.getLAtivo().isSelected());
		convenio.setObservacoes(this.formulario.getTObservacoes().getText());
		convenio.getContato().setCelular(this.formulario.getTCelular().getText());
		convenio.getContato().setTelefone(this.formulario.getTFixo().getText());
		convenio.getContato().setEmail(this.formulario.getTEmail().getText());
		convenio.getEndereco().setLogradouro(this.formulario.getTLogradouro().getText());
		convenio.getEndereco().setComplemento(this.formulario.getTComplemento().getText());
		convenio.getEndereco().setNumero(ConverteDadosUtil.RetornaInt(this.formulario.getTNumero().getText()));
		convenio.getEndereco().setBairro(this.formulario.getTBairro().getText());
		convenio.getEndereco().setCidade(this.formulario.getTCidade().getText());
		convenio.getEndereco().setEstado((String) this.formulario.getComboEstado().getSelectedItem());
		convenio.getEndereco().setCep(this.formulario.getJCep().getText().replaceAll("[_.-]", ""));

	}

	/*-----------------------------------------------------------------------------------------------------------------*/
	/*---------------------------------------CLASSES PARA EDICAO DOS OBJETOS-------------------------------------------*/
	public void AlterandoObjetos() {
		this.formulario.getTCodigo().setText(String.valueOf(this.convenio.getCodigo()));
		this.formulario.getTConvenio().setText(this.convenio.getNome());
		this.formulario.getLAtivo().setSelected(this.convenio.isAtivo());
		this.formulario.getTObservacoes().setText(this.convenio.getObservacoes());

		this.formulario.getTLogradouro().setText(this.convenio.getEndereco().getLogradouro());
		this.formulario.getTComplemento().setText(this.convenio.getEndereco().getComplemento());
		this.formulario.getTNumero().setText(String.valueOf(this.convenio.getEndereco().getNumero()));
		this.formulario.getTBairro().setText(this.convenio.getEndereco().getBairro());
		this.formulario.getTCidade().setText(this.convenio.getEndereco().getCidade());
		this.formulario.getComboEstado().setSelectedItem(this.convenio.getEndereco().getEstado());
		this.formulario.getJCep().setText(this.convenio.getEndereco().getCep());
		this.formulario.getTEmail().setText(this.convenio.getContato().getEmail());
		this.formulario.getTCelular().setText(this.convenio.getContato().getCelular());
		this.formulario.getTFixo().setText(this.convenio.getContato().getTelefone());
	}

	/*-----------------------------------------------------------------------------------------------------------------*/
	/*---------------------------------------CLASSES PARA DETALHAR OBJETOS-------------------------------------------*/
	public void DetalhandoObjetos() {
		this.formulario.getTCodigo().setEditable(false);
		this.formulario.getTConvenio().setEditable(false);
		this.formulario.getLAtivo().setEnabled(false);
		this.formulario.getTObservacoes().setEditable(false);

		this.formulario.getTLogradouro().setEditable(false);
		this.formulario.getTComplemento().setEditable(false);
		this.formulario.getTNumero().setEditable(false);
		this.formulario.getTBairro().setEditable(false);
		this.formulario.getTCidade().setEditable(false);
		this.formulario.getComboEstado().setEditable(false);
		this.formulario.getJCep().setEditable(false);
		this.formulario.getTEmail().setEditable(false);
		this.formulario.getTCelular().setEditable(false);
		this.formulario.getTFixo().setEditable(false);
	}

	/*-----------------------------------------------------------------------------------------------------------------*/
	/*-------------------CLASSES QUE POSSUI AS ACOES DOS BOTOES ---------------*/

	// Classe que possui eventos dos botoes da TELA
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(this.formulario.getBTGravar())&& Validando()) {
			Salvar();
			
			this.formulario.dispose();
		} else if (event.getSource().equals(this.formulario.getBTCancelar())) {
			this.formulario.dispose();
		} else {
			MensagemPainelUtil.ErroDuplicacao("Campo Convenio deve ser preenchido");
		}
	}

	private boolean Validando() {
		return ValidaCampos.Validar(this.formulario.getTConvenio().getText());
	}

	private void UsandoTAB() {
		this.formulario.getRootPane().setDefaultButton(
				this.formulario.getBTGravar());
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

	public void TeclaEsc() {
		JRootPane meurootpane = this.formulario.getRootPane();
		meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
		meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
			public void actionPerformed(ActionEvent e) {
				formulario.dispose();
			}
		});
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Convenio getConvenio() {
		return convenio;
	}
}

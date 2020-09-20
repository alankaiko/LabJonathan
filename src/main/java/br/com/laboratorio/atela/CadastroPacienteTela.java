package br.com.laboratorio.atela;

import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.laboratorio.listeners.PacienteListener;
import br.com.laboratorio.service.PacienteService;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.ListasUtil;
import javax.swing.JButton;

public class CadastroPacienteTela extends JDialog implements Serializable {
	private static final long serialVersionUID = 1L;
	private PacienteListener listener;
	private JPanel panel;
	private JButton botaocancelar, botaogravar;
	private JSeparator linhasepara, linhaseparacao;
	private JFormattedTextField JCpf, JDatanascimento, JDatacadastro, JCep;
	private JTextField TCodigo, TNome, TRg, TEmail, TObservacao;
	private JTextField TTelefone, TCelular, TLogradouro, TComplemento, TCidade, TBairro;
	private JLabel LNome, LCodigo, LDatacad, LCpf, LRg, LDatanascimento, LEmail, LTelefone;
	private JLabel LCelular, LLogradouro, LComplemento, LCep, LEstado, LCidade, LBairro, LObservacao;
	private JComboBox<String> ComboEstado;
	
	public CadastroPacienteTela() {
		getContentPane().setLayout(null);
		
		this.panel = new JPanel();
		this.panel.setBackground(Color.WHITE);
		this.panel.setBounds(0, 0, 695, 386);
		getContentPane().add(panel);
		this.panel.setLayout(null);
		
		PacienteService service = new PacienteService();
		service.Listar();
		
		this.AdicionarComponentes();
		this.AdicionarAoPainel();
		this.listener = new PacienteListener(this);
	}
	
	private void AdicionarComponentes() {
		this.LCodigo = new JLabel("C\u00F3digo");
		this.LCodigo.setBounds(10, 29, 86, 14);
		
		this.TCodigo = new JTextField();
		this.TCodigo.setBorder(new LineBorder(Color.BLACK));
		this.TCodigo.setBounds(10, 46, 86, 20);
		this.TCodigo.setColumns(10);
		
		this.LNome = new JLabel("Nome");
		this.LNome.setBounds(10, 77, 444, 14);
		
		this.TNome = new JTextField();
		this.TNome.setColumns(10);
		this.TNome.setBorder(new LineBorder(Color.BLACK));
		this.TNome.setBounds(10, 94, 444, 20);
		
		this.LDatacad = new JLabel("Data Cadastro");
		this.LDatacad.setBounds(464, 77, 215, 14);
		
		this.JDatacadastro= new JFormattedTextField(ConverteDadosUtil.FormataData());
		this.JDatacadastro.setEditable(false);
		this.JDatacadastro.setText(ConverteDadosUtil.RetornaDataAtual());
		this.JDatacadastro.setBounds(464, 94, 221, 20);
		
		this.LCpf = new JLabel("CPF");
		this.LCpf.setBounds(10, 125, 295, 14);
		
		this.JCpf= new JFormattedTextField(ConverteDadosUtil.FormataCPF());
		this.JCpf.setBorder(new LineBorder(Color.BLACK));
		this.JCpf.setBounds(10, 142, 295, 20);
		
		this.LRg = new JLabel("RG");
		this.LRg.setBounds(315, 125, 139, 14);
		
		this.TRg = new JTextField();
		this.TRg.setColumns(10);
		this.TRg.setBorder(new LineBorder(Color.BLACK));
		this.TRg.setBounds(315, 142, 139, 20);
		
		this.LDatanascimento = new JLabel("Data Nascimento");
		this.LDatanascimento.setBounds(464, 125, 215, 14);
		
		this.JDatanascimento= new JFormattedTextField(ConverteDadosUtil.FormataData());
		this.JDatanascimento.setBorder(new LineBorder(new Color(171, 173, 179)));
		this.JDatanascimento.setBounds(464, 142, 221, 20);
		
		this.linhasepara = new JSeparator();
		this.linhasepara.setForeground(Color.BLACK);
		this.linhasepara.setBounds(10, 173, 675, 2);
		
		this.LEmail = new JLabel("E-mail");
		this.LEmail.setBounds(10, 187, 295, 14);
		
		this.TEmail = new JTextField();
		this.TEmail.setColumns(10);
		this.TEmail.setBorder(new LineBorder(Color.BLACK));
		this.TEmail.setBounds(10, 204, 295, 20);
		
		this.LTelefone = new JLabel("Telefone");
		this.LTelefone.setBounds(315, 187, 139, 14);
		
		this.TTelefone = new JTextField();
		this.TTelefone.setColumns(10);
		this.TTelefone.setBorder(new LineBorder(Color.BLACK));
		this.TTelefone.setBounds(315, 204, 139, 20);
		
		this.LCelular = new JLabel("Celular");
		this.LCelular.setBounds(464, 187, 215, 14);
		
		this.TCelular = new JTextField();
		this.TCelular.setColumns(10);
		this.TCelular.setBorder(new LineBorder(Color.BLACK));
		this.TCelular.setBounds(464, 204, 221, 20);
		
		this.linhaseparacao = new JSeparator();
		this.linhaseparacao.setForeground(Color.BLACK);
		this.linhaseparacao.setBounds(10, 235, 675, 2);
		
		this.LLogradouro = new JLabel("Logradouro");
		this.LLogradouro.setBounds(10, 248, 295, 14);
		
		this.TLogradouro = new JTextField();
		this.TLogradouro.setColumns(10);
		this.TLogradouro.setBorder(new LineBorder(Color.BLACK));
		this.TLogradouro.setBounds(10, 265, 295, 20);
		
		this.LComplemento = new JLabel("Complemento");
		this.LComplemento.setBounds(315, 248, 364, 14);
		
		this.TComplemento = new JTextField();
		this.TComplemento.setColumns(10);
		this.TComplemento.setBorder(new LineBorder(Color.BLACK));
		this.TComplemento.setBounds(315, 265, 370, 20);
		
		this.LCep = new JLabel("CEP");
		this.LCep.setBounds(10, 296, 111, 14);
		
		this.JCep = new JFormattedTextField(ConverteDadosUtil.FormataCep());
		this.JCep.setBorder(new LineBorder(Color.BLACK));
		this.JCep.setBounds(10, 313, 111, 20);
		
		this.LEstado = new JLabel("Estado");
		this.LEstado.setBounds(131, 296, 174, 14);
		
		this.ComboEstado = new JComboBox<String>();
		this.ComboEstado.setBorder(new LineBorder(new Color(171, 173, 179)));
		this.ComboEstado.setModel(new DefaultComboBoxModel(new Vector(ListasUtil.Estados())));
		this.ComboEstado.setBounds(131, 313, 174, 20);
		
		this.LCidade = new JLabel("Cidade");
		this.LCidade.setBounds(315, 296, 139, 14);
		
		this.TCidade = new JTextField();
		this.TCidade.setColumns(10);
		this.TCidade.setBorder(new LineBorder(Color.BLACK));
		this.TCidade.setBounds(315, 313, 139, 20);
		
		this.LBairro = new JLabel("Bairro");
		this.LBairro.setBounds(464, 296, 215, 14);
		
		this.TBairro = new JTextField();
		this.TBairro.setColumns(10);
		this.TBairro.setBorder(new LineBorder(Color.BLACK));
		this.TBairro.setBounds(464, 313, 221, 20);
		
		this.LObservacao = new JLabel("Observa\u00E7\u00E3o");
		this.LObservacao.setBounds(10, 344, 675, 14);
		
		this.TObservacao = new JTextField();
		this.TObservacao.setColumns(10);
		this.TObservacao.setBorder(new LineBorder(Color.BLACK));
		this.TObservacao.setBounds(10, 361, 675, 20);
		
		this.botaocancelar = new JButton("Cancelar");
		this.botaocancelar.setBounds(596, 397, 89, 23);
		this.getContentPane().add(botaocancelar);
		
		this.botaogravar = new JButton("Gravar");
		this.botaogravar.setBounds(497, 397, 89, 23);
		this.getContentPane().add(botaogravar);
	}
	
	private void AdicionarAoPainel() {
		this.panel.add(TCodigo);
		this.panel.add(LCodigo);
		this.panel.add(TNome);
		this.panel.add(LNome);
		this.panel.add(JDatacadastro);
		this.panel.add(LDatacad);
		this.panel.add(LCpf);
		this.panel.add(TRg);
		this.panel.add(LRg);
		this.panel.add(JDatanascimento);
		this.panel.add(LDatanascimento);
		this.panel.add(LEmail);
		this.panel.add(TEmail);
		this.panel.add(linhasepara);
		this.panel.add(LTelefone);
		this.panel.add(TTelefone);
		this.panel.add(TCelular);
		this.panel.add(linhaseparacao);
		this.panel.add(LLogradouro);
		this.panel.add(TLogradouro);
		this.panel.add(LComplemento);
		this.panel.add(TComplemento);
		this.panel.add(LCep);
		this.panel.add(JCep);
		this.panel.add(JCpf);
		this.panel.add(ComboEstado);
		this.panel.add(LEstado);
		this.panel.add(LCidade);
		this.panel.add(TCidade);
		this.panel.add(LBairro);
		this.panel.add(TBairro);
		this.panel.add(JCpf);
		this.panel.add(LCelular);
		this.panel.add(LObservacao);
		panel.add(TObservacao);
	}

	public JFormattedTextField getJCpf() {
		return JCpf;
	}

	public void setJCpf(JFormattedTextField jCpf) {
		JCpf = jCpf;
	}

	public JFormattedTextField getJDatanascimento() {
		return JDatanascimento;
	}

	public void setJDatanascimento(JFormattedTextField jDatanascimento) {
		JDatanascimento = jDatanascimento;
	}

	public JFormattedTextField getJDatacadastro() {
		return JDatacadastro;
	}

	public void setJDatacadastro(JFormattedTextField jDatacadastro) {
		JDatacadastro = jDatacadastro;
	}

	public JFormattedTextField getJCep() {
		return JCep;
	}

	public void setJCep(JFormattedTextField jCep) {
		JCep = jCep;
	}

	public JTextField getTCodigo() {
		return TCodigo;
	}

	public void setTCodigo(JTextField tCodigo) {
		TCodigo = tCodigo;
	}

	public JTextField getTNome() {
		return TNome;
	}

	public void setTNome(JTextField tNome) {
		TNome = tNome;
	}

	public JTextField getTRg() {
		return TRg;
	}

	public void setTRg(JTextField tRg) {
		TRg = tRg;
	}

	public JTextField getTEmail() {
		return TEmail;
	}

	public void setTEmail(JTextField tEmail) {
		TEmail = tEmail;
	}

	public JTextField getTObservacao() {
		return TObservacao;
	}

	public void setTObservacao(JTextField tObservacao) {
		TObservacao = tObservacao;
	}

	public JTextField getTTelefone() {
		return TTelefone;
	}

	public void setTTelefone(JTextField tTelefone) {
		TTelefone = tTelefone;
	}

	public JTextField getTCelular() {
		return TCelular;
	}

	public void setTCelular(JTextField tCelular) {
		TCelular = tCelular;
	}

	public JTextField getTLogradouro() {
		return TLogradouro;
	}

	public void setTLogradouro(JTextField tLogradouro) {
		TLogradouro = tLogradouro;
	}

	public JTextField getTComplemento() {
		return TComplemento;
	}

	public void setTComplemento(JTextField tComplemento) {
		TComplemento = tComplemento;
	}

	public JComboBox<String> getComboEstado() {
		return ComboEstado;
	}
	
	public void setComboEstado(JComboBox<String> comboEstado) {
		ComboEstado = comboEstado;
	}

	public JTextField getTCidade() {
		return TCidade;
	}

	public void setTCidade(JTextField tCidade) {
		TCidade = tCidade;
	}

	public JTextField getTBairro() {
		return TBairro;
	}

	public void setTBairro(JTextField tBairro) {
		TBairro = tBairro;
	}
	
	public JButton getBotaocancelar() {
		return botaocancelar;
	}
	
	public void setBotaocancelar(JButton botaocancelar) {
		this.botaocancelar = botaocancelar;
	}
	
	public JButton getBotaogravar() {
		return botaogravar;
	}
	
	public void setBotaogravar(JButton botaogravar) {
		this.botaogravar = botaogravar;
	}
}

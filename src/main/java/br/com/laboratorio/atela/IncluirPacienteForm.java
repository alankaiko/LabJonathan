package br.com.laboratorio.atela;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.laboratorio.listeners.IncluirPacienteListener;
import br.com.laboratorio.modelo.EnumSexo;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.ListasUtil;

public class IncluirPacienteForm extends JDialog {
	private Container tela = getContentPane();
	private JTextField TCodigo, TNome, TRg, TTelefone, TEmail;
	private JTextField TCidade, TBairro, TNumero, TLogradouro, TComplemento;
	private JLabel LCodigo, LNome, LDatacadastro, LCpf, LRg, LDatanasc, LSexo, LTelefone, LEmail, LObservacoes;
	private JLabel LUf, LCidade, LNumero, LBairro, LLogradouro, LComplemento, LReferencia, LCep, LConvenio, LAdicionaConvenio;
	private JTextArea TObservacao, TReferencia;
	private JFormattedTextField JCpf, JDataNasc, JDataCadastro, JCep;
	private JButton BTGravar, BTCancelar;
	private JComboBox<String> ComboEstado, ComboSexo;
	private JTabbedPane tabbedPane;
	private JLayeredPane layeredPane, layeredPane_2;
	private JScrollPane scrollPane_1, scrollPane;
	private IncluirPacienteListener listener;
	private JComboBox<String> ComboConvenio;

	public static void main(String[] args) {
		try {
			IncluirPacienteForm dialog = new IncluirPacienteForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IncluirPacienteForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gestor\\Desktop\\nuclear.png"));
		setTitle("Paciente");
		setBounds(100, 100, 699, 339);
		tela.setLayout(null);

		this.MontarComponentes();
		this.listener = new IncluirPacienteListener(this);
	}

	public void MontarComponentes() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 665, 237);
		tela.add(tabbedPane);

		layeredPane = new JLayeredPane();
		tabbedPane.addTab("Dados Pessoais", null, layeredPane, null);

		LCodigo = new JLabel("C\u00F3digo");
		LCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCodigo.setBounds(13, 42, 70, 14);
		layeredPane.add(LCodigo);

		TCodigo = new JTextField();
		TCodigo.setBounds(13, 56, 76, 20);
		layeredPane.add(TCodigo);
		TCodigo.setColumns(10);

		LNome = new JLabel("Nome");
		LNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		LNome.setBounds(90, 42, 46, 14);
		layeredPane.add(LNome);

		TNome = new JTextField();
		TNome.setBounds(90, 56, 304, 20);
		layeredPane.add(TNome);
		TNome.setColumns(10);

		LDatacadastro = new JLabel("Data Cadastro");
		LDatacadastro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LDatacadastro.setBounds(13, 14, 86, 14);
		layeredPane.add(LDatacadastro);

		JDataCadastro= new JFormattedTextField(ConverteDadosUtil.FormataData());
		JDataCadastro.setEditable(false);
		JDataCadastro.setText(ConverteDadosUtil.RetornaDataAtual());
		JDataCadastro.setBounds(98, 11, 86, 20);
		layeredPane.add(JDataCadastro);

		LCpf = new JLabel("CPF");
		LCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCpf.setBounds(395, 42, 51, 14);
		layeredPane.add(LCpf);

		JCpf= new JFormattedTextField(ConverteDadosUtil.FormataCPF());
		JCpf.setBounds(395, 56, 130, 20);
		layeredPane.add(JCpf);

		LRg = new JLabel("RG");
		LRg.setFont(new Font("Tahoma", Font.BOLD, 11));
		LRg.setBounds(526, 42, 46, 14);
		layeredPane.add(LRg);

		TRg = new JTextField();
		TRg.setBounds(526, 56, 130, 20);
		layeredPane.add(TRg);
		TRg.setColumns(10);

		LDatanasc = new JLabel("Data Nasc.");
		LDatanasc.setFont(new Font("Tahoma", Font.BOLD, 11));
		LDatanasc.setBounds(13, 83, 70, 14);
		layeredPane.add(LDatanasc);

		JDataNasc= new JFormattedTextField(ConverteDadosUtil.FormataData());
		JDataNasc.setBounds(13, 97, 76, 20);
		layeredPane.add(JDataNasc);

		LSexo = new JLabel("Sexo");
		LSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LSexo.setBounds(90, 83, 46, 14);
		layeredPane.add(LSexo);

		ComboSexo = new JComboBox<String>();
		ComboSexo.setModel(new DefaultComboBoxModel(EnumSexo.values()));
		ComboSexo.setBounds(90, 97, 86, 20);
		layeredPane.add(ComboSexo);

		LTelefone = new JLabel("Telefone");
		LTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		LTelefone.setBounds(178, 83, 86, 14);
		layeredPane.add(LTelefone);

		TTelefone = new JTextField();
		TTelefone.setBounds(178, 97, 106, 20);
		layeredPane.add(TTelefone);
		TTelefone.setColumns(10);

		LEmail = new JLabel("E-mail");
		LEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		LEmail.setBounds(285, 83, 46, 14);
		layeredPane.add(LEmail);

		TEmail = new JTextField();
		TEmail.setBounds(285, 97, 371, 20);
		layeredPane.add(TEmail);
		TEmail.setColumns(10);

		LObservacoes = new JLabel("Observa\u00E7\u00F5es");
		LObservacoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		LObservacoes.setBounds(13, 121, 86, 14);
		layeredPane.add(LObservacoes);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(13, 136, 643, 62);
		layeredPane.add(scrollPane);

		TObservacao = new JTextArea();
		scrollPane.setViewportView(TObservacao);
		
		LConvenio = new JLabel("Conv\u00EAnio");
		LConvenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		LConvenio.setBounds(351, 14, 88, 14);
		layeredPane.add(LConvenio);
		
		LAdicionaConvenio = new JLabel();
		LAdicionaConvenio.setText("Adicionar?");
		LAdicionaConvenio.setForeground(Color.BLUE);
		LAdicionaConvenio.setFont(new Font("Palatino Linotype", Font.PLAIN, 10));
		LAdicionaConvenio.setBounds(594, 16, 62, 14);
		layeredPane.add(LAdicionaConvenio);
		
		ComboConvenio = new JComboBox<String>();
		ComboConvenio.setBounds(409, 11, 175, 20);
		layeredPane.add(ComboConvenio);
		
		layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Endere\u00E7os", null, layeredPane_2, null);

		LCep = new JLabel("CEP");
		LCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCep.setBounds(10, 11, 46, 14);
		layeredPane_2.add(LCep);

		JCep = new JFormattedTextField(ConverteDadosUtil.FormataCep());
		JCep.setBounds(10, 26, 106, 20);
		layeredPane_2.add(JCep);
	
		LUf = new JLabel("UF");
		LUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		LUf.setBounds(119, 11, 21, 14);
		layeredPane_2.add(LUf);

		ComboEstado = new JComboBox<String>();
		ComboEstado.setModel(new DefaultComboBoxModel(new Vector(ListasUtil.Estados())));
		ComboEstado.setBounds(119, 26, 62, 20);
		layeredPane_2.add(ComboEstado);

		LCidade = new JLabel("Cidade");
		LCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCidade.setBounds(185, 11, 46, 14);
		layeredPane_2.add(LCidade);

		TCidade = new JTextField();
		TCidade.setBounds(185, 26, 232, 20);
		layeredPane_2.add(TCidade);
		TCidade.setColumns(10);

		LBairro = new JLabel("Bairro");
		LBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBairro.setBounds(420, 11, 46, 14);
		layeredPane_2.add(LBairro);

		TBairro = new JTextField();
		TBairro.setBounds(420, 26, 235, 20);
		layeredPane_2.add(TBairro);
		TBairro.setColumns(10);

		LNumero = new JLabel("N\u00FAmero");
		LNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		LNumero.setBounds(10, 52, 106, 14);
		layeredPane_2.add(LNumero);

		TNumero = new JTextField();
		TNumero.setBounds(10, 70, 106, 20);
		layeredPane_2.add(TNumero);
		TNumero.setColumns(10);

		LLogradouro = new JLabel("Logradouro");
		LLogradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LLogradouro.setBounds(119, 52, 85, 14);
		layeredPane_2.add(LLogradouro);

		TLogradouro = new JTextField();
		TLogradouro.setBounds(119, 70, 298, 20);
		layeredPane_2.add(TLogradouro);
		TLogradouro.setColumns(10);

		LComplemento = new JLabel("Complemento");
		LComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		LComplemento.setBounds(420, 52, 92, 14);
		layeredPane_2.add(LComplemento);

		TComplemento = new JTextField();
		TComplemento.setBounds(420, 70, 235, 20);
		layeredPane_2.add(TComplemento);
		TComplemento.setColumns(10);

		LReferencia = new JLabel("Referencia");
		LReferencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		LReferencia.setBounds(10, 95, 106, 14);
		layeredPane_2.add(LReferencia);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 110, 645, 88);
		layeredPane_2.add(scrollPane_1);

		TReferencia = new JTextArea();
		scrollPane_1.setViewportView(TReferencia);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 259, 665, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			tela.add(buttonPane);
			{
				BTGravar = new JButton("Novo");
				BTGravar.setActionCommand("OK");
				buttonPane.add(BTGravar);
				getRootPane().setDefaultButton(BTGravar);
			}
			{
				BTCancelar = new JButton("Cancel");
				BTCancelar.setActionCommand("Cancel");
				buttonPane.add(BTCancelar);
			}
		}
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



	public JTextField getTTelefone() {
		return TTelefone;
	}

	public void setTTelefone(JTextField tTelefone) {
		TTelefone = tTelefone;
	}

	public JTextField getTEmail() {
		return TEmail;
	}

	public void setTEmail(JTextField tEmail) {
		TEmail = tEmail;
	}

	
	public JFormattedTextField getJCpf() {
		return JCpf;
	}

	public void setJCpf(JFormattedTextField jCpf) {
		JCpf = jCpf;
	}

	public JFormattedTextField getJDataNasc() {
		return JDataNasc;
	}

	public void setJDataNasc(JFormattedTextField jDataNasc) {
		JDataNasc = jDataNasc;
	}

	public JFormattedTextField getJDataCadastro() {
		return JDataCadastro;
	}

	public void setJDataCadastro(JFormattedTextField jDataCadastro) {
		JDataCadastro = jDataCadastro;
	}

	public JFormattedTextField getJCep() {
		return JCep;
	}

	public void setJCep(JFormattedTextField jCep) {
		JCep = jCep;
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

	public JTextField getTNumero() {
		return TNumero;
	}

	public void setTNumero(JTextField tNumero) {
		TNumero = tNumero;
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

	public JComboBox<String> getComboSexo() {
		return ComboSexo;
	}
	
	public void setComboSexo(JComboBox<String> comboSexo) {
		ComboSexo = comboSexo;
	}

	public JTextArea getTObservacao() {
		return TObservacao;
	}
	
	public void setTObservacao(JTextArea tObservacao) {
		TObservacao = tObservacao;
	}

	public JTextArea getTReferencia() {
		return TReferencia;
	}

	public void setTReferencia(JTextArea tReferencia) {
		TReferencia = tReferencia;
	}

	public IncluirPacienteListener getListener() {
		return listener;
	}
	
	public JButton getBTGravar() {
		return BTGravar;
	}
	
	public void setBTGravar(JButton bTGravar) {
		BTGravar = bTGravar;
	}
	
	public JButton getBTCancelar() {
		return BTCancelar;
	}
	
	public void setBTCancelar(JButton bTCancelar) {
		BTCancelar = bTCancelar;
	}
	
	public JLabel getLAdicionaConvenio() {
		return LAdicionaConvenio;
	}
	
	public void setLAdicionaConvenio(JLabel lAdicionaConvenio) {
		LAdicionaConvenio = lAdicionaConvenio;
	}
	
	public Container getTela() {
		return tela;
	}
	
	public JComboBox<String> getComboConvenio() {
		return ComboConvenio;
	}
	
	public void setComboConvenio(JComboBox<String> comboConvenio) {
		ComboConvenio = comboConvenio;
	}
}

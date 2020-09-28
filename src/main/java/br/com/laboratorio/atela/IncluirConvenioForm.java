package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.IncluirConvenioListener;
import br.com.laboratorio.listeners.IncluirFuncionarioListener;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.ListasUtil;

public class IncluirConvenioForm extends JDialog {
	private JLabel LCodigo, LConvenio, LObervacoes, LCep, LUf, LCidade, LBairro, LLogradouro;
	private JLabel LComplemento, Lfixo, LCelular, LEmail, LContato, LNumero;
	private JTextField TCodigo, TConvenio, TCidade, TBairro, TLogradouro;
	private JTextField TComplemento, TFixo, TCelular, TEmail, TContato, TNumero;
	private JComboBox<String> ComboEstado;
	private JFormattedTextField JCep;
	private JLayeredPane layer1, layer2;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JCheckBox LAtivo;
	private JTextArea TObservacoes;
	private JButton BTGravar, BTCancelar;
	private IncluirConvenioListener listener;

	public IncluirConvenioForm() {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBackground(SystemColor.inactiveCaption);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gestor\\Desktop\\nuclear.png"));
		setTitle("Convênio");
		setBounds(100, 100, 555, 340);
		getContentPane().setLayout(null);	
		setModal(true);
		setResizable(false);
		
		this.MontarComponentes();
		this.listener = new IncluirConvenioListener(this);
	}

	private void MontarComponentes() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(10, 11, 522, 234);
		getContentPane().add(tabbedPane);

		layer1 = new JLayeredPane();
		layer1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Dados Principais", null, layer1, null);
		layer1.setLayout(null);

		layer2 = new JLayeredPane();
		tabbedPane.addTab("Dados Contato", null, layer2, null);

		LCodigo = new JLabel("C\u00F3digo");
		LCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCodigo.setBounds(10, 11, 46, 14);
		layer1.add(LCodigo);

		TCodigo = new JTextField();
		TCodigo.setBounds(10, 26, 103, 20);
		layer1.add(TCodigo);
		TCodigo.setEditable(false);
		TCodigo.setColumns(10);

		LConvenio = new JLabel("Conv\u00EAnio");
		LConvenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		LConvenio.setBounds(115, 11, 68, 14);
		layer1.add(LConvenio);

		TConvenio = new JTextField();
		TConvenio.setBounds(115, 26, 336, 20);
		layer1.add(TConvenio);
		TConvenio.setColumns(10);

		LAtivo = new JCheckBox("Ativo");
		LAtivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LAtivo.setBackground(Color.WHITE);
		LAtivo.setBounds(457, 25, 89, 23);
		layer1.add(LAtivo);

		LObervacoes = new JLabel("Observa\u00E7\u00F5es");
		LObervacoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		LObervacoes.setBounds(10, 50, 103, 20);
		layer1.add(LObervacoes);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 438, 93);
		layer1.add(scrollPane);

		TObservacoes = new JTextArea();
		scrollPane.setViewportView(TObservacoes);

		LCep = new JLabel("CEP");
		LCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCep.setBounds(10, 11, 46, 14);
		layer2.add(LCep);

		JCep = new JFormattedTextField(ConverteDadosUtil.FormataCep());
		JCep.setBounds(10, 26, 106, 20);
		layer2.add(JCep);

		LUf = new JLabel("UF");
		LUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		LUf.setBounds(119, 11, 21, 14);
		layer2.add(LUf);

		ComboEstado = new JComboBox<String>();
		ComboEstado.setModel(new DefaultComboBoxModel(new Vector(ListasUtil.Estados())));
		ComboEstado.setBounds(119, 26, 62, 20);

		LCidade = new JLabel("Cidade");
		LCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCidade.setBounds(185, 11, 46, 14);
		layer2.add(LCidade);

		TCidade = new JTextField();
		TCidade.setColumns(10);
		TCidade.setBounds(185, 26, 310, 20);
		layer2.add(TCidade);

		LBairro = new JLabel("Bairro");
		LBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBairro.setBounds(10, 50, 46, 14);
		layer2.add(LBairro);

		TBairro = new JTextField();
		TBairro.setColumns(10);
		TBairro.setBounds(10, 65, 165, 20);
		layer2.add(TBairro);

		LLogradouro = new JLabel("Logradouro");
		LLogradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LLogradouro.setBounds(185, 50, 92, 14);
		layer2.add(LLogradouro);

		TLogradouro = new JTextField();
		TLogradouro.setColumns(10);
		TLogradouro.setBounds(185, 65, 310, 20);
		layer2.add(TLogradouro);

		LComplemento = new JLabel("Complemento");
		LComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		LComplemento.setBounds(10, 90, 92, 14);
		layer2.add(LComplemento);

		TComplemento = new JTextField();
		TComplemento.setColumns(10);
		TComplemento.setBounds(10, 105, 394, 20);
		layer2.add(TComplemento);

		Lfixo = new JLabel("Telefone Fixo");
		Lfixo.setFont(new Font("Tahoma", Font.BOLD, 11));
		Lfixo.setBounds(10, 128, 92, 14);
		layer2.add(Lfixo);

		TFixo = new JTextField();
		TFixo.setBounds(10, 142, 115, 20);
		layer2.add(TFixo);
		TFixo.setColumns(10);

		LCelular = new JLabel("Telefone Cel");
		LCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCelular.setBounds(130, 128, 81, 14);
		layer2.add(LCelular);

		TCelular = new JTextField();
		TCelular.setBounds(130, 142, 115, 20);
		layer2.add(TCelular);
		TCelular.setColumns(10);

		LEmail = new JLabel("E-mail");
		LEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		LEmail.setBounds(248, 128, 46, 14);
		layer2.add(LEmail);

		TEmail = new JTextField();
		TEmail.setBounds(248, 142, 247, 20);
		layer2.add(TEmail);
		TEmail.setColumns(10);

		LContato = new JLabel("Nome do Contato");
		LContato.setFont(new Font("Tahoma", Font.BOLD, 11));
		LContato.setBounds(10, 164, 115, 14);
		layer2.add(LContato);

		TContato = new JTextField();
		TContato.setBounds(10, 178, 485, 20);
		layer2.add(TContato);
		TContato.setColumns(10);
		
		TNumero = new JTextField();
		TNumero.setColumns(10);
		TNumero.setBounds(414, 105, 81, 20);
		layer2.add(TNumero);
		
		LNumero = new JLabel("Bairro");
		LNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		LNumero.setBounds(414, 90, 81, 14);
		layer2.add(LNumero);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 258, 510, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				BTGravar = new JButton("OK");
				BTGravar.setActionCommand("OK");
				buttonPane.add(BTGravar);
				getRootPane().setDefaultButton(BTGravar);
			}
			{
				BTCancelar = new JButton("Cancelar");
				BTCancelar.setActionCommand("Cancelar");
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

	public JTextField getTConvenio() {
		return TConvenio;
	}

	public void setTConvenio(JTextField tConvenio) {
		TConvenio = tConvenio;
	}

	public JFormattedTextField getJCep() {
		return JCep;
	}
	
	public void setJCep(JFormattedTextField jCep) {
		JCep = jCep;
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

	public JTextField getTFixo() {
		return TFixo;
	}

	public void setTFixo(JTextField tFixo) {
		TFixo = tFixo;
	}

	public JTextField getTCelular() {
		return TCelular;
	}

	public void setTCelular(JTextField tCelular) {
		TCelular = tCelular;
	}

	public JTextField getTEmail() {
		return TEmail;
	}

	public void setTEmail(JTextField tEmail) {
		TEmail = tEmail;
	}

	public JTextField getTContato() {
		return TContato;
	}

	public void setTContato(JTextField tContato) {
		TContato = tContato;
	}

	public JComboBox<String> getComboEstado() {
		return ComboEstado;
	}
	
	public void setComboEstado(JComboBox<String> comboEstado) {
		ComboEstado = comboEstado;
	}

	public JTextArea getTObservacoes() {
		return TObservacoes;
	}

	public void setTObservacoes(JTextArea tObservacoes) {
		TObservacoes = tObservacoes;
	}
	
	public JButton getBTCancelar() {
		return BTCancelar;
	}
	
	public void setBTCancelar(JButton bTCancelar) {
		BTCancelar = bTCancelar;
	}
	
	public JButton getBTGravar() {
		return BTGravar;
	}
	
	public void setBTGravar(JButton bTGravar) {
		BTGravar = bTGravar;
	}
	
	public IncluirConvenioListener getListener() {
		return listener;
	}
	
	public JCheckBox getLAtivo() {
		return LAtivo;
	}
	
	public void setLAtivo(JCheckBox lAtivo) {
		LAtivo = lAtivo;
	}
	
	public JTextField getTNumero() {
		return TNumero;
	}
	
	public void setTNumero(JTextField tNumero) {
		TNumero = tNumero;
	}
}

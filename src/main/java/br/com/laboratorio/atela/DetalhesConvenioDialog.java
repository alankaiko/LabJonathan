package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

import br.com.laboratorio.listeners.DetalhesConvenioListener;
import br.com.laboratorio.listeners.IncluirConvenioListener;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.ListasUtil;

public class DetalhesConvenioDialog extends JDialog {
	private JLabel LCodigo, LConvenio, LObervacoes, LCep, LUf, LCidade, LBairro, LLogradouro;
	private JLabel LComplemento, Lfixo, LCelular, LEmail, LContato, LNumero;
	private JLabel TCodigo, TConvenio, TCidade, TBairro, TLogradouro;
	private JLabel TComplemento, TFixo, TCelular, TEmail, TContato, TNumero;
	private JComboBox<String> ComboEstado;
	private JLabel JCep;
	private JLayeredPane layer1, layer2;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JCheckBox LAtivo;
	private JTextArea TObservacoes;
	private JButton BTCancelar;
	private DetalhesConvenioListener listener;

	public DetalhesConvenioDialog() {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBackground(SystemColor.inactiveCaption);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gestor\\Desktop\\nuclear.png"));
		setTitle("Convênio");
		setBounds(100, 100, 555, 340);
		getContentPane().setLayout(null);	
		setModal(true);
		setResizable(false);
		
		this.MontarComponentes();
		this.listener = new DetalhesConvenioListener(this);
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

		LCodigo = new JLabel("Código");
		LCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCodigo.setBounds(10, 11, 46, 14);
		layer1.add(LCodigo);

		TCodigo = new JLabel();
		TCodigo.setBounds(10, 26, 103, 20);
		layer1.add(TCodigo);

		LConvenio = new JLabel("Convênio");
		LConvenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		LConvenio.setBounds(115, 11, 68, 14);
		layer1.add(LConvenio);

		TConvenio = new JLabel();
		TConvenio.setBounds(115, 26, 336, 20);
		layer1.add(TConvenio);

		LAtivo = new JCheckBox("Ativo");
		LAtivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LAtivo.setBackground(Color.WHITE);
		LAtivo.setBounds(457, 25, 89, 23);
		LAtivo.setEnabled(true);
		layer1.add(LAtivo);

		LObervacoes = new JLabel("Observações");
		LObervacoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		LObervacoes.setBounds(10, 50, 103, 20);
		layer1.add(LObervacoes);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 438, 93);
		layer1.add(scrollPane);

		TObservacoes = new JTextArea();
		TObservacoes.setEditable(false);
		scrollPane.setViewportView(TObservacoes);

		LCep = new JLabel("CEP");
		LCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCep.setBounds(10, 11, 46, 14);
		layer2.add(LCep);

		JCep = new JLabel();
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

		TCidade = new JLabel();
		TCidade.setBounds(185, 26, 310, 20);
		layer2.add(TCidade);

		LBairro = new JLabel("Bairro");
		LBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBairro.setBounds(10, 50, 46, 14);
		layer2.add(LBairro);

		TBairro = new JLabel();
		TBairro.setBounds(10, 65, 165, 20);
		layer2.add(TBairro);

		LLogradouro = new JLabel("Logradouro");
		LLogradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LLogradouro.setBounds(185, 50, 92, 14);
		layer2.add(LLogradouro);

		TLogradouro = new JLabel();
		TLogradouro.setBounds(185, 65, 310, 20);
		layer2.add(TLogradouro);

		LComplemento = new JLabel("Complemento");
		LComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		LComplemento.setBounds(10, 90, 92, 14);
		layer2.add(LComplemento);

		TComplemento = new JLabel();
		TComplemento.setBounds(10, 105, 394, 20);
		layer2.add(TComplemento);

		Lfixo = new JLabel("Telefone Fixo");
		Lfixo.setFont(new Font("Tahoma", Font.BOLD, 11));
		Lfixo.setBounds(10, 128, 92, 14);
		layer2.add(Lfixo);

		TFixo = new JLabel();
		TFixo.setBounds(10, 142, 115, 20);
		layer2.add(TFixo);

		LCelular = new JLabel("Telefone Cel");
		LCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCelular.setBounds(130, 128, 81, 14);
		layer2.add(LCelular);

		TCelular = new JLabel();
		TCelular.setBounds(130, 142, 115, 20);
		layer2.add(TCelular);

		LEmail = new JLabel("E-mail");
		LEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		LEmail.setBounds(248, 128, 46, 14);
		layer2.add(LEmail);

		TEmail = new JLabel();
		TEmail.setBounds(248, 142, 247, 20);
		layer2.add(TEmail);

		LContato = new JLabel("Nome do Contato");
		LContato.setFont(new Font("Tahoma", Font.BOLD, 11));
		LContato.setBounds(10, 164, 115, 14);
		layer2.add(LContato);

		TContato = new JLabel();
		TContato.setBounds(10, 178, 485, 20);
		layer2.add(TContato);
		
		TNumero = new JLabel();
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
				BTCancelar = new JButton("Cancelar");
				BTCancelar.setActionCommand("Cancelar");
				buttonPane.add(BTCancelar);
			}
		}
	}

	public JLabel getTCodigo() {
		return TCodigo;
	}

	public void setTCodigo(JLabel tCodigo) {
		TCodigo = tCodigo;
	}

	public JLabel getTConvenio() {
		return TConvenio;
	}

	public void setTConvenio(JLabel tConvenio) {
		TConvenio = tConvenio;
	}

	public JLabel getTCidade() {
		return TCidade;
	}

	public void setTCidade(JLabel tCidade) {
		TCidade = tCidade;
	}

	public JLabel getTBairro() {
		return TBairro;
	}

	public void setTBairro(JLabel tBairro) {
		TBairro = tBairro;
	}

	public JLabel getTLogradouro() {
		return TLogradouro;
	}

	public void setTLogradouro(JLabel tLogradouro) {
		TLogradouro = tLogradouro;
	}

	public JLabel getTComplemento() {
		return TComplemento;
	}

	public void setTComplemento(JLabel tComplemento) {
		TComplemento = tComplemento;
	}

	public JLabel getTFixo() {
		return TFixo;
	}

	public void setTFixo(JLabel tFixo) {
		TFixo = tFixo;
	}

	public JLabel getTCelular() {
		return TCelular;
	}

	public void setTCelular(JLabel tCelular) {
		TCelular = tCelular;
	}

	public JLabel getTEmail() {
		return TEmail;
	}

	public void setTEmail(JLabel tEmail) {
		TEmail = tEmail;
	}

	public JLabel getTContato() {
		return TContato;
	}

	public void setTContato(JLabel tContato) {
		TContato = tContato;
	}

	public JLabel getTNumero() {
		return TNumero;
	}

	public void setTNumero(JLabel tNumero) {
		TNumero = tNumero;
	}

	public JComboBox<String> getComboEstado() {
		return ComboEstado;
	}

	public void setComboEstado(JComboBox<String> comboEstado) {
		ComboEstado = comboEstado;
	}

	public JLabel getJCep() {
		return JCep;
	}

	public void setJCep(JLabel jCep) {
		JCep = jCep;
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
	
	public DetalhesConvenioListener getListener() {
		return listener;
	}
	
	public void setListener(DetalhesConvenioListener listener) {
		this.listener = listener;
	}
}

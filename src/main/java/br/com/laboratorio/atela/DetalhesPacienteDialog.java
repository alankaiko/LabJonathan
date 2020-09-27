package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.DetalhesPacienteListener;
import br.com.laboratorio.util.ConverteDadosUtil;

public class DetalhesPacienteDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JLabel LId, LNome, LCpf, LRg, LDataNasc, LDataCad, LObservacao;
	private JLabel LIndentif, LEndereco, LLogradouro, LComplemento;
	private JLabel LNumero, LBairro, LCidade, LCep, LContato, LEmail, LCelular, LTelefone, LEstado, LConvenio, TConvenio;
	private JLabel TId, TNome, TCpf, TDataCadastro, TRg, TDataNasc, TObservacao, TLogradouro, TComplemento, TNumero;
	private JLabel TBairro, TCidade, TComboEstado, TCep, TEmail, TTelefone, TCelular;
	private JFormattedTextField JCpf, JDataNasc, JDataCadastro, JCep;
	private JButton cancelar;
	private JSeparator separa, separator;
	private DetalhesPacienteListener listener;

	public DetalhesPacienteDialog() {
		setModal(true);
		setBounds(100, 100, 580, 460);
		tela.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tela.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		OrganizarComponentes();
		AdicionaNaTela();
		listener = new DetalhesPacienteListener(this);
	}

	private void OrganizarComponentes() {
		LIndentif = new JLabel();
		LIndentif.setText("DADOS PESSOAIS");
		LIndentif.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		LIndentif.setBounds(10, 11, 130, 14);

		LId = new JLabel();
		LId.setText("Código");
		LId.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LId.setHorizontalAlignment(SwingConstants.RIGHT);
		LId.setBounds(42, 33, 59, 14);

		TId = new JLabel();
		TId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TId.setBounds(111, 30, 39, 20);

		LCpf = new JLabel();
		LCpf.setText("CPF:");
		LCpf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		LCpf.setBounds(64, 58, 37, 14);

		TCpf = new JLabel();
		TCpf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TCpf.setBounds(111, 55, 113, 20);

		LNome = new JLabel();
		LNome.setText("Nome:");
		LNome.setHorizontalAlignment(SwingConstants.RIGHT);
		LNome.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LNome.setBounds(52, 85, 49, 14);

		TNome = new JLabel();
		TNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TNome.setBounds(111, 82, 337, 20);

		LRg = new JLabel();
		LRg.setText("RG:");
		LRg.setHorizontalAlignment(SwingConstants.RIGHT);
		LRg.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LRg.setBounds(411, 58, 37, 14);

		TRg = new JLabel();
		TRg.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TRg.setBounds(458, 55, 113, 20);

		LEndereco = new JLabel();
		LEndereco.setText("ENDEREÇO");
		LEndereco.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		LEndereco.setBounds(10, 134, 130, 14);

		LLogradouro = new JLabel();
		LLogradouro.setText("Logradouro:");
		LLogradouro.setHorizontalAlignment(SwingConstants.RIGHT);
		LLogradouro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LLogradouro.setBounds(10, 160, 91, 14);

		TLogradouro = new JLabel();
		TLogradouro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TLogradouro.setBounds(111, 157, 340, 20);

		LComplemento = new JLabel();
		LComplemento.setText("Complemento:");
		LComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		LComplemento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LComplemento.setBounds(10, 186, 91, 14);

		TComplemento = new JLabel();
		TComplemento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TComplemento.setBounds(111, 183, 340, 20);

		LNumero = new JLabel();
		LNumero.setText("Número");
		LNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		LNumero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LNumero.setBounds(20, 211, 81, 14);

		TNumero = new JLabel();
		TNumero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TNumero.setBounds(111, 208, 59, 20);

		LCidade = new JLabel();
		LCidade.setText("Cidade:");
		LCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		LCidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCidade.setBounds(20, 237, 81, 14);

		TCidade = new JLabel();
		TCidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TCidade.setBounds(111, 234, 198, 20);

		LBairro = new JLabel();
		LBairro.setText("Bairro:");
		LBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		LBairro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LBairro.setBounds(332, 211, 71, 14);

		TBairro = new JLabel();
		TBairro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TBairro.setBounds(413, 208, 141, 20);

		LEstado = new JLabel();
		LEstado.setText("UF:");
		LEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		LEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LEstado.setBounds(364, 237, 39, 14);

		TComboEstado = new JLabel();
		TComboEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TComboEstado.setBounds(413, 234, 141, 20);

		LCep = new JLabel();
		LCep.setText("CEP:");
		LCep.setHorizontalAlignment(SwingConstants.RIGHT);
		LCep.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCep.setBounds(21, 260, 81, 14);

		TCep = new JLabel();
		TCep.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TCep.setBounds(112, 257, 81, 20);

		LContato = new JLabel();
		LContato.setText("CONTATO");
		LContato.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		LContato.setBounds(10, 292, 130, 14);

		LEmail = new JLabel();
		LEmail.setText("E-mail:");
		LEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		LEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LEmail.setBounds(20, 312, 81, 14);

		TEmail = new JLabel();
		TEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TEmail.setBounds(111, 309, 292, 20);

		LCelular = new JLabel();
		LCelular.setText("Celular:");
		LCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		LCelular.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCelular.setBounds(20, 340, 81, 14);

		TCelular = new JLabel();
		TCelular.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TCelular.setBounds(111, 337, 113, 20);

		TTelefone = new JLabel();
		TTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TTelefone.setBounds(411, 337, 113, 20);

		LTelefone = new JLabel();
		LTelefone.setText("Telefone:");
		LTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		LTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LTelefone.setBounds(322, 340, 81, 14);

		TDataCadastro = new JLabel();
		TDataCadastro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TDataCadastro.setBounds(458, 30, 165, 20);

		LDataCad = new JLabel();
		LDataCad.setText("Data Cadastro");
		LDataCad.setHorizontalAlignment(SwingConstants.RIGHT);
		LDataCad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LDataCad.setBounds(364, 33, 84, 14);

		LDataNasc = new JLabel();
		LDataNasc.setText("Data Nasc.:");
		LDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		LDataNasc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LDataNasc.setBounds(20, 107, 81, 14);

		TDataNasc = new JLabel();
		TDataNasc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TDataNasc.setBounds(111, 104, 113, 20);

		TConvenio = new JLabel();
		TConvenio.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TConvenio.setBounds(423, 104, 177, 20);

		LConvenio = new JLabel();
		LConvenio.setText("Plano");
		LConvenio.setHorizontalAlignment(SwingConstants.RIGHT);
		LConvenio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LConvenio.setBounds(332, 107, 81, 14);

		LObservacao = new JLabel();
		LObservacao.setText("Observação:");
		LObservacao.setHorizontalAlignment(SwingConstants.RIGHT);
		LObservacao.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LObservacao.setBounds(20, 365, 81, 14);

		TObservacao = new JLabel();
		TObservacao.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TObservacao.setBounds(105, 362, 420, 20);

		JCpf = new JFormattedTextField(ConverteDadosUtil.FormataCPF());
		JDataNasc = new JFormattedTextField(ConverteDadosUtil.FormataData());
		JDataCadastro = new JFormattedTextField(ConverteDadosUtil.FormataData());
		JCep = new JFormattedTextField(ConverteDadosUtil.FormataCep());
		separa = new JSeparator();
		separator = new JSeparator();

		cancelar = new JButton();
		cancelar.setText("Voltar");
		cancelar.setBounds(447, 388, 89, 23);

	}

	private void AdicionaNaTela() {
		panel.add(LIndentif);
		panel.add(LId);
		panel.add(TId);
		panel.add(LCpf);
		panel.add(TCpf);
		panel.add(LNome);
		panel.add(TNome);
		panel.add(LRg);
		panel.add(TRg);
		panel.add(LEndereco);
		panel.add(LLogradouro);
		panel.add(TLogradouro);
		panel.add(LComplemento);
		panel.add(TComplemento);
		panel.add(LNumero);
		panel.add(TNumero);
		panel.add(LCidade);
		panel.add(TCidade);
		panel.add(LBairro);
		panel.add(TBairro);
		panel.add(LEstado);
		panel.add(TComboEstado);
		panel.add(LCep);
		panel.add(TCep);
		panel.add(LContato);
		panel.add(LEmail);
		panel.add(TEmail);
		panel.add(LCelular);
		panel.add(TCelular);
		panel.add(TTelefone);
		panel.add(LTelefone);
		panel.add(cancelar);
		panel.add(TDataCadastro);
		panel.add(LDataCad);
		panel.add(LDataNasc);
		panel.add(TDataNasc);
		panel.add(TConvenio);
		panel.add(LConvenio);
		panel.add(separa);
		panel.add(separator);
		panel.add(LObservacao);
		panel.add(TObservacao);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Container getTela() {
		return tela;
	}

	public void setTela(Container tela) {
		this.tela = tela;
	}

	public JLabel getLId() {
		return LId;
	}

	public void setLId(JLabel lId) {
		LId = lId;
	}

	public JLabel getLNome() {
		return LNome;
	}

	public void setLNome(JLabel lNome) {
		LNome = lNome;
	}

	public JLabel getLCpf() {
		return LCpf;
	}

	public void setLCpf(JLabel lCpf) {
		LCpf = lCpf;
	}

	public JLabel getLRg() {
		return LRg;
	}

	public void setLRg(JLabel lRg) {
		LRg = lRg;
	}

	public JLabel getLDataNasc() {
		return LDataNasc;
	}

	public void setLDataNasc(JLabel lDataNasc) {
		LDataNasc = lDataNasc;
	}

	public JLabel getLDataCad() {
		return LDataCad;
	}

	public void setLDataCad(JLabel lDataCad) {
		LDataCad = lDataCad;
	}

	public JLabel getLObservacao() {
		return LObservacao;
	}

	public void setLObservacao(JLabel lObservacao) {
		LObservacao = lObservacao;
	}

	public JLabel getLIndentif() {
		return LIndentif;
	}

	public void setLIndentif(JLabel lIndentif) {
		LIndentif = lIndentif;
	}

	public JLabel getLEndereco() {
		return LEndereco;
	}

	public void setLEndereco(JLabel lEndereco) {
		LEndereco = lEndereco;
	}

	public JLabel getLLogradouro() {
		return LLogradouro;
	}

	public void setLLogradouro(JLabel lLogradouro) {
		LLogradouro = lLogradouro;
	}

	public JLabel getLComplemento() {
		return LComplemento;
	}

	public void setLComplemento(JLabel lComplemento) {
		LComplemento = lComplemento;
	}

	public JLabel getLNumero() {
		return LNumero;
	}

	public void setLNumero(JLabel lNumero) {
		LNumero = lNumero;
	}

	public JLabel getLBairro() {
		return LBairro;
	}

	public void setLBairro(JLabel lBairro) {
		LBairro = lBairro;
	}

	public JLabel getLCidade() {
		return LCidade;
	}

	public void setLCidade(JLabel lCidade) {
		LCidade = lCidade;
	}

	public JLabel getLCep() {
		return LCep;
	}

	public void setLCep(JLabel lCep) {
		LCep = lCep;
	}

	public JLabel getLContato() {
		return LContato;
	}

	public void setLContato(JLabel lContato) {
		LContato = lContato;
	}

	public JLabel getLEmail() {
		return LEmail;
	}

	public void setLEmail(JLabel lEmail) {
		LEmail = lEmail;
	}

	public JLabel getLCelular() {
		return LCelular;
	}

	public void setLCelular(JLabel lCelular) {
		LCelular = lCelular;
	}

	public JLabel getLTelefone() {
		return LTelefone;
	}

	public void setLTelefone(JLabel lTelefone) {
		LTelefone = lTelefone;
	}

	public JLabel getLEstado() {
		return LEstado;
	}

	public void setLEstado(JLabel lEstado) {
		LEstado = lEstado;
	}

	public JLabel getLConvenio() {
		return LConvenio;
	}

	public void setLConvenio(JLabel lConvenio) {
		LConvenio = lConvenio;
	}

	public JLabel getTConvenio() {
		return TConvenio;
	}

	public void setTConvenio(JLabel tConvenio) {
		TConvenio = tConvenio;
	}

	public JLabel getTId() {
		return TId;
	}

	public void setTId(JLabel tId) {
		TId = tId;
	}

	public JLabel getTNome() {
		return TNome;
	}

	public void setTNome(JLabel tNome) {
		TNome = tNome;
	}

	public JLabel getTCpf() {
		return TCpf;
	}

	public void setTCpf(JLabel tCpf) {
		TCpf = tCpf;
	}

	public JLabel getTDataCadastro() {
		return TDataCadastro;
	}

	public void setTDataCadastro(JLabel tDataCadastro) {
		TDataCadastro = tDataCadastro;
	}

	public JLabel getTRg() {
		return TRg;
	}

	public void setTRg(JLabel tRg) {
		TRg = tRg;
	}

	public JLabel getTDataNasc() {
		return TDataNasc;
	}

	public void setTDataNasc(JLabel tDataNasc) {
		TDataNasc = tDataNasc;
	}

	public JLabel getTObservacao() {
		return TObservacao;
	}

	public void setTObservacao(JLabel tObservacao) {
		TObservacao = tObservacao;
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

	public JLabel getTNumero() {
		return TNumero;
	}

	public void setTNumero(JLabel tNumero) {
		TNumero = tNumero;
	}

	public JLabel getTBairro() {
		return TBairro;
	}

	public void setTBairro(JLabel tBairro) {
		TBairro = tBairro;
	}

	public JLabel getTCidade() {
		return TCidade;
	}

	public void setTCidade(JLabel tCidade) {
		TCidade = tCidade;
	}

	public JLabel getTComboEstado() {
		return TComboEstado;
	}

	public void setTComboEstado(JLabel tComboEstado) {
		TComboEstado = tComboEstado;
	}

	public JLabel getTCep() {
		return TCep;
	}

	public void setTCep(JLabel tCep) {
		TCep = tCep;
	}

	public JLabel getTEmail() {
		return TEmail;
	}

	public void setTEmail(JLabel tEmail) {
		TEmail = tEmail;
	}

	public JLabel getTTelefone() {
		return TTelefone;
	}

	public void setTTelefone(JLabel tTelefone) {
		TTelefone = tTelefone;
	}

	public JLabel getTCelular() {
		return TCelular;
	}

	public void setTCelular(JLabel tCelular) {
		TCelular = tCelular;
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

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JSeparator getSepara() {
		return separa;
	}

	public void setSepara(JSeparator separa) {
		this.separa = separa;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public DetalhesPacienteListener getListener() {
		return listener;
	}

	public void setListener(DetalhesPacienteListener listener) {
		this.listener = listener;
	}

}

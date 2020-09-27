package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.DetalhesFuncionariListener;
import br.com.laboratorio.util.ConverteDadosUtil;

public class DetalhesFuncionariDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JLabel TCodigo,TCpf,TNome,TRg,TLogradouro,TComplemento,TNumero,TCidade,TBairro,TEstado;
	private JLabel TCep,TEmail,TCelular,TTelefone, LRegistro, TRegistro;
	private JLabel LCodigo, LCpf, LDados,LNome, LRg, LEndereco, LLogradouro, LComplemento;
	private JLabel LNumero, LCidade, LBairro, LUf, LCep,LContato,LEmail,LCelular,LTelefone;
	private JButton BTCancelar;
	private JFormattedTextField JCpf,JDataNasc, JDataCadastro,JCep;
	private DetalhesFuncionariListener listener;
	
	public DetalhesFuncionariDialog() {
		setModal(true);
		setBounds(100, 100, 650, 460);
		tela.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tela.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		OrganizarComponentes();
		listener = new DetalhesFuncionariListener(this);	
	}
	
	private void OrganizarComponentes(){
		LDados = new JLabel();
		LDados.setText("DADOS PESSOAIS");
		LDados.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		LDados.setBounds(10, 11, 130, 14);
		panel.add(LDados);
		
		LCodigo = new JLabel();
		LCodigo.setText("Código:");
		LCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		LCodigo.setBounds(42, 36, 59, 14);
		panel.add(LCodigo);
		
		TCodigo = new JLabel();
		TCodigo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TCodigo.setBounds(111, 33, 39, 20);
		panel.add(TCodigo);
		
		LCpf = new JLabel();
		LCpf.setText("CPF:");
		LCpf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		LCpf.setBounds(64, 67, 37, 14);
		panel.add(LCpf);
		
		TCpf = new JLabel();
		TCpf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TCpf.setBounds(111, 64, 113, 20);
		panel.add(TCpf);
		JCpf = new JFormattedTextField(ConverteDadosUtil.FormataCPF());
		
		LNome = new JLabel();
		LNome.setText("Nome:");
		LNome.setHorizontalAlignment(SwingConstants.RIGHT);
		LNome.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LNome.setBounds(52, 94, 49, 14);
		panel.add(LNome);
		
		TNome = new JLabel();
		TNome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TNome.setBounds(111, 91, 337, 20);
		panel.add(TNome);
		
		TRegistro = new JLabel();
		TRegistro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TRegistro.setBounds(458, 30, 165, 20);
		panel.add(TRegistro);
		
		LRegistro = new JLabel();
		LRegistro.setText("Registro:");
		LRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		LRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LRegistro.setBounds(364, 33, 84, 14);
		panel.add(LRegistro);
		
		LRg = new JLabel();
		LRg.setText("RG:");
		LRg.setHorizontalAlignment(SwingConstants.RIGHT);
		LRg.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LRg.setBounds(411, 64, 37, 14);
		panel.add(LRg);
		
		TRg = new JLabel();
		TRg.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		TRg.setBounds(458, 61, 113, 20);
		panel.add(TRg);
		
		LEndereco = new JLabel();
		LEndereco.setText("ENDEREÇO");
		LEndereco.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		LEndereco.setBounds(10, 122, 130, 14);
		panel.add(LEndereco);
		
		LLogradouro = new JLabel();
		LLogradouro.setText("Logradouro:");
		LLogradouro.setHorizontalAlignment(SwingConstants.RIGHT);
		LLogradouro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LLogradouro.setBounds(10, 150, 91, 14);		
		panel.add(LLogradouro);
		
		TLogradouro = new JLabel();
		TLogradouro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TLogradouro.setBounds(111, 147, 340, 20);
		panel.add(TLogradouro);
		
		LComplemento = new JLabel();
		LComplemento.setText("Complemento:");
		LComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		LComplemento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LComplemento.setBounds(10, 175, 91, 14);
		panel.add(LComplemento);
		
		TComplemento = new JLabel();
		TComplemento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TComplemento.setBounds(111, 173, 340, 20);
		panel.add(TComplemento);
		
		LNumero = new JLabel();
		LNumero.setText("Número:");
		LNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		LNumero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LNumero.setBounds(20, 203, 81, 14);
		panel.add(LNumero);
		
		TNumero = new JLabel();
		TNumero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TNumero.setBounds(111, 200, 59, 20);
		panel.add(TNumero);
		
		LCidade = new JLabel();
		LCidade.setText("Cidade:");
		LCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		LCidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCidade.setBounds(20, 228, 81, 14);
		panel.add(LCidade);
		
		TCidade = new JLabel();
		TCidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TCidade.setBounds(111, 225, 198, 20);
		panel.add(TCidade);
		
		LBairro = new JLabel();
		LBairro.setText("Bairro:");
		LBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		LBairro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LBairro.setBounds(332, 203, 71, 14);
		panel.add(LBairro);
		
		TBairro = new JLabel();
		TBairro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TBairro.setBounds(413, 200, 187, 20);
		panel.add(TBairro);
		
		LUf = new JLabel();
		LUf.setText("UF:");
		LUf.setHorizontalAlignment(SwingConstants.RIGHT);
		LUf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LUf.setBounds(364, 228, 39, 14);
		panel.add(LUf);
		
		TEstado = new JLabel();
		TEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TEstado.setBounds(413, 225, 187, 20);
		panel.add(TEstado);
				
		LCep = new JLabel();
		LCep.setText("CEP:");
		LCep.setHorizontalAlignment(SwingConstants.RIGHT);
		LCep.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCep.setBounds(20, 259, 81, 14);
		panel.add(LCep);
		
		TCep = new JLabel();
		TCep.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TCep.setBounds(111, 256, 81, 20);
		panel.add(TCep);
		JCep = new JFormattedTextField(ConverteDadosUtil.FormataCep());
		
		LContato = new JLabel();
		LContato.setText("CONTATO");
		LContato.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		LContato.setBounds(10, 284, 130, 14);
		panel.add(LContato);
		
		LEmail = new JLabel();
		LEmail.setText("E-mail:");
		LEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		LEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LEmail.setBounds(20, 312, 81, 14);
		panel.add(LEmail);
		
		TEmail = new JLabel();
		TEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TEmail.setBounds(111, 309, 292, 20);
		panel.add(TEmail);
		
		LCelular = new JLabel();
		LCelular.setText("Celular:");
		LCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		LCelular.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LCelular.setBounds(20, 340, 81, 14);
		panel.add(LCelular);
		
		TCelular = new JLabel();
		TCelular.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TCelular.setBounds(111, 337, 113, 20);
		panel.add(TCelular);
		
		TTelefone = new JLabel();
		TTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		TTelefone.setBounds(411, 337, 113, 20);
		panel.add(TTelefone);
		
		LTelefone = new JLabel();
		LTelefone.setText("Telefone:");
		LTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		LTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		LTelefone.setBounds(322, 340, 81, 14);
		panel.add(LTelefone);
		
		BTCancelar = new JButton();
		BTCancelar.setText("Voltar");
		BTCancelar.setBounds(269, 388, 89, 23);
		panel.add(BTCancelar);
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


	public JLabel getTCodigo() {
		return TCodigo;
	}


	public void setTCodigo(JLabel tCodigo) {
		TCodigo = tCodigo;
	}


	public JLabel getTCpf() {
		return TCpf;
	}


	public void setTCpf(JLabel tCpf) {
		TCpf = tCpf;
	}


	public JLabel getTNome() {
		return TNome;
	}


	public void setTNome(JLabel tNome) {
		TNome = tNome;
	}


	public JLabel getTRg() {
		return TRg;
	}


	public void setTRg(JLabel tRg) {
		TRg = tRg;
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


	public JLabel getTEstado() {
		return TEstado;
	}


	public void setTEstado(JLabel tEstado) {
		TEstado = tEstado;
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


	public JLabel getTCelular() {
		return TCelular;
	}


	public void setTCelular(JLabel tCelular) {
		TCelular = tCelular;
	}


	public JLabel getTTelefone() {
		return TTelefone;
	}


	public void setTTelefone(JLabel tTelefone) {
		TTelefone = tTelefone;
	}


	public JLabel getLCodigo() {
		return LCodigo;
	}


	public void setLCodigo(JLabel lCodigo) {
		LCodigo = lCodigo;
	}


	public JLabel getLCpf() {
		return LCpf;
	}


	public void setLCpf(JLabel lCpf) {
		LCpf = lCpf;
	}


	public JLabel getLDados() {
		return LDados;
	}


	public void setLDados(JLabel lDados) {
		LDados = lDados;
	}


	public JLabel getLNome() {
		return LNome;
	}


	public void setLNome(JLabel lNome) {
		LNome = lNome;
	}


	public JLabel getLRg() {
		return LRg;
	}


	public void setLRg(JLabel lRg) {
		LRg = lRg;
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


	public JLabel getLCidade() {
		return LCidade;
	}


	public void setLCidade(JLabel lCidade) {
		LCidade = lCidade;
	}


	public JLabel getLBairro() {
		return LBairro;
	}


	public void setLBairro(JLabel lBairro) {
		LBairro = lBairro;
	}


	public JLabel getLUf() {
		return LUf;
	}


	public void setLUf(JLabel lUf) {
		LUf = lUf;
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


	public JButton getBTCancelar() {
		return BTCancelar;
	}


	public void setBTCancelar(JButton bTCancelar) {
		BTCancelar = bTCancelar;
	}

	public DetalhesFuncionariListener getListener() {
		return listener;
	}

	public void setListener(DetalhesFuncionariListener listener) {
		this.listener = listener;
	}


	public JLabel getLRegistro() {
		return LRegistro;
	}


	public void setLRegistro(JLabel lRegistro) {
		LRegistro = lRegistro;
	}


	public JLabel getTRegistro() {
		return TRegistro;
	}


	public void setTRegistro(JLabel tRegistro) {
		TRegistro = tRegistro;
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



}

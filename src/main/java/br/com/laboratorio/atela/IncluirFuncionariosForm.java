package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.IncluirFuncionarioListener;
import br.com.laboratorio.util.ConverteDadosUtil;
import br.com.laboratorio.util.ListasUtil;
import br.com.laboratorio.util.SomenteNumerosUtil;

public class IncluirFuncionariosForm extends JDialog {
	private IncluirFuncionarioListener listener;
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JLabel LId, LNome, LCpf, LRg;
	private JLabel LIndentif, LEndereco, LLogradouro, LComplemento;
	private JLabel LNumero, LBairro, LCidade, LCep, LContato, LEmail, LCelular, LTelefone, LEstado;
	private JTextField TId, TNome, TRg, TLogradouro, TComplemento, TNumero;
	private JTextField TBairro, TCidade, TEmail, TTelefone, TCelular, TCoren;
	private JFormattedTextField JCpf, JCep;
	private JButton BTGravar, BTCancelar;
	private JComboBox ComboEstado, comboCoren,comboCorenEst;
	private SomenteNumerosUtil soNumeros;


	
	public IncluirFuncionariosForm() {
		setTitle("Inserir Dados de Funcionário");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 649, 465);
		
		tela.setLayout(null);		
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		DadosFuncionario();
		InicializaCompomentes();
		listener = new IncluirFuncionarioListener(this);
	}
	
	private void DadosFuncionario(){
		LIndentif = new JLabel();
		LIndentif.setText("DADOS PESSOAIS");
		LIndentif.setBounds(15,10,300,20);
		LIndentif.setFont(new Font("Calibri", Font.BOLD, 13));
		LIndentif.setForeground(Color.black);
									
		LId = new JLabel();
		LId.setText("Código:");
		LId.setBounds(15,41,50,20);
		LId.setFont(new Font("Arial",Font.BOLD,11));
			
		TId = new JTextField();
		TId.setBounds(61,42,50,20);
		TId.setBackground(new Color(255,255,204));
		TId.setFont(new Font("Arial",Font.BOLD,10));
		TId.setForeground(Color.black);
		TId.setEditable(false);
		
		comboCoren = new JComboBox();
		comboCoren.setBounds(370, 42, 74, 20);
		comboCoren.setModel(new DefaultComboBoxModel(new Vector(ListasUtil.Coren())));
		
		TCoren = new JTextField();
		TCoren.setBounds(448, 42, 120, 22);
		TCoren.setColumns(10);
		
		comboCorenEst = new JComboBox();
		comboCorenEst.setBounds(571, 42, 46, 20);
		comboCorenEst.setModel(new DefaultComboBoxModel(new Vector(ListasUtil.EstadosAbrev())));		
			
		LCpf = new JLabel();
		LCpf.setText("*CPF:");
		LCpf.setBounds(15, 73, 50, 20);	
		LCpf.setFont(new Font("Arial" , Font.BOLD,11));;
		
		JCpf = new JFormattedTextField(ConverteDadosUtil.FormataCPF());
		JCpf.setBounds(61,73,140,19);		
			
		LRg = new JLabel();			
		LRg.setText("*RG:");
		LRg.setBounds(419,73,29,20);
		LRg.setFont(new Font("Arial" , Font.BOLD,11));;
		
		TRg = new JTextField();
		TRg.setBounds(448,74,169,19);
		TRg.setFont(new Font("Arial",Font.BOLD,10));
		TRg.addKeyListener(soNumeros);

		LNome = new JLabel();	
		LNome.setText("*Nome:");
		LNome.setBounds(15,104,602,20);
		LNome.setFont(new Font("Arial" , Font.BOLD,11));;
		
		TNome = new JTextField();
		TNome.setBounds(61,105,556,19);
		TNome.setFont(new Font("Arial",Font.BOLD,10));		
			
		LEndereco = new JLabel();
		LEndereco.setText("ENDEREÇO");
		LEndereco.setFont(new Font("Calibri", Font.BOLD, 13));
		LEndereco.setBounds(15, 135, 64, 14);
		
		LLogradouro = new JLabel();
		LLogradouro.setText("Logradouro: ");
		LLogradouro.setFont(new Font("Arial", Font.BOLD, 11));
		LLogradouro.setBounds(15, 160, 84, 14);
			
		TLogradouro = new JTextField();
		TLogradouro.setBounds(111, 157, 506, 20);
		TLogradouro.setColumns(10);
				
		LComplemento = new JLabel();
		LComplemento.setText("Complemento: ");
		LComplemento.setFont(new Font("Arial", Font.BOLD, 11));
		LComplemento.setBounds(15, 191, 100, 14);
		
		TComplemento = new JTextField();
		TComplemento.setColumns(10);
		TComplemento.setBounds(111, 188, 506, 20);
				
		LNumero = new JLabel();
		LNumero.setText("Numero:");
		LNumero.setFont(new Font("Arial", Font.BOLD, 11));
		LNumero.setBounds(15, 222, 58, 14);
		
		TNumero = new JTextField();
		TNumero.setBounds(111, 219, 106, 20);
		TNumero.setColumns(10);
		TNumero.addKeyListener(soNumeros);
				
		LBairro = new JLabel();
		LBairro.setText("Bairro: ");
		LBairro.setFont(new Font("Arial", Font.BOLD, 11));
		LBairro.setBounds(363, 219, 46, 14);
		
		TBairro = new JTextField();
		TBairro.setBounds(419, 216, 198, 20);
		TBairro.setColumns(10);
				
		LCidade = new JLabel();
		LCidade.setText("Cidade: ");
		LCidade.setFont(new Font("Arial", Font.BOLD, 11));
		LCidade.setBounds(15, 247, 46, 14);
		
		TCidade = new JTextField();
		TCidade.setBounds(111, 244, 208, 20);
		TCidade.setColumns(10);
	
		LEstado = new JLabel();
		LEstado.setText("UF: ");
		LEstado.setBounds(419, 250, 46, 14);
			
		ComboEstado = new JComboBox();
		ComboEstado.setBounds(475, 247, 142, 20);
		ComboEstado.setModel(new DefaultComboBoxModel(new Vector(ListasUtil.Estados())));
		
		LCep = new JLabel();			
		LCep.setText("CEP:");
		LCep.setFont(new Font("Arial", Font.BOLD, 11));
		LCep.setBounds(15, 278, 35, 14);
			
		JCep = new JFormattedTextField(ConverteDadosUtil.FormataCep());
		JCep.setBounds(111, 275, 86, 20);

		LContato = new JLabel();		
		LContato.setText("CONTATO");
		LContato.setFont(new Font("Calibri", Font.BOLD, 13));
		LContato.setBounds(15, 317, 72, 14);
		
		LEmail = new JLabel();
		LEmail.setText("Email:");
		LEmail.setFont(new Font("Arial", Font.BOLD, 11));
		LEmail.setBounds(50, 334, 46, 14);
			
		TEmail = new JTextField();
		TEmail.setBounds(109, 331, 252, 20);
		TEmail.setColumns(10);
		
		LCelular = new JLabel();
		LCelular.setText("Celular:");
		LCelular.setFont(new Font("Arial", Font.BOLD, 11));
		LCelular.setBounds(404, 359, 46, 14);
		
		TCelular = new JTextField();
		TCelular.setBounds(456, 359, 161, 20);
		TCelular.setColumns(10);
		
		LTelefone = new JLabel();
		LTelefone.setText("Telefone:");
		LTelefone.setFont(new Font("Arial", Font.BOLD, 11));
		LTelefone.setBounds(394, 334, 72, 14);
			
		TTelefone = new JTextField();
		TTelefone.setBounds(456, 331, 161, 20);
		TTelefone.setColumns(10);	
	
		BTGravar = new JButton();
		BTGravar.setText("Gravar");
		BTGravar.setFont(new Font("Calibri", Font.PLAIN, 12));
		BTGravar.setBounds(222, 403, 89, 23);
		
		BTCancelar = new JButton();
		BTCancelar.setText("Cancelar");
		BTCancelar.setFont(new Font("Calibri", Font.PLAIN, 12));
		BTCancelar.setBounds(321, 403, 89, 23);
	}
	
	
	
	//classe que adiciona os componentes criados no metodo anterior à tela geral
	public void InicializaCompomentes(){
		tela.add(this.TId);
		tela.add(this.TNome );
		tela.add(this.TRg);
		tela.add(this.LId);
		tela.add(this.LNome);
		tela.add(this.LRg);
		tela.add(this.LIndentif);	
		tela.add(this.JCpf);
		tela.add(this.JCep);
		tela.add(this.LEndereco);
		tela.add(this.LLogradouro);
		tela.add(this.TLogradouro);
		tela.add(this.LComplemento);
		tela.add(this.TComplemento);
		tela.add(this.LNumero);
		tela.add(this.LBairro);
		tela.add(this.LCidade);
		tela.add(this.LCep);
		tela.add(this.TNumero);
		tela.add(this.TBairro);
		tela.add(this.TCidade);
		tela.add(this.LContato);
		tela.add(this.LCpf);
		tela.add(this.LEmail);
		tela.add(this.LCelular);
		tela.add(this.LTelefone);
		tela.add(this.TEmail);
		tela.add(this.TTelefone);
		tela.add(this.TCelular);
		tela.add(this.BTGravar);
		tela.add(this.BTCancelar);
		tela.add(this.ComboEstado);
		tela.add(this.comboCoren);
		tela.add(this.TCoren);
		tela.add(comboCorenEst);
		tela.add(this.LEstado);
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


	public JTextField getTId() {
		return TId;
	}


	public void setTId(JTextField tId) {
		TId = tId;
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



	public JTextField getTNumero() {
		return TNumero;
	}


	public void setTNumero(JTextField tNumero) {
		TNumero = tNumero;
	}


	public JTextField getTBairro() {
		return TBairro;
	}


	public void setTBairro(JTextField tBairro) {
		TBairro = tBairro;
	}


	public JTextField getTCidade() {
		return TCidade;
	}

	public void setTCidade(JTextField tCidade) {
		TCidade = tCidade;
	}


	public JTextField getTEmail() {
		return TEmail;
	}


	public void setTEmail(JTextField tEmail) {
		TEmail = tEmail;
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

	public JFormattedTextField getJCpf() {
		return JCpf;
	}

	public void setJCpf(JFormattedTextField jCpf) {
		JCpf = jCpf;
	}


	public JFormattedTextField getJCep() {
		return JCep;
	}

	public void setJCep(JFormattedTextField jCep) {
		JCep = jCep;
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

	public JComboBox getComboEstado() {
		return ComboEstado;
	}

	public void setComboEstado(JComboBox comboEstado) {
		ComboEstado = comboEstado;
	}

	public IncluirFuncionarioListener getListener() {
		return listener;
	}

	public JTextField getTCoren() {
		return TCoren;
	}

	public void setTCoren(JTextField tCoren) {
		TCoren = tCoren;
	}

	public JComboBox getComboCoren() {
		return comboCoren;
	}

	public void setComboCoren(JComboBox comboCoren) {
		this.comboCoren = comboCoren;
	}

	public JComboBox getComboCorenEst() {
		return comboCorenEst;
	}

	public void setComboCorenEst(JComboBox comboCorenEst) {
		this.comboCorenEst = comboCorenEst;
	}
	
}

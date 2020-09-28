package br.com.laboratorio.atela;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class IncluirProfissionalExecutanteTela extends JDialog {
	private JTextField TCodigo, TNome, TCep, TCidade, TBairro, TLogradouro, TNumero, TComplemento, TFixo;
	private JTextField TCel, TEmail, TNumeroCon;
	private JLabel LCodigo, LConselho, LUfCon, LNome, lblAssinaturaDigital, LNumeroCon, LCep, LUf;
	private JLabel LCidade, LBairro, LLogradouro, LNumero, LComplemento, LFixo, LCel, LEmail;
	private JRadioButton radiodr, rdbtnDra, radionenhum;
	private JLayeredPane layer1, layer2;
	private Panel painelassinatura;
	private JTabbedPane tabbedPane;
	private JComboBox<String> comboconselho, comboufcons, combouf;
	private JButton BTAdicionar, BTExcluir;


	public static void main(String[] args) {
		try {
			IncluirProfissionalExecutanteTela dialog = new IncluirProfissionalExecutanteTela();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IncluirProfissionalExecutanteTela() {
		setBackground(SystemColor.inactiveCaption);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gestor\\Desktop\\nuclear.png"));
		setTitle("Profissional Executante");
		setBounds(100, 100, 589, 293);
		getContentPane().setLayout(null);
		
		
		this.MontarComponentes();
	}
	
	private void MontarComponentes(){
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 553, 198);
		getContentPane().add(tabbedPane);
		
		layer1 = new JLayeredPane();
		tabbedPane.addTab("Dados Principais", null, layer1, null);
		
		layer2 = new JLayeredPane();
		tabbedPane.addTab("Endere\u00E7o", null, layer2, null);
		
		LCodigo = new JLabel("C\u00F3digo");
		LCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCodigo.setBounds(10, 21, 46, 14);
		layer1.add(LCodigo);
		
		TCodigo = new JTextField();
		TCodigo.setBounds(10, 37, 46, 20);
		layer1.add(TCodigo);
		TCodigo.setColumns(10);
		
		LConselho = new JLabel("Conselho");
		LConselho.setFont(new Font("Tahoma", Font.BOLD, 11));
		LConselho.setBounds(66, 21, 62, 14);
		layer1.add(LConselho);
		
		comboconselho = new JComboBox<String>();
		comboconselho.setModel(new DefaultComboBoxModel(new String[] {"CRM", "CRN", "CRO"}));
		comboconselho.setBounds(66, 37, 62, 20);
		layer1.add(comboconselho);
		
		LUfCon = new JLabel("UF");
		LUfCon.setFont(new Font("Tahoma", Font.BOLD, 11));
		LUfCon.setBounds(241, 21, 57, 14);
		layer1.add(LUfCon);
		
		comboufcons = new JComboBox<String>();
		comboufcons.setModel(new DefaultComboBoxModel(new String[] {"AM", "BA", "GO", "SP", "RJ", "TO"}));
		comboufcons.setBounds(241, 37, 57, 20);
		layer1.add(comboufcons);
		
		LNome = new JLabel("Nome do Profissional");
		LNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		LNome.setBounds(10, 84, 168, 14);
		layer1.add(LNome);
		
		TNome = new JTextField();
		TNome.setBounds(10, 98, 242, 20);
		layer1.add(TNome);
		TNome.setColumns(10);
		
		lblAssinaturaDigital = new JLabel("Assinatura Digital");
		lblAssinaturaDigital.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAssinaturaDigital.setBounds(368, 21, 114, 14);
		layer1.add(lblAssinaturaDigital);
		
		painelassinatura = new Panel();
		painelassinatura.setBounds(314, 37, 213, 82);
		layer1.add(painelassinatura);
		
		radiodr = new JRadioButton("Dr.");
		radiodr.setBackground(Color.WHITE);
		radiodr.setBounds(10, 59, 84, 23);
		layer1.add(radiodr);
		
		rdbtnDra = new JRadioButton("Dra.");
		rdbtnDra.setBackground(Color.WHITE);
		rdbtnDra.setBounds(96, 59, 62, 23);
		layer1.add(rdbtnDra);
		
		radionenhum = new JRadioButton("Nenhum");
		radionenhum.setBackground(Color.WHITE);
		radionenhum.setBounds(160, 60, 92, 23);
		layer1.add(radionenhum);
		
		BTAdicionar = new JButton("Adicionar");
		BTAdicionar.setBounds(314, 125, 89, 23);
		layer1.add(BTAdicionar);
		
		BTExcluir = new JButton("Excluir");
		BTExcluir.setBounds(438, 125, 89, 23);
		layer1.add(BTExcluir);
		
		TNumeroCon = new JTextField();
		TNumeroCon.setColumns(10);
		TNumeroCon.setBounds(138, 37, 93, 20);
		layer1.add(TNumeroCon);
		
		LNumeroCon = new JLabel("N\u00FAmero");
		LNumeroCon.setFont(new Font("Tahoma", Font.BOLD, 11));
		LNumeroCon.setBounds(138, 21, 93, 14);
		layer1.add(LNumeroCon);
				
		LCep = new JLabel("CEP");
		LCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCep.setBounds(10, 11, 46, 14);
		layer2.add(LCep);
		
		TCep = new JTextField();
		TCep.setColumns(10);
		TCep.setBounds(10, 26, 106, 20);
		layer2.add(TCep);
		
		LUf = new JLabel("UF");
		LUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		LUf.setBounds(119, 11, 21, 14);
		layer2.add(LUf);
		
		combouf = new JComboBox<String>();
		combouf.setModel(new DefaultComboBoxModel(new String[] {"AM", "BA", "GO", "MT", "PA", "TO", "SP"}));
		combouf.setBounds(119, 26, 62, 20);
		layer2.add(combouf);
		
		LCidade = new JLabel("Cidade");
		LCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCidade.setBounds(185, 11, 46, 14);
		layer2.add(LCidade);
		
		TCidade = new JTextField();
		TCidade.setColumns(10);
		TCidade.setBounds(185, 26, 353, 20);
		layer2.add(TCidade);
		
		LBairro = new JLabel("Bairro");
		LBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBairro.setBounds(10, 50, 46, 14);
		layer2.add(LBairro);
		
		TBairro = new JTextField();
		TBairro.setColumns(10);
		TBairro.setBounds(10, 65, 171, 20);
		layer2.add(TBairro);
		
		LLogradouro = new JLabel("Logradouro");
		LLogradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LLogradouro.setBounds(185, 50, 106, 14);
		layer2.add(LLogradouro);
		
		TLogradouro = new JTextField();
		TLogradouro.setColumns(10);
		TLogradouro.setBounds(185, 65, 353, 20);
		layer2.add(TLogradouro);
		
		LNumero = new JLabel("N\u00FAmero");
		LNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		LNumero.setBounds(10, 90, 92, 14);
		layer2.add(LNumero);
		
		TNumero = new JTextField();
		TNumero.setColumns(10);
		TNumero.setBounds(10, 105, 106, 20);
		layer2.add(TNumero);
		
		LComplemento = new JLabel("Complemento");
		LComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		LComplemento.setBounds(119, 90, 92, 14);
		layer2.add(LComplemento);
		
		TComplemento = new JTextField();
		TComplemento.setColumns(10);
		TComplemento.setBounds(119, 105, 419, 20);
		layer2.add(TComplemento);
		
		LFixo = new JLabel("Telefone Fixo");
		LFixo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LFixo.setBounds(10, 128, 92, 14);
		layer2.add(LFixo);
		
		TFixo = new JTextField();
		TFixo.setColumns(10);
		TFixo.setBounds(10, 142, 115, 20);
		layer2.add(TFixo);
		
		LCel = new JLabel("Telefone Cel");
		LCel.setFont(new Font("Tahoma", Font.BOLD, 11));
		LCel.setBounds(130, 128, 81, 14);
		layer2.add(LCel);
		
		TCel = new JTextField();
		TCel.setColumns(10);
		TCel.setBounds(130, 142, 115, 20);
		layer2.add(TCel);
		
		LEmail = new JLabel("E-mail");
		LEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		LEmail.setBounds(248, 128, 46, 14);
		layer2.add(LEmail);
		
		TEmail = new JTextField();
		TEmail.setColumns(10);
		TEmail.setBounds(248, 142, 290, 20);
		layer2.add(TEmail);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 220, 551, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
              System.exit(0);
			{
				JButton BTGravar = new JButton("Gravar");
				BTGravar.setActionCommand("OK");
				buttonPane.add(BTGravar);
				getRootPane().setDefaultButton(BTGravar);
			}
			{
				JButton BTCancelar = new JButton("Cancel");
				BTCancelar.setActionCommand("Cancel");
				buttonPane.add(BTCancelar);
			}
			
		}
	}
}

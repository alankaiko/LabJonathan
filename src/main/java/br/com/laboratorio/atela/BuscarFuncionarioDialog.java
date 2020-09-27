package br.com.laboratorio.atela;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.BuscarFuncionarioListener;
import br.com.laboratorio.listeners.RadioListenerFuncionario;

public class BuscarFuncionarioDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JTextField textoBuscar;
	private JButton ok,cancelar, buscar;
	private JRadioButton buscaCpf, buscaRg, buscaNome, buscaCodigo;
	private JLabel buscarUsuario;
	private ButtonGroup botaoGrupo= new ButtonGroup();
	private JScrollPane scrollPane;
	private JTable table;
	private BuscarFuncionarioListener listener;
	private RadioListenerFuncionario radioFuncionario;


	
	public BuscarFuncionarioDialog() {
		setTitle("Buscar Clientes");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 620, 400);
		
		tela.setLayout(null);		
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 100, 560, 220);
		scrollPane.getViewport().setBackground(Color.WHITE);
		tela.add(scrollPane);
		table = new JTable();
		
		
		OrganizaDados();
		listener = new BuscarFuncionarioListener(this);
		radioFuncionario = new RadioListenerFuncionario(this);
	}
	
	
	
	public void OrganizaDados(){
		buscarUsuario = new JLabel();
		buscarUsuario.setText("Escolha uma Opção: ");
		buscarUsuario.setBounds(15,10,150,20);
		tela.add(this.buscarUsuario);
	
		buscaCpf = new JRadioButton();
		buscaCpf.setText("CPF");
		buscaCpf.setFont(new Font("Arial", Font.PLAIN, 13));
		buscaCpf.setBounds(201, 40, 53, 23);
		botaoGrupo.add(buscaCpf);
		tela.add(this.buscaCpf);
		
		buscaRg = new JRadioButton();
		buscaRg.setText("RG");
		buscaRg.setFont(new Font("Arial", Font.PLAIN, 13));
		buscaRg.setBounds(154, 40, 53, 23);
		botaoGrupo.add(buscaRg);
		tela.add(this.buscaRg);
		
		buscaNome = new JRadioButton();
		buscaNome.setText("Nome");
		buscaNome.setFont(new Font("Arial", Font.PLAIN, 13));
		buscaNome.setBounds(82, 40, 60, 23);
		botaoGrupo.add(buscaNome);
		tela.add(this.buscaNome);		
		
		buscaCodigo = new JRadioButton();
		buscaCodigo.setText("Código");
		buscaCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
		buscaCodigo.setBounds(15, 40, 65, 23);
		botaoGrupo.add(buscaCodigo);
		tela.add(this.buscaCodigo);
	
		textoBuscar = new JTextField();
		textoBuscar.setBounds(15,70,260,20);
		textoBuscar.setFont(new Font("Arial",Font.BOLD,10));
		textoBuscar.setForeground(Color.black);	
		tela.add(this.textoBuscar);

		buscar = new JButton();
		buscar.setText("Buscar");
		buscar.setBounds(300,68,125,20);
		tela.add(this.buscar);

		ok = new JButton();
		ok.setText("OK");
		ok.setBounds(150,340,125,20);
		tela.add(this.ok);
	
		cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setBounds(290,340,125,20);	
		tela.add(this.cancelar);
	}




	public JButton getOk() {
		return ok;
	}


	public void setOk(JButton ok) {
		this.ok = ok;
	}


	public JButton getCancelar() {
		return cancelar;
	}


	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}


	public JButton getBuscar() {
		return buscar;
	}


	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public JRadioButton getBuscaCpf() {
		return buscaCpf;
	}


	public void setBuscaCpf(JRadioButton buscaCpf) {
		this.buscaCpf = buscaCpf;
	}


	public JRadioButton getBuscaRg() {
		return buscaRg;
	}


	public void setBuscaRg(JRadioButton buscaRg) {
		this.buscaRg = buscaRg;
	}


	public JRadioButton getBuscaNome() {
		return buscaNome;
	}


	public void setBuscaNome(JRadioButton buscaNome) {
		this.buscaNome = buscaNome;
	}


	public JRadioButton getBuscaCodigo() {
		return buscaCodigo;
	}


	public void setBuscaCodigo(JRadioButton buscaCodigo) {
		this.buscaCodigo = buscaCodigo;
	}


	public JTextField getTextoBuscar() {
		return textoBuscar;
	}


	public void setTextoBuscar(JTextField textoBuscar) {
		this.textoBuscar = textoBuscar;
	}

	public BuscarFuncionarioListener getListener() {
		return listener;
	}
	public void setListener(BuscarFuncionarioListener listener) {
		this.listener = listener;
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


	public JLabel getBuscarUsuario() {
		return buscarUsuario;
	}


	public void setBuscarUsuario(JLabel buscarUsuario) {
		this.buscarUsuario = buscarUsuario;
	}


	public ButtonGroup getBotaoGrupo() {
		return botaoGrupo;
	}


	public void setBotaoGrupo(ButtonGroup botaoGrupo) {
		this.botaoGrupo = botaoGrupo;
	}


	public RadioListenerFuncionario getRadioFuncionario() {
		return radioFuncionario;
	}


	public void setRadioFuncionario(RadioListenerFuncionario radioFuncionario) {
		this.radioFuncionario = radioFuncionario;
	}
	
}

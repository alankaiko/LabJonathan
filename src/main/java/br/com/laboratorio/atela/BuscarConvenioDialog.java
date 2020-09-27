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

import br.com.laboratorio.listeners.BuscarConvenioListener;
import br.com.laboratorio.listeners.RadioListenerConvenio;

public class BuscarConvenioDialog extends JDialog {
	private JPanel panel = new JPanel();
	private Container tela = getContentPane();
	private JTextField textoBuscar;
	private JButton ok,cancelar, buscar;
	private JRadioButton buscaId, buscaNome;
	private JLabel buscarUsuario;
	private ButtonGroup botaoGrupo= new ButtonGroup();
	private JScrollPane scrollPane;
	private JTable table;
	private BuscarConvenioListener listener;
	private RadioListenerConvenio radioListener;
	
	
	
	public BuscarConvenioDialog() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 514, 344);
		
		tela.setLayout(null);		
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		OrganizaDados();

		listener = new BuscarConvenioListener(this);
		radioListener = new RadioListenerConvenio(this);
	}
	
	
	private void OrganizaDados(){
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 100, 478, 177);
		scrollPane.getViewport().setBackground(Color.WHITE);
		tela.add(scrollPane);
		
		table = new JTable();
		
		
		buscarUsuario = new JLabel();
		buscarUsuario.setText("Escolha uma Opção: ");
		buscarUsuario.setBounds(15,10,150,20);
		tela.add(this.buscarUsuario);
	
		buscaId = new JRadioButton();
		buscaId.setText("Código");
		buscaId.setFont(new Font("Arial", Font.PLAIN, 13));
		buscaId.setBounds(15, 40, 84, 23);
		tela.add(this.buscaId);
		botaoGrupo.add(buscaId);
		
		buscaNome = new JRadioButton();
		buscaNome.setText("Convenio");
		buscaNome.setFont(new Font("Arial", Font.PLAIN, 13));
		buscaNome.setBounds(106, 40, 90, 23);
		tela.add(this.buscaNome);
		botaoGrupo.add(buscaNome);
		
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
		ok.setBounds(118,288,125,20);
		tela.add(this.ok);
	
		cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setBounds(253,288,125,20);	
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


	

	public JRadioButton getBuscaId() {
		return buscaId;
	}


	public void setBuscaId(JRadioButton buscaId) {
		this.buscaId = buscaId;
	}


	public JRadioButton getBuscaNome() {
		return buscaNome;
	}
	
	public void setBuscaNome(JRadioButton buscaNome) {
		this.buscaNome = buscaNome;
	}


	public JTextField getTextoBuscar() {
		return textoBuscar;
	}


	public void setTextoBuscar(JTextField textoBuscar) {
		this.textoBuscar = textoBuscar;
	}
	
	public BuscarConvenioListener getListener() {
		return listener;
	}
	public void setListener(BuscarConvenioListener listener) {
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


	public RadioListenerConvenio getRadioListener() {
		return radioListener;
	}


	public void setRadioListener(RadioListenerConvenio radioListener) {
		this.radioListener = radioListener;
	}

}

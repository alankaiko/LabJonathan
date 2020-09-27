package br.com.laboratorio.atela;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.laboratorio.listeners.GerenciarFuncionarioListener;

public class GerenciaTelaFuncionario extends JDialog {
	private JPanel panel = new JPanel();
	private JTable table;
	private JButton detalhes, codigo, buscar, modificar, incluir, excluir, fim;
	private Container tela= getContentPane();
	private JScrollPane scrollPane;
	private GerenciarFuncionarioListener listener;
	
	
	public GerenciaTelaFuncionario() {
		setTitle("Cadastro de Funcionarios");
		setModal(true);
		setBounds(100, 100, 700, 480);
		setResizable(false);
		tela.setLayout(null);
		tela.add(panel, BorderLayout.CENTER);
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26,12,472,412);
		tela.add(scrollPane);	
		table = new JTable();
		
		DadosConvenio();
		listener = new GerenciarFuncionarioListener(this);
	}

	public void DadosConvenio() {
		detalhes = new JButton();
		detalhes.setText("Detalhes");
		detalhes.setBounds(525,11,125,20);
		tela.add(detalhes);
		
		codigo = new JButton();
		codigo.setText("Código");
		codigo.setBounds(525,35,125,20);
		tela.add(codigo);
		
		buscar = new JButton();
		buscar.setText("Buscar");
		buscar.setBounds(525,58,125,20);		
		tela.add(buscar);
		
		
		modificar = new JButton();
		modificar.setText("Modificar");
		modificar.setBounds(525,81,125,20);
		tela.add(modificar);
		
		incluir = new JButton();
		incluir.setText("Incluir");
		incluir.setBounds(525,104,125,20);
		tela.add(incluir);
		
		excluir = new JButton();
		excluir.setText("Excluir");
		excluir.setBounds(525,127,125,20);
		tela.add(excluir);
		
		fim = new JButton();
		fim.setText("Fim");
		fim.setBounds(525,150,125,20);
		tela.add(fim);
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JButton getDetalhes() {
		return detalhes;
	}


	public void setDetalhes(JButton detalhes) {
		this.detalhes = detalhes;
	}


	public JButton getCodigo() {
		return codigo;
	}


	public void setCodigo(JButton codigo) {
		this.codigo = codigo;
	}


	public JButton getBuscar() {
		return buscar;
	}


	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}


	public JButton getModificar() {
		return modificar;
	}


	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}


	public JButton getIncluir() {
		return incluir;
	}


	public void setIncluir(JButton incluir) {
		this.incluir = incluir;
	}


	public JButton getExcluir() {
		return excluir;
	}


	public void setExcluir(JButton excluir) {
		this.excluir = excluir;
	}


	public JButton getFim() {
		return fim;
	}


	public void setFim(JButton fim) {
		this.fim = fim;
	}


	public Container getTela() {
		return tela;
	}


	public void setTela(Container tela) {
		this.tela = tela;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


}

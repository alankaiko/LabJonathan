package br.com.laboratorio.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.laboratorio.modelo.Usuario;

public class TabelaDeUsuariosUtil extends AbstractTableModel{
	private String[] colunas = new String[] { "LOGIN", "NOME USUÁRIO"};
	private List<Usuario> linhas;
    private static final int LOGIN = 0;
    private static final int NOME = 1;
	 
    
    public TabelaDeUsuariosUtil() {
        linhas = new ArrayList<Usuario>();
       
    }
 
    
    public TabelaDeUsuariosUtil(List<Usuario> dadosUsuario) {
        linhas = new ArrayList<Usuario>(dadosUsuario);
	
	
    }
	
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    };
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case LOGIN:
            return String.class;
        case NOME:
            return String.class;
        default:
           
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
	public int getRowCount() {
	    return linhas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        
        Usuario dados = linhas.get(rowIndex);
 
        switch (columnIndex) {
        case LOGIN:
            return dados.getLogin();
        case NOME:
            return dados.getFuncionario().getNome();
        default:
           
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
	
	 
	
	public void addSocio(Usuario dados) {
	    linhas.add(dados);
	    int ultimoIndice = getRowCount() - 1;
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	 
	 
	
	public void addListaDeSocios(List<Usuario> dados) {
	    int indice = getRowCount();
	    linhas.addAll(dados);
	    fireTableRowsInserted(indice, indice + dados.size());
	}
	 

	public void limpar() {
	    linhas.clear();
	    fireTableDataChanged();
	}
	
	
	
	
	
	
	@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       
        Usuario dados = linhas.get(rowIndex);
 
        switch (columnIndex) {
        case LOGIN:
        	dados.setLogin((String) aValue);
            break;
        case NOME:
        	dados.getFuncionario().setNome((String) aValue);
            break;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
         
        fireTableCellUpdated(rowIndex, columnIndex); 
    }
}

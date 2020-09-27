package br.com.laboratorio.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.laboratorio.modelo.Convenio;

public class TabelaDeConveniosUtil extends AbstractTableModel{
	private String[] colunas = new String[] { "CODIGO", "CONVENIO"};
	private List<Convenio> linhas;
	private static final int CODIGO = 0;
    private static final int CONVENIO = 1;
	 
    
    public TabelaDeConveniosUtil() {
        linhas = new ArrayList<Convenio>();
       
    }
 
    
    public TabelaDeConveniosUtil(List<Convenio> dadosConvenio) {
        linhas = new ArrayList<Convenio>(dadosConvenio);
	
	
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
        case CODIGO:
            return Long.class;
        case CONVENIO:
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
        
        Convenio dados = linhas.get(rowIndex);
 
        switch (columnIndex) {
        case CODIGO:
            return dados.getCodigo();
        case CONVENIO:
            return dados.getNome();
        default:
           
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
	
	 
	
	public void addSocio(Convenio dados) {
	    linhas.add(dados);
	    int ultimoIndice = getRowCount() - 1;
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	 
	 
	
	public void addListaDeSocios(List<Convenio> dados) {
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
       
        Convenio dados = linhas.get(rowIndex);
 
        switch (columnIndex) {
        case CODIGO:
        	dados.setCodigo((Long) aValue);
            break;
        case CONVENIO:
        	dados.setNome((String) aValue);
            break;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
         
        fireTableCellUpdated(rowIndex, columnIndex); 
    }
}

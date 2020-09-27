package br.com.laboratorio.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.laboratorio.modelo.Paciente;



public class TabelaBuscarPacientesUtil extends AbstractTableModel{
	private String[] colunas = new String[] { "CÓDIGO", "NOME", "CPF","RG" };
	private List<Paciente> linhas;
	private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int CPF = 2;
    private static final int RG = 3;
	 
    
    public TabelaBuscarPacientesUtil() {
        linhas = new ArrayList<Paciente>();
       
    }
 
    
    public TabelaBuscarPacientesUtil(List<Paciente> paciente) {
        linhas = new ArrayList<Paciente>(paciente);
	
	
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
            return Integer.class;
        case NOME:
            return String.class;
        case CPF:
            return String.class;
        case RG:
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
        
		Paciente dados = linhas.get(rowIndex);
 
        switch (columnIndex) {
        case CODIGO:
            return dados.getCodigo();
        case NOME:
            return dados.getNome();
        case CPF:
            return dados.getCpf();
        case RG:
        	return dados.getRg();
        default:
           
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
	
	 
	
	public void addUsuario(Paciente dados) {
	  
	    linhas.add(dados);
	    int ultimoIndice = getRowCount() - 1;
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	 
	 
	
	public void addListaDeUsuario(List<Paciente> dados) {
	    
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
       
		Paciente dados = linhas.get(rowIndex);
 
        switch (columnIndex) {
        case CODIGO:
        	dados.setCodigo((Long) aValue);
            break;
        case NOME:
        	dados.setNome((String) aValue);
            break;
        case CPF:
        	dados.setCpf((String) aValue);
        case RG:
        	dados.setRg((String) aValue);
            break;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
         
        fireTableCellUpdated(rowIndex, columnIndex); 
    }
    
}

package br.com.laboratorio.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.laboratorio.modelo.Paciente;
import br.com.laboratorio.util.HibernateUtil;
import br.com.laboratorio.util.MensagemPainelUtil;



public class PacienteRepository {
	Session sessao;
	Transaction transacao = null;
	
	//Metodo que salva um novo cliente Pessoa Fisica ou Pessoa Juridica
	public void Guardar(Paciente paciente){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(paciente);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			
			MensagemPainelUtil.ErroDuplicacao("Nome/Cpf não pode ser duplicado");
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	public void Remover(Paciente paciente) {
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(paciente);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			MensagemPainelUtil.ErroDuplicacao("Erro!! Este Paciente possui registros em Prontuários");
		} finally {
			sessao.close();
		}
	}
	
	
	
	public Paciente BuscarPorId(Long codigo){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Paciente paciente = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Paciente.buscarPorId");
			consulta.setLong("codigo", codigo);
			paciente = (Paciente) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return paciente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> ListarPacientes(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Paciente> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Paciente.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Paciente> BuscarPeloNome(String nome){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Paciente> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Paciente.buscarPeloNome");
			consulta.setString("nome", "%"+nome+"%");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	
	public Long VerificaQTDRegistro(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Long> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Paciente.verificaQtd");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista.get(0);
	}
	
}

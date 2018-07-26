package tds.um.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tds.um.modelo.Usuario;
import tds.um.utils.HibernateUtil;

public class AdapatadorUsuarioTDS implements IAdaptadorUsuarioDAO {

	@Override
	public void registrarUsuario(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
		} finally {
			session.close();
		}

	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Usuario recuperarUsuario(int codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			Usuario u = session.get(Usuario.class, codigo);
			session.getTransaction().commit();
			return u;
		} catch (RuntimeException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> recuperarTodosUsuarios() {
		List<Usuario> listaURec = new ArrayList<Usuario>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			listaURec = (ArrayList<Usuario>) session.createQuery("FROM Usuario").list();
			session.getTransaction().commit();
			return listaURec;
		} catch (RuntimeException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}

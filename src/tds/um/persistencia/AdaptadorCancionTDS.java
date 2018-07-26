package tds.um.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tds.um.modelo.Cancion;
import tds.um.utils.HibernateUtil;

public class AdaptadorCancionTDS implements IAdaptadorCancionDAO {

	@Override
	public void registrarCancion(Cancion cancion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.save(cancion);
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
	public void borrarCancion(Cancion cancion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.delete(cancion);
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
	public void modificarCancion(Cancion cancion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.update(cancion);
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
	public Cancion recuperarCancion(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			Cancion u = session.get(Cancion.class, id);
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
	public List<Cancion> recuperarTodasCanciones() {
		List<Cancion> listaRec = new ArrayList<Cancion>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			listaRec = (ArrayList<Cancion>) session.createQuery("FROM Cancion").list();
			session.getTransaction().commit();
			return listaRec;
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

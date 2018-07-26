package tds.um.persistencia;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tds.um.modelo.ListaCanciones;
import tds.um.utils.HibernateUtil;

public class AdaptadorListaCancionesTDS implements IAdaptadorListaCancionesDAO {

	@Override
	public void registrarListaCanciones(ListaCanciones listaCanciones) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.save(listaCanciones);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void borrarListaCanciones(ListaCanciones listaCanciones) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.delete(listaCanciones);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void modificarListaCanciones(ListaCanciones listaCanciones) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.update(listaCanciones);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (trans != null)
				trans.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public ListaCanciones recuperarListaCanciones(int id) {
		List<ListaCanciones> listaC = new ArrayList<ListaCanciones>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			listaC = (ArrayList<ListaCanciones>) session.createQuery("from ListaCanciones").list();
			session.getTransaction().commit();
			return (ListaCanciones) listaC;
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
	public List<ListaCanciones> recuperarTodasListasCanciones() {
		List<ListaCanciones> listaRec = new ArrayList<ListaCanciones>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			listaRec = (ArrayList<ListaCanciones>) session.createQuery("FROM ListaCanciones").list();
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

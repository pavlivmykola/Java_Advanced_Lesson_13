package ua.lviv.lgs.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.DAO.JornalsDAO;
import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.shared.FactoryManager;
import ua.lviv.lgs.utils.ConnectionUtils;

public class JornalsDAOImpl implements JornalsDAO{
	
	private EntityManager em = FactoryManager.getEntityManager();
//	private static Logger LOGGER = Logger.getLogger(JornalsDAOImpl.class);

	@Override
	public Jornals create(Jornals jornal) {
		try {
			em.getTransaction().begin();
			em.persist(jornal);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return null;
	}

	@Override
	public Jornals read(Integer id) {
		Jornals jornal = null;
		try {
			jornal = em.find(Jornals.class, id);
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return jornal;
	}

	@Override
	public Jornals update(Jornals jornal) {
		try {
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return null;
	}

	@Override
	public void delete(Jornals jornal) {
		try {
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}

	}

	@Override
	public List<Jornals> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Jornals e");
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return (List<Jornals>) query.getResultList();
	}

}

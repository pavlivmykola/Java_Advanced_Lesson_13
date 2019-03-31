package ua.lviv.lgs.DAO.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.DAO.SubscriptionDAO;
import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.shared.FactoryManager;

public class SubscriptionDAOImpl implements SubscriptionDAO{

	
	private EntityManager em = FactoryManager.getEntityManager();
//	private static Logger LOGGER = Logger.getLogger(SubscriptionDAOImpl.class);

	@Override
	public Subscriptions create(Subscriptions subscription) {
		try {
			em.getTransaction().begin();
			em.persist(subscription);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return subscription;
	}

	@Override
	public Subscriptions read(Integer id) {
		return null;
	}

	public Subscriptions reads(String id) {
		Subscriptions subscription = null;
		try {
			subscription = em.find(Subscriptions.class, id);
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return subscription;
	}
	
	
	@Override
	public Subscriptions update(Subscriptions subscription) {
		throw new IllegalStateException("there is no update for subscription");
	}

	@Override
	public void delete(Subscriptions subscription) {
		try {
			em.getTransaction().begin();
			em.remove(subscription);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subscriptions> readAll() {
		Query query = null;
		try {
			query = em.createQuery("select e from Subscriptions e");
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return (List<Subscriptions>) query.getResultList();
	}

}

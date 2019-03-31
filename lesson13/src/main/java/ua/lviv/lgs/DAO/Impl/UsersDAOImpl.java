package ua.lviv.lgs.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ua.lviv.lgs.DAO.UsersDAO;
import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.shared.FactoryManager;

public class UsersDAOImpl implements UsersDAO{
	private EntityManager em = FactoryManager.getEntityManager();
//	private static Logger LOGGER = Logger.getLogger(UsersDAOImpl.class);
	
	
	
	@Override
	public Users create(Users user) {
		try {
			em.getTransaction().begin();;
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return user;
	}

	@Override
	public Users read(Integer id) {
		Users user = null;
		try {
			user = em.find(Users.class, id);
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return user;
	}
	
	@Override
	public Users readByLogin(String login) {
		Users user = null;
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
			Root<Users> from = criteria.from(Users.class);
			criteria.select(from);
			criteria.where(builder.equal(from.get("email"), login));
			TypedQuery<Users> typed = em.createQuery(criteria);
			user = typed.getSingleResult();
			} catch (Exception ex) {
				System.out.println(ex);
//			LOGGER.error(ex);
		}
		return user;
	}

	@Override
	public Users update(Users user) {
		try {
			return user;
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return null;
	}
	
	@Override
	public void delete(Users user) {
		try {
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
	}

	@Override
	public List<Users> readAll() {
		List<Users> listOfUsers = new ArrayList<>();
		try {
		
		} catch (Exception ex) {
			System.out.println(ex);
//			LOGGER.error(ex);
		}
		return listOfUsers;
	}

}

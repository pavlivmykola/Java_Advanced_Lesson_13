package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.DAO.UsersDAO;
import ua.lviv.lgs.DAO.Impl.UsersDAOImpl;
import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.service.UsersService;

public class UsersServiceImpl implements UsersService{
	
	private UsersDAO usersDAO;
//	private static Logger LOGGER = Logger.getLogger(UsersServiceImpl.class);
	private static UsersService userServiceImpl;
	
	private UsersServiceImpl() {
		try {
			usersDAO = new UsersDAOImpl();
		} catch (Exception ex) {
//			LOGGER.error(ex);
			System.out.println(ex);
		}
	}

	public static UsersService getUserServiceImpl() {
		if (userServiceImpl==null) {
			userServiceImpl = new UsersServiceImpl();
		}
		return userServiceImpl;
	}
	
	@Override
	public Users create(Users t) {
		return usersDAO.create(t);
	}

	@Override
	public Users read(Integer i) {
		return usersDAO.read(i);
	}
	
	@Override
	public Users readByLogin(String login) {
//		if (usersDAO==null) {
//			usersDAO = new UsersDAOImpl();
//		}
		return usersDAO.readByLogin(login);
	}

	@Override
	public Users update(Users t) {
		return usersDAO.update(t);
	}

	@Override
	public void delete(Users t) {
		usersDAO.delete(t);
		
	}

	@Override
	public List<Users> readAll() {
		return usersDAO.readAll();
	}
	
	
}

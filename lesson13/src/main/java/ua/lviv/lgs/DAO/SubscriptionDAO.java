package ua.lviv.lgs.DAO;

import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface SubscriptionDAO extends AbstractCRUD<Subscriptions>{
	
	Subscriptions reads(String s);
}

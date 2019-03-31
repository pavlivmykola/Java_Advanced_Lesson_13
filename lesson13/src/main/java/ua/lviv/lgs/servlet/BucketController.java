package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.service.JornalsService;
import ua.lviv.lgs.service.SubscriptionService;
import ua.lviv.lgs.service.UsersService;
import ua.lviv.lgs.service.impl.JornalsServiceImpl;
import ua.lviv.lgs.service.impl.SubscriptionServiceImpl;
import ua.lviv.lgs.service.impl.UsersServiceImpl;

@WebServlet(name = "bucket", description = "bucket", urlPatterns = { "/bucket" })
public class BucketController extends HttpServlet {
	private SubscriptionService subscriptionService = SubscriptionServiceImpl.getSubscriptionServiceImpl();
	private JornalsService jornalsService = JornalsServiceImpl.getJornalsServiceImpl();
	private UsersService userService = UsersServiceImpl.getUserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String jornalId = request.getParameter("jornalId");
		Jornals jornal = jornalsService.read(Integer.parseInt(jornalId));
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		Users user = userService.read(userId);
		
		long millis=System.currentTimeMillis();
//		Subscriptions subscription = new Subscriptions(7, Integer.parseInt(jornalId), new Date(millis), new Date(millis));
		Subscriptions subscription = new Subscriptions();
		subscription.setId(UUID.randomUUID().toString());
		subscription.setJornal(jornal);
		subscription.setStart(new Date(millis));
		subscription.setEnd(new Date(millis));
		subscription.setUser(user);
		
		subscriptionService.create(subscription);

		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		Subscriptions read = subscriptionService.reads(bucketId);
		subscriptionService.delete(read);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		
	}
}

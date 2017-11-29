package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gc.dto.UserDto;

/*
 * author: Alexander Cyr
 *
 */

@Controller
public class HomeController {

	@RequestMapping("/")
	public String helloWorld() {
		return "index";
	}
	
	@RequestMapping("/addNewUser")
	public String goToRegister() {
		return "addNewUser";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String checkLogin(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(UserDto.class);
		
		crit.add(Restrictions.like("UserName", "%"+username+"%"));
		ArrayList<UserDto> list = (ArrayList<UserDto>)crit.list();	
		
		tx.commit();
		session.close();
		
		String webPage = "index";
		
		if(!list.isEmpty()) {
			
			String dbPassword = list.get(0).getPassword();
			
			if(password.equals(dbPassword)) {
				model.addAttribute("firstName", list.get(0).getFirstName() );
				webPage = "userHome";
			}
			else {
				String alert = "<script>alert('Password is incorrect. Try again.')</script>";
				model.addAttribute("alert", alert );
			}
		}
		else {
			String alert = "<script>alert('Username does not exist. Try again.')</script>";
			model.addAttribute("alert", alert );	
		}
		return webPage;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String addNewUser(Model model, @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("username") String username, @RequestParam("password") String password) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		UserDto newUser = new UserDto();
		int id = 0;
		newUser.setID(id);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setPassword(password);
		newUser.setUserName(username);
		
		session.save(newUser);
		
		model.addAttribute("firstName", firstName);
		
		tx.commit();
		session.close();		
		
		return "userHome";
	}
	
	
	
}
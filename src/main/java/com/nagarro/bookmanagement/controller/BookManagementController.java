package com.nagarro.bookmanagement.controller;

import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.nagarro.bookmanagement.dao.LoginDao;
import com.nagarro.bookmanagement.entity.Bean;
import com.nagarro.bookmanagement.entity.Book;
import com.nagarro.bookmanagement.services.RestServices;


@Controller
public class BookManagementController {
	@Autowired
	private LoginDao loginDao;

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		return "login";
	}

	@RequestMapping("/processlogin")
	public String validate(@ModelAttribute("bean") Bean bean, Model model) throws ClassNotFoundException {
		System.out.println(bean);
		if (this.loginDao.validate(bean)) {
			return "welcome";
		}
		return "login";
	}
	
	
	
	
	
//	@RequestMapping("/")
//	public String login() {
//
//		return "login";
//	}

//	@RequestMapping("login")
//	public String logout() {
//
//		return "login";
//	}


//	method = RequestMethod.POST
	@PostMapping(value = "/addall")
	public String addBook(Book book, HttpSession session) throws URISyntaxException {
//		System.out.println(emp.getName());
		RestServices.addBook(book);
		

		Book[] books = RestServices.getBooks();
		session.setAttribute("list", books);
		return "welcome";
	}
//	method = RequestMethod.GET
	@PostMapping(value = "/add" )
	public String uploadBook() throws URISyntaxException {

		return "add";
	}

	@RequestMapping("welcome")
	// @ResponseBody
	public String welcome() {

		return "welcome";
	}

	@PostMapping(value = "/edit")
	public String editBook() {

		return "edit";
	}


	@PostMapping(value = "/edit")
	public String update(@ModelAttribute Book book, HttpSession session, @RequestParam("code") int code)
			throws URISyntaxException {
		RestServices.updateBook(book);
		Book[] list = RestServices.getBooks();
		session.setAttribute("list", list);
		return "welcome";
	}
	
	//delete
	@DeleteMapping(value="/delete")
	// @ResponseBody
	public String delete(@RequestParam("id") int id) {
//		System.out.println(id);
		RestServices.deleteBook(id);
		
		return "welcome";
	}



	@RequestMapping("/validate")
	public String validate(HttpSession session, @RequestParam("userId") String userId,
			@RequestParam("password") String password) throws URISyntaxException {

		Bean bean = RestServices.getUser(userId, password);
		
		String message = "";
		if (bean == null) {
			message = "Login ID or Password incorrect";
			session.setAttribute("message", message);
			return "login";
		}

		Book[] list = RestServices.getBooks();
		session.setAttribute("userName", bean.getUsername());

		session.setAttribute("list", list);

		return "welcome";
	}
}

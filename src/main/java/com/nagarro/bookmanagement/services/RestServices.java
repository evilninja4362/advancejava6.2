package com.nagarro.bookmanagement.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.bookmanagement.entity.Bean;
import com.nagarro.bookmanagement.entity.Book;

@Service
public class RestServices {
	private final static RestTemplate restTemplate=new RestTemplate();
	public static Book[] getBooks() throws URISyntaxException {
		String url="http://localhost:3306/Books";
		URI uri = new URI(url);

		try {
			return restTemplate.getForEntity(uri, Book[].class).getBody();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Book getBook(String code) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("code", Integer.valueOf(code));
		Book emp = restTemplate.getForObject("http://localhost:3306/Books/{code}", Book.class, params);
		return emp;
	}

	public static void addBook(Book book) throws URISyntaxException {
		String url = "http://localhost:3306/Books";
		URI uri = new URI(url);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Book> request = new HttpEntity<Book>(book, headers);

		restTemplate.postForEntity(uri, request, Book.class);
	}

	public static void updateBook(Book book) throws URISyntaxException {
		String url = "http://localhost:3306/Books";
		URI uri = new URI(url);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Book> request = new HttpEntity<Book>(book, headers);

		restTemplate.postForEntity(uri, request, Book.class);
	}
	public static Bean getUser(String userId, String password) {
		
		Map<String,String> params=new HashMap<String,String>();
		params.put("userId", userId);
		params.put("password", password);

		Bean user=restTemplate.getForObject("http://localhost:3306/user/{userId}/{password}", Bean.class, params);

		return user;
	}

	public static void deleteBook(int code) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("code", Integer.valueOf(code));
		restTemplate.delete("http://localhost:3306/Books/{code}", params);
	}
}

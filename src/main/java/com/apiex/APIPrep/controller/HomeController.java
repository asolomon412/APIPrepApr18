package com.apiex.APIPrep.controller;

import java.util.ArrayList;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.apiex.APIPrep.model.Etherum;
import com.apiex.APIPrep.model.LoveMatcher;
import com.apiex.APIPrep.model.Person;
import com.apiex.APIPrep.model.Quote;
import com.apiex.APIPrep.model.Result;
import com.apiex.APIPrep.model.TriviaFact;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		mv.addObject("test", quote);
		return mv;
	}

	@RequestMapping("/people")
	public String people() {
		// these lines are needed for https
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		
		// need to pass in the request factory to the RestTemplate
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		Result result = restTemplate.getForObject("https://swapi.co/api/people/?format=json", Result.class);

		// Don't need any of this, just used for testing
		System.out.println(result.toString());

		ArrayList<Person> people = result.getResults();

		for (Person p : people) {
			System.out.println(p.getName());
		}
		// end of testing
		return "personselect";
	}

	@RequestMapping("/personspecs")
	public String personSpecs(@RequestParam("person") int person, Model model) {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		Person result = restTemplate.getForObject("https://swapi.co/api/people/" + person + "/?format=json",
				Person.class);
		System.out.println(result.toString());

		model.addAttribute("person", result);
		return "personresults";
	}

	@RequestMapping("/trivia")
	public ModelAndView trivia() {
		ModelAndView mv = new ModelAndView("trivia");
		// example adding headers and a key
		// obtained some examples here:
		// https://www.quora.com/How-do-I-consume-ReST-service-using-Spring-RestTemplate-How-to-pass-Java-object-in-HTTP-POST-Request-through-both-Header-parameter-and-Request-body-I-also-like-know-how-to-create-design-archtecture-for-my-Spring-ReST-client-application
		HttpHeaders headers = new HttpHeaders();
		// here is an example using that needs to pass a key into the API to retrieve
		// the results
		headers.add("X-Mashape-Key", "wHzB00qxiAmshjpvW6GylUHEtesMp1xT2FQjsnAHBWwC1ov");
		headers.setContentType(MediaType.APPLICATION_JSON);
		// using the HttpEntity to assign the headers to send to the API
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TriviaFact> response = restTemplate.exchange(
				"https://numbersapi.p.mashape.com/random/trivia?fragment=true&json=true&notfound=floor", HttpMethod.GET,
				entity, TriviaFact.class);

		// just printing the response will give you the status codes and more
		// to access to the json data directly we need to use the getBody() method.
		System.out.println(response);
		System.out.println(response.getBody());
		mv.addObject("test", response.getBody());
		return mv;
	}

	@RequestMapping("/random")
	public ModelAndView randomFact(@RequestParam("facttype") String type) {
		ModelAndView mv = new ModelAndView("randomfact");
		// example adding headers and a key
		// obtained some examples here:
		// https://www.quora.com/How-do-I-consume-ReST-service-using-Spring-RestTemplate-How-to-pass-Java-object-in-HTTP-POST-Request-through-both-Header-parameter-and-Request-body-I-also-like-know-how-to-create-design-archtecture-for-my-Spring-ReST-client-application
		HttpHeaders headers = new HttpHeaders();
		// here is an example using that needs to pass a key into the API to retrieve
		// the results -- removed some of the key will need to update this if the project is ever cloned to test
		headers.add("X-Mashape-Key", "wHzB00qxiAmshjpvW6GylUHEtesMp1xT2FQjsnAHBWwC1ov");
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TriviaFact> response = restTemplate.exchange(
				"https://numbersapi.p.mashape.com/random/" + type + "?fragment=true&json=true&max=20&min=10",
				HttpMethod.GET, entity, TriviaFact.class);

		// just printing the response will give you the status codes and more
		// to access to the json data directly we need to use the getBody() method.
		System.out.println(response);
		System.out.println(response.getBody());
		mv.addObject("test", response.getBody());
		return mv;
	}
	
	@RequestMapping("/love")
	public ModelAndView loveCalc(@RequestParam("fname") String fname, @RequestParam("sname") String sname) {

		ModelAndView mv = new ModelAndView("lovematch");
		// example adding headers and a key
		// obtained some examples here:
		// https://www.quora.com/How-do-I-consume-ReST-service-using-Spring-RestTemplate-How-to-pass-Java-object-in-HTTP-POST-Request-through-both-Header-parameter-and-Request-body-I-also-like-know-how-to-create-design-archtecture-for-my-Spring-ReST-client-application
		HttpHeaders headers = new HttpHeaders();
		// here is an example using that needs to pass a key into the API to retrieve
		// the results
		headers.add("X-Mashape-Key", "wHzB00qxiAmshjpvW6GylUHEtesMp1xT2FQjsnAHBWwC1ov");
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); // needed this because the line below was not working...
//		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<LoveMatcher> response = restTemplate.exchange(
				"https://love-calculator.p.mashape.com/getPercentage?fname=" + fname + "&sname=" +sname,
				HttpMethod.GET, entity, LoveMatcher.class);

		// just printing the response will give you the status codes and more
		// to access to the json data directly we need to use the getBody() method.
		System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
		// returns the body of this message
		System.out.println(response.getBody());
		mv.addObject("test", response.getBody());
		return mv;
	}
	
	//https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=BTC,USD,EUR
	// for Jill/John/Mike
	@RequestMapping("/crypto")
	public ModelAndView crypto() {
		ModelAndView mv = new ModelAndView("crypto");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Etherum> response = restTemplate.exchange(
				"https://min-api.cryptocompare.com/data/pricehistorical?fsym=ETH&tsyms=BTC,USD,EUR",
				HttpMethod.GET, entity, Etherum.class);

		mv.addObject("test", response.getBody());
		return mv;
	}
}

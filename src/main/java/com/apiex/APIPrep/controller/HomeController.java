package com.apiex.APIPrep.controller;

import java.util.ArrayList;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.apiex.APIPrep.model.Person;
import com.apiex.APIPrep.model.Quote;
import com.apiex.APIPrep.model.Result;

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

}

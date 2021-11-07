package br.com.ismael.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.ismael.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Ismael");
		person.setLastName("José");
		person.setAddress("Fortaleza");
		person.setGender("Male");
		return person;
	}
}

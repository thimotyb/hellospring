package it.ariadne.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.ariadne.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findByCognome(String cognome);
	
}
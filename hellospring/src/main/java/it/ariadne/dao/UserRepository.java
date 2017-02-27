package it.ariadne.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import it.ariadne.model.User;

public interface UserRepository extends Repository<User, Long> {

	public List<User> findByCognome(String cognome);
	
}
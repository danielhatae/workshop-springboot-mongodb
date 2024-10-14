package com.daniel.hatae.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.hatae.workshopmongo.domain.User;
import com.daniel.hatae.workshopmongo.dto.UserDTO;
import com.daniel.hatae.workshopmongo.repository.UserRepository;
import com.daniel.hatae.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	/*
	 *  um item um pouco polemico porque poderia ser criado no UserDTO.
	 *  Pode haver projetos que é necessário recuperar os dados para utilizar no método de serviços.
	*/
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}

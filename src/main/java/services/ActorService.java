package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Actor;
import repositories.ActorRepository;
import security.LoginService;

@Service
@Transactional
public class ActorService {

	// Managed repository
	@Autowired
	private ActorRepository actorRepository;

	// Supporting services

	// Constructors
	public ActorService() {
		super();
	}

	// Simple CRUD methods
	public void save(Actor actor) {
		actorRepository.save(actor);
	}

	public void delete(Actor actor) {
		actorRepository.delete(actor);
	}

	public Actor findOne(int actorId) {
		return actorRepository.findOne(actorId);
	}

	public Collection<Actor> findAll() {
		return actorRepository.findAll();
	}

	// Other methods
	public Actor findOneByUserId(int userId) {
		return actorRepository.findOneByUserId(userId);
	}

	public Collection<Actor> allActorsWithoutMe() {
		int userAccount = LoginService.getPrincipal().getId();
		Collection<Actor> res = actorRepository.allActorsWithoutMe(userAccount);
		return res;
	}

	// All checks


	
}

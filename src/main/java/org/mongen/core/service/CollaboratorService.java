package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Collaborator;
import org.mongen.core.repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
	@Autowired
	CollaboratorRepository colaboratorRepo;
	
	public List<Collaborator> getCollaborators(){
		return colaboratorRepo.findAll();
	}
	
	public Collaborator findCollaboratorById(Long id) {
		Optional<Collaborator> temp = colaboratorRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Collaborator createCollaborator(Collaborator nuevo) {
		return colaboratorRepo.save(nuevo);
	}
	
	public Collaborator updateCollaborator(Collaborator nuevo,Long id) {
		nuevo.setId(id);
		return colaboratorRepo.save(nuevo);
	}
	
	public void deleteCollaborator(Long id) {
		colaboratorRepo.deleteById(id);
	}
}

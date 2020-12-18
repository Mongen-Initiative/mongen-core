package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Collaborator;
import org.mongen.core.models.CollaboratorType;
import org.mongen.core.repository.CollaboratorRepository;
import org.mongen.core.repository.CollaboratorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
	@Autowired
	CollaboratorRepository collaboratorRepo;
	@Autowired
	CollaboratorTypeRepository collaboratorTypeRepo;
	
	public List<Collaborator> getCollaborators(){
		return collaboratorRepo.findAll();
	}
	
	public Collaborator findCollaboratorById(Long id) {
		Optional<Collaborator> temp = collaboratorRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Collaborator createCollaborator(Collaborator nuevo) {
		return collaboratorRepo.save(nuevo);
	}
	
	public Collaborator updateCollaborator(Collaborator nuevo,Long id) {
		nuevo.setId(id);
		return collaboratorRepo.save(nuevo);
	}
	
	public void deleteCollaborator(Long id) {
		collaboratorRepo.deleteById(id);
	}

	public List<CollaboratorType> getCollaboratorTypes() {
		return collaboratorTypeRepo.findAll();
	}
}

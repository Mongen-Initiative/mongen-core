package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Collaborator;
import org.mongen.core.models.CollaboratorType;
import org.mongen.core.models.payloads.CollaboratorPayload;
import org.mongen.core.models.payloads.MainContactPayload;
import org.mongen.core.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1")
public class CollaboratorController {

	@Autowired
	CollaboratorService collaboratorServ;
	
	@ApiOperation(value = "Get All the Collaborators")
	@GetMapping("/collaborators")
	public ResponseEntity<List<Collaborator>> getCollaborators(){
		List<Collaborator> cola = collaboratorServ.getCollaborators();
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}

	@ApiOperation(value = "Get All the Collaborator Types")
	@GetMapping("/collaborators/type")
	public ResponseEntity<List<CollaboratorType>> getCollaboratorTypes(){
		List<CollaboratorType> cola = collaboratorServ.getCollaboratorTypes();
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Get one Collaborator")
	@GetMapping("/collaborators/{id}")
	public ResponseEntity<Collaborator> getCollaboratorId(@PathVariable("id") Long id){
		Collaborator cola = collaboratorServ.findCollaboratorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Create a Collaborator")
	@PostMapping("/collaborators")
	public ResponseEntity<Collaborator> createCollaborator(@RequestBody CollaboratorPayload collaborator){
		Collaborator new_collaborator = collaboratorServ.createCollaborator(collaborator);
		return ResponseEntity.status(HttpStatus.CREATED).body(new_collaborator);
	}

	@ApiOperation(value = "Create a Main Contact")
	@PostMapping("/main_contact")
	public ResponseEntity<Collaborator> createCollaborator(@RequestBody MainContactPayload main_contact){
		Collaborator new_main_contact = collaboratorServ.createMainContact(main_contact);
		return ResponseEntity.status(HttpStatus.CREATED).body(new_main_contact);
	}
	
	@ApiOperation(value = "Update a Collaborator")
	@PatchMapping("/collaborators/{id}")
	public ResponseEntity<Collaborator> updateCollaborator(@PathVariable("id") Long id, @RequestBody Collaborator collaborator){
		Collaborator cola = collaboratorServ.updateCollaborator(collaborator, id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Delete a Collaborator")
	@DeleteMapping("/collaborators/{id}")
	public ResponseEntity<?> deleteCollaborator(@PathVariable("id") Long id){
		collaboratorServ.deleteCollaborator(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Collaborator with ID: " + id);
	}
}

package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Collaborator;
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
	CollaboratorService colaboratorServ;
	
	@ApiOperation(value = "Get All the Collaborators")
	@GetMapping("/collaborators")
	public ResponseEntity<List<Collaborator>> getCollaborators(){
		List<Collaborator> cola = colaboratorServ.getCollaborators();
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Get one Collaborator")
	@GetMapping("/collaborators/{id}")
	public ResponseEntity<Collaborator> getCollaboratorId(@PathVariable("id") Long id){
		Collaborator cola = colaboratorServ.findCollaboratorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Create a Collaborator")
	@PostMapping("/collaborators")
	public ResponseEntity<Collaborator> createCollaborator(@RequestBody Collaborator collaborator){
		Collaborator cola = colaboratorServ.createCollaborator(collaborator);
		return ResponseEntity.status(HttpStatus.CREATED).body(cola);
	}
	
	@ApiOperation(value = "Update a Collaborator")
	@PatchMapping("/collaborators/{id}")
	public ResponseEntity<Collaborator> updateCollaborator(@PathVariable("id") Long id, @RequestBody Collaborator collaborator){
		Collaborator cola = colaboratorServ.updateCollaborator(collaborator, id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Delete a Collaborator")
	@DeleteMapping("/collaborators/{id}")
	public ResponseEntity<?> deleteCollaborator(@PathVariable("id") Long id){
		colaboratorServ.deleteCollaborator(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Collaborator with ID: " + id);
	}
}

package org.mongen.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mongen.core.models.Collaborator;
import org.mongen.core.models.CollaboratorType;
import org.mongen.core.models.payloads.CollaboratorPayload;
import org.mongen.core.models.payloads.MainContactPayload;
import org.mongen.core.models.responses.CollaboratorResponse;
import org.mongen.core.models.responses.MainContactResponse;
import org.mongen.core.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class CollaboratorController {

	@Autowired
	CollaboratorService collaboratorServ;
	
	@ApiOperation(value = "Get All the Collaborators")
	@GetMapping("/collaborators")
	public ResponseEntity<List<CollaboratorResponse>> getCoolCollaborators(){
		List<Collaborator> collaborators = collaboratorServ.getCollaborators();
		List<CollaboratorResponse> collaborators_resp = collaboratorServ.generateListCollaboratorResponse(collaborators);
		return ResponseEntity.status(HttpStatus.OK).body(collaborators_resp);
	}

	@ApiOperation(value = "Get Collaborators by Organization")
	@GetMapping("/collaborators/organization_id/{org_id}")
	public ResponseEntity<List<CollaboratorResponse>> getCollaboratorsByOrganization(@PathVariable("org_id") Long org_id){
		List<Collaborator> collaborators = collaboratorServ.getCollaboratorsByOrganization(org_id);
		List<CollaboratorResponse> collaborators_resp = collaboratorServ.generateListCollaboratorResponse(collaborators);
		return ResponseEntity.status(HttpStatus.OK).body(collaborators_resp);
	}

	@ApiOperation(value = "Get All the Collaborator Types")
	@GetMapping("/collaborators/type")
	public ResponseEntity<List<CollaboratorType>> getCollaboratorTypes(){
		List<CollaboratorType> types = collaboratorServ.getCollaboratorTypes();
		return ResponseEntity.status(HttpStatus.OK).body(types);
	}
	
	@ApiOperation(value = "Get one Collaborator")
	@GetMapping("/collaborator/{id}")
	public ResponseEntity<CollaboratorResponse> getCollaboratorId(@PathVariable("id") Long id){
		CollaboratorResponse collaborator = new CollaboratorResponse(collaboratorServ.findCollaboratorById(id));
		return ResponseEntity.status(HttpStatus.OK).body(collaborator);
	}

	@ApiOperation(value = "Get one Main Contact")
	@GetMapping("/main_contact/{id}")
	public ResponseEntity<MainContactResponse> getMainContactId(@PathVariable("id") Long id){
		MainContactResponse collaborator = new MainContactResponse(collaboratorServ.findCollaboratorById(id));
		return ResponseEntity.status(HttpStatus.OK).body(collaborator);
	}
	
	@ApiOperation(value = "Create a Collaborator")
	@PostMapping("/collaborator")
	public ResponseEntity<Collaborator> createCollaborator(@Valid @RequestBody CollaboratorPayload collaborator){
		Collaborator new_collaborator = collaboratorServ.createCollaborator(collaborator);
		return ResponseEntity.status(HttpStatus.CREATED).body(new_collaborator);
	}

	@ApiOperation(value = "Create a Main Contact")
	@PostMapping("/main_contact")
	public ResponseEntity<Collaborator> createCollaborator(@Valid @RequestBody MainContactPayload main_contact){
		Collaborator new_main_contact = collaboratorServ.createMainContact(main_contact);
		return ResponseEntity.status(HttpStatus.CREATED).body(new_main_contact);
	}
	
	@ApiOperation(value = "Update a Collaborator")
	@PatchMapping("/collaborator/{id}")
	public ResponseEntity<Collaborator> updateCollaborator(@PathVariable("id") Long id, @RequestBody Collaborator collaborator){
		Collaborator updated_collaborator = collaboratorServ.updateCollaborator(collaborator, id);
		return ResponseEntity.status(HttpStatus.OK).body(updated_collaborator);
	}
	
	@ApiOperation(value = "Delete a Collaborator")
	@DeleteMapping("/collaborator/{id}")
	public ResponseEntity<?> deleteCollaborator(@PathVariable("id") Long id){
		collaboratorServ.deleteCollaborator(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Collaborator with ID: " + id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}

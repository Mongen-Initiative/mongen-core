package org.mongen.core.controller;

import io.swagger.annotations.ApiOperation;
//import org.mongen.core.models.SocialMedia;
//import org.mongen.core.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Not in use

//@RestController
//@RequestMapping("/api/v1")
//public class SocialMediaController {
//
//	@Autowired
//	SocialMediaService socialMediaServ;
//
//	@ApiOperation(value = "Get All the Social Media")
//	@GetMapping("/all_social_media")
//	public ResponseEntity<List<SocialMedia>> getDonors(){
//		List<SocialMedia> social_media = socialMediaServ.getSocialMedia();
//		return ResponseEntity.status(HttpStatus.OK).body(social_media);
//	}
//
//	@ApiOperation(value = "Get one Social Media")
//	@GetMapping("/social_media/{id}")
//	public ResponseEntity<SocialMedia> getDonorId(@PathVariable("id") Long id){
//		SocialMedia social_media = socialMediaServ.findSocialMediaById(id);
//		return ResponseEntity.status(HttpStatus.OK).body(social_media);
//	}
//
//	@ApiOperation(value = "Create Social Media")
//	@PostMapping("/social_media")
//	public ResponseEntity<SocialMedia> createDonor(@RequestBody SocialMedia social_media_payload){
//		SocialMedia social_media = socialMediaServ.createSocialMedia(social_media_payload);
//		return ResponseEntity.status(HttpStatus.CREATED).body(social_media);
//	}
//
//	@ApiOperation(value = "Update Social Media")
//	@PatchMapping("/social_media/{id}")
//	public ResponseEntity<SocialMedia> updateDonor(@PathVariable("id") Long id, @RequestBody SocialMedia social_media_payload){
//		SocialMedia social_media = socialMediaServ.updateSocialMedia(social_media_payload, id);
//		return ResponseEntity.status(HttpStatus.OK).body(social_media);
//	}
//
//	@ApiOperation(value = "Delete Social Media")
//	@DeleteMapping("/social_media/{id}")
//	public ResponseEntity<?> deleteDonor(@PathVariable("id") Long id){
//		socialMediaServ.deleteSocialMedia(id);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Social Media with ID: " + id);
//	}
//}

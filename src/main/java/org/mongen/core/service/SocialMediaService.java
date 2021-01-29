package org.mongen.core.service;

import org.mongen.core.models.SocialMedia;
import org.mongen.core.repository.SocialMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaService {
	@Autowired
	SocialMediaRepository socialMediaRepo;
	
	public List<SocialMedia> getSocialMedia(){
		return socialMediaRepo.findAll();
	}
	
	public SocialMedia findSocialMediaById(Long id) {
		Optional<SocialMedia> temp = socialMediaRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public SocialMedia createSocialMedia(SocialMedia social_media) {
		return socialMediaRepo.save(social_media);
	}
	
	public SocialMedia updateSocialMedia(SocialMedia social_media, Long id) {
		social_media.setId(id);
		return socialMediaRepo.save(social_media);
	}
	
	public void deleteSocialMedia(Long id) {
		socialMediaRepo.deleteById(id);
	}
}

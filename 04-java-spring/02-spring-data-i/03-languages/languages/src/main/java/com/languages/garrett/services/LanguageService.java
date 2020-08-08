package com.languages.garrett.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.garrett.models.Languages;
import com.languages.garrett.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Languages> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Languages createLanguage(Languages l) {
		return languageRepository.save(l);
	}
	
	public Languages findLanguage(Long id) {
		Optional<Languages> optionalLang = languageRepository.findById(id);
		
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		}
		else {
			return null;
		}
	}
	
	public Languages updateLanguage(Long id, Languages updatedLanguage) {
		return this.languageRepository.save(updatedLanguage);
	}
	
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);
	}
}

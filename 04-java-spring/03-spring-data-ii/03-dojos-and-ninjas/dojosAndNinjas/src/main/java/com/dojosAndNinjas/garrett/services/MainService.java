package com.dojosAndNinjas.garrett.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojosAndNinjas.garrett.models.Dojo;
import com.dojosAndNinjas.garrett.models.Ninja;
import com.dojosAndNinjas.garrett.repositories.DojoRepository;
import com.dojosAndNinjas.garrett.repositories.NinjaRepository;

@Service
public class MainService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	public MainService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
		this.dojoRepo = dojoRepo;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}

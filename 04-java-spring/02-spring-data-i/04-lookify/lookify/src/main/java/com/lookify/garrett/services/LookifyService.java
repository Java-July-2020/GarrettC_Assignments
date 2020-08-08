package com.lookify.garrett.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lookify.garrett.models.Lookify;
import com.lookify.garrett.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public Lookify getSong(Long id) {
		Lookify set = this.lookifyRepository.findById(id).orElse(null);
		return set;
	}
	
	public List<Lookify> getAllSong(){
		return lookifyRepository.findAll();
	}
	
	public Lookify createSong(Lookify song) {
		return lookifyRepository.save(song);
	}
	
	public Lookify createSong(String title, String artist, Integer rating) {
		Lookify newSong = new Lookify(title, artist, rating);
		return this.lookifyRepository.save(newSong);
	}
	
	public void deleteSong(Long id) {
		this.lookifyRepository.deleteById(id);
	}
	
	public Lookify updateSong(long id, Lookify updateSong) {
		return this.lookifyRepository.save(updateSong);
	}
	
	public List<Lookify> findArtistSongs(String artist) {
		return this.lookifyRepository.findByArtistContaining(artist);
	}
	
	public List<Lookify> findTopTen() {
		return this.lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	

}

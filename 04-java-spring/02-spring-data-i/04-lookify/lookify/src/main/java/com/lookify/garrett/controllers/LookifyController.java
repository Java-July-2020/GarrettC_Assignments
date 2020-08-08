package com.lookify.garrett.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lookify.garrett.models.Lookify;
import com.lookify.garrett.services.LookifyService;

@Controller
public class LookifyController {
	
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashBoard(Model model) {
		List<Lookify> songs = lookifyService.getAllSong();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Lookify song) {
		return "new.jsp";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			lookifyService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value = "/songs/{id}")
	public String findSongByIndex(@PathVariable(value = "id") Long id, Model model) {
		Lookify song = lookifyService.getSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@RequestMapping(value = "/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "songs/search", method = RequestMethod.POST)
	public String searchArtist(@RequestParam(name = "search") String artist, Model model) {
		List<Lookify> songs = lookifyService.findArtistSongs(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "artistSongs.jsp";
	}
	
	@RequestMapping("search/topTen")
	public String topTen(Model model) {
		List<Lookify> topTen = lookifyService.findTopTen();
		model.addAttribute("songs", topTen);
		return"topTen.jsp";
	}
}

package com.skilldistillery.film.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.MVCFilmSiteDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	private int filmId = 0;

	@Autowired
	private MVCFilmSiteDAO filmDAO;

	public void setFilmDAo(MVCFilmSiteDAO filmdao) {
		this.filmDAO = filmdao;
	}

	@RequestMapping(path = "findFilmById.do", method = RequestMethod.GET, params = "id")
	public ModelAndView findFilmByID(@RequestParam("id") int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDAO.findFilmById(filmId).displayFilm());
		mv.setViewName("WEB-INF/result.jsp");
		return mv;

	}

	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(@Valid Film film) {
		ModelAndView mv = new ModelAndView();
		Film newFilm = filmDAO.createFilm(film);
		mv.addObject("newfilm", newFilm);
		mv.setViewName("WEB-INF/newFilm.jsp");
		return mv;

	}

	@RequestMapping(path = "addFilmForm.do", method = RequestMethod.GET)
	private ModelAndView getForm(@Valid Film film) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/addFilm.jsp");
		return mv;

	}
	
	@RequestMapping(path = "searchFilm.do", method = RequestMethod.GET, params = "keyword")
	public ModelAndView searchFilm(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmBySearch(keyword);
		if (films.isEmpty()){
			mv.addObject("result", "No matching films found!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}
		
		else {
			mv.addObject("result", "Here is a list of films we found matching your keyword:<br>");
			mv.addObject("films", films);
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}
		
	}
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST, params = "id")
	private ModelAndView deleteFilm(@RequestParam("id") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(filmId);
		if (filmDAO.deleteFilm(film)) {
			mv.addObject("result", "Movie was deleted!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}
		
		else {
			mv.addObject("result", "Movie was not deleted!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}
		
	}

	@RequestMapping(path = "editFilmForm.do", method = RequestMethod.GET, params = "id")
	private ModelAndView getEditForm(@RequestParam("id") int filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		this.filmId = filmId;
		Film film = filmDAO.findFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("/WEB-INF/editFilm.jsp");
		return mv;

	}

	@RequestMapping(path = "editFilm.do", method = RequestMethod.POST)
	private ModelAndView updateFilm(@Valid Film film) {
		ModelAndView mv = new ModelAndView();
		if (filmDAO.updateFilm(film, this.filmId)) {
			mv.addObject("result", "Film was updated!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}

		else {
			mv.addObject("result", "Film was not updated!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}

	}

	@RequestMapping(path = "index.do", method = RequestMethod.GET)
	private ModelAndView getIndex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.html");
		return mv;

	}

}

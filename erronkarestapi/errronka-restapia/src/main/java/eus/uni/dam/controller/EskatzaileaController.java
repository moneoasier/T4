package eus.uni.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eus.uni.dam.dao.PartidaDAO;

import eus.uni.dam.model.Partida;

import java.util.List;

@RestController
@RequestMapping("/")
public class EskatzaileaController {

	   @Autowired
	   private PartidaDAO partidaDao;
	
	   @GetMapping("partidak")
	    public List<Partida> getPartidak() {
	        return partidaDao.findAll();
	    }
}

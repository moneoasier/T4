package eus.uni.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;


import eus.uni.dam.dao.PartidaDAO;

import eus.uni.dam.model.Partida;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

@RestController
@RequestMapping("/")
public class EskatzaileaController {
		List<Partida> partidaOrdenatuak;
		List<Partida> partidaDatak;
		List<Partida> top3= new ArrayList<Partida>();
		
	   @Autowired
	   private PartidaDAO partidaDao;

	
	   @GetMapping("partidakOrdenatuak")
	    public List<Partida> getPartidakOrdenatuak() {
		   partidaOrdenatuak=partidaDao.findAll();
		   
		   Collections.sort(partidaOrdenatuak, new Comparator<Partida>() {
				@SuppressWarnings("removal")
				@Override
				public int compare(Partida p1, Partida p2) {
					
					return new Integer(p2.getPuntuazioa()).compareTo(new Integer(p1.getPuntuazioa()));
				}
			});
		   
	        return partidaOrdenatuak;
	    }
	   
	   
	   @GetMapping("partidakTop3")
	   public List<Partida> getTop3(){
		   
		   if(getPartidakOrdenatuak().size()>3) {
			   for(int i=0;i<3;i++) {
				   top3.add(getPartidakOrdenatuak().get(i));
			   }
		   }else {
			   return getPartidakOrdenatuak();
		   }
		return top3;
		   
		   
	   }
	   
	   
	   @GetMapping("partidak")
	    public List<Partida> getPartidak() {
		
		   
	        return partidaDao.findAll();
	    }
	   
	   @GetMapping("/partidaEmployee")
		public List<Partida> partidaEmployee(@RequestParam(value = "employee", defaultValue = "1") int employee) {
			
			
			return(partidaDao.findEmployee(employee));
			
		}
	
	   

	   
	   
}

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.DateTimeAtCompleted;

@RestController
@RequestMapping("/")
/**
 * Mapping-aren bidez zer eskaera egiten diren kudeatzen du
 * @author hayar.abderrafia
 *
 */
public class EskatzaileaController {
		List<Partida> partidaOrdenatuak;
		List<Partida> partidaDatak;
		List<Partida> top3= new ArrayList<Partida>();
		
		
	   @Autowired
	   private PartidaDAO partidaDao;

	   /**
	    * partidaFame Mapping-aren bidez bezero bakoitzaren puntuazio onena erakusten du eta ordenatzen du
	    * @return
	    */
	   @GetMapping("partidakFame")
	    public List<Partida> getPartidakFame() {
		   partidaOrdenatuak=partidaDao.findAll();
		   
		   List<Partida> partidakFame= new ArrayList<Partida>();
		   
		   
		   Collections.sort(partidaOrdenatuak, new Comparator<Partida>() {
				@SuppressWarnings("removal")
				@Override
				public int compare(Partida p1, Partida p2) {
					
					return new Integer(p2.getPuntuazioa()).compareTo(new Integer(p1.getPuntuazioa()));
				}
			});
  
		 for(int i=0;i<partidaOrdenatuak.size();i++) {
			 int pepe=0;
			 if(partidakFame.size()>0) {
				 for(int j=0;j<partidakFame.size();j++) {
					 if(partidaOrdenatuak.get(i).getEmployeeid() == partidakFame.get(j).getEmployeeid()) {
						 pepe=1;
					 }
				 }
			 }
			 if (pepe == 0) {
				 partidakFame.add(partidaOrdenatuak.get(i));
			 }
		 }
	        return partidakFame;
	    }
	   
	   /**
	    * partidakTop3 Mapping-aren bidez 3 partida onenak kontsultatzen ditu
	    * @return
	    */
	   @GetMapping("partidakTop3")
	   public List<Partida> getTop3(){
		   
		   if(getPartidakFame().size()>3) {
			   for(int i=0;i<3;i++) {
				   top3.add(getPartidakFame().get(i));
			   }
		   }else {
			   return getPartidakFame();
		   }
		return top3;
		   
		   
	   }
	   
	   /**
	    * partidak Mapping-aren bidez jokatu diren partida guztiak kontsultatzen ditu
	    * @return
	    */
	   @GetMapping("partidak")
	    public List<Partida> getPartidak() {
		
		   
	        return partidaDao.findAll();
	    }
	   /**
	    * partidaEmployee Mapping-aren bidez, bidalitako langilearen Id-aren partidak kontsultatzen ditu
	    * @param employee
	    * @return
	    */
	   @GetMapping("partidaEmployee")
		public List<Partida> partidaEmployee(@RequestParam(value = "employee", defaultValue = "1") int employee) {
			
			
			return(partidaDao.findEmployee(employee));
			
		}
	
	   /**
	    * partidaFame Mapping-aren bidez bezero bakoitzaren puntuazio txarrena erakusten du eta ordenatzen du
	    * @return
	    */
	   @GetMapping("partidakShame")
	    public List<Partida> getPartidakShame() {
		   partidaOrdenatuak=partidaDao.findAll();
		   
		   List<Partida> partidakShame= new ArrayList<Partida>();
		   
		   Collections.sort(partidaOrdenatuak, new Comparator<Partida>() {
				@SuppressWarnings("removal")
				@Override
				public int compare(Partida p1, Partida p2) {
					
					return new Integer(p1.getPuntuazioa()).compareTo(new Integer(p2.getPuntuazioa()));
				}
			});
		   for(int i=0;i<partidaOrdenatuak.size();i++) {
				 int pepe=0;
				 if(partidakShame.size()>0) {
					 for(int j=0;j<partidakShame.size();j++) {
						 if(partidaOrdenatuak.get(i).getEmployeeid() == partidakShame.get(j).getEmployeeid()) {
							 pepe=1;
						 }
					 }
				 }
				 if (pepe == 0) {
					 partidakShame.add(partidaOrdenatuak.get(i));
				 }
			 }
		   
	        return partidakShame;
	    }
	   

	   
	   
}

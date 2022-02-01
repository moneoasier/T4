package eus.uni.dam.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.management.Query;

import eus.uni.dam.model.*;

import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

@Repository
public class PartidaDAO {
	@Autowired
    private MongoClient client;
    private MongoCollection<Partida> collection;

    /**
     * Zein datubasetik eta zein kolekziotikn hartu behar den definitu
     */
    @PostConstruct
    void datuakKargatu() {
        collection = client.getDatabase("datuak").getCollection("puntuazioa",Partida.class);
    }
    /**
     * Datu basetik kolekzioaren datu guztiak kontsultatu
     * @return
     */
    public List<Partida> findAll(){
    	return collection.find().into(new ArrayList<>());
    }
    /**
     * Langilearen arabera datu basetik kolekzioaren datuak kontsultatu
     * @param employee
     * @return
     */
    
    public List<Partida> findEmployee(int employee){
    	 Bson filter=Filters.eq("employeeid",employee);
    	
    	return collection.find(filter).into(new ArrayList<>());
    }
    public int findPartidaKop(){

  	collection.countDocuments();
  	
 	return (int) collection.countDocuments();
 }
    

} 

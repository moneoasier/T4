package eus.uni.dam.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.management.Query;

import eus.uni.dam.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

@Repository
public class PartidaDAO {
	@Autowired
    private MongoClient client;
    private MongoCollection<Partida> collection;

    @PostConstruct
    void datuakKargatu() {
        collection = client.getDatabase("datuak").getCollection("puntuazioa",Partida.class);
    }
    public List<Partida> findAll(){
    	return collection.find().into(new ArrayList<>());
    }
    
    
    public static List<Partida> findDate(){

    	return null;
    }
    

} 
package eus.uni.dam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import eus.uni.dam.model.Partida;

@Repository
public class PartidaDao {
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
}

package config;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.lang.UsesSunMisc;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import eus.uni.dam.HrEmployee;
import eus.uni.dam.ManagementDAO;
import eus.uni.dam.PartidakPartidak;
import eus.uni.dam.ResPartner;


public class ImportConfig {
	static List<PartidakPartidak> partidak = new ArrayList<>();
	static List<HrEmployee> employees = new ArrayList<>();
	static List<PartidakPartidak>partidamongo= new ArrayList<>();
	static ApplicationContext exportContext = new AnnotationConfigApplicationContext(Postgreconfig.class);
	static ManagementDAO dout = exportContext.getBean(ManagementDAO.class);
	
	
	public static void main(String[] args) {

		employees = dout.getEmployees();
		partidak=dout.getPartidak();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	

		LocalDateTime date = LocalDateTime.now();
		JSONParser parser = new JSONParser();
	
		try {
		
	            
			JSONArray a = (JSONArray) parser.parse(new FileReader("c:\\prueba.json"));
			
			int i=partidak.size();
			int g = partidak.size();


				for (Object o : a) {
				
				JSONObject jsonObject = (JSONObject) o;
				String puntuazioa = String.valueOf(jsonObject.get("puntuazioa"));
				String adina = String.valueOf(jsonObject.get("adina"));
				String departamentua = String.valueOf(jsonObject.get("departamentua"));
				date = LocalDateTime.parse((String) jsonObject.get("data"),formatter);
				String employeeid = (String) String.valueOf(jsonObject.get("employeeid"));
				

				PartidakPartidak p = new PartidakPartidak(++i,Integer.parseInt(adina),date,departamentua,Integer.parseInt(employeeid),++g,Integer.parseInt(puntuazioa));
				System.out.println(p);
				partidamongo.add(p);
				dout.update(p);

			}
				
				
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		
		
		
		  CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
	        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
	        
	        String uri = "mongodb://192.168.65.4:27017/";
	        
	        
	        try (MongoClient mongoClient = MongoClients.create(uri)) {
	            MongoDatabase database = mongoClient.getDatabase("datuak").withCodecRegistry(pojoCodecRegistry);
	            MongoCollection<Document> collection = database.getCollection("puntuazioa");
	     
	      
	            for(PartidakPartidak p:partidamongo) {
	            
	            	
	            	collection.insertOne(new Document().append("_id", new ObjectId()).append("partidaId", p.getPartidaId()).append("puntuazioa", p.getPuntuazioa()).append("data", p.getData()).append("employeeid",p.getEmployeeid()).append("adina", p.getAdina()).append("departamentua", p.getDepartamentua()));
	            	
	            	
	            	System.out.println(p);
	            	
	            }
	            
	            System.out.println("updated succesfully!!");


	            
	        }
	        
	        
	        
	        
	        
	       
		
		

	}

}
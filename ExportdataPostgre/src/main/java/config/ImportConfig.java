package config;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import eus.uni.dam.HrEmployee;
import eus.uni.dam.ManagementDAO;
import eus.uni.dam.PartidakPartidak;


public class ImportConfig {
	static List<PartidakPartidak> partidak = new ArrayList<>();
	static List<HrEmployee> employees = new ArrayList<>();
	static List<PartidakPartidak> partidamongo = new ArrayList<>();
	static ApplicationContext exportContext = new AnnotationConfigApplicationContext(Postgreconfig.class);
	static ManagementDAO dout = exportContext.getBean(ManagementDAO.class);

	public static void main(String[] args) throws IOException {

		int hariZenbatzailea = 0;
		HariZerbitzaria hariZerbitzaria;

		while (true) {

			System.out.println("Service started, waiting for connection");
			// Create ServerSocket object, bind port, start waiting for connection
			ServerSocket ss = new ServerSocket(8888);
			// accept method, return socket object
			Socket server = ss.accept();

			BufferedInputStream bis = new BufferedInputStream(server.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\prueba.json"));

			hariZenbatzailea++;
			hariZerbitzaria = new HariZerbitzaria(hariZenbatzailea, server, bis, bos);
			hariZerbitzaria.start(); // haria martxan jarri eta buklean jarraitu

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			server.close();
			ss.close();

			System.out.println("Upload succeeded");

			employees = dout.getEmployees();
			partidak = dout.getPartidak();

			LocalDateTime date = LocalDateTime.now();
			JSONParser parser = new JSONParser();

			try {

				JSONObject a = (JSONObject) parser.parse(new FileReader("C:\\prueba.json"));

				int i = partidak.size();
				int g = partidak.size();

				JSONObject jsonObject = (JSONObject) a;
				String puntuazioa = String.valueOf(jsonObject.get("puntuazioa"));
				String adina = String.valueOf(jsonObject.get("adina"));
				String departamentua = String.valueOf(jsonObject.get("departamentua"));
				String employeeid = (String) String.valueOf(jsonObject.get("employeeid"));

				PartidakPartidak p = new PartidakPartidak(++i, Integer.parseInt(adina), date, departamentua,
						Integer.parseInt(employeeid), ++g, Integer.parseInt(puntuazioa));
				System.out.println(p);
				partidamongo.add(p);
				dout.update(p);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
			CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),
					fromProviders(pojoCodecProvider));

			String uri = "mongodb://192.168.65.4:27017/";

			try (MongoClient mongoClient = MongoClients.create(uri)) {
				MongoDatabase database = mongoClient.getDatabase("datuak").withCodecRegistry(pojoCodecRegistry);
				MongoCollection<Document> collection = database.getCollection("puntuazioa");

				for (PartidakPartidak p : partidamongo) {

					collection.insertOne(new Document().append("_id", new ObjectId())
							.append("partidaId", p.getPartidaId()).append("puntuazioa", p.getPuntuazioa())
							.append("data", p.getData()).append("employeeid", p.getEmployeeid())
							.append("adina", p.getAdina()).append("departamentua", p.getDepartamentua()));

					System.out.println(p);

				}

				System.out.println("updated succesfully!!");
				partidamongo.clear();

			}

		}

	}

}
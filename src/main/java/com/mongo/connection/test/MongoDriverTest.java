package com.mongo.connection.test;
import java.text.ParseException;
import java.util.stream.StreamSupport;

// import org.bson.Document;

/*
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
*/

public class MongoDriverTest {

	private static String LOCAL_HOST = "localhost";

	private static String HOST = LOCAL_HOST;

	private static String[] PORTS = { HOST + ":" + 27018, HOST + ":" + 27019, HOST + ":" + 27020 };

	private static String CONFIG1 = "root:root";
	private static String CONFIG2 = "test?readPreference=nearest&replicaSet=hiperiondevelreplicaset&authSource=admin";

	private static String createConnectionString() {
		StringBuilder urlBuilder = new StringBuilder();

		String ports = String.join(",", PORTS);

		System.out.println(ports);

		urlBuilder.append("mongodb://").append(CONFIG1).append("@").append(ports).append("/").append(CONFIG2);

		return urlBuilder.toString();
	}

	public static void main(String[] args) throws ParseException {

		String url = createConnectionString();

		try {
/*
			MongoClient mongo = MongoClients.create(url);

			MongoDatabase db = mongo.getDatabase("admin");

			System.out.println("Connected to MongoDB database: " + db.getName());
			 
			 StreamSupport.stream(db.listCollectionNames().spliterator(), false)
					.forEach(item -> System.out.println(item));

			Document replicaDoc = db.runCommand(new Document("replSetGetStatus", 1));

			System.out.println("Replicaset name: " + replicaDoc.getString("set"));

			System.out.println("Member's data:");
			for (Document doc : replicaDoc.getList("members", Document.class)) {
				System.out.println("    Name: " + doc.getString("name"));
				System.out.println("    Health: " + (doc.getDouble("health") == 1 ? "UP" : "DOWN"));
				System.out.println("    State: " + doc.getString("stateStr"));
				System.out.println();
			}
*/
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
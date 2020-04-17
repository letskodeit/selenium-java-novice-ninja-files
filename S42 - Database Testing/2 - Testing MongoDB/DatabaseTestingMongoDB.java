package tutorialselenium;

import org.bson.Document;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
// Download Driver - http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/installation-guide/
public class DatabaseTestingMongoDB {
	
	MongoClient mongoClient = null;
	MongoDatabase db = null;

	@BeforeClass
	public void beforeClass() {
		try {
			// STEP 1: Connect to database
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDatabase("users");
			System.out.println("Connect to database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	@Test
	public void test() throws Exception {
		try {
			// STEP 2: Get Collection
			MongoCollection<Document> table = db.getCollection("user_info");
			// STEP 3: Extract Data
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("last_name", "Scott");
			FindIterable<Document> cursor = table.find(searchQuery);
			
			// STEP 4: Iterate over data
			for (Document obj : cursor) {
				String lastName = obj.getString("last_name");
				System.out.println(lastName);
				System.out.println("*************************");
				System.out.println(obj.toString());
				
				Assert.assertEquals("", "");
			}
			
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
}
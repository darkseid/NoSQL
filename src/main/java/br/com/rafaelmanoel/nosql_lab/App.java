package br.com.rafaelmanoel.nosql_lab;

import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;

import br.com.rafaelmanoel.nosql_lab.model.MongoConfiguration;
import br.com.rafaelmanoel.nosql_lab.model.ScoreEntry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

    
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
        
        System.out.println("Mongo loaded.");
        
        mongoOperation.dropCollection("scoreentry");
        
        Set<String> collectionNames = mongoOperation.getCollectionNames();
        for (String name : collectionNames) {
        	System.out.println(">> Collection: " + name);
        }
        
        ScoreEntry scoreEntry = new ScoreEntry();
        scoreEntry.setScore(11);
        scoreEntry.setUserId(new ObjectId());
        
        mongoOperation.save("scoreentry", scoreEntry);
        
        
        System.out.println("Recorded");
        
        mongoOperation.insert(scoreEntry);
        
        
        System.out.println("Listing scores");
        
        List<ScoreEntry> collection = mongoOperation.getCollection("scoreentry", ScoreEntry.class);
        for (ScoreEntry s : collection) {
        	System.out.println(s);
        }
        
        System.out.println("Scores listed");
    	
    }
}

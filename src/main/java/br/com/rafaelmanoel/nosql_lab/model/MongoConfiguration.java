/**
 * 
 */
package br.com.rafaelmanoel.nosql_lab.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;

/**
 * @author rafael
 *
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

	 
		@Override
		public @Bean Mongo mongo() throws Exception {
	 
			return new Mongo("localhost");
		}
	 
		@Override
		public @Bean MongoTemplate mongoTemplate() throws Exception {
	 
			return new MongoTemplate(mongo(),"testDb","rankingCollection");
		}

}

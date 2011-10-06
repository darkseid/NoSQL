/**
 * 
 */
package br.com.rafaelmanoel.nosql_lab.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.mapping.Document;

/**
 * @author rafael
 *
 */
@Document
public class ScoreEntry {

	@Id
	private ObjectId userId;
	private long score;
	
	
	
	
	public ObjectId getUserId() {
		return userId;
	}
	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreEntry [userId=" + userId + ", score=" + score + "]";
	}
	
}

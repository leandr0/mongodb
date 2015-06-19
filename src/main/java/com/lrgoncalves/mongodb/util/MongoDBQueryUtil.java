/**
 * 
 */
package com.lrgoncalves.mongodb.util;



/**
 * @author lrgoncalves
 *
 */
public class MongoDBQueryUtil {

	public static final String OBJECT_ID = "_id";

	private String collectionName;
	
	public MongoDBQueryUtil(final String collectionName) {
		this.collectionName = collectionName;
	}
	
	public MongoDBQueryUtil() {
		this.collectionName = null;
	}

	
	
	public String getCollectionName() {
		CommonsChecker.checkCollectionName(collectionName);
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
}
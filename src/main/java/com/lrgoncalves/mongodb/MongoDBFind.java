/**
 * 
 */
package com.lrgoncalves.mongodb;

import org.bson.types.ObjectId;

import com.lrgoncalves.mongodb.driver.MongoDBDriver;
import com.lrgoncalves.mongodb.util.MongoDBQueryUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import static com.lrgoncalves.mongodb.util.MongoDBQueryUtil.*;

/**
 * @author lrgoncalves
 *
 */
public class MongoDBFind {

	protected MongoDBDriver mongoDBDriver;	

	private MongoDBQueryUtil mongoDBQuery;

	public MongoDBFind() {
		mongoDBQuery = new MongoDBQueryUtil();
	}
	
	public MongoDBFind(final String collectionName) {
		mongoDBQuery = new MongoDBQueryUtil(collectionName);
	}
	
	
	public DBObject find(final String collecionName){
		
		return null;
	}
	
	public DBObject findDocumentById(final String collectionName, final String objectIdValue){
		
		BasicDBObject query = new BasicDBObject();
	    query.put(OBJECT_ID, new ObjectId(objectIdValue));
	    
	    //TODO
	    mongoDBDriver = new MongoDBDriver();
	    
	    return (DBObject) mongoDBDriver.connect().createCollection(collectionName).findOne(query);
		
	}
	
	public DBObject findDocumentById(final String objectIdValue){
		
		return findDocumentById(mongoDBQuery.getCollectionName(), objectIdValue);
		
	}
	
	public ObjectId getId(final DBObject dbObject){
		return (ObjectId) dbObject.get(OBJECT_ID);
	}
}
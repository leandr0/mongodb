/**
 * 
 */
package com.lrgoncalves.mongodb;

import static com.lrgoncalves.mongodb.util.XMLConverter.XmlToJson;

import java.io.IOException;
import java.io.InputStream;

import com.lrgoncalves.mongodb.driver.MongoDBDriver;
import com.lrgoncalves.mongodb.util.MongoDBQueryUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * @author lrgoncalves
 *
 */
public class MongoDBInsert{

	protected MongoDBDriver mongoDBDriver;	

	private MongoDBQueryUtil mongoDBQuery;
	
	private DBCollection collection;
	
	public MongoDBInsert() {
		mongoDBQuery = new MongoDBQueryUtil();
		mongoDBDriver 	= new MongoDBDriver().connect();
	}
	
	public MongoDBInsert(final String collectionName) {
		mongoDBQuery 	= new MongoDBQueryUtil(collectionName);
		mongoDBDriver 	= new MongoDBDriver().connect();
		collection 		= mongoDBDriver.createCollection(collectionName);
	}
	
	/**
	 * 
	 * @param xml
	 * @return
	 * @throws IOException
	 */
	public BasicDBObject insertXMLConvertingToJSON(final InputStream xml, final String collectionName) throws IOException{
		return insert(XmlToJson(xml),collectionName);		
	}

	/**
	 * 
	 * @param xml
	 * @return
	 */
	public BasicDBObject insertXMLConvertingToJSON (final String xml, final String collectionName){
		return insert(XmlToJson(xml),collectionName); 
	}	

	public BasicDBObject insert(final String json, final String collectionName){
		
		checkCollectionStatus(collectionName);
		
		BasicDBObject basicDBObject = (BasicDBObject)JSON.parse(json);

		collection.insert(basicDBObject);

		return basicDBObject;
	}

	public BasicDBObject insert(final DBObject json, final String collectionName){
		checkCollectionStatus(collectionName);
		collection.insert(json);
		return (BasicDBObject) json;
	}
	
	private void checkCollectionStatus(final String collectionName){
		if(collection == null || collection.getName() != collectionName){
			collection = mongoDBDriver.createCollection(collectionName);
		}
	}
	
	/**
	 * 
	 * @param xml
	 * @return
	 * @throws IOException
	 */
	public BasicDBObject insertXMLConvertingToJSON(final InputStream xml) throws IOException{
		
		return insertXMLConvertingToJSON(xml, mongoDBQuery.getCollectionName());		
	}

	/**
	 * 
	 * @param xml
	 * @return
	 */
	public BasicDBObject insertXMLConvertingToJSON (final String xml){
		return insertXMLConvertingToJSON(xml, mongoDBQuery.getCollectionName()); 
	}	

	public BasicDBObject insert(final String json){
		return insert(json, mongoDBQuery.getCollectionName());
	}

	public BasicDBObject insert(final DBObject json){
		return insert(json, mongoDBQuery.getCollectionName());
	}
}
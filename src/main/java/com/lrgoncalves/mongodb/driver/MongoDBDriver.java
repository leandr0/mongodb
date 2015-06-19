/**
 * 
 */
package com.lrgoncalves.mongodb.driver;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.lrgoncalves.mongodb.util.CommonsChecker;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @author lrgoncalves
 *
 */
public class MongoDBDriver {

	private DB db;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String host 	= "localhost:9090,agdfhafdsahgd,owuyrirtywiru";
		String [] hosts = host.split(",");
		
		List<ServerAddress> serverAddresses = new LinkedList<ServerAddress>();
		
		for(String hostAddress : hosts){
			try {
				System.out.println(hostAddress);
				serverAddresses.add(new ServerAddress(hostAddress));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	public MongoDBDriver connect(){

		try{

			MongoCredential credential = MongoCredential.createCredential("test", "test", "123456".toCharArray());
			ServerAddress serverAddress = new ServerAddress("localhost" , 27017 );
			
			//MongoClientURI uri = new MongoClientURI("mongodb://test:123456@localhost:27017/test");
			
			MongoClient mongoClient = new MongoClient/*(uri);*/(Arrays.asList(serverAddress,serverAddress),Arrays.asList(credential));
			//MongoClient mongoClient = new MongoClient( "54.207.247.174" , 8080 );	
			
			
			db = mongoClient.getDB("test");

			return this;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public DBCollection createCollection(final String collectionName){
		CommonsChecker.checkCollectionName(collectionName);
		return db.getCollection(collectionName);
	}
}
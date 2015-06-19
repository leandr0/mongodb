/**
 * 
 */
package com.lrgoncalves.mongodb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.bson.types.ObjectId;

import com.lrgoncalves.mongodb.util.XMLConverter;
import com.mongodb.BasicDBObject;

/**
 * @author lrgoncalves
 *
 */
public class MainMaster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		try{
			insert();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private static void find(){
		final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>"; 

		MongoDBInsert insertInstance = new MongoDBInsert("results");

		MongoDBFind findInstance = new  MongoDBFind();

		ObjectId objectIdValue = findInstance.getId(insertInstance.insertXMLConvertingToJSON(xml));

		System.out.println(objectIdValue);



		System.out.println(findInstance.findDocumentById( objectIdValue.toString()));


		///db.results.find({"_id": ObjectId("54e25d85bd5e49710710eaee")})
	}

	private static void insert(){
		try{

			final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>"; 

			//final File xmlFile = new File(System.getProperty("user.dir")+File.separator+"xml"+File.separator+"catalog.xml");

			//final FileInputStream fileInputStream = new FileInputStream(xmlFile);

			MongoDBInsert instance = new MongoDBInsert("resultado");

			//MongoDBInsert instance = new MongoDBInsert();
			//System.out.println(instance.getId(instance.insertXMLConvertingToJSON(fileInputStream,"results")));

			BasicDBObject request = new BasicDBObject();

			request.append("type", "request");
			request.append("business_operation", "quotation");

			BasicDBObject payload = new BasicDBObject();
			payload.append("type", "json");
			payload.append("content", XMLConverter.XmlToJson(xml));

			request.append("payload", payload);

			//System.out.println(instance.getId(instance.insertXMLConvertingToJSON(xml/*,"results"*/)));

			instance.insert(request,"results");

		}catch(Exception t){
			t.printStackTrace();
		}
	}

}

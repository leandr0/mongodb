/**
 * 
 */
package com.lrgoncalves.mongodb.util;

import java.io.IOException;
import java.io.InputStream;

import org.json.XML;

import sun.misc.IOUtils;

/**
 * @author lrgoncalves
 * 
 */
public class XMLConverter {

	private static final int 		LENGTH_INT_MAX_VALUE 	= -1;
	private static final boolean 	READ_ALL_DOCUMENT 		= true;
	private static final String 	EMPTY_JSON 				= "{}";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//org.json.json
	//20140107
	/**
	 * 
	 * @param xml as Inputstream
	 * @return Json as String
	 * @throws IOException {@literal to conversion performance}
	 * @throws IllegalArgumentException {@literal to validation statements}
	 */
	public static String XmlToJson(final InputStream xml) throws IOException{
		
		if(xml == null){
			throw new IllegalArgumentException("The XML stream must not be null");
		}
		
		return XmlToJson(new String(IOUtils.readFully(xml, LENGTH_INT_MAX_VALUE, READ_ALL_DOCUMENT)));
	}

	/**
	 * 
	 * @param xml as String
	 * @return Json as String
	 * @throws IOException {@literal to conversion performance}
	 * @throws IllegalArgumentException {@literal to validation statements}
	 */
	public static String XmlToJson (final String xml){
		if(xml == null || xml.isEmpty()){
			throw new IllegalArgumentException("The xml is empty");
		}

		String json = XML.toJSONObject(xml).toString();

		if(json.isEmpty() || json.trim().equals(EMPTY_JSON)){
			throw new IllegalArgumentException("The xml is empty");
		}
		
		return json;
	}
}
/**
 * 
 */
package com.lrgoncalves.mongodb.util;

/**
 * @author lrgoncalves
 *
 */
public class CommonsChecker {

	public static void checkCollectionName(final String collectionName){
		if(collectionName == null || collectionName.trim().isEmpty()){
			throw new IllegalArgumentException("CollectionName value is invalid.");
		}
	}
	
}

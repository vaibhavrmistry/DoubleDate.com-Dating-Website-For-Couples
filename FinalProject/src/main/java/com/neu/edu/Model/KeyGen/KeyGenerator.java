package com.neu.edu.Model.KeyGen;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

public class KeyGenerator {

	//	private SecureRandom random = new SecureRandom();
	//
	//	public String nextTokenId(){
	//		return new BigInteger(130, random).toString(32);
	//	}

	public static String genKey(){
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}

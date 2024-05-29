package com.spring.example.app.JWT;

import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.jackson.JacksonProperties.Datatype;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

public class GenerateSecretKey {

	public static void main(String[] args) {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		// Convert the secret key to a base64-encoded string
		String secretString = Encoders.BASE64.encode(key.getEncoded());

		// Print the secret key
		System.out.println("Generated 256-bit secret key: " + secretString);
	}

}

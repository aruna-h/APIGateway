package com.bridgelabz.zuulGatewayApplication.utility;


import java.util.Date;


import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author bridgelabz
 * @since 9/08/2018 <br>
 *        <p>
 *        Entity giving information about the tokengenerator which create token and parse token <br>
 *        </p>
 */
@Service
public class TokenGenerator {
	public static String createToken(String id) {
		final String KEY = "what";
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Date startTime = new Date();
		Date expireTime = new Date(startTime.getTime() + (1000 * 60 * 60 * 24));

		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(startTime).setExpiration(expireTime)
				.signWith(signatureAlgorithm, KEY);
		return builder.compact();
	}

	/**
	 * function for parsing jwt
	 * 
	 * @param jwt
	 * @return
	 */
	public Claims parseJwt(String jwt) {
		final String KEY = "what";
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt).getBody();
	}

	
}

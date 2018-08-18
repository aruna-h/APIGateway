package com.bridgelabz.zuulGatewayApplication.repository;

/**
 * @author bridgelabz
 * @since 5/08/2018 <br>
 *        <p>
 *        Business Entity of redisrepository <br>
 *        </p>
 */
public interface RedisRepository {

	void saveInRedis(String token);

	String getFromRedis(String userId);


}

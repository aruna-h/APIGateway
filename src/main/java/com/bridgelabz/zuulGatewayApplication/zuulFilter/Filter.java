package com.bridgelabz.zuulGatewayApplication.zuulFilter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.context.RequestContext;

import io.jsonwebtoken.Claims;

import com.bridgelabz.zuulGatewayApplication.repository.RedisRepository;
import com.bridgelabz.zuulGatewayApplication.utility.Messages;
import com.bridgelabz.zuulGatewayApplication.utility.TokenGenerator;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author bridgelabz
 * @since 9/08/2018 <br>
 *        <p>
 *        Entity giving information about the pre-filter using zuul api-gateway
 *        <br>
 *        </p>
 */
public class Filter extends ZuulFilter {
	@Autowired
	TokenGenerator tokengenerator;
	@Autowired
	RedisRepository redisrepository;
	@Autowired
	Messages messages;
	private static Logger logger = LoggerFactory.getLogger(Filter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getRequestURI().startsWith("/note/note/")) {
			String token = request.getHeader("token");
			if (token == null) {

				try {
					throw new Exception(messages.get("100"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			logger.info("token from header : " + token);
			Claims userId = tokengenerator.parseJwt(token);
			if (userId == null) {
				try {
					throw new Exception(messages.get("101"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			logger.info("userId : " + userId);
			// String redisToken = (String) redisrepository.getFromRedis(userId.getId());
			// System.out.println("token from redis : " + redisToken);
			// if (redisToken != null) {
			ctx.addZuulRequestHeader("userId", userId.getId());
			// request.setAttribute("userId", userId);
			logger.info("userId : " + userId);
			return userId;
			// }
		}
		return null;
	}
}

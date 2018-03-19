package com.sprbt.springBootMvn;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {

	    Jedis jedis = new Jedis("192.168.1.137", 6379);
	    System.out.println(jedis.ping());
	}
	
}

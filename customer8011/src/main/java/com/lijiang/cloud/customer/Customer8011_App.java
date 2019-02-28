package com.lijiang.cloud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.devtools.restart.RestartApplicationListener;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Customer8011_App {
    public static void main(String[] args){
        SpringApplication.run( Customer8011_App.class,args );
    }
}

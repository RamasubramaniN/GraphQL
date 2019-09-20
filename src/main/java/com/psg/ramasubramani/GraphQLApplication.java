package com.psg.ramasubramani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rn5
 * Application Root.
 *
 */
@SpringBootApplication
public class GraphQLApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(GraphQLApplication.class, args);
        System.out.println("GraphQL Application is up and running.");
    }
    
}

package com.mizi.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

}

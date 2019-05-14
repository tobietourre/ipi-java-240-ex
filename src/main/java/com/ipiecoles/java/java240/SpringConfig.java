package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class SpringConfig {

    @Value("${bitcoinService.forceRefresh}")
    Boolean forceRefresh;

    @Autowired
    @Qualifier("withoutCache")
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(forceRefresh);
        return bitcoinService;
    }

    public static void main(String[] args){
        System.out.println("Avant initialisation du contexte");
        SpringApplication.run(SpringConfig.class, args);
        System.out.println("Avant initialisation du contexte");
    }
}

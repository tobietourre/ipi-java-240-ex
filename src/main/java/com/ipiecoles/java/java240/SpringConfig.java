package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration

@ComponentScan(basePackages = "com.ipiecoles.java.java240")
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Value("${bitcoinService.forceRefresh}")
    Boolean forceRefresh;

    @Bean(name = "bitcoinServiceWithoutCache")
    @Scope("singleton")
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(forceRefresh);
        return bitcoinService;
    }


    /*
    @Bean(name = "webPageManager")
    @Scope("singleton")
    public WebPageManager webPageManager(){
        return new WebPageManager();
    }

    @Bean(name = "produitManager", initMethod = "initialiserCatalogue")
    @Scope("singleton")
    public ProduitManager produitManager(){
        ProduitManager pm = new ProduitManager();
        pm.setBitcoinService(bitcoinServiceWithCache());
        pm.setWebPageManager(webPageManager());
        return pm;
    }*/


}

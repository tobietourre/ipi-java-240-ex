package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
    @Bean(name = "bitcoinServiceWithoutCache")
    @Scope("singleton")
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(true);
        bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    @Bean(name = "bitcoinServiceWithCache")
    @Scope("singleton")
    public BitcoinService bitcoinServiceWithCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(false);
        bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    @Bean(name = "webPageManager")
    @Scope("singleton")
    public WebPageManager webPageManager(){
        return new WebPageManager();
    }

    @Bean(name = "produitManager")
    @Scope("singleton")
    public ProduitManager produitManager(){
        ProduitManager pm = new ProduitManager();
        pm.setBitcoinService(bitcoinServiceWithCache());
        pm.setWebPageManager(webPageManager());
        return pm;
    }
}

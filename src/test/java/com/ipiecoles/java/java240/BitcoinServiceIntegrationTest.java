package com.ipiecoles.java.java240;

import com.ipiecoles.java.java240.BitcoinService;
import com.ipiecoles.java.java240.WebPageManager;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class BitcoinServiceIntegrationTest {

    @Autowired
    private BitcoinService bitcoinServiceWithoutCache;

    @Test
    public void getBitcoinRateWithoutCache() throws IOException {
        //Given
        /*String apiResponse = webPageManager.getPageContents(apiUrl);
        apiResponse = apiResponse.replace("{\"EUR\":","");
        apiResponse = apiResponse.replace("}","");
        Double rateExpected = Double.parseDouble(apiResponse);*/
        //When
        Double rate = bitcoinServiceWithoutCache.getBitcoinRate();

        //Then
        Assertions.assertThat(rate).isNotNull();
        Assertions.assertThat(rate).isPositive();
    }
}


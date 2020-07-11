package com.jy.casestudy.bitcoin;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.service.account.AccountService;

import java.io.IOException;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-10 12:07
 **/
public class AccountInfoCase {
    public static void main(String[] args) throws IOException {
        ExchangeSpecification exSpec = new BitstampExchange().getDefaultExchangeSpecification();
        exSpec.setUserName("34387");
        exSpec.setApiKey("a4SDmpl9s6xWJS5fkKRT6yn41vXuY0AM");
        exSpec.setSecretKey("sisJixU6Xd0d1yr6w02EHCb9UwYzTNuj");
        Exchange bitStamp = ExchangeFactory.INSTANCE.createExchange(exSpec);
        System.out.println(bitStamp);

        // Get the account information
        AccountService accountService = bitStamp.getAccountService();
        AccountInfo accountInfo = accountService.getAccountInfo();
        System.out.println(accountInfo.toString());
    }
}

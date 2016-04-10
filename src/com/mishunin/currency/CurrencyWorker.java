package com.mishunin.currency;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mishunin
 * @version $Id$
 */
public class CurrencyWorker {

    private static String DAILY_INFO_URI = "http://www.cbr.ru/scripts/XML_daily.asp";
    private static String DAILY_DYNAMIC_INFO_URI = "http://www.cbr.ru/scripts/XML_dynamic.asp";
    private static final String DATE_REQ = "date_req";
    private static final String DATE_REQ_1 = "date_req1";
    private static final String DATE_REQ_2 = "date_req2";
    private static final String VAL_NM_RQ = "VAL_NM_RQ";

    public String loadCurrency(String code) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(createURI(code));
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    private URI createURI(String code) throws URISyntaxException {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        return new URI(DAILY_DYNAMIC_INFO_URI + "?" + DATE_REQ_1 + "=" + date + "&" + DATE_REQ_2 + "=" + date + "&" + VAL_NM_RQ + "=" + code);
    }

}

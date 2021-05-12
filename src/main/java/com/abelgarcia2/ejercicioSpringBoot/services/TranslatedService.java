package com.abelgarcia2.ejercicioSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class ResponseData {
    public String translatedText;
    public int match;
}

class Traduccion {
    ResponseData responseData;
}

@Service
public class TranslatedService {
    @Autowired
    RestTemplate restTemplate;

    public String traduce(String palabra) {
        String url = "https://api.mymemory.translated.net/get?q=" + palabra + "&langpair=es|en";
        Traduccion json = restTemplate.getForObject(url, Traduccion.class);
        return json.responseData.translatedText;
    }
}
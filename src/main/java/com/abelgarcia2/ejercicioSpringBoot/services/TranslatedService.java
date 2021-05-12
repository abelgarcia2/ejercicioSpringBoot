package com.abelgarcia2.ejercicioSpringBoot.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class Matches {
    public String translation;
}

class Traduccion {
    public ArrayList<Matches> matches = new ArrayList<Matches>();
}

@Service
public class TranslatedService {
    @Autowired
    RestTemplate restTemplate;

    public String traduce(String palabra) {
        String url = "https://api.mymemory.translated.net/get?q=" + palabra + "&langpair=es|en";
        Traduccion json = restTemplate.getForObject(url, Traduccion.class);
        return json.matches.get(0).translation;
    }
}
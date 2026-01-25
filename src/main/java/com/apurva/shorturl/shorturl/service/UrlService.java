package com.apurva.shorturl.shorturl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.apurva.shorturl.shorturl.model.Url;
import com.apurva.shorturl.shorturl.repository.UrlRepository;
import com.apurva.shorturl.shorturl.util.ShortUrlGenerator;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    public ResponseEntity<String> shortenUrl(String longUrl){
        Optional<Url> existing=urlRepository.findByLongUrl(longUrl);
        if(existing.isPresent())
        {
            return new ResponseEntity<>(existing.get().getShortUrl(),HttpStatus.OK);
        }

        String shortUrl;
        Url url=new Url();
        do{
            shortUrl=ShortUrlGenerator.generate();
        }while(urlRepository.findByShortUrl(shortUrl).isPresent());

        url.setShortUrl(shortUrl);
        url.setLongUrl(longUrl);
        urlRepository.save(url);
        return new ResponseEntity<>(shortUrl,HttpStatus.CREATED);
    }

    public String getLongUrl(String shortUrl)
    {
        Optional<Url> existing= urlRepository.findByShortUrl(shortUrl);
        if(existing.isPresent())
        {
            return existing.get().getLongUrl();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Short URL does not exist"); 
    }
}

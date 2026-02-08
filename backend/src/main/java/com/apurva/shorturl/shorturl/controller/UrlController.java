package com.apurva.shorturl.shorturl.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.apurva.shorturl.shorturl.dto.ShortenRequest;
import com.apurva.shorturl.shorturl.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/shortenUrl")
    public ResponseEntity<String> shortenUrl(@Valid @RequestBody ShortenRequest request){
        return urlService.shortenUrl(request.getLongUrl());
    }

    @GetMapping("/{shortUrl}")
    public void redirectToOriginal(@PathVariable String shortUrl, HttpServletResponse response) throws IOException
    {
        String longUrl=urlService.getLongUrl(shortUrl);
        response.sendRedirect(longUrl);
    }
}

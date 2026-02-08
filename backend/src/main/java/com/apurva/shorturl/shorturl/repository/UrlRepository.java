package com.apurva.shorturl.shorturl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apurva.shorturl.shorturl.model.Url;

public interface UrlRepository extends JpaRepository<Url,Long> {

    Optional<Url> findByShortUrl(String shortUrl);

    Optional<Url> findByLongUrl(String longUrl);

}

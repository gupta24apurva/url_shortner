package com.apurva.shorturl.shorturl.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Data
public class ShortenRequest {

    @NotBlank(message="url is required")
    @URL(message="url must be valid")
    private String longUrl;
}

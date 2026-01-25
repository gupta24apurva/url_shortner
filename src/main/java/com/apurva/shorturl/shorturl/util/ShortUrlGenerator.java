package com.apurva.shorturl.shorturl.util;

import java.security.SecureRandom;

public class ShortUrlGenerator {
    public static final String BASE62="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final int length=7;

    public static final SecureRandom random=new SecureRandom();

    public static String generate()
    {
        StringBuilder sb=new StringBuilder(length);
        for(int i=0;i<length;i++)
        {
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }
        return sb.toString();
    }
}

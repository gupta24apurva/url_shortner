# URL Shortener – Spring Boot + MySQL

A backend URL shortener service built using **Spring Boot** and **MySQL**.  
It converts long URLs into short 7-character URLs and redirects users back to the original URL.

---

## 🚀 Features

- Shorten long URLs into 7-character short URLs  
- Redirect to original URL using the short URL  
- Idempotent behavior  
  - Same long URL → same short URL  
- URL validation using Hibernate Validator  
- MySQL persistence using JPA  
- Auto-generated timestamps  
- Frontend-ready redirect behavior (302)

---

## 🛠 Tech Stack

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Hibernate Validator  
- MySQL  
- Lombok  

---

## 📌 API Endpoints

### 🔹 Shorten URL

**POST** `/api/shortenUrl`

Request json:
{
  "longUrl": "https://www.google.com"
}

**GET** `/api/{shortUrl}`



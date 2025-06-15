# 🌍 Multi-Language Spring Boot Application

This project demonstrates a Spring Boot application with **internationalization (i18n)** support for **Uzbek**, **English**, and **Russian** languages. Based on the currently authenticated user's language preference, messages are returned in the appropriate locale.

---

## 🚀 Features

- 🌐 Dynamic message translation using Spring's `MessageSource`
- 🔐 Integration with Spring Security (uses authenticated user's preferred language)
- 🧠 Locale resolution based on the authenticated `User` entity
- 📁 Resource bundle files for UZ, EN, and RU (`.properties`)
- ✅ UTF-8 encoding support for Cyrillic characters (Russian)

---

## 🔐 How Language Is Resolved
The currently authenticated User object contains a Language enum (UZ, EN, RU). This is converted into a Locale and used to fetch the appropriate translation:

```java
User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
Locale locale = user.getLanguage().toLocale();
String message = messageSource.getMessage("user.welcome", null, locale);
```

## 👨‍💻 Author
Created by Abror Allaberganov – Java Backend Developer

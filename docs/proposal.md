---
layout: default
title: Project Proposal
---
# Hanover Community Marketplace Platform

## Project Overview
The project that I propose is te development of a Hanover student, staff, and faculty exclusive online marketplace. It would allow users to buy, sell, and trade items such as furniture, electronics, and textbooks on a trusted campus platform.

**Main Features:**
- **User Authentication:** Access to the platform would be restricted to verified hanover email addresses.
- **Listings:** The listings would be picture based and categorized for easier searching and listings.
- **Profiles and Reviews:** Each profile will be unique and have reviews and history attatched to their account.
- **Search and Filters/Categories:** There will be tools availiable to search and list items by category, price, etc.
- **Security and Safety:** Automated verification through verified Hanover emails restrics access, and meet up safety can be built in.
- **Device Accessibility:** This is intended to be avaliable and used on computers and mobile devices alike via web applications.

The aim for the platform would be to bring the convenience of exiting online markeplaces with the exclusivity of a campus restricted community.

---

## Comparing with Exesting Solutions

There are multiple existing platforms that have a variety of approaches to online marketplaces. Although they have their individual flaws, they have traits that can influence and improve the creation of a Hanover Campus exlusive marketplace.

- **Facebook Marketplace** [1]: This platform is tied to the social media profiles of the platform and excells is categorization and filtering. However, it has issues with scamming and shadey behavior.
- **Craigslist** [2]: This is a platform that has been around for a long time with little change. This leaves it with a dated design and interface as well as lacking security measures; however, it has a wide range of listing ability and browsing filters.
- **OfferUp** [3]: This is a modern platform that is focused on mobile device users. Nevertheless, it also suffers from trust issues between buyers and sellers.
- **VarageSale** [4]: This is a platform that focuses on community. It impliments admin verification for joining members. Although this is an imporvement for security, it is held back by its reliance on manual oversight rather than automated verification.
- **University Buy and Sell Groups** [5]: This platform, and others like it, are secondary sources that are run on social media platforms like Facebook. This allows for the convenience of a small local marketplace, but suffers a similar administration issue as Varagesale and is reliant on third party platforms.

When compared to these examples, the Hanover Marketplace would be able to provide a standalone and campus exclusive solution. It could also have a straighforward and streamlined design that focuses on ease of use.

---

## Technologies

There are two overarching sections of this project that need to be taken into consideration. The front end which the user will interact with, and the back end which takes care of all of the behind the scenes tasks. Thus, I will have these four sub-sections here for technologies; Things to learn, tools needed, front end, and back end. 

**Things to Learn**
- I will need to learn how to structure a full stack web application and how to connect the front end, back end, and database.
- I will have to learn how to impliment security features and authentication based on '@hanover.edu' email accounts.
- I will need to impliment a form of image storing and handling for item listings
- I will need to host and deploy a web application that can be accessed by others online

**Needed Tools**
- **Version Control ([GitHub](https://github.com)):** Version control will be needed to track progress and also for managing the projects repository.
- **IDE ([IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Visual Studio Code](https://code.visualstudio.com/)):** These are two options that can be used for coding and debugging.
- **Database Admin:** [pgAdmin](https://www.pgadmin.org/) can be used for PostgreSQL or SQLite browser tools.
- **Hosting and Deployment ([Render](https://render.com/) or [Railway](https://railway.app/)):** Free tiers can be used to host Java web applications with databases.
- **Image Hosting ([Cloudinary](https://cloudinary.com/)):** This is an example of a free to use service for storing and serving images for listings.

**Front End**
- **Thymeleaf** ([thymeleaf.org](https://www.thymeleaf.org/)): This is a server-side template engine which can be used to generate HTML pages directly from Java backend data.
- **Bootstrap** ([getbootstrap.com](https://getbootstrap.com/)): This is a CSS/JS library that provides layouts, navigation bars, cards, and forms which can help make the site appear more modern and mobile friendly without adding heavy amounts of design work.
- **HTML5, CSS3, JavaScript:** These are standard web technologies that are used to style and build UI.

**Back End**
- **Java 19:** The core programming language.
- **Spring Boot** ([spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)): This is a framework that makes building web applications more simple through its support for controllers, security, and embedded servers.
- **Spring Security** ([spring.io/projects/spring-security](https://spring.io/projects/spring-security)): This provides a tool which can be used for authentication and access restriction, allowing only Hanover email accounts.
- **Spring Data JPA** ([spring.io/projects/spring-data-jpa](https://spring.io/projects/spring-data-jpa)): This helps simplify database access through its use of repositories and automatic query generation.
- **SQLite** ([sqlite.org](https://www.sqlite.org/)): This is a lightweight and file based database for development.
- **PostgreSQL** ([postgresql.org](https://www.postgresql.org/)): This is a databse that is production ready and can be used for deployment, and it is supported by free hosting providers.


## References
[1] Facebook, *Facebook Marketplace*. [Online]. Avaliable: https://www.facebook.com/marketplace.

[2] Craigslist, *Craigslist Official Site*. [Online]. Avaliable: https://www.craigslist.org.

[3] OfferUp, *OfferUp Marketplace*. [Online]. Avaliable: https://offerup.com.

[4] VarageSale, *VarageSale Community Marketplace*. [Online]. Avaliable: https://www.varagesale.com.

[5] Facebook, *Yale Free and For Sale Group*. [Online]. Avaliable: https://www.facebook.com/groups/150454865086.
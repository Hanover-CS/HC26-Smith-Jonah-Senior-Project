---
layout: default
title: Project Proposal
---
# Hanover Community Marketplace Platform

## Project Overview
My proposed project is to develop an online marketplace which can only be accessed by Hanover students, faculty, and staff. It would allow users to buy, sell, and trade items such as textbooks, furniture, or electronics on a trustworthy and secure platform.

The aim of this platform is to combine the **convenience of existing online marketplaces** with the trust and security of a **campus-only community**. By doing so, one can more confidently ensure that transactions will be safer and that the user base is limited to verified Hanover email accounts.

**Main Features:**
- **User Authentication:** Access to the platform would be restricted to verified Hanover email addresses.  
- **Listings:** The listings would be picture-based and categorized for easier searching and browsing.  
- **Profiles and Reviews:** Each profile will be unique and have reviews and history attached to their account.  
- **Search and Filters/Categories:** There will be tools available to search and list items by category, price, etc.  
- **Security and Safety:** Automated verification through verified Hanover emails restricts access, and meet-up safety can be built in.  
- **Device Accessibility:** This is intended to be available and used on computers and mobile devices alike via web applications.  

---

## Comparing with Existing Solutions

There are multiple existing platforms that have a variety of approaches to online marketplaces. Although they have their individual flaws, they have traits that can influence and improve the creation of a Hanover campus exclusive marketplace.

- **Facebook Marketplace** [1]: This platform is tied to the social media profiles of the platform and excels in categorization and filtering. However, it has issues with scamming and shady behavior.  
- **Craigslist** [2]: This is a platform that has been around for a long time with little change. This leaves it with a dated design and interface as well as lacking security measures; however, it has a wide range of listing ability and browsing filters.  
- **OfferUp** [3]: This is a modern platform that is focused on mobile device users. Nevertheless, it also suffers from trust issues between buyers and sellers.  
- **VarageSale** [4]: This is a platform that focuses on community. It implements admin verification for joining members. Although this is an improvement for security, it is held back by its reliance on manual oversight rather than automated verification.  
- **University Buy and Sell Groups** [5]: This platform, and others like it, are secondary sources that are run on social media platforms like Facebook. This allows for the convenience of a small local marketplace, but suffers a similar administration issue as VarageSale and is reliant on third-party platforms.  

When compared to these examples, the Hanover Marketplace would be able to provide a **standalone** and **campus-exclusive solution**. It could also have a straightforward and streamlined design that focuses on ease of use.

---

## Technologies

The technologies section is divided into **five sub-sections**:  
1. **Things to Learn** – These are new skills that must be learned to complete the project.  
2. **Needed Tools** – A list of software and services required for development and deployment.  
3. **Front End** – A list of the technologies that will build the user interface.  
4. **Back End** – A list of the technologies that will handle server-side logic, authentication, and database management.  
5. **Alternative Technologies** – A section containing a discussion of other options considered and justification of chosen tools.  

**Things to Learn**
- I will need to learn how to structure a full stack web application and how to connect the front end, back end, and database.  
- I will have to learn how to implement security features and authentication based on '@hanover.edu' email accounts.  
- I will need to implement a form of image storage and handling for item listings.  
- I will need to host and deploy a web application that can be accessed by others online.  

**Needed Tools**
- **Version Control ([GitHub](https://github.com)):** Version control will be needed to track progress and also for managing the project's repository.  
- **IDE ([IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Visual Studio Code](https://code.visualstudio.com/)):** These are two options that can be used for coding and debugging.  
- **Database Admin:** [pgAdmin](https://www.pgadmin.org/) can be used for PostgreSQL or SQLite browser tools.  
- **Hosting and Deployment ([Render](https://render.com/) or [Railway](https://railway.app/)):** Free tiers can be used to host Java web applications with databases.  
- **Image Hosting ([Cloudinary](https://cloudinary.com/)):** This is an example of a free-to-use service for storing and serving images for listings.  

**Front End**
- **Thymeleaf** ([thymeleaf.org](https://www.thymeleaf.org/)): This is a server-side template engine which can be used to generate HTML pages directly from Java backend data.  
- **Bootstrap** ([getbootstrap.com](https://getbootstrap.com/)): This is a CSS/JS library that provides layouts, navigation bars, cards, and forms which can help make the site appear more modern and mobile-friendly without adding heavy amounts of design work.  
- **HTML5, CSS3, JavaScript:** These are standard web technologies that are used to style and build UI.  

**Back End**
- **Java 19:** This will be the core programming language.  
- **Spring Boot** ([spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)): This is a framework that makes building web applications simpler through its support for controllers, security, and embedded servers.  
- **Spring Security** ([spring.io/projects/spring-security](https://spring.io/projects/spring-security)): This provides a tool which can be used for authentication and access restriction, allowing only Hanover email accounts.  
- **Spring Data JPA** ([spring.io/projects/spring-data-jpa](https://spring.io/projects/spring-data-jpa)): This helps simplify database access through its use of repositories and automatic query generation.  
- **SQLite** ([sqlite.org](https://www.sqlite.org/)): This is a lightweight and file-based database for development.  
- **PostgreSQL** ([postgresql.org](https://www.postgresql.org/)): This is a database that is production-ready and can be used for deployment, and it is supported by free hosting providers.  

**Alternative Technologies**
For each core technology, alternatives were considered:  

- **Front End:** While *React* [6] or *Angular* could provide more dynamic single-page applications, they would inherently increase the complexity of the project and steepen the overall learning curve. I selected **Thymeleaf** because it works alongside Spring Boot seamlessly, reducing the complexity of the project as well as the time needed for setup.  
- **Database:** Alternatives like *MySQL* [7] are widely used, but **PostgreSQL** is more suited for production deployment due to its advanced queries and free-tier hosting options.  
- **Image Hosting:** Services such as *AWS S3* [8] are industry-standard; however, they require more setup and potential costs. I selected **Cloudinary** because of its free tier and simple integration with web apps.  

### Components and Connections
The system architecture will have **three primary components**:  
- The **front end** (Thymeleaf, Bootstrap, HTML/CSS/JS) will handle the rendering of user-facing pages.  
- The **back end** (Java 19, Spring Boot, Spring Security, JPA) will handle authentication, business logic, and requests.  
- The **database** (SQLite for development, PostgreSQL for deployment) will handle the storage of listings, users, and reviews.  

---

## References
[1] Facebook, *Facebook Marketplace*. [Online]. Available: https://www.facebook.com/marketplace.  
[2] Craigslist, *Craigslist Official Site*. [Online]. Available: https://www.craigslist.org.  
[3] OfferUp, *OfferUp Marketplace*. [Online]. Available: https://offerup.com.  
[4] VarageSale, *VarageSale Community Marketplace*. [Online]. Available: https://www.varagesale.com.  
[5] Facebook, *Yale Free and For Sale Group*. [Online]. Available: https://www.facebook.com/groups/150454865086.  
[6] React, *React Official Docs*. [Online]. Available: https://react.dev.  
[7] MySQL, *MySQL Official Site*. [Online]. Available: https://www.mysql.com.  
[8] Amazon, *AWS S3*. [Online]. Available: https://aws.amazon.com/s3.  
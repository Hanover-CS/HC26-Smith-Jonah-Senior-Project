---
layout: default
title: Project Proposal
---
# Hanover College Marketplace (HCM) Platform

## Project Overview
My proposed project is to develop an online marketplace which can only be accessed by Hanover students, faculty, and staff. It would allow users to buy, sell, and trade items such as textbooks, furniture, or electronics on a trustworthy and secure platform.

The aim of this platform is to combine the **convenience of existing online marketplaces** with the trust and security of a **campus-only community**. By doing so, one can more confidently ensure that transactions will be safer and that the user base is limited to verified Hanover email accounts.

**Main Features:**

- **User Authentication:** Access to the Hanover Marketplace platform would be restricted to solely verified Hanover College email addresses. Doing so will ensure that only members of the campus community would be able to access the application, in turn creating a more secure and trustworthy marketplace. The increase in security and trust would derive from the thorough prevention of spam, phishing, or fake accounts from interacting on the site, in turn improving trust and accountability when buying or selling items. 

- **Listings:** The listings on this web application would be picture-focused as opposed to being text heavy and unappealing. Listings will also be given numerous categories to ease the process of searching, browsing, and listing. Each listing will have images of the items in question, a brief description and statement of condition, as well as contact information. This will ensure that buyers have all the information they need about an item as well as contact information for the seller. 

- **Profiles and Reviews:** Each profile will be unique and attached to the Hanover community member's account. With this system in place buyers and sellers alike can build a rapport with their community, identifying and highlighting trustworthy and positive behavior.  

- **Search and Filters/Categories:** There will be categories for listing and searching for items. These may include price or condition, or they could include more in-depth searches like textbooks (possibly filtered by major), furniture, etc.  

- **Security and Safety:** Verification for the application could be completed autonomously through Hanover emails, relieving any need for admin observation and preventing fraudulent access. Other safety features could include suggested meeting locations on campus, suggestions for safe trading practices, reporting tools, etc. 

- **Device Accessibility:** This application is intended to be accessible on both computers and mobile devices, and as such will need to be developed as a web application. Proper scaling of pages for mobile uses and UI considerations for mobile users would encourage the use of the application on more devices that just laptops and desktops. 

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



**1. Things to Learn:**  

- **Full-Stack Development:** I will need to learn how to structure a full stack web app by connecting the front end, back end, and database into one system. This will include learning how to process client-side requests and how they are returned by the server. 

- **Front End Development:** I will need to grow in my ability to use HTML, CSS, and JavaScript as well as frameworks like **Bootstrap** and **Thymeleaf**. By doing so, I will be able to create a responsive environment that users can interact with.  

- **Back End Development:** I will need to expand my abilities with APIs and logic in reference to **Spring Boot** such as controllers and data layers.  

- **Security and Authentication:** I will need to learn how to use **Spring Security** to restrict access to verified *@hanover.edu* email accounts and how to manage login sessions.  

- **Database Management:** I will need to learn how to structure relational databases using **SQLite** for development and **PostgreSQL** for production. I will also need to learn how to interact with both of those services using **Spring Data JPA**.  

- **Image Hosting and Handling:** I will need to learn how to integrate **Cloudinary** for uploading, storing, and retrieving images for item listings.  

- **Deployment and Hosting:** I will need to learn how to deploy a web app and how to connect it to a production-ready database.  

- **Tools and Workflow:** I will need to learn how to use tools like **GitHub** version control, **pgAdmin**, and IDEs like **IntelliJ** alongside one another in my project’s workflow.  



**2. Needed Tools:**  

- **Version Control ([GitHub](https://github.com)):** GitHub will be used for managing the project's repository, tracking progress on the project, and for maintaining version control. It will also keep a history of commits, allowing for possible rollback of changes if needed. It also allows for branching and merging, which can be used to experiment with changes that may be large or of a "make or break" quality. IT can also be used for running automated testing and maintaining progress reports of time spent and changes made.

- **IDE ([IntelliJ IDEA](https://www.jetbrains.com/idea/)):** IntelliJ is compatible with Java and Spring Boot. It offers built-in tools for Spring Boot as well as database connections and Maven/Gradle builds. IntelliJ will be used for coding as well as debugging, adding plugins, and possibly running local servers.

- **Database Admin ([pgAdmin](https://www.pgadmin.org/) or SQLite):** These tools will allow for visualization, queries, and management of databases. pgAdmin will be paired efficiently with PostgreSQL, allowing for inspection of tables, running queries, and will ensure continuity between the application and database. Earlier on in development SQLite can be used for more simple debugging.

- **Hosting and Deployment ([Render](https://render.com/) or [Railway](https://railway.app/)):** These services allow free hosting for web applications and databases. Render would allow for automatic deployment whenever changes are pushed to the main GitHub branch. Railway also provides tools that simplify scalability. These resources would allow for the application to be accessible to real users while limiting the difficulty between development and deployment.

- **Image Hosting ([Cloudinary](https://cloudinary.com/)):** Cloudinary gives developers free access to image handling, uploading, scaling, and delivery. It is effective at quick delivery and formatting for varying devices. Rather than storing images directly in the database, Cloudinary will handle storage in the cloud and return secure URLs, in turn reducing the size and complexity of the database,



**3. Front End:**  

- **Thymeleaf** ([thymeleaf.org](https://www.thymeleaf.org/)): Thymeleaf allows for the deployment of HTML pages to be generated from data on the server-side. This could allow me to dynamically populate an item listing page with entries without the need for heavy front end frameworks. This, in turn, allows me to reuse templates across multiple pages.

- **Bootstrap** ([getbootstrap.com](https://getbootstrap.com/)): Bootstrap would allow me to make layouts the work efficiently on both mobile and desktop devices. It provides many built-in components such as navigation bars, login and sign-up models, layouts for item listings, and styles that can greatly reduce the amount of CSS that would need to be written from scratch.

- **HTML5, CSS3, JavaScript:** 
    - **HTML5** will be used to define the web pages' structure and will enable layouts for listings, profiles, and reviews.
    - **CSS3** will be used to create customized styling that goes beyond the defaults of Bootstrap. This could allow me to create a more distinctly Hanover themed application.
    - **JavaScript** will allow for interactivity like filtering listings and confirming actions (such as deleting a post of marking it as sold/pending)


**4. Back End:**  

- **Java 19:** This will be the core programming language. I chose this language because it integrates very well with Spring Boot and thus simplifies web development. Python or JavaScript could have been used; however, Java is heavily documented, more user friendly, and works directly with frameworks like Spring. This will ultimately reduce the already large learning curve for this project.  

- **Spring Boot** ([spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)): This is a framework that makes building web applications simpler through its support for controllers, security, and embedded servers. I chose this because of its web development tools as well as its direct pairing with Spring Security and Spring Data JPA.  

- **Spring Security** ([spring.io/projects/spring-security](https://spring.io/projects/spring-security)): This will play a key role in authenticating and authorizing people before entrance and during user interactions (like listing items or leaving reviews). It will allow access to be restricted to solely *@hanover,edu* accounts. The provided security features could include password hashing and giving admins different levels of control than standard users. 

- **Spring Data JPA** ([spring.io/projects/spring-data-jpa](https://spring.io/projects/spring-data-jpa)): This would allow for the creation of methods being written as simple functions while the SQL is generated automatically. This would help me reduce the number of errors made during development.

- **SQLite** ([sqlite.org](https://www.sqlite.org/)): SQLite is a lightweight database that I can use during development and testing. It runs locally and does not need a server, which is ideal for quicker responses during development. It also allows for better experimentation and design before moving onto production.

- **PostgreSQL** ([postgresql.org](https://www.postgresql.org/)): PostgreSQL is ideal for production and deployment due to its support of advanced queries, indexing for lookups, and is able to work alongside Render and Railway cost free. It is scalable, reliable, and ideal for a project that is intended for community use.



**5. Alternative Technologies:**  
For each core technology, alternatives were considered:  


- **Front End:** While *React* [6] or *Angular* could provide more dynamic single-page applications, they would inherently increase the complexity of the project and steepen the overall learning curve. I selected **Thymeleaf** because it works alongside Spring Boot seamlessly, reducing the complexity of the project as well as the time needed for setup.  

- **Database:** Alternatives like *MySQL* [7] are widely used, but **PostgreSQL** is more suited for production deployment due to its advanced queries and free-tier hosting options. Another factor in choosing to use PostgreSQL is their superior support in cloud environments.  

- **Image Hosting:** Services such as *AWS S3* [8] are industry-standard; however, they require more setup and potential costs. I selected **Cloudinary** because it is supposedly simple to integrate with web applications and allows for automatic handling of image scaling and delivery. The biggest factor, however, is that their free-of-charge services give a wider range of flexibility than any of their competitors.  

- **Authentication:** I selected **Spring Security** because of its direct integration with Spring Boot. It should also give me thorough control over authentication and authorization. While there are other solutions that could be used for these purposes, Spring Security is a ready-to-use service that integrates with other tools that I will already be using. Given that, it should help to reduce the overall complexity of this project and lower the learning curve.  

- **Framework:** I selected **Spring Boot** as the framework that I will use for this project because of its designed ability to be used alongside Spring Security and Spring Data JPA. While there are alternatives that may be simpler at first glance – *Flask* and *Python* or *Express.js* and *JavaScript* – Spring Boot allows me to leverage my knowledge of Java rather than refreshing or learning another language.  



### Components and Connections  
The system architecture will have **three primary components**:  

- **Front End (Thymeleaf, Bootstrap, HTML/CSS/JS):** The front end will take care of rendering pages that the user sees and interacts with. These pages will be interacted with directly when users are browsing, creating listings, managing profiles, and leaving reviews. By using Thymeleaf templates alongside Bootstrap styling I can ensure that UI is responsive and friendly for all devices.

- **Back End (Java 19, Spring Boot, Spring Security, JPA):** The back end will be in charge of handling authentication, logic, and requests. This will include validating access via Hanover emails as well as processing the creation and editing of listings. Spring Security will also ensure that sensitive actions (like posting items or reviews) can only be performed by verified users. 

- **Database (SQLite for development, PostgreSQL for deployment):** The database will handle the storage of important and sensitive data, including user accounts, item listings, and reviews. SQLite will provide a lightweight method of performing these actions during development and testing. PostgreSQL will be the database used for deployment of the web application as it is more scalable and robust. 

- **Additional connections:**  
    - The **front end** will communicate with the **back end** through HTTP requests (like a new listing sending a POST request to the server).  
    - The **back end** will interact with the **database** through Spring Data JPA and will automatically translate Java into SQL queries.  
    -  External services like **Cloudinary** (used for image hosting) will also integrate at this layer. This will ensure that uploaded images are stored securely while still remaining linked to their specific listings.

---

## References
[1] Facebook, “Facebook Marketplace,” Meta Platforms, [Online]. Available: https://www.facebook.com/marketplace. [Accessed: 29-Sep-2025].  

[2] Craigslist, “Craigslist Official Site,” Craigslist Inc., [Online]. Available: https://www.craigslist.org. [Accessed: 29-Sep-2025].  

[3] OfferUp, “OfferUp Marketplace,” OfferUp Inc., [Online]. Available: https://offerup.com. [Accessed: 29-Sep-2025].  

[4] VarageSale, “VarageSale Community Marketplace,” VarageSale, [Online]. Available: https://www.varagesale.com. [Accessed: 29-Sep-2025].  

[5] Facebook, “Yale Free and For Sale Group,” Facebook Groups, [Online]. Available: https://www.facebook.com/groups/150454865086. [Accessed: 29-Sep-2025].  

[6] React, “React Official Docs,” Meta Platforms, [Online]. Available: https://react.dev. [Accessed: 29-Sep-2025].  

[7] MySQL, “MySQL Official Site,” Oracle Corporation, [Online]. Available: https://www.mysql.com. [Accessed: 29-Sep-2025].  

[8] Amazon, “Amazon S3,” Amazon Web Services, [Online]. Available: https://aws.amazon.com/s3. [Accessed: 29-Sep-2025].  

[9] Pivotal/VMware, “Spring Boot,” Spring.io, [Online]. Available: https://spring.io/projects/spring-boot. [Accessed: 29-Sep-2025].  

[10] Pivotal/VMware, “Spring Security,” Spring.io, [Online]. Available: https://spring.io/projects/spring-security. [Accessed: 29-Sep-2025].  

[11] Pivotal/VMware, “Spring Data JPA,” Spring.io, [Online]. Available: https://spring.io/projects/spring-data-jpa. [Accessed: 29-Sep-2025].  

[12] Thymeleaf, “Thymeleaf,” Thymeleaf.org, [Online]. Available: https://www.thymeleaf.org. [Accessed: 29-Sep-2025].  

[13] Bootstrap, “Bootstrap,” GetBootstrap.com, [Online]. Available: https://getbootstrap.com. [Accessed: 29-Sep-2025].  

[14] SQLite, “SQLite Official Documentation,” SQLite.org, [Online]. Available: https://www.sqlite.org. [Accessed: 29-Sep-2025].  

[15] PostgreSQL, “PostgreSQL Official Documentation,” PostgreSQL.org, [Online]. Available: https://www.postgresql.org. [Accessed: 29-Sep-2025].  

[16] Cloudinary, “Cloudinary Documentation,” Cloudinary.com, [Online]. Available: https://cloudinary.com. [Accessed: 29-Sep-2025].  

[17] GitHub, “GitHub,” GitHub.com, [Online]. Available: https://github.com. [Accessed: 29-Sep-2025].  

[18] JetBrains, “IntelliJ IDEA,” JetBrains.com, [Online]. Available: https://www.jetbrains.com/idea/. [Accessed: 29-Sep-2025].  

[19] PostgreSQL Global Development Group, “pgAdmin,” pgAdmin.org, [Online]. Available: https://www.pgadmin.org/. [Accessed: 29-Sep-2025].  

[20] Render, “Render Documentation,” Render.com, [Online]. Available: https://render.com. [Accessed: 29-Sep-2025].  

[21] Railway, “Railway Documentation,” Railway.app, [Online]. Available: https://railway.app. [Accessed: 29-S

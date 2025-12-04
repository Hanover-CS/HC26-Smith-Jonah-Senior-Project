# HC26-Smith-Jonah-Senior-Project

To start, you'll want to clone the project from GitHub into IntelliJ.

---

### 1. Set Up the Database

Open the SQL shell and enter this code:
```
CREATE DATABASE hanover_marketplace;
CREATE USER hanover_user WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE hanover_marketplace TO hanover_user;
```

### 2. Hook up cloudinary
- Now go to cloudinary.com and create a free account. 
- Once you've created an account you'll be able to find your needed key (looks like cloudinary://API_KEY:API_SECRET@CLOUD_NAME) on your dashboard. You'll have to do a 2-factor authentication step to access it. 
- Once it is visible, copy and paste it into src/main/resources/application-local.properties.

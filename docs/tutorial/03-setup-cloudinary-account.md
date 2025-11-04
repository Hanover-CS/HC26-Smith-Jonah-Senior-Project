---
layout: default
title: Setup Cloudinary Account
---

# 3) Set up your Cloudinary account

1. **Create a Cloudinary account** (free tier works).
2. In the dashboard, locate:
   - **Cloud name**
   - **API Key**
   - **API Secret**

3. Construct your **CLOUDINARY_URL** (no quotes): ie. CLOUDINARY_URL=cloudinary://<your_api_key>:<your_api_secret>@dxxfaci
    - When you make your key do not include any <> characters. Otherwise everything else says the same (except of course replacing the key, secret key, and @)


## Configure locally (IntelliJ)
- **Run → Edit Configurations… →** Select your Spring Boot app
- **Environment variables →** add:
  - Name: `CLOUDINARY_URL`
  - Value: `cloudinary://1234567890:abcdef@mycloud`

*(This keeps secrets out of Git.)*

<img src="img/intellij-env-var.png" alt="IntelliJ Run Config Environment Variable" width="700"/>

**Why env vars?** See Spring Boot docs on [externalized configuration](https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config) (#features.external-config).

[Prev: Prerequisites](02-prerequisites.md) | [Next: Wire Spring Boot](04-wire-spring-boot.md)

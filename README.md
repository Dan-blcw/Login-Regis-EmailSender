# Login-Regis-EmailSender
## Demo Restful API Security , Role management, token generation and validation

## This is an experiment

- the purpose is to understand what the core of JWT is, how a miniature spring security configuration works,understand how I configure all the HTTP security for our application, if you are still confused about this, watch it to understand how works, I have a pretty solid explanation of the core parts(for Vietnamese people).
- The ones I use in this test are java, postgres DB, Spring boot, Spring Security, Lombox,JSON Web Tokens (JWT),BCrypt, JPA, Hibernate ...
## Prerequisites

- JDK 8
- Maven
- Postgres

## Summary chart
<!--  
                                                    - src
                                                         - main
                                                               -* com.DanCreate.loginregisEmail
                                                                     - config 
                                                                             - ApplicationConfigAuxiliary.java
                                                                             - PasswordEncoder.java
                                                                             - SecurityConfig.java
                                                                     - controller
                                                                             - RegistrationController.java
                                                                     - model
                                                                          - dtos
                                                                                ---- RegistrationDto.java
                                                                          - entities
                                                                                ---- Role.java
                                                                                ---- TokenKey.java
                                                                                ---- User.java
                                                                     - reponsitory
                                                                             - TokenKeyRepository.java
                                                                             - UserReponsitory.java
                                                                     - service
                                                                          - interfaces
                                                                                ---- EmailService.java
                                                                             - EmailServiceImpl.java
                                                                             - EmailValidatorService.java
                                                                             - RegistrationService.java
                                                                             - TokenKeyService.java
                                                                             - UserService.java
                                                                      - LoginRegisEmailApplication.java
                                                         - resources
                                                                     -application.properties
                                                    - pom.xml
 -->

![image](https://user-images.githubusercontent.com/127305381/226134317-4279acdb-7fc6-42f7-8216-1cb9faeb0322.png)


## End
Okay,that is all and i'm Dan - P-Minh Huong

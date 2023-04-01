# Demo Login, Registration, EmailSender with JavaEmailSender ,token generation and validation

## This is an experiment

## Prerequisites
- knowledgeable Spring security, JPA, Session, Hibernate
- JDK 19
- Maven
- PostgreSQL
## Set request body as raw with JSON payload
```
{
    "firstname": "Dan",
    "lastname": "blcw",
    "email": "dan_blcw12@gmail.com",
    "password": "0fcvzcv"
}
```
## Database
#### Table use_db
![image](https://user-images.githubusercontent.com/127305381/229306056-16896b41-e20a-4aa8-a7e9-7d783ce36dd9.png)
#### Table token_key
![image](https://user-images.githubusercontent.com/127305381/229306138-d40021e2-c618-4a35-aa19-308111c32f07.png)
## Postman
#### @GetRequest after have JWT Token from table Database use_db
#### Demo - Get : localhost:8080/api/v1/registration/confirm?token={JWT Token}
#### if it shows like this then it works because the endpoint is already printed
![image](https://user-images.githubusercontent.com/127305381/229306420-4be65a8c-9bb1-4322-9c86-d19b04137bd1.png)
#### Note
- since this is a beta the security part will block your view but that doesn't matter because the token and endpoint are still working properly without a hitch
## Summary chart
```
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
                   - application.properties
- pom.xml
```
## Final
Okay,that is all and i'm Dan - P-Minh Huong

# Demo Login, Registration, EmailSender with JavaEmailSender ,token generation and validation

## This is an experiment

## Prerequisites
- knowledgeable Spring security, JPA, Session, Hibernate
- JDK 19
- Maven
- PostgreSQL
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
## End
Okay,that is all and i'm Dan - P-Minh Huong

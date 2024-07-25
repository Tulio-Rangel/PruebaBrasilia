## How to run

#### 1. Clonar el proyecto
```
git clone https://github.com/Tulio-Rangel/PruebaBrasilia.git
```

#### 2. Change or Use Current Properties
```
spring.security.user.name=tulio
```
```
spring.security.user.password=tulio
```

#### 3. Run the app
Use your IDE to run the app or use a terminal a run ```mvn spring-boot:run```

#### 3. Test the endpoint
In this repository theres a Postman Collection with the endpoint to thes the application running.
```
https://github.com/Tulio-Rangel/PruebaBrasilia/blob/master/Brasilia.postman_collection.json
```

In case you changed the security name and password, be sure to change the values in the Autorization Tab on postman.
The security is Basic Auth
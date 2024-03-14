API Backend for Technical Test

# Local environment

Para lanzar la app en local:

mvn spring-boot:run

# Postman collection

En el directorio test/postman hay una colección de requests de postman para poder probar en local los endpoints.

# Cosas a mejorar

- En el path de los endpoint no poner verbos, el método http es el verbo. por ejemplo /list, sustituirlo por el recurso que se va a listar en plural -> orders.
- Las entidades en el paquete de dominio no hace falta anotarlas con @Entity, ya estan anotadas las del paquete entity
**CONFIGURACIÓN**

**Configuración y prueba**

Se puede construir el proyecto y lanzar las pruebas unitarias con el comando

```
mvn test
```

**Base de datos**

Crear una base de datos llamada *databasespq* y dar permisos al usuario por defecto


```
CREATE DATABASE databasespq;
USE databasespq;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON databasespq.* TO 'spq'@'localhost';
```

La configuración por defecto para la base de datos y los usuarios puede ser actualizada en el fichero *resources/datanucleus.properties*.

Para construir y realzar la clases del proyecto se debe ejecutar el comando de maven

```
mvn clean compile
```


**Base de datos**

Las clases de datos deben ser procesadas antes de generar las tablas con el comando

```
mvn datanucleus:enhance
```

Para la creación de las tablas se debe ejecutar el comando de maven:

```
mvn datanucleus:schema-create
```

**Datos de prueba**

Se pueden introducir datos de prueba en la aplicación utilizando el comando de maven

```
mvn -Pdatos exec:java
```

**Tests de integración y rendimiento**

Introducidos los datos de prueba se pueden lanzar los tests de integración y rendimiento usando el comando

```
mvn verify -Pintegration
```

**Inicio del servidor**

El servidor REST de la aplicación se lanza utilizando el comando

```
mvn exec:java
```

*Si el servidor ha sido iniciado correctamente se pueden obtener los datos de prueba accediendo con el navegador a la URL http://localhost:8080/myapp/users*

**Inicio de la aplicación cliente**

La aplicación cliente puede iniciarse usando el comando

```
mvn -Pcliente exec:java
```

##EJECUCIÓN

Una vez ejecutado estos pasos, se abrirá la ventana de **Login**. 

Teniendo en cuenta que es la primera vez que iniciamos y **no tenemos cuenta creada:**

1. La ventana de Login daremos a la opcion de *registrarnos*. Siendo todos los campos obligatorios de rellenar. 
2. Una vez tenemos la cuenta registrada, *iniciamos sesión*. Cuando hemos iniciado sesión, podremos ver nuestros datos en "Mi Perfil".
Si desearamos cambiar algo de nuestro perfil, esta ventana nos dará la opción de editar el perfil, incluso cambiar la contraseña. 
3. Si deseasemos hacer este cambio, se nos habilitaría una nueva ventana donde podriamos realizar la acción deseada, *cambiar contraseña*. 
4. Además de poder *cerrar sesión*, si así lo deseamos. 

**Si tuvieramos cuenta creada:**

Iniciariamos sesión y una vez dentro,podríamos realizar las funcionalidades descritas
en el anterior parrafo.

**Si tuvieramos cuenta creada y no recordasemos la contraseña:**

1. Clickariamos en la opcion de *recuperar contraseña*, donde accederiamos a una nueva ventana. 
2. En esta nueva ventana tendriamos que introducir nuestro nombre de usuario asi como la palabra y 
pregunta de recuperacion que introdujimos cuando nos registramos para poder crear una nueva contraseña.

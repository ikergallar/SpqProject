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

**Documentación**

Se genera el reporte de la documentacion en HTML y TeX

```
mvn doxygen:report
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

*Funciones de Login*

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


*Funciones de anuncios*

Tras iniciar sesión, en el apartado de servicios se encuentra la lista de los servicios que se ofrecen
donde mediante filtros la busqueda se podrá ajustar más a lo que buscamos. Mediante la opción de abrir
accederiamos a los detalles del servicio que hubiesemos seleccionado donde tendriamos diferentes opciones:
Podriamos contratar el servicio, añadirlo a una lista de anuncios favoritos, visualizar el perfil de el
usuario que ha creado el servicio y añadir un comentario al servicio.

En caso de querer visualizar los anuncios que ha creado el usuario, en el apartado de mi perfil 
podríamos acceder a la sección de mis servicios, donde tendriamos la opción de eliminar o editar 
anuncios que ya hayamos creado y crear nuevos anuncios también.

También tendriamos en mi perfil la opción de acceder a una lista donde se visualizarian los servicios que 
hayamos contratado anteriormente. A parte tendriamos la opción de reportar dicho servicio.

**Chat**

Mediante el boton "*chat* " en la ventana principal podremos acceder a esta funcionalidad. Una vez pulsamos este botón se ejecutará el cliente del chat, en este punto todavía habría que abrir la clase servidor por separado para poder usarlo y poder chatear desde otro ordenador conectado en la misma red. 
Se utiliza este como punto intermedio, de forma que un cliente pueda enviar la información necesaria a otro cliente. Para ello, 
necesitaremos dos ip diferentes. Cada cliente debe introducir su nick y la propia ip. Esta ip será detectada por el servidor y se podrán comunicar ambos clientes.

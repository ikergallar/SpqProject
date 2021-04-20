CONFIGURACION

Base de datos

Crear una base de datos llamada databasespq y dar permisos al usuario por defecto

CREATE DATABASE databasespq;
USE databasespq;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON databasespq.* TO 'spq'@'localhost';

La configuración por defecto para la base de datos y los usuarios puede ser actualizada en el fichero resources/datanucleus.properties.

Para construir y realzar la clases del proyecto se debe ejecutar el comando de maven

mvn clean compile
  
Creación de las tablas

Para la creación de las tablas se debe ejecutar el comando de maven

mvn datanucleus:schema-create

Inicio del servidor

El servidor REST de la aplicación se lanza utilizando el comando

mvn exec:java

Si el servidor ha sido iniciado correctamente se pueden obtener los datos de prueba accediendo con el navegador a la URL http://localhost:8080/myapp/users.

EJECUCION

Una vez ejecutado estos pasos, se abrirá la ventana de Login. 

Teniendo en cuenta que es la primera vez que iniciamos y no tenemos cuenta creada:

En primer lugar, en la ventana de Login daremos a la opcion de registrarnos.
Siendo todos los campos obligatorios de rellenar. Una vez tenemos la cuenta registrada,
iniciamos sesión. Cuando hemos iniciado sesión, podremos ver nuestros datos en "Mi Perfil".
Si desearamos cambiar algo de nuestro perfil, esta ventana nos dará la opción de 
editar el perfil, incluso cambiar la contraseña. Si deseasemos hacer este cambio, 
se nos habilitaría una nueva ventana donde podriamos realizar la acción deseada, 
cambiar contraseña. Además de poder cerrar sesión, si así lo deseamos. 

Si tuvieramos cuenta creada:

Iniciariamos sesión y una vez dentro,podríamos realizar las funcionalidades descritas
en el anterior parrafo.

Si tuvieramos cuenta creada y no recordasemos la contraseña:

Clickariamos en la opcion de recuperar contraseña, donde accederiamos a una nueva ventana. 
En esta nueva ventana tendriamos que introducir nuestro nombre de usuario asi como la palabra y 
pregunta de recuperacion que introdujimos cuando nos registramos para poder crear una nueva contraseña.

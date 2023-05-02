# Test Java 2020

## Descripción General
Este repositorio es una prueba de un desarrollo Java.

La aplicación consta de 3 capas:
* Controller: Desde donde exponemos el endpoint, capturamos los datos y componemos la respuesta.
* Service: Servicios a los que llama el controlador.
* Persistence: Compuesta por  _model_  donde tenemos el mapeo de la BBDD y  _repository_  desde donde interactuamos con la BBDD. 

##  Base de Datos
Para esta aplicación, utilizaremos H2.

La base de datos, al estar especificada en el pom.xml, la tendremos disponible sin necesidad de instalación adicional.

En la configuración del `application.properties` tenemos especificado que se arranque en memoria cuando inicie la aplicación.

También H2, al arrancarse, automáticamente ejecutará los insert que tenemos en `data.sql`.

Así, sólo con ejecutar la aplicación tendremos en memoria nuestra BBDD con datos lista para consultar.

## Revisión del código fuente
La clase para ejecutar las pruebas unitarias es `TestJava2020ApplicationTests.java`, en ella podemos encontrar los siguientes 5 tests:

```
Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
```

También podemos consultar directamente el endpoint con la aplicación arrancada:

```
http://localhost:8080/price?date=2020-06-14-10.00.00&productId=35455&brandId=1
```

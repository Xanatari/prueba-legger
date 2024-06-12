# app-eventos-corporativos-api

Eventos Corporativos es un app que se encarga de registrar lugares y permitir la creación de eventos en ellos. Adicional permite el registro de personas al evento.

## Debe hacerse disponible API's para:

 * Crear y editar lugares con datos base. Cada lugar tiene sus propios cupos.
 * Crear evento con los datos base proporcionados y agregar el dato de lugares. Cada evento puede tener más de un lugar.
 * Crear un registro de una persona a un evento con un lugar determinado y que realice el descuento del cupo en el sitio seleccionado.
 * La base de datos en este proyecto base es H2
 * El proyecto debe entregarse en un repositorio en GitHub y con una carpeta con las pruebas visuales del logro del reto técnico.


## Tabla de Contenidos

* [Desarrollo](#desarrollo)
* [Integraciones](#integraciones)
  * [Base de Datos](#base-de-datos)
* [Trazabilidad](#trazabilidad)
* [Procesos](#procesos)
  * [Proceso 1](#p1)
  * [Proceso 2](#p2)
  * [Proceso 3](#p3)
* [Operacion](#operacion)
* [Troubleshooting](#troubleshooting)


## Integraciones


## Base de Datos

| Url Dev       | Url Prod      | 
| ------------- |:-------------:| 
| jdbc:h2:mem:test | jdbc:h2:mem:test |  

	


## Procesos
Procesos del api.

| Nombre        | Descripcion   | 
| ------------- |:-------------:| 
| col 3 is      | right-aligned | 
| col 2 is      | centered      |  
| zebra stripes | are neat      |  

### Create the database
CREATE DATABASE "app-eventos-corporativos-api";

### Create the user
CREATE USER "app-eventos-corporativos-api" WITH PASSWORD '123456789!aA';

### Grant privileges to the user on the database
GRANT ALL PRIVILEGES ON DATABASE "app-eventos-corporativos-api" TO "app-eventos-corporativos-api";



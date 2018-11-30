# Aplicacion móvil para lenguaje de señas

### INTEGRANTES:
*Peña Pastrana Christine
*Perez Rabinez Julio
*Maqui Victoriano Cesar

---
### OBJETIVO:

Realizar un proyecto para Android desarrollado en Java, elegido por el usuario donde se aplique lo aprendido en el curso, el alcance del proyecto se deja a elección del usuario, con un mínimo de 20 horas dedicadas por el usuario.

---
### ACERCA DEL PROYECTO:

Es una aplicación móvil realizada en Java por Android Studio con base de datos Firebase que busca:
* Servir de ayuda a personas con discapacidad auditiva para que se relacionen con las demás personas de manera más fácil y efectiva.
* Permite las personas con discapacidad auditiva aprender a su propio ritmo y de manera autodidacta el lenguaje de señas.
* Permite a cualquier persona aprender el lenguaje de señas y establecer comunicación con una persona con discapacidad auditiva mediante un diccionario.

---
### PROTOTIPO:

**Inicio:**
En este pantalla se encontrará el inicio de la aplicación y el cómo usarlo.

![](https://i.imgur.com/yumuC6c.png)

![](https://i.imgur.com/spwhM0i.png)

**Login**
En esta pantalla se encontrará las opciones de ingreso del usuario.

![](https://i.imgur.com/KZMVeay.png)

**Registro**
En esta pantalla se encontrará las opciones de registro del usuario.

![](https://i.imgur.com/woIVlWT.png)


**Traductor:**
En esta pantalla se encontrará la función principal del proyecto, la traducción.

![](https://i.imgur.com/OF195fD.png)

Pantallas de guardado:

![](https://i.imgur.com/7Q9DCDK.png)


**Diccionario:**
En esta pantalla se encontrará las palabras en el lenguaje de señas consideradas en la aplicación divididas en categorías.

![](https://i.imgur.com/SdOpJqW.png)

Si se ingresa en una categoría:

![](https://i.imgur.com/QxLXpz2.png)

**Listas:**
En esta pantalla se encontrará las listas guardadas de las traducciones.

![](https://i.imgur.com/eRErdqo.png)


**Historial:**
En este pantalla se encontrará el historial de traducciones realizadas.

![](https://i.imgur.com/AMpYStI.png)


---
### HISTORIAS DE USUARIO:

| Número | 1 |
| ------ | ----------- |
| Nombre | Registro de usuario |
| Tipo de Usuario  |  Usuario registrado |
|Prioridad (Alta-Media-Baja)  |Baja |
| Descripción | El usuario debe poder ingresar sus datos (nombre,correo, password) para poder registrarse en la aplicación. La entrada de los campos se encuentran validados. El sistema recibirá los datos si cumplen con estos y los almacenará en la base de datos Firebase.


| Número | 2 |
| ------ | ----------- |
| Nombre | Login de usuario |
| Tipo de Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  |Baja |
| Descripción | El usuario debe poder ingresar sus datos (nombre, password) para poder ingresar en la aplicación. La entrada de los campos se encuentran validados. Se puede ingresar con Facebook.

| Número | 3 |
| ------ | ----------- |
| Nombre | Reproducir el texto en voz |
| Tipo de Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Baja |
| Descripción | Al hacer click en el ícono de sonido se debe reproducir las palabras que se encuentran escritas en la sección traductor.

| Número | 4 |
| ------ | ----------- |
| Nombre | Compartir traducción con otros usuarios |
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Baja |
| Descripción | Al hacer click en el botón circular en la sección traductor se puede elegir la opcion compartir que permitirá al usuario compartir la traducción con otras personas por distintos medios.

| Número | 5 |
| ------ | ----------- |
| Nombre | Historial de traducción |
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Baja |
| Programador responsable | Perez Rabines Julio |
| Descripción | Al hacer selección en la sección de Historial se puede visualizar el historial de traducciones realizadas junto a la fecha de realización.


| Número | 6 |
| ------ | ----------- |
| Nombre |Notificaciones de aprendizaje|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Media |
| Descripción | El usuario recibirá notificaciones aleatorias de palabras en lenguaje de señas cada día.


| Número | 7 |
| ------ | ----------- |
 Nombre |Juegos de aprendizaje|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Media |
| Descripción | El usuario al hacer click en el botón de Juegos de la sección Diccionario ingresará a la sección educativa de la aplicación donde se encontrarán minijuegos.

| Número | 8 |
| ------ | ----------- |
| Nombre |Ajustes y configuración|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Media |
| Descripción | Al hacer click en ajustes y configuración, el usuario será capaz de cambiar el idioma, el tamaño de la ltera, visualizar información del programa y de los programadores, asi como activar las opciones de notificaciones.

| Número | 9 |
| ------ | ----------- |
| Nombre | Guardar traducción|
| Usuario| Usuario registrado |
|Prioridad (Alta-Media-Baja) |Media |
| Descripción | El usuario puede guardar una traducción mediante el botón circular en la sección Traductor, debe elegir o crear la lista en la que se guardara la traducción y estas seran almacenadas en la sección Listas.

| Número | 10 |
| ------ | ----------- |
| Nombre | Búsqueda de traducción |
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Media |
| Programador responsable | Perez Rabines Julio |
| Descripción | El usuario puede realizar una búsqueda de las traducciones realizadas con anterioridad en el campo de búsqueda.

| Número | 11 |
| ------ | ----------- |
| Nombre | Crear una lista|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Media |
| Descripción | El usuario puede crear una lista ingresando un nombre a su elección desde la sección Traducción al hacer click en el boton circular de Guardar o en la sección Listas en la parte superior.


| Número | 12 |
| ------| ----------- |
 Nombre | Eliminar historial|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Alta |
| Descripción | El usuario puede eliminar el historial al hacer click en el icono de basura en la parte superior.

| Número | 13 |
| ------| ----------- |
| Nombre |Integración con firebase|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Alta |
| Descripción | La aplicación tendrá integrada una base de datos en Firebase para el registro de usuarios.

| Número | 14 |
| ------ | ----------- |
| Nombre |Conversión de voz a lenguaje de señas|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Alta |
| Descripción | La aplicación permitirá al usuario al presionar el botón de micrófono, emitir una palabra y al concluir automáticamente mostrará la palabra en lenguaje de señas.

| Número | 15 |
| ------ | ----------- |
| Nombre |Conversión de texto a lenguaje de señas|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Alta |
| Descripción | La aplicación permitirá al usuario ingresar texto en la sección Traductor y traducirá automáticamente este texto a lenguaje de señas.

| Número | 16 |
| ------ | ----------- |
| Nombre |Añadir diccionario de lenguaje de señas|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Alta |
| Descripción | Se añadirá un diccionario de lenguaje de señas a la aplicación para la correspondiente traducción, así como las palabras más utilizadas divididas en categorías en la sección Diccionario. 

| Número | 17 |
| ------ | ----------- |
| Nombre |Detalles del diccionario|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Alta |
| Descripción | En categorías de la sección Diccionario, al hacer click en alguna palabra se visualizara los detalles de esta palabra y su traducción a lenguaje de señas mediante gifs. 


| Número | 18 |
| ------ | ----------- |
| Nombre |Interfaz del usuario|
| Usuario  | Usuario registrado |
|Prioridad (Alta-Media-Baja)  | Alta |
| Descripción | La interfaz del usuario debe de ser fácil de usar, con colores adecuados al tema, uniforme en las 5 secciones de la aplicación y con una distribución adecuada.

---
### DISEÑO DE LA BASE DE DATOS ESTRUCTURADA:
![](https://i.imgur.com/nKjpKaH.png)
![](https://i.imgur.com/P9sfFSa.png)


---
### PROCESO DE BASE DE DATOS
* Solo era necesario el uso de la base de datos para el registro y las listas guardadas.
* Firebase nos simplifica el inicio de sesión y la gestión de la misma.
* Nos permitirá gestionar el envío de notificaciones a nuestros usuarios con la diferencia de que estas podrán ser programadas acorde a diferentes parámetros. 

---
### PROBLEMAS ENCONTRADOS EN EL DESARROLLO

* Se encontro problemas al conectarce con la base de datos firebase
* Falta de tiempo para desarrollar el proyecto.
* Virus
* Hacer un cluster con mi tostadora para que aguantara el android studio
* Android studio necestiba descargar plugins entre los miembros del equipo.


---
### SCREENSHOTS DEL PROYECTO FINAL

![](https://i.imgur.com/A2t1zSn.jpg)
![](https://i.imgur.com/klDJrlo.jpg)
![](https://i.imgur.com/0XXCtGO.jpg)
![](https://i.imgur.com/WoEyTqr.jpg)
![](https://i.imgur.com/V0lyoh1.jpg)
![](https://i.imgur.com/PyaqXvK.jpg)
![](https://i.imgur.com/CQtdlyX.jpg)
![](https://i.imgur.com/Z2bK1zv.jpg)
![](https://i.imgur.com/8wKTyix.jpg)
![](https://i.imgur.com/1ZAPGM2.jpg)
![](https://i.imgur.com/6Xc9Grw.jpg)


---
### CUADRO RESÚMEN
![](https://i.imgur.com/rBjUhWS.png)


**Total de Puntos: 73
Estado del Proyecto: 80%**

---
### CÓDIGO EN GITHUB
El proyecto se encontrará subido en github con el siguiente link: [Aplicación móvil de lenguaje de señas](https://github/kiwik9/Mute)

---
### INFORME EN EL READ ME

El informe se encontrará en el READ ME con Markdown del proyecto, se utilizó hackmd.io.

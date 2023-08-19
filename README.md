# ListadoDeTareasSpring
Assesment diagnostico forte 2023
Notas:

1.- La base de datos se genera automáticamente con usuarios de prueba, únicamente se necesita una BD llamada "springboot" en blanco

2.- Se necesita el token obtenido de /login enviando "username" y "password" en formato json por medio de POST.

3.- Una vez con el token, éste se manda como Bearer, ya se puede acceder a:

	/newTask   [POST] -> crear tarea, se manda descripcion y estado
 
	/getTasks  [GET]  -> obtener lista de tareas
 
	/deleteTask [DELETE] -> se envia el id de la tarea a eliminar
 
	/updateTask [POST] -> se envia id de tarea a modificar, junto a los campos descripcion y estado
 
	/createUser [POST] -> se envia un JSON que contenga los values: email, username, password, "roles":["USER"]
				roles contiene ADMIN, INVITED o USER
	/deleteUser [DELETE] -> se envia el id del usuario a eliminar

Dificultades:

1.- Nunca habia trabajado con Spring, y tenia muy poca experiencia con java, únicamente con aplicaciones de consola

2.- Se me dificultó bastante la configuración de Spring Security junto con JwT, me basé en este enlace: https://www.youtube.com/watch?v=aeCotM2DORo

3.- Me llevó demasiado tiempo implementar la autenticación con jwt, por lo que solo incluí Tests referentes al CRUD

4.- Se intento ligar a los usuarios con sus tareas respectivas, pero no logré hacer la relación al momento de insertar una nueva tarea

5.- Por cuestiones de tiempo, no se implementaron los roles completamente, al igual que el framework de mockito.


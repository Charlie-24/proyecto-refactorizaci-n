# Resultado Final del Proyecto

Finalmente hemos reducido drásticamente el numero de Issues, pero todavía quedan algunas
las cuales no se han podido solucionar debido a la compatibilidad de código de nuestra clase

## Issues restantes 

#### Change this instance-reference to static reference

Esta issue indica que la variable `equipoNombre`, la estamos utilizando como variable estática y que no tenemos que usarla de ese manera, quitándole la propiedad de estático y haciendo referencia de esta manera `this.equipoNombre` , el problema viene cuando realizamos este cambio y nos genera mas Issues ya que esa variable debe de ser estática para utilizarla en varios métodos

#### Use the built-in formatting to construct this argument

Hace referencia a la forma de concatenación de logger.info ya que su manera de concatenación mas correcta seria 

-  logger.info("Comentario: {}", resultado);

en vez de 

-  logger.info("Comentario: "+ resultado);

El problema viene cuando la manera correcta, no la podemos implementar debido a la versión de la librería SLF4J la cual utilizamos para usar las funciones `logger`

#### Remove this assignment of "puntos" y Remove this assignment of "equipoNombre".

Nos indica que debemos de borrar los atributos del constructor por defecto y el copia porque estamos sobrescribiendo las variables estáticas `puntos` y `equipoNombre`, pero no podemos porque son atributos que los recurrentemente accedemos en los metodos
 


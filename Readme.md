# Prinicipios SOLID

Los principios se interrelaciona, pero no siempre se puede aplicar al pie de 
la letra. 

## Single Responsibility

Cada clase debe manejar una única responsabilidad. Además deben estár 
relacionada con lo que la clase busca hacer. Para cumplir con el principio 
se recomienda utilizar otra clase que realice dicha tarea e implemente la 
clase a la cual se desea trabajar. Se puede instanciar lo que  hacen otras 
tareas, más no se le integra lógica. Ley de Demeter. Se debe refactorizar si 
afectar la lógica existente. 

## Open to extend, close to change

Se debe poder expandir las funcionalidades, pero sin tener que cambiar la ya 
existente. Ya sea con herencia pero no por nuevos métodos. Mejor derivar. Se 
debe crear una nueva clase para cada funcionalidad nueva, extendiendo. 

## Linskov sustitution princilple

Dada una clase que especifique en una menor, está podrán ser intercambiables 
entre las superiores e inferiores. Las hijas no debería tener más métodos 
que el padre para poder funcionar correctamente. Es mejor que los padres se 
base en la mayor abstración. Se necesita de un alto nivel de abstracción en 
el análisis del software.

## Interface segregation

No se debería interfaces grandes con métodos que no serán usados. Por lo 
cual se deben poder crear varias. Cada una según el nivel de abstracció. Se 
puede usar el instanceOf para verificar instancias. 

## Dependencies reversal

Las dependencias deben ser dadas en las abstraciones no en lo concreto, los 
detalles dependen de las abstraciones. Lo cual resulta que sea opaco al 
detalle en las abstraciones, sino en las concreciones u envoltorios para 
ocultar la lógica interna.

# Clean Architecture

Se usa diferentes capas con solo uno de alcance arriba abajo.

Las entidedes contiene los POJO que serán cómo beans para poder manejar los 
datos. Luego en repositorios se manejan todas las clases relacionadas con la 
persistencia de los datos. 

Los servicios sera la lógica de negocio, gestionando los respositorios con 
las entidades. 
El controlador será el que organizará controlará la comunicación entre capas,
cohesionandolas. Usuando las entidades en los servicios.

El archivo configuración guardará todo lo relacionado con la configuración 
específica del proyecto. 

Sería Controlador, Servicio(POJO en el medio de servicios -> entities), 
Repositorio 



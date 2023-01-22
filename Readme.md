# Prinicipios SOLID

## Single Responsibility

Cada clase debe manejar una única responsabilidad. Además deben estár 
relacionada con lo que la clase busca hacer. Para cumplir con el principio 
se recomienda utilizar otra clase que realice dicha tarea e implemente la 
clase a la cual se desea trabajar. Se puede instanciar lo que  hacen otras 
tareas, más no se le integra lógica. Ley de Demeter. Se debe refactorizar si 
afectar la lógica existente. 


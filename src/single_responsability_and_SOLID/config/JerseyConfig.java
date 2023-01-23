package single_responsability_and_SOLID.config;
//En caso de usar Jersey. Ese marcador se usa de spring, para marcar el punto de entrada.
//También indica que es componente y extiende a la clase que no está por la librería.

//@ApplicationPath("/")
//@Component
public class JerseyConfig /*extends ResoursesConfig*/{
    public JerseyConfig(){
//        this.packages("com.ruta.controllers");
    }
}

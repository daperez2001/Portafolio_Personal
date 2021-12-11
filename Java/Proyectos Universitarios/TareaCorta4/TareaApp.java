
/**
 * Reune todos los metodos y clases en una sola
 * 
 * @author Daniel Pérez 
 * @version 20/09/2021
 */
public class TareaApp
{
    /**
     * Genera un menu para que el usuario pueda realizar las funciones del numero perfecto y tabulación 
     * 
     */
    public void apalicacion()
    {
        int salir = 1;
        Calculadora calculadora = new Calculadora();
        Interfaz interfaz = new Interfaz();
        while (salir != 0){
            interfaz.stringPrint("\t\tMenu\nDigite 1 para comprobar si un numero es perfecto\nDigite 2 si desea realizar alguna tabulacion\nDigite 0 para salir de la aplicación");
            salir = interfaz.intEntradaDeDatos();
            if (salir == 1 ){
                interfaz.stringPrint("Digite el numero que desea verificar");
                interfaz.booleanPrint(calculadora.numPerfecto(interfaz.longEntradaDeDatos()));
            }else{ 
                if (salir == 2){
                    interfaz.stringPrint("Digite el numero que desea verificar");
                    calculadora.tabulacion(interfaz.intEntradaDeDatos());
                }else{
                    if (salir == 0){
                        interfaz.stringPrint("La aplicacion se cerro correctamente");
                    }else{
                        interfaz.stringPrint("Digito incorrecto");
                    }
                }
            }
        }
    }
}

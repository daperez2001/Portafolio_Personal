/**
 * Llama la interfaz y envia esos datos hacia la piramide 
 * 
 * @author Daniel Pérez
 * @version 18/09/2021
 */
public class Aplicacion
{
    /**
     * Distribuye los datos entre clases Interfaz y Piramide
     * 
     */
    public void aplicacion()
    {
        int salir = 1;
        Piramide nuevaPiramide = new Piramide();
        Interfaz nuevaInterfaz = new Interfaz();
            while (salir != 0){
            System.out.println("                     Menu  \nDigite 1 para crear una nueva Piramide \nDigite 0 para salir de la aplicación");
            salir = nuevaInterfaz.interfaz();
            if (salir == 1){
                System.out.println("Digite la altura que desea que tenga la Piramide");
                nuevaPiramide.toString(nuevaInterfaz.interfaz());
            }else{
                if (salir == 0){
                    System.out.println("La aplicación se ha cerrado exitosamente");
                }else{
                    System.out.println("Digito incorrecto");
                }
            }
        }
    }
}

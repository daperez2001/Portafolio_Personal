/**
 * Esta clase Main trae a la clase App y hace que se ejecute el programa.
 * 
 * @author Daniel Pérez.
 * @author Randy Sancho.
 * @author Yerlan Irola.
 * @version 16/11/2021
 */
public class Main
{
    public static void main(String args[]) {
        boolean ejecutar = true;
        int numero = 0;
        try {
            String numeroS = args[1];
            numero = Integer.parseInt(numeroS);
        } catch (NumberFormatException e) {
            ejecutar = false;
            System.out.println("Error, ingreso mal los datos");
        }
        if(ejecutar == true){
            App app = new App();
            app.run(args[0], numero);
        }
    }
}

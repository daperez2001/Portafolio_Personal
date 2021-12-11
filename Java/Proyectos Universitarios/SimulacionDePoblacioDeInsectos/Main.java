import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase la cual une y ejecuta el codigo
 * 
 * @author Daniel Pérez 
 * @version 23/10/2021
 */
public class Main
{
    public static void main( String argv[] ) {
        // Haga entrada de datos para obtener la "cantidadDeBichos" de la
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite la cantidad de bichos de la poblacion");
        int cantidadDeBichos = 0;
        boolean i = true;
        while (i == true){
                try{
                cantidadDeBichos = scanner.nextInt(); 
            }catch(InputMismatchException ex){
                cantidadDeBichos = 0;
                scanner = new Scanner(System.in);
            }
            if (cantidadDeBichos <= 0){
                System.out.println("Digito incorrecto, por favor volver a ingresarlo");
            }else{
                i = false;
            }
        }
        //población
            // CREAR LAS POBLACIONES
        Poblacion poblacion1 = new Poblacion(cantidadDeBichos);
        poblacion1.crearPoblacion();
        Poblacion poblacion2 = new Poblacion(cantidadDeBichos);
        poblacion2.crearPoblacion();
        Poblacion poblacion3 = poblacion1.combinarse(poblacion2);
        // El método extinguir hace el llamado inicial del método recursivo
        poblacion3.inicial();
        // Mostrar el Bicho sobreviviente al usuario
        Bicho bicho = new Bicho(poblacion3, 0, 3);
        System.out.println(bicho);
    }
}

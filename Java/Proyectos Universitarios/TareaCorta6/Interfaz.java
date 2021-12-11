import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Realiza la entrada de datos de las demas clases 
 * 
 * @author Daniel Pérez
 * @version 20/09/2021
 */
public class Interfaz
{
    /**
     * Realiza la entrada de datos "char"
     * 
     * @return  caracter de entrada de datos 
     */
    public char charEntradaDeDatos()
    {
        Scanner scanner = new Scanner(System.in);
        char caracter;
        try{
                caracter = scanner.next().charAt(0);
        }catch(InputMismatchException ex){
                caracter = ' ';
        }
        return caracter;
    }
     /**
     * Realiza la entrada de datos "int"
     * 
     * @return  numero de entrada de datos 
     */
    public int intEntradaDeDatos()
    {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        try{
                numero = scanner.nextInt();
        }catch(InputMismatchException ex){
                numero = 0;
        }
        return numero;
    }
    /**
     * Realiza la salida de datos "String"
     * 
     */
    public void stringPrint(String  text)
    {
        System.out.println(text); 
    }
}

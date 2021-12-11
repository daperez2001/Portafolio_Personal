import java.util.Scanner;
/**
 * Realiza la entrada de datos de las demas clases 
 * 
 * @author Daniel Pérez
 * @version 20/09/2021
 */
public class Interfaz
{
    /**
     * Realiza la entrada de datos "int"
     * 
     * @return  Codigo de entrada de datos 
     */
    public int intEntradaDeDatos()
    {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        return numero;
    }
    /**
     * Realiza la entrada de datos "long"
     * 
     * @return Codigo de entrada de datos
     */
    public long longEntradaDeDatos()
    {
        Scanner scanner = new Scanner(System.in);
        long numero = scanner.nextLong();
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
    /**
     * Realiza la salida de datos "boolean"
     * 
     */
    public void booleanPrint(boolean txt)
    {
        System.out.println(txt); 
    }
}

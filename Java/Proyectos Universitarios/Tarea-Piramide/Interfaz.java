import java.util.Scanner;
/**
 * Genera una entrada de datos para ingresar la altura 
 * 
 * @author Daniel Pérez 
 * @version 18/09/2021
 */
public class Interfaz
{
    /**
     * Entrada de datos (altura)
     * 
     * @return  Altura de la piramide  
     */
    public int interfaz()
    {
        Scanner scanner = new Scanner(System.in);
        int altura = scanner.nextInt();
        return altura;
    }
}

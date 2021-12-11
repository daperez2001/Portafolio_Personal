
/**
 * Realiza metodos matematicos 
 * 
 * @author Daniel Pérez 
 * @version 20/09/2021
 */
public class Calculadora
{
    Interfaz interfaz = new Interfaz();
    /**
     * Calcula si un numero es Perfecto 
     * 
     * @param  numero Recibe el numero que queremos comprobar  
     * @return   Un resultado booleano el cual representa si el numero es Perfecto 
     */
    public boolean numPerfecto(long numero)
    {
        long contador = 1;
        long sumaDeDivisiones = 0l;
        boolean respuesta = false;
        if (numero > 0){
            while(contador != numero){
                if (numero % contador == 0 ){
                    sumaDeDivisiones += contador;
                } 
                contador++;
            }
            if (sumaDeDivisiones == numero){
                respuesta = true;
            } else {
                respuesta = false;
            }
        }else{
            interfaz.stringPrint("Su numero es invalido" );
        }
        return respuesta;
    }
        /**
     * Realiza una tabulacion en base a exponente 2 y 3 de un numero  
     * 
     * @param  numero Recibe el numero que queremos comprobar  
     */
    public void tabulacion(int numero){
        int inicio = 1;
            if (numero >= 1){
            interfaz.stringPrint("N\tCuadrado\tCubo"); 
            while(inicio <= numero){
                double cuadrado = Math.pow(inicio, 2);
                int intCuadrado = (int) cuadrado;
                double cubo = Math.pow(inicio, 3);
                int intCubo = (int)cubo;
                interfaz.stringPrint(inicio + "\t" + intCuadrado + "\t\t" + intCubo);
                inicio++;
            }
        }else{
            interfaz.stringPrint("Su numero es invalido" );
        }
    }
}

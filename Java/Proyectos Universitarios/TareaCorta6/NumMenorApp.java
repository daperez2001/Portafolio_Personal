
/**
 * Distribucion de logica y datos del numero menor
 * 
 * @author Daniel Pérez
 * @version 06/10/2021
 */public class NumMenorApp
{
    /**
     * Ejecuta y almacena el numero menor
     * 
     */  
    public void numMenorApp()
    {
        NumMenor numMenor = new NumMenor();
        Interfaz interfaz = new Interfaz();
        boolean dato = true;
        int tamaño = 0;
        while(dato == true){ 
            interfaz.stringPrint("Ingrese la cantidad de numeros que desea comparar");
            tamaño = interfaz.intEntradaDeDatos();
            if (tamaño > 0){
                dato = false;
            }else{
                interfaz.stringPrint("Dato erroneo, debe ingresar un numero entero y mayor a 0");
            }
        }
        double vector[] = new double[tamaño];
        interfaz.stringPrint("Ingrese los numeros a comparar");
        for(int i = 0; i < tamaño; i++)
        {
           vector[i] = interfaz.intEntradaDeDatos();
        }
        interfaz.stringPrint("El numenor menor del anterior conjunto es: " + numMenor.numeroMenor(vector));
    }
}

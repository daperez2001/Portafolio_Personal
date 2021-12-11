
/**
 * Distribucion de logica y datos del Palindromo
 * 
 * @author Daniel Pérez
 * @version 06/10/2021
 */
public class PalindromoApp
{
    /**
     * Ejecuta y almacena el Palindromo con el metodo iterativo
     * 
     */     
    public void palindromoIterativo() {
         Interfaz interfaz = new Interfaz();
         Palindromo palindromo = new Palindromo();
         int tamaño = 0;
         boolean dato = true;
         while(dato == true){ 
            interfaz.stringPrint("Ingrese la cantidad de letras que contiene su palabra");
            tamaño = interfaz.intEntradaDeDatos();
            if (tamaño > 0){
                dato = false;
            }else{
                interfaz.stringPrint("Dato erroneo, debe ingresar un numero entero y mayor a 0");
            }
        }
        char vector[] = new char[tamaño];
        interfaz.stringPrint("Ingrese letra por letra la palabra que desea verificar su Palindromo");
        for(int i = 0; i < tamaño; i++)
        {
           vector[i] = interfaz.charEntradaDeDatos();
        }
        boolean respuesta = palindromo.iterativa(vector);
        interfaz.stringPrint("El resultado de esta palabra sobre su Palindromo es: " + respuesta);
    }
    /**
     * Ejecuta y almacena el Palindromo con el metodo iterativo
     * 
     */ 
    public void palindromoRecursivo() {
         Interfaz interfaz = new Interfaz();
         Palindromo palindromo = new Palindromo();
         int tamaño = 0;
         boolean dato = true;
         while(dato == true){ 
            interfaz.stringPrint("Ingrese la cantidad de letras que contiene su palabra");
            tamaño = interfaz.intEntradaDeDatos();
            if (tamaño > 0){
                dato = false;
            }else{
                interfaz.stringPrint("Dato erroneo, debe ingresar un numero entero y mayor a 0");
            }
        }
        char vector[] = new char[tamaño];
        interfaz.stringPrint("Ingrese letra por letra la palabra que desea verificar su Palindromo");
        for(int i = 0; i < tamaño; i++)
        {
           vector[i] = interfaz.charEntradaDeDatos();
        }
        boolean respuesta = palindromo.recursiva(vector, 0);
        interfaz.stringPrint("El resultado de esta palabra sobre su Palindromo es: " + respuesta);
    }
}

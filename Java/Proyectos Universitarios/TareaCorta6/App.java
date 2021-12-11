
/**
 * Genera un menu en el cual se decide que clase ejecutar
 * 
 * @author Daniel Pérez
 * @version 06/10/2021
 */
public class App
{
    /**
     * Realiza un menu en el cual decidimos que clase usar
     * 
     */
    public void Menu() {
        PalindromoApp palindromoApp = new PalindromoApp();
        NumMenorApp numMenorApp = new NumMenorApp();
        Interfaz interfaz = new Interfaz();
        int i = 0;
        while ( i == 0){
            interfaz.stringPrint("\t\tMenu");
            interfaz.stringPrint("1. PalindromoApp (Metodo Recursivo)");
            interfaz.stringPrint("2. PalindromoApp (Metodo Iterativo)");
            interfaz.stringPrint("3. NumeroMenorApp");
            interfaz.stringPrint("4. Salir");
                int opcion = interfaz.intEntradaDeDatos();
            switch(opcion){
                case 1:
                    palindromoApp.palindromoRecursivo();
                    break;
                case 2:
                    palindromoApp.palindromoIterativo();
                    break;
                case 3:
                    numMenorApp.numMenorApp();
                    break;
                case 4:
                    i = 1;
                    interfaz.stringPrint("App cerrada exitosamente");
                    break;    
                default:
                    interfaz.stringPrint("Dato incorrecto");
            }
        }
    }
}

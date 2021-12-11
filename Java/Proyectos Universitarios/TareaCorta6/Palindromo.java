
/**
 * Logica del Palindromo
 * 
 * @author Daniel Pérez
 * @version 06/10/2021
 */
public class Palindromo
{
    boolean resultado = false;
    int j = 0;
    /**
     * Comprueba si una palabra es Palindromo con metodo iterativo
     * 
     * @param vector Palabra almacenada letra por letra 
     * @return     resultado del Palindromo
     */
    public boolean iterativa(char[] vector)
    {
            for(int i = 0; i < vector.length; ++i){
            if (vector[i] == vector[(vector.length - 1) - i]){
                    resultado = true;
            }else{
                    resultado = false;
                    i = vector.length;
            }
        } 
        return resultado;
    }
    /**
     * Comprueba si una palabra es Palindromo con metodo recursivo
     * 
     * @param vector Palabra almacenada letra por letra 
     * @param inicio indica el numero en el cual inicia el ciclo
     * @return     resultado del Palindromo
     */    
    public boolean recursiva(char[] vector,int inicio)
        {
        if (inicio < vector.length - 1){ 
            if (vector[inicio] == vector[(vector.length - 1) - inicio]){
                    resultado = true;
            }else{
                    resultado = false;
                    inicio = vector.length;
            }
            resultado =  recursiva(vector, inicio + 1);
        }
        return resultado;
    }
}

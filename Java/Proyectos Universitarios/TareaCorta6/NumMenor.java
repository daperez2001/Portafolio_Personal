
/**
 * Logica para obtener un numero menor
 * 
 * @author Daniel Pérez
 * @version 06/10/2021
 */
public class NumMenor
{
    /**
     * Logica para calcular el numero menor 
     * 
     * @param vectorDeNumeros Numeros que queremos utilizar 
     * @return     numero menor
     */
    public double numeroMenor(double vectorDeNumeros[]) {
        double numMenor = vectorDeNumeros[0];
        for (int i = 0; i < vectorDeNumeros.length; ++i){
            if (vectorDeNumeros[i] < numMenor){
             numMenor = vectorDeNumeros[i];
            }  
        }
         return numMenor;
    }
}

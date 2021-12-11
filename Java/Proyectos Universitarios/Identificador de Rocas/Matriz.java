/**
 * Esta clase trae la matriz y la modifica para dar la imagen resultante.
 * 
 * @author Daniel Pérez.
 * @author Randy Sancho.
 * @author Yerlan Irola.
 * @version 16/11/2021
 */
public class Matriz
{
    // instance variables - replace the example below with your own
    private int matriz[][];
    private int colorDeFondo;
    private int cantidadDePiedras;

    /**
     * Este constructor recibe una matriz y determina la cantidad de piedras y el color de fondo de la imagen.  
     */
    public Matriz(int matriz[][])
    {
        this.matriz = matriz;
        colorDeFondo = matriz[0][0];
        cantidadDePiedras = contarPiedras(matriz);
    }
    
    /**
     * Este metodo crea una copia de la matriz ingresada.
     * @param matriz
     * este parametro es la matriz ingresada.
     * @return nuevaMatriz
     * regresa la copia de la matriz que se ingresó.
     */
    public int[][] copiaMatriz(int matriz[][]){
        int nuevaMatriz[][] = new int[matriz.length][matriz[0].length];
        for(int i = 0; i < matriz.length; ++i){
           for(int j = 0; j < matriz[i].length; ++j ){
                nuevaMatriz[i][j] = matriz[i][j];
           }
        }    
        return nuevaMatriz; 
    }
    
    /**
     * Este metodo cuenta la cantidad de piedras que hay en una matriz.
     * @param matriz
     * este parametro es la matriz ingresada.
     * @return contar
     * regresa el numero de piedras que posee la matriz.
     */
    public int contarPiedras(int matriz[][]){
        int matrizContador[][] = new int[matriz.length][matriz[0].length];
        int matrizCopia[][] = copiaMatriz(matriz);
        for(int i = 0; i < matrizContador.length; ++i){
           for(int j = 0; j < matrizContador[i].length; ++j ){
                matrizContador[i][j] = matriz[0][0];
           }
        }   
        Piedra contarPiedra;
        boolean listo = true;
        int contar = 0;
        while(listo){
            contarPiedra = new Piedra(matrizCopia);
            contarPiedra.borrarPiedra(matrizCopia);
            listo = matrizVacia(matrizContador, matrizCopia);
            contar++; 
        }
        return contar;
    }
    
    /**
     * Este metodo compara las dos matrices ingresadas y genera una matriz con color de fondo.
     * @param matrizContado
     * este parametro es la matriz con el color de fondo, vacía.
     * @param matriz
     * este parametro es la matriz con imagen.
     * @return listo
     * regresa booleano que determina si ya las imagenes son iguales o diferentes.
     */
    private boolean matrizVacia(int matrizContador[][], int matriz[][]){
        boolean listo = true;
        for(int i = 0; i < matriz.length; ++i){
           for(int j = 0; j < matriz[i].length; ++j ){
               if(matrizContador[i][j] == matriz[i][j]){
                   listo = false;            
               }else{
                   listo = true;
                   i = (matriz.length - 1);
                   j = (matriz[i].length - 1);
               }
           }
        }   
        return listo;
    }
    
    /**
     * Este metodo se utiliza para obtener la cantidad de piedras.
     * @return cantidadDePiedras
     * regresa el numero que pertenece a la cantidad de piedras en la imagen.
     */
    public int getCantidadDePiedras(){
        return cantidadDePiedras;
    }
}

import java.awt.Image;
/**
 * Esta clase es el robot al que se le dice cuanto peso puede llevar y las piedras que va a tener e imprime en la matriz esas piedras.
 * 
 * @author Daniel Pérez.
 * @author Randy Sancho.
 * @author Yerlan Irola.
 * @version 16/11/2021
 */
public class Robot
{
   private int peso;
   private int cantidadPiedras;
   private Piedra piedrasLlevar[];
   
    /**
     * Este constructor recibe el peso que puede cargar el robot.  
     */
    Robot (int peso){
     this.peso = peso;
   }
   
    /**
     * Este metodo ordena las piedras del vector piedras ingresado en base al porcentaje de metal de cada piedra, de mayor porcentaje a menor.
     * @param piedras
     * este parametro es el vector de piedras sin ordenar.
     * @return piedras
     * regresa el vector de piedras ordenado.
     */
    private Piedra[] ordenarPiedras(Piedra piedras []){
     int porcentaje = 0; 
     int posicionPiedra = 0;
     for(int i = 0; i < piedras.length; ++i){
         porcentaje = 0;
         for(int j = i; j < piedras.length; ++j){
            if(piedras[j].getPorcentajeMetal() > porcentaje){
                porcentaje = piedras[j].getPorcentajeMetal();
                posicionPiedra = j;
            }
         }
         Piedra movPiedras = piedras[i];
         piedras[i] = piedras[posicionPiedra];
         piedras[posicionPiedra] = movPiedras;
     }
     return piedras;
   }
   
    /**
     * Este metodo cuenta las piedras que el robor puede llevar.
     * @param piedras
     * este parametro es el vector de piedras ordenado.
     * @param peso
     * este parametro es el peso que puede llevar el robot.
     * @return contador
     * regresa el numero de piedras que el robot llevará.
     */
   private int contarPiedrasLlevar(Piedra piedras[], int peso){
       int contador = 0;
       int contadorBorrar = 0; 
       for(int i = 0; i < piedras.length; i++){
          if(piedras[i].getPesoRoca() <= peso){
            peso -= piedras[i].getPesoRoca();
            contador++;
          }
       }
       return contador;
   }
   
    /**
     * Este metodo selecciona las piedras que el robor puede llevar.
     * @param piedras
     * este parametro es el vector de piedras ordenado.
     * @param peso
     * este parametro es el peso que puede llevar el robot.
     */
   private void seleccionarPiedras(Piedra piedras[], int peso){
       int contador = 0;
       for(int i = 0; i < piedras.length; i++){
          if(piedras[i].getPesoRoca() <= peso){
            peso -= piedras[i].getPesoRoca();
            piedrasLlevar[contador] = piedras[i];
            contador++;
          }
       }
   }

    /**
     * Este metodo llama a otros metodos para realizar la seleccion de piedras que el robot llevará.
     * @param piedras
     * este parametro es el vector de piedras.
     * @param matriz
     * este parametro es la matriz imagen.
     * @return ImagenParaImprimir
     * regresa la imagen con las piedras que lleva el robot
     */
   public int [][] seleccionPiedras(Piedra[] piedras, int[][] matriz){
       piedras = ordenarPiedras(piedras);
       cantidadPiedras = contarPiedrasLlevar(piedras, peso);
       piedrasLlevar = new Piedra[cantidadPiedras];
       seleccionarPiedras(piedras, peso);
       return ImagenParaImprimir();
   }
   
    /**
     * Este metodo toString la cantidad de piedras que lleva el robot y los datos de cada roca.
     * @return txt
     * devuelve la cantidad de piedras y sus datos.
     */
   public String toString(){
       String txt = "PIEDRAS RECOLECTADAS\nCantidad de piedras: " + cantidadPiedras + "\n\n" + reumenPiedras();
       return txt; 
   }
   
    /**
     * Este metodo hace una linea de texto con los datos de cada roca.
     * @return txt
     * devuelve los datos de las piedras.
     */
   private String reumenPiedras(){
       String txt = ""; 
       for(int i = 0; i < piedrasLlevar.length; i++){
           txt += "Piedra " + (i + 1) +":\nPeso: " + piedrasLlevar[i].getPesoRoca() + "\nManchas: " + piedrasLlevar[i].getManchas() + "\n\n"; 
       }
       return txt;
   }
   
    /**
     * Este metodo es la que crea la imagen que es la que llevará el robot con las piedras que puede llevar.
     * @return matrizLista
     * devuelve matriz sin las piedras utilizables.
     */
   private int [][] ImagenParaImprimir (){
     int [][] matrizLista = new int [piedrasLlevar[0].getFilasNum()][piedrasLlevar[0].getColumnasNum()];
     int [][] piedra;
     for(int p = 0; p < matrizLista.length; ++p){
            for(int o = 0; o < matrizLista[p].length; ++o ){
                matrizLista [p][o] = piedrasLlevar[0].getFondo(); 
            }
     }
     for (int k = 0; k < piedrasLlevar.length; k++){
          piedra = piedrasLlevar[k].getPiedra();
            for(int i = 0; i < piedra.length; ++i){
               for(int j = 0; j < piedra[i].length; ++j ){
                if (piedra [i][j] !=  piedrasLlevar[0].getFondo()){
                    matrizLista [i][j] = piedra [i][j];
               }
            }   
          }
     }
     return matrizLista;
   }
}

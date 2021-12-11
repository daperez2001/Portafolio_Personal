/**
 * Este clase hace el arbol para comprimir los datos.
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 29/11/21
 */
public class ArbolComprimir
{
    private Nodo raiz;
    private int caracteresTotales;
    private String datosBits;
    private String datosComprimidos;
    private String arbol;
    
    /**
     * Este es el constructor de la clase ArbolComprimir.
     * @param matriz
     * este es la matriz que se envía para rellenar el arbol.
     */
    public ArbolComprimir(String[][] matriz) {
        raiz = new Nodo("1");
        agregarElementos(raiz, matriz, 0);
        matriz = nuevaRepresentacion(matriz);
        caracteresTotales = caracteresTotales(matriz);    
        datosBits = lineaDeDatosBits(matriz);
        arbol = leerArbol1();
        datosComprimidos = arbol + datosBits; 
    }
    
    /**
     * Este metodo es un get que devuelve los datos comprimidos.
     * @return datosComprimidos
     * devuelve los datos del arbol mas los bits.
     */
    public String getDatosComprimidos(){
        return datosComprimidos;
    }
    
    /**
     * Este metodo agrega elementos al arbol binario.
     * @param nodo
     * este parametro es un objeto nodo.
     * @param matriz
     * este parametro es la matriz de binarios.
     * @param iterador
     * este parametro es el valor el cual señala espacio en matriz.
     */
    public void agregarElementos(Nodo nodo, String[][] matriz, int iterador){
        if(iterador != matriz.length - 2){
            nodo.setHijoIzquierdo(matriz[iterador][0]);
            nodo.setHijoDerecho("1");
            agregarElementos(nodo.getHijoDerecho(), matriz, (iterador + 1) );          
        }else{
            nodo.setHijoIzquierdo(matriz[iterador][0]);
            nodo.setHijoDerecho(matriz[iterador + 1][0]);
        }
    }
    
     /**
     * Este metodo regresa un string con el arbol binario mediante el llamado del metodo leerArbol.
     * @return arbol
     * regresa el valor string para poder imprimir el arbol.
     */
    public String leerArbol1(){
        String arbol = leerArbol(raiz,"");
        return arbol;
    }
    
     /**
     * Este metodo crea un string en la que muestra el arbol binario.
     * @param nodo
     * este parametro es un objeto nodo.
     * @param arbol
     * este parametro es un string al cual se le va a añadir la lectura del arbol
     * @return arbol
     * regresa el valor string para poder imprimir el arbol.
     */
    private String leerArbol(Nodo nodo, String arbol){
        if(nodo.getBits().equals("1") &&  nodo.getHijoDerecho().getBits().equals("1")){
            arbol += "10" + nodo.getHijoIzquierdo().getBits(); 
            arbol = leerArbol(nodo.getHijoDerecho(), arbol);
        } else {
            arbol += "10" + nodo.getHijoIzquierdo().getBits();
            arbol += "0" + nodo.getHijoDerecho().getBits();
        }
        return arbol;
    }
    
     /**
     * Este metodo asigna los valores de las letras comprimidos.
     * @param matriz
     * este parametro la matriz enviada.
     * @return matriz
     * regresa la matriz con los nuevos valores asignados.
     */
    private String[][] nuevaRepresentacion(String[][] matriz){
        String posicion = "0";
        for(int i = 0; i < matriz.length; i++){
            if(i == matriz.length - 1){
                matriz[i][3] = posicion.substring(0, posicion.length() - 1);
            }else{
                matriz[i][3] = posicion;
                posicion = 1 + posicion;
            }
        }
        return matriz;
    }
    
     /**
     * Este metodo cuenta cuantos caracteres tiene en total la matriz.
     * @param matriz
     * este parametro es la matriz con los datos que se van a contar.
     * @return contador
     * regresa el valor total de los caracteres que se encuentran en la matriz.
     */
    private int caracteresTotales(String[][] matriz){
        int contador = 0;
        for(int i = 0; i < matriz.length; i++){
            contador += Integer.parseInt(matriz[i][1]);    
        }
        return contador;
    }
    
     /**
     * Este metodo crea la linea de datos.
     * @param matriz
     * este parametro es la matriz con los datos que se trabajarán.
     * @return lineaDeDatos
     * regresa el string con la linea de datos en ella.
     */
    private String lineaDeDatosBits(String[][] matriz){
        String lineaDeDatos = "";
        for(int j = 1; j <= caracteresTotales; j++){    
            for(int i = 0; i < matriz.length; i++){
                if(posiciones(matriz[i][2], j + "") == true){
                    lineaDeDatos += matriz[i][3];
                }
            }
        }
        return lineaDeDatos;
    }
    
     /**
     * Este metodo indica la posición en la que van los caracteres.
     * @param buscarValor
     * este parametro es el valor bucado.
     * @param valor
     * este parametro es valor ingresado.
     * @return boolean
     * regresa la condición si se encuentra o no en la posición.
     */
    public boolean posiciones(String buscarValor, String valor){
        String nuevo = "";
        for(int i = 0; i < buscarValor.length(); i++){
            if(buscarValor.charAt(i) != '-'){
                nuevo = nuevo + buscarValor.charAt(i); 
            } else {
                if(nuevo.equals(valor)){
                    return true;
                }
                nuevo = "";
            }   
        }
        return false;
    }
}

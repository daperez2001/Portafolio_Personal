/**
 * Este clase hace el arbol de descomprension los datos.
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 5/12/21
 */
public class ArbolDescomprimir
{
    Nodo raiz;
    int i = 0;
    
    /**
     * Este es el constructor de la clase ArbolDescomprimir e inicializa la creación del arbol.
     * @param arbol
     * este parametro son los bits enviados.
     */
    public ArbolDescomprimir(String arbol)
    {
        crearArbol(arbol);
    }
    
    /**
     * Este metodo crea el arbol desde su raiz.
     * @param arbol
     * este parametro son los bits enviados.
     */
    public void crearArbol(String arbol)
    {   
        raiz = new Nodo("1");
        arbol(raiz, arbol);
        i = 0;
    }
    
    /**
     * Este metodo añade nodos al arbol binario.
     * @param nodo
     * este parametro es un objeto tipo nodo.
     * @param arbol
     * este parametro son los bits enviados.
     */
    public void arbol(Nodo nodo, String arbol)
    {
        if(arbol.charAt(i) == '1'){
            anadirHijoIzquierdo(arbol, nodo);
            anadirHijoDerecho(arbol, nodo);
        }else{
            if(arbol.charAt(i) == '0'){
                anadirHijoDerecho(arbol, nodo);
            }
        }
    }
    
     /**
     * Este metodo añade un nodo izquierdo al arbol binario.
     * @param arbol
     * este parametro son los bits enviados.
     * @param nodo
     * este parametro es un objeto tipo nodo.
     */
    public void anadirHijoIzquierdo(String arbol, Nodo nodo)
    {
        i++;
        if(arbol.charAt(i) == '1'){
            nodo.setHijoIzquierdo("1", nodo);
            arbol(nodo.getHijoIzquierdo(), arbol);
        }else{
            if(arbol.charAt(i) == '0'){
                i++;
                nodo.setHijoIzquierdo(arbol.substring(i, i + 8), nodo);
                i += 8;
            }
        }
    }
    
     /**
     * Este metodo añade un nodo derecho al arbol binario.
     * @param arbol
     * este parametro son los bits enviados.
     * @param nodo
     * este parametro es un objeto tipo nodo.
     */
    public void anadirHijoDerecho(String arbol, Nodo nodo)
    {
        if(arbol.charAt(i) == '1'){
            nodo.setHijoDerecho("1", nodo);
            arbol(nodo.getHijoDerecho(), arbol);
        }else{
            if(arbol.charAt(i) == '0'){
                i++;
                nodo.setHijoDerecho(arbol.substring(i, i + 8), nodo);
                i += 8;
            }
        }
    }
    
     /**
     * Este metodo genera la palabra, pasando los datos de binario a letras.
     * @param datos
     * este parametro son los bits enviados.
     * @return texto
     * regresa un string con la palabra hecha a partir de los bits recibidos.
     */
    public String generarPalabra(String datos){
        boolean salir = false;
        Nodo nodo = raiz;
        String texto = "";
        int i = 0;
        while(!salir){
            if(datos.charAt(i) == '1'){
                if(nodo.getHijoDerecho().getBits().equals("1")){
                    nodo = nodo.getHijoDerecho();
                }else{
                    texto += nodo.getHijoDerecho().getBits();
                    nodo = raiz;
                }
            }
            if(datos.charAt(i) == '0'){
                if(nodo.getHijoIzquierdo().getBits().equals("1")){
                    nodo = nodo.getHijoIzquierdo();
                }else{
                    texto += nodo.getHijoIzquierdo().getBits();
                    nodo = raiz;
                }
            }
            i++;
            if(i == datos.length()){
                salir = true;
            }
        }
        return texto;
    }        
}

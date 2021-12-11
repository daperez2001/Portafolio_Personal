/**
 * Este clase crea los nodos del arbol binario.
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 29/11/21
 */
 public class Nodo
{
    private String bits;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;
    private Nodo padre;
    
    /**
     * Este es el constructor de la clase Nodo.
     * @param bits
     * este parametro son los bits que va a contener el nodo.
     */
    public Nodo(String bits) {
        this.bits = bits;
        hijoIzquierdo = null;
        hijoDerecho = null;
        padre = null;
    }
    
    /**
     * Este es el constructor de la clase Nodo, en el cual tambien se define el nodo padre.
     * @param bits
     * este parametro son los bits que va a contener el nodo.
     * @param padre
     * este parametro es un objeto Nodo del cual viene el nuevo nodo.
     */
    public Nodo(String bits, Nodo padre) {
        this.bits = bits;
        hijoIzquierdo = null;
        hijoDerecho = null;
        this.padre = padre;
    }
    
    /**
     * Este metodo devuelve los bits que hay en el nodo.
     * @return bits
     * devuelve los bits del nodo.
     */
    public String getBits() {
        return bits;
    }
    
    /**
     * Este metodo devuelve el objeto nodo, el cual es el padre del nodo.
     * @return padre
     * devuelve el nodo padre.
     */
    public Nodo getPadre() {
        return padre;
    }
    
    /**
     * Este metodo devuelve el nodo hijo izquierdo del nodo.
     * @return hijoIzquierdo
     * devuelve el nodo hijoIzquierdo.
     */
    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }
    
    /**
     * Este metodo devuelve el nodo hijo derecho del nodo.
     * @return hijoDerecho
     * devuelve el nodo hijoIzquierdo.
     */
    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }
    
    /**
     * Este metodo establece nodo hijo izquierdo del nodo.
     * @param bits
     * este parametro son los bits que contendra el nodo.
     */
    public void setHijoIzquierdo(String bits) {
        this.hijoIzquierdo = new Nodo(bits);
    }
    
    /**
     * Este metodo establece nodo hijo izquierdo del nodo con su nodo padre.
     * @param bits
     * este parametro son los bits que contendra el nodo.
     * @param padre
     * este parametro es un objeto nodo, el cual es el padre del nodo asignado.
     */
    public void setHijoIzquierdo(String bits, Nodo padre) {
        this.hijoIzquierdo = new Nodo(bits, padre);
    }
    
    /**
     * Este metodo establece los bits que contiene el nodo.
     * @param bits
     * este parametro son los bits que contendra el nodo.
     */
    public void setBits(String bits) {
        this.hijoIzquierdo = new Nodo(bits);
    }
    
    /**
     * Este metodo establece nodo hijo derecho del nodo.
     * @param bits
     * este parametro son los bits que contendra el nodo.
     */
    public void setHijoDerecho(String bits) {
        this.hijoDerecho = new Nodo(bits);
    }
    
    /**
     * Este metodo establece nodo hijo derecho del nodo, con su nodo padre.
     * @param bits
     * este parametro son los bits que contendra el nodo.
     * @param padre
     * este parametro es un objeto nodo, el cual es el padre del nodo asignado.
     */
    public void setHijoDerecho(String bits, Nodo padre) {
        this.hijoDerecho = new Nodo(bits, padre);
    }
}

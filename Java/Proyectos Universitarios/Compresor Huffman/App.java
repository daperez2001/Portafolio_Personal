import java.math.BigInteger;
/**
 * Este clase compila los metodos y clases para descomprimir y comprimir.
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 2/12/21
 */
public class App
{
    /**
     * Este Metodo recibe el nombre del archivo y lo comprime.
     * @param nombreArchivo
     * este parametro es el archivo recibido de parte del usuario.
     */
    public void comprimir(String nombreArchivo)
    {
      Comprimir comprimir = new Comprimir();
      String matriz[][] = comprimir.generarMatriz(nombreArchivo);
      ArbolComprimir arbolComprimir = new ArbolComprimir(matriz);
      comprimir.guardarArchivoHuf(nombreArchivo, arbolComprimir.getDatosComprimidos());
    }
    
    /**
     * Este Metodo recibe el nombre del archivo y lo descomprime.
     * @param nombreArchivo
     * este parametro es el archivo recibido de parte del usuario.
     */
    public void descomprimir(String nombreArchivo)
    {
        Descomprimir descomprimir = new Descomprimir(nombreArchivo);
        ArbolDescomprimir arbolDescomprimir = new ArbolDescomprimir(descomprimir.getArbol());
        String texto = arbolDescomprimir.generarPalabra(descomprimir.getDatos());
        texto = descomprimir.ASCII(texto);
        descomprimir.guardarArchivoExt(nombreArchivo, texto);
    }
}

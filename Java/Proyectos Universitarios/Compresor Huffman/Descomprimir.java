/**
 * Este clase descomprime los datos del archivo recibido.
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 2/12/21
 */
public class Descomprimir
{
    String arbol = "";
    String datos = "";
    
    /**
     * Este es el constructor de la clase Descomprimir.
     * @param nombreArchivo
     * este parametro es el nombre del archivo que se descomprimirá.
     */
    public Descomprimir(String nombreArchivo){
        dividirDatos(geneerarBits(nombreArchivo));
    }
    
    /**
     * Este Metodo convierte el documento recibido en bits.
     * @param nombreArchivo
     * este parametro es el nombre del archivo recibido de parte del usuario.
     * @return bits
     * devuelve un string con los bits obtenidos.
     */
    public String geneerarBits(String nombreArchivo)
    {
       String bits = "";
       BitFileReader bitsReader = new BitFileReader( nombreArchivo );
       while ( bitsReader.hasNext() ) {
          bits += bitsReader.next();
       }
       bitsReader.close();
       return bits;
    }
    
    /**
     * Este Metodo guarda el archivo ya descomprimido.
     * @param nombreArchivo
     * este parametro es el nombre del archivo recibido de parte del usuario.
     * @param texto
     * este parametro es el texto resultante de la descompresion del archivo.
     */
    public void guardarArchivoExt(String nomArchivo, String texto)
    {
       FileWriter fileWriter = new FileWriter(newNameExt(nomArchivo));
       
       try {
        fileWriter.crearArchivo(texto);
       } catch (Exception e) {
        System.out.println("ERROR: " + e);
       }
       
       try {
        fileWriter.close();
       } catch (Exception e) {
        System.out.println("ERROR: " + e);
       }
    }
    
    /**
     * Este Metodo divide los datos en el arbol binario correspondiente.
     * @param datosComprimidos
     * este parametro son los datos que serán ingresados al arbol
     */
    public void dividirDatos(String datosComprimidos){
        if(datosComprimidos.charAt(1) == '1'){
            datosArbol1(datosComprimidos);
        }else{
            datosArbol2(datosComprimidos);
        }
    }
    
    /**
     * Este Metodo ingresa los datos recibidos al arbol binario para su creación.
     * @param datosComprimidos
     * este parametro son los datos que serán ingresados al arbol
     */
    private void datosArbol1(String datosComprimidos)
    {
        boolean salir = false;
        int i = 0;
        int contador1 = 0;
        while(!salir)           
        {
            if(datosComprimidos.charAt(i) == '1')
            {
                i++;
                contador1++;
            }else{
                salir = true;
            }
        }
        int cantidadCaracteresArbol = contador1 + ((contador1 + 1) * 8) + (contador1 + 1);
        for(int j = 0; j < cantidadCaracteresArbol; j++)
        {
            arbol += datosComprimidos.charAt(j);
        }
        for(int j = cantidadCaracteresArbol; j < datosComprimidos.length(); j++)
        {
            datos += datosComprimidos.charAt(j);
        }  
    }
    
    /**
     * Este Metodo ingresa los datos recibidos al arbol binario para su creación.
     * @param datosComprimidos
     * este parametro son los datos que serán ingresados al arbol
     */
    private void datosArbol2(String datosComprimidos)
    {
        boolean salir = false;
        int i = 0;
        int contador = 0;
         while(!salir)           
        {
            if(datosComprimidos.charAt(i) == '1' && datosComprimidos.charAt(i + 1) == '0')
            {
                i += 10;
                contador += 10;
            }else{
                contador += 9;
                salir = true;
            }
        }
        for(int j = 0; j < contador; j++)
        {
            arbol += datosComprimidos.charAt(j);
        }
        for(int j = contador; j < datosComprimidos.length(); j++)
        {
            datos += datosComprimidos.charAt(j);
        }
    }

    /**
     * Este Metodo regresa el string de datos del arbol binario.
     * @return arbol
     * regresa el string de datos del arbol binario
     */
    public String getArbol()
    {
        return arbol;
    }
    
    /**
     * Este Metodo regresa el string datos.
     * @return datos
     * regresa el string de datos.
     */
    public String getDatos()
    {
        return datos;
    }
    
    /**
     * Este Metodo convierte los datos binarios a letras.
     * @return texto
     * regresa el string del texto descomprimido.
     */
    public String ASCII(String datos)
    {
        int valorDecimal = 0;
        String texto = "";
        int letras = datos.length() / 8;
        for(int j = 0; j < letras; j++){
            for(int i = 0; i < 8; i++)
            {   if(datos.charAt(i) == '1'){
                    if(i == 0){
                        valorDecimal += 128;
                    }
                    if(i == 1){
                        valorDecimal += 64;
                    }
                    if(i == 2){
                        valorDecimal += 32;
                    }
                    if(i == 3){
                        valorDecimal += 16;
                    }
                    if(i == 4){
                        valorDecimal += 8;
                    }
                    if(i == 5){
                        valorDecimal += 4;
                    }
                    if(i == 6){
                        valorDecimal += 2;
                    }
                    if(i == 7){
                        valorDecimal += 1;
                    }
                }
            }
            texto += "" + (char) valorDecimal;
            valorDecimal = 0;
            datos = datos.substring(8, datos.length());
        }
        return texto;
    }
    
    /**
     * Este Metodo cambia el nombre del archivo.
     * @param nomArchivo
     * este parametro es el nombre del archivo ingresado.
     * @return nomArchivo
     * regresa el nuevo nombre del archivo
     */
    private String newNameExt(String nomArchivo) 
    {
        int numLetras = nomArchivo.length();
        nomArchivo = nomArchivo.substring(0, numLetras - 4);
        return nomArchivo;
    }
}

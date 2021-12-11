/**
 * Este clase comprime los datos del archivo recibido.
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 29/11/21
 */
public class Comprimir
{
    /**
     * Este Metodo genera una matriz con numeros binarios a partir del archivo recibido.
     * @param nombreArchivo
     * este parametro es el archivo recibido de parte del usuario.
     * @return matriz
     * devuelve la matriz con los equivalentes binarios del archivo.
     */
    public String[][] generarMatriz(String nombreArchivo)
    {
      FileReader archivo = new FileReader( nombreArchivo );
      String matriz[][] = CrearMatrizASCII();
      try {
           matriz = archivo.leerArchivo(matriz);
      } catch (Exception e ) {
          System.out.println("ERROR: " + e);
      }
      try {
        archivo.close();
      } catch (Exception e) {
        System.out.println("ERROR: " + e);
      }
      matriz = rellenarCade(matriz); 
      matriz = OptimizarMatriz(matriz);
      matriz = ordenarMatriz(matriz);
      return matriz;
    }
    
    /**
     * Este Metodo guarda el archivo ya comprimido y agrega los bits faltantes.
     * @param nombreArchivo
     * este parametro es el archivo recibido de parte del usuario.
     * @param bits
     * este string son los bits comprimidos recolectados del arbol.
     */
    public void guardarArchivoHuf(String nomArchivo, String bits)
    {
       BitFileWriter bitsWriter = new BitFileWriter( newNameHuf(nomArchivo), bitsSobrantes(bits) );
       bitsWriter.write( rellenarBytes(bits, bitsSobrantes(bits)));
       bitsWriter.close();
    }
    
    /**
     * Este Metodo guarda el archivo ya comprimido y agrega los bits faltantes.
     * @param nombreArchivo
     * este parametro es el archivo recibido de parte del usuario.
     * @param bits
     * este string son los bits comprimidos recolectados del arbol.
     */
    private int bitsSobrantes(String bits){
        int sobrantes = 0;
        sobrantes = (((bits.length() / 8) + 1) * 8) - bits.length();  
        if(sobrantes == 8){
            sobrantes = 0;
        }
        return sobrantes;
    }
    
    /**
     * Este Metodo rellena los bits faltantes de los datos. 
     * @param bits
     * este string son los bits comprimidos recolectados del arbol.
     * @param bitsSobrantes
     * este parametro es el numero de bits que faltan en los datos.
     */
    private String rellenarBytes(String bits, int bitsSobrantes){
        for(int i = 1; i <= bitsSobrantes && bitsSobrantes != 0 ; i++){
            bits += 0;
        }
        return bits;
    }
    
    /**
     * Este Metodo cambia el nombre del archivo añadiendole un ".huf" 
     * @param nomArchivo
     * este string es el nombre del archivo recibido.
     * @return nomArchivo
     * regresa el nombre del archivo con ".huf" añadido
     */
    private String newNameHuf(String nomArchivo) 
    {
        return nomArchivo + ".huf";
    }
    
    /**
     * Este Metodo crea la matriz de binarios con los caracteres. 
     * @param nomArchivo
     * este string es el nombre del archivo recibido.
     * @return matriz
     * regresa la matriz con binarios.
     */
    public String[][] CrearMatrizASCII()
    {
        String matriz[][] = new String[256][4];
        for(int i = 0; i < 256; i++){
            matriz[i][0] = Integer.toBinaryString(i);
            matriz[i][1] = "0";
            matriz[i][2] = "";
        }
        return matriz;
    }
    
    /**
     * Este Metodo crea la matriz de binarios con los caracteres. 
     * @param nomArchivo
     * este string es el nombre del archivo recibido.
     * @return matriz
     * regresa la matriz con binarios.
     */
    public String[][] rellenarCade(String matriz[][])
    {
        for(int i = 0; i < 256; i++){
            while(matriz[i][0].length() != 8){    
                matriz[i][0] = 0 + matriz[i][0];           
            }
        }
        return matriz;
    }
    
    /**
     * Este Metodo cuenta los caracteres que hay en la matriz. 
     * @param matriz
     * esta matriz es la matriz de binarios.
     * @return contadorChar
     * regresa el numero de caracteres.
     */
    private int contadorChar(String matriz[][])
    {
        int contadorChar = 0;
        for(int i = 0; i < 256; i++){
            if(Integer.parseInt(matriz[i][1]) > 0){
                contadorChar++;
            }
        }
        return contadorChar;
    }
    
    /**
     * Este Metodo remueve los caracteres no usados de la matriz. 
     * @param matriz
     * esta matriz es la matriz de binarios.
     * @return newMatriz
     * regresa la matriz ya optimizada.
     */
    public String[][] OptimizarMatriz(String matriz[][])
    {
        String newMatriz[][] = new String[contadorChar(matriz)][4];
        int contador = 0;
        for(int i = 0; i < 256; i++){
            if(Integer.parseInt(matriz[i][1]) > 0){
                newMatriz[contador][0] = matriz[i][0];
                newMatriz[contador][1] = matriz[i][1];
                newMatriz[contador][2] = matriz[i][2];
                contador++;
            }
        }
        return newMatriz;
    }
    
    /**
     * Este Metodo ordena la matriz dependiendo de cuantas veces aparece un caracter en el texto. 
     * @param matriz
     * esta es la matriz recibida.
     * @return Matriz
     * regresa la matriz ya ordenada.
     */
    public String[][] ordenarMatriz(String matriz[][])
    {
        int contador = 0;
        int numMayor = 0;
        for(int j = 0; j < matriz.length; j++){
            for(int i = j; i < matriz.length; i++){
                if(Integer.parseInt(matriz[i][1]) > numMayor){
                    numMayor = Integer.parseInt(matriz[i][1]);
                    String posicion0 = matriz[j][0];
                    String posicion1 = matriz[j][1];
                    String posicion2 = matriz[j][2];
                    matriz[j][0] = matriz[i][0];
                    matriz[j][1] = matriz[i][1];
                    matriz[j][2] = matriz[i][2];
                    matriz[i][0] = posicion0;
                    matriz[i][1] = posicion1;
                    matriz[i][2] = posicion2;
                }
            }
            numMayor = 0;
        }
        return matriz;
    }
}

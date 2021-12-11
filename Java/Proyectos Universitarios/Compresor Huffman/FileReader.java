import java.io.File;
import java.io.FileInputStream;

/**
 * 
 */
public class FileReader
{
    private FileInputStream inputStream;
    private String nombreArchivo;
    /**
     * Constructor for objects of class FileReader
     */
    public FileReader(String nombreArchivo)
    {
        try {
            this.nombreArchivo = nombreArchivo;
            File archivo = new File(nombreArchivo);
            inputStream = new FileInputStream(archivo);
        } catch (Exception e) {
            System.out.println("Error abriendo el archivo");
        }
    }
    
    /**
     * Lee todo lo que queda del archivo y lo devuelve en un string
     * (si usan binario o caracteres)
     * 
     * @return Representacion de caracteres del contenido del archivo
     */
    public String[][] leerArchivo(String [][] matriz) throws Exception {
        int cont;
        int i = 0;
        int contador = 1;
        while ((cont = inputStream.read()) != -1) {
           // Para convertir el entero que lee a binario
           String binario = Integer.toBinaryString(cont);
           matriz = comprobar(matriz, binario, contador);
           i++;
           contador++;
        }
        return matriz;
    }
    
    private String[][] comprobar(String [][] matriz, String binario, int contador) throws Exception {
        for(int i = 0; i < 256; i++){
            if(matriz[i][0].equals(binario)){
                int provicional = Integer.parseInt(matriz[i][1]) + 1;
                matriz[i][1] = provicional + "";
                matriz[i][2] += contador + "-";
            }
        }
        return matriz;
    }
    
    public String leerSiguienteCaracter() throws Exception  {
       int cont = inputStream.read();
       if (cont == -1) {
            return "-1";
       }
       return Integer.toBinaryString(cont);
    }

    public void close() throws Exception  {
        inputStream.close();
    }
}

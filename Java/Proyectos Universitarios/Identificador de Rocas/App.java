/**
 * Esta clase trae otros metodos para ejecutar todo en un solo lugar.
 * 
 * @author Daniel Pérez.
 * @author Randy Sancho.
 * @author Yerlan Irola.
 * @version 16/11/2021
 */
public class App {
    /**
     * Este metodo recibe la imagen y el peso que puede llevar el robot. Con esto inicializa los otros metodos e imprime la matriz final.
     * @param archivo
     * este parametro es la imagen ingresada.
     * @param peso
     * este parametro es el peso que puede cargar el robot.
     */
    public void run (String archivo, int peso){ 
        Imagen imagen = new Imagen(archivo);
        Robot robot = new Robot(peso);
        int m[][] = imagen.getMatriz(); 
        Matriz matriz = new Matriz(m);
        int copiaM[][] = matriz.copiaMatriz(m);
        int cantidadPiedras = matriz.getCantidadDePiedras();
        Piedra piedras[] = new Piedra[cantidadPiedras];
        for(int i = 0; i < piedras.length; i++){
            piedras[i] = new Piedra(copiaM);
            piedras[i].borrarPiedra(copiaM);
            piedras[i].setManchas(matriz.contarPiedras(piedras[i].analisis()));
        }
        try {
            m=robot.seleccionPiedras(piedras, m);
            System.out.println(robot);
            Imagen imagenSalida = new Imagen(m);
            imagenSalida.dibujar();  
        } catch (ArrayIndexOutOfBoundsException excepcion) {
            System.out.println("El peso del Robot es menor que el de las piedras");
        }  
    }
}

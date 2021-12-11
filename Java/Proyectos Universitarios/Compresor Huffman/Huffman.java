
/**
 * Esta es la clase huffman, donde se inicia el programa y se decide si comprimir o descomprimir el archivo deseado.
 * 
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 3/12/21
 */
public class Huffman
{
    public static void main(String[]args)    
    {
        App app = new App();
        if(args.length != 0){
            if(args[0].equals( "-c" )){
                app.comprimir(args[1]);
            }else{
              if(args[0].equals( "-d" )){
                app.descomprimir(args[1]);
              }
            }
        }else{
            Menu menu = new Menu(app);     
        }
        }
}


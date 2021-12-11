
/**
 * Clase la cual almacena, crea y reproduce a la poblacion de bichos
 * 
 * @author Daniel Pérez 
 * @version 23/10/2021
 */
public class Poblacion
{
    Bicho bicho = new Bicho();
    double largoPoblacion[];
    int colorPoblacion[];
    int formaPoblacion[]; 
    int tamañoDePoblacion;
    /**
     * Constructor el cual inicializa vactores y guarda el tamaño de la poblacion
     * @param tamañoPoblacion indica cual va a ser el tamaño de la poblacio
     */
    public Poblacion(int tamañoPoblacion)
    {
        largoPoblacion = new double[tamañoPoblacion];
        colorPoblacion = new int[tamañoPoblacion];
        formaPoblacion = new int[tamañoPoblacion]; 
        tamañoDePoblacion = tamañoPoblacion;
    }
    /**
     * Crea una poblacion con valores aleatorios
     */
    public void crearPoblacion(){
        for(int i = 0; i < tamañoDePoblacion; i++){
            double largo = Math.random() * 1000.99;            
            largoPoblacion[i] = largo; 
            double colorR = Math.random() * 3.99;
            int color = (int) colorR;
            colorPoblacion[i] = color;
            double formaR = Math.random() * 2.99;
            int forma = (int) formaR;
            formaPoblacion[i] = forma;
        }
    }
    /**
     * Combina dos insectos para obtener un tercero
     * @param poblacion2 Inicializacion de la poblacion con la que va a combinarse
     * return poblacion
     */
    public Poblacion combinarse(Poblacion poblacion2)
    { 
       Poblacion poblacion = new Poblacion(tamañoDePoblacion); 
       int newColorPoblacion[] = new int[tamañoDePoblacion];
       int newFormaPoblacion[] = new int[tamañoDePoblacion];
       double newLargoPoblacion[] = new double[tamañoDePoblacion];
       for(int i = 0; i < tamañoDePoblacion; i++)
       {
            bicho.cruzarBichos(colorPoblacion[i], poblacion2.getColorPoblacion(i), formaPoblacion[i], poblacion2.getFormaPoblacion(i), largoPoblacion[i], poblacion2.getLargoPoblacion(i));
            newColorPoblacion[i] = bicho.getColor();
            newFormaPoblacion[i] = bicho.getForma();
            newLargoPoblacion[i] = bicho.getLargo();
       }  
       for(int e = 0; e < tamañoDePoblacion; ++e)
       {
            poblacion.setPoblacion(e, newLargoPoblacion[e], newColorPoblacion[e], newFormaPoblacion[e]);
       }
       return poblacion;
    }
    /**
     * Ejecuta la logica de extincion de una poblacion   
     * @param tamañoDePoblacion indica el tamaño de la poblacion 
     */
    private void extinguir(int tamañoDePoblacion){
       if(tamañoDePoblacion > 1){
           bicho.cruzarBichos(colorPoblacion[0], colorPoblacion[tamañoDePoblacion - 1], formaPoblacion[0], formaPoblacion[tamañoDePoblacion - 1], largoPoblacion[0], largoPoblacion[tamañoDePoblacion - 1]); 
           largoPoblacion[tamañoDePoblacion - 1] = -1;
           colorPoblacion[tamañoDePoblacion - 1] = -1;
           formaPoblacion[tamañoDePoblacion - 1] = -1; 
           // -1 significa que estan muertos
           largoPoblacion[0] = bicho.getLargo();
           colorPoblacion[0] = bicho.getColor();
           formaPoblacion[0] = bicho.getForma();
           extinguir(tamañoDePoblacion - 1);
        } 
    }
    /**
     * Metodo para ejecutar el metodo extinguir desde fuera de esta clase 
     */
    public void inicial(){
        extinguir(tamañoDePoblacion);
    }
    /** 
    *Metodo para pasar el valor de la variable largo
    * @param posicion Indica cual insecto ocupamos
    * @return largo
    */
    public double getLargoPoblacion(int posicion)
    {
        double largo = largoPoblacion[posicion];
        return largo;
    }
    /** 
    *Metodo para pasar el valor de la variable color
    * @param posicion Indica cual insecto ocupamos
    * @return color
    */
    public int getColorPoblacion(int posicion)
    {
        int color = colorPoblacion[posicion];
        return color;
    }
    /** 
    *Metodo para pasar el valor de la variable forma
    * @param posicion Indica cual insecto ocupamos
    * @return forma
    */
    public int getFormaPoblacion(int posicion)
    {
        int forma = formaPoblacion[posicion];
        return forma;
    }
    /** 
    *Metodo para asignar nuevo valores en clase Poblacion
    * @param posicion Indica cual insecto ocupamos
    * @param largo Largo del insecto
    * @param color Color del insecto
    * @param forma Forma del insecto 
    */
    public void setPoblacion(int posicion, double largo, int color, int forma)
    {
        largoPoblacion[posicion] = largo;
        colorPoblacion[posicion] = color;
        formaPoblacion[posicion] =  forma;
    }
}

/**
 * Clase la cual se encarga de toda la logica con respecto a los bichos
 * 
 * @author Daniel Pérez 
 * @version 23/10/2021
 */
public class Bicho
{
    // instance variables - replace the example below with your own
    private int color;
    private int forma;
    private double largo;
    Poblacion newPoblacion;
    int newNumBicho;
    int numFamilia;
    /**
     * Constructor bacio de Bicho
     */
    public Bicho(){}
    /**
     * Constructor para bicho, principalmente para realizar un toString
     * @param poblacion Inicializacion de la clase poblacion
     * @param numBicho representa algun bicho de una poblacion
     * @param familia indica de cual poblacion pertenece el bicho que ingreso
     * 
     */
    public Bicho(Poblacion poblacion, int numBicho, int familia){
        newPoblacion = poblacion;
        newNumBicho = numBicho;
        numFamilia = familia;
    }
    /** 
    *Realiza la logica de cruzar un bicho con otro
    * @param colorPadre Indica que color es el padre de la nueva cria
    * @param colorMadre Indica que color es la madre de la nueva cria
    * @param formaPadre Indica que forma tiene el padre de la nueva cria
    * @param formaMadre Indica que forma tiene la madre de la nueva cria
    * @param largoPadre Indica que largo tiene el padre de la nueva cria
    * @param largoMadre Indica que largo tiene la madre de la nueva cria
    */
    public void cruzarBichos(int colorPadre,int colorMadre, int formaPadre, int formaMadre, double largoPadre, double largoMadre)
    {
        int colorHijo = 0;
        int formaHijo = 0;
        double largoHijo = (largoPadre + largoMadre) / 2;
        if(colorPadre == colorMadre)
        {
            colorHijo = colorPadre;    
            if (formaPadre == formaMadre){
                formaHijo = formaPadre;
            }
            if (formaPadre == 0 && formaMadre == 1){
                formaHijo = 2;
            }
            if (formaPadre == 0 && formaMadre == 2){
                    formaHijo = 1;
                }
            if (formaPadre == 1 && formaMadre == 0){
                    formaHijo = 2;
                }    
            if (formaPadre == 1 && formaMadre == 2){
                formaHijo = 0;
            } 
            if (formaPadre == 2 && formaMadre == 0){
                formaHijo = 1; 
            }
            if (formaPadre == 2 && formaMadre == 1){
                formaHijo = 0;
            }
        } else {
            if (colorPadre > colorMadre){
                colorHijo = colorPadre;
                formaHijo = formaPadre; 
            }
            if (colorMadre > colorPadre){
                colorHijo = colorMadre;
                formaHijo = formaMadre; 
            }
        }
        color = colorHijo;
        forma = formaHijo;
        largo = largoHijo;
    }
    /** 
    *Metodo para pasar el valor de la variable color
    * @return color
    */
    public int getColor()
    {
        return color;
    }
    /** 
    *Metodo para pasar el valor de la variable forma
    * @return forma
    */
    public int getForma()
    {
        return forma;
    }
    /** 
    *Metodo para pasar el valor de la variable largo
    * @return largo
    */
    public double getLargo()
    {
        return largo;
    }
    /** 
    *Imprime datos de un insecto
    * @return familia, insecto, color ,largo y forma
    */
    public String toString()
    {
        int color = newPoblacion.getColorPoblacion(newNumBicho); 
        int forma = newPoblacion.getFormaPoblacion(newNumBicho);
        double largo = newPoblacion.getLargoPoblacion(newNumBicho);
        String colorString = colorString(color);
        String formaString = formaString(forma);
        String colorS = "Color: " + colorString;
        String formaS = "Forma: " + formaString;
        String largoS = "Largo: " + largo;
        return "Familia de insectos: " + numFamilia + "\nInspeccion de insecto numero: " + (newNumBicho + 1) + "\n" + colorS + "\n" + formaS + "\n" + largoS + "\n"; 
    }
    /** 
    *Convierte el color representado por numeros en un String
    * @return colorString
    */
    private String colorString(int color)
    {
        String colorString = "";
        switch(color)
        {
            case -1:
                colorString = "muerto";
                break;
            case 0:
                colorString = "rojo";
                break;
            case 1:
                colorString = "azul";
                break;
            case 2:
                colorString = "verde";
                break;
            case 3:
                colorString = "amarillo";
                break;
        }
        return colorString;
    }
    /** 
    *Convierte la forma representada por numeros en un String
    * @return colorString
    */
    private String formaString(int forma)
    {
        String formaString = "";
        switch(forma)
        {
            case -1:
                formaString = "muerto";
                break;
            case 0:
                formaString = "cuadrado";
                break;
            case 1:
                formaString = "círculo";
                break;
            case 2:
                formaString = "triangulo";
                break;
        }
        return formaString;
    }
}

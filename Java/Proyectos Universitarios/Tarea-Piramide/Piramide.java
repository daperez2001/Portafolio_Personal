/**
 * Aplica metodos para generar una piramide
 * 
 * @author Daniel Pérez 
 * @version 18/09/2021
 */
public class Piramide
{
    private int alturaConstante;
    private int segundaAltura;
    private int contador;
    private int segundoContador;
    private int tercerContador;
    private int cuartoContador;
    private String espacio;
    private String asterisco;
    /**
    * Recibe la altura de la piramide y la genera
    * 
    * @param  Altura de la piramide  
    */
    public void toString(int altura){
        if (altura > 0) {
                alturaConstante = altura;
                segundaAltura = altura;
                contador = 1;
                segundoContador = 1;
                tercerContador = altura + 1; 
                espacio = " ";
                asterisco = "*";
                while (contador <= alturaConstante){
                    espacio = " ";
                    segundoContador = 1;
                    while (segundoContador <= altura){
                        espacio += " " ;   
                        segundoContador++;
                    }
                    System.out.println(espacio + asterisco);    
                    while(tercerContador >= segundaAltura){
                        asterisco += "*";
                        tercerContador--;
                    }
                    altura--;
                    segundaAltura -= 2;
                    contador++;
                }
        }else{
            System.out.println ("Su numero es invalido \nDebe seleccionar un numero entero y mayor a 0");
        }
    }
}

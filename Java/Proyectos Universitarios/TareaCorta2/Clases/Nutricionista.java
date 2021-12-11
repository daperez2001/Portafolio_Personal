/*Esta clase lo que hara es realizar la convercion para obtener el imc
Autor:Daniel*/
package Clases;
	public class Nutricionista {

		public double calcularImc(double pesoEnKilos, double alturaEnMetros){
			return pesoEnKilos  / (alturaEnMetros * alturaEnMetros);
		}
	}

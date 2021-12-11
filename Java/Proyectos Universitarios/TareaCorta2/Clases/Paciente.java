/*Esta clase es utilizada para amacenar datos del paciente y devolverlos de maneraa toString
Autor:Daniel*/
package Clases;
	public class Paciente {
		private String nombre;
		private double pesoEnKilos;
		private double alturaEnMetros;
		private double imc;
		
		public Paciente (String nuevoNombre, double nuevoPesoEnKilos, double nuevaAlturaEnMetros){
			 nombre = nuevoNombre;
			 pesoEnKilos = nuevoPesoEnKilos;
			 alturaEnMetros = nuevaAlturaEnMetros;
			 imc = 0;
		}

		public String getNombre(){	
			return nombre;
		}
		public void setNombre(String nuevoNombre){
			nombre = nuevoNombre;
		}
		
		public double getPesoEnKilos (){	
			return pesoEnKilos ;
		}
			public void setPesoEnKilos(double nuevoPesoEnKilos){
			pesoEnKilos = nuevoPesoEnKilos;
		}
		
		public double getAlturaEnMetros(){	
			return alturaEnMetros;
		}	
		public void setAlturaEnMetros(double nuevaAlturaEnMetros){
			alturaEnMetros = nuevaAlturaEnMetros;
		}
		
		public double getImc(){	
			return imc;
		}	
		public void setImc(double nuevoImc){
			imc = nuevoImc;
		} 
		
		public String toString(){
			return "Nombre: " + nombre + "\nPeso: " + pesoEnKilos + "Kg \nAltura: " + alturaEnMetros + "m \nIndice de Masa Corporal: " + imc;
		}
	}

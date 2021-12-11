//Importar la Clase
import Clases.Atleta;
//Code 
class Instancia {
	public static void main(String[]args) {	
		System.out.println("Datos de los Atletas");
		Atleta primerAtleta = new Atleta("Carlos", "Rodriguez", 20, 'M', true, 15.45);
		Atleta segundoAtleta = new Atleta("Maria", "Vasquez", 18, 'F', false, 22.75);
		System.out.println(primerAtleta.resumen());
		System.out.println("Segundo Atleta");
		System.out.println(segundoAtleta.resumen());
	}
}
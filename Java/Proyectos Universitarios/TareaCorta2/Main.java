/*En este metodo obtenemos datos de la clase Paciente para obtener el imc desde nutricionista
y finalmente mente asignar el nuevo valor imc en paciente. Adenas se utiliza JOptionPane
como entrada de datos del usuario y se imprime los resultados de paciente
Autor:Daniel*/
import Clases.Paciente; 
import Clases.Nutricionista; 
import javax.swing.JOptionPane;
class Main {
	public static void main(String[]args) {	
		//Entrada de datos
		String nombre = JOptionPane.showInputDialog("Digite su nombre");
		String pesoEnKilos = JOptionPane.showInputDialog("Digite su peso en Kilogramos");
		double nuevoPesoEnKilos = Double.parseDouble(pesoEnKilos);
		String alturaEnMetros = JOptionPane.showInputDialog("Digite su estatura en metros");
		double nuevaAlturaEnMetros = Double.parseDouble(alturaEnMetros);
		//Clase Paciente
		Paciente miPaciente = new Paciente(nombre, nuevoPesoEnKilos, nuevaAlturaEnMetros);
		System.out.println (miPaciente);
		//Clase nutricionista 
		Nutricionista miNutricionista = new Nutricionista();
		//Asignacion de datos
		miPaciente.setImc(miNutricionista.calcularImc(miPaciente.getPesoEnKilos(), miPaciente.getAlturaEnMetros()));
		System.out.println (miPaciente);
		String nom = miPaciente.getNombre();
		System.out.println (nom);

	}
}
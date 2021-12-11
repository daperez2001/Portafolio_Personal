package Clases;
	public class Atleta {
		//Atributos de la clase 
		private String nombre;
		private String apellido;
		private int edad;
		private String disciplina;
		private char genero;
		private boolean clasificado;
		private double puntuacion;
		//Constructor 
	public Atleta (String nuevoNombre, String nuevoApellido, int nuevaEdad, char nuevoGenero, boolean nuevoClasificado, double nuevaPuntuacion ){
		nombre = nuevoNombre;
		apellido = nuevoApellido;
		edad = nuevaEdad;
		disciplina = ("Atletismo");
		genero = nuevoGenero;
		clasificado = nuevoClasificado;
		puntuacion = nuevaPuntuacion;
		}
		//Metodos set y get 
		//Nombre
		public String getNombre(){
		return nombre;
		}
		public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
		}
		//Apellido
			public String getApellido(){
		return apellido;
		}
		public void setApellido(String nuevoApellido) {
		apellido = nuevoApellido;
		}
		//Edad
			public int getEdad(){
		return edad;
		}
		public void setEdad(int nuevaEdad) {
		edad = nuevaEdad;
		}
		//Disciplina
			public String getDisciplina(){
		return disciplina;
		}
		public void setDisciplina(String nuevaDisciplina) {
		disciplina = nuevaDisciplina;
		}
		//Genero
			public char getGenero(){
		return genero;
		}
		public void setGenero(char nuevoGenero) {
		genero = nuevoGenero;
		}
		//Clasificación 
			public boolean getClasificado(){
		return clasificado;
		}
		public void setClasificado(boolean nuevoClasificado) {
		clasificado = nuevoClasificado;
		}
		//Puntuación
			public double getPuntuacion(){
		return puntuacion;
		}
		public void setPuntuacion(double nuevaPuntuacion) {
		puntuacion = nuevaPuntuacion;
		}
		//Resumen del Atleta
		public String resumen() {
		String resumen = ("Nombre del Atleta: " + nombre + " " + apellido + "\nEdad del Ateta: " + edad +" años" + "\nDisciplina del Ateta: " + disciplina + "\nGenero del Atleta (M = Male and F = Female): " + genero + "\nClasificado: " + clasificado + "\nPuntuacion: " + puntuacion);
		return resumen;
		}
	}
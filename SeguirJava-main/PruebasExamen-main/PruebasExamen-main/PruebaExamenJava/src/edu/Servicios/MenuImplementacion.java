package edu.Servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz{

	Scanner sc = new Scanner(System.in);
	public int menuAmbulatorio() {
		
		
		
		System.out.println("Ambulatorio");
		System.out.println("///////////");
		System.out.println("[0] - Cerrar Menú");
		System.out.println("[1] - Pedir Citas");
		System.out.println("[2] - Registro de llegada");
		System.out.println("[3] - Listado de consultas");
		System.out.println("///////////");
		int op = sc.nextInt();
		
		return op;
		
	}
	
	public int menuConsultas() {
		
		
		System.out.println("Menú de consultas");
		System.out.println("///////////");
		System.out.println("[0] - Volver");
		System.out.println("[1] - Mostrar consultas");
		System.out.println("[2] - Imprimir consultas");
		System.out.println("///////////");
		int op2 = sc.nextInt();
		
		return op2;
		
	}
	
	public int menuCitas() {
		
		System.out.println("Tipo de consultas");
		System.out.println("///////////");
		System.out.println("[0] - Psicología");
		System.out.println("[1] - Traumatología");
		System.out.println("[2] - Fisioterapia");
		System.out.println("///////////");
		int op2 = sc.nextInt();
		
		return op2;
		
	}
}

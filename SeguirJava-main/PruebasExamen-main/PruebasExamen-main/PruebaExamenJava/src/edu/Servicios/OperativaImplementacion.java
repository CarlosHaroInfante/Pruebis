package edu.Servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import edu.Controladores.Inicio;
import edu.Dtos.Citas;
import edu.ficheros.ficherosImplementacion;
import edu.ficheros.ficherosInterfaz;

public class OperativaImplementacion implements OperativaInterfaz{

	
	String nombre = "CitasConAsistencia";
    LocalDate fechaHoy = LocalDate.now();
    String log2 = "C:\\Users\\Carlos\\Desktop\\" + fechaHoy + "log.txt";
    
    String citasConFecha = "C:\\Users\\Carlos\\Desktop\\CitasConAsistencia" + "-" + fechaHoy + ".txt";
    
	Scanner sc = new Scanner(System.in);
	
	
	
	public void CitasNueva(List<Citas> listaCitas) {
		try {	
		FileWriter escribe = new FileWriter(log2, true);
		
		Citas citasNuevas = new Citas();
		
		System.out.println("Pedir una cita nueva");
		
		System.out.println("Apellidos del paciente");
		citasNuevas.setApellidos(sc.nextLine());
		
		System.out.println("Nombre del paciente");
		citasNuevas.setNombre(sc.next());	
		
		System.out.println("DNI del paciente");
		citasNuevas.setDni(sc.next());
		
		System.out.println("Especialidad ([0] - Psicología | [1] - Traumatología | [2] - Fisioterapia)");
		int op = sc.nextInt();
		
		if(op == 0) {
			citasNuevas.setEspecialidad("Psicología");
		}
		else if(op == 1) {
			citasNuevas.setEspecialidad("Traumatología");
		}
		else if(op == 2) {
			citasNuevas.setEspecialidad("Fisioterapia");
		}
		else {
			System.out.println("opción no válida");
		}
	
		
		System.out.println("Fecha de  la cita(formato dd-MM-yyyy)");
		citasNuevas.setFechaCita(sc.next());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		System.out.println("Precio");
		citasNuevas.setPrecio(sc.nextDouble());
		
		citasNuevas.setIdCitas(idAuto(listaCitas));
		
		listaCitas.add(citasNuevas);
		
		escribe.write("Cita de paciente añadida \n");
		escribe.close();
		
		for (Citas citas : listaCitas) {
			System.out.println(citas.toString());
		}
		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al añadir la cita" + e.getMessage());
		}
		
		
	}
	public void registroLlegada(List<Citas> listaCitas) {
		
		try {
		FileWriter escribe = new FileWriter(log2, true);
		
		System.out.println("DNI del cliente con cita");
		String Dni = sc.next();
		
		LocalDate fechaHoy = LocalDate.now();
		
		int dia = fechaHoy.getDayOfMonth();
		int mes = fechaHoy.getMonthValue();
		int anyo = fechaHoy.getYear();
		
		String diaFin = String.valueOf(dia);
		String mesFin = String.valueOf(mes);
		String anyoFin = String.valueOf(anyo);
		
		String fechaFin = diaFin + "/" + mesFin + "/" + anyoFin;
		System.out.println(fechaFin);
		
		if(validarDni(Dni)) {
			
			System.out.println("El DNI es válido");
			escribe.write("\n Se valida el DNI");
			
			for (Citas citas : listaCitas) {
				if(citas.getFechaCita().equals(fechaFin)) {
					System.out.println("Espere su turno para la consulta de Psicología en la sala de espera. Su especialista le avisará.");
					citas.setVisita(true);
					
				}
			}
		}
		else {
			System.out.println("El DNI no es válido");
			escribe.write("\n El DNI no se ha podido validar");
		}
		escribe.close();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al validar la cita");
		}
	}
		
	
	public void listadoConsultasPsicologia(List<Citas> listaCitas) {
		
		try {
			FileWriter escribe = new FileWriter(log2, true);
			System.out.println("Fecha de la consulta dd/MM/yyyy");
			String fecha = sc.next();
			
			for(Citas citas : listaCitas) {
				
				if(citas.getEspecialidad().equals("Psicología") && citas.getFechaCita().equals(fecha)) {
					System.out.println(citas.getNombre()+ " " + citas.getApellidos() + " " + citas.getFechaCita());
					escribe.write("\n Se listan las consultas de psicología");
				}
				else {
					System.out.println("Ninguna opción valida");
				}
				
			}
			
			escribe.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar las consultas");
		}
		
	}
	
	/**else if(citas.getEspecialidad().equals("Traumatología") && citas.getFechaCita().equals(fecha)){
		System.out.println(citas.toString());
	}
	else if (citas.getEspecialidad().equals("Fisioterapia") && citas.getFechaCita().equals(fecha)) {
		System.out.println(citas.toString());**/
		
public void listadoConsultasTraumatologia(List<Citas> listaCitas) {
		
		try {
			FileWriter escribe = new FileWriter(log2, true);
			System.out.println("Fecha de la consulta dd/MM/yyyy");
			String fecha = sc.next();
			
			for(Citas citas : listaCitas) {
				
				if(citas.getEspecialidad().equals("Traumatología") && citas.getFechaCita().equals(fecha)) {
					System.out.println(citas.getNombre()+ " " + citas.getApellidos() + " " + citas.getFechaCita());
					escribe.write("\n Se listan las consultas de traumatología");
				}
				else {
					System.out.println("Ninguna opción valida");
				}
				
			}
			escribe.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar las consultas");
		}
		
	}

public void listadoConsultasFisioterapia(List<Citas> listaCitas) {
	
	try {
		FileWriter escribe = new FileWriter(log2, true);
		System.out.println("Fecha de la consulta dd/MM/yyyy");
		String fecha = sc.next();
		
		for(Citas citas : listaCitas) {
			
			if(citas.getEspecialidad().equals("Fisioterapia") && citas.getFechaCita().equals(fecha)) {
				System.out.println(citas.getNombre()+ " " + citas.getApellidos() + " " + citas.getFechaCita());
				escribe.write("\n Se listan las consultas de Fisioterapia \n");
			}
			else {
			}
			
		}
		escribe.close();
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al listar las consultas");
	}
	
}

public void imprimirConsultasPsicologia(List<Citas> listaCitas) {
	try {
		
		System.out.println("Fecha de la consulta dd/MM/yyyy");
		String fecha = sc.next();
		FileWriter escribe = new FileWriter(citasConFecha, true);
		for(Citas citas : listaCitas) {
			
			if(citas.getEspecialidad().equals("Psicología") && citas.getFechaCita().equals(fecha)) {
				escribe.write(citas.getNombre()+ " " + citas.getApellidos()+ " " + citas.getFechaCita() + "\n");
				
			}
			else {
				escribe.write("\n Ninguna opción valida");
			}
			
		
		}
		escribe.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al imprimir las consultas" + e.getMessage());
	}
}

public void imprimirConsultasTraumatologia(List<Citas> listaCitas) {
	
try {
		
		System.out.println("Fecha de la consulta dd/MM/yyyy");
		String fecha = sc.next();
		FileWriter escribe = new FileWriter(citasConFecha, true);
		for(Citas citas : listaCitas) {
			
			if(citas.getEspecialidad().equals("Traumatología") && citas.getFechaCita().equals(fecha)) {
				escribe.write(citas.getNombre()+ " " + citas.getApellidos()+ " " + citas.getFechaCita() + "\n");
				
			}
			else {
				escribe.write("\n Ninguna opción valida \n");
			}
		
		}
		escribe.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al imprimir las consultas" + e.getMessage());
	}
}

public void imprimirConsultasFisioterapia(List<Citas> listaCitas) {
	try {
		
	System.out.println("Fecha de la consulta dd/MM/yyyy");
	String fecha = sc.next();
	FileWriter escribe = new FileWriter(citasConFecha, true);
	for(Citas citas : listaCitas) {
		
		if(citas.getEspecialidad().equals("Fisioterapia") && citas.getFechaCita().equals(fecha)) {
			escribe.write(citas.getNombre()+ " " + citas.getApellidos()+ " " + citas.getFechaCita() + " \n");
			
		}
		else {
			escribe.write("\n Ninguna opción valida \n");
		}
	
	}
	escribe.close();
	
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error al imprimir las consultas" + e.getMessage());
	}
}
		
	
	private long idAuto(List<Citas> listaCitas) {
		
		long idNuevo = 0;
		
		int tamanioLista = listaCitas.size();
		
		
		if(tamanioLista > 0) {
			
			idNuevo = listaCitas.get(tamanioLista - 1).getIdCitas() + 1;
		}
		
		else {
			idNuevo = 1;
		}
		
		return idNuevo;
	}
	
	private boolean validarDni(String Dni) {
		
		if(Dni.length() != 9) {
			return false;
		}
		
		String  numeroDni = Dni.substring(0, 8);
		
		char letra = Character.toUpperCase(Dni.charAt(8));
		String letrasValida = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = Integer.parseInt(numeroDni) % 23;
		char letraCalculada = letrasValida.charAt(resto);
		
		return letra == letraCalculada;

	}
}

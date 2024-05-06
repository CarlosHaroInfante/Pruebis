package edu.Controladores;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.Dtos.Citas;
import edu.Servicios.MenuImplementacion;
import edu.Servicios.MenuInterfaz;
import edu.Servicios.OperativaImplementacion;
import edu.Servicios.OperativaInterfaz;
import edu.ficheros.ficherosImplementacion;
import edu.ficheros.ficherosInterfaz;

public class Inicio {
static LocalDate fechaHoy = LocalDate.now();

	public static void main(String[] args) {
		
		boolean cerrarMenu = false;
		
		List<Citas> citas = new ArrayList<Citas>();
		MenuInterfaz menu = new MenuImplementacion();
		OperativaInterfaz operativa = new OperativaImplementacion();
		String log = "C:\\Users\\Carlos\\Downloads\\PruebasExamen-main\\PruebasExamen-main\\PruebaExamenJava\\src\\edu\\" + fechaHoy + "log.txt";
	    String log2 = "C:\\Users\\Carlos\\Desktop\\" + fechaHoy + "log.txt";
		LocalDateTime ahora = LocalDateTime.now();
		ficherosInterfaz ficheros = new ficherosImplementacion();
		ficheros.leerse(citas);
		
		
		while(!cerrarMenu) {
			System.out.println(citas.toString());
			int opcion = menu.menuAmbulatorio();
			
			switch (opcion) {
			case 0: {
				
				try {
					System.out.println("Cerrar Menú");
					FileWriter escribe = new FileWriter(log2, true);
					escribe.write("Se cierra el menú. \n");
					escribe.close();
					cerrarMenu =  true;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al cerrar el menú" + e.getMessage());
				}
				
				break;
				
			}
			case 1: {
				try {
				
					System.out.println("Pedir Citas");
					FileWriter escribe = new FileWriter(log2, true);
					escribe.write("Pedir Citas \n");
					escribe.close();
					operativa.CitasNueva(citas);
					
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error en las opciones (Ambulatorio)" + e.getMessage());
				}

				break;
			}
			case 2: {
				try {
					
					System.out.println("Registro de llegada");
					FileWriter escribe = new FileWriter(log2, true);
					escribe.write("Registro de llegada \n");
					escribe.close();
					operativa.registroLlegada(citas);
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error en las opciones (Ambulatorio)" + e.getMessage());
				}
				
				break;
			}
			case 3: {
				
				try {
					
					
					FileWriter escribe = new FileWriter(log2, true);
					escribe.write("Listado de consultas \n");
					System.out.println("Listado de consultas");
					
					int opcion2 = menu.menuConsultas();
					switch (opcion2) {
				case 0: {
					
						System.out.println("Volver");
						escribe.write("Volver \n");
						escribe.close();
						menu.menuAmbulatorio();
						
					
					break;
				}
				case 1: {
					
						System.out.println("Mostrar consultas");
						escribe.write("Mostrar consultas");
						int  opcion3 = menu.menuCitas();
						switch (opcion3) {
					case 0: {
						System.out.println("Psicología");
						escribe.write("citas de psicología \n");
						escribe.close();
						operativa.listadoConsultasPsicologia(citas);
						break;
					}
					case 1: {
						System.out.println("Traumatología");
						escribe.write("citas de traumatología \n");
						operativa.listadoConsultasTraumatologia(citas);
						break;
					}
					case 2: {
						System.out.println("Fisioterapia");
						escribe.write("citas de fisioterapia \n");
						operativa.listadoConsultasFisioterapia(citas);
						break;
					}
					default:
						escribe.write("Opcion no válida");
						throw new IllegalArgumentException("Unexpected value: " + opcion3);
					}
						
						escribe.close();
					
					
					break;
				}
				case 2: {
					
					
					System.out.println("Imprimir consultas");
					escribe.write("Imprimir consultas \n");
					int  opcion3 = menu.menuCitas();
					switch (opcion3) {
				case 0: {
					System.out.println("Psicología");
					escribe.write("citas de psicología \n");
					operativa.imprimirConsultasPsicologia(citas);	
					break;
				}
				case 1: {
					System.out.println("Traumatología");
					escribe.write("citas de traumatología \n");
					operativa.imprimirConsultasTraumatologia(citas);
					break;
				}
				case 2: {
					System.out.println("Fisioterapia");
					escribe.write("citas de fisioterapia \n");
					operativa.imprimirConsultasFisioterapia(citas);
					break;
				}
				default:
					escribe.write("Opcion no válida \n");
					throw new IllegalArgumentException("Unexpected value: " + opcion3);
				}
					
					escribe.close();
					
					
					
					
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion2);
				}
				break;
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error en las opciones (Ambulatorio)" + e.getMessage());
				}
				
				
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
			
		}
		
		
	}
}

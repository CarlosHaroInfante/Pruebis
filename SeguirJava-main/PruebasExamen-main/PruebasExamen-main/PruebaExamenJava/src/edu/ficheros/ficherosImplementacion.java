package edu.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

import edu.Dtos.Citas;

public class ficherosImplementacion implements ficherosInterfaz{

	public void leerse(List<Citas> listaCitas) {
		
		LocalDate fechaHoy = LocalDate.now();
		
		String ruta = "C:\\Users\\Carlos\\Downloads\\PruebasExamen-main\\PruebasExamen-main\\PruebaExamenJava\\src\\edu\\" + fechaHoy;
		
		String citas = "C:\\Users\\Carlos\\Desktop\\citas.txt";
		
		
		try {
			
			BufferedReader leer = new BufferedReader(new FileReader(citas));
			
			String linea;
			
			while ((linea = leer.readLine()) != null) {
			Citas citasN = new Citas();	
			String[] lineas = linea.split(";");
			citasN.setDni(lineas[0]);
			citasN.setNombre(lineas[1]);
			citasN.setApellidos(lineas[2]);
			citasN.setEspecialidad(lineas[3]);
			citasN.setFechaCita(lineas[4]);
			Double precio = Double.parseDouble(lineas[5]);
			citasN.setPrecio(precio);
			Boolean visita = Boolean.parseBoolean(lineas[6]);
			citasN.setVisita(visita);
			listaCitas.add(citasN);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al importar el archivo" + e.getMessage());
		}
		
	}
	
	
	
}

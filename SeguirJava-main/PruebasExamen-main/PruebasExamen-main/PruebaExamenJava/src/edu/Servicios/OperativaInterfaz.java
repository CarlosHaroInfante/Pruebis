package edu.Servicios;

import java.util.List;

import edu.Dtos.Citas;

public interface OperativaInterfaz {

	public void CitasNueva(List<Citas> listaCitas);
	
	public void registroLlegada(List<Citas> listaCitas);
	
	public void listadoConsultasPsicologia(List<Citas> listaCitas);
	
	public void listadoConsultasTraumatologia(List<Citas> listaCitas);
	
	public void listadoConsultasFisioterapia(List<Citas> listaCitas);
	
	public void imprimirConsultasPsicologia(List<Citas> listaCitas);
	
	public void imprimirConsultasTraumatologia(List<Citas> listaCitas);
	
	public void imprimirConsultasFisioterapia(List<Citas> listaCitas);
}

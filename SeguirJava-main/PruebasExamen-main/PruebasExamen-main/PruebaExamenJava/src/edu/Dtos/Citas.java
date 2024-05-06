package edu.Dtos;

public class Citas {

		long idCitas;
		
		String dni = "aaaaa";
		
		String nombre = "aaaaa";
		
		String apellido1 = "aaaaa";
		
		String apellido2 = "aaaaa";
		
		String apellidos = "aaaaa";
		
		String especialidad = "aaaaa";
		
		String fechaCita = "31-12-9999";
		
		Double precio = 99.99;
		
		Boolean visita = false;

	public long getIdCitas() {
		return idCitas;
	}

	public void setIdCitas(long idCitas) {
		this.idCitas = idCitas;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getVisita() {
		return visita;
	}

	public void setVisita(Boolean visita) {
		this.visita = visita;
	}

	public Citas(long idCitas, String dni, String nombre, String apellido1, String apellido2, String apellidos, String especialidad,
			String fechaCita, Double precio, Boolean visita) {
		super();
		this.idCitas = idCitas;
		this.dni = dni;
		this.nombre =  nombre;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
		this.fechaCita = fechaCita;
		this.precio = precio;
		this.visita = visita;
		String[] apellidosJuntos = apellidos.split(" ");
		this.apellido1 = apellidosJuntos[0];
		this.apellido2 = apellidosJuntos[1];


	}
	
	public Citas() {}

	@Override
	public String toString() {
		return "Citas [idCitas=" + idCitas + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", especialidad=" + especialidad
				+ ", fechaCita=" + fechaCita + ", precio=" + precio + ", visita=" + visita + "]";
	}

	
}

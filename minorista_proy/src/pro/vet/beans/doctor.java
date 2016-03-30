package pro.vet.beans;

public class doctor {

	
	public int getIddoctor() {
		return iddoctor;
	}
	public void setIddoctor(int iddoctor) {
		this.iddoctor = iddoctor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEspecialidadbean(especialidad especialidadbean) {
		this.especialidadbean = especialidadbean;
	}
	public especialidad getEspecialidadbean() {
		return especialidadbean;
	}

	private int iddoctor;
	private String nombre;
	private especialidad especialidadbean;
	
}

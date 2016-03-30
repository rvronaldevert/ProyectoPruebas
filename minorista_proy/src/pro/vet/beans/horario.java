package pro.vet.beans;

import java.sql.Date;

public class horario {

	
	public int getIdhorario() {
		return idhorario;
	}
	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHoraini() {
		return horaini;
	}
	public void setHoraini(Date horaini) {
		this.horaini = horaini;
	}
	public Date getHorafin() {
		return horafin;
	}
	public void setHorafin(Date horafin) {
		this.horafin = horafin;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setDoctorbean(doctor doctorbean) {
		this.doctorbean = doctorbean;
	}
	public doctor getDoctorbean() {
		return doctorbean;
	}
	private int idhorario;
	private String nombre;
	private Date fecha;
	private Date horaini;
	private Date horafin;
	private doctor doctorbean;
	
}

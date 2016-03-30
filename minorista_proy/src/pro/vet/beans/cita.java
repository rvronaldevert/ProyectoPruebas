package pro.vet.beans;

public class cita {

	private int idcita;
	private mascota mascotabean;
	private horario horariobean;
	private doctor doctorbean;
	
	
	public int getIdcita() {
		return idcita;
	}
	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}
	public mascota getMascotabean() {
		return mascotabean;
	}
	public void setMascotabean(mascota mascotabean) {
		this.mascotabean = mascotabean;
	}
	public horario getHorariobean() {
		return horariobean;
	}
	public void setHorariobean(horario horariobean) {
		this.horariobean = horariobean;
	}
	public doctor getDoctorbean() {
		return doctorbean;
	}
	public void setDoctorbean(doctor doctorbean) {
		this.doctorbean = doctorbean;
	}
	

}

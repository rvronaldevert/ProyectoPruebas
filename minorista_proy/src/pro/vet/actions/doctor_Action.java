package pro.vet.actions;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import pro.vet.beans.doctor;
import pro.vet.services.doctor_implements;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="Veterinaria_LT")
public class doctor_Action extends ActionSupport {

	doctor_implements doctori = new doctor_implements();
	private ArrayList<doctor> doctores;
	private String especialidaddoctor;
	private doctor doctorbean;
	
	@Action( value="AGrabaDoctor",results={@Result(name="success",type="json")}
	)
public String Graba_doctores() throws Exception{

		System.out.println(doctorbean.getNombre());
System.out.println(doctorbean.getEspecialidadbean().getIdespecialidad());

return SUCCESS;


}
	
	private String fechaini,fechafin,doctor;
	
	public String getEspecialidaddoctor() {
		return especialidaddoctor;
	}

	public void setEspecialidaddoctor(String especialidaddoctor) {
		this.especialidaddoctor = especialidaddoctor;
	}

	@Action( value="AlistaDoctores",results={@Result(name="success",type="json")}
			)
	public String lista_doctores() throws Exception{
	
		
		setDoctores(doctori.listar_doctor());
		
		return SUCCESS;
		
		
	}
	
	@Action( value="JSONCargaDoctorxEspecialidad",results={@Result(name="success",type="json")}
	)
	public String lista_doctoresxespecialidad() throws Exception{
			doctores=doctori.listar_doctor_x_espe(Integer.parseInt(especialidaddoctor));
			return SUCCESS;
	}

	public void setDoctores(ArrayList<doctor> doctores) {
		this.doctores = doctores;
	}

	public ArrayList<doctor> getDoctores() {
		return doctores;
	}

	public void setFechaini(String fechaini) {
		this.fechaini = fechaini;
	}

	public String getFechaini() {
		return fechaini;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctorbean(doctor doctorbean) {
		this.doctorbean = doctorbean;
	}

	public doctor getDoctorbean() {
		return doctorbean;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

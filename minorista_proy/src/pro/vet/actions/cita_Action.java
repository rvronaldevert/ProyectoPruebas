package pro.vet.actions;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import pro.vet.beans.cita;
import pro.vet.beans.doctor;
import pro.vet.services.cita_implements;
import pro.vet.services.doctor_implements;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value="Veterinaria_LT")
public class cita_Action extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private ArrayList<cita> citas;
	private doctor doctorbeancita;
	private cita citabean;
	
	private cita_implements citai=
		new cita_implements();

	@Action( value="JSONGrabaCita",
			results={@Result(name="success",type="json")}
	)
	public String graba_cita() throws Exception{
	System.out.println(citabean.getDoctorbean().getIddoctor());
	System.out.println(citabean.getHorariobean().getIdhorario());
	System.out.println(citabean.getMascotabean().getIdmascota());
	
	return SUCCESS;

	}
	
@Action( value="AlistaCita",
		results={@Result(name="success",type="json")}
)
public String lista_cita() throws Exception{
citas =citai.lista_cita();
return SUCCESS;

}

@Action( value="JSONCargaDatos",
		results={@Result(name="success",type="json")}
)
public String cargadatos() throws Exception{
doctor_implements doctori=new doctor_implements();
doctorbeancita = doctori.listar_doctor().get(0);
return SUCCESS;
}
	
	public void setCitas(ArrayList<cita> citas) {
		this.citas = citas;
	}
	public ArrayList<cita> getCitas() {
		return citas;
	}


	public void setDoctorbeancita(doctor doctorbeancita) {
		this.doctorbeancita = doctorbeancita;
	}


	public doctor getDoctorbeancita() {
		return doctorbeancita;
	}

	public void setCitabean(cita citabean) {
		this.citabean = citabean;
	}

	public cita getCitabean() {
		return citabean;
	}
	

}

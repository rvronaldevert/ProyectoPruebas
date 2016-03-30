package pro.vet.actions;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import pro.vet.beans.especialidad;
import pro.vet.services.especialidad_Implements;


@ParentPackage(value="Veterinaria_LT")
public class especialidad_Action extends ActionSupport {
	private ArrayList<especialidad> especialidades;
	private especialidad_Implements especialidadi=new especialidad_Implements();
	private int especialidadid;
	
	@Action( value="JSONCargaEspecialidad",results={@Result(name="success",type="json")}
	)
	public String lista_especialidad() throws Exception{
		especialidades = especialidadi.listar_especialidad();
		return SUCCESS;
	}
	
	public void setEspecialidades(ArrayList<especialidad> especialidades) {
		this.especialidades = especialidades;
	}
	public ArrayList<especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidadid(int especialidadid) {
		this.especialidadid = especialidadid;
	}

	public int getEspecialidadid() {
		return especialidadid;
	}
	

}

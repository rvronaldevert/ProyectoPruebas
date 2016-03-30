package pro.vet.actions;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import pro.vet.beans.horario;
import pro.vet.services.horario_implements;
import pro.vet.services.horario_services;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="Veterinaria_LT")
public class horario_action extends ActionSupport {
	horario_implements horarioi=new horario_implements();
	private String 
	horafechaini,
	horafechafin,
	horariodoctor;
	private ArrayList<horario> horarios;
	

	@Action( value="JSONCargaHorariosxFecha",results={@Result(name="success",type="json")}
	)
	public String lista_horariosxfecha() throws Exception{		
			horarios=horarioi.listar_horarioXfecha(horafechaini);		
			return SUCCESS;	}
	
	@Action( value="JSONCargaHorariosFechas",results={@Result(name="success",type="json")}
	)
	public String lista_horariosxfechas() throws Exception{

			horarios=horarioi.listar_horarioXentrefechas(
					horafechaini, 
					horafechafin,
					Integer.parseInt(horariodoctor));

			return SUCCESS;
	}
	public void setHorarios(ArrayList<horario> horarios) {
		this.horarios = horarios;
	}
	public ArrayList<horario> getHorarios() {
		return horarios;
	}
	public void setHorafechaini(String horafechaini) {
		this.horafechaini = horafechaini;
	}
	public String getHorafechaini() {
		return horafechaini;
	}
	public void setHorafechafin(String horafechafin) {
		this.horafechafin = horafechafin;
	}
	public String getHorafechafin() {
		return horafechafin;
	}
	public void setHorariodoctor(String horariodoctor) {
		this.horariodoctor = horariodoctor;
	}
	public String getHorariodoctor() {
		return horariodoctor;
	}

}

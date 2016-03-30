package pro.vet.webservices;

import java.util.List;

import pro.vet.beans.doctor;
import pro.vet.services.doctor_implements;

public class ServicioWS {
	
	public List<doctor> listado() throws Exception{
		doctor_implements doctori=
			new doctor_implements();
		return doctori.listar_doctor();
	}
	public String graba(String cod,String nom){
		//Para grabar
		return "Registro Grabado";
	}
}

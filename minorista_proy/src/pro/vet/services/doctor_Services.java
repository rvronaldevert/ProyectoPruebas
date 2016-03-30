package pro.vet.services;

import java.util.ArrayList;

import pro.vet.beans.doctor;

public interface doctor_Services {

	
	
	public ArrayList<doctor> listar_doctor_x_nombre(doctor nom)throws Exception;
	
	
	public ArrayList<doctor> listar_doctor_x_espe(int id)throws Exception;
	
	//operacion de prueba para saber si conecta mybatis
	public ArrayList<doctor>listar_doctor( )throws Exception;
	
}

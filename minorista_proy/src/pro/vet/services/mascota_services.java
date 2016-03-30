package pro.vet.services;

import java.util.ArrayList;

import pro.vet.beans.mascota;

public interface mascota_services {
	
	public ArrayList<mascota> listar_mascota_x_nombre(String nom)throws Exception;
	public ArrayList<mascota> listar_mascota()throws Exception;
	public mascota busca_mascota(int idmascota)throws Exception;
	public String graba_mascota(mascota obj) throws Exception;
	
}

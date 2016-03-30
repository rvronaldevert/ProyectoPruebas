package pro.vet.services;

import java.util.ArrayList;

import pro.vet.beans.mascota;
import pro.vet.factory.DAOFactory;

public class mascota_implements implements mascota_services {

	 DAOFactory factory = DAOFactory.getFactory(1);
	 mascota_services dao =factory.getMascota_services();
	 
	@Override
	public ArrayList<mascota> listar_mascota_x_nombre(String nom)
			throws Exception {
		
		return dao.listar_mascota_x_nombre(nom);
	}

	@Override
	public String graba_mascota(mascota obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.graba_mascota(obj);
	}

	@Override
	public ArrayList<mascota> listar_mascota() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_mascota();
	}

	@Override
	public mascota busca_mascota(int idmascota) throws Exception {
		// TODO Auto-generated method stub
		return dao.busca_mascota(idmascota);
	}
	
	

}

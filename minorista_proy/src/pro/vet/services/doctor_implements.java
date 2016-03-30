package pro.vet.services;

import java.util.ArrayList;

import pro.vet.beans.doctor;
import pro.vet.factory.DAOFactory;

public class doctor_implements  implements doctor_Services{

	 DAOFactory factory = DAOFactory.getFactory(1);
	 doctor_Services dao =factory.getDoctor_services();
	@Override
	public ArrayList<doctor> listar_doctor_x_nombre(doctor nom)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_doctor_x_nombre(nom);
	}
	@Override
	public ArrayList<doctor> listar_doctor() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_doctor();
	}
	@Override
	public ArrayList<doctor> listar_doctor_x_espe(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_doctor_x_espe(id);
	}
	
	 
	 

	 

}

package pro.vet.services;

import java.util.ArrayList;

import pro.vet.beans.especialidad;
import pro.vet.factory.DAOFactory;

public class especialidad_Implements implements especialidad_Services {
	DAOFactory factory = DAOFactory.getFactory(1);
	 especialidad_Services dao =factory.getEspecialidad_Services();
	@Override
	public ArrayList<especialidad> listar_especialidad() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_especialidad();
	}

}

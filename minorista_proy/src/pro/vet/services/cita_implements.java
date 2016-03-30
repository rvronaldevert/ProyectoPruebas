package pro.vet.services;

import java.util.ArrayList;

import pro.vet.beans.cita;
import pro.vet.factory.DAOFactory;

public class cita_implements implements cita_services{
	
	DAOFactory factory = DAOFactory.getFactory(1);
	cita_services dao =factory.getCita_services();
	
	@Override
	public String registrar_cita(cita obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.registrar_cita(obj);
	}

	@Override
	public ArrayList<cita> lista_cita() throws Exception {
		// TODO Auto-generated method stub
		return dao.lista_cita();
	}
	

}

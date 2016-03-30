package pro.vet.services;

import java.util.ArrayList;


import pro.vet.beans.horario;
import pro.vet.factory.DAOFactory;

public class horario_implements implements horario_services {

	 
	DAOFactory factory = DAOFactory.getFactory(1);
	horario_services dao =factory.getHorario_Services();
	@Override
	public String registrar_horario(horario obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.registrar_horario(obj);
	}

	@Override
	public ArrayList<horario> listar_horarioXfecha(String fec)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_horarioXfecha(fec);
	}

	@Override
	public ArrayList<horario> listar_horarioXdoctor(horario doc) throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_horarioXdoctor(doc);
	}

	@Override
	public ArrayList<horario> listar_horarioXentrefechas(String fec1,
			String fec2,int doctor) throws Exception {
		// TODO Auto-generated method stub
		return dao.listar_horarioXentrefechas(fec1, fec2,doctor);
	}

}

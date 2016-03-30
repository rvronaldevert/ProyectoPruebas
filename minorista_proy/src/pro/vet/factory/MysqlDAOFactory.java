package pro.vet.factory;

 
import pro.vet.DAO.cita_DAO;
import pro.vet.DAO.doctor_DAO;
import pro.vet.DAO.especialidad_DAO;
import pro.vet.DAO.horario_DAO;
import pro.vet.DAO.mascota_DAO;
import pro.vet.services.cita_services;
import pro.vet.services.doctor_Services;
import pro.vet.services.especialidad_Services;
import pro.vet.services.horario_services;
import pro.vet.services.mascota_services;

public class MysqlDAOFactory extends DAOFactory{

	@Override
	public horario_services getHorario_Services() {
		 
		return new  horario_DAO();
	}

	@Override
	public doctor_Services getDoctor_services() {
		// TODO Auto-generated method stub
		return new doctor_DAO() ;
	}

	@Override
	public cita_services getCita_services() {
		// TODO Auto-generated method stub
		return new cita_DAO();
	}

	@Override
	public mascota_services getMascota_services() {
		// TODO Auto-generated method stub
		return new mascota_DAO();
	}

	@Override
	public especialidad_Services getEspecialidad_Services() {
		// TODO Auto-generated method stub
		return new especialidad_DAO();
	}

}

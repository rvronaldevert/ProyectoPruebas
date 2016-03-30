package pro.vet.factory;

import pro.vet.services.cita_services;
import pro.vet.services.doctor_Services;
import pro.vet.services.especialidad_Services;
import pro.vet.services.mascota_services;
import pro.vet.services.horario_services;

public abstract class DAOFactory {

	private static final int MYSQL=1;
	
	public abstract horario_services getHorario_Services();
	public abstract doctor_Services getDoctor_services();
	public abstract cita_services getCita_services();
	public abstract mascota_services getMascota_services();
	public abstract especialidad_Services getEspecialidad_Services();
	
	public static DAOFactory getFactory(int bd){
		return new MysqlDAOFactory();
	}
	
}

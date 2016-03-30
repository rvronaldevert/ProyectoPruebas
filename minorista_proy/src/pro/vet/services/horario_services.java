package pro.vet.services;

import java.util.ArrayList;


import pro.vet.beans.horario;

public interface horario_services {
	public ArrayList<horario>listar_horarioXentrefechas(String fec1,String fec2,int doctor)throws Exception;
	public ArrayList<horario>listar_horarioXfecha(String fec)throws Exception;
	public ArrayList<horario>listar_horarioXdoctor(horario doc)throws Exception;
	public String registrar_horario(horario obj)throws Exception;
}

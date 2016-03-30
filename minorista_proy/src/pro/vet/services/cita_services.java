package pro.vet.services;

import java.util.ArrayList;

import pro.vet.beans.cita;

public interface cita_services {
	public String registrar_cita(cita obj)throws Exception;
	public ArrayList<cita> lista_cita() throws Exception;
}

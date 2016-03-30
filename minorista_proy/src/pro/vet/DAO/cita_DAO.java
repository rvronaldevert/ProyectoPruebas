package pro.vet.DAO;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pro.vet.beans.cita;
import pro.vet.beans.doctor;
import pro.vet.services.cita_services;


public class cita_DAO implements cita_services{

    SqlSessionFactory sqlmapper= null;{
   	 try {
			
		
   	 Reader reader = Resources.getResourceAsReader("ConfiguracionIbatis.xml");
   	 
   	 sqlmapper =new  SqlSessionFactoryBuilder().build(reader);
   	 } catch (Exception e) {
				e.printStackTrace();
			}
    }
    
	@Override
	public String registrar_cita(cita obj) throws Exception {
		 SqlSession session = sqlmapper.openSession();
			String msg="";
			try {
				
				msg="exito"+ session.selectList("citaXML.registra_cita",obj);
				
			} catch (Exception e) {
				msg=e.getMessage();
			}finally{ session.close();}
		return msg;
		
	}

	@Override
	public ArrayList<cita> lista_cita() throws Exception {
	 ArrayList<cita> lista=null;
	 SqlSession session = sqlmapper.openSession();		
		try {			
			lista= (ArrayList<cita>)
			session.selectList("citaXML.lista_cita");			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ session.close();}
		return lista;		
	}

}

package pro.vet.DAO;

import java.io.Reader;

import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts.demoapp_struts.model.Event;
import org.apache.struts.demoapp_struts.model.User;


import pro.vet.beans.cita;
import pro.vet.services.doctor_Services;

public class user_DAO {

	

	         SqlSessionFactory sqlmapper= null;{
	        	 try {
					
				
	        	 Reader reader = Resources.getResourceAsReader("ConfiguracionIbatis.xml");
	        	 
	        	 sqlmapper =new  SqlSessionFactoryBuilder().build(reader);
	        	 } catch (Exception e) {
						e.printStackTrace();
					}
	         }
			
			public ArrayList<User> listar_usuarios()
					throws Exception {
				
				 ArrayList<User> lista=null;
				 SqlSession session = sqlmapper.openSession();
					
					try {
						
						lista= (ArrayList<User>) session.selectList("userxml.lista_usuario");
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{ session.close();}
				return lista;
				
			  
			}
			
			public ArrayList<Event> listar_eventos()
			throws Exception {
		
		 ArrayList<Event> lista=null;
		 SqlSession session = sqlmapper.openSession();
			
			try {
				
				lista= (ArrayList<Event>) session.selectList("userxml.lista_evento");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return lista;
		
	  
	}
			
			public String registrar_evento(Event obj) throws Exception {
				 SqlSession session = sqlmapper.openSession();
					String msg="";
					try {
						
						msg="exito"+ session.selectList("userxml.registra_evento",obj);
						
					} catch (Exception e) {
						msg=e.getMessage();
					}finally{ session.close();}
					System.out.println(msg);
				return msg;
				
			}
			
 	 

	 
}

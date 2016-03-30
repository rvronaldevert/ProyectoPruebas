package pro.vet.DAO;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pro.vet.beans.doctor;
import pro.vet.services.doctor_Services;

public class doctor_DAO  implements doctor_Services{

	

	         SqlSessionFactory sqlmapper= null;{
	        	 try {
					
				
	        	 Reader reader = Resources.getResourceAsReader("ConfiguracionIbatis.xml");
	        	 
	        	 sqlmapper =new  SqlSessionFactoryBuilder().build(reader);
	        	 } catch (Exception e) {
						e.printStackTrace();
					}
	         }
			@Override
			public ArrayList<doctor> listar_doctor_x_nombre(doctor nom)
					throws Exception {
				
				 ArrayList<doctor> lista=null;
				 SqlSession session = sqlmapper.openSession();
					
					try {
						
						lista= (ArrayList<doctor>) session.selectList("doctorxml.lista_usuario");
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{ session.close();}
				return lista;
				
			  
			}
			@Override
			public ArrayList<doctor> listar_doctor() throws Exception {
				 ArrayList<doctor> lista=null;
				 SqlSession session = sqlmapper.openSession();
					
					try {
						
						lista= (ArrayList<doctor>) session.selectList("doctorxml.lista_doctor");
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{ session.close();}
				return lista;
			}
			@Override
			public ArrayList<doctor> listar_doctor_x_espe(int id)
					throws Exception {
				 ArrayList<doctor> lista=null;
				 SqlSession session = sqlmapper.openSession();
					
					try {
						
						lista= (ArrayList<doctor>) session.selectList("doctorxml.lista_doctor_x_espe",id);
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally{ session.close();}
				return lista;
			} 
	
	
	
 

 	 

	 
}

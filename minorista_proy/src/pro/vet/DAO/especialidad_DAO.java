package pro.vet.DAO;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pro.vet.beans.doctor;
import pro.vet.beans.especialidad;
import pro.vet.services.especialidad_Services;

public class especialidad_DAO implements especialidad_Services {

	SqlSessionFactory sqlmapper= null;{
   	 try {
			
		
   	 Reader reader = Resources.getResourceAsReader("ConfiguracionIbatis.xml");
   	 
   	 sqlmapper =new  SqlSessionFactoryBuilder().build(reader);
   	 } catch (Exception e) {
				e.printStackTrace();
			}
    }
	
	@Override
	public ArrayList<especialidad> listar_especialidad() throws Exception {
		 ArrayList<especialidad> lista=null;
		 SqlSession session = sqlmapper.openSession();
			
			try {
				
				lista= (ArrayList<especialidad>) session.selectList("especialidadxml.lista_especialidad");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return lista;
	}

}

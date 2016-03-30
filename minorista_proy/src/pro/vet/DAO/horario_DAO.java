package pro.vet.DAO;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import pro.vet.beans.doctor;
import pro.vet.beans.horario;
 
import pro.vet.services.horario_services;

public class horario_DAO  implements horario_services{


    SqlSessionFactory sqlmapper= null;{
   	 try {
			
		
   	 Reader reader = Resources.getResourceAsReader("ConfiguracionIbatis.xml");
   	 
   	 sqlmapper =new  SqlSessionFactoryBuilder().build(reader);
   	 } catch (Exception e) {
				e.printStackTrace();
			}
    }
	 
	@Override
	public String registrar_horario(horario obj) throws Exception {
		
		
		 SqlSession session = sqlmapper.openSession();
			String msg="";
			try {
				
				msg="exito"+ session.selectList("horarioXML.registra_horario",obj);
				
			} catch (Exception e) {
				msg=e.getMessage();
			}finally{ session.close();}
		return msg;
		
	 
	}

	@Override
	public ArrayList<horario> listar_horarioXfecha(String fec)
			throws Exception {
		 ArrayList<horario> lista=null;
		 SqlSession session = sqlmapper.openSession();
			
			try {
				
				lista= (ArrayList<horario>) session.selectList("horarioXML.lista_horarior_x_fecha",fec);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return lista;
	}

	@Override
	public ArrayList<horario> listar_horarioXdoctor(horario doc) throws Exception {
		 ArrayList<horario> lista=null;
		 SqlSession session = sqlmapper.openSession();
			
			try {
				
				lista= (ArrayList<horario>) session.selectList("doctorXML.lista_horarior_x_doctor",doc);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return lista;
	}

	@Override
	public ArrayList<horario> listar_horarioXentrefechas(String fec1,
			String fec2,int doctor) throws Exception {
		 ArrayList<horario> lista=null;
		 SqlSession session = sqlmapper.openSession();
			
			try {
				Map<String, Object > params=
					new HashMap<String, Object>();

				params.put("f1", fec1);
				params.put("f2", fec2);
				params.put("iddoc", doctor);

				lista= (ArrayList<horario>) session.selectList("horarioXML.lista_horarior_x_entrefechas",params);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return lista;
	}

}

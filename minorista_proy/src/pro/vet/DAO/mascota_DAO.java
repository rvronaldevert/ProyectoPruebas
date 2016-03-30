package pro.vet.DAO;

import java.io.Reader;

import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




import pro.vet.beans.mascota;
import pro.vet.services.mascota_services;
import pro.vet.util.ImagenUtil;

public class mascota_DAO  implements mascota_services{

    SqlSessionFactory sqlmapper= null;{
   	 try {
			
		
   	 Reader reader = Resources.getResourceAsReader("ConfiguracionIbatis.xml");
   	 
   	 sqlmapper =new  SqlSessionFactoryBuilder().build(reader);
   	 } catch (Exception e) {
				e.printStackTrace();
			}
    }
    
	@Override
	public ArrayList<mascota> listar_mascota_x_nombre(String nom)
			throws Exception {		
		 ArrayList<mascota> lista=null;
		 SqlSession session = sqlmapper.openSession();			
			try {				
				lista= (ArrayList<mascota>) session.selectList("mascotaxml.lista_mascota_x_nombre",nom);				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return lista;  
	}

	@Override
	public String graba_mascota(mascota obj) throws Exception {

		 SqlSession session = sqlmapper.openSession();
			String msg="";
			try {
				obj.setImagenBytes(ImagenUtil.getBytesFromFile(obj.getImagen()));
				msg="exito"+ session.insert("mascotaxml.registra_mascota",obj);
				session.commit();
			} catch (Exception e) {
				msg=e.getMessage();
				session.rollback();
			}finally{ session.close();}
		return msg;
	}

	@Override
	public ArrayList<mascota> listar_mascota() throws Exception {
		ArrayList<mascota> lista=null;
		 SqlSession session = sqlmapper.openSession();			
			try {				
				lista= (ArrayList<mascota>) session.selectList("mascotaxml.lista_mascota");				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return lista;
	}
	

	@Override
	public mascota busca_mascota(int idmascota) throws Exception {
		// TODO Auto-generated method stub
		mascota bean=null;
		 SqlSession session = sqlmapper.openSession();			
			try {				
				bean= (mascota) session.selectOne("mascotaxml.busca_mascota",idmascota);				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{ session.close();}
		return bean;
	}

}

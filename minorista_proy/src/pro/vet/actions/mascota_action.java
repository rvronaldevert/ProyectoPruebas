package pro.vet.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import pro.vet.beans.mascota;
import pro.vet.services.mascota_implements;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value="Veterinaria_LT")
public class mascota_action extends ActionSupport {
	private mascota mascotabean;
	private mascota_implements mascotai=new mascota_implements();
	private ArrayList<mascota> mascotas;
	private ArrayList<mascota> mascotasnombre;
	private InputStream imagen;
	private String idmascota;
	
	@Action( value="JSONBuscaMascota",
			results={@Result(name="success",location="/DatosMascota.jsp")}
	)	
	public String busca_mascota() throws Exception{		
		mascotabean = mascotai.busca_mascota(mascotabean.getIdmascota());	
		return SUCCESS;
	}
	
	
	@Action(value = "/JSONCargarImagen", 
			results = { @Result(
							params={"inputName","imagen"}, 
							name = "success", type="stream") })
	public String CargaImagen() throws Exception {		
		try {
			
			mascota bean = mascotai.busca_mascota(Integer.parseInt(idmascota));			
			imagen = new ByteArrayInputStream(bean.getImagenBytes());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	@Action( value="JSONGrabaMascota",
			results={@Result(name="success",type="json")}
	)	
	public String graba_mascota() throws Exception{
		mascotai.graba_mascota(mascotabean);
		return SUCCESS;

	}

	@Action( value="JSONListaMascota",
			results={@Result(name="success",type="json")}
	)	
	public String lista_mascota() throws Exception{
		mascotas=mascotai.listar_mascota();		
		return SUCCESS;

	}

	@Action( value="JSONListaMascotaNombre",
			results={@Result(name="success",type="json")}
	)	
	public String lista_mascotaNombre() throws Exception{		
		mascotasnombre =mascotai.listar_mascota_x_nombre("%"+mascotabean.getNombre()+"%");		
		return SUCCESS;

	}
	public void setMascotabean(mascota mascotabean) {
		this.mascotabean = mascotabean;
	}

	public mascota getMascotabean() {
		
		return mascotabean;
	}

	public void setMascotas(ArrayList<mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public ArrayList<mascota> getMascotas() {
		return mascotas;
	}

	public void setImagen(InputStream imagen) {
		this.imagen = imagen;
	}

	public InputStream getImagen() {
		return imagen;
	}

	public void setIdmascota(String idmascota) {
		this.idmascota = idmascota;
	}

	public String getIdmascota() {
		return idmascota;
	}

	public void setMascotasnombre(ArrayList<mascota> mascotasnombre) {
		this.mascotasnombre = mascotasnombre;
	}

	public ArrayList<mascota> getMascotasnombre() {
		return mascotasnombre;
	}

	 
}

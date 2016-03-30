package pro.vet.beans;

import java.io.File;

public class mascota {



	private File imagen;
	private String imagenFileName;
	public File getImagen() {
		return imagen;
	}
	public void setImagen(File imagen) {
		this.imagen = imagen;
	}
	public String getImagenFileName() {
		return imagenFileName;
	}
	public void setImagenFileName(String imagenFileName) {
		this.imagenFileName = imagenFileName;
	}
	public String getImagenContentType() {
		return imagenContentType;
	}
	public void setImagenContentType(String imagenContentType) {
		this.imagenContentType = imagenContentType;
	}
	public byte[] getImagenBytes() {
		return imagenBytes;
	}
	public void setImagenBytes(byte[] imagenBytes) {
		this.imagenBytes = imagenBytes;
	}



	private String imagenContentType;
	private byte[] imagenBytes;
	
	
	public int getIdmascota() {
		return idmascota;
	}
	public void setIdmascota(int idmascota) {
		this.idmascota = idmascota;
	}
	
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}



	private int idmascota;
	private String nombre;

}

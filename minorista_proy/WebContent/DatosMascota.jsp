<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

               <div class="type-text">
        			<label>Nombre</label>
        			<sj:textfield name="mascotabean.nombre"/>
        		</div>    
				<div class="type-text">
        			<label>Imagen</label>        			        			
        			<img src="JSONCargarImagen?idmascota=${mascotabean.idmascota}" width="400" height="400" border="1" />
        		</div>
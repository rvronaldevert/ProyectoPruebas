<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function formatimg(cellvalue, options, rowObject){		
			return "<img src='JSONCargarImagen?idmascota="+cellvalue+"' width='50' height='50'/>";
	}
	function formatlink(cellvalue, options, rowObject){
		return "<a href=javascript:AbreImagen('"+cellvalue+"')>Aqui</a>";		
	}
	function AbreImagen(id){
		document.getElementById("imgfoto").src ="JSONCargarImagen?idmascota="+id;
	}
</script>
</head>
<sj:head jquerytheme="showcase" customBasepath="themes" />
<link rel="stylesheet" href="styles/layout.css" type="text/css"/>
<body>
<s:form id="frmb"  theme="simple" cssClass="yform" action="JSONGrabaMascota" method="post" enctype="multipart/form-data">	
	        	<fieldset>
        		<legend>Datos de la mascota</legend>
        		<div class="type-text">
        			<label>Codigo</label>
        			<sj:textfield name="mascotabean.idmascota"/>
        		</div>
        		<div id="divResultMascota">
        		
        		</div>		    	
				<sj:submit id="btngrabar" button="true" indicator="indicator" value="Graba" targets="divResultMascota"/>	
	    </fieldset>
</s:form>
<s:form id="frmc" theme="simple" cssClass="yform" >
<s:url id="URLListaMascota" action="JSONListaMascota"/>
<sj:autocompleter
                    href="%{URLListaMascota}" 
					id="txtmascota"
					list="mascotas"										
					name="mascotabean.nombre"					 
					listKey="nombre" 
					listValue="nombre"
					loadMinimumCount="2"																						
					onCompleteTopics="reloadMascota"									
					/>
<div id="idResult"></div>
<s:url id="URLListaMascotaNombre" action="JSONListaMascotaNombre"/>        
        <sjg:grid id="grdmascota" 
        gridModel="mascotasnombre" 
        dataType="json"  
        href="%{URLListaMascotaNombre}"        
        reloadTopics="reloadMascota"
        formIds="frmc"        
        >
        	<sjg:gridColumn key="true" name="idmascota" title="Id"/>        	
        	<sjg:gridColumn name="nombre" title="Nombre Mascota"/>       	        	
        	<sjg:gridColumn name="idmascota" title="Aqui" formatter="formatimg"/>
        	<sjg:gridColumn name="idmascota" title="Aqui" formatter="formatlink"/>
        </sjg:grid>

<img id="imgfoto"/>
</s:form>
</body>
</html>
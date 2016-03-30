<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function formatlink(cellvalue, options, rowObject){		
		return "<a href=javascript:AbreDialogo('"+cellvalue+"')>"+cellvalue+"</a>";
	}
	function AbreDialogo(id){
		$("#dialog1").dialog("open");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<sj:head jquerytheme="showcase" customBasepath="themes" />
<link rel="stylesheet" href="style/layout.css" type="text/css" media="all" />
<body>

<s:form>
	<s:url id="URLCargaDatos" action="JSONCargaDatos"/>	
	<div class="type-button">	
		<sj:submit button="true" value="Abrir" href="%{URLCargaDatos}" onCompleteTopics="openDia"/>
	</div>
</s:form>
 <s:url id="URLCitas" action="AlistaCita"/>        
        <sjg:grid id="grdhorario" 
        gridModel="citas" 
        dataType="json"  
        href="%{URLCitas}"        
        >
        	<sjg:gridColumn key="true" name="idcita" title="Id"/>
        	<sjg:gridColumn name="horariobean.fecha" title="Fecha"/>
        	<sjg:gridColumn name="mascotabean.nombre" title="Nombre Mascota"/>        	
        	<sjg:gridColumn name="horariobean.doctorbean.nombre" title="Fecha"/>        	
        	<sjg:gridColumn name="idcita" title="Aqui" formatter="formatlink"/>
        </sjg:grid>
        <sj:dialog id="dialog1" 
        title="Datos Adicionales" autoOpen="false" modal="true" 
        width="500" height="600"
        openTopics="openDia">
        <s:form>
        	<fieldset>
        		<legend>Datos del doctor</legend>
        		<div class="type-text">
        			<label>Codigo</label>
        			<sj:textfield name="doctorbeancita.iddoctor"/>
        		</div>
        		<div class="type-text">
        			<label>Nombre</label>
        			<sj:textfield name="doctorbeancita.nombre"/>
        		</div>
        	</fieldset>
        </s:form>
        	
        </sj:dialog>
</body>
</html>
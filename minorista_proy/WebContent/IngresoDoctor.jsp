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

</head>
<sj:head jquerytheme="showcase" customBasepath="themes" />
<link rel="stylesheet" href="themes/showcase/jquery.ui.theme.css" type="text/css" media="all" />
<body>
<s:form id="frmconsulta"  cssClass="yform" 
action="AGrabaDoctor">
<sj:textfield name="mascotabean.nombre"/>
<sj:textfield name="doctorbean.nombre"/>

<s:url id="URLEspecialidad" action="JSONCargaEspecialidad"/> 
				<sj:select 
					href="%{URLEspecialidad}" 
					id="cboespecialidad"										
					name="doctorbean.especialidadbean.idespecialidad" 
					list="especialidades" 
					listKey="idespecialidad" 
					listValue="desespecialidad"					
					headerKey="-1" 
					headerValue="-- Seleccione --"
				/>
				<sj:submit value="Graba"/>
</s:form>
</body>
</html>
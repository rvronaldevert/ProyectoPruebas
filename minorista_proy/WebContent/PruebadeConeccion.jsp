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

<s:form id="frmconsulta"  cssClass="yform" action="JSONCargaHorariosFechas">
        <fieldset>
            <legend>AJAX Form</legend>
	        <div class="type-text">
	            Especialidad
				<s:url id="URLEspecialidad" action="JSONCargaEspecialidad"/> 
				<sj:select 
					href="%{URLEspecialidad}" 
					id="cboespecialidad" 
					onChangeTopics="reloadDoctor"					
					name="especialidaddoctor" 
					list="especialidades" 
					listKey="idespecialidad" 
					listValue="desespecialidad"					
					headerKey="-1" 
					headerValue="-- Seleccione --"
				/>
	        </div>
	        <div class="type-text">
	            Doctor
				<s:url id="URLDoctor" action="JSONCargaDoctorxEspecialidad"/> 
				<sj:select 
					href="%{URLDoctor}" 
					id="cbodoctor"		 
					formIds="frmconsulta" 
					reloadTopics="reloadDoctor" 
					name="horariodoctor" 
					list="doctores"				
					listKey="iddoctor" 
					listValue="nombre"	 
					headerKey="-1" 
					headerValue="-- Seleccione --"
				/>
	        </div>
	        <div class="type-text">
	        
	        <sj:datepicker value="today" id="txtdel" 
	        name="horafechaini" displayFormat="yy-mm-dd" label="Desde" />	        
	        </div>
	        <div class="type-text">
	        
	        <sj:datepicker value="today" id="txtal" name="horafechafin" displayFormat="yy-mm-dd" label="Hasta" />	        
	        </div>
	        <div class="type-button">
				
				<sj:submit 
					id="btnConsultar"					 
					value="Consultar" 		
					button="true"
					targets="divresult"
					onClickTopics="cargaGrid"
					indicator="indicator"
				/>
									
					<img id="indicator" 
						src="images/indicator.gif" 
						alt="Loading..." 
						style="display:none"
					/>
	        </div>
        </fieldset>       
        <s:url id="URLFechas" action="JSONCargaHorariosFechas"/>        
        <sjg:grid id="grdhorario" 
        gridModel="horarios" 
        dataType="json"  
        href="%{URLFechas}" 
        formIds="frmconsulta"
        reloadTopics="cargaGrid"
        >
        	<sjg:gridColumn name="idhorario" title="Id"/>
        	<sjg:gridColumn name="fecha" title="Fecha"/>
        	<sjg:gridColumn name="doctorbean.nombre" title="Nombre Doctor"/>
        	<sjg:gridColumn name="doctorbean.especialidadbean.desespecialidad" title="Especialidad"/>
        </sjg:grid>
        
 <div id="divresult">
    </div>
           
    </s:form>
 
</body>
</html>
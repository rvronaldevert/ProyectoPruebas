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
<link rel="stylesheet" href="styles/layout.css" type="text/css"/>
<script type="text/javascript">	
	function formatSel(cellvalue, options, rowObject){
		return "<a href=javascript:JalaDatos('"+cellvalue+"')>Aqui</a>";		
	}
	function JalaDatos(id){
		document.getElementById("txtidmascota").value=id;		
		$("#dialogAyuda").dialog("close");
	}
	function Actualiza(){
		alert("jj");
	}
	$.subscribe('rowSelect',function(event ,data){
		var grid = event.originalEvent.grid; 
		var row  = grid.jqGrid('getGridParam', 'selrow');
		var iddoctor   = grid.jqGrid('getCell', row, 'doctorbean.iddoctor');
		var idhorario  = grid.jqGrid('getCell', row, 'idhorario');
		
		
		document.getElementById("txtcitaidhorario").value=idhorario;
		document.getElementById("txtcitaiddoctor").value=iddoctor;		
	});
	 $.subscribe('actualizar', function(event,data) {
		 document.getElementById("txtcitaidmascota").value=document.getElementById("txtidmascota").value;
    });
</script>
<body>
	
<table>

	<tr>
		<td valign="top" width="400px">
		
		<s:form id="frmM"  theme="simple" cssClass="yform" action="JSONBuscaMascota">	
	        	<fieldset>
        		<legend>Datos de la mascota</legend>
        		<div class="type-text">
        			<label>Codigo</label>
        			<sj:textfield id="txtidmascota" name="mascotabean.idmascota"/>        			
        		</div>
        		<div class="type-button">
        		<sj:submit id="btnBuscar" button="true" value="Buscar" targets="divResulMascota" indicator="indicator" formIds="frmM" buttonIcon="ui-icon-find" onCompleteTopics="actualizar"/>
        		<sj:a openDialog="dialogAyuda" id="btnAyuda" button="true" buttonIcon="ui-icon-newwin">Ayuda</sj:a>
        		</div>
        		<div id="divResulMascota">
				</div>        		
				</fieldset>			
		</s:form>	
		
		</td>
		<td valign="top">
		
		<s:form id="frmH"  theme="simple" cssClass="yform" action="JSONGrabaMascota">	
	        	<fieldset>
        		<legend>Consultar Horario</legend>
        		<div class="type-text">
        			<label>Fecha</label>
        			<sj:datepicker value="today" id="txtfecha"   name="horafechaini" displayFormat="yy-mm-dd" />
        			<sj:submit 
					id="btnConsultar"					 
					value="Consultar" 		
					button="true"
					targets="divresult"
					onClickTopics="cargaGrid"
					indicator="indicator"
				/>        
        		</div>
        		<div>
        		<s:url id="URLFechas" action="JSONCargaHorariosxFecha"/>        
        <sjg:grid id="grdhorario" 
        gridModel="horarios" 
        dataType="json"  
        href="%{URLFechas}" 
        formIds="frmH"
        reloadTopics="cargaGrid"
        onSelectRowTopics="rowSelect"
        >
        	<sjg:gridColumn name="doctorbean.iddoctor" title="IdDoctor" />
        	<sjg:gridColumn name="idhorario" title="Id"/>
        	<sjg:gridColumn name="fecha" title="Fecha"/>
        	<sjg:gridColumn name="doctorbean.nombre" title="Nombre Doctor"/>
        	<sjg:gridColumn name="doctorbean.especialidadbean.desespecialidad" title="Especialidad"/>
        	
        </sjg:grid>
        		</div>
        		</fieldset>
        </s:form>
		</td>
		<td>
		

		</td>
	</tr>
</table>

<sj:dialog id="dialogAyuda"  autoOpen="false" modal="true" title="Ayuda de mascota" width="500" height="300">
	<s:form id="frmF" theme="simple" cssClass="yform" >
		<sj:textfield name="mascotabean.nombre" onChangeTopics="reloadMascota"/>
		
		<s:url id="URLListaMascotaNombre" action="JSONListaMascotaNombre"/>        
        <sjg:grid id="grdmascota" 
        gridModel="mascotasnombre" 
        dataType="json"  
        href="%{URLListaMascotaNombre}"        
        reloadTopics="reloadMascota"
        formIds="frmF"        
        >
        	<sjg:gridColumn key="true" name="idmascota" title="Id"/>        	
        	<sjg:gridColumn name="nombre" title="Nombre Mascota"/>
        	<sjg:gridColumn name="idmascota" title="Seleccionar" formatter="formatSel"/>       	       	
        	
        </sjg:grid>
											
   </s:form>
</sj:dialog>
<s:form action="JSONGrabaCita">
<s:hidden id="txtcitaidmascota" name="citabean.mascotabean.idmascota"  />
<s:hidden id="txtcitaidhorario" name="citabean.horariobean.idhorario"/>
<s:hidden id="txtcitaiddoctor" name="citabean.doctorbean.iddoctor"/>
        			<sj:submit 
					id="btnGrabar"					 
					value="Grabar" 		
					button="true"
					targets="divresult"					
					indicator="indicator"
				/>        

</s:form>
</body>
</html>
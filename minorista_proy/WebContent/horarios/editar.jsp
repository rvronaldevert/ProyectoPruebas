<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<html>
<head>
<title><s:text  name="global.titulo" /></title>	

<sj:head locale="es" jqueryui="true" jquerytheme="le-frog"/>

<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/screen.css" />



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="struts2, jquery, jquery-ui, plugin, showcase, jqgrid" />
<meta http-equiv="description" content="A Showcase for the Struts2 jQuery Plugin" />

<script type="text/javascript">

function seleccion1(valor){
	document.getElementById("productoApicola").value = valor;
}

function seleccion2(valor){
	document.getElementById("envase").value = valor;
}

</script>

<style>

#idForm28LightboxLabelText { position: absolute;	top: 20px;	left: 20px;	width: 100px;	height: 20px;	}
#event_text { position: absolute;	top: 20px;	left: 190px; width: 150px;	height: 20px;	}  

#idForm28LightboxLabelDesde { position: absolute;	top: 50px;	left: 20px;	width: 100px;	height: 20px;	}
#event_start_date { position: absolute;	top: 50px;	left: 190px; width: 150px;	height: 20px;	}  

#idForm28LightboxLabelHasta { position: absolute;	top: 80px;	left: 20px;	width: 100px;	height: 20px;	}
#event_end_date { position: absolute;	top: 80px;	left: 190px; width: 150px;	height: 20px;	}  

#idForm28LabelProductoApicola { position: absolute;	top: 110px;	left: 20px;	width: 150px;	height: 20px;	}
#idForm28ProductoApicola { position: absolute;	top: 110px;	left: 190px; width: 150px;	height: 25px;	}  

#idForm28LabelEnvase { position: absolute;	top: 140px;	left: 20px;	width: 100px;	height: 20px;	}
#idForm28Envase { position: absolute;	top: 140px;	left: 190px; width: 150px;	height: 25px;	}  

#idForm28LabelCantidad { position: absolute;	top: 170px;	left: 20px;	width: 150px;	height: 20px;	}
#idForm28Cantidad { position: absolute;	top: 170px;	left: 190px; width: 150px;	height: 20px;	}  

 #idForm28LightboxGuardar{	  position: absolute;	top: 230px;	left: 20px;	width: 80px;	height: 30px;	}
#idForm28LightboxCancelar{	  position: absolute;	top: 230px;	left: 120px;	width: 80px;	height: 30px;	}
#idForm28LightboxEliminar{	  position: absolute;	top: 230px;	left: 220px;	width: 80px;	height: 30px;	}

#idDivForm28Editar{	position: absolute;	top: 0px;	left: 0px;	background-color:  #EBFCE4; padding: 0px;color: green;	font-size: 13px;	font-style: normal;	font-family: Verdana, Geneva, sans-serif;	}

#idDivMensajeForm28Lightbox { position: absolute;	top: 135px;	left: 20px;	width: 400px;	height: 20px; font-size: 11px;	}

</style>

 
<body >

<div  id="idDivForm28Editar">
<div id="idDivMensajeForm28Lightbox"></div>

<s:form id='idForm28Lightbox'>
		<label id="idForm28LightboxLabelText">Nombre</label>
		<s:textfield id="event_text" name="text" />
		
		<label id="idForm28LightboxLabelDesde">Desde</label>
		<s:textfield id="event_start_date" name="start_date" readonly="true"/>
		
		<label id="idForm28LightboxLabelHasta">Hasta</label>
		<s:textfield id="event_end_date" name="end_date"  readonly="true"/>

		<label id="idForm28LabelCantidad">Cantidad (unidades)</label>
		<sj:textfield  id="idForm28Cantidad"  name="cantidad" onkeypress="return validarSoloNumerosEnteros(event);" maxlength="5"/>
	
		<s:hidden id="productoApicola" name="productoApicola"  />
		<s:hidden id="envase" name="envase"  />
		
		<sj:submit id="idForm28LightboxGuardar"  button="true" value="Guardar" onclick="lightbox.save();" />
		<sj:submit id="idForm28LightboxCancelar" button="true" value="Cancelar" onclick="lightbox.close()" />
		<sj:submit  id="idForm28LightboxEliminar" button="true" value="Eliminar" onclick="lightbox.remove()" />
</s:form>
	
</div>
	

</body>
</html>

<script>
	var nombres = ["","","","","","","Guardar","Cancelar","Eliminar"];

	getValues = function () {
		var ev = {};
		var inputs = document.body.getElementsByTagName('input');

		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "button") {
				continue;
			}
			var name = inputs[i].getAttribute('name');
			if (name == "start_date" || name == "end_date"){
				ev[name] = parent.scheduler.templates.api_date(inputs[i].value);
			}
			else{
				ev[name] = inputs[i].value;
			}
		}
		return ev;
	};

	setValues = function (obj) {
		var inputs = document.body.getElementsByTagName('input');
		for (var i = 0; i < inputs.length; i++){
			if (inputs[i].type != "button") {
				var name = inputs[i].getAttribute('name');
				if (name == "start_date" || name == "end_date"){
					inputs[i].value = parent.scheduler.date.date_to_str(parent.scheduler.config.api_date)(obj[name]);
				}else{
					inputs[i].value = nombres[i];
				}
			}
		}
	};


	
</script>







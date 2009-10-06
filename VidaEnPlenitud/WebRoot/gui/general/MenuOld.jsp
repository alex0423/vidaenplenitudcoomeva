<?xml version="1.0" encoding="ISO-8859-1" ?>
<f:subview id="MenuPrincipal"  
	xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:ice="http://www.icesoft.com/icefaces/component">    
	<f:loadBundle basename="co.com.rpro.label.labels" var="lbl" />
	<ice:form partialSubmit="true">
		Prueba
		<ice:panelGroup style="width=100%" styleClass="exampleBox menuBarContainer">
			<ice:menuBar id="menuBar" orientation="Horizontal">

				<!-- admistracion menu -->
				<ice:menuItem value="#{lbl['labels.menu.adminsitracion']}"
					id="admistracion" onclick="return false;">
					<ice:menuItem action="#{menuBar.primaryListener}"
						id="reasigProveedor"
						value="#{lbl['labels.menu.admin.reasigprove']}"
						icon="/images/menu/open.gif">
						<f:param name="myParam" value="reasigProveedor" />
					</ice:menuItem>
					<ice:menuItem id="asigCorrEval"
						value="#{lbl['labels.menu.admin.asigCorrEva']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="asigCorrEval" />
					</ice:menuItem>
					<ice:menuItem id="actPlantilla"
						value="#{lbl['labels.menu.admin.actualplant']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="actPlantilla" />
					</ice:menuItem>
					<ice:menuItem id="tipProveedor"
						value="#{lbl['labels.menu.admin.admistiprove']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="tipProveedor" />
					</ice:menuItem>
					<ice:menuItem id="tipProdu"
						value="#{lbl['labels.menu.admin.admistiprodu']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="tipProdu" />
					</ice:menuItem>
				</ice:menuItem>

				<!-- Edit Proceso -->
				<ice:menuItem value="#{lbl['labels.menu.proceso']}" id="proceso"
					onclick="return false;">
					<ice:menuItem action="#{menuBar.primaryListener}"
						id="generarClave"
						value="#{lbl['labels.menu.proceso.genclave']}"
						icon="/images/menu/open.gif">
						<f:param name="myParam" value="generarClave" />
					</ice:menuItem>
					<ice:menuItem id="registrarProveedor"
						value="#{lbl['labels.menu.proceso.registproveedor']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="registrarProveedor" />
					</ice:menuItem>
					<ice:menuItem id="evaluProveedor"
						value="#{lbl['labels.menu.proceso.evaluproveedor']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="evaluProveedor" />
					</ice:menuItem>
					<ice:menuItem id="corrProveedor"
						value="#{lbl['labels.menu.proceso.correvaluacion']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="corrProveedor" />
					</ice:menuItem>
				</ice:menuItem>

				<!-- View menu -->
				<ice:menuItem value="#{lbl['labels.menu.consulta.consulta']}"
					id="consulta" onclick="return false;">
					<ice:menuItem action="#{menuBar.primaryListener}"
						id="archAdjunto"
						value="#{lbl['labels.menu.consulta.archivoadjunto']}"
						icon="/images/menu/open.gif">
						<f:param name="myParam" value="archAdjunto" />
					</ice:menuItem>
					<ice:menuItem id="logCambios"
						value="#{lbl['labels.menu.consulta.logcambio']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="logCambios" />
					</ice:menuItem>
					<ice:menuItem id="hisProveedor"
						value="#{lbl['labels.menu.consulta.histoprovee']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="hisProveedor" />
					</ice:menuItem>
					<ice:menuItem id="maesProveedor"
						value="#{lbl['labels.menu.consulta.maestprovee']}"
						action="#{menuBar.primaryListener}">
						<f:param name="myParam" value="maesProveedor" />
					</ice:menuItem>
				</ice:menuItem>
			</ice:menuBar>
		</ice:panelGroup>
	</ice:form>
</f:subview>

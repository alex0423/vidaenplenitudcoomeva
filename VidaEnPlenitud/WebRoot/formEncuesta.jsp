<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
	<jsp:directive.page contentType="text/html;charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" />
	<f:view>
		<ice:outputDeclaration doctypeRoot="html"
			doctypePublic="-//W3C//DTD HTML 4.01 Transitional//EN"
			doctypeSystem="http://www.w3.org/TR/html4/loose.dtd" />
		<html>
			<head>
				<title><ice:outputText
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.encuestaExpertos.titulo']} " />
				</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
				<style type="text/css">
.panelSubtitulo {
	background-color: #006668;
	FONT-WEIGHT: bold;
	text-transform: uppercase;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #ffffff;
}
</style>
			</head>
			<body>
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
				<ice:panelGrid styleClass="panelCabeceraWidth" style="width: 935px">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>

				<br />
				<ice:form>

					<ice:panelGrid columns="1" styleClass="panelCabecera1"
						style="width: 925px">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.encuesta.titulo']}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>
					<br />


					<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
						styleClass="panelCabeceraWidth" columns="2"
						style="text-align: left; vertical-align: top; display: inline; width: 926px; height: 470px"
						border="0">

						<ice:panelGrid columns="2" style="width: 393px" border="0"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">
							<ice:outputText value="#{lbl['labels.encuesta.mediocon']}"></ice:outputText>
							<ice:selectOneMenu style="width: 195px" styleClass="ingresos"
								valueChangeListener="#{encuesta.onSelectMedCon}"
								partialSubmit="true" immediate="true"
								value="#{encuesta.selectedMedCon}">
								<f:selectItems value="#{LOVs.mediosConocimiento}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.encuesta.mediocon.esp']}"></ice:outputText>
							<ice:panelGrid>
								<ice:outputText rendered="true" binding="#{encuesta.lblOutput}" />
								<ice:inputTextarea value="#{encuesta.aclaracionMedCon}"
									cols="40" rows="4" binding="#{encuesta.txtAclMedCon}"
									styleClass="ingresos"></ice:inputTextarea>
							</ice:panelGrid>
							<ice:outputText value="#{lbl['labels.encuesta.cumple_esp']}"></ice:outputText>
							<ice:selectOneMenu styleClass="ingresos" partialSubmit="true"
								valueChangeListener="#{encuesta.onSelectCumpEsp}"
								immediate="true" value="#{encuesta.selectedCumpEsp}">
								<f:selectItems value="#{LOVs.siNo}" />
							</ice:selectOneMenu>
							<ice:outputText
								value="#{lbl['labels.encuesta.cumple_esp.aclara']}"></ice:outputText>
							<ice:panelGrid>
								<ice:outputText rendered="true" binding="#{encuesta.lblOutput2}" />
								<ice:inputTextarea value="#{encuesta.aclaracionCumpEsp}"
									cols="40" rows="4" binding="#{encuesta.txtAclCumpEsp}"
									styleClass="ingresos"></ice:inputTextarea>
							</ice:panelGrid>
							<ice:outputText value="#{lbl['labels.encuesta.cumple_prog_est']}"></ice:outputText>
							<ice:selectOneMenu styleClass="ingresos" partialSubmit="true"
								valueChangeListener="#{encuesta.onSelectCumpProgEst}"
								immediate="true" value="#{encuesta.selectedCumpProgEst}">
								<f:selectItems value="#{LOVs.siNo}" />
							</ice:selectOneMenu>
							<ice:outputText
								value="#{lbl['labels.encuesta.cumple_prog_est_aclara']}" />
							<ice:panelGrid>
								<ice:outputText rendered="true" binding="#{encuesta.lblOutput3}" />
								<ice:inputTextarea value="#{encuesta.aclaracionCumpProgEst}"
									cols="40" rows="4" binding="#{encuesta.txtAclCumpProgEst}"
									styleClass="ingresos" />
							</ice:panelGrid>
							<ice:outputText value="#{lbl['labels.encuesta.atencion']}" />
							<ice:selectOneMenu style="width: 192px" styleClass="ingresos"
								partialSubmit="true" immediate="true"
								value="#{encuesta.selectedAtencion}">
								<f:selectItems value="#{LOVs.atencion}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.encuesta.sugerencias']}" />
							<ice:inputTextarea value="#{encuesta.sugerencias}" cols="40"
								rows="4" styleClass="ingresos" />

						</ice:panelGrid>

						<ice:panelGrid columns="2" border="0"
							style="text-align: left; vertical-align: sub; height: 206px; width: 357px"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">

							<ice:outputText value="#{lbl['labels.encuesta.nombre_ref']}"></ice:outputText>
							<ice:inputText value="#{encuesta.nombreRef}" partialSubmit="true"
								immediate="true" binding="#{encuesta.txtNombre}"
								styleClass="ingresos"></ice:inputText>
							<ice:outputText value="#{lbl['labels.encuesta.apellido_ref']}"></ice:outputText>
							<ice:inputText value="#{encuesta.apellidoRef}"
								partialSubmit="true" immediate="true"
								binding="#{encuesta.txtApellido}" styleClass="ingresos"></ice:inputText>
							<ice:outputText value="#{lbl['labels.encuesta.direccion_ref']}"></ice:outputText>
							<ice:inputText value="#{encuesta.direccionRef}"
								partialSubmit="true" immediate="true"
								binding="#{encuesta.txtDireccion}" styleClass="ingresos"></ice:inputText>
							<ice:outputText value="#{lbl['labels.encuesta.telefono_ref']}"></ice:outputText>
							<ice:inputText value="#{encuesta.telefonoRef}"
								partialSubmit="true" immediate="true"
								binding="#{encuesta.txtTelefono}" styleClass="ingresos"></ice:inputText>
							<ice:outputText value="#{lbl['labels.encuesta.email_ref']}"></ice:outputText>
							<ice:inputText value="#{encuesta.emailRef}" styleClass="ingresos"
								partialSubmit="true" immediate="true"
								binding="#{encuesta.txtEmail}"></ice:inputText>
							<ice:outputText value="#{lbl['labels.encuesta.act_interes']}"></ice:outputText>
							<ice:inputTextarea value="#{encuesta.actividadesInteres}"
								cols="40" rows="4" partialSubmit="true" immediate="true"
								binding="#{encuesta.txtActividades}" styleClass="ingresos" />

						</ice:panelGrid>

					</ice:panelGrid>

					<ice:panelGrid columns="3">
						<ice:commandButton value="#{lbl['labels.encuesta.guardar']}"
							actionListener="#{encuesta.action_guardarEncuesta}" />
						<ice:outputText />
						<ice:commandButton value="#{lbl['labels.encuesta.cancelar']}"
							actionListener="#{encuesta.action_limpiar}" />
					</ice:panelGrid>
					<br />
					<br />
					<ice:panelGrid>
						<ice:messages id="msg" />
					</ice:panelGrid>
					<ice:panelGrid width="100%">
						<center>
							<ice:outputConnectionStatus activeLabel="Procesando..."
								style="font-size: 13px;" />
						</center>
					</ice:panelGrid>

					<ice:panelGrid styleClass="panelFooter" style="width: 1250px">
						<ice:outputText value="#{lbl['labels.copyright']}"
							styleClass="textoBlanco" />
					</ice:panelGrid>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>

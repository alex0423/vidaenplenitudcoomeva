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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.creacionActividades.titulo']}" />
				</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
			</head>
			<body>
				<script type="text/javascript" src="js/Funciones.js" />
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />
				<br />
				<ice:form partialSubmit="true">
					<ice:panelGrid styleClass="icePnlGrdPPAL">
						<ice:panelGrid styleClass="panelCabecera1">
							<f:facet name="header">
								<ice:outputText value="#{lbl['labels.registroActividades']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>
						<ice:panelGrid columns="2"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">
							<ice:outputText value="#{lbl['labels.codigoActividad']}" />
							<ice:panelGrid columns="2">
								<ice:inputText id="codActividad"
									value="#{creacionActividades.codigo}" size="10"
									actionListener="#{creacionActividades.action_verificarCodigo}"
									styleClass="ingresos" required="true"
									binding="#{creacionActividades.txtCodigo}">
								</ice:inputText>
								<ice:message id="errorCodActividad" for="codActividad"
									style="color: Red" />
							</ice:panelGrid>
							<ice:outputText value="#{lbl['labels.nombreActividad']}" />
							<ice:panelGrid columns="2">
								<ice:inputText id="txtActividad" size="30"
									value="#{creacionActividades.actividad}" styleClass="ingresos"
									maxlength="50" binding="#{creacionActividades.txtActividad}">
								</ice:inputText>
								<ice:message id="errorTxtActividad" for="txtActividad"
									style="color: Red" />
							</ice:panelGrid>
							<ice:outputText value="#{lbl['labels.estado']}" />
							<ice:selectOneMenu value="#{creacionActividades.selectedEstado}"
								styleClass="ingresos">
								<f:selectItems value="#{creacionActividades.tipoEstados}" />
							</ice:selectOneMenu>
						</ice:panelGrid>
						<ice:panelGrid styleClass="panelPrincipalButton">
							<ice:panelGrid columns="2"
								styleClass="panelContenedorButtonWidth">
								<ice:commandButton value="#{lbl['labels.registrar']}"
									actionListener="#{creacionActividades.action_crearActividad}" />
								<ice:commandButton value="#{lbl['labels.btn.cancelar']}" />
							</ice:panelGrid>
						</ice:panelGrid>
					</ice:panelGrid>
					<br />
					<br />
					<ice:panelGrid styleClass="panelFooter">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.copyright']}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>
					<ice:panelPopup draggable="false" modal="true"
						visible="#{creacionActividades.modalRendered}"
						autoCentre="#{creacionActividades.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{creacionActividades.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{creacionActividades.message}" />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{creacionActividades.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>

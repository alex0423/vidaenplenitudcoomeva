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
				<title>Formulario de Inscripcion</title>
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

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="./Cabecera.jsp" />
				</ice:panelGrid>
				<br />

				<ice:form>
					<ice:panelGroup>
						<ice:panelGrid styleClass="panelCabecera1">
							<ice:outputText value="#{lbl['labels.regusuario.titulo']}"
								styleClass="textoBlanco" />
						</ice:panelGrid>
						<ice:panelGrid columns="2"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
							<ice:outputText value="#{lbl['labels.regusuario.usuario']}"></ice:outputText>
							<ice:inputText binding="#{registrarUsuario.txtUsuario}"
								partialSubmit="true" immediate="true"
								value="#{registrarUsuario.usuario}"></ice:inputText>
							<ice:outputText value="#{lbl['labels.regusuario.regional']}"></ice:outputText>
							<ice:selectOneMenu value="#{registrarUsuario.selectedRegional}"
								styleClass="ingresos">
								<f:selectItems value="#{LOVs.regionalesUsuario}" />
							</ice:selectOneMenu>
							<ice:outputText />
							<ice:commandButton value="#{lbl['labels.regusuario.boton']}"
								actionListener="#{registrarUsuario.action_guardarRegistro}"></ice:commandButton>
						</ice:panelGrid>

					</ice:panelGroup>
					<br />
					<ice:panelGrid columns="1">
						<ice:messages id="msg"
							style="width: 595px; font-size: 14px; font-weight: bold;" />
					</ice:panelGrid>
					<br />
					<br />

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
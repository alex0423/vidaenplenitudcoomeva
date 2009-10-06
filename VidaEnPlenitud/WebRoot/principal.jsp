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
				<title>Vida En Plenitud</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
				<link rel="stylesheet" type="text/css" href="./css/coomeva.css" />
			</head>
			<body>
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />
				<ice:form>
					<center>
						<ice:panelGrid>
							<ice:outputText value="#{principal.inicio}"></ice:outputText>
							<h2>
								<ice:outputText
									value="#{lbl['lblinstrucciones']}"></ice:outputText>
							</h2>
						</ice:panelGrid>
						<ice:panelGrid style="height: 100px;">
							<ice:outputText></ice:outputText>
						</ice:panelGrid>
						<ice:panelGrid>
							<div align="center" class="textoGral">
								<ice:outputText value="#{etiqueta.lblDerechos}" />
								<br />
								<img src="css/imagenes/logotipoVidaenPlenitud.jpg" />
							</div>
						</ice:panelGrid>
					</center>
					<br />
					<ice:panelGrid styleClass="panelFooter">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.copyright']}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>					
				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>
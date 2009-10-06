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
				<title>ICEfaces, Ajax for Java EE</title>
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
				<ice:form partialSubmit="true">
					<ice:panelGrid>
						<ice:inputText value="#{hacerValoracion.estatura}"
							binding="#{hacerValoracion.txtEstatura}">
						</ice:inputText>
						<!--<ice:selectOneMenu value="#{registrarProfesor.selectedDepto}">
							<f:selectItems value="#{registrarProfesor.listaDeptos}" />
						</ice:selectOneMenu>  -->
						<ice:inputText>
						</ice:inputText>
					</ice:panelGrid>
					<ice:messages />
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>

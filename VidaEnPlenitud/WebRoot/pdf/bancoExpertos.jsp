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
				<link rel="stylesheet" type="text/css" href="./css/coomeva.css" />					
				<link rel="stylesheet" type="text/css" href="./css/print.css" />
			</head>
			<body>

				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
				<ice:form partialSubmit="true">
					<ice:panelGrid>
						<ice:outputLabel value="CONSULTAR BANCO DE EXPERTOS"></ice:outputLabel>
					</ice:panelGrid>
					<ice:panelGrid columns="2">
						<ice:outputText value="Regional:" />
						<ice:outputText value="#{listarBEPdf.regionalNombre}" />
					</ice:panelGrid>
					<ice:panelGrid columns="1" border="1">
						<ice:dataTable id="consultoriaList"
							value="#{listarBEPdf.lstConsultorias}" var="item">

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{listarBEPdf.nombreColumnName}" />
								</f:facet>
								<ice:outputText value="#{item.vepConsultoria.nombre}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{listarBEPdf.descripcionColumnName}" />
								</f:facet>
								<ice:outputText value="#{item.vepConsultoria.descripcion}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{listarBEPdf.estadoColumnName}" />
								</f:facet>
								<ice:outputText value="#{item.vepConsultoria.estado}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{listarBEPdf.objetivoColumnName}" />
								</f:facet>
								<ice:outputText value="#{item.objetivo}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText
										value="#{listarBEPdf.numBeneficiadosColumnName}" />
								</f:facet>
								<ice:outputText value="#{item.numBeneficiados}" />
							</ice:column>

							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{listarBEPdf.fechaInicioColumnName}" />
								</f:facet>
								<ice:outputText value="#{item.fechaIni}" />
							</ice:column>

						</ice:dataTable>

					</ice:panelGrid>
					<ice:messages />
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>

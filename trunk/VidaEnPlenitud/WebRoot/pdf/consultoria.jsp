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
			</head>
			<body>
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
				<ice:form partialSubmit="true">
					<ice:panelGrid border="1" width="700" id="id_4" rendered="true">
						<ice:panelGrid columns="2">
							<ice:outputText value="#{lbl['labels.codigoServicio']}" />
							<ice:outputText value="#{itemConsultoria.id}" />
							<ice:outputText value="#{lbl['labels.nombreServicio']}" />
							<ice:outputText value="#{itemConsultoria.nombreConsultoria}" />
							<ice:outputText value="#{lbl['labels.descripcionServicio']}" />
							<ice:outputText value="#{itemConsultoria.descripcionConsultoria}" />
							<ice:outputText value="Nro. Beneficiados" />
							<ice:outputText
								value="#{itemConsultoria.beneficiadosConsultoria}" />
						</ice:panelGrid>
						<ice:panelGrid columns="4">
							<ice:outputText value="#{lbl['labels.codigoCiudad']}" />
							<ice:outputText value="#{itemConsultoria.regional}" />
							<ice:outputText value="#{lbl['labels.estado']}" />
							<ice:outputText value="#{itemConsultoria.estado}" />
							<ice:outputText value="Fecha Inicio" />
							<ice:outputText value="#{itemConsultoria.fechaInicioConsultoria}" />
							<ice:outputText value="Fecha Terminacion" />
							<ice:outputText
								value="#{itemConsultoria.fechaTerminacionConsultoria}" />
						</ice:panelGrid>
					</ice:panelGrid>
					<ice:panelGrid>
						<ice:outputText></ice:outputText>
						<ice:outputText></ice:outputText>
					</ice:panelGrid>
					<ice:panelGrid width="100%" columns="2" border="1">
						<ice:outputText value="CONSULTORES"></ice:outputText>
						<ice:outputText value="BENEFICIARIOS"></ice:outputText>
						<ice:dataTable id="dtConsultores" rows="5"
							value="#{itemConsultoria.lstConsultores}" var="item">
							<ice:column id="nombreColumnConsultor">
								<f:facet name="header">
									<ice:outputText value="Nombre"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{item.nombre}"></ice:outputLabel>
							</ice:column>
							<ice:column id="descripcionColumnConsultor">
								<f:facet name="header">
									<ice:outputText value="Documento"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{item.identificacion}"></ice:outputLabel>
							</ice:column>
							<ice:column id="estadoColumnConsultor">
								<f:facet name="header">
									<ice:outputText value="ID Asociado"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{item.idAsociado}"></ice:outputLabel>
							</ice:column>
						</ice:dataTable>

						<ice:dataTable id="dtBeneficiarios" rows="5"
							value="#{itemConsultoria.lstBeneficiarios}" var="itemBenef">
							<ice:column id="nombreColumnBenef">
								<f:facet name="header">
									<ice:outputText value="Nombre"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{itemBenef.nombre}"></ice:outputLabel>
							</ice:column>
							<ice:column id="descripcionColumnBenef">
								<f:facet name="header">
									<ice:outputText value="Documento"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{itemBenef.identificacion}"></ice:outputLabel>
							</ice:column>
							<ice:column id="estadoColumnBenef">
								<f:facet name="header">
									<ice:outputText value="ID Asociado"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{itemBenef.idAsociado}"></ice:outputLabel>
							</ice:column>
						</ice:dataTable>
					</ice:panelGrid>

					<ice:panelGrid width="100%" border="1">
						<ice:outputText value="INFORMES DE SEGUIMIENTO"></ice:outputText>
						<ice:dataTable id="dtSeguimiento" rows="5"
							value="#{itemConsultoria.lstInformes}" var="itemSeg">
							<ice:column id="fechaColumnSeg">
								<f:facet name="header">
									<ice:outputText value="Fecha"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{itemSeg.fecha}"></ice:outputLabel>
							</ice:column>
							<ice:column id="informeColumnSeg">
								<f:facet name="header">
									<ice:outputText value="Informe"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{itemSeg.contenido}"></ice:outputLabel>
							</ice:column>
							<ice:column id="archivoColumnSeg">
								<f:facet name="header">
									<ice:outputText value="Archivo"></ice:outputText>
								</f:facet>
								<ice:outputLabel value="#{itemSeg.archivo}"></ice:outputLabel>
							</ice:column>
						</ice:dataTable>
					</ice:panelGrid>

					<ice:messages />
				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>
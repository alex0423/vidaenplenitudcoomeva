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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.inscripcionActividades.titulo']}" />
				</title>
				<link rel="stylesheet" type="text/css"
					href="./xmlhttp/css/xp/xp.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />

			</head>
			<body>
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
								<ice:outputText
									value="#{lbl['labels.inscripcionActividades.header']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>
						<ice:panelGrid columns="4"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth"
							binding="#{inscripcionActividades.panel1}"
							columnClasses="icePnlGrdColLbl1 icePnlGrdColTxt1">
							<ice:outputText value="#{lbl['labels.tipoDocumento']}" />
							<ice:selectOneMenu
								value="#{inscripcionActividades.selectedTipoDocumento}"
								styleClass="ingresos">
								<f:selectItems
									value="#{inscripcionActividades.tipoIdentificacion}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.numero']}" />
							<ice:panelGrid columns="2">
								<ice:inputText id="txtIdentificacion"
									value="#{inscripcionActividades.identificacion}"
									styleClass="ingresos" maxlength="20"
									binding="#{inscripcionActividades.txtCedula}">
								</ice:inputText>
								<ice:commandButton value="..."
									actionListener="#{inscripcionActividades.action_consultarAsociado}" />
								<ice:message id="msgTxtIdentificacion" for="txtIdentificacion"
									style="color: Red" />
							</ice:panelGrid>
						</ice:panelGrid>
						<ice:panelGrid columns="4"
							rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1"
							styleClass="panelCabeceraWidth" rendered="false"
							binding="#{inscripcionActividades.panel2}"
							columnClasses="icePnlGrdColLbl1 icePnlGrdColTxt1">
							<ice:outputText value="#{lbl['labels.nombreUno']}" />
							<ice:inputText value="#{inscripcionActividades.nombre1}"
								style="width: 240px" styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.nombreDos']}" />
							<ice:inputText value="#{inscripcionActividades.nombre2}"
								style="width: 240px" styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.apellidoUno']}" />
							<ice:inputText value="#{inscripcionActividades.apellido1}"
								style="width: 240px" styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.apellidoDos']}" />
							<ice:inputText value="#{inscripcionActividades.apellido2}"
								style="width: 240px" styleClass="ingresos" readonly="true" />
						</ice:panelGrid>
						<ice:panelGrid columns="4"
							rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1"
							styleClass="panelCabeceraWidth" rendered="false"
							binding="#{inscripcionActividades.panel3}"
							columnClasses="icePnlGrdColLbl1 icePnlGrdColTxt1">
							<ice:outputText value="#{lbl['labels.fechaNacimiento']}" />
							<ice:inputText value="#{inscripcionActividades.fechaNacimiento}"
								style="width: 240px" styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.generoA']}" />
							<ice:inputText value="#{inscripcionActividades.genero}"
								style="width: 240px" styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.estadoCivil']}" />
							<ice:inputText value="#{inscripcionActividades.estadoCivil}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.ocupacionI']}" />
							<ice:inputText value="#{inscripcionActividades.ocupacion}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.tituloProfesional']}" />
							<ice:inputText
								value="#{inscripcionActividades.tituloProfesional}"
								styleClass="ingresos" readonly="true" />
						</ice:panelGrid>
						<ice:panelGrid columns="6"
							rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1"
							styleClass="panelCabeceraWidth" rendered="false"
							binding="#{inscripcionActividades.panel4}"
							columnClasses="icePnlGrdColLbl1 icePnlGrdColTxt1">
							<ice:outputText value="#{lbl['labels.codigoAsociado']}" />
							<ice:inputText value="#{inscripcionActividades.codigoAsociado}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.asociadoCooperativa']}" />
							<ice:inputText
								value="#{inscripcionActividades.asociadoCooperativa}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.estadoAsociado']}" />
							<ice:inputText value="#{inscripcionActividades.estadoAsociado}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.fechaEstado']}" />
							<ice:inputText value="#{inscripcionActividades.fechaEstado}"
								styleClass="ingresos" readonly="true">
								<f:convertDateTime pattern="yyyy-MM-dd" />
							</ice:inputText>
							<ice:outputText value="#{lbl['labels.cuotasVencidas']}" />
							<ice:inputText value="#{inscripcionActividades.cuotasVencidas}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.fechaIngresoA']}" />
							<ice:inputText
								value="#{inscripcionActividades.fechaIngresoAsociado}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.codigoCorte']}" />
							<ice:inputText value="#{inscripcionActividades.codigoCorte}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.fechaIngresoVEP']}" />
							<ice:inputText value="#{inscripcionActividades.fechaIngresoVEP}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.tipoInscrito']}" />
							<ice:inputText value="#{inscripcionActividades.tipoInscrito}"
								styleClass="ingresos" readonly="true" />
						</ice:panelGrid>
						<ice:panelGrid rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth" columns="4"
							binding="#{inscripcionActividades.panel5}"
							columnClasses="icePnlGrdColLbl1 icePnlGrdColTxt1">
							<ice:outputText value="#{lbl['labels.codigoGrupo']}" />
							<ice:panelGrid columns="2">
								<ice:inputText id="txtCodigoGrupo"
									value="#{inscripcionActividades.codigoGrupo}"
									style="width: 232px" styleClass="ingresos" />
								<ice:commandButton value="..."
									actionListener="#{inscripcionActividades.action_consultarGrupo}" />
							</ice:panelGrid>
							<ice:message id="msgTxtCodigoGrupo" for="txtCodigoGrupo"
								style="color: Red" />
							<ice:outputText />
							<ice:outputText value="#{lbl['labels.codigoActividad']}" />
							<ice:inputText style="width: 232px"
								value="#{inscripcionActividades.codigoActividad}"
								styleClass="ingresos" readonly="true" />
							<ice:outputText value="#{lbl['labels.nombre']}" />
							<ice:inputText value="#{inscripcionActividades.nombreActividad}"
								styleClass="ingresos" style="width: 268px" readonly="true" />
							<ice:outputText value="#{lbl['labels.estado']}" />
							<ice:inputText value="#{inscripcionActividades.estadoActividad}"
								styleClass="ingresos" readonly="true" />
							<ice:messages />
						</ice:panelGrid>
						<ice:panelGrid styleClass="panelPrincipalButton">
							<ice:panelGrid columns="2">
								<!-- <ice:dataTable var="actividades"
									value="#{inscripcionActividades.listParametroActividad}"
									id="table" rows="0" scrollable="true" scrollHeight="150px"
									styleClass="dataPaginatorDataTable" cellpadding="0"
									columnWidths="200px">
									<f:facet name="header">
										<ice:outputText value="#{lbl['labels.listaActividades']}" />
									</f:facet>
									<ice:column>
										<f:facet name="header">
											<ice:outputText value="#{lbl['labels.table.actividadesId']}" />
										</f:facet>
										<ice:outputText value="#{actividades.idActividadpar}" />
									</ice:column>
									<ice:column>
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.table.actividadesNombre']}" />
										</f:facet>
										<ice:outputText value="#{actividades.nombre}" />
									</ice:column>
									<ice:column>
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.table.actividadesEstado']}" />
										</f:facet>
										<ice:outputText value="#{actividades.estadopar}" />
									</ice:column>
									<ice:column>
										<f:facet name="header">
											<ice:outputText
												value="#{lbl['labels.table.actividadesBorrar']}" />
										</f:facet>
										<ice:commandLink
											value="#{lbl['labels.table.actividadesBorrar']}"
											actionListener="#{inscripcionActividades.removeActividad}">
											<f:param name="nombreActividad" value="#{actividades.nombre}" />
										</ice:commandLink>
									</ice:column>
								</ice:dataTable> -->

								<ice:commandButton value="#{lbl['labels.btn.guardar']}"
									actionListener="#{inscripcionActividades.action_guardarInscripcion}" />
								<ice:commandButton value="#{lbl['labels.btn.cancelar']}" />

							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputConnectionStatus />
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
						visible="#{inscripcionActividades.modalRendered}"
						autoCentre="#{inscripcionActividades.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{inscripcionActividades.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{inscripcionActividades.message}" />
								<br />
								<center>
									<ice:commandButton value="#{lbl['labels.message.button']}"
										actionListener="#{inscripcionActividades.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>

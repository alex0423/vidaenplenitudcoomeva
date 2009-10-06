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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.registrarProfesor.titulo']}" />
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
					<ice:panelGroup>
						<ice:panelGrid styleClass="panelCabecera1">
							<f:facet name="header">
								<ice:outputText
									value="#{lbl['labels.registrarProfesor.header']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>

						<ice:panelGrid columns="5"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">
							<ice:outputText value="#{lbl['labels.tipoDocumento']}" />
							<ice:selectOneMenu id="cmbTipoDocumento" partialSubmit="true"
								value="#{registrarProfesor.tipoid}" styleClass="ingresos">
								<f:selectItems value="#{LOVs.tiposIdentificacion}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.numero']}" />
							<ice:inputText binding="#{registrarProfesor.txtCedula}"
								value="#{registrarProfesor.cedula}" partialSubmit="true"
								styleClass="ingresos" maxlength="20">
							</ice:inputText>
							<ice:commandButton value="..."
								actionListener="#{registrarProfesor.action_consultarAsociado}"></ice:commandButton>
						</ice:panelGrid>
					</ice:panelGroup>
					<br />
					<ice:panelGrid>
						<ice:messages id="msg" />
					</ice:panelGrid>
					<br />
					<ice:panelGroup>

						<ice:panelGrid columns="4"
							rowClasses="icePnlGrdRowVEP2 icePnlGrdRowVEP1"
							styleClass="panelCabeceraWidth">
							<ice:outputText value="Primer Nombre" />
							<ice:inputText value="#{registrarProfesor.nombre1}"
								binding="#{registrarProfesor.txtNombre1}" partialSubmit="true"
								style="width: 293px" styleClass="ingresos" />
							<ice:outputText value="Segundo Nombre" />
							<ice:inputText value="#{registrarProfesor.nombre2}"
								binding="#{registrarProfesor.txtNombre2}" partialSubmit="true"
								style="width: 293px" styleClass="ingresos" />
							<ice:outputText value="Primer Apellido" />
							<ice:inputText value="#{registrarProfesor.apellido1}"
								binding="#{registrarProfesor.txtApellido1}" partialSubmit="true"
								style="width: 293px" styleClass="ingresos" />
							<ice:outputText value="Segundo Apellido" />
							<ice:inputText value="#{registrarProfesor.apellido2}"
								binding="#{registrarProfesor.txtApellido2}" partialSubmit="true"
								style="width: 293px" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.fechaNacimiento']}" />
							<ice:selectInputDate renderAsPopup="true" styleClass="ingresos"
								binding="#{registrarProfesor.txtFechaNacimiento}"
								popupDateFormat="yyyy/MM/dd"
								value="#{registrarProfesor.fechaNace}">
							</ice:selectInputDate>
							<ice:outputText value="#{lbl['labels.generoA']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{registrarProfesor.selectedGenero}">
								<f:selectItems value="#{LOVs.genero}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.estadoCivil']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{registrarProfesor.estadoCivil}">
								<f:selectItems value="#{LOVs.estadoCivil}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.ocupacionI']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{registrarProfesor.ocupacion}">
								<f:selectItems value="#{LOVs.ocupacion}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.tituloProfesional']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{registrarProfesor.tituloProfesional}">
								<f:selectItems value="#{LOVs.tituloProfesional}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.estado']}" />
							<ice:selectOneMenu id="cmbEstado"
								value="#{registrarProfesor.estadoRegistro}"
								styleClass="ingresos">
								<f:selectItems value="#{LOVs.estado}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.dirres']}" />
							<ice:inputText value="#{registrarProfesor.direccionResidencia}"
								partialSubmit="true"
								binding="#{registrarProfesor.txtDirResidencia}"
								style="width: 252px" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telred']}" />
							<ice:inputText value="#{registrarProfesor.telefonoResidencia}"
								partialSubmit="true"
								binding="#{registrarProfesor.txtTelefonoResidencia}"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ciudadres']}" />
							<div>
								<ice:inputText value="#{registrarProfesor.ciuRes}"
									styleClass="ingresos" readonly="true" />
								<ice:commandButton binding="#{registrarProfesor.btnCiuRes}"
									partialSubmit="true" value="..."
									action="#{registrarProfesor.popupResidencia}" />
							</div>

							<ice:outputText />
							<ice:outputText />
							<ice:outputText value="#{lbl['labels.dircom']}" />
							<ice:inputText value="#{registrarProfesor.dirComercial}"
								binding="#{registrarProfesor.txtDirComercial}"
								partialSubmit="true" style="width: 252px" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telcom']}" />
							<ice:inputText value="#{registrarProfesor.telefonoComercial}"
								binding="#{registrarProfesor.txtTelefonoComercial}"
								partialSubmit="true" style="width: 252px" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ciudadcom']}" />
							<div>
								<ice:inputText value="#{registrarProfesor.ciuCom}"
									styleClass="ingresos" readonly="true" />
								<ice:commandButton binding="#{registrarProfesor.btnCiuCom}"
									partialSubmit="true" value="..."
									action="#{registrarProfesor.popupComercial}" />
							</div>
							<ice:outputText />
							<ice:outputText />
							<ice:outputText value="#{lbl['labels.telcel']}" />
							<ice:inputText value="#{registrarProfesor.telefonoCelular}"
								style="width: 252px" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.direccionElectronica']}" />
							<ice:inputText value="#{registrarProfesor.correoElectrinico}"
								style="width: 252px" styleClass="ingresos" />

						</ice:panelGrid>
						<ice:panelGrid rowClasses="icePnlGrdRowVEP1"
							style="width: 960px;">
							<ice:inputFile id="inputFileName"
								progressListener="#{registrarProfesor.fileUploadProgress}"
								actionListener="#{registrarProfesor.uploadFile}"
								label="#{lbl['labels.etiqueta.subir']}" submitOnUpload="postUpload"/>
							<ice:outputProgress value="#{registrarProfesor.fileProgress}"
								styleClass="uploadProgressBar" />
						</ice:panelGrid>
						<ice:panelGrid columns="3"
							style="text-align: center; width: 100px">
							<ice:commandButton value="#{lbl['labels.btn.guardar']}"
								actionListener="#{registrarProfesor.action_registrarProfesor}" />
							<ice:outputText />
							<ice:commandButton value="#{lbl['labels.btn.cancelar']}"
								actionListener="#{registrarProfesor.action_limpiar}" />

						</ice:panelGrid>

					</ice:panelGroup>
					<br />
					<br />
					<ice:panelGrid width="100%">
						<center>
							<ice:outputConnectionStatus activeLabel="Procesando..."
								style="font-size: 13px;" />
						</center>
					</ice:panelGrid>
					<br />
					<ice:panelGrid styleClass="panelFooter">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.copyright']}"
								styleClass="textoBlanco" />
						</f:facet>
					</ice:panelGrid>
					<ice:panelPopup id="visorMensajes" draggable="false" modal="true"
						visible="#{registrarProfesor.modalRendered}"
						autoCentre="#{registrarProfesor.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{registrarProfesor.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{registrarProfesor.message}" />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{registrarProfesor.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>

					<ice:panelPopup id="selectorCiudades"
						style="width: 388px; height: 172px; text-align: left"
						draggable="true" rendered="#{registrarProfesor.visible}"
						visible="#{registrarProfesor.visible}" modal="true"
						autoCentre="true">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.panelciudades.titulo']}" />
						</f:facet>
						<f:facet name="body">
							<ice:panelGrid id="ciudadSelector1"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" columns="2">
								<ice:outputText value="#{lbl['labels.panelciudades.pais']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{registrarProfesor.pais}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{registrarProfesor.onSelectPais}">
									<f:selectItems value="#{LOVs.paises}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.depto']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{registrarProfesor.deptos}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{registrarProfesor.onSelectDepartamento}">
									<f:selectItems value="#{registrarProfesor.lista_deptos}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.ciudad']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{registrarProfesor.ciu}" style="width: 212px"
									partialSubmit="true"
									valueChangeListener="#{registrarProfesor.onSelectCiudad}">
									<f:selectItems value="#{registrarProfesor.lista_ciu}" />
								</ice:selectOneMenu>

								<ice:commandButton action="#{registrarProfesor.closePopup}"
									value="#{lbl['labels.panelciudades.boton2']}"
									style="width: 93px" />
								<center>
									<ice:outputConnectionStatus activeLabel="Procesando..."
										style="font-size: 13px;" />
								</center>

							</ice:panelGrid>
						</f:facet>
					</ice:panelPopup>

				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>
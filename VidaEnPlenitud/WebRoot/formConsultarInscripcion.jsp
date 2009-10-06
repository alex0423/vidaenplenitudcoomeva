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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.consultarInscripcion.titulo']}" />
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

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />

				<ice:form partialSubmit="true">

					<ice:panelGrid columns="1" styleClass="panelCabecera1">
						<ice:outputText value="#{lbl['labels.consins']}"
							styleClass="textoBlanco" />
					</ice:panelGrid>
					<ice:panelGrid columns="4" border="0"
						rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
						styleClass="panelCabeceraWidth" width="100%">

						<ice:panelGrid border="0" columns="4" id="panel1"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth" visible="true" width="100%">
							<ice:outputText value="#{lbl['labels.tipoid']}" />
							<ice:selectOneMenu value="#{consultaInscripcion.STipoid}"
								styleClass="ingresos">
								<f:selectItems value="#{LOVs.tiposIdentificacion}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.tipoaso']}" />
							<ice:selectOneMenu value="#{consultaInscripcion.STipoAsociado}"
								styleClass="ingresos">
								<f:selectItems value="#{LOVs.tiposAsociado}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.numeroid']}" />
							<ice:inputText value="#{consultaInscripcion.SCedula}"
								partialSubmit="true" immediate="true"
								binding="#{consultaInscripcion.txtCedula}" styleClass="ingresos"></ice:inputText>
							<ice:outputText value="#{lbl['labels.genero']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{consultaInscripcion.SGenero}">
								<f:selectItems value="#{LOVs.genero}" />
							</ice:selectOneMenu>

							<ice:outputText value="#{lbl['labels.estcivil']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{consultaInscripcion.SEstadoCivil}">
								<f:selectItems value="#{LOVs.estadoCivil}" />
							</ice:selectOneMenu>

							<ice:outputText value="#{lbl['labels.tiposangre']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{consultaInscripcion.STipoSangre}">
								<f:selectItems value="#{LOVs.tipoSangre}" />
							</ice:selectOneMenu>

							<ice:outputText value="#{lbl['labels.fechanace']}" />
							<ice:selectInputDate styleClass="ingresos" renderAsPopup="true"
								popupDateFormat="yyyy/MM/dd"
								value="#{consultaInscripcion.SFechaNace}">
							</ice:selectInputDate>

							<ice:outputText value="#{lbl['labels.fechaingresoaso']}" />
							<ice:selectInputDate renderAsPopup="true"
								popupDateFormat="yyyy/MM/dd"
								value="#{consultaInscripcion.SFechaIngresoAsociado}"
								styleClass="ingresos" />

							<ice:outputText value="#{lbl['labels.titulopro']}" />
							<ice:selectOneMenu styleClass="ingresos"
								value="#{consultaInscripcion.STituloProfesional}">
								<f:selectItems value="#{LOVs.tituloProfesional}" />
							</ice:selectOneMenu>
							<ice:outputText />
							<ice:outputText />
							<ice:outputText value="#{lbl['labels.servimed']}" />
							<ice:selectManyCheckbox id="sServMedico"
								value="#{consultaInscripcion.filteredServMedico}"
								layout="pageDirection">
								<f:selectItems value="#{LOVs.servicioMedico}" />
							</ice:selectManyCheckbox>

							<ice:outputText value="#{lbl['labels.serviact']}" />
							<ice:selectManyCheckbox id="sPams" layout="pageDirection"
								value="#{consultaInscripcion.filteredPAMS}">
								<f:selectItems value="#{LOVs.PAM}" />
							</ice:selectManyCheckbox>
							<ice:outputText value="#{lbl['labels.hobbies']}" />
							<ice:selectManyCheckbox id="sHobbies"
								value="#{consultaInscripcion.filteredHobbies}"
								layout="pageDirection">
								<f:selectItems value="#{LOVs.hobbies}" />
							</ice:selectManyCheckbox>
							<ice:outputText value="#{lbl['labels.patalogias']}" />
							<ice:selectManyCheckbox id="sPatologias"
								value="#{consultaInscripcion.filteredPatologias}"
								layout="pageDirection">
								<f:selectItems value="#{LOVs.patologias}" />
							</ice:selectManyCheckbox>
						</ice:panelGrid>
					</ice:panelGrid>
					<ice:panelGrid border="0">
						<ice:commandButton
							actionListener="#{consultaInscripcion.action_realizarConsulta}"
							value="#{lbl['labels.consins']}"></ice:commandButton>
					</ice:panelGrid>
					<ice:panelGrid columns="1">
						<ice:outputText value="#{consultaInscripcion.message}"></ice:outputText>
						<ice:messages id="msg" />
					</ice:panelGrid>

					<ice:panelGroup>
						<ice:dataTable value="#{consultaInscripcion.lista_aso}" rows="5"
							var="item" id="dtRegistros"
							binding="#{consultaInscripcion.dataTable}"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultacumple.tipoid']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.tipodocumentoAsociado}"></ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText
										value="#{lbl['labels.consultacumple.numeroid']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.documento}" />
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultacumple.nombre']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.nombre1Asociado}"></ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.cumple.fechanace']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.fechaNace}">
									<f:convertDateTime pattern="yyyy/MM/dd" />
								</ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.genero']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.genero}" />
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.cumple.fechaingvep']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.fechaIngresovp}">
									<f:convertDateTime pattern="yyyy/MM/dd" />
								</ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.estcivil']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.estcivil}" />
							</ice:column>
							<ice:column id="seleccionColumnAs">
								<f:facet name="header">
									<ice:outputText value="Seleccione"></ice:outputText>
								</f:facet>
								<ice:commandButton value="Seleccionar"
									actionListener="#{consultaInscripcion.rowSelection}"></ice:commandButton>
							</ice:column>

						</ice:dataTable>
						<ice:dataPaginator id="dataScroll_11" for="dtRegistros">
							<f:facet name="first">
								<ice:graphicImage style="border:none;"
									url="./xmlhttp/css/xp/css-images/arrow-first.gif"></ice:graphicImage>
							</f:facet>
							<f:facet name="last">
								<ice:graphicImage style="border:none;"
									url="./xmlhttp/css/xp/css-images/arrow-last.gif"></ice:graphicImage>
							</f:facet>
							<f:facet name="previous">
								<ice:graphicImage style="border:none;"
									url="./xmlhttp/css/xp/css-images/arrow-previous.gif"></ice:graphicImage>
							</f:facet>
							<f:facet name="next">
								<ice:graphicImage style="border:none;"
									url="./xmlhttp/css/xp/css-images/arrow-next.gif"></ice:graphicImage>
							</f:facet>
							<f:facet name="fastforward">
								<ice:graphicImage style="border:none;"
									url="./xmlhttp/css/xp/css-images/arrow-ff.gif"></ice:graphicImage>
							</f:facet>
							<f:facet name="fastrewind">
								<ice:graphicImage style="border:none;"
									url="./xmlhttp/css/xp/css-images/arrow-fr.gif"></ice:graphicImage>
							</f:facet>
						</ice:dataPaginator>

						<!-- Display counts about the table and the currently displayed page -->
						<ice:dataPaginator id="dataScroll_21" for="dtRegistros"
							rowsCountVar="rowsCount"
							displayedRowsCountVar="displayedRowsCount"
							firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
							pageCountVar="pageCount" pageIndexVar="pageIndex">
							<ice:outputFormat value="#{lbl['labels.datatable.pages']}"
								styleClass="standard">
								<f:param value="#{rowsCount}" />
								<f:param value="#{displayedRowsCount}" />
								<f:param value="#{firstRowIndex}" />
								<f:param value="#{lastRowIndex}" />
								<f:param value="#{pageIndex}" />
								<f:param value="#{pageCount}" />
							</ice:outputFormat>
						</ice:dataPaginator>
						<ice:panelGrid columns="6">
							<ice:commandButton
								actionListener="#{consultaInscripcion.action_generarExcel}"
								value="#{lbl['labels.btn.generarExcel']}"></ice:commandButton>

							<ice:outputLink value="./servlet/showFileServlet"
								visible="#{consultaInscripcion.visibleExport}"
								rendered="#{consultaInscripcion.visibleExport}">
								<f:param name="url" value="#{consultaInscripcion.exportName}" />
								<ice:outputText value="Descargar EXCEL" />
							</ice:outputLink>
							<ice:outputText />
							<ice:commandButton
								actionListener="#{consultaInscripcion.action_generarHtml}"
								value="#{lbl['labels.btn.generarHtml']}"></ice:commandButton>
							<ice:outputLink value="./servlet/showFileServlet"
								visible="#{consultaInscripcion.visibleExportHtml}"
								rendered="#{consultaInscripcion.visibleExportHtml}">
								<f:param name="url"
									value="#{consultaInscripcion.exportNameHtml}" />
								<ice:outputText value="Descargar HTML" />
							</ice:outputLink>
						</ice:panelGrid>
					</ice:panelGroup>
					<br />
					<br />
					<ice:panelGroup>
						<ice:panelGrid border="0" columns="4" id="panel2"
							visible="#{consultaInscripcion.visible}"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">

							<ice:outputText value="#{lbl['labels.nombre1']}" />
							<ice:inputText value="#{consultaInscripcion.nombre1}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.nombre2']}" />
							<ice:inputText value="#{consultaInscripcion.nombre2}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.apellido1']}" />
							<ice:inputText value="#{consultaInscripcion.apellido1}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.apellido2']}" />
							<ice:inputText value="#{consultaInscripcion.apellido2}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.fechanace']}" />
							<ice:inputText value="#{consultaInscripcion.fechaNace}"
								readonly="true" styleClass="ingresos" >
								<f:convertDateTime pattern="yyyy/MM/dd" />
							</ice:inputText>

							<ice:outputText value="#{lbl['labels.edad']}" />
							<ice:inputText value="#{consultaInscripcion.edad}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.genero']}" />
							<ice:inputText value="#{consultaInscripcion.genero}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.codigoaso']}" />
							<ice:inputText value="#{consultaInscripcion.codigoAsociado}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.estadoaso']}" />
							<ice:inputText value="#{consultaInscripcion.estadoAsociado}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.fechaestado']}" />
							<ice:inputText value="#{consultaInscripcion.fechaEstado}"
								readonly="true" styleClass="ingresos">
								<f:convertDateTime pattern="yyyy/MM/dd" />
							</ice:inputText>
							<ice:outputText value="#{lbl['labels.fechaingresoaso']}" />
							<ice:inputText
								value="#{consultaInscripcion.fechaIngresoAsociado}"
								readonly="true" styleClass="ingresos">
								<f:convertDateTime pattern="yyyy/MM/dd" />
							</ice:inputText>

							<ice:outputText value="#{lbl['labels.codigocorte']}" />
							<ice:inputText value="#{consultaInscripcion.corte}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.fechaingvep']}" />

							<ice:inputText value="#{consultaInscripcion.fechaIngVEP}"
								readonly="true" styleClass="ingresos">
								<f:convertDateTime pattern="yyyy/MM/dd" />
							</ice:inputText>
							<ice:outputText value="#{lbl['labels.dirres']}" />
							<ice:inputText value="#{consultaInscripcion.direccionResidencia}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ciudadres']}" />
							<ice:inputText value="#{consultaInscripcion.ciuRes}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.dircom']}" />
							<ice:inputText value="#{consultaInscripcion.dirComercial}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ciudadcom']}" />
							<ice:inputText value="#{consultaInscripcion.ciuCom}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telred']}" />
							<ice:inputText value="#{consultaInscripcion.telefonoResidencia}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telcom']}" />
							<ice:inputText value="#{consultaInscripcion.telefonoComercial}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telcel']}" />
							<ice:inputText value="#{consultaInscripcion.telefonoCelular}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.correoele']}" />
							<ice:inputText value="#{consultaInscripcion.correoElectrinico}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.titulopro']}" />

							<ice:inputText value="#{consultaInscripcion.tituloProfesional}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ocupacion']}" />
							<ice:inputText value="#{consultaInscripcion.ocupacion}"
								readonly="true" styleClass="ingresos" />

							<ice:outputText value="#{lbl['labels.estcivil']}" />
							<ice:inputText value="#{consultaInscripcion.estadoCivil}"
								readonly="true" styleClass="ingresos" />

							<ice:outputText value="#{lbl['labels.tiposangre']}" />
							<ice:inputText value="#{consultaInscripcion.tipoSangre}"
								readonly="true" styleClass="ingresos" />
						</ice:panelGrid>

						<ice:panelGrid visible="#{consultaInscripcion.visible}"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth" columns="3">
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.servimed']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems
										value="#{consultaInscripcion.registeredServMedico}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.serviact']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems value="#{consultaInscripcion.registeredPAMS}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.sufrepatol']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems
										value="#{consultaInscripcion.registeredPatologias}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.ofrecer']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems
										value="#{consultaInscripcion.registeredServOfrecer}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.conocimientos']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems
										value="#{consultaInscripcion.registeredConocimientos}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.hobbies']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems value="#{consultaInscripcion.registeredHobbies}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
						</ice:panelGrid>
					</ice:panelGroup>

					<ice:panelGroup>
						<ice:panelGrid>
							<center>
								<ice:outputConnectionStatus activeLabel="Procesando..."
									style="font-size: 13px;" />
							</center>
						</ice:panelGrid>

						<ice:panelGrid styleClass="panelFooter" style="width: 1197px">
							<f:facet name="header">
								<ice:outputText value="#{lbl['labels.copyright']}"
									styleClass="textoBlanco"></ice:outputText>
							</f:facet>
						</ice:panelGrid>
					</ice:panelGroup>
				</ice:form>

			</body>
		</html>
	</f:view>
</jsp:root>

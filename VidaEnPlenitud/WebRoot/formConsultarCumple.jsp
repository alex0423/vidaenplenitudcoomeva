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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.consultarCumple.titulo']}" />
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

				<ice:form>
					<ice:panelGroup>
						<ice:panelGrid columns="1" styleClass="panelCabecera1">
							<f:facet name="header">
								<ice:outputText value="#{lbl['labels.cumple']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>
						<ice:panelGrid columns="4"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
							<ice:outputText value="#{lbl['labels.cumple.fechaini']}"></ice:outputText>
							<ice:selectInputDate styleClass="ingresos"
								value="#{consultaCumple.fechaIni}" renderAsPopup="true"
								popupDateFormat="yyyy/MM/dd">
							</ice:selectInputDate>
							<ice:outputText value="#{lbl['labels.cumple.fechafin']}" />
							<ice:selectInputDate styleClass="ingresos"
								value="#{consultaCumple.fechaFin}" renderAsPopup="true"
								popupDateFormat="yyyy/MM/dd">
							</ice:selectInputDate>
							<ice:commandButton
								value="#{lbl['labels.consultacumple.consultar']}"
								actionListener="#{consultaCumple.action_generarConsultaCumple}" />
						</ice:panelGrid>

						<ice:panelGrid>
							<ice:messages id="msg" />
						</ice:panelGrid>
					</ice:panelGroup>
					<ice:panelGroup>
						<ice:dataTable value="#{consultaCumple.lista_asociado}" rows="5"
							var="item" id="dtRegistros" binding="#{consultaCumple.dataTable}"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultacumple.tipoid']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.vepPlusBuc.tipodocumentoAsociado}"></ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText
										value="#{lbl['labels.consultacumple.numeroid']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.vepPlusBuc.documento}" />
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.consultacumple.nombre']}"></ice:outputText>
								</f:facet>
								<ice:outputText
									value="#{item.vepPlusBuc.nombre1Asociado} #{item.vepPlusBuc.nombre2Asociado} #{item.vepPlusBuc.apellido1Asociado} #{item.vepPlusBuc.apellido2Asociado}"></ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.cumple.fechanace']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.vepPlusBuc.fechaNace}">
									<f:convertDateTime pattern="yyyy/MM/dd" />
								</ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.genero']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.vepPlusBuc.genero}" />
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.cumple.fechaingvep']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.vepPlusBuc.fechaIngresovp}">
									<f:convertDateTime pattern="yyyy/MM/dd" />
								</ice:outputText>
							</ice:column>
							<ice:column>
								<f:facet name="header">
									<ice:outputText value="#{lbl['labels.estcivil']}"></ice:outputText>
								</f:facet>
								<ice:outputText value="#{item.vepPlusBuc.estcivil}" />
							</ice:column>
							<ice:column id="seleccionColumnAs">
								<f:facet name="header">
									<ice:outputText value="Seleccione"></ice:outputText>
								</f:facet>
								<ice:commandButton value="Seleccionar"
									actionListener="#{consultaCumple.rowSelection}"></ice:commandButton>
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
					</ice:panelGroup>
					<br />
					<br />
					<ice:panelGroup>
						<ice:panelGrid columns="1" styleClass="panelCabecera1"
							visible="#{consultaCumple.visible}">
							<f:facet name="header">
								<ice:outputText value="DETALLE DEL REGISTRO"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>

						<ice:panelGrid border="0" columns="4" id="panel2"
							visible="#{consultaCumple.visible}"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth">

							<ice:outputText value="#{lbl['labels.nombre1']}" />
							<ice:inputText value="#{consultaCumple.nombre1}" readonly="true"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.nombre2']}" />
							<ice:inputText value="#{consultaCumple.nombre2}" readonly="true"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.apellido1']}" />
							<ice:inputText value="#{consultaCumple.apellido1}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.apellido2']}" />
							<ice:inputText value="#{consultaCumple.apellido2}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.fechanace']}" />
							<ice:inputText value="#{consultaCumple.fechaNace}"
								readonly="true" styleClass="ingresos">		
								<f:convertDateTime pattern="yyyy/MM/dd" />						
							</ice:inputText>
							<ice:outputText value="#{lbl['labels.edad']}" />
							<ice:inputText value="#{consultaCumple.edad}" readonly="true"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.genero']}" />
							<ice:inputText value="#{consultaCumple.genero}" readonly="true"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.codigoaso']}" />
							<ice:inputText value="#{consultaCumple.codigoAsociado}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.estadoaso']}" />
							<ice:inputText value="#{consultaCumple.estadoAsociado}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.fechaingresoaso']}" />
							<ice:inputText value="#{consultaCumple.fechaIngresoAsociado}"
								readonly="true" styleClass="ingresos">			
								<f:convertDateTime pattern="yyyy/MM/dd" />					
							</ice:inputText>

							<ice:outputText value="#{lbl['labels.codigocorte']}" />
							<ice:inputText value="#{consultaCumple.corte}" readonly="true"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.fechaingvep']}" />

							<ice:inputText value="#{consultaCumple.fechaIngVEP}"
								readonly="true" styleClass="ingresos">	
								<f:convertDateTime pattern="yyyy/MM/dd" />							
							</ice:inputText>
							<ice:outputText value="#{lbl['labels.dirres']}" />
							<ice:inputText value="#{consultaCumple.direccionResidencia}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ciudadres']}" />
							<ice:inputText value="#{consultaCumple.ciuRes}" readonly="true"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.dircom']}" />
							<ice:inputText value="#{consultaCumple.dirComercial}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ciudadcom']}" />
							<ice:inputText value="#{consultaCumple.ciuCom}" readonly="true"
								styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telred']}" />
							<ice:inputText value="#{consultaCumple.telefonoResidencia}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telcom']}" />
							<ice:inputText value="#{consultaCumple.telefonoComercial}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.telcel']}" />
							<ice:inputText value="#{consultaCumple.telefonoCelular}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.correoele']}" />
							<ice:inputText value="#{consultaCumple.correoElectrinico}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.titulopro']}" />

							<ice:inputText value="#{consultaCumple.tituloProfesionalLabel}"
								readonly="true" styleClass="ingresos" />
							<ice:outputText value="#{lbl['labels.ocupacion']}" />
							<ice:inputText value="#{consultaCumple.ocupacionLabel}"
								readonly="true" styleClass="ingresos" />

							<ice:outputText value="#{lbl['labels.estcivil']}" />
							<ice:inputText value="#{consultaCumple.estadoCivilLabel}"
								readonly="true" styleClass="ingresos" />

							<ice:outputText value="#{lbl['labels.tiposangre']}" />
							<ice:inputText value="#{consultaCumple.tipoSangre}"
								readonly="true" styleClass="ingresos" />
						</ice:panelGrid>

						<ice:panelGrid visible="false"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							styleClass="panelCabeceraWidth" columns="3">
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.servimed']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems value="#{consultaCumple.registeredServMedico}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.serviact']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems value="#{consultaCumple.registeredPAMS}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.sufrepatol']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems value="#{consultaCumple.registeredPatologias}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.ofrecer']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems value="#{consultaCumple.registeredServOfrecer}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.conocimientos']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems
										value="#{consultaCumple.registeredConocimientos}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
							<ice:panelGrid>
								<ice:outputText value="#{lbl['labels.hobbies']}" />
								<ice:selectManyMenu style="overflow: auto;height:75px"
									readonly="true">
									<f:selectItems value="#{consultaCumple.registeredHobbies}" />
								</ice:selectManyMenu>
							</ice:panelGrid>
						</ice:panelGrid>
						<ice:panelGrid columns="5">
							<ice:commandButton value="#{lbl['labels.btn.generarExcel']}"
								actionListener="#{consultaCumple.action_generarExcel}" />
							<ice:outputLink value="./servlet/showFileServlet"
								visible="#{consultaCumple.visibleExport}"
								rendered="#{consultaCumple.visibleExport}">
								<f:param name="url" value="#{consultaCumple.exportName}" />
								<ice:outputText value="Descargar Excel" />
							</ice:outputLink>
							<ice:outputText />
							<ice:commandButton value="#{lbl['labels.btn.generarHtml']}"
								actionListener="#{consultaCumple.action_generarHtml}" />
							<ice:outputLink value="./servlet/showFileServlet"
								visible="#{consultaCumple.visibleExportHtml}"
								rendered="#{consultaCumple.visibleExportHtml}">
								<f:param name="url" value="#{consultaCumple.exportNameHtml}" />
								<ice:outputText value="Descargar Html" />
							</ice:outputLink>
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

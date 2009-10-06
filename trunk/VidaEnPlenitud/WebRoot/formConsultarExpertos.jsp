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
						value="#{lbl['labels.titulo.todos']} #{lbl['labels.consultarExpertos.titulo']}" />
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
						<ice:panelGrid styleClass="panelCabecera1">
							<ice:outputText value="#{lbl['labels.consexp']}"
								styleClass="textoBlanco" />
						</ice:panelGrid>
						<ice:panelGrid columns="6"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" visible="true">
							<ice:outputText value="#{lbl['labels.consexp.estado']}:"></ice:outputText>
							<ice:selectOneMenu styleClass="ingresos" partialSubmit="true"
								immediate="true" value="#{listarConsultorias.SEstado}">
								<f:selectItems value="#{LOVs.estadoConsultoria}" />
							</ice:selectOneMenu>
							<ice:outputText value="#{lbl['labels.consexp.fechaini']}" />
							<ice:selectInputDate renderAsPopup="true" immediate="true"
								value="#{listarConsultorias.SFechaInicio}"
								popupDateFormat="yyyy/MM/dd">
							</ice:selectInputDate>
							<ice:outputText value="#{lbl['labels.consexp.fechater']}" />
							<ice:selectInputDate renderAsPopup="true" immediate="true"
								value="#{listarConsultorias.SFechaFin}"
								popupDateFormat="yyyy/MM/dd">
							</ice:selectInputDate>
							<ice:outputText value="#{lbl['labels.consexp.idservicio']}" />
							<ice:inputText styleClass="ingresos" partialSubmit="true"
								value="#{listarConsultorias.SIdServicio}"
								binding="#{listarConsultorias.filteredIdServicio}" />
							<ice:outputText value="#{lbl['labels.consexp.idasesor']}" />
							<ice:inputText styleClass="ingresos" partialSubmit="true"
								value="#{listarConsultorias.SAsesor}"
								binding="#{listarConsultorias.filteredAsesor}" />
							<ice:outputText value="Regional" />
							<ice:selectOneMenu value="#{listarConsultorias.idRegional}"
								disabled="#{listarConsultorias.disabledRegional}"
								styleClass="ingresos">
								<f:selectItems value="#{LOVs.regionalesUsuario}" />
							</ice:selectOneMenu>
						</ice:panelGrid>

						<ice:panelGrid columns="2">
							<ice:commandButton value="Consultar"
								actionListener="#{listarConsultorias.action_consultar}"></ice:commandButton>
							<ice:commandButton value="Cancelar"
								actionListener="#{listarConsultorias.action_limpiar}"></ice:commandButton>

						</ice:panelGrid>
						<br />
						<ice:panelGrid>
							<ice:messages id="msg" />
						</ice:panelGrid>
						<br />
						<br />
						<ice:panelGrid styleClass="panelCabecera1">
							<ice:outputText value="#{lbl['labels.resultadobusqueda']}"
								styleClass="textoBlanco" />
						</ice:panelGrid>
						<ice:panelGrid>
							<ice:dataTable id="dtConsultorias" rows="5"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
								value="#{listarConsultorias.lstConsultorias}" var="item"
								binding="#{listarConsultorias.dataTable}">
								<ice:column id="nombreColumn">
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.consultaasesoria.nombre']}"></ice:outputText>
									</f:facet>
									<ice:outputLabel value="#{item.nombre}"></ice:outputLabel>
								</ice:column>
								<ice:column id="descripcionColumn">
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.consultaasesoria.descripcion']}"></ice:outputText>
									</f:facet>
									<ice:outputLabel value="#{item.descripcion}"></ice:outputLabel>
								</ice:column>
								<ice:column id="estadoColumn">
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.consultaasesoria.estado']}"></ice:outputText>
									</f:facet>
									<ice:outputLabel value="#{item.estado}"></ice:outputLabel>
								</ice:column>
								<ice:column id="fechaIniColumn">
									<f:facet name="header">
										<ice:outputText
											value="#{lbl['labels.consultaasesoria.fechainicio']}"></ice:outputText>
									</f:facet>
									<ice:outputText value="#{item.fechaInicio}">
										<f:convertDateTime pattern="yyyy/MM/dd" />
									</ice:outputText>
								</ice:column>
								<ice:column id="seleccionColumn">
									<f:facet name="header">
										<ice:outputText value="Seleccione"></ice:outputText>
									</f:facet>
									<ice:commandButton value="Seleccionar"
										actionListener="#{listarConsultorias.rowSelection}"></ice:commandButton>
								</ice:column>
							</ice:dataTable>

							<ice:dataPaginator id="dataScroll_1" for="dtConsultorias">
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
							<ice:dataPaginator id="dataScroll_2" for="dtConsultorias"
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
							<ice:panelGrid columns="5">
								<ice:commandButton value="#{lbl['labels.btn.generarExcel']}"
									actionListener="#{listarConsultorias.action_generarExcel}" />
								<ice:outputLink value="./servlet/showFileServlet"
									visible="#{listarConsultorias.visibleExport}"
									rendered="#{listarConsultorias.visibleExport}">
									<f:param name="url" value="#{listarConsultorias.exportName}" />
									<ice:outputText value="Descargar Excel" />
								</ice:outputLink>
								<ice:outputText />
								<ice:commandButton value="#{lbl['labels.btn.generarHtml']}"
									actionListener="#{listarConsultorias.action_generarHtml}" />
								<ice:outputLink value="./servlet/showFileServlet"
									visible="#{listarConsultorias.visibleExportHtml}"
									rendered="#{listarConsultorias.visibleExportHtml}">
									<f:param name="url"
										value="#{listarConsultorias.exportNameHtml}" />
									<ice:outputText value="Descargar Html" />
								</ice:outputLink>

							</ice:panelGrid>
						</ice:panelGrid>
						<br />
						<br />
						<ice:panelGrid rendered="#{listarConsultorias.renderInfo}"
							styleClass="icePnlGrdPPAL">
							<fieldset>
								<ice:panelGrid border="0" width="700" id="id_4" rendered="true">
									<ice:panelGrid styleClass="panelSubtitulo" width="100%">
										<ice:outputText
											value="#{lbl['labels.consultaasesoria.titulo']}"
											styleClass="textoBlanco" />
									</ice:panelGrid>
									<ice:panelGrid columns="2"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
										<ice:outputText value="#{lbl['labels.codigoServicio']}" />
										<ice:inputText value="#{listarConsultorias.id}"
											readonly="true" styleClass="ingresos" />
										<ice:outputText value="#{lbl['labels.nombreServicio']}" />
										<ice:inputText value="#{listarConsultorias.nombreConsultoria}"
											styleClass="ingresos" readonly="true" size="70" />
										<ice:outputText value="#{lbl['labels.descripcionServicio']}" />
										<ice:inputText readonly="true" size="70" styleClass="ingresos"
											value="#{listarConsultorias.descripcionConsultoria}" />
										<ice:outputText value="Nro. Beneficiados" />
										<ice:inputText readonly="true" styleClass="ingresos"
											value="#{listarConsultorias.beneficiadosConsultoria}" />
									</ice:panelGrid>
									<ice:panelGrid columns="4"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
										<ice:outputText value="#{lbl['labels.regional']}" />
										<ice:inputText readonly="true" styleClass="ingresos"
											value="#{listarConsultorias.regional}" />
										<ice:outputText value="#{lbl['labels.estado']}" />
										<ice:inputText readonly="true"
											value="#{listarConsultorias.estado}" styleClass="ingresos" />
										<ice:outputText value="Fecha Inicio" />
										<ice:inputText readonly="true"
											value="#{listarConsultorias.fechaInicioConsultoria}"
											styleClass="ingresos">
											<f:convertDateTime pattern="yyyy/MM/dd" />
										</ice:inputText>
										<ice:outputText value="Fecha Terminacion" />
										<ice:inputText readonly="true"
											value="#{listarConsultorias.fechaTerminacionConsultoria}"
											styleClass="ingresos">
											<f:convertDateTime pattern="yyyy/MM/dd" />
										</ice:inputText>
									</ice:panelGrid>
								</ice:panelGrid>
								<ice:panelGrid>
									<ice:outputText></ice:outputText>
									<ice:outputText></ice:outputText>
								</ice:panelGrid>
								<ice:panelGrid columns="2">
									<ice:outputText
										value="#{lbl['labels.detalleconsultoria.consultores']}"></ice:outputText>
									<ice:outputText
										value="#{lbl['labels.detalleconsultoria.beneficiarios']}"></ice:outputText>
									<ice:dataTable id="dtConsultores" rows="5"
										value="#{listarConsultorias.lstConsultores}" var="item"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
										<ice:column id="nombreColumnConsultor">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.nombre']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel value="#{item.nombre}"></ice:outputLabel>
										</ice:column>
										<ice:column id="descripcionColumnConsultor">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.identificacion']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel value="#{item.identificacion}"></ice:outputLabel>
										</ice:column>
										<ice:column id="estadoColumnConsultor">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.codigoaso']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel value="#{item.idAsociado}"></ice:outputLabel>
										</ice:column>
									</ice:dataTable>

									<ice:dataTable id="dtBeneficiarios" rows="5"
										value="#{listarConsultorias.lstBeneficiarios}" var="itemBenef"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
										<ice:column id="nombreColumnBenef">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.nombre']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel value="#{itemBenef.beneficiado.nombre}"></ice:outputLabel>
										</ice:column>
										<ice:column id="estadoColumnBenef">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.tipoiddato']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel value="#{itemBenef.tipoDocumento}"></ice:outputLabel>
										</ice:column>
										<ice:column id="descripcionColumnBenef">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.identificacion']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel
												value="#{itemBenef.beneficiado.id.numeroDocumento}"></ice:outputLabel>
										</ice:column>
									</ice:dataTable>
								</ice:panelGrid>

								<ice:panelGrid width="100%">
									<ice:outputText
										value="#{lbl['labels.detalleconsultoria.informes']}"></ice:outputText>
									<ice:dataTable id="dtSeguimiento" rows="5"
										value="#{listarConsultorias.lstInformes}" var="itemSeg"
										rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
										<ice:column id="fechaColumnSeg">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.fecha']}"></ice:outputText>
											</f:facet>
											<ice:outputText value="#{itemSeg.fecha}">
												<f:convertDateTime pattern="yyyy/MM/dd" />
											</ice:outputText>
										</ice:column>
										<ice:column id="informeColumnSeg">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.gestionRealizada']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel value="#{itemSeg.contenido}"></ice:outputLabel>
										</ice:column>
										<ice:column id="archivoColumnSeg">
											<f:facet name="header">
												<ice:outputText value="#{lbl['labels.archivo']}"></ice:outputText>
											</f:facet>
											<ice:outputLabel value="#{itemSeg.archivo}"></ice:outputLabel>
										</ice:column>
									</ice:dataTable>
								</ice:panelGrid>
							</fieldset>
						</ice:panelGrid>
						<ice:panelGrid width="100%">
							<center>
								<ice:outputConnectionStatus activeLabel="Procesando..."
									style="font-size: 13px;" />
							</center>
						</ice:panelGrid>
						<ice:panelGrid styleClass="panelFooter">
							<f:facet name="header">
								<ice:outputText value="#{lbl['labels.copyright']}"
									styleClass="textoBlanco" />
							</f:facet>
						</ice:panelGrid>

					</ice:panelGroup>
					<br />
					<ice:panelPopup id="selectorCiudades"
						style="width: 388px; height: 172px; text-align: left"
						draggable="true" rendered="#{listarConsultorias.visible}"
						visible="#{listarConsultorias.visible}" modal="true"
						autoCentre="true">
						<f:facet name="header">
							<ice:outputText value="#{lbl['labels.panelciudades.titulo']}" />
						</f:facet>
						<f:facet name="body">
							<ice:panelGrid id="ciudadSelector1"
								rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2" columns="2">
								<ice:outputText value="#{lbl['labels.panelciudades.pais']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{listarConsultorias.pais}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{listarConsultorias.onSelectPais}"
									immediate="true">
									<f:selectItems value="#{LOVs.paises}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.depto']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{listarConsultorias.deptos}" style="width: 162px"
									partialSubmit="true"
									valueChangeListener="#{listarConsultorias.onSelectDepartamento}"
									immediate="true">
									<f:selectItems value="#{listarConsultorias.lista_deptos}" />
								</ice:selectOneMenu>

								<ice:outputText value="#{lbl['labels.panelciudades.ciudad']}" />
								<ice:selectOneMenu styleClass="ingresos"
									value="#{listarConsultorias.ciu}" style="width: 212px"
									partialSubmit="true"
									valueChangeListener="#{listarConsultorias.onSelectCiudad}"
									immediate="true">
									<f:selectItems value="#{listarConsultorias.lista_ciu}" />
								</ice:selectOneMenu>

								<ice:commandButton action="#{listarConsultorias.closePopup}"
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

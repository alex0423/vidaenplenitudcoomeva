<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root version="1.1" xmlns:jsp="http://java.sun.com/JSP/Page"
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
				<link rel="stylesheet" type="text/css" href="./css/coomeva.css" />
				<link rel="stylesheet" type="text/css" href="./css/style.css" />
			</head>
			<body>
				<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />

				<ice:panelGrid styleClass="panelCabeceraWidth">
					<jsp:directive.include file="Cabecera.jsp" />
				</ice:panelGrid>
				<br />

				<ice:form partialSubmit="true">
					<ice:panelGrid styleClass="icePnlGrdPPAL">
						<ice:dataTable id="dtConsultorias" rows="5"
							rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2"
							value="#{consultoriasAsesor.lstConsultorias}" var="item"
							binding="#{consultoriasAsesor.dataTable}">
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
								<ice:outputLabel value="#{item.fechaInicio}"></ice:outputLabel>
							</ice:column>
							<ice:column id="seleccionColumn">
								<f:facet name="header">
									<ice:outputText value="Seleccione"></ice:outputText>
								</f:facet>
								<ice:commandButton value="Seleccionar"
									actionListener="#{consultoriasAsesor.rowSelection}"></ice:commandButton>
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

					</ice:panelGrid>
					<br />
					<br />
					<ice:panelGrid rendered="#{consultoriasAsesor.renderInfo}"
						styleClass="icePnlGrdPPAL">
						<fieldset>
							<ice:panelGrid border="0" width="700" id="id_4" rendered="true">
								<ice:panelGrid columns="2"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
									<ice:outputText value="#{lbl['labels.codigoServicio']}" />
									<ice:inputText value="#{consultoriasAsesor.id}" readonly="true"
										styleClass="ingresos" />
									<ice:outputText value="#{lbl['labels.nombreServicio']}" />
									<ice:inputText value="#{consultoriasAsesor.nombreConsultoria}"
										styleClass="ingresos" readonly="true" size="70" />
									<ice:outputText value="#{lbl['labels.descripcionServicio']}" />
									<ice:inputText readonly="true" size="70" styleClass="ingresos"
										value="#{consultoriasAsesor.descripcionConsultoria}" />
									<ice:outputText value="Nro. Beneficiados" />
									<ice:inputText readonly="true" styleClass="ingresos"
										value="#{consultoriasAsesor.beneficiadosConsultoria}" />
								</ice:panelGrid>
								<ice:panelGrid columns="4"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
									<ice:outputText value="#{lbl['labels.codigoCiudad']}" />
									<ice:inputText readonly="true" styleClass="ingresos"
										value="#{consultoriasAsesor.regional}" />
									<ice:outputText value="#{lbl['labels.estado']}" />
									<ice:inputText readonly="true"
										value="#{consultoriasAsesor.estado}" styleClass="ingresos" />
									<ice:outputText value="Fecha Inicio" />
									<ice:inputText readonly="true"
										value="#{consultoriasAsesor.fechaInicioConsultoria}"
										styleClass="ingresos" />
									<ice:outputText value="Fecha Terminacion" />
									<ice:inputText readonly="true"
										value="#{consultoriasAsesor.fechaTerminacionConsultoria}"
										styleClass="ingresos" />
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
									value="#{consultoriasAsesor.lstConsultores}" var="item"
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
									value="#{consultoriasAsesor.lstBeneficiarios}" var="itemBenef"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
									<ice:column id="nombreColumnBenef">
										<f:facet name="header">
											<ice:outputText value="#{lbl['labels.nombre']}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="#{itemBenef.nombre}"></ice:outputLabel>
									</ice:column>
									<ice:column id="descripcionColumnBenef">
										<f:facet name="header">
											<ice:outputText value="#{lbl['labels.identificacion']}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="#{itemBenef.identificacion}"></ice:outputLabel>
									</ice:column>
									<ice:column id="estadoColumnBenef">
										<f:facet name="header">
											<ice:outputText value="#{lbl['labels.codigoaso']}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="#{itemBenef.idAsociado}"></ice:outputLabel>
									</ice:column>
								</ice:dataTable>
							</ice:panelGrid>

							<ice:panelGrid width="100%">
								<ice:outputText
									value="#{lbl['labels.detalleconsultoria.informes']}"></ice:outputText>
								<ice:dataTable id="dtSeguimiento" rows="5"
									value="#{consultoriasAsesor.lstInformes}" var="itemSeg"
									rowClasses="icePnlGrdRowVEP1 icePnlGrdRowVEP2">
									<ice:column id="fechaColumnSeg">
										<f:facet name="header">
											<ice:outputText value="#{lbl['labels.fecha']}"></ice:outputText>
										</f:facet>
										<ice:outputLabel value="#{itemSeg.fecha}"></ice:outputLabel>
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

					<ice:messages />
					<ice:panelPopup draggable="false" modal="true"
						visible="#{consultoriasAsesor.modalRendered}"
						autoCentre="#{consultoriasAsesor.autoCentre}"
						style="z-index: 50000; top: 30%; left: 35%; position: absolute; width: 380px;">
						<f:facet name="header">
							<ice:panelGroup styleClass="popupHeaderWrapper">
								<ice:outputText value="#{consultoriasAsesor.messageTittle}"
									styleClass="popupHeaderText" />
							</ice:panelGroup>
						</f:facet>
						<f:facet name="body">
							<ice:panelGroup styleClass="popupBody">
								<ice:outputText value="#{consultoriasAsesor.message}" />
								<br />
								<br />
								<center>
									<ice:commandButton type="submit"
										value="#{lbl['labels.message.button']}"
										actionListener="#{consultoriasAsesor.toggleModal}" />
								</center>
							</ice:panelGroup>
						</f:facet>
					</ice:panelPopup>

					<ice:messages />
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

				</ice:form>
			</body>
		</html>
	</f:view>
</jsp:root>

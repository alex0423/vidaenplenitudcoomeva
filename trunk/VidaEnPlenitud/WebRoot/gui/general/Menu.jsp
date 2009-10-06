<?xml version="1.0" encoding="ISO-8859-1" ?>
<f:subview id="MenuPrincipal" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
	<!-- f:loadBundle basename="co.com.rpro.label.labels" var="lbl" /> -->
	<ice:form partialSubmit="true">

		<ice:panelGroup style="width=100%"
			styleClass="exampleBox menuBarContainer">
			<ice:menuBar id="menuBar" orientation="Horizontal">
				<ice:menuItems value="#{menuBar.menuModel}" />
				<!-- admistracion menu -->
			</ice:menuBar>

			<!-- ice:panelGrid>
				<ice:commandLink action="#{menuBar.cerrarSession}"
					value="#{lbl['labels.menu.consulta.cerrarsesion']}"></ice:commandLink>

			</ice:panelGrid> -->
		</ice:panelGroup>
	</ice:form>
</f:subview>

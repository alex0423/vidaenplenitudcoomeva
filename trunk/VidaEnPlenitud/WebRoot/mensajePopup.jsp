<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
	<jsp:directive.page contentType="text/html;charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" />
	<f:view>
		<f:loadBundle basename="co.com.vep.etiquetas.labels" var="lbl" />
		<ice:panelPopup id="visorMensajes" draggable="false" modal="true"
			visible="#{registrarProfesor.modalRendered}"
			autoCentre="#{registrarProfesor.autoCentre}">
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

	</f:view>
</jsp:root>
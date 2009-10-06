<html   
	xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:ice="http://www.icesoft.com/icefaces/component">
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1" />
		<title>Pagina Principal</title>
		<link rel="stylesheet" type="text/css"
			href="../../xmlhttp/css/rime/rime.css" />
	</head> 
	<body>
		<f:view> 
			<ice:panelGrid style="width=100%" >				
				<jsp:directive.include file="../menu/menu.jsp" />
			</ice:panelGrid>
			<ice:form partialSubmit="true">
				<!-- <include file="../general/Menu.jspx" %> -->
				<ice:panelGrid>
					<ice:outputText value="hola"></ice:outputText>
				</ice:panelGrid>
			</ice:form>
		</f:view>
	</body>
</html>

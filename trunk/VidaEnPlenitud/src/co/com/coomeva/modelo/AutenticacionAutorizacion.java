package co.com.coomeva.modelo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import co.com.coomeva.profile.ws.client.CaasStub;
import co.com.coomeva.profile.ws.client.CaasStub.Application;
import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.coomeva.profile.ws.client.CaasStub.Section;
import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.coomeva.profile.ws.client.CaasStub.ValidateUser;
import co.com.coomeva.profile.ws.client.CaasStub.ValidateUserResponse;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.ProjectUtils;


public class AutenticacionAutorizacion {

	private CaasStub stub = null;

	private ValidateUser val = null;

	private UserVo	usuario = null;

	private RprDatos_Empleado usuarioActual = null;

	private ArrayList listaModulos = null;

	private Menu menu = null;
	
	private Application app;

	

	public AutenticacionAutorizacion() {

	}

	public void getInstance() {

		

//		if (getUsuarioActual() == null) {
//			HttpServletRequest request = FacesUtils.getServletRequest();
//			//System.out.println("AutenticacionAutorizacion getInstance() Request: "+ request);
//
//			String login = "";
//			String password = "";
//			if (request != null) {
//				String remoteUser = request.getRemoteUser();
//
//				//System.out.println("RemoteUser: " + remoteUser);
//				login = remoteUser;
//			}
//
//			//System.out.println("El login es: " + login);
//
//			autenticar(login, password);
//		}

	
	}

	public void destroy() {
		
		FacesUtils.resetManagedBean("autenticacionAutorizacion");
	}

	private String login;

	// private String password;

	public void autenticar(String login, String password) {
		setLogin(login);
		// setPassword(password);

		// setUsuarioActual(DatosUsuarioCU.getDatosEmpleadoPorCodigo(login));
		//
		// if (getUsuarioActual() != null)
		// cargarModulosUsuario(ProjectUtils.getNombreAplicacion());
		// if (true)
		// return;

		int directorio = 1;

		if (validarUsuario(directorio, getLogin(), password)) {
			directorio = 2;
			validarUsuario(directorio, getLogin(), password);
		}

	}

	private boolean validarUsuario(int directorio, String usuario, String clave) { 

		String str = ProjectUtils.getWebServiceUrl(); // "http://192.1.2.26:9092/axis2/services/Caas";

		boolean error = false;
		try {
			stub = new CaasStub(str);

			val = new ValidateUser();
			val.setUserName(getLogin());
			val.setDirectory(directorio);

			ValidateUserResponse vures = null;
			vures = stub.validateUser(val);
			if (vures != null) {
				setUsuario(vures.get_return());

				/*if (esUsuarioValidoEnProfileManager()) {
					setUsuarioActual(DatosUsuarioCU
							.getDatosEmpleadoPorCedula(getUsuario().getId()));
					if (getUsuarioActual() != null) {*/

						cargarModulosUsuario(ProjectUtils.getNombreAplicacion(), getUsuario());

						pintarDatosMenu(getUsuario());
				/*	} else
					{
						error = true;
					}
				} else
				{
					setUsuarioActual(null);
					error = true;
				}*/

			} /*else
			{
				setUsuarioActual(null);
				error = true;
			}*/

		} catch (RemoteException e) {
			// TODO: handle exception
			error = true;
			System.out.println("RemoteException");
		} catch (Exception e) {

			e.printStackTrace();
			error = true;
		}

		return error;
	}

	private boolean validarUsuarioPrueba(String login, String password,
			int directorio) {

		setLogin(login);
		// setPassword(password);

		String str = ProjectUtils.getWebServiceUrl(); // "http://192.1.2.26:9092/axis2/services/Caas";

		//System.out.println("UrlServicio: " + str);

		boolean error = false;
		try {
			stub = new CaasStub(str);

			val = new ValidateUser();
			val.setUserName(getLogin());
			val.setPassword(password);

			//System.out.println("getLogin: " + getLogin());
			// System.out.println("getPassword: " + getPassword());
			//System.out.println("directorio: " + directorio);

			val.setDirectory(directorio);

			ValidateUserResponse vures = null;
			vures = stub.validateUser(val);
			if (vures != null) {
				setUsuario(vures.get_return());

				if (esUsuarioValidoEnProfileManager()) {
					pintarDatosMenu(getUsuario());
				}

			}

		} catch (RemoteException e) {
			// TODO: handle exception
			error = true;
			System.out.println("RemoteException");
		} catch (Exception e) {

			e.printStackTrace();
		}

		return error;
	}

	public Application[] getApplicationsDefecto() {

		Application[] applications = new Application[1];
		applications[0] = new Application();
		applications[0].setName("RegistroProveedores");

		Role[] roles = new Role[6];
		roles[0] = new Role();
		roles[0].setName("Auxiliar");

		Section[] sections = new Section[1];
		sections[0] = new Section();
		sections[0].setName("Administracion");

		String[] actions = { "Reasignar Proveedor", "Asignar Correccion Evaluación Proveedor",
				"Actualizacion Plantilla", "Administracion Tipo Proveedor" , " Administracion Tipo Producto"};
		sections[0].setActions(actions);

		roles[0].setSections(sections);

		roles[1] = new Role();
		roles[1].setName("Aprobador");

		sections = new Section[1];
		sections[0] = new Section();
		sections[0].setName("Aprobar");

		String[] actions1 = { "Aprobar Legalizacion", "Aprobar Solicitud" };
		sections[0].setActions(actions1);

		roles[1].setSections(sections);

		roles[2] = new Role();
		roles[2].setName("Organizador");

		sections = new Section[1];
		sections[0] = new Section();
		sections[0].setName("Reservar");

		String[] actions2 = { "Reservar Solicitudes" };
		sections[0].setActions(actions2);

		roles[2].setSections(sections);

		roles[3] = new Role();
		roles[3].setName("Turismo");

		sections = new Section[1];
		sections[0] = new Section();
		sections[0].setName("Turismo");

		String[] actions3 = { "Actualizar Solicitud" };
		sections[0].setActions(actions3);

		roles[3].setSections(sections);

		roles[4] = new Role();
		roles[4].setName("Gestion Humana");

		sections = new Section[1];
		sections[0] = new Section();
		sections[0].setName("Reportes");

		String[] actions4 = { "Paz  y Salvo", "Consultar Solicitudes" };
		sections[0].setActions(actions4);

		roles[4].setSections(sections);

		roles[5] = new Role();
		roles[5].setName("Administrador");

		sections = new Section[1];
		sections[0] = new Section();
		sections[0].setName("Reportes");

		String[] actions5 = { "Legalizaciones por Aprobar",
				"Solicitudes por Aprobar", "Pendientes por Trasferencia",
				"Consultar Solicitudes" };
		sections[0].setActions(actions5);

		roles[5].setSections(sections);

		applications[0].setRoles(roles);

		return applications;
	}
	
	public String validarModulosUsuario(String aplicacion, UserVo usuario, String tipoUsuario) throws Exception {
		//System.out.println("Entro a cargarModulosUsuario");
		String respuesta="0";
		Application[] applications = usuario.getApplications();
		//System.out.println("111-num app: "+applications.length);
		// Application[] applications = getApplicationsDefecto();
		// ModuloMenu moduloMenu = null;
		
		OpcionModulo opcionModulo = null;

		for (int i = 0; i < applications.length; i++) {
			Application application = applications[i];

			if (application.getName().equals(aplicacion)) {
				setApp(application);
				Role[] roles = application.getRoles();
				for (int j = 0; j < roles.length; j++) {
					String rol =  roles[j].getName();
					String prov = ProjectUtils.getValorDefecto("autenticacion.roles.proveedor");
					if (rol.equals(prov)
									&& tipoUsuario.equals("1") && roles.length==1) {
						respuesta ="1";
						break;						
					}

						//throw new Exception( "El usuario pertenece al rol Proveedor y esta intentando ingresar como Empleado" );
				}
				break;
			}
		}
		return respuesta;
	}
	
	public void cargarModulosUsuario(String aplicacion, UserVo usuario) {
		//System.out.println("Entro a cargarModulosUsuario");
		
		Application[] applications = usuario.getApplications();
		//System.out.println("111-num app: "+applications.length);
		// Application[] applications = getApplicationsDefecto();
		// ModuloMenu moduloMenu = null;
		
		OpcionModulo opcionModulo = null;

		for (int i = 0; i < applications.length; i++) {
			Application application = applications[i];
			if (application.getName().equals(aplicacion)) {
				FacesUtils.getSession().setAttribute("Application", application.getName());
				
				Role[] roles = application.getRoles();	
				for (int j = 0; j < roles.length; j++) {
					Role role = roles[j];

					// Se mete a la sesion el rol
					FacesUtils.getSession().setAttribute("Role", role);
					
					Section[] sections = role.getSections();					
					FacesUtils.getSession().setAttribute("Section", sections);					
					if (sections != null)
						for (int k = 0; k < sections.length; k++) {
							Section section = sections[k];			
							String[] actions = section.getActions();
							FacesUtils.getSession().setAttribute("acciones", actions);
						}			
				}
				break;
			}
		}
	}

	private void adicionarAction(String section, OpcionModulo opcionModulo) {
		// TODO Auto-generated method stub
		//Administracion
		if (section.equals("Administracion")) {
			// Se revisa a que opciones del menu tiene derecho
			//Actualizar Plantilla
			if (ProjectUtils.esActualizarPlantilla(opcionModulo
					.getDescripcion()))
				setRenderActualizarPlantilla(true);
			else if (ProjectUtils.esReasignarEvaluacion(opcionModulo
					.getDescripcion()))
				setRenderReasignarEvaluacion(true);
		}
		//Consulta
		if (section.equals(ProjectUtils.getNombreSectionConsulta())) {
			// Se revisa a que opciones del menu tiene derecho
			//Actualizar Plantilla
			if (ProjectUtils.esListadoProveedores(opcionModulo
					.getDescripcion()))
				setRenderListadoProveedores(true);
			else if (ProjectUtils.esHistoricoProveedor(opcionModulo
					.getDescripcion()))
				setRenderHistoricoProveedor(true);
			else if (ProjectUtils
					.esFormularioProveedor(opcionModulo
							.getDescripcion()))
				setRenderFormularioProveedor(true);
		}
		//Proceso
		if (section.equals(ProjectUtils.getNombreSectionProceso())) {
			// Se revisa a que opciones del menu tiene derecho
			//Actualizar Plantilla
			if (ProjectUtils.esCorreccionEvaluacion(opcionModulo
					.getDescripcion()))
				setRenderCorreccionEvaluacion(true);
			else if (ProjectUtils.esAsignarClave(opcionModulo
					.getDescripcion()))
				setRenderAsignarClave(true);
			else if (ProjectUtils
					.esEvaluarProveedor(opcionModulo
							.getDescripcion()))
				setRenderEvaluarProveedor(true);
			else if (ProjectUtils
					.esRegistroProveedor(opcionModulo
							.getDescripcion()))
				setRenderRegistroProveedor(true);
		}
		System.out.println();
		System.out.println();
		System.out.println();System.out.println("ACTION");
		 System.out.println("isRenderActualizarPlantilla "+ isRenderActualizarPlantilla());
		 System.out.println("isRenderReasignarEvaluacion: "+ isRenderReasignarEvaluacion());
		 System.out.println("isRenderListadoProveedores: "+ isRenderListadoProveedores());
		 System.out.println("isRenderHistoricoProveedor: "+ isRenderHistoricoProveedor());
		 System.out.println("isRenderFormularioProveedor: "+ isRenderFormularioProveedor());
		 System.out.println("isRenderCorreccionEvaluacion: "+ isRenderCorreccionEvaluacion());
		 System.out.println("isRenderAsignarClave: "+ isRenderAsignarClave());
		 System.out.println("isRenderEvaluarProveedor: "+ isRenderEvaluarProveedor());
		 System.out.println("isRenderRegistroProveedor: "+ isRenderRegistroProveedor());
	}

	private void adicionarSection(String section) {

		//System.out.println("La section es: " + section);
		String proces =  ProjectUtils.getNombreSectionProceso();
		String con = ProjectUtils.getNombreSectionConsulta();
		String admi	= "Administracion";
		
		// Si el rol tiene la section Procesos 
		if (section.equals(ProjectUtils.getNombreSectionProceso())
				&& !isRenderSectionProveedor()) {
			setRenderSectionProveedor(true);
			setRenderSectionProceso(true);
			setSectionProceso(section);
			// Si el rol tiene la section Administracion
		} else if (section.equals("Administracion")
				&& !isRenderSectionAdministracion()) {
			setRenderSectionAdministracion(true);
			setSectionAdministracion(section);
			// Si el rol tiene la section Consulta
		} else if (section.equals(ProjectUtils
				.getNombreSectionConsulta())
				&& !isRenderSectionConsulta()) {
			setRenderSectionConsulta(true);
			setSectionConsultas(section);
		}
		 System.out.println();System.out.println("SECTION");
		 System.out.println("isRenderSectionProveedor: "+ isRenderSectionProveedor());
		 System.out.println("isRenderSectionProveedor: "+ isRenderSectionAdministrador());
		 System.out.println("isRenderSectionAuxiliarCompras: "+ isRenderSectionAuxiliarCompras());
		 System.out.println("isRenderSectionConsulta: "+ isRenderSectionConsulta());
		 System.out.println();System.out.println();
		
	}

	public UserVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UserVo usuario) {
		this.usuario = usuario;
	}

	public boolean esUsuarioAutenticado() {
		// TODO Auto-generated method stub

		return true;
		// return getUsuarioActual() != null &&
		// esUsuarioValidoEnProfileManager();
	}

	public boolean esUsuarioValidoEnProfileManager() {
		// TODO Auto-generated method stub
		if (getUsuario() == null)
			return false;

		return true;

		// return "true".equals(getUsuario().getAuthorized());
	}

	public RprDatos_Empleado getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(RprDatos_Empleado usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	// public TgvDatos_Empleado getAprobadorUsuario() {
	// return aprobadorUsuario;
	// }
	//
	// public void setAprobadorUsuario(TgvDatos_Empleado aprobadorUsuario) {
	// this.aprobadorUsuario = aprobadorUsuario;
	// }

	public ArrayList getListaModulos() {
		return listaModulos;
	}

	public void setListaModulos(ArrayList listaModulos) {
		this.listaModulos = listaModulos;
	}

	public Menu getMenu() {
		if (menu == null)
			menu = new Menu();
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	// ////METODOS QUE DEVUELVEN DATOS A LAS PANTALLAS

	public List listarModulosMenu() {
		// TODO Auto-generated method stub
		if (getMenu().getListaModulosMenu().size() == 0)
			cargarModulosUsuario(ProjectUtils.getNombreAplicacion(), getUsuario());
		return getMenu().getListaModulosMenu();
	}

	public String getCodigoEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_codigo();
		return retorno;
	}

	public String getCedulaEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_cedula();
		return retorno;
	}

	public String getNombreEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_nombre() + " "
					+ getUsuarioActual().getEmp_apellido1() + " "
					+ getUsuarioActual().getEmp_apellido2();
		return retorno;
	}

	public String getEmpresaEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getNombre_sociedad();
		return retorno;
	}

	public String getCargoEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_cargo();
		return retorno;
	}

	public String getDescripcionCargoEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getCargo_nombre();
		return retorno;
	}

	public String getCategoriaEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getCategoria();
		return retorno;
	}

	public String getDivisionEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_division();
		return retorno;
	}

	public String getDescripcionDivisionEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getDivision_nombre();
		return retorno;
	}

	public String getCCContableEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_cc_contable();
		return retorno;
	}

	public String getCtaCteEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_ctacte();
		return retorno;
	}

	public String getEmailEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_email();
		return retorno;
	}

	public String getEstadoEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_estado();
		return retorno;
	}

	public String getCodigoJefeEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_jefe_codigo();
		return retorno;
	}

	public String getSociedadEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getEmp_sociedad();
		return retorno;
	}

	public String getDescripcionSociedadEmpleado() {
		String retorno = null;
		if (getUsuarioActual() != null)
			retorno = getUsuarioActual().getNombre_sociedad();
		return retorno;
	}

	public static void main(String[] args) {

		AutenticacionAutorizacion autenticacion = new AutenticacionAutorizacion();
		// autenticacion.autenticar("usuario", "kaira");
		// autenticacion.autenticar("dsalcedo", "juanandres", 2);
		// autenticacion.autenticar("dncasi13", "password", 1);
		// autenticacion.autenticarPrueba("dsalcedo", "juanandres", 2);
		// autenticacion.validarUsuarioPrueba("dnxapr02", "my4ng3l2", 1);
		autenticacion.validarUsuarioPrueba("dncasi21", "facilcon", 1);
		// autenticacion.validarUsuarioPrueba("dncaom07", "asda", 1);

	}

	public void pintarDatosMenu(UserVo userVo) {

		Application[] applications = userVo.getApplications();

		//System.out.println("-----APLICACIONES-----");
		for (int i = 0; i < applications.length; i++) {
			Application application = applications[i];
			//System.out.println("application.getName: " + application.getName());
			Role[] roles = application.getRoles();
			//System.out.println("	-----ROLES-----");
			for (int j = 0; j < roles.length; j++) {
				Role role = roles[j];
				//System.out.println("	role.getName: " + role.getName());
				Section[] sections = role.getSections();
				//System.out.println("		-----SECTIONS-----");
				if (sections != null)
					for (int k = 0; k < sections.length; k++) {
						Section section = sections[k];
						/*System.out.println("			section.getName: ["
								+ section.getName() + "]");*/
						String[] actions = section.getActions();
						//System.out.println("			-----ACTIONS-----");
						for (int l = 0; l < actions.length; l++) {
							String action = actions[l];
							//System.out.println("				action: " + action);
						}
						//System.out.println("			-----END ACTIONS-----");
					}
				//System.out.println("		-----END SECTIONS-----");

			}
			//System.out.println("	-----END ROLES-----");
		}
	}

	public void autenticarPrueba(String login, String password, int directorio) {

		String str = ProjectUtils.getWebServiceUrl(); // "http://192.1.2.26:9092/axis2/services/Caas";
		try {
			stub = new CaasStub(str);
		} catch (AxisFault e) {
		} catch (Exception e) {
		}
		val = new ValidateUser();
		val.setUserName(login);
		val.setPassword(password);

		val.setDirectory(directorio);
		//
		ValidateUserResponse vures = null;
		try {
			vures = stub.validateUser(val);
		} catch (RemoteException e) {
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		setUsuario(vures.get_return());

		//

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	/*
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

	// //////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean renderSectionAdministrador = false;

	private boolean renderSectionProveedor = false;

	private boolean renderSectionAuxiliarCompras = false;

	
	private boolean renderSectionConsultas = false;

	private boolean renderSectionAdministracion = false;

	private boolean renderSectionProceso = false;

	private boolean renderSectionConsulta = false;
	
	// //////////////////////////////////////////////////////////////////////////////////////////////////
	// Administracion
	private boolean renderReasignarEvaluacion = false;

	private boolean renderActualizarPlantilla = false;

	//Proceso
	private boolean renderCorreccionEvaluacion = false;

	private boolean renderRegistroProveedor = false;

	private boolean renderEvaluarProveedor = false;

	private boolean renderAsignarClave = false;

	// //Consultas
	private boolean renderListadoProveedores = false;

	private boolean renderHistoricoProveedor = false;
	private boolean renderFormularioProveedor = false;
	// /////////////////--------------------------------------
	//Sesiones  Perfiles
	private String sectionProveedorProceso;
	
	private String sectionAdmistradorAdministracion;

	private String sectionAdmisntradorConsultas;
	
	private String sectionAuxiliarProceso;
	
	private String sectionAuxiliarConsultas;

	private String sectionConsultaConsultas;

	// Sesiones
	
	private String sectionProceso;
	
	private String sectionAdministracion;

	private String sectionConsultas;	


	public boolean isRenderSectionAdministrador() {
		return renderSectionAdministrador;
	}

	public void setRenderSectionAdministrador(boolean renderSectionAdministrador) {
		this.renderSectionAdministrador = renderSectionAdministrador;
	}

	public boolean isRenderSectionProveedor() {
		return renderSectionProveedor;
	}

	public void setRenderSectionProveedor(boolean renderSectionProveedor) {
		this.renderSectionProveedor = renderSectionProveedor;
	}

	public boolean isRenderSectionAuxiliarCompras() {
		return renderSectionAuxiliarCompras;
	}

	public void setRenderSectionAuxiliarCompras(boolean renderSectionAuxiliarCompras) {
		this.renderSectionAuxiliarCompras = renderSectionAuxiliarCompras;
	}

	public boolean isRenderSectionConsultas() {
		return renderSectionConsultas;
	}

	public void setRenderSectionConsultas(boolean renderSectionConsultas) {
		this.renderSectionConsultas = renderSectionConsultas;
	}

	public boolean isRenderReasignarEvaluacion() {
		return renderReasignarEvaluacion;
	}

	public void setRenderReasignarEvaluacion(boolean renderReasignarEvaluacion) {
		this.renderReasignarEvaluacion = renderReasignarEvaluacion;
	}

	public boolean isRenderActualizarPlantilla() {
		return renderActualizarPlantilla;
	}

	public void setRenderActualizarPlantilla(boolean renderActualizarPlantilla) {
		this.renderActualizarPlantilla = renderActualizarPlantilla;
	}

	public boolean isRenderCorreccionEvaluacion() {
		return renderCorreccionEvaluacion;
	}

	public void setRenderCorreccionEvaluacion(boolean renderCorreccionEvaluacion) {
		this.renderCorreccionEvaluacion = renderCorreccionEvaluacion;
	}

	public boolean isRenderRegistroProveedor() {
		return renderRegistroProveedor;
	}

	public void setRenderRegistroProveedor(boolean renderRegistroProveedor) {
		this.renderRegistroProveedor = renderRegistroProveedor;
	}

	public boolean isRenderEvaluarProveedor() {
		return renderEvaluarProveedor;
	}

	public void setRenderEvaluarProveedor(boolean renderEvaluarProveedor) {
		this.renderEvaluarProveedor = renderEvaluarProveedor;
	}

	public boolean isRenderAsignarClave() {
		return renderAsignarClave;
	}

	public void setRenderAsignarClave(boolean renderAsignarClave) {
		this.renderAsignarClave = renderAsignarClave;
	}

	public boolean isRenderListadoProveedores() {
		return renderListadoProveedores;
	}

	public void setRenderListadoProveedores(boolean renderListadoProveedores) {
		this.renderListadoProveedores = renderListadoProveedores;
	}

	public boolean isRenderHistoricoProveedor() {
		return renderHistoricoProveedor;
	}

	public void setRenderHistoricoProveedor(boolean renderHistoricoProveedor) {
		this.renderHistoricoProveedor = renderHistoricoProveedor;
	}

	public String getSectionAdmistradorAdministracion() {
		return sectionAdmistradorAdministracion;
	}

	public void setSectionAdmistradorAdministracion(
			String sectionAdmistradorAdministracion) {
		this.sectionAdmistradorAdministracion = sectionAdmistradorAdministracion;
	}


	public String getSectionAdmisntradorConsultas() {
		return sectionAdmisntradorConsultas;
	}

	public void setSectionAdmisntradorConsultas(String sectionAdmisntradorConsultas) {
		this.sectionAdmisntradorConsultas = sectionAdmisntradorConsultas;
	}


	public String getSectionProveedorProceso() {
		return sectionProveedorProceso;
	}

	public void setSectionProveedorProceso(String sectionProveedorProceso) {
		this.sectionProveedorProceso = sectionProveedorProceso;
	}

	public String getSectionAuxiliarProceso() {
		return sectionAuxiliarProceso;
	}

	public void setSectionAuxiliarProceso(String sectionAuxiliarProceso) {
		this.sectionAuxiliarProceso = sectionAuxiliarProceso;
	}

	public String getSectionAuxiliarConsultas() {
		return sectionAuxiliarConsultas;
	}

	public void setSectionAuxiliarConsultas(String sectionAuxiliarConsultas) {
		this.sectionAuxiliarConsultas = sectionAuxiliarConsultas;
	}


	public String getSectionConsultaConsultas() {
		return sectionConsultaConsultas;
	}

	public void setSectionConsultaConsultas(String sectionConsultaConsultas) {
		this.sectionConsultaConsultas = sectionConsultaConsultas;
	}

	public boolean isRenderSectionAdministracion() {
		return renderSectionAdministracion;
	}

	public void setRenderSectionAdministracion(boolean renderSectionAdministracion) {
		this.renderSectionAdministracion = renderSectionAdministracion;
	}

	public boolean isRenderSectionProceso() {
		return renderSectionProceso;
	}

	public void setRenderSectionProceso(boolean renderSectionProceso) {
		this.renderSectionProceso = renderSectionProceso;
	}

	public boolean isRenderSectionConsulta() {
		return renderSectionConsulta;
	}

	public void setRenderSectionConsulta(boolean renderSectionConsulta) {
		this.renderSectionConsulta = renderSectionConsulta;
	}

	public String getSectionProceso() {
		return sectionProceso;
	}

	public void setSectionProceso(String sectionProceso) {
		this.sectionProceso = sectionProceso;
	}

	public String getSectionAdministracion() {
		return sectionAdministracion;
	}

	public void setSectionAdministracion(String sectionAdministracion) {
		this.sectionAdministracion = sectionAdministracion;
	}

	public String getSectionConsultas() {
		return sectionConsultas;
	}

	public void setSectionConsultas(String sectionConsultas) {
		this.sectionConsultas = sectionConsultas;
	}

	public boolean isRenderFormularioProveedor() {
		return renderFormularioProveedor;
	}

	public void setRenderFormularioProveedor(boolean renderFormularioProveedor) {
		this.renderFormularioProveedor = renderFormularioProveedor;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}	




}

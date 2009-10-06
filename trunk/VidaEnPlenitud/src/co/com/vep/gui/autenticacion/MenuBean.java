package co.com.vep.gui.autenticacion;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.coomeva.modelo.AutenticacionAutorizacion;
import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.coomeva.profile.ws.client.CaasStub.Section;
import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.LoaderResourceElements;
import co.com.vep.util.StringUtils;

import com.icesoft.faces.component.menubar.MenuItem;
import com.icesoft.faces.context.effects.Effect;
import com.icesoft.faces.context.effects.Highlight;

public class MenuBean {

	private static LoaderResourceElements loaderReourceElements = LoaderResourceElements
			.getInstance();
	private UserVo usuario;

	public MenuBean() {
		valueChangeEffect = new Highlight("#fda505");
		valueChangeEffect.setFired(true);
	}

	private List menuModel;
	private String roleEnSession;

	public void obtenerDatos() throws Exception {
		try {
			LoginView sessions = (LoginView) FacesUtils
					.getManagedBean("loginView");
			usuario = sessions.getUsuarioVo();
			if (usuario == null)
				throw new Exception("Objeto USUARIO no existe");

			menuModel = new ArrayList();

			roleEnSession = ((Role) Session
					.getSessionAttribute("Role")).getName();

			Section[] sections = (Section[]) FacesUtils.getSession()
					.getAttribute("Section");
			if (sections != null)
				for (int k = 0; k < sections.length; k++) {
					Section section = sections[k];

					MenuItem item = new MenuItem();
					item.setValue(sections[k].getName());
					menuModel.add(item);

					String[] actions = section.getActions();
					for (int jj = 0; jj < actions.length; jj++) {
						MenuItem hijo = new MenuItem();
						hijo.setValue(actions[jj]);
						System.out.println("#{menuBar."
								+ StringUtils.clean(actions[jj]));
						hijo.setAction(FacesContext.getCurrentInstance()
								.getApplication().createMethodBinding(
										"#{menuBar."
												+ StringUtils
														.clean(actions[jj])
												+ "}", new Class[] {}));
						item.getChildren().add(hijo);
					}

				}

			MenuItem inicio = new MenuItem();
			inicio.setValue("Cerrar Sesion");
			inicio.setAction(FacesContext.getCurrentInstance().getApplication()
					.createMethodBinding("#{menuBar.cerrarSession}",
							new Class[] {}));

			menuModel.add(inicio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AutenticacionAutorizacion autenticacion = new AutenticacionAutorizacion();
	private AutenticacionAutorizacion usuarioSesion = null;

	public AutenticacionAutorizacion getUsuarioSesion() {

		usuarioSesion = (AutenticacionAutorizacion) FacesUtils.getSession()
				.getAttribute("autenticacion");
		return usuarioSesion;
	}

	public List getListaModulosMenu() {
		List objects = getUsuarioSesion().listarModulosMenu();
		return objects;
	}

	/**
	 * * Resets the valueChange effect to fire when the current response * is
	 * completed. 72: * 73: *
	 * 
	 * @param event
	 *            jsf action event 74:
	 */
	public void effectChangeListener(javax.faces.event.ValueChangeEvent event) {
		valueChangeEffect.setFired(false);
	}

	// records which menu item fired the event
	private String actionFired;

	// records the param value for the menu item which fired the event
	private String param;

	// orientation of the menubar ("Horizontal" or "Vertical")
	private String orientation = "Horizontal";

	// effect that shows a value binding chance on there server
	protected Effect valueChangeEffect;

	// propiedades para los modulos del menú
	private boolean renderModAdministracion;
	private boolean renderModProceso;
	private boolean renderModConsulta;

	// propiedades para las opciones del menú

	/**
	 * Get the param value for the menu item which fired the event.
	 * 
	 * @return the param value
	 */
	public String getParam() {
		return param;
	}

	/**
	 * Set the param value.
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * Get the modified ID of the fired action.
	 * 
	 * @return the modified ID
	 */
	public String getActionFired() {
		return actionFired;
	}

	/**
	 * Identify the ID of the element that fired the event and return it in a
	 * form suitable for display.
	 * 
	 * @param e
	 *            the event that fired the listener
	 */

	public String IngresarValoracion() {
		String paginaRetorno = "irIngValoracion";
		return paginaRetorno;
	}

	public String ConsultarInscripcion() {		
		String paginaRetorno = "irConsultarInscripcion";
		return paginaRetorno;
	}

	public String IngresarAsociado() {
		String paginaRetorno = "irIngresarAsociado";
		return paginaRetorno;
	}

	public String ConsultarCumpleanos() {
		String paginaRetorno = "irConsultarCumpleanos";
		return paginaRetorno;
	}

	public String RegistrarUsuario() {
		String paginaRetorno = "irIngresarUsuario";
		return paginaRetorno;
	}

	public String IngresarProfesor() {
		String paginaRetorno = "irIngresarProfesor";
		return paginaRetorno;
	}

	public String IngresarSitioPractica() {
		String paginaRetorno = "irIngresarSitioPractica";
		return paginaRetorno;
	}

	public String IngresarActividad() {
		String paginaRetorno = "irIngresarActividad";
		return paginaRetorno;
	}

	public String InscribirActividad() {
		String paginaRetorno = "irInscribirActividad";
		return paginaRetorno;
	}

	public String ProgramarActividad() {
		String paginaRetorno = "irProgramarActividad";
		return paginaRetorno;
	}

	public String ConsultarActividadesFrecuentadas() {
		String paginaRetorno = "irConsActiFrecuentadas";
		return paginaRetorno;
	}

	public String ConsultarActividadesPeriodo() {
		String paginaRetorno = "irConsulActiPeriodo";
		return paginaRetorno;
	}

	public String CrearAsesoria() {
		String paginaRetorno = "irIngAsesoria";
		return paginaRetorno;
	}

	public String ConsultarAsesoria() {
		String paginaRetorno = "irConsAsesoria";
		return paginaRetorno;
	}

	public String SeguimientoAsesoria() {
		String paginaRetorno = "irIngSeguimiento";
		return paginaRetorno;
	}

	public String Consultarexpertos() {
		String paginaRetorno = "irConsultarExpertos";
		return paginaRetorno;
	}
	
	public String ConsultarAsistencia() {
		String paginaRetorno = "irGrabarAsistencia";
		return paginaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public String cerrarSession() {

		((LoginView) FacesUtils.getManagedBean("loginView")).setTxtLogin("");
		((LoginView) FacesUtils.getManagedBean("loginView")).setTxtPassword("");

		FacesUtils.getSession().invalidate();

		String paginaRetorno = "irInicio";
		return paginaRetorno;

	}

	/**
	 * Get the orientation of the menu ("horizontal" or "vertical")
	 * 
	 * @return the orientation of the menu
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * Set the orientation of the menu ("horizontal" or "vertical").
	 * 
	 * @param orientation
	 *            the new orientation of the menu
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Effect getValueChangeEffect() {
		return valueChangeEffect;
	}

	public void setValueChangeEffect(Effect valueChangeEffect) {
		this.valueChangeEffect = valueChangeEffect;
	}

	public List getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(List menuModel) {
		this.menuModel = menuModel;
	}

	public String getRoleEnSession() {
		return roleEnSession;
	}

	public void setRoleEnSession(String roleEnSession) {
		this.roleEnSession = roleEnSession;
	}

}

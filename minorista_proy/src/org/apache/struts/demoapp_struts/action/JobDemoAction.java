package org.apache.struts.demoapp_struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.demoapp_struts.model.CustomEventsManager;
import org.apache.struts.demoapp_struts.model.User;
import org.apache.struts2.ServletActionContext;

import pro.vet.DAO.user_DAO;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.controls.DHXExternalLightboxForm;
import com.dhtmlx.planner.controls.DHXLightboxSelect;
import com.dhtmlx.planner.controls.DHXLocalization;
import com.dhtmlx.planner.controls.DHXMiniCalendar;
import com.dhtmlx.planner.controls.DHXTimelineView;
import com.dhtmlx.planner.controls.DHXUnitsView;
import com.dhtmlx.planner.controls.DHXTimelineView.RenderModes;
import com.dhtmlx.planner.controls.DHXTimelineView.XScaleUnits;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;
import com.opensymphony.xwork2.ActionSupport;

public class JobDemoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<User> users;
	private Boolean employee;
	private String username;
	private String userid;
	private String planner;
	private String events;
	
	public List<User> getUsers() {
		return users;
	}
	public Boolean getEmployee() {
		return employee;
	}
	public String getUsername() {
		return username;
	}
	public String getUserid() {
		return userid;
	}
	public String getPlanner() {
		return planner;
	}
	public String getEvents() {
		return events;
	}

	public String javaplanner() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("email") == null) {
			//return ERROR;
		}

		DHXPlanner planner = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
    	planner.setInitialDate(2013, 7, 15);
    	planner.setInitialView("units");
    	planner.config.setScrollHour(8);
    	planner.setWidth(844);
    	planner.setHeight(518);
    	planner.load("events", DHXDataFormat.JSON);
    	planner.data.dataprocessor.setURL("events");
    	planner.config.setDetailsOnCreate(true);
    	planner.config.setFirstHour(10);
    	planner.config.setLastHour(20);
    	planner.extensions.add(DHXExtension.TOOLTIP);

    	planner.localizations.set(DHXLocalization.Spanish);
    	// create units view
    	DHXUnitsView units = new DHXUnitsView("units", "user", "Units");
    	units.setServerListLink("users");
    	units.setSkipIncorrect(true);
    	planner.views.add(units);

    	// create timeline view
    	DHXTimelineView timeline = new DHXTimelineView("timeline", "user", "Timeline");
    	timeline.setRenderMode(RenderModes.BAR);
    	timeline.setXScaleUnit(XScaleUnits.MINUTE);
        timeline.setXStep(30);
        timeline.setXSize(18);
        timeline.setXStart(20);
        timeline.setXLength(48);
    	timeline.setServerList("users");
    	planner.views.add(timeline);

    	
		// adds sections in lightbox
    	DHXLightboxSelect sel = new DHXLightboxSelect("user", "Owner");
    	sel.setServerList("users");
    	planner.lightbox.add(sel);
    	
    	DHXLightboxSelect sel2 = new DHXLightboxSelect("user", "Ownerff");
    	sel.setServerList("users");
    	planner.lightbox.add(sel2);

    	DHXLightboxSelect status = new DHXLightboxSelect("status", "Status");
    	status.setServerList("status");
    	planner.lightbox.add(status);

    	DHXLightboxSelect urgency = new DHXLightboxSelect("urgency", "Urgency");
    	urgency.setServerList("urgency");
    	planner.lightbox.add(urgency);

    	// creates mini-calendar
    	DHXMiniCalendar cal = new DHXMiniCalendar("minical");
    	cal.setNavigation(true);
    	planner.calendars.add(cal);
    	
       	users = (new CustomEventsManager(request)).getUsers();
    	
    	employee = false;// !session.getAttribute("type").toString().equals("manager");
    	username = users.get(0).getName();
    	userid = users.get(0).getId().toString();
    	
    	this.planner = planner.render();
		return SUCCESS;
	}
	
 

	public String events() throws Exception {
		System.out.println("entro a evnet");
		CustomEventsManager evs = new CustomEventsManager(ServletActionContext.getRequest());
		events = evs.run();		
		return SUCCESS;
	}

	public String login() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		if (session.getAttribute("email") != null)
			return LOGIN;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//if (email == null || password == null)
			//return SUCCESS;

		//Session s = HibernateUtil.getSessionFactory().openSession();
		user_DAO dao=new user_DAO();    	
		List<User> users = dao.listar_usuarios();
			/*s.createCriteria(User.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password))
				.list();
         */
		if (users.size() == 0)
			return ERROR;

		session.setAttribute("id", users.get(0).getId());
		session.setAttribute("email", users.get(0).getEmail());
		session.setAttribute("name", users.get(0).getName());
		session.setAttribute("type", users.get(0).getType());
		return LOGIN;
	}

	public String logout() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		session.removeAttribute("id");
		session.removeAttribute("email");
		session.removeAttribute("name");
		session.removeAttribute("type");
		return SUCCESS;
	}
}
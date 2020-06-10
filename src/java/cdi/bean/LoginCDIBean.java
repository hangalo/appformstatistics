/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.bean;

import dao.StatisticaDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import jdbcutil.DateUtil;
import jdbcutil.SessionUtils;
import model.Circoscrizioni;
import model.StatisticaOrdinis;
import model.User;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author informatica
 */
@Named(value = "loginCDIBean")
@SessionScoped
public class LoginCDIBean implements Serializable {

    @Inject
    private UserLoged userLoged;
    private User user = new User();
    private String unsername, password;

    private Date date;

    private Circoscrizioni circoscrizioni = new Circoscrizioni();
    private List<StatisticaOrdinis> statisticaOrdinisCircoscrizionis = new ArrayList<>();
    private List<StatisticaOrdinis> statisticaOrdinisCircoscrizionisByYears = new ArrayList<>();
    boolean valid = false;
    UserDAO userDAO = new UserDAO();
    StatisticaDAO statisticaDAO = new StatisticaDAO();

    public UserLoged getUserLoged() {
        return userLoged;
    }

    public void setUserLoged(UserLoged userLoged) {
        this.userLoged = userLoged;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUnsername() {
        return unsername;
    }

    public void setUnsername(String unsername) {
        this.unsername = unsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Circoscrizioni getCircoscrizioni() {
        return circoscrizioni;
    }

    public void setCircoscrizioni(Circoscrizioni circoscrizioni) {
        this.circoscrizioni = circoscrizioni;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void onDateSelect(SelectEvent<Date> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
        Date dt = (Date) event.getObject();

        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent component = view.findComponent(":form:tabViewData:circo");
       Integer idCircoscrizione = Integer.parseInt(component.getAttributes().get("value").toString());
        statisticaOrdinisCircoscrizionisByYears = statisticaDAO.findByAnno(DateUtil.getYearOfDate(dt));
     statisticaOrdinisCircoscrizionisByYears = statisticaDAO.findByAnnoCircoDomicilio(DateUtil.getYearOfDate(dt), idCircoscrizione);

        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Anno >>>", DateUtil.getYearOfDate(dt).toString()));
     facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ID Circoscrizon >>>", String.valueOf(idCircoscrizione)));
       /// facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ID CircoscrizonHTML >>>", String.valueOf(component)));
    }

    public List<StatisticaOrdinis> getStatisticaOrdinisCircoscrizionisByYears() {
        return statisticaOrdinisCircoscrizionisByYears;
    }

    public void setStatisticaOrdinisCircoscrizionisByYears(List<StatisticaOrdinis> statisticaOrdinisCircoscrizionisByYears) {
        this.statisticaOrdinisCircoscrizionisByYears = statisticaOrdinisCircoscrizionisByYears;
    }

    public String validateUsernamePassword() {
        System.out.println(">>>>>>>>>>>>>>USER"+unsername +">>>>>>>>>>>>>>>>PASS"+password);
        boolean valid = userDAO.validate(unsername, password);

        if (valid) {
            user = userDAO.findUser(unsername, password);

            statisticaOrdinisCircoscrizionis = statisticaDAO.findByCircoDomicilio(user.getCircoscrizioni().getIdCircoscrizione());
            userLoged.setUser(user);
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "home";

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }

    }

    public String validateUsernamePassword2() {

        boolean valid = userDAO.validate(unsername, password);

        if (valid) {
            user = userDAO.findUser(unsername, password);

            if (user.getCircoscrizioni().getIdCircoscrizione().equals(circoscrizioni.getIdCircoscrizione())) {

                statisticaOrdinisCircoscrizionis = statisticaDAO.findByCircoDomicilio(user.getCircoscrizioni().getIdCircoscrizione());
                userLoged.setUser(user);
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", user);
                return "home";
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect Circoscrizione",
                                "Please enter correct Circoscrizione"));
                return "login";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }

    }

    public void logout2() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }

    public List<StatisticaOrdinis> getStatisticaOrdinisCircoscrizionis() {
        return statisticaOrdinisCircoscrizionis;
    }

    public void setStatisticaOrdinisCircoscrizionis(List<StatisticaOrdinis> statisticaOrdinisCircoscrizionis) {
        this.statisticaOrdinisCircoscrizionis = statisticaOrdinisCircoscrizionis;
    }

}

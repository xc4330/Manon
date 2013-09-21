/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import session.common.MailerBean;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import entity.common.CustomerEntity;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import session.common.MemberSessionBeanLocal;
/**
 *
 * @author apple
 */
@ManagedBean(name="userAccountManagementBean")
@RequestScoped
public class UserAccountManagementBean {
private static final Logger logger = Logger.getLogger(
                "managedbean.UserAccountManagedBean");
    @EJB
    protected MailerBean mailerBean;
    private String userName;
    private String password;
    private String email;
    @EJB
    private MemberSessionBeanLocal memberSessionBeanLocal;
    

    public UserAccountManagementBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String doLogin() {
        System.out.println("doLLLLLLLLLLLLLLLLLLOGIN and email is "+email+"  "+password+"and ");
        if(memberSessionBeanLocal.verifyMember(email,password)){ 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You are successfully login"));
            return"memberHome.xhtml";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sorry your username and password do not match"));
            return "index.xhtml";
        }

    }
    
    public String doRegister(){
       System.out.println("useraccount managementbean line 69");
       if(!email.contains("@")){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sorry you did not input a valid email address"));
           return "index.xhtml";
       }
        if(memberSessionBeanLocal.registerMember(email, password, userName)){
            System.out.println("useraccount managementbean line 75");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Good"));
            System.out.println("mmb lin 91");

            mailerBean.sendConfirmationMessage(email);
            System.out.println("mmb line 96");
            return "index.xhtml";
        }
        else{
            System.out.println("useraccount managementbean line 76");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sorry"));
            return "index.xhtml";
        }
    }
}

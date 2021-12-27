package in.co.rays.ors.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.RoleBean;
import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.exception.RecordNotFoundException;
import in.co.rays.ors.model.UserModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;


/**
 * User registration functionality Controller. Performs operation for User
 * Registration
 * 
 * @author Tanvi
 * @Version:(4.14.0)
 */
@ WebServlet(name="UserRegistrationCtl",urlPatterns={"/UserRegistrationCtl"})
public class UserRegistrationCtl extends BaseCtl {

    public static final String OP_SIGN_UP = "SignUp";

    private static Logger log = Logger.getLogger(UserRegistrationCtl.class);

    @Override
    protected boolean validate(HttpServletRequest request) {

        log.debug("UserRegistrationCtl Method validate Started");

        boolean pass = true;

        String login = request.getParameter("login");
        String dob = request.getParameter("dob");

        if (DataValidator.isNull(request.getParameter("firstName"))) {
            request.setAttribute("firstName", PropertyReader.getValue("error.require", "First Name"));
            pass = false;
        }else if (!DataValidator.isValidName(request.getParameter("firstName"))) {
        	request.setAttribute("firstName", PropertyReader.getValue("error.name", "Invalid First") );
			pass = false;
		}
        
        if (DataValidator.isNull(request.getParameter("lastName"))) {
            request.setAttribute("lastName", PropertyReader.getValue("error.require", "Last Name"));
            pass = false;
        }else if (!DataValidator.isValidName(request.getParameter("lastName"))) {
        	request.setAttribute("lastName", PropertyReader.getValue("error.name", "Invlid Last") );
			pass = false;
        }
        
        if (DataValidator.isNull(login)) {
            request.setAttribute("login", PropertyReader.getValue("error.require", "Login Id"));
            pass = false;
        } else if (!DataValidator.isEmail(login)) {
            request.setAttribute("login", PropertyReader.getValue("error.email", "Invalid "));
            pass = false;
        }
        
        if (DataValidator.isNull(request.getParameter("mobileNo"))) {
        	request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "Mobile No"));
        	pass = false;
		}  else if (!DataValidator.isMobileNo(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", "Mobile No. contain 10 Digits & Series start with 6-9");
			pass = false;
		}
        
        if (DataValidator.isNull(request.getParameter("password"))) {
            request.setAttribute("password", PropertyReader.getValue("error.require", "Password"));
            pass = false;
        }else if (!DataValidator.isPassword(request.getParameter("password"))) {
        	request.setAttribute("password", "Password contain 8 letters with alpha-numeric & special Character");
        	pass = false;
        }
        if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
            request.setAttribute("confirmPassword", PropertyReader.getValue("error.require", "Confirm Password"));
            pass = false;
        }
        
        if (DataValidator.isNull(request.getParameter("gender"))) {
            request.setAttribute("gender",PropertyReader.getValue("error.require", "Gender"));
            pass = false;
        }
        if (DataValidator.isNull(dob)) {
            request.setAttribute("dob",PropertyReader.getValue("error.require", "Date Of Birth"));
            pass = false;
        } /*else if (!DataValidator.isDate(dob)) {
        	request.setAttribute("dob", PropertyReader.getValue("error.date", "Date Of Birth"));
            pass = false;
        }*/else if (!DataValidator.isvalidateAge(dob)) {
            request.setAttribute("dob", PropertyReader.getValue("error.require", "Minimum Age 18 year"));
            pass = false;
        }
        if (!request.getParameter("password").equals( request.getParameter("confirmPassword")) && !"".equals(request.getParameter("confirmPassword"))) 
        {
            request.setAttribute("confirmPassword", PropertyReader.getValue("error.confirmpassword", "Password and Confirm Password"));
            pass = false;
        }
        log.debug("UserRegistrationCtl Method validate Ended");

        return pass;
    }

    @Override
    protected BaseBean populateBean(HttpServletRequest request) {

        log.debug("UserRegistrationCtl Method populatebean Started");

        UserBean bean = new UserBean();

        bean.setRoleId(RoleBean.STUDENT);

        bean.setId(DataUtility.getLong(request.getParameter("id")));
        bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
        bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
        bean.setLogin(DataUtility.getString(request.getParameter("login")));
        bean.setPassword(DataUtility.getString(request.getParameter("password")));
        bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
        bean.setGender(DataUtility.getString(request.getParameter("gender")));
        bean.setDob(DataUtility.getDate(request.getParameter("dob")));
        bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
System.out.println("-------------------"+request.getParameter("dob"));
       
	populateDTO(bean, request);
        log.debug("UserRegistrationCtl Method populatebean Ended");
        return bean;
    }

    /**
     * Contains Display logics
     */

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("UserRegistrationCtl Method doGet Started");
        ServletUtility.forward(getView(), request, response);

    }

    /**
     * Contains Submit logics
     */

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {      
        log.debug("UserRegistrationCtl Method doPost Started");
        
        String op = DataUtility.getString(request.getParameter("operation"));
        
//get model
        UserModel model = new UserModel();
//        long id = DataUtility.getLong(request.getParameter("id"));
        
        if (OP_SIGN_UP.equalsIgnoreCase(op)) {
            UserBean bean = (UserBean) populateBean(request);
            try {
                long pk = model.registerUser(bean);
              
                bean.setId(pk);
          //      request.getSession().setAttribute("UserBean", bean);
                ServletUtility.setSuccessMessage("User Successfully Register", request);
                ServletUtility.forward(getView(), request, response);
                return;
            } catch (ApplicationException e) {
            	e.printStackTrace();
                log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            } catch (DuplicateRecordException e) {
                log.error(e);
                ServletUtility.setBean(bean, request);
                ServletUtility.setErrorMessage("Login Id Already Exists",request);
                ServletUtility.forward(getView(), request, response);
            } 
			 catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);
		}
        
        log.debug("UserRegistrationCtl Method doPost Ended");
    }

    @Override
    protected String getView() {
        return ORSView.USER_REGISTRATION_VIEW;
    }

}
package in.co.rays.ors.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.RecordNotFoundException;
import in.co.rays.ors.model.UserModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;
/**
 * Forget Password functionality Controller. Performs operation for Forget
 * Password
 * 
 * @author Tanvi
 * @Version:(4.14.0)
 */
@ WebServlet(name="ForgetPasswordCtl",urlPatterns={"/ForgetPasswordCtl"})
public class ForgetPasswordCtl extends BaseCtl {

    private static Logger log = Logger.getLogger(ForgetPasswordCtl.class);

    @Override
    protected boolean validate(HttpServletRequest request) {

        log.debug("ForgetPasswordCtl Method validate Started");

        boolean pass = true;

        String login = request.getParameter("login");

        if (DataValidator.isNull(login)) {
            request.setAttribute("login",
                    PropertyReader.getValue("error.require", "Email Id"));
            pass = false;
        } else if (!DataValidator.isEmail(login)) {
            request.setAttribute("login",
                    PropertyReader.getValue("error.email", "Invalid"));
            pass = false;
        }
        log.debug("ForgetPasswordCtl Method validate Ended");

        return pass;
    }

    @Override
    protected BaseBean populateBean(HttpServletRequest request) {

        log.debug("ForgetPasswordCtl Method populatebean Started");

        UserBean bean = new UserBean();

        bean.setLogin(DataUtility.getString(request.getParameter("login")));

        log.debug("ForgetPasswordCtl Method populatebean Ended");

        return bean;
    }
    /**
     * Contains Display logics
     */

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("ForgetPasswordCtl Method doGet Started");

        ServletUtility.forward(getView(), request, response);

    }
    /**
     * Contains Submit logics
     */

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("ForgetPasswordCtl Method doPost Started");

        String op = DataUtility.getString(request.getParameter("operation"));
        UserBean bean = (UserBean) populateBean(request);

// get model
        UserModel model = new UserModel();

        if (OP_GO.equalsIgnoreCase(op)) {
            try {
                model.forgetPassword(bean.getLogin());
                ServletUtility.setSuccessMessage("Password has been sent to your email id.", request);
            } catch (RecordNotFoundException e) {
                ServletUtility.setErrorMessage(e.getMessage(), request);
                log.error(e);
            } catch (ApplicationException e) {
            	e.printStackTrace();
            	log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            }
        }
            else if (OP_RESET.equalsIgnoreCase(op)) {
            	
            	ServletUtility.redirect(ORSView.FORGET_PASSWORD_CTL, request, response);
            	return;
			}
            ServletUtility.forward(getView(), request, response);
            

        log.debug("ForgetPasswordCtl Method doPost Ended");
    }

    @Override
    protected String getView() {
        return ORSView.FORGET_PASSWORD_VIEW;
    }

}
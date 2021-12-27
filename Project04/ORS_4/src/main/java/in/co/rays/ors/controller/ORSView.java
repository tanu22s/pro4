package in.co.rays.ors.controller;

/**
 * Contains ORS View and Controller URI
 * 
 * @author Tanvi
 * @Version:(4.14.0)

 */

public interface ORSView {

    public String APP_CONTEXT = "/ORS_4";

//    public String LAYOUT_VIEW = "/BaseLayout.jsp";
    public String PAGE_FOLDER = "/jsp";

    public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";
  
    public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
    public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
    public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";    
    public String COURSE_VIEW = PAGE_FOLDER +"/CourseView.jsp";
    public String COURSE_LIST_VIEW = PAGE_FOLDER +"/CourseListView.jsp";
    public String ERROR_VIEW = PAGE_FOLDER + "/ErrorView.jsp";
 //   public String ERROR_VIEW5 = PAGE_FOLDER + "/ErrorView5.jsp";
    
    public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
    public String FACULTY_VIEW = PAGE_FOLDER +"/FacultyView.jsp";
    public String FACULTY_LIST_VIEW = PAGE_FOLDER +"/FacultyListView.jsp";
    public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
    public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";    
    public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
    public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";
    public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";
    public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
    public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
    public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
    public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
    public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
    public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
    public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
    public String TIMETABLE_VIEW = PAGE_FOLDER + "/TimeTableView.jsp";
    public String TIMETABLE_LIST_VIEW = PAGE_FOLDER + "/TimeTableListView.jsp";
    public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
    public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
    public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
    public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";    
    
    
    
    
    public String ERROR_CTL = APP_CONTEXT + "/ErrorCtl";

    public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
    public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
    public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
    public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
    public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
    public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
    public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
    public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";    
    public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
    public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
    public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
    public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
    public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";
    public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
    public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
    public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
    public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
    public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
    public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
    public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
    public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
    public String TIMETABLE_CTL = APP_CONTEXT + "/ctl/TimeTableCtl";
    public String TIMETABLE_LIST_CTL = APP_CONTEXT + "/ctl/TimeTableListCtl";
    public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
    public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
    public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
    public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
}

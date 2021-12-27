package in.co.rays.ors.bean;

import java.util.Date;

/**
 * Faculty JavaBean encapsulates Faculty attributes
 * 
 * @author Tanvi
 * @Version:(4.14.0)
 * 
 */
public class FacultyBean extends BaseBean {

 
	private String firstName;

   
	private String lastName;

    
	private String Gender;

    
	private String EmailId;
	
	
	private String mobileno;
	
	
	private long collegeid;
   
	private String collegeName;

  
	private long courseId;

   
	private String courseName;

	
	private Date Dob;
 

	private long subjectId;

	private String subjectName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String EmailId) {
		this.EmailId = EmailId;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public long getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(long collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dOB) {
		Dob = dOB;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


    public String getKey() {
        return id + "";
    }

   
    public String getValue() {
        return firstName +""+ lastName;
    }
}

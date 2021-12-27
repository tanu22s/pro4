package in.co.rays.ors.bean;

/**
 * Role JavaBean encapsulates Role attributes
 * 
 * @author Tanvi
 * @Version:(4.14.0)
 */

public class RoleBean extends BaseBean {

    /**
     * Predefined Role constants
     */
    public static final int ADMIN = 1;
    public static final int STUDENT = 2;
    public static final int COLLEGE = 3;
    public static final int FACULTY = 4;
    public static final int KIOSK = 5;

    /**
     * Role Name
     */

    private String name;

    /**
     * Role Description
     */
    private String description;

    /**
     * accessor
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return id + "";
    }

    public String getValue() {
        return name;
    }

}

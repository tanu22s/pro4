package in.co.rays.ors.exception;

/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
* 
 * @author Tanvi
 * @Version:(4.14.0)
 */

public class DatabaseException extends Exception {

    /**
     * @param msg
     *            : Error message
     */
    public DatabaseException(String msg) {
        super(msg);
    }
}

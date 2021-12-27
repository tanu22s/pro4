package in.co.rays.ors.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @authorTanvi
 * @Version:(4.14.0)

 */

public class DuplicateRecordException extends Exception {

    /**
     * @param msg
     *            error message
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }

}
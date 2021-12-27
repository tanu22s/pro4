package in.co.rays.ors.exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
  
 * @authorTanvi
 * @Version:(4.14.0)

 */

public class RecordNotFoundException extends Exception {

    /**
     * @param msg
     *            error message
     */
    public RecordNotFoundException(String msg) {
        super(msg);

    }
}

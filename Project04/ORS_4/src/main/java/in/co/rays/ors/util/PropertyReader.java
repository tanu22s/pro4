
package in.co.rays.ors.util;

import java.util.ResourceBundle;

/**

 * @author Tanvi
 * @Version:(4.14.0)
 
 */

public class PropertyReader {

    private static ResourceBundle rb = ResourceBundle
            .getBundle("in.co.rays.ors.bundle.system");

    /**
     * Return value of key
     * 
     * @param key
     * @return
     */

    public static String getValue(String key) {
        String val = null;
  //      System.out.println("property reader key ....."+ key);
        try {
            val = rb.getString(key);
   //         System.out.println("property reader val ....."+ val);
        } catch (Exception e) {
            val = key;
        }
        return val;
    }
    

    /**
     * Gets String after placing param values
     * 
     * @param key
     * @param param
     * @return String
     */
    public static String getValue(String key, String param) {
        String msg = getValue(key);
        msg = msg.replace("{0}", param);
        return msg;
    }

    /**
     * Gets String after placing params values
     * 
     * @param key
     * @param params
     * @return
     */
    public static String getValue(String key, String[] params) {
        String msg = getValue(key);
        for (int i = 0; i < params.length; i++) {
            msg = msg.replace("{" + i + "}", params[i]);
        }
        return msg;
    }

    /**
     * Test method
     * 
     * @param args
     */

    public static void main(String[] args) {
        String[] params = { "Roll No" };
        System.out.println(PropertyReader.getValue("error.require", params));
    }

}


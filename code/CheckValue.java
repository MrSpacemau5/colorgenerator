
/**
 * Class containg the checkValue method
 * 
 * @author MrSpacemau5
 * @version 18/11/2017
 */
public class CheckValue {

    /**
     * checks if the user input is a valid color value (between 0 and 255)
     *
     * @param s the user input
     * @return {@code true} if the value is valid, {@code false} otherwise
     * @throws NumberFormatException if the user input is not an integer
     */
    public static boolean checkValue(String s) throws NumberFormatException {
        boolean res = false;
        int parsedString = 0;
        parsedString = Integer.parseInt(s);
        if(parsedString<=255 && parsedString>=0) {
            res=true;
        }
        return res;
    }

}

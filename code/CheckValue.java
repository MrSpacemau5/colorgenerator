
public class CheckValue {

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

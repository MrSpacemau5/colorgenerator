
public class CheckValue {

	public static boolean checkValue(String s) {
		boolean res = false;
		int parsedString = 0;
		try{
			parsedString = Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
		}
		if(parsedString<=255 && parsedString>=0) {
			res=true;
		}
		
		return res;
	}
	
}

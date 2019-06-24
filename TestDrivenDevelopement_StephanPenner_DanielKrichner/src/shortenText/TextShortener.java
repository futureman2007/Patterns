package shortenText;

public class TextShortener {
	public static String shortenText(String s) {
		
		if(s.length() > 140) {
			return cutText(s, " ");
		}else {
			return s;
		}
		
	}
	private static String cutText(String s, String delim) {
		s = s.substring(0,140);
		
		String[] tokens = s.split(delim);
		StringBuffer buff;
		String word = null;
		
		buff = appendStringsToBufferTill(tokens.length -1, tokens);
		cutOffLastPoint(buff);
		buff.append("...");
		
		if(buff.toString().length() > 140) {
			clearStringBuffer(buff);
			appendStringsToBufferTill(tokens.length -2, tokens);
		}
			
		return buff.toString();	
		
		
	}
	private static String workWithOneLongString(String[] tokens) {
		if(tokens[0].length() + 3 <= 140) {
			return tokens[0];
		}
		return "";
	}
	
	private static StringBuffer appendStringsToBufferTill(int limit, String [] tokens) {
		StringBuffer buff = new StringBuffer();
		
		if(limit == 0) {
			return buff.append(workWithOneLongString(tokens));
		}
		for(int i = 0; i < limit -1; i++) {
			buff.append(tokens[i]);
			buff.append(" ");
		}
			buff.append(tokens[limit -1]);
		return buff;
	}
	
	
	private static void cutOffLastPoint(StringBuffer buff) {
		String s = buff.toString();
		if(s.charAt(s.length() -1) == '.' ) {
			clearStringBuffer(buff); 
			buff.append(s.substring(0, s.length() -1));
		}
	}
	
	private static void clearStringBuffer(StringBuffer buff) {
		buff.delete(0, buff.length());
	}
}

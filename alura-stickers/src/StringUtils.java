
public class StringUtils {

	public static String limpaString(String str) {					
		return str.replaceAll("[^a-zA-Z0-9]", "");
	}
}

import java.io.File;

public class FileUtils {

	public static void checkDirectory(String directoryName) throws Exception {					
		
		File directory = new File(directoryName);
	    
		if (!directory.exists() && !directory.mkdir()) {	    		    	
	    	throw new Exception("O diretório "+directoryName + " não existe e/ou não foi possível criá-lo.");	    	
		}	    	    	  
	}
}

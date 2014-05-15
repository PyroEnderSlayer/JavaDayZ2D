package pyrotuliq.proz.lang;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pyrotuliq.proz.ProZ;

public class LanguageRegistry {
	private static Map<String, Language> langs = new HashMap<String, Language>();
	private static Language currentLanguage;
	
	private LanguageRegistry() {
		// DO NOTHING
	}
	
	public static void loadLanguage(String lang) throws IOException {
		Language language = new Language();
		BufferedInputStream input = new BufferedInputStream(ProZ.class.getClassLoader().getResourceAsStream("assets/lang/" + lang));
		long available = input.available();
		
		String currentKey = "";
		String currentValue = null;
		for (int iterator = 0; iterator < available; iterator++) {
			int b = input.read();
			String inputString = String.valueOf(Character.toChars(b));
			
			if (inputString.equals("=") && currentValue == null)
				currentValue = "";
			else if (inputString.equals("\n") && currentValue != null) {
				language.setKey(currentKey, currentValue);
				currentKey = "";
				currentValue = null;
			} else if (currentValue != null)
				currentValue += inputString;
			else
				currentKey += inputString;
		}
		
		input.close();
		langs.put(lang, language);
		
		if (currentLanguage == null)
			currentLanguage = language;
	}
	
	public static void setLanguage(String lang) {
		if (langs.containsKey(lang))
			currentLanguage = langs.get(lang);
	}
}

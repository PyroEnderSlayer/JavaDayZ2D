package pyrotuliq.proz.lang;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Map;

import pyrotuliq.proz.ProZ;

public class LanguageRegistry {
	private static Map<String, Language> langs;
	
	public static void loadLanguage(String lang) throws IOException {
		BufferedInputStream input = new BufferedInputStream(ProZ.class.getClassLoader().getResourceAsStream("assets/lang/" + lang));
		input.read();
	}
}

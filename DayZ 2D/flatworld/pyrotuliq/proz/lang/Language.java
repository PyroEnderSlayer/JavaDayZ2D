package pyrotuliq.proz.lang;

import java.util.HashMap;
import java.util.Map;

public class Language {
	private Map<String, String> lang;
	
	public Language() {
		lang = new HashMap<>();
	}
	
	public void setKey(String key, String text) {
		lang.put(key, text);
	}
	
	public void delKey(String key) {
		if (lang.containsKey(key))
			lang.remove(key);
	}
}

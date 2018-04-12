public class Substitute {
	public int getValue(String key, String code) {
		int value = 0;
		int magnitudo = 1;

		for (int i = code.length() - 1; i >= 0; i--) {
			int val = key.indexOf(code.charAt(i));
			if (val >= 0) {
				value += ((val + 1) % 10) * magnitudo;
				magnitudo *= 10;
			}
		}
		return value;
	}
}

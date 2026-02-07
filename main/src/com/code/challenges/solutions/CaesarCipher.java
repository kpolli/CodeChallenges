package solutions;

public class CaesarCipher {
	
	/*
	 * Simple encryption
	 * */
	
    public static void main(String[] args) {
        System.out.println(encryptWord("middle-Outz", 2));
    }
    
    private static String encryptWord(String s, int k) {
        if (s.isEmpty()) {
            return s;
        }
        
        char [] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
        	if (Character.isLetter(ss[i])) {
        		for (int j = 0; j < k; j++) {
        			ss[i] = (char) (ss[i] + 1);
        			if (ss[i] == '{') {
        				ss[i] = 'a';
        			} else if (ss[i] == '[') {
        				ss[i] = 'A';
        			}
        		}  
            }
        }
        String ans = new String(ss);
        return ans;
    }
}

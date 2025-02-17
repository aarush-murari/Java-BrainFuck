import java.io.IOException;
import java.util.Scanner;
public class BrainFuck {
	public static byte[] stream = new byte[30000];
	public static int dp = 0;
    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
    	while(scnr.hasNextLine()) {
    		String command = scnr.nextLine();
    		if (command.equals("quit()") || command.equals("exit()")) {
    			break;
    		}
    		else {
    			interpret(command);
    		}
    	}
    	
    }
    
    public static void interpret(String data) {
    	int pos1 = 0;
    	int pos2 = 0;
    	int i = 0;
    	Scanner bfScnr = new Scanner(System.in);
    	while (i < data.length()) {
    		
    		char token = data.charAt(i);
    		switch (token) {
    		
	    		case '>':
	    			dp++;
	    			if (dp > (stream.length - 1)) {
	    				dp = 0;
	    			}
	    			break;
	    		case '<':
	    			dp--;
	    			if (dp < 0) {
	    				dp = stream.length - 1;
	    			}
	    			break;
	    		case '+':
	    			stream[dp] += 1;
	    			break;
	    		case '-':
	    			stream[dp] -= 1;
	    			break;
	    		case '.':
	    			System.out.print((char)stream[dp]);
	    			break;
	    		case ',':
					try {
						byte charInput = (byte) System.in.read();
						//if (charInput == '\r') {charInput = '\n';}
						stream[dp] = charInput;
							
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
	    		case '[':
	    			pos1 = i;
	    			break;
	    		case ']':
	    			if (stream[dp] != 0) {
	    				i = pos1;
	    				continue;
	    			}
	    			break;
    		}
    		i++;
    		
    	}
    }

	
}

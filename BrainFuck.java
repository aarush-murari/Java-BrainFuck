import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class BrainFuck {
    public static byte[] stream = new byte[30000];
    public static int dp = 0;
    public static LinkedList<Character> instructions= new LinkedList<Character>();
    public static int pc = 0;
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
    
    public static void interpret(String data) {//intentional by design.
    	int pos1 = 0;
    	int pos2 = 0;
    	int i = 0;
    	Scanner bfScnr = new Scanner(System.in);
    	while (i < data.length()) {
    		instructions.add(data.charAt(i));
    		i++;
    	}	
    	for (pc = pc; pc < instructions.size(); pc++) {
    		char token = instructions.get(pc);
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
	    			pos1 = pc;
	    			break;
	    		case ']':
	    			if (stream[dp] != 0) {
	    				pc = pos1;
	    				continue;
	    			}
	    			break;
    		}
    		
    	}
    }

	
}

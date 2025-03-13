import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class BrainFuck {
    public static byte[] stream = new byte[30000];
    public static int dp = 0;
    public static LinkedList<Character> instructions = new LinkedList<Character>();
    public static int pc = 0;
    public static int pos1 = 0;
	public static int pos2 = 0;
    
    public static boolean shouldIPop = true;
    
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
    private static boolean isValid(char testChar) {
		String validChars = " +-<>.,[]";
    	if (validChars.contains(String.valueOf(testChar))) {
    		return true;
    	}
		return false;
	}

    public static void remove(int pos1, int pos2) {
    	for (int i = pos1; i < pos2; i++) {
    		//System.out.println(instructions);
    		popStack();
    	}
    }
    
    
    public static void popPc() {
		instructions.remove(pc);
		pc--;
    }
    public static void popStack() {
    	instructions.remove();
    	pc--;
    }
    
    
    public static void interpret(String data) {//intentional by design.
    	
    	int i = 0;
    	Scanner bfScnr = new Scanner(System.in);
    	while (i < data.length()) {
    		char instructionChar = data.charAt(i);
    		if (isValid(instructionChar)) {
    			instructions.add(instructionChar);
    			//System.out.println(pc + " " + instructions.size());
    		}
    		i++;
    	}	
    	for (pc = pc; pc < instructions.size();pc++) {
    		char token = instructions.get(pc);
    		switch (token) {
    		
	    		case '>':
	    			dp++;
	    			if (dp > (stream.length - 1)) {
	    				dp = 0;
	    			}
	    			if (shouldIPop) {
	    				popPc();
	    			}
	    			break;
	    		case '<':
	    			dp--;
	    			if (dp < 0) {
	    				dp = stream.length - 1;
	    			}
	    			if (shouldIPop) {
	    				popPc();
	    			}
	    			break;
	    		case '+':
	    			stream[dp] += 1;
	    			if (shouldIPop) {
	    				popPc();
	    			}
	    			break;
	    		case '-':
	    			stream[dp] -= 1;
	    			if (shouldIPop) {
	    				popPc();
	    			}
	    			break;
	    		case '.':
	    			System.out.print((char)stream[dp]);
	    			if (shouldIPop) {
	    				popPc();
	    			}
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
					if (shouldIPop) {
						popPc();
	    			}
					break;
	    		case '[':
	    			pos1 = pc;
	    			shouldIPop = false;
	    			break;
	    		case ']':
	    			if (stream[dp] != 0) {
	    				pc = pos1;
	    				break;
	    			}
	    			shouldIPop = true;
	    			remove(pos1, pc);
	    			continue;
    		}
    		
    	}
    }
	
	
}

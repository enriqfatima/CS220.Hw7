import java.util.HashMap;

public class symbolTable {
	
	HashMap<String, String> map = new HashMap<String, String>();
	
	public symbolTable() {
		map = new HashMap<String, String>();
	    map.put("R0", "0");
	    map.put("R1", "1");
	    map.put("R2", "2");
	    map.put("R3", "3");
	    map.put("R4", "4");
	    map.put("R5", "5");
	    map.put("R6", "6");
	    map.put("R7", "7");
	    map.put("R8", "8");
	    map.put("R9", "9");
	    map.put("R10", "10");
	    map.put("R11", "11");
	    map.put("R12", "12");
	    map.put("R13", "12");
	    map.put("R14", "14");
		map.put("SP", "0");
		map.put("LCL", "1");
		map.put("ARG", "2");
		map.put("THIS", "3");
		map.put("THAT", "4");
		map.put("SCREEN", "16384");
		map.put("KBD", "24576");
	}
	
	//adding an entry to a table 
	public boolean addEntry(String key, String value)
	{
		if(symbolTable.put(key, value) != null);
		{
			return true;
		}
		return false;
	}
	
	public boolean isValidName(String symbol)
	{

		return false;
		
	}
	public boolean contains(String key)
	{
		return symbolTable.constainsKey(key);
	}

	public String getAddress(String value)
	{
		return symbolTable.get(val);
	}
	
	public 

}

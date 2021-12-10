import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Parser {
	
	public int lineNumber ;
	public int lineCount;
	private String strFileArr[];
	private String cleanLine = "" ;
	public static commandType compT;  
	
	//implements the following enum. command types 
	public enum commandType
	{
		A_COMMAND, L_COMMAND, C_COMMAND, NO_COMMAND ;
	}
	public String cleanLine(String rawLine)
	{
		if(rawLine !=null && rawLine.contains("//"))
		{
			rawLine = rawLine.substring(0, rawLine.indexOf('/'));	
		}
		else
		{
			rawLine = rawLine.trim(); 
		}
		return rawLine;
	}
	
	//Description: opens input file/stream and prepares to parse 
	Parser(String fileName)
	{
		FileInputStream fstream = null;
		try
		{
			fstream = new FileInputStream(fileName);
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
	}
	//returns bool if more comands left, closes stream if not 
	public boolean hasMoreCommand()
	{
		if(lineNumber != strFileArr.length)
		{
			return true;
		}
		return false;
	}
	
	//reads next line from file and parses it into instance vars.
	void advance()
	{
		if(hasMoreCommand())
		{
			lineNumber ++;
		}
	}
	
	//parse symbols for A- or L-commands 
	void parseSymbol()
	{
		String symbol = "" ;
		if(cleanLine.startsWith("@")
		{
			symbol = cleanLine;
			symbol = symbol.replaceAll("@", "");
		}
		else
		{
			if(cleanLine.startsWith("("))
			{
				symbol = cleanLine;
				symbol = symbol.replaceAll("\\((.*?\\)", "$1");
			}
		}
	}
	public void parseJump()
	{
		if(cleanLine.contains(";"))
		{
			String retJump = cleanLine(null);
			int endIndex = retJump.lastIndexOf(";");
			jumpMnemonic = retJump.substring(endIndex + 1, retJump.length());
		}
		else jumpMnemonic;
	}
	
	public void parseComp()
	{
		String retComp = cleanLine(null);
		if(cleanLine.contains("="))
		{
			int endIndex = retComp.lastIndexOf("=");
			retComp = retComp.substring(endIndex + 1, retComp.length());
		}
		else if(cleanLine.contains(";"))
		{
			int endIndex = retComp.lastIndexOf(";");
			retComp = retComp.substring(0, endIndex);
		}
		compMnemonic  = retComp ;
	}
	public void parseDest()
	{
		if(cleanLine.contains("="))
		{
			String retDest = cleanLine(null);
			int endIndex = retDest.lastIndexOf("=");
			retDest = retDest.substring(0, endIndex);
			destMnemonic = retDest;
		}
		else
		{
			destMnemonic = null; 
		}
	}
	void parse()
	{
		
	}
	public String getDestMnemonic(String destMnemonic)
	{
		parseDest(); 
		return destMnemonic;
	}
	//getter for comp part of C-inst. 
	public String getJumpMnemonic(String jumpMnemonic)
	{
		parseJump();
		return jumpMnemonic;
	}
	
	//getter for comp part of C-inst. 
	public String getCompMnemonic(String compMnemonic)
	{
		parseComp(); 
		return compMnemonic; 
	}
	//Returns type of current command
	public commandType commandType()
	{
		if(strFileArr[lineCount].startsWith("("))
		{
			return compT = commandType.L_COMMAND;
		}
		else if(strFileArr[lineCount].startsWith("@"))
		{
			return compT = commandType.A_COMMAND;
		}
		return commandType.C_COMMAND;
	}
	
	//getter for cleanLine from file (debigging)
	public String getCleanLine(String file)
	{
		String tempFile=file.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/|(?m)^[ \t]*\r?\n|null|\t", "" );
		return tempFile = tempFile.replaceAll("(?m)^[ \t]*\r?\n", "");
	}
}
	/*public Command commandType()
		{
		if (cleanLine.contains();
		{
			return commandType = Command.L_COMMAND;
		}
		else (cleanLine.startsWith("@"));
		{
			return commandType = Command.A_COMMAND;
		}
		else if(cleanLine.contains("=") || cleanLine.contains(";"));
		{
			return commandType = Command.C_COMMAND;
		}
		return Command.NO_COMMAND;
	}*/
	

package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
	
	//File stored within Jar, Immutable
	public static String loadWorld(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			InputStream in = InputStream.class.getResourceAsStream(path); 
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line =  br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	//File stored outside Jar, mutable
	public static String loadFile(String path, boolean newgame){
		StringBuilder builder = new StringBuilder();
		
		try{
			//InputStream in = InputStream.class.getResourceAsStream(path); 
			//BufferedReader br = new BufferedReader(new InputStreamReader(in));
			BufferedReader br;
			if (newgame)
				br = new BufferedReader(new FileReader("saveState-NewGame.txt"));
			else
				br = new BufferedReader(new FileReader("saveState.txt"));
			String line;
			while((line =  br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			//loadWorld("/saveFiles/" + path);
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

abstract public class AbastractReadFile {

	public String fileContent ="";
	private String file;
	public AbastractReadFile(String filename) {
		this.file = filename;
	}
	public ArrayList<String> readFile(){
		ArrayList<String> text = new ArrayList<>();
		try {
		FileInputStream flux = new FileInputStream(this.file);
		InputStreamReader lecture = new InputStreamReader(flux);
		BufferedReader buff = new BufferedReader(lecture);
		String ligne;
		while((ligne=buff.readLine()) != null) {
			System.out.println(ligne);
			fileContent += ligne;
			text.add(ligne);
		}
		buff.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return text;
	}	
	public void upside() {
		 ArrayList<String> text = readFile();
		 
		 for(int i = text.size()-1; i >=0 ; i--) {
			 System.out.println(text.get(i));
		 }
	}
	
	public void palindrom() {
		String palindrom ="";
		for(int i = fileContent.length() -1; i>= 0; i--) {
			palindrom += fileContent.charAt(i);
		}
		String result = fileContent + palindrom;
		System.out.println(palindrom);
		System.out.println(result);
	}
	
	public boolean diff(AbastractReadFile file2) {
		if(this.fileContent.length() != file2.fileContent.length()) {
			return false;
		}
		for(int i = 0; i < file2.fileContent.length(); i++) {
			
		}
		return true;
	}
	
}

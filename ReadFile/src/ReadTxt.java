import java.util.ArrayList;

public class ReadTxt extends AbastractReadFile {
	
	public ReadTxt(String fileName) {
		super(fileName);
	}

	public ArrayList<String> read() {
		return readFile();
	}
	
	public boolean compare(ReadTxt file2) {
		final ArrayList<String> txt1 = this.read();
		final ArrayList<String> txt2 = file2.read();
		
		return txt1.equals(txt2);
		
	}
}
 
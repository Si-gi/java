public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadTxt testFile1 = new ReadTxt("C:\\Users\\licence.PW04\\Documents\\java\\test.txt");
		ReadTxt testFile2 = new ReadTxt("C:\\Users\\licence.PW04\\Documents\\java\\test2.txt");
		//readedFile.read();
		testFile1.upside();
		testFile1.palindrom();
		boolean b = testFile1.compare(testFile2);
		System.out.print(b);
	}

}
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
	public static void main(String[] args) {
		System.out.println("Hello Z3R0K3N");
		FileInputStream file= null;
		try {
			file = new FileInputStream("readme.txt");
			int c;
			StringBuilder strbuiler =new StringBuilder();
			c=file.read();
			while (c!=-1)
			{
				strbuiler.append((char)c);
			}
			System.out.println(strbuiler.toString());
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.getStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class writesinhviendemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectOutputStream objWOut;
		FileOutputStream fOut;
		sinhvien sv1= new sinhvien(1, "Z3R0K3N", 9999);
		try {
			fOut=new FileOutputStream("datasv.dat");
			objWOut=new ObjectOutputStream(fOut);
			objWOut.writeObject(sv1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}
}

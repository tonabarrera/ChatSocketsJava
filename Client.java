import java.net.*;
import java.io.*;

public class Client{

	public static void main(String args[]){

		String cad3;
		String resultado = "";
		String url = "localhost";
		int port = 1111;

		try{
			Socket sc1 = new Socket(url, port);
			InputStreamReader isr = new InputStreamReader( System.in );
			InputStream is = sc1.getInputStream();
			BufferedReader bf = new BufferedReader(isr);	
			OutputStream os1 = sc1.getOutputStream();
			DataOutputStream dos1 = new DataOutputStream(os1);
			DataInputStream dis = new DataInputStream(is);
			boolean continuar = true;

			System.out.println("El chat a empezado");
			System.out.println("Escribe <<Goodbye Moy>> para terminar el chat");
			
			while(continuar){
				cad3 = bf.readLine();
				System.out.println("Tu: " + cad3);
				dos1.writeUTF(cad3);
				if(cad3.equals("Goodbye Moy")){
					break;
				}
				resultado = dis.readUTF();
				System.out.println("Moy: " + resultado);
				if(resultado.equals("Goodbye Moy")){
					break;
				}
			}
			System.out.println("El chat a terminado");

			dos1.flush();	
			dos1.close();
		}
		catch(IOException e){	
			System.out.println("ERROR: NO SE ENCONTRO EL SERVIDOR");
		}
	}	
}
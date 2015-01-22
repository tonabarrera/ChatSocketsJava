import java.net.*;
import java.io.*;

public class Server{
	public static void main(String args[]){

		String resultado = "";
		String cad3 ="";
		int port = 1111;
		String a,b,c, tipo;
		ServerSocket ss = null;
		String url = "localhost";	
		
		try{
			ss = new ServerSocket(port);
			Socket s1 = ss.accept();
			InputStreamReader isr = new InputStreamReader( System.in );
			InputStream is = s1.getInputStream();
			OutputStream os1 = s1.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos1 = new DataOutputStream(os1);
			BufferedReader bf = new BufferedReader(isr);
			boolean continuar = true;
			System.out.println("El chat a empezado");
			System.out.println("Escribe <<Goodbye Moy>> para terminar el chat");	
			System.out.println("Esperando al cliente...");
			while(continuar){
				resultado = dis.readUTF();
				System.out.println("Client: " + resultado);
				if(resultado.equals("Goodbye Moy")){
					break;
				}
				cad3 = bf.readLine();
				System.out.println("Tu: " + cad3);
				dos1.writeUTF(cad3);
				if(cad3.equals("Goodbye Moy")){
					break;
				}
			}
			System.out.println("El chat a terminado");

			s1.close();
			dis.close();		
		}
		catch(IOException e){
			System.out.println("ERROR EN EL CLIENTE");	
		}	
	}
}
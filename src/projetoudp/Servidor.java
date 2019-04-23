package projetoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor{
    public static void main(String[] args)  {
        try {
            DatagramSocket s = new DatagramSocket(4545);
            System.out.println("Servidor esperando conexão.....");
    	 
            String envio;
            DatagramPacket recebe = new DatagramPacket (new byte[512], 512);
    	 
            while (true) {
                envio = "";
    		s.receive(recebe);
    		 
    		System.out.println("Mensagem recebida: ");
    		for(int i = 0; i < recebe.getLength(); i++) {
    			 System.out.println((char) recebe.getData()[i]);
    		}
    		System.out.println();
    		 
    		DatagramPacket resp = new DatagramPacket(recebe.getData(),recebe.getLength(), recebe.getAddress(), recebe.getPort());
    		s.send(resp);
            }
        } catch (IOException ex) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
}
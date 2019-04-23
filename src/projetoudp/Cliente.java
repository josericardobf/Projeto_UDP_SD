package projetoudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    String msgDevolvida;
    /*
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket();

            InetAddress dest = InetAddress.getByName("localhost");
            String envio;

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("> ");
            envio = teclado.readLine();

            while(!envio.equalsIgnoreCase("")) {
                byte[] buffer = envio.getBytes();
                DatagramPacket msg = new DatagramPacket(buffer, buffer.length, dest, 4545);
                s.send(msg);

                DatagramPacket resposta = new DatagramPacket (new byte[512], 512);

                s.receive(resposta);

                System.out.println(new String(resposta.getData()));

                System.out.println("> ");
                envio = teclado.readLine();
            }

            s.close();

        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    */
    
    public String EnviaRecebeMensagem(String mensagem) {
        try {
            DatagramSocket s = new DatagramSocket();
            InetAddress dest = InetAddress.getByName("localhost");

            if(!mensagem.equalsIgnoreCase("")) {
                byte[] buffer = mensagem.getBytes();
                DatagramPacket msg = new DatagramPacket(buffer, buffer.length, dest, 4545);
                s.send(msg);

                DatagramPacket resposta = new DatagramPacket (new byte[512], 512);
                s.receive(resposta);
                
                msgDevolvida = new String(resposta.getData());
            }

            s.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block

        }
        
        return msgDevolvida.trim();
    }
}
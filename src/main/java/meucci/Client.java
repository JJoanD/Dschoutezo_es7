package meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket mySocket;
    DataOutputStream outVersoServer;
    BufferedReader tastiera;
    BufferedReader inDalServer;

    public Socket connetti(){
      System.out.println("2 CLIENT partito in esecuzione");
    try{
        //per l'input da tastiera
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        //creazione socket
        mySocket = new Socket(nomeServer, portaServer); //possibile utilizzare anche 'InetAddress.getLocalHost' al posto di 'nomeServer'

        outVersoServer = new DataOutputStream(mySocket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

    }catch(UnknownHostException e){
        System.err.println("Host sconosciuto");
    }catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Errore durante la connessione");
        System.exit(1);
    }
    return mySocket;
    }

    public void comunica(String msg){

        try {
            outVersoServer.writeBytes(msg + "\n");
        } catch (Exception e) {
            
        }
    }

     public String riceve() {
        
        try {
            return inDalServer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "Errore";
        }
    }

    public void close() {

        try {         
            mySocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

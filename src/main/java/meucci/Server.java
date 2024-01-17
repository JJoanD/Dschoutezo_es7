package meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    
    public static  ServerSocket server;
    public static  Socket client;
    public static  int port;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;


    public Socket attendi(){
       
        try{
            System.out.println(" SERVER partito in esecuzione");
            //creo un server sulla porta 6789
            if(server == null){
                server = new ServerSocket(6789);
            }

            //rimane in attesa di un client
            client = server.accept();
            //non va chiuso il server cosi da poter inibire altri client

            //associo due oggetti al socket del client per effetuare la scrittura e la lettura , ossia gli stream
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica(String msg) throws Exception{

        outVersoClient.writeBytes(msg + "\n");

        /*XmlMapper mapper = new XmlMapper();
        Persona p = new Persona();
        String xml = mapper.writeValueAsString(p);*/
        
    }

    public String riceve() {
        
        try {
            return inDalClient.readLine();
        } catch (IOException e) { 
            e.printStackTrace();
            return "Errore";
        }
    }

    public void closeClient() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}   

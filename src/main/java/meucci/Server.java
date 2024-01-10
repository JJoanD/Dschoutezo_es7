package meucci;

import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Server {
    
    public static  ServerSocket server;
    public static  Socket client;
    public static  int port;

    public static void main( String[] args )
    {
        Server server = new Server();
        server.attendi();
        
    }

    public Socket attendi(){
       
        try{
            System.out.println("1 SERVER partito in esecuzione");
            //creo un server sulla porta 6789
            if(server == null){
                server = new ServerSocket(6789);
            }
            //rimane in attesa di un client
            client = server.accept();
            //non va chiuso il server cosi da poter inibire altri client

            //associo due oggetti al coket del client per effetuare la scrittura e la lettura , ossia gli stream
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica() throws Exception{
        XmlMapper mapper = new XmlMapper();
        Persona p = new Persona();
        String xml = mapper.writeValueAsString(p);
        
    }
}   

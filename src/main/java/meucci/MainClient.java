package meucci;

import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MainClient {
    public static void main(String[] args) {
        try { 
            Scanner tastiera = new Scanner(System.in);
            String msgServer = "";
            Client client = new Client();
            client.connetti();
            
            msgServer = client.riceve();
            System.out.println(msgServer);

            /* 
            InserimentoDatiPersona();

            client.comunica(p.getCongome());
            client.comunica(p.getNome());
            client.comunica(String.valueOf(p.getEtà())); */

            msgServer = client.riceve();
            System.out.println(msgServer);

            XmlMapper xmlMapper = new XmlMapper();


            Persona persona = xmlMapper.readValue(msgServer, Persona.class);
            
           // msgServer = client.riceve();

            System.out.println("XML Risposta : " + persona);

            System.out.println("attesa json");

            msgServer = client.riceve();
            System.out.println(msgServer);

            ObjectMapper jsonMapper = new ObjectMapper();

            Persona p = jsonMapper.readValue(msgServer,Persona.class);
            System.out.println("JSON Risposta : " + p);

            tastiera.close();
            client.close();
        } catch (Exception e) {
           
        }
    }

}

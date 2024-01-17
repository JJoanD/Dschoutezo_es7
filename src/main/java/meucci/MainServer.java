package meucci;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MainServer {
    public static void main(String[] args) {
        try {
            Server server = new Server();
            Persona p = new Persona("joan" , "dschoutezo" , 18);
            server.attendi();
            server.comunica("Connessione effetuata");
           
        

            XmlMapper mapper = new XmlMapper();
            String xml = mapper.writeValueAsString(p);
            System.out.println(xml);
            server.comunica(xml);

            System.out.println("ora invio JSON");

            ObjectMapper jsonMapper = new ObjectMapper();
            String jsoString = jsonMapper.writeValueAsString(p);
            System.out.println(jsoString);
            server.comunica(jsoString);

            } catch (Exception e) {
              
            }
    }
}
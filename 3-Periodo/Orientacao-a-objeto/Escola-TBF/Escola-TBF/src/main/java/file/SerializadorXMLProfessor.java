package file;

import classes.Professor; 
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SerializadorXMLProfessor implements ISerializador<Professor> {
    
    // Serializa uma lista de Professores para XML como String
    public String toFile(List<Professor> professores) {
        try {
            JAXBContext context = JAXBContext.newInstance(Professor.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            for (Professor professor : professores) {
                marshaller.marshal(professor, writer);
            }
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Professor> fromFile(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(Professor.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StringReader reader = new StringReader(xmlString);
            List<Professor> professores = new ArrayList<>();
            while (reader.ready()) {
                Professor professor = (Professor) unmarshaller.unmarshal(reader);
                professores.add(professor);
            }
            return professores;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
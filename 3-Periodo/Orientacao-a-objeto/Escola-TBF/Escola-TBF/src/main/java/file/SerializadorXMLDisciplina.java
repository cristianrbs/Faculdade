package file;

import classes.Disciplina;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SerializadorXMLDisciplina implements ISerializador<Disciplina> {
    
    
    public String toFile(List<Disciplina> disciplinas) {
        try {
            JAXBContext context = JAXBContext.newInstance(Disciplina.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            for (Disciplina disciplina : disciplinas) {
                marshaller.marshal(disciplina, writer);
            }
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Disciplina> fromFile(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(Disciplina.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StringReader reader = new StringReader(xmlString);
            List<Disciplina> disciplinas = new ArrayList<>();
            while (reader.ready()) {
                Disciplina disciplina = (Disciplina) unmarshaller.unmarshal(reader);
                disciplinas.add(disciplina);
            }
            return disciplinas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
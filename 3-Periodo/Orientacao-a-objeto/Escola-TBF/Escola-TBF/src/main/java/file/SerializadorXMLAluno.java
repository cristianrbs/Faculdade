package file;

import classes.Aluno;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public  class SerializadorXMLAluno implements ISerializador<Aluno> {
    
    public String toFile(List<Aluno> alunos) {
        try {
            JAXBContext context = JAXBContext.newInstance(Aluno.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            for (Aluno aluno : alunos) {
                marshaller.marshal(aluno, writer);
            }
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Aluno> fromFile(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(Aluno.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StringReader reader = new StringReader(xmlString);
            List<Aluno> alunos = new ArrayList<>();
            while (reader.ready()) {
                Aluno aluno = (Aluno) unmarshaller.unmarshal(reader);
                alunos.add(aluno);
            }
            return alunos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
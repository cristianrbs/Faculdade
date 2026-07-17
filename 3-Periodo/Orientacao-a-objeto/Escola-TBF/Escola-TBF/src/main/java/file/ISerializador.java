

package file;

import java.util.List;


public interface ISerializador<T> {

    String toFile(List<T> lista);

    List<T> fromFile(String data);
}

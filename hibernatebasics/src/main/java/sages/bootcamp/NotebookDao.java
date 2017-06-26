package sages.bootcamp;

import java.util.List;

public interface NotebookDao {

    List<Notebook> findByResolution(int price);

}

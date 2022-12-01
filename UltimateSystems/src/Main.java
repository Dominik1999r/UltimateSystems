import gui.MainPanel;
import model.Nauczyciel;
import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        List<Nauczyciel> listNauczyciel = new ArrayList<>();
        MainPanel glownyPanel = new MainPanel(listStudent, listNauczyciel);

    }
}
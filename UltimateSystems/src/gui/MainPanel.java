package gui;

import model.Nauczyciel;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.List;

public class MainPanel extends JFrame {

    private JButton dodajStudenta = new JButton("Dodaj studenta");

    private JButton usunStudenta = new JButton("Usuń studenta");

    private JButton edytujStudenta = new JButton("Edytuj studenta");

    private JButton panelNauczyciela = new JButton("Panel nauczyciela");

    private JButton teachersOneStudent = new JButton("Nauczyciele studenta");

    private JButton addStudentToTeacher = new JButton("Nadaj nauczyciela studentowi");

    private JButton search = new JButton("Szukaj");
    private JButton deleteFromList = new JButton("Usuń powiazanie");

    private JButton sortNameButton = new JButton("Sortuj po nazwisku");

    private JPanel drawPanel = new JPanel();
    private JPanel upPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel downPanel = new JPanel();
    public MainPanel(List<Student> students, List<Nauczyciel> listNauczyciele) throws HeadlessException {
        showStudents(students, listNauczyciele);
    }
    public void showStudents(List<Student> students, List<Nauczyciel> listNauczyciele){

        this.setTitle("Lista studentów");
        this.setPreferredSize(new Dimension(690, 600));

        String[][] rec2 = new String[students.size()][6];
        int i = 0;
        for(Student s : students){
            rec2[i][0] = String.valueOf(i+1);
            rec2[i][1] = s.getImie();
            rec2[i][2] = s.getNazwisko();
            rec2[i][3] = s.getEmail();
            rec2[i][4] = String.valueOf(s.getWiek());
            rec2[i][5] = s.getKierunek();
            i++;
        }

        String[] header = {"nr" ,"Imie", "Nazwisko", "email", "wiek","kierunek" };


        JTable table = new JTable(rec2, header);

        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);

        deleteFromList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteOfList deleteFromList = new DeleteOfList(MainPanel.this, students, listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        search.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainPanel.this.setVisible(false);
                Search search = new Search(MainPanel.this, students, listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addStudentToTeacher.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddStudentToTeacher addStudentToTeacher1 = new AddStudentToTeacher(MainPanel.this,students, listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        teachersOneStudent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ShowTeachersOfStudent teachersOneStudent1 = new ShowTeachersOfStudent(MainPanel.this,students, listNauczyciele);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        panelNauczyciela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainPanel.this.setVisible(false);
                TeacherPanel panelNauczyciela1 = new TeacherPanel(students,listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        dodajStudenta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddStudent addStudent = new AddStudent(MainPanel.this, students,listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        usunStudenta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteStudent deleteStudent = new DeleteStudent(MainPanel.this, students, listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        edytujStudenta.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditStudent editStudent = new EditStudent(MainPanel.this, students, listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        sortNameButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Collections.sort(students, (p1, p2) -> {
                 return p1.getNazwisko().compareTo(p2.getNazwisko());
                });
                MainPanel.this.setVisible(false);
                MainPanel mainPanel = new MainPanel( students, listNauczyciele);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        drawPanel.add(new JScrollPane(table));
        upPanel.add(dodajStudenta);
        upPanel.add(usunStudenta);
        upPanel.add(edytujStudenta);
        upPanel.add(search);
        upPanel.add(sortNameButton);
        downPanel.add(teachersOneStudent);;
        downPanel.add(addStudentToTeacher);
        downPanel.add(deleteFromList);
        downPanel.add(panelNauczyciela);



        upPanel.setPreferredSize(new Dimension(800, 50));
        leftPanel.setPreferredSize(new Dimension(50, 900));
        drawPanel.setPreferredSize(new Dimension(800,700));
        downPanel.setPreferredSize(new Dimension(800,50));
        rightPanel.setPreferredSize(new Dimension(50, 900));

        this.setLayout(new BorderLayout());
        this.add(upPanel, BorderLayout.NORTH);
        this.add(drawPanel, BorderLayout.CENTER);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(downPanel, BorderLayout.SOUTH);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(drawPanel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

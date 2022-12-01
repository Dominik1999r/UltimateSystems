package gui;

import model.Nauczyciel;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.List;

public class TeacherPanel extends JFrame {

    private JButton dodajNauczyciela = new JButton("Dodaj nauczyciela");
    private JButton usunNauczyciela = new JButton("Usuń nauczyciela");
    private JButton edytujNauczyciela = new JButton("Edytuj nauczyciela");
    private JButton glownyPanel = new JButton("Glówny panel");
    private JButton studentsOneTeacher = new JButton("Studenci nauczyciela");

    private JButton sortNameButton = new JButton("Sortuj po nazwisku");
    private JPanel drawPanel = new JPanel();
    private JPanel upPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel downPanel = new JPanel();

    public TeacherPanel(List<Student> students, List<Nauczyciel> listNauczyciel) throws HeadlessException {
        this.setTitle("Lista nauczycieli");
        showNauczyciel(students,listNauczyciel);
    }
    public void showNauczyciel(List<Student> students, List<Nauczyciel> Nauczyciele){


        this.setPreferredSize(new Dimension(690, 600));
        drawPanel.setPreferredSize(new Dimension(700 , 500));

        this.setLayout(new FlowLayout());

        String[][] rec2 = new String[Nauczyciele.size()][6];

        int i = 0;
        for(Nauczyciel n : Nauczyciele){
            rec2[i][0] = String.valueOf(i+1);
            rec2[i][1] = n.getImie();
            rec2[i][2] = n.getNazwisko();
            rec2[i][3] = n.getEmail();
            rec2[i][4] = String.valueOf(n.getWiek());
            rec2[i][5] = n.getPrzedmiot();
            i++;
        }

        String[] header = {"nr" ,"Imie", "Nazwisko", "email", "wiek", "przedmiot" };


        JTable table = new JTable(rec2, header);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);


        studentsOneTeacher.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TeacherPanel.this.setVisible(false);
                ShowStudentsOfTeacher studentsOneTeacher = new ShowStudentsOfTeacher(TeacherPanel.this, students, Nauczyciele);
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

        glownyPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TeacherPanel.this.setVisible(false);
                MainPanel glownyPanel1 = new MainPanel(students,  Nauczyciele);
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


        dodajNauczyciela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddTeacher addTeacher = new AddTeacher(TeacherPanel.this,students, Nauczyciele);
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

        usunNauczyciela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteTeacher deleteTeacher = new DeleteTeacher(TeacherPanel.this, students, Nauczyciele);
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

        edytujNauczyciela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditTeacher editTeacher = new EditTeacher(TeacherPanel.this, students,Nauczyciele);
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
                Collections.sort(Nauczyciele, (p1, p2) -> {
                    return p1.getNazwisko().compareTo(p2.getNazwisko());
                });
                TeacherPanel.this.setVisible(false);
                TeacherPanel teacherPanel = new TeacherPanel( students, Nauczyciele);
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

        upPanel.add(dodajNauczyciela);
        upPanel.add(usunNauczyciela);
        upPanel.add(edytujNauczyciela);
        upPanel.add(sortNameButton);

        downPanel.add(studentsOneTeacher);;
        downPanel.add(glownyPanel);

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
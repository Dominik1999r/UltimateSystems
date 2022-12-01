package gui;

import model.Nauczyciel;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ShowTeachersOfStudent extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieLabel = new JLabel("Imie studenta");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko studenta");
    private JLabel wiekLabel = new JLabel("Kierunek studenta");
    private JTextField imieField = new JTextField();
    private JTextField nazwiskoField = new JTextField();
    private JTextField kierunekField = new JTextField();
    private JButton findButton = new JButton("Szukaj (terminal)");
    private JButton wrocButton = new JButton("Wróć");

    public ShowTeachersOfStudent(JFrame parent, List<Student> students, List<Nauczyciel> listNauczyciele) throws HeadlessException {

        this.setTitle("Wyswietl wszystkich nauczycieli danego studenta");
        this.setSize(new Dimension(600, 600));
        this.setPreferredSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        Dimension labelSize = new Dimension(150, 20);
        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;

        imieLabel.setPreferredSize(labelSize);
        nazwiskoLabel.setPreferredSize(labelSize);
        wiekLabel.setPreferredSize(labelSize);
        imieField.setPreferredSize(fieldSize);
        nazwiskoField.setPreferredSize(fieldSize);
        kierunekField.setPreferredSize(fieldSize);

        findButton.setPreferredSize(new Dimension(150,20));
        wrocButton.setPreferredSize(new Dimension(100, 20));

        panel.add(imieLabel);
        panel.add(nazwiskoLabel);
        panel.add(wiekLabel);
        panel.add(imieField);
        panel.add(nazwiskoField);
        panel.add(kierunekField);
        panel.add(wrocButton);
        panel.add(findButton);

        // Ustawienie imieLabel
        layout.putConstraint(SpringLayout.NORTH, imieLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie nazwiskoLabel
        layout.putConstraint(SpringLayout.NORTH, nazwiskoLabel, 15, SpringLayout.SOUTH, imieLabel);
        layout.putConstraint(SpringLayout.WEST, nazwiskoLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie wiekLabel
        layout.putConstraint(SpringLayout.NORTH, wiekLabel, 15, SpringLayout.SOUTH, nazwiskoLabel);
        layout.putConstraint(SpringLayout.WEST, wiekLabel, 60, SpringLayout.WEST, panel);

        //ustawienia pol
        // Ustawienie imieField
        layout.putConstraint(SpringLayout.NORTH, imieField, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie nazwiskoField
        layout.putConstraint(SpringLayout.NORTH, nazwiskoField, 15, SpringLayout.SOUTH, imieField);
        layout.putConstraint(SpringLayout.WEST, nazwiskoField, odleglosc, SpringLayout.EAST, imieLabel);


        // Ustawienie kierunekField
        layout.putConstraint(SpringLayout.NORTH, kierunekField, 15, SpringLayout.SOUTH, nazwiskoField);
        layout.putConstraint(SpringLayout.WEST, kierunekField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie findButton
        layout.putConstraint(SpringLayout.NORTH, findButton, 15, SpringLayout.SOUTH, kierunekField);
        layout.putConstraint(SpringLayout.WEST, findButton, 0, SpringLayout.WEST, imieLabel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, kierunekField);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, kierunekField);


        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imieStudenta = imieField.getText();
                String nazwiskoStudenta = nazwiskoField.getText();
                String kierunekStudenta = kierunekField.getText();

                for(Nauczyciel n : listNauczyciele){
                    List<Student> students1 = n.getListStudent();
                    for(Student s : students1){
                        if(s.getImie().equals(imieStudenta) && s.getNazwisko().equals(nazwiskoStudenta) && s.getKierunek().equals(kierunekStudenta)){
                            n.showNauczyciel();
                        }
                    }
                }
                JOptionPane.showMessageDialog(ShowTeachersOfStudent.this, "Zostanią wypisani nauczyciele, jeśli podany użytkownik istnieje", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowTeachersOfStudent.this.dispose();
                parent.setVisible(true);

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(ShowTeachersOfStudent.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    ShowTeachersOfStudent.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}


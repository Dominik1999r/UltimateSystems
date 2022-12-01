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

public class AddStudentToTeacher extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieStudentaLabel = new JLabel("Imie studenta");
    private JLabel nazwiskoStudentaLabel = new JLabel("Nazwisko studenta");
    private JLabel wiekStudentaLabel = new JLabel("Wiek studenta");
    private JLabel emailStudentaLabel = new JLabel("Email studenta");
    private JLabel kierunekStudentaLabel = new JLabel("Kierunek studenta");
    private JLabel imieNauczycielaLabel = new JLabel("Imie nauczyciela");
    private JLabel nazwiskoNauczycielaLabel = new JLabel("Nazwisko nauczyciela");
    private JLabel wiekNauczycielaLabel = new JLabel("Wiek nauczyciela");
    private JLabel emailNauczycielaLabel = new JLabel("Email nauczyciela");
    private JLabel przedmiotNauczycielaLabel = new JLabel("Przedmiot nauczyciela");
    private JTextField imieStudentaField = new JTextField();
    private JTextField nazwiskoStudentaField = new JTextField();
    private JTextField wiekStudentaField = new JTextField();
    private JTextField emailStudentaField = new JTextField();
    private JTextField kierunekStudentaField = new JTextField();
    private JTextField imieNauczycielaField = new JTextField();
    private JTextField nazwiskoNauczycielaField = new JTextField();
    private JTextField wiekNauczycielaField = new JTextField();
    private JTextField emailNauczycielaField = new JTextField();
    private JTextField przedmiotNauczycielaField = new JTextField();
    private JButton zapiszButton = new JButton("Dodaj");
    private JButton wrocButton = new JButton("Wróć");

    public AddStudentToTeacher(JFrame parent, List<Student> students, List<Nauczyciel> nauczyciele) {

        this.setTitle("Przypisanie studentowi nauczyciela - nauczycielowi studenta");
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Dimension labelSize = new Dimension(150, 20);
        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;

        imieStudentaLabel.setPreferredSize(labelSize);
        nazwiskoStudentaLabel.setPreferredSize(labelSize);
        wiekStudentaLabel.setPreferredSize(labelSize);
        emailStudentaLabel.setPreferredSize(labelSize);
        kierunekStudentaLabel.setPreferredSize(labelSize);
        imieNauczycielaLabel.setPreferredSize(labelSize);
        nazwiskoNauczycielaLabel.setPreferredSize(labelSize);
        wiekNauczycielaLabel.setPreferredSize(labelSize);
        emailNauczycielaLabel.setPreferredSize(labelSize);
        przedmiotNauczycielaLabel.setPreferredSize(labelSize);
        imieStudentaField.setPreferredSize(fieldSize);
        nazwiskoStudentaField.setPreferredSize(fieldSize);
        wiekStudentaField.setPreferredSize(fieldSize);
        emailStudentaField.setPreferredSize(fieldSize);
        kierunekStudentaField.setPreferredSize(fieldSize);
        imieNauczycielaField.setPreferredSize(fieldSize);
        nazwiskoNauczycielaField.setPreferredSize(fieldSize);
        wiekNauczycielaField.setPreferredSize(fieldSize);
        emailNauczycielaField.setPreferredSize(fieldSize);
        przedmiotNauczycielaField.setPreferredSize(fieldSize);

        zapiszButton.setPreferredSize(new Dimension(100, 20));
        wrocButton.setPreferredSize(new Dimension(100, 20));

        panel.add(imieStudentaLabel);
        panel.add(nazwiskoStudentaLabel);
        panel.add(wiekStudentaLabel);
        panel.add(emailStudentaLabel);
        panel.add(kierunekStudentaLabel);
        panel.add(imieNauczycielaLabel);
        panel.add(nazwiskoNauczycielaLabel);
        panel.add(wiekNauczycielaLabel);
        panel.add(emailNauczycielaLabel);
        panel.add(przedmiotNauczycielaLabel);
        panel.add(imieStudentaField);
        panel.add(nazwiskoStudentaField);
        panel.add(wiekStudentaField);
        panel.add(emailStudentaField);
        panel.add(kierunekStudentaField);
        panel.add(imieNauczycielaField);
        panel.add(nazwiskoNauczycielaField);
        panel.add(wiekNauczycielaField);
        panel.add(emailNauczycielaField);
        panel.add(przedmiotNauczycielaField);
        panel.add(zapiszButton);
        panel.add(wrocButton);


        // Ustawienie imiestudentaLabel
        layout.putConstraint(SpringLayout.NORTH, imieStudentaLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie nazwiskostudentaLabel
        layout.putConstraint(SpringLayout.NORTH, nazwiskoStudentaLabel, 15, SpringLayout.SOUTH, imieStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, nazwiskoStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie wiekstudentaLabel
        layout.putConstraint(SpringLayout.NORTH, wiekStudentaLabel, 15, SpringLayout.SOUTH, nazwiskoStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, wiekStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie emailStudentaLabel
        layout.putConstraint(SpringLayout.NORTH, emailStudentaLabel, 15, SpringLayout.SOUTH, wiekStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, emailStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie kierunekStudentaLabel
        layout.putConstraint(SpringLayout.NORTH, kierunekStudentaLabel, 15, SpringLayout.SOUTH, emailStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, kierunekStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie imieNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, imieNauczycielaLabel, 15, SpringLayout.SOUTH, kierunekStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, imieNauczycielaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie nazwiskoNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, nazwiskoNauczycielaLabel, 15, SpringLayout.SOUTH, imieNauczycielaLabel);
        layout.putConstraint(SpringLayout.WEST, nazwiskoNauczycielaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie wiekNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, wiekNauczycielaLabel, 15, SpringLayout.SOUTH, nazwiskoNauczycielaLabel);
        layout.putConstraint(SpringLayout.WEST, wiekNauczycielaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie emailNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, emailNauczycielaLabel, 15, SpringLayout.SOUTH, wiekNauczycielaLabel);
        layout.putConstraint(SpringLayout.WEST, emailNauczycielaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie przedmiotNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, przedmiotNauczycielaLabel, 15, SpringLayout.SOUTH, emailNauczycielaLabel);
        layout.putConstraint(SpringLayout.WEST, przedmiotNauczycielaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie pól
        // Ustawienie imieStudentaField
        layout.putConstraint(SpringLayout.NORTH, imieStudentaField, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie nazwiskoStudentaField
        layout.putConstraint(SpringLayout.NORTH, nazwiskoStudentaField, 15, SpringLayout.SOUTH,imieStudentaField);
        layout.putConstraint(SpringLayout.WEST, nazwiskoStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie wiekStudentaField
        layout.putConstraint(SpringLayout.NORTH, wiekStudentaField, 15, SpringLayout.SOUTH, nazwiskoStudentaField);
        layout.putConstraint(SpringLayout.WEST, wiekStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie emailStudentaField
        layout.putConstraint(SpringLayout.NORTH, emailStudentaField, 15, SpringLayout.SOUTH, wiekStudentaField);
        layout.putConstraint(SpringLayout.WEST, emailStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie kierunekStudentaField
        layout.putConstraint(SpringLayout.NORTH, kierunekStudentaField, 15, SpringLayout.SOUTH, emailStudentaField);
        layout.putConstraint(SpringLayout.WEST, kierunekStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie ImieNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, imieNauczycielaField, 15, SpringLayout.SOUTH, kierunekStudentaField);
        layout.putConstraint(SpringLayout.WEST, imieNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie NazwiskoNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, nazwiskoNauczycielaField, 15, SpringLayout.SOUTH, imieNauczycielaField);
        layout.putConstraint(SpringLayout.WEST, nazwiskoNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie wiekNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, wiekNauczycielaField, 15, SpringLayout.SOUTH, nazwiskoNauczycielaField);
        layout.putConstraint(SpringLayout.WEST, wiekNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie emailNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, emailNauczycielaField, 15, SpringLayout.SOUTH, wiekNauczycielaField);
        layout.putConstraint(SpringLayout.WEST, emailNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie przedmiotNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, przedmiotNauczycielaField, 15, SpringLayout.SOUTH, emailNauczycielaField);
        layout.putConstraint(SpringLayout.WEST, przedmiotNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie zapiszButton
        layout.putConstraint(SpringLayout.NORTH, zapiszButton, 15, SpringLayout.SOUTH, przedmiotNauczycielaLabel);
        layout.putConstraint(SpringLayout.WEST, zapiszButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, przedmiotNauczycielaLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, przedmiotNauczycielaField);


        // dodanie studenta do listy nauczyciela i na odwrót
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imieNauczycielaField.getText().isEmpty() || nazwiskoNauczycielaField.getText().isEmpty() || emailNauczycielaField.getText().isEmpty() ||
                        przedmiotNauczycielaField.getText().isEmpty() || imieStudentaField.getText().isEmpty() || nazwiskoStudentaField.getText().isEmpty() ||
                        wiekStudentaField.getText().isEmpty() || emailStudentaField.getText().isEmpty() || kierunekStudentaField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(AddStudentToTeacher.this, "Nie podano wszystkich wymaganych danych.", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for(Student s : students){
                    if( s.checkStudent(imieStudentaField.getText(), nazwiskoStudentaField.getText(), emailStudentaField.getText(), kierunekStudentaField.getText()) ){
                        for( Nauczyciel n : nauczyciele){
                            int wiek = 0;
                            try {
                                wiek = Integer.parseInt(wiekNauczycielaField.getText());
                            }
                            catch (Exception exception){
                                JOptionPane.showMessageDialog(AddStudentToTeacher.this, "Błędne dane w polu wiek", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                            }
                            if(n.checkNauczyciel(imieNauczycielaField.getText(), nazwiskoNauczycielaField.getText(), wiek,emailNauczycielaField.getText(), przedmiotNauczycielaField.getText())){
                                s.addNauczyciel(imieNauczycielaField.getText(), nazwiskoNauczycielaField.getText(), wiek,emailNauczycielaField.getText(), przedmiotNauczycielaField.getText());
                                break;
                            }
                        }
                        break;
                    }
                }
                for(Nauczyciel n : nauczyciele){
                    int wiek = 0;
                    try {
                        wiek = Integer.parseInt(wiekNauczycielaField.getText());
                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(AddStudentToTeacher.this, "Błędne dane w polu wiek", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    }
                    if(n.checkNauczyciel(imieNauczycielaField.getText(),nazwiskoNauczycielaField.getText(), wiek, emailNauczycielaField.getText(),przedmiotNauczycielaField.getText())){
                        for(Student s : students){
                            if(s.checkStudent(imieStudentaField.getText(), nazwiskoStudentaField.getText(), emailStudentaField.getText(), kierunekStudentaField.getText())){
                                int buf = 0;
                                try {
                                    buf = Integer.parseInt(wiekStudentaField.getText());
                                }
                                catch (Exception exception){
                                    JOptionPane.showMessageDialog(AddStudentToTeacher.this, "Błędne dane w polu wiek", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                                }
                                n.addStudent(imieStudentaField.getText(), nazwiskoStudentaField.getText(), buf ,emailStudentaField.getText(), kierunekStudentaField.getText());
                                break;
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(AddStudentToTeacher.this, "Pomyślnie dodano studentowi nauczyciela, jeśli użytkownicy istnieją w bazie", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                AddStudentToTeacher.this.dispose();
            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentToTeacher.this.dispose();
                parent.setVisible(true);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(AddStudentToTeacher.this, "Czy napewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                    parent.setVisible(true);
                    AddStudentToTeacher.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}

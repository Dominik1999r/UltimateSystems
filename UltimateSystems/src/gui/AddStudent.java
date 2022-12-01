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

public class AddStudent extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieLabel = new JLabel("Imie studenta");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko studenta");
    private JLabel wiekLabel = new JLabel("Wiek studenta");
    private JLabel emailLabel = new JLabel("Email studenta");
    private JLabel kierunekLabel = new JLabel("Kierunek studenta");
    private JTextField imieField = new JTextField();
    private JTextField nazwiskoField = new JTextField();
    private JTextField wiekField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField kierunekField = new JTextField();
    private JButton zapiszButton = new JButton("Zapisz");
    private JButton wrocButton = new JButton("Wróć");


    public AddStudent(JFrame parent, List<Student> students, List<Nauczyciel> nauczyciele) throws HeadlessException {

        this.setTitle("Dodaj studenta");
        this.setSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Dimension labelSize = new Dimension(150, 20);

        imieLabel.setPreferredSize(labelSize);
        nazwiskoLabel.setPreferredSize(labelSize);
        wiekLabel.setPreferredSize(labelSize);
        emailLabel.setPreferredSize(labelSize);
        kierunekLabel.setPreferredSize(labelSize);


        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;

        imieField.setPreferredSize(fieldSize);
        nazwiskoField.setPreferredSize(fieldSize);
        wiekField.setPreferredSize(fieldSize);
        emailField.setPreferredSize(fieldSize);
        kierunekField.setPreferredSize(fieldSize);

        zapiszButton.setPreferredSize(new Dimension(100,20));
        wrocButton.setPreferredSize(new Dimension(100, 20));


        panel.add(imieLabel);
        panel.add(nazwiskoLabel);
        panel.add(wiekLabel);
        panel.add(emailLabel);
        panel.add(kierunekLabel);

        panel.add(imieField);
        panel.add(nazwiskoField);
        panel.add(wiekField);
        panel.add(emailField);
        panel.add(kierunekField);

        panel.add(zapiszButton);
        panel.add(wrocButton);


        // Ustawienie imieLabel
        layout.putConstraint(SpringLayout.NORTH, imieLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieLabel, 60, SpringLayout.WEST, panel);


        // Ustawienie nazwiskoLabel
        layout.putConstraint(SpringLayout.NORTH, nazwiskoLabel, 15, SpringLayout.SOUTH, imieLabel);
        layout.putConstraint(SpringLayout.WEST, nazwiskoLabel, 60, SpringLayout.WEST, panel);


        // Ustawienie wiekLabel
        layout.putConstraint(SpringLayout.NORTH, wiekLabel, 15, SpringLayout.SOUTH, nazwiskoLabel);
        layout.putConstraint(SpringLayout.WEST, wiekLabel, 60, SpringLayout.WEST, panel);


        // Ustawienie emailLabel
        layout.putConstraint(SpringLayout.NORTH, emailLabel, 15, SpringLayout.SOUTH, wiekLabel);
        layout.putConstraint(SpringLayout.WEST, emailLabel, 60, SpringLayout.WEST, panel);


        // Ustawienie kierunekLabel
        layout.putConstraint(SpringLayout.NORTH, kierunekLabel, 15, SpringLayout.SOUTH, emailLabel);
        layout.putConstraint(SpringLayout.WEST, kierunekLabel, 60, SpringLayout.WEST, panel);


        // Ustawienie pól
        // Ustawienie imieField
        layout.putConstraint(SpringLayout.NORTH, imieField, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieField, odleglosc, SpringLayout.EAST, imieLabel);


        // Ustawienie nazwiskoField
        layout.putConstraint(SpringLayout.NORTH, nazwiskoField, 15, SpringLayout.SOUTH, imieField);
        layout.putConstraint(SpringLayout.WEST, nazwiskoField, odleglosc, SpringLayout.EAST, imieLabel);


        // Ustawienie wiekField
        layout.putConstraint(SpringLayout.NORTH, wiekField, 15, SpringLayout.SOUTH, nazwiskoField);
        layout.putConstraint(SpringLayout.WEST, wiekField, odleglosc, SpringLayout.EAST, imieLabel);


        // Ustawienie emailField
        layout.putConstraint(SpringLayout.NORTH, emailField, 15, SpringLayout.SOUTH, wiekField);
        layout.putConstraint(SpringLayout.WEST, emailField, odleglosc, SpringLayout.EAST, imieLabel);


        // Ustawienie kierunekField
        layout.putConstraint(SpringLayout.NORTH, kierunekField, 15, SpringLayout.SOUTH, emailField);
        layout.putConstraint(SpringLayout.WEST, kierunekField, odleglosc, SpringLayout.EAST, imieLabel);


        // Ustawienie zapiszButton
        layout.putConstraint(SpringLayout.NORTH, zapiszButton, 15, SpringLayout.SOUTH, kierunekField);
        layout.putConstraint(SpringLayout.WEST, zapiszButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, kierunekLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, kierunekField);


        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(imieField.getText().isEmpty() || nazwiskoField.getText().isEmpty() || wiekField.getText().isEmpty() || emailField.getText().isEmpty() || kierunekField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(AddStudent.this, "Nie podano wszystkich wymaganych danych.", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int wiek = 0;
                try {
                    wiek = Integer.parseInt(wiekField.getText());
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(AddStudent.this, "W polu wiek podano nieprawidlowe dane", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Student student = new Student(imieField.getText(), nazwiskoField.getText(), wiek, emailField.getText(), kierunekField.getText());

                if(student.rightStudent()){ // jeśli obiekt student spełnia warunki (wiek > 18, poprawny email i imie.length > 3)
                    JOptionPane.showMessageDialog(AddStudent.this, "Pomyślnie dodano studenta", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                    students.add(student);
                    AddStudent.this.dispose();
                    parent.setVisible(false);
                    MainPanel glownyPanel = new MainPanel(students, nauczyciele);
                }
                else{
                    JOptionPane.showMessageDialog(AddStudent.this, "Niepoprawne dane", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudent.this.dispose();
                parent.setVisible(true);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(AddStudent.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    AddStudent.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}

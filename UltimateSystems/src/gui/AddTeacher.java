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

public class AddTeacher extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieLabel = new JLabel("Imie");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko");
    private JLabel wiekLabel = new JLabel("Wiek");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel przedmiotLabel = new JLabel("Przedmiot");
    private JTextField imieField = new JTextField();
    private JTextField nazwiskoField = new JTextField();
    private JTextField wiekField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField przedmiotField = new JTextField();
    private JButton zapiszButton = new JButton("Zapisz");
    private JButton wrocButton = new JButton("Wróć");

    public AddTeacher(JFrame parent, List<Student> students, List<Nauczyciel> nauczyciele) throws HeadlessException {

        this.setTitle("Dodaj nauczyciela");
        this.setSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Dimension labelSize = new Dimension(150, 20);
        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;


        imieLabel.setPreferredSize(labelSize);
        nazwiskoLabel.setPreferredSize(labelSize);
        wiekLabel.setPreferredSize(labelSize);
        emailLabel.setPreferredSize(labelSize);
        przedmiotLabel.setPreferredSize(labelSize);

        imieField.setPreferredSize(fieldSize);
        nazwiskoField.setPreferredSize(fieldSize);
        wiekField.setPreferredSize(fieldSize);
        emailField.setPreferredSize(fieldSize);
        przedmiotField.setPreferredSize(fieldSize);

        zapiszButton.setPreferredSize(new Dimension(100,20));
        wrocButton.setPreferredSize(new Dimension(100, 20));

        panel.add(imieLabel);
        panel.add(nazwiskoLabel);
        panel.add(wiekLabel);
        panel.add(emailLabel);
        panel.add(przedmiotLabel);
        panel.add(imieField);
        panel.add(nazwiskoField);
        panel.add(wiekField);
        panel.add(emailField);
        panel.add(przedmiotField);
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


        // Ustawienie przedmiotLabel
        layout.putConstraint(SpringLayout.NORTH, przedmiotLabel, 15, SpringLayout.SOUTH, emailLabel);
        layout.putConstraint(SpringLayout.WEST, przedmiotLabel, 60, SpringLayout.WEST, panel);



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


        // Ustawienie przedmiotField
        layout.putConstraint(SpringLayout.NORTH, przedmiotField, 15, SpringLayout.SOUTH, emailField);
        layout.putConstraint(SpringLayout.WEST, przedmiotField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie zapiszButton
        layout.putConstraint(SpringLayout.NORTH, zapiszButton, 15, SpringLayout.SOUTH, przedmiotField);
        layout.putConstraint(SpringLayout.WEST, zapiszButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, przedmiotLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, przedmiotField);



        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(imieField.getText().isEmpty() || nazwiskoField.getText().isEmpty() || wiekField.getText().isEmpty() || emailField.getText().isEmpty() || przedmiotField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(AddTeacher.this, "Nie podano wszystkich wymaganych danych.", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int wiek = 0;
                try {
                    wiek = Integer.parseInt(wiekField.getText());
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(AddTeacher.this, "W polu wiek podano nieprawidlowe dane", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Nauczyciel nauczyciel = new Nauczyciel(imieField.getText(), nazwiskoField.getText(), wiek, emailField.getText(), przedmiotField.getText());

                if(nauczyciel.rightNauczyciel()){// jeśli obiekt nauczyciel spełnia warunki (wiek > 18, poprawny email i imie.length > 3)
                    JOptionPane.showMessageDialog(AddTeacher.this, "Pomyślnie dodano nauczyciela", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                    nauczyciele.add(nauczyciel);
                    AddTeacher.this.dispose();
                    parent.setVisible(false);
                    TeacherPanel panelNauczyciela = new TeacherPanel(students, nauczyciele);

                }
                else{
                    JOptionPane.showMessageDialog(AddTeacher.this, "Niepoprawne dane", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTeacher.this.dispose();
                parent.setVisible(true);

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(AddTeacher.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    AddTeacher.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}

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

public class EditTeacher extends JFrame {
    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieLabel = new JLabel("Imie");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko");
    private JLabel wiekLabel = new JLabel("Nowy wiek");
    private JLabel emailLabel = new JLabel("Nowy Email");
    private JLabel przedmiotLabel = new JLabel("Nowy przedmiot");
    private JLabel oldEmailLabel = new JLabel("Stary Email");
    private JLabel oldPrzedmiotLabel = new JLabel("Stary przedmiot");
    private JTextField imieField = new JTextField();
    private JTextField nazwiskoField = new JTextField();
    private JTextField wiekField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField przedmiotField = new JTextField();
    private JTextField oldEmailField = new JTextField();
    private JTextField oldPrzedmiotField = new JTextField();
    private JButton edytujButton = new JButton("Edytuj");
    private JButton wrocButton = new JButton("Wróć");
    public EditTeacher(JFrame parent, List<Student> students, List<Nauczyciel> listNauczyciel){

        this.setTitle("Edytuj nauczyciela");
        this.setSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Dimension labelSize = new Dimension(150, 20);
        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;

        imieLabel.setPreferredSize(labelSize);
        nazwiskoLabel.setPreferredSize(labelSize);
        wiekLabel.setPreferredSize(labelSize);
        emailLabel.setPreferredSize(labelSize);
        przedmiotLabel.setPreferredSize(labelSize);
        oldEmailLabel.setPreferredSize(labelSize);
        oldPrzedmiotLabel.setPreferredSize(labelSize);
        imieField.setPreferredSize(fieldSize);
        nazwiskoField.setPreferredSize(fieldSize);
        wiekField.setPreferredSize(fieldSize);
        emailField.setPreferredSize(fieldSize);
        przedmiotField.setPreferredSize(fieldSize);
        oldEmailField.setPreferredSize(fieldSize);
        oldPrzedmiotField.setPreferredSize(fieldSize);

        edytujButton.setPreferredSize(new Dimension(100,20));
        wrocButton.setPreferredSize(new Dimension(100, 20));

        panel.add(imieLabel);
        panel.add(nazwiskoLabel);
        panel.add(wiekLabel);
        panel.add(emailLabel);
        panel.add(przedmiotLabel);
        panel.add(oldEmailLabel);
        panel.add(oldPrzedmiotLabel);
        panel.add(imieField);
        panel.add(nazwiskoField);
        panel.add(wiekField);
        panel.add(emailField);
        panel.add(przedmiotField);
        panel.add(oldEmailField);
        panel.add(oldPrzedmiotField);
        panel.add(edytujButton);
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

        // Ustawienie oldEmailLabel
        layout.putConstraint(SpringLayout.NORTH, oldEmailLabel, 15, SpringLayout.SOUTH, przedmiotLabel);
        layout.putConstraint(SpringLayout.WEST, oldEmailLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie oldPrzedmiotLabel
        layout.putConstraint(SpringLayout.NORTH, oldPrzedmiotLabel, 15, SpringLayout.SOUTH, oldEmailLabel);
        layout.putConstraint(SpringLayout.WEST, oldPrzedmiotLabel, 60, SpringLayout.WEST, panel);


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

        // Ustawienie oldEmailField
        layout.putConstraint(SpringLayout.NORTH, oldEmailField, 15, SpringLayout.SOUTH, przedmiotField);
        layout.putConstraint(SpringLayout.WEST, oldEmailField, odleglosc, SpringLayout.EAST, imieLabel);


        // Ustawienie oldPrzedmiotField
        layout.putConstraint(SpringLayout.NORTH, oldPrzedmiotField, 15, SpringLayout.SOUTH, oldEmailField);
        layout.putConstraint(SpringLayout.WEST, oldPrzedmiotField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie edytujButton
        layout.putConstraint(SpringLayout.NORTH, edytujButton, 15, SpringLayout.SOUTH, oldPrzedmiotField);
        layout.putConstraint(SpringLayout.WEST, edytujButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, oldPrzedmiotLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, oldPrzedmiotField);

        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String imieNauczyciela = imieField.getText();
                String nazwiskoNauczyciela = nazwiskoField.getText();
                String oldEmailNauczyciela =  oldEmailField.getText();
                String oldPrzedmiotNauczyciela = oldPrzedmiotField.getText();
                String nowyKierunek = przedmiotField.getText();
                String nowyEmail = emailField.getText();

                int nowyWiek;
                try {
                    nowyWiek = Integer.parseInt(wiekField.getText());
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(EditTeacher.this, "Nieprawidłowe dane w polu wiek", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for(Nauczyciel n: listNauczyciel){
                    n.editNauczyciel(imieNauczyciela, nazwiskoNauczyciela, oldEmailNauczyciela, oldPrzedmiotNauczyciela,nowyWiek,nowyKierunek,nowyEmail);
                }
                JOptionPane.showMessageDialog(EditTeacher.this, "Pomyślnie edytowano studenta", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                EditTeacher.this.dispose();
                parent.setVisible(false);

                TeacherPanel panelNauczyciela = new TeacherPanel(students, listNauczyciel.stream().toList());
            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditTeacher.this.dispose();
                parent.setVisible(true);

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(EditTeacher.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    EditTeacher.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}

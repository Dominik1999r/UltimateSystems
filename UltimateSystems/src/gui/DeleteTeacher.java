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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeleteTeacher extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private  JLabel imieLabel = new JLabel("Imie");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko");
    private JLabel wiekLabel = new JLabel("Wiek");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel przedmiotLabel = new JLabel("Przedmiot");
    private JTextField imieField = new JTextField();
    private JTextField nazwiskoField = new JTextField();
    private JTextField wiekField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField przedmiotField = new JTextField();
    private JButton usunButton = new JButton("Usuń");
    private JButton wrocButton = new JButton("Wróć");

    public DeleteTeacher(JFrame parent, List<Student> students, List<Nauczyciel> listNauczyciel) throws HeadlessException {


        this.setTitle("Usun nauczyciela");
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

        usunButton.setPreferredSize(new Dimension(100,20));
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

        panel.add(usunButton);
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

        // Ustawienie przyciskow
        // Ustawienie usunButton
        layout.putConstraint(SpringLayout.NORTH, usunButton, 15, SpringLayout.SOUTH, przedmiotField);
        layout.putConstraint(SpringLayout.WEST, usunButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, przedmiotLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, przedmiotField);

        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(imieField.getText().isEmpty() || nazwiskoField.getText().isEmpty()){// Nie podano imienia i nazwiska
                    JOptionPane.showMessageDialog(DeleteTeacher.this, "Nie podano wymaganych danych. Podaj imie i nazwisko", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else if(wiekField.getText().isEmpty() && emailField.getText().isEmpty() && przedmiotField.getText().isEmpty()){

                    Stream<Nauczyciel> stream1 = listNauczyciel.stream();

                    String imieNauczyciela = imieField.getText();
                    String nazwiskoNauczyciela = nazwiskoField.getText();

                    Stream<Nauczyciel> streamFiltered = stream1.filter(n -> !n.deleteNauczyciel(imieNauczyciela, nazwiskoNauczyciela));
                    JOptionPane.showMessageDialog(DeleteTeacher.this, "Pomyślnie przeslano żądanie usunięcia nauczyciela. Podany użytkownik zostanie usunięty, jeśli znajduje się w bazie", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                    DeleteTeacher.this.dispose();
                    parent.setVisible(false);
                    TeacherPanel panelNauczyciela = new TeacherPanel(students, streamFiltered.collect(Collectors.toList()));
                }
                else if(!wiekField.getText().isEmpty() && !emailField.getText().isEmpty() && !przedmiotField.getText().isEmpty()){// Podano wszystkie dane

                    Stream<Nauczyciel> stream1 = listNauczyciel.stream();
                    String imieNauczyciela = imieField.getText();
                    String nazwiskoNauczyciela = nazwiskoField.getText();
                    String emailNauczyciela = emailField.getText();
                    String przedmiotNauczyciela = przedmiotField.getText();

                    int wiekNauczyciela;
                    try{
                        wiekNauczyciela = Integer.parseInt(wiekField.getText());
                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(DeleteTeacher.this, "Niepoprawne dane w polu wiek", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Stream<Nauczyciel> streamFiltered = stream1.filter(n -> !n.deleteNauczyciel(imieNauczyciela, nazwiskoNauczyciela, wiekNauczyciela, emailNauczyciela,przedmiotNauczyciela));
                    JOptionPane.showMessageDialog(DeleteTeacher.this, "Pomyślnie przeslano żadanie usunięcia nauczyciela. Podany użytkownik zostanie usunięty, jeśli znajduje się w bazie", "Sukces", JOptionPane.INFORMATION_MESSAGE);

                    DeleteTeacher.this.dispose();
                    parent.setVisible(false);
                    TeacherPanel panelNauczyciela = new TeacherPanel(students, streamFiltered.collect(Collectors.toList()));
                }
            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTeacher.this.dispose();
                parent.setVisible(true);

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(DeleteTeacher.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    DeleteTeacher.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}

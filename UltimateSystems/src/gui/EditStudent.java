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

public class EditStudent  extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieLabel = new JLabel("Imie");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko");
    private JLabel wiekLabel = new JLabel("Nowy wiek");
    private JLabel emailLabel = new JLabel("Nowy Email");
    private JLabel kierunekLabel = new JLabel("Nowy kierunek");
    private JLabel oldEmailLabel = new JLabel("Stary Email");
    private JLabel oldKierunekLabel = new JLabel("Stary kierunek");
    private JTextField imieField = new JTextField();
    private JTextField nazwiskoField = new JTextField();
    private JTextField wiekField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField kierunekField = new JTextField();
    private JTextField oldEmailField = new JTextField();
    private JTextField oldKierunekField = new JTextField();
    private JButton edytujButton = new JButton("Edytuj");
    private JButton wrocButton = new JButton("Wróć");
    public EditStudent(JFrame parent, List<Student> students, List<Nauczyciel> listNauczyciel){

        this.setTitle("Edytuj studenta");
        this.setSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Dimension labelSize = new Dimension(150, 20);
        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;

        imieLabel.setPreferredSize(labelSize);
        nazwiskoLabel.setPreferredSize(labelSize);
        wiekLabel.setPreferredSize(labelSize);
        emailLabel.setPreferredSize(labelSize);
        kierunekLabel.setPreferredSize(labelSize);
        oldEmailLabel.setPreferredSize(labelSize);
        oldKierunekLabel.setPreferredSize(labelSize);
        imieField.setPreferredSize(fieldSize);
        nazwiskoField.setPreferredSize(fieldSize);
        wiekField.setPreferredSize(fieldSize);
        emailField.setPreferredSize(fieldSize);
        kierunekField.setPreferredSize(fieldSize);
        oldEmailField.setPreferredSize(fieldSize);
        oldKierunekField.setPreferredSize(fieldSize);

        edytujButton.setPreferredSize(new Dimension(100,20));
        wrocButton.setPreferredSize(new Dimension(100, 20));

        panel.add(imieLabel);
        panel.add(nazwiskoLabel);
        panel.add(wiekLabel);
        panel.add(emailLabel);
        panel.add(kierunekLabel);
        panel.add(oldEmailLabel);
        panel.add(oldKierunekLabel);
        panel.add(imieField);
        panel.add(nazwiskoField);
        panel.add(wiekField);
        panel.add(emailField);
        panel.add(kierunekField);
        panel.add(oldEmailField);
        panel.add(oldKierunekField);
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

        // Ustawienie kierunekLabel
        layout.putConstraint(SpringLayout.NORTH, kierunekLabel, 15, SpringLayout.SOUTH, emailLabel);
        layout.putConstraint(SpringLayout.WEST, kierunekLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie oldEmailLabel
        layout.putConstraint(SpringLayout.NORTH, oldEmailLabel, 15, SpringLayout.SOUTH, kierunekLabel);
        layout.putConstraint(SpringLayout.WEST, oldEmailLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie oldkierunekLabel
        layout.putConstraint(SpringLayout.NORTH, oldKierunekLabel, 15, SpringLayout.SOUTH, oldEmailLabel);
        layout.putConstraint(SpringLayout.WEST, oldKierunekLabel, 60, SpringLayout.WEST, panel);


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

        // Ustawienie oldEmailField
        layout.putConstraint(SpringLayout.NORTH, oldEmailField, 15, SpringLayout.SOUTH, kierunekField);
        layout.putConstraint(SpringLayout.WEST, oldEmailField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie oldKierunekField
        layout.putConstraint(SpringLayout.NORTH, oldKierunekField, 15, SpringLayout.SOUTH, oldEmailField);
        layout.putConstraint(SpringLayout.WEST, oldKierunekField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie edytujButton
        layout.putConstraint(SpringLayout.NORTH, edytujButton, 15, SpringLayout.SOUTH, oldKierunekField);
        layout.putConstraint(SpringLayout.WEST, edytujButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, oldKierunekLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, oldKierunekField);


        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String imieStudenta = imieField.getText();
                String nazwiskoStudenta = nazwiskoField.getText();
                String oldEmailStudenta =  oldEmailField.getText();
                String oldKierunekStudenta = oldKierunekField.getText();
                String nowyKierunek = kierunekField.getText();
                String nowyEmail = emailField.getText();

                int nowyWiek;
                try {
                    nowyWiek = Integer.parseInt(wiekField.getText());
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(EditStudent.this, "Nieprawidłowe dane w polu wiek", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for(Student s: students){
                    s.editStudent(imieStudenta, nazwiskoStudenta, oldEmailStudenta, oldKierunekStudenta, nowyWiek, nowyKierunek, nowyEmail);
                }
                JOptionPane.showMessageDialog(EditStudent.this, "Pomyślnie edytowano studenta", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                EditStudent.this.dispose();
                parent.setVisible(false);
                MainPanel glownyPanel = new MainPanel(students.stream().toList(), listNauczyciel);
            }
        });


        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditStudent.this.dispose();
                parent.setVisible(true);

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(EditStudent.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    EditStudent.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}

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

public class Search extends JFrame {
    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieLabel = new JLabel("Imie");
    private JLabel nazwiskoLabel = new JLabel("Nazwisko");
    private JTextField imieField = new JTextField();
    private JTextField nazwiskoField = new JTextField();
    private JButton szukajButton = new JButton("Szukaj (terminal)");
    private  JButton wrocButton = new JButton("Wróć");
    public Search(JFrame parent, List<Student> students, List<Nauczyciel> nauczyciele) throws HeadlessException {

        this.setTitle("Szukaj użytkownika");
        this.setSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        Dimension labelSize = new Dimension(150, 20);
        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;

        imieLabel.setPreferredSize(labelSize);
        nazwiskoLabel.setPreferredSize(labelSize);
        imieField.setPreferredSize(fieldSize);
        nazwiskoField.setPreferredSize(fieldSize);

        szukajButton.setPreferredSize(new Dimension(140,20));
        wrocButton.setPreferredSize(new Dimension(100, 20));

        panel.add(imieLabel);
        panel.add(nazwiskoLabel);
        panel.add(imieField);
        panel.add(nazwiskoField);
        panel.add(szukajButton);
        panel.add(wrocButton);

        // Ustawienie imieLabel
        layout.putConstraint(SpringLayout.NORTH, imieLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie nazwiskoLabel
        layout.putConstraint(SpringLayout.NORTH, nazwiskoLabel, 15, SpringLayout.SOUTH, imieLabel);
        layout.putConstraint(SpringLayout.WEST, nazwiskoLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie pól
        // Ustawienie imieField
        layout.putConstraint(SpringLayout.NORTH, imieField, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie nazwiskoField
        layout.putConstraint(SpringLayout.NORTH, nazwiskoField, 15, SpringLayout.SOUTH, imieField);
        layout.putConstraint(SpringLayout.WEST, nazwiskoField, odleglosc, SpringLayout.EAST, imieLabel);

        // Ustawienie szukajButton
        layout.putConstraint(SpringLayout.NORTH, szukajButton, 15, SpringLayout.SOUTH, nazwiskoField);
        layout.putConstraint(SpringLayout.WEST, szukajButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, nazwiskoLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, nazwiskoField);

        szukajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(imieField.getText().isEmpty() || nazwiskoField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Search.this, "Nie podano wszystkich wymaganych danych.", "Niepowodzenia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(Search.this, "Jeśli użytkownik istnieje to zostanie wypisany (terminal)", "Sukces", JOptionPane.INFORMATION_MESSAGE);

                String imie = imieField.getText();
                String nazwisko = nazwiskoField.getText();

                for(Student s : students){
                    if(s.getImie().equals(imie) && s.getNazwisko().equals(nazwisko)){
                        System.out.println("Student");
                        s.showStudent();
                    }
                }
                for(Nauczyciel n : nauczyciele){
                    if(n.getImie().equals(imie) && n.getNazwisko().equals(nazwisko)){
                        System.out.println("Nauczyciel");
                        n.showNauczyciel();
                    }
                }
            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search.this.dispose();
                parent.setVisible(true);

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(Search.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    Search.this.dispose();
                }
            }
        });

        this.add(panel);
        this.setVisible(true);
    }
}

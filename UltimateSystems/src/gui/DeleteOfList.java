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

public class DeleteOfList extends JFrame {

    private SpringLayout layout = new SpringLayout();
    private JPanel panel = new JPanel(layout);
    private JLabel imieStudentaLabel = new JLabel("Imie studenta");
    private JLabel nazwiskoStudentaLabel = new JLabel("Nazwisko studenta");
    private JLabel kierunekStudentaLabel = new JLabel("Kierunek studenta");
    private JLabel imieNauczycielaLabel = new JLabel("Imie nauczyciela");
    private JLabel nazwiskoNauczycielaLabel = new JLabel("Nazwisko nauczyciela");
    private JLabel przedmiotNauczycielaLabel = new JLabel("Przedmiot nauczyciela");
    private JTextField imieStudentaField = new JTextField();
    private JTextField nazwiskoStudentaField = new JTextField();
    private JTextField kierunekStudentaField = new JTextField();
    private JTextField imieNauczycielaField = new JTextField();
    private JTextField nazwiskoNauczycielaField = new JTextField();
    private JTextField przedmiotNauczycielaField = new JTextField();
    private JButton usunButton = new JButton("Usuń");
    private  JButton wrocButton = new JButton("Wróć");

    public DeleteOfList(JFrame parent, List<Student> students, List<Nauczyciel> listNauczyciel){

        this.setTitle("Usun studenta z listy nauczyciela i na odwrót");
        this.setSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        Dimension labelSize = new Dimension(150, 20);
        Dimension fieldSize = new Dimension(150, 20);
        int odleglosc = 30;

        imieStudentaLabel.setPreferredSize(labelSize);
        nazwiskoStudentaLabel.setPreferredSize(labelSize);
        kierunekStudentaLabel.setPreferredSize(labelSize);
        imieNauczycielaLabel.setPreferredSize(labelSize);
        nazwiskoNauczycielaLabel.setPreferredSize(labelSize);
        przedmiotNauczycielaLabel.setPreferredSize(labelSize);
        imieStudentaField.setPreferredSize(fieldSize);
        nazwiskoStudentaField.setPreferredSize(fieldSize);
        kierunekStudentaField.setPreferredSize(fieldSize);
        imieNauczycielaField.setPreferredSize(fieldSize);
        nazwiskoNauczycielaField.setPreferredSize(fieldSize);
        przedmiotNauczycielaField.setPreferredSize(fieldSize);

        usunButton.setPreferredSize(new Dimension(100,20));
        wrocButton.setPreferredSize(new Dimension(100, 20));

        panel.add(imieStudentaLabel);
        panel.add(nazwiskoStudentaLabel);
        panel.add(kierunekStudentaLabel);
        panel.add(imieNauczycielaLabel);
        panel.add(nazwiskoNauczycielaLabel);
        panel.add(przedmiotNauczycielaLabel);
        panel.add(imieStudentaField);
        panel.add(nazwiskoStudentaField);
        panel.add(kierunekStudentaField);
        panel.add(imieNauczycielaField);
        panel.add(nazwiskoNauczycielaField);
        panel.add(przedmiotNauczycielaField);
        panel.add(usunButton);
        panel.add(wrocButton);


        // Ustawienie imieStudentaLabel
        layout.putConstraint(SpringLayout.NORTH, imieStudentaLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie nazwiskoStudentaLabel
        layout.putConstraint(SpringLayout.NORTH, nazwiskoStudentaLabel, 15, SpringLayout.SOUTH, imieStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, nazwiskoStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie kierunekStudentaLabel
        layout.putConstraint(SpringLayout.NORTH, kierunekStudentaLabel, 15, SpringLayout.SOUTH, nazwiskoStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, kierunekStudentaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie imieNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, imieNauczycielaLabel, 15, SpringLayout.SOUTH, kierunekStudentaLabel);
        layout.putConstraint(SpringLayout.WEST, imieNauczycielaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie nazwiskoNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, nazwiskoNauczycielaLabel, 15, SpringLayout.SOUTH, imieNauczycielaLabel);
        layout.putConstraint(SpringLayout.WEST, nazwiskoNauczycielaLabel, 60, SpringLayout.WEST, panel);

        // Ustawienie przedmiotNauczycielaLabel
        layout.putConstraint(SpringLayout.NORTH, przedmiotNauczycielaLabel, 15, SpringLayout.SOUTH, nazwiskoNauczycielaLabel);
        layout.putConstraint(SpringLayout.WEST, przedmiotNauczycielaLabel, 60, SpringLayout.WEST, panel);


        // Ustawienie pól
        // Ustawienie imieStudentaField
        layout.putConstraint(SpringLayout.NORTH, imieStudentaField, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imieStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie nazwiskoStudentaField
        layout.putConstraint(SpringLayout.NORTH, nazwiskoStudentaField, 15, SpringLayout.SOUTH, imieStudentaField);
        layout.putConstraint(SpringLayout.WEST, nazwiskoStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie kierunekStudentaField
        layout.putConstraint(SpringLayout.NORTH, kierunekStudentaField, 15, SpringLayout.SOUTH, nazwiskoStudentaField);
        layout.putConstraint(SpringLayout.WEST, kierunekStudentaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie imieNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, imieNauczycielaField, 15, SpringLayout.SOUTH, kierunekStudentaField);
        layout.putConstraint(SpringLayout.WEST, imieNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie nazwiskoNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, nazwiskoNauczycielaField, 15, SpringLayout.SOUTH, imieNauczycielaField);
        layout.putConstraint(SpringLayout.WEST, nazwiskoNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie przedmiotNauczycielaField
        layout.putConstraint(SpringLayout.NORTH, przedmiotNauczycielaField, 15, SpringLayout.SOUTH, nazwiskoNauczycielaField);
        layout.putConstraint(SpringLayout.WEST, przedmiotNauczycielaField, odleglosc, SpringLayout.EAST, imieStudentaLabel);

        // Ustawienie usunButton
        layout.putConstraint(SpringLayout.NORTH, usunButton, 15, SpringLayout.SOUTH, przedmiotNauczycielaField);
        layout.putConstraint(SpringLayout.WEST, usunButton, 60, SpringLayout.WEST, panel);

        // Ustawienie wrocButton
        layout.putConstraint(SpringLayout.NORTH, wrocButton, 15, SpringLayout.SOUTH, przedmiotNauczycielaLabel);
        layout.putConstraint(SpringLayout.EAST, wrocButton, 0, SpringLayout.EAST, przedmiotNauczycielaField);

        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String imieStudenta = imieStudentaField.getText();
                String nazwiskoStudenta = nazwiskoStudentaField.getText();
                String kierunekStudenta = kierunekStudentaField.getText();

                String imieNauczyciela = imieNauczycielaField.getText();
                String nazwiskoNauczyciela = nazwiskoNauczycielaField.getText();
                String przedmiotNauczyciela =  przedmiotNauczycielaField.getText();


                for(Student s : students) {
                    if(s.getImie().equals(imieStudenta) && s.getNazwisko().equals(nazwiskoStudenta) && s.getKierunek().equals(kierunekStudenta))
                        s.deleteNauczyciel(imieNauczyciela, nazwiskoNauczyciela, przedmiotNauczyciela);
                }
                for(Nauczyciel n : listNauczyciel){
                    if(n.getImie().equals(imieNauczyciela) && n.getNazwisko().equals(nazwiskoNauczyciela) && n.getPrzedmiot().equals(przedmiotNauczyciela))
                        n.deleteStudent(imieStudenta, nazwiskoStudenta, kierunekStudenta);
                }
                JOptionPane.showMessageDialog(DeleteOfList.this, "Jeśli podani użytkownicy istnieją, to zostanie usunięte powiązanie studenta z nauczycielem", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(DeleteOfList.this, "Czy na pewno chcesz zamknąć okno?", "Zamykanie okna", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                    parent.setVisible(true);
                    DeleteOfList.this.dispose();
                }
            }
        });

        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteOfList.this.dispose();
                parent.setVisible(true);

            }
        });

        this.add(panel);
        this.setVisible(true);

    }
}

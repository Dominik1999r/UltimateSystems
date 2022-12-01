package model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Nauczyciel {

    private String imie;
    private String nazwisko;
    private int wiek;
    private String email;
    private String przedmiot;
    private List<Student> listStudent = new ArrayList<>();

    public Nauczyciel(String imie, String nazwisko, int wiek, String email, String przedmiot, List<Student> listStudent) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.email = email;
        this.przedmiot = przedmiot;
        this.listStudent = listStudent;
    }

    public Nauczyciel(String imie, String nazwisko, int wiek, String email, String przedmiot) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.email = email;
        this.przedmiot = przedmiot;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public List<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
    }
    public boolean deleteNauczyciel(String imie, String nazwisko) {
        if (this.imie.equals(imie) && this.nazwisko.equals(nazwisko)) {
            return true;
        }
        return false;
    }
    public boolean deleteNauczyciel(String imie, String nazwisko, int wiek, String email, String kierunek) {
        if (this.imie.equals(imie) && this.nazwisko.equals(nazwisko) && this.wiek == wiek && this.email.equals(email) && this.przedmiot.equals(kierunek)) {
            return true;
        }
        return false;
    }

    public boolean rightNauczyciel(){
        if(isValidEmailAddress(this.email) && this.wiek > 18 && this.imie.length() > 2){
            return true;
        }
        return false;
    }
    public boolean rightNauczyciel(String email, int wiek, String imie){
        if(isValidEmailAddress(email) && wiek > 18 && imie.length() > 2){
            return true;
        }
        return false;
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }


    public boolean checkNauczyciel(String imieNauczyciela, String nazwiskoNauczyciela, int wiekNauczyciela ,String emailNauczyciela, String przedmiotNauczyciela){
        if(this.imie.equals(imieNauczyciela) && this.nazwisko.equals(nazwiskoNauczyciela) && this.wiek == wiekNauczyciela && this.email.equals(emailNauczyciela) && this.przedmiot.equals(przedmiotNauczyciela)){
            return true;
        }
        return false;
    }
    public void addStudent(String imieStudenta, String nazwiskoStudenta, int wiekStudenta, String emailStudenta, String kierunekStudenta) {
        Student student = new Student(imieStudenta, nazwiskoStudenta, wiekStudenta, emailStudenta, kierunekStudenta);
        this.listStudent.add(student);
    }

    public void showNauczyciel(){
        System.out.println("imie: " + this.imie);
        System.out.println("nazwisko: " + this.nazwisko);
        System.out.println("wiek: " + this.wiek);
        System.out.println("email: " + this.email);
        System.out.println("przedmiot: " + this.przedmiot);
        if(this.listStudent.size() > 0){
            System.out.print("Uczeni studenci: ");
            for(Student student : listStudent){
                System.out.print(student.getImie() + " " + student.getNazwisko() + ", ");
            }
        }
        System.out.println();
        System.out.println();
    }
    public void editNauczyciel(String imieNauczyciela, String nazwiskoNauczyciela, String oldEmailNauczyciela, String oldPrzedmiotNauczyciela, int nowyWiek, String nowyPrzedmiot, String nowyEmail) {
        if(this.imie.equals(imieNauczyciela) && this.nazwisko.equals(nazwiskoNauczyciela) && this.email.equals(oldEmailNauczyciela) && this.przedmiot.equals(oldPrzedmiotNauczyciela)){

            if(rightNauczyciel(nowyEmail, nowyWiek, this.imie)) {
                this.wiek = nowyWiek;
                this.przedmiot = nowyPrzedmiot;
                this.email = nowyEmail;
            }
            else {
                System.out.println("Niepoprawne dane nauczyciela!");
            }
        }
    }

    public boolean istniejeStudent(String imieStudenta, String nazwiskoStudenta, String kierunekStudenta){
        for(Student s : this.listStudent){
            if(s.getImie().equals(imieStudenta) && s.getNazwisko().equals(nazwiskoStudenta) && s.getKierunek().equals(kierunekStudenta)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "cielicki.Nauczyciel{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", email='" + email + '\'' +
                ", przedmiot='" + przedmiot + '\'' +
                ", listStudent=" + listStudent +
                '}';
    }

    public void deleteStudent(String imieStudenta, String nazwiskoStudenta, String kierunekStudenta) {
        for(Student s : this.listStudent){
            if(s.getImie().equals(imieStudenta) && s.getNazwisko().equals(nazwiskoStudenta)  && s.getKierunek().equals(kierunekStudenta)){
                Stream<Student> stream1 = this.listStudent.stream();
                Stream<Student> streamFiltered = stream1.filter(n -> !n.equals(s));
                this.listStudent = streamFiltered.collect(Collectors.toList());
            }
        }
    }
}
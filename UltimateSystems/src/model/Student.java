package model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {

    private String imie;
    private String nazwisko;
    private int wiek;
    private String email;
    private String kierunek;

    private List<Nauczyciel> listNauczyciel = new ArrayList<>();

    public Student(String imie, String nazwisko, int wiek, String email, String kierunek, List<Nauczyciel> listNauczyciel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.email = email;
        this.kierunek = kierunek;
        this.listNauczyciel = listNauczyciel;
    }


    public Student(String imie, String nazwisko, int wiek, String email, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.email = email;
        this.kierunek = kierunek;
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

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public List<Nauczyciel> getListNauczyciel() {
        return listNauczyciel;
    }

    public void setListNauczyciel(List<Nauczyciel> listNauczyciel) {
        this.listNauczyciel = listNauczyciel;
    }

    public void setNauczyciel(String imie, String nazwisko, int wiek, String email, String przedmiot) {
        Nauczyciel nauczyciel = new Nauczyciel(imie, nazwisko, wiek, email, przedmiot);
        this.listNauczyciel.add(nauczyciel);
    }

    public boolean deleteStudent(String imie, String nazwisko, int wiek, String email, String kierunek) {
        if (this.imie.equals(imie) && this.nazwisko.equals(nazwisko) && this.wiek == wiek && this.email.equals(email) && this.kierunek.equals(kierunek)) {
            return true;
        }
        return false;
    }
    public boolean deleteStudent(String imie, String nazwisko) {
        if (this.imie.equals(imie) && this.nazwisko.equals(nazwisko)) {
            return true;
        }
        return false;
    }

    public void editStudent( String imieStudenta,String nazwiskoStudenta,String oldEmailStudenta,String oldKierunekStudenta,int nowyWiek,String nowyKierunek,String nowyEmail){
        if(this.imie.equals(imieStudenta) && this.nazwisko.equals(nazwiskoStudenta) && this.email.equals(oldEmailStudenta) && this.kierunek.equals(oldKierunekStudenta)){

            if(rightStudent(nowyEmail, nowyWiek, this.imie)) {
                this.wiek = nowyWiek;
                this.kierunek = nowyKierunek;
                this.email = nowyEmail;
            }
            else {
                System.out.println("Niepoprawne dane studenta!");
            }
        }
    }
    public boolean rightStudent(){
        if(isValidEmailAddress(this.email) && this.wiek > 18 && this.imie.length() > 2){
            return true;
        }
        return false;
    }
    public boolean rightStudent(String email, int wiek, String imie){
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

    public boolean checkStudent(String imieStudenta, String nazwiskoStudenta, String emailStudenta, String kierunekStudenta){
        if(this.imie.equals(imieStudenta) && this.nazwisko.equals(nazwiskoStudenta) && this.email.equals(emailStudenta) && this.kierunek.equals(kierunekStudenta)){
            return true;
        }
        return false;
    }
    public void addNauczyciel(String imieNauczyciela, String nazwiskoNauczyciela, int wiekNauczyciela, String emailNauczyciela, String przedmiotNauczyciela){
        Nauczyciel nauczyciel = new Nauczyciel(imieNauczyciela, nazwiskoNauczyciela, wiekNauczyciela, emailNauczyciela, przedmiotNauczyciela);
        this.listNauczyciel.add(nauczyciel);
    }

    public void showStudent(){
        System.out.println("imie: " + this.imie);
        System.out.println("nazwisko: " + this.nazwisko);
        System.out.println("wiek: " + this.wiek);
        System.out.println("email: " + this.email);
        System.out.println("kierunek: " + this.kierunek);
        /*
        if(this.listNauczyciel.size() > 0){
            System.out.print("Lista nauczycieli danego studenta: ");
            for(Nauczyciel n : listNauczyciel){
                System.out.print(n.getImie() + " " + n.getNazwisko() + ", ");
            }
            System.out.println();
        }
         */
        System.out.println();
    }
    public void deleteNauczyciel(String imieNauczyciela, String nazwiskoNauczyciela,String przedmiotNauczyciela){
        for(Nauczyciel n : this.listNauczyciel){
            if(n.getImie().equals(imieNauczyciela) && n.getNazwisko().equals(nazwiskoNauczyciela)  && n.getPrzedmiot().equals(przedmiotNauczyciela)){
                Stream<Nauczyciel> stream1 = this.listNauczyciel.stream();
                Stream<Nauczyciel> streamFiltered = stream1.filter(s -> !s.equals(n));
                this.listNauczyciel = streamFiltered.collect(Collectors.toList());
            }
        }
    }
    public boolean istniejeNauczyciel(String imieNauczyciela, String nazwiskoNauczyciela, String przedmiotNauczyciela){
        for(Nauczyciel n : this.listNauczyciel){
            if(n.getImie().equals(imieNauczyciela) && n.getNazwisko().equals(nazwiskoNauczyciela) && n.getPrzedmiot().equals(przedmiotNauczyciela)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "cielicki.Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", email='" + email + '\'' +
                ", kierunek='" + kierunek + '\'' +
                ", listNauczyciel=" + listNauczyciel +
                '}';
    }
}

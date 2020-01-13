package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Aby klasa miała odniesienie do bazy danych konieczne jest dopisanie tej adnotacji
@Data //generuje settery, gettery, oraz metody z klasy Object
@AllArgsConstructor //wygeneruje nam konstruktor ustawiający wszystkie pola
public class AppUser {
    @Id //oznacza adnotację dla klucza głównego
    @GeneratedValue(strategy = GenerationType.AUTO) //pozwala na przejęcie odpowiedzialności za generowanie kluczy głównych przez TopLink,
    // który posługuje się pomocniczą tabelą przechowującą wartości potrzebne do generowania kluczy
    private long id;

    private String email;
    private String password;
    private String name;
    private String surname;

    /**
     * Tylko hasło i email ponieważ od resjestrującego bedzie wymagane wyłacznie haslo i email, pozostałe dane będzie można oddoać potem.
     * @param email
     * @param password
     */
    public AppUser(String email, String password){
        this.email = email;
        this.password = password;
    }
}

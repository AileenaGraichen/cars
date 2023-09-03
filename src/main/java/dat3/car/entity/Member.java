package dat3.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Member extends AdminDetails{

    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    private String password;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "street", nullable = false, length = 50)
    private String street;
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @Column(name = "zip_code", nullable = false, length = 50)
    private String zip;

    private boolean approved;
    private int ranking;

    public Member(String username, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public void setLastEdited(LocalDateTime now) {
    }
}


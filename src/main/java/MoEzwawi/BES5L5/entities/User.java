package MoEzwawi.BES5L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Setter
    private String username;
    @Setter
    @Column(name = "full_name")
    private String fullName;
    @Setter
    private String email;
    @Column(name = "birthday")
    private Date dateOfBirth;
    @OneToMany(mappedBy = "user")
    private List<Booking> listOfBookings;

    public User(String username, String fullName, String email, Date dateOfBirth) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

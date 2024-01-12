package MoEzwawi.BES5L5.entities;

import MoEzwawi.BES5L5.exceptions.DateNotAvailableException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Getter
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    private long id;
    @Setter
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Workspace workspace;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;


    public Booking(LocalDate date, Workspace workspace, User user) {
        this.date = date;
        this.workspace = workspace;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", date=" + date +
                ", workspace=" + workspace.getType() +", n°=" + workspace.getId() +
                ", user=" + user.getUsername() +
                '}';
    }
}

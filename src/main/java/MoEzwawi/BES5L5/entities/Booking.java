package MoEzwawi.BES5L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Workspace workspace;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    private boolean isDateAvailable(LocalDate date, Workspace workspace, User user){
        return (workspace.getListOfBookings().stream()
                .noneMatch(booking -> booking.getDate().equals(date))
                )
                &&
                (user.getListOfBookings().stream()
                .noneMatch(booking -> booking.getDate().equals(date))
                );
    }

    public Booking(LocalDate date, Workspace workspace, User user) {
        if (isDateAvailable(date,workspace,user)) {
            this.date = date;
            this.workspace = workspace;
            this.user = user;
        } else System.err.println("date not available");
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
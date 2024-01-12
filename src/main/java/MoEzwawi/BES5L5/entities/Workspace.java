package MoEzwawi.BES5L5.entities;


import MoEzwawi.BES5L5.entities.enums.WorkspaceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "workspaces")
@Getter
@NoArgsConstructor
public class Workspace {
    @Id
    @GeneratedValue
    private long id;
    @Setter
    private String description;
    @Setter
    @Enumerated(EnumType.STRING)
    private WorkspaceType type;
    @Setter
    @Column(name = "max_capacity")
    private int maximumCapacity;
    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
    @OneToMany(mappedBy = "workspace")
    private List<Booking> listOfBookings;

    public Workspace(String description, WorkspaceType type, int maximumCapacity, Building building) {
        this.description = description;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", maximumCapacity=" + maximumCapacity +
                ", building=" + building.getName() +
                '}';
    }
}

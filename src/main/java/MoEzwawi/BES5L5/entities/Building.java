package MoEzwawi.BES5L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "buildings")
@Getter
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    private long id;
    @Setter
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "building")
    private List<Workspace> workspaces;

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

package MoEzwawi.BES5L5.spring_data.repositories;

import MoEzwawi.BES5L5.entities.Booking;
import MoEzwawi.BES5L5.entities.User;
import MoEzwawi.BES5L5.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByWorkspace(Workspace workspace);
    List<Booking> findByUser(User user);
}

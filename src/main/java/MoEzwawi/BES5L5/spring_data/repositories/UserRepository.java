package MoEzwawi.BES5L5.spring_data.repositories;

import MoEzwawi.BES5L5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}

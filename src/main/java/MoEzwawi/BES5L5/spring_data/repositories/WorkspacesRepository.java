package MoEzwawi.BES5L5.spring_data.repositories;

import MoEzwawi.BES5L5.entities.Workspace;
import MoEzwawi.BES5L5.entities.enums.WorkspaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspacesRepository extends JpaRepository<Workspace,Long> {
    List<Workspace> findByType(WorkspaceType type);

    @Query("SELECT w FROM Workspace w WHERE w.building.city LIKE :city")
    public List<Workspace> findByCity(String city);
}

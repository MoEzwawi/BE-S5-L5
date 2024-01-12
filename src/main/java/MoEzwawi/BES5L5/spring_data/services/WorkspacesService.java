package MoEzwawi.BES5L5.spring_data.services;

import MoEzwawi.BES5L5.entities.Workspace;
import MoEzwawi.BES5L5.entities.enums.WorkspaceType;
import MoEzwawi.BES5L5.exceptions.ItemNotFoundException;
import MoEzwawi.BES5L5.spring_data.repositories.WorkspacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspacesService {
    @Autowired
    private WorkspacesRepository workspacesRepository;
    public void save(Workspace building){
        workspacesRepository.save(building);
        System.out.println("Workspace saved correctly");
    }
    public Workspace findById(long id) throws ItemNotFoundException {
        Optional<Workspace> buildingOptional = workspacesRepository.findById(id);
        if (buildingOptional.isPresent()) return buildingOptional.get();
        else throw new ItemNotFoundException("Workspace n° " + id + " not found");
    }
    public void deleteById(long id){
        workspacesRepository.deleteById(id);
        System.out.println("Workspace correctly deleted from db");
    }
    public List<Workspace> findAll(){
        return workspacesRepository.findAll();
    }
    public void findByIdAndUpdateDescription(long id, String newDescription){
        Workspace found = this.findById(id);
        found.setDescription(newDescription);
        workspacesRepository.save(found);
        System.out.println("Description correctly updated");
    }
    public void findByIdAndUpdateType(long id, WorkspaceType type){
        Workspace found = this.findById(id);
        found.setType(type);
        workspacesRepository.save(found);
        System.out.println("Type correctly updated");
    }
    public void findByIdAndUpdateCapacity(long id, int newCapacity){
        Workspace found = this.findById(id);
        found.setMaximumCapacity(newCapacity);
        workspacesRepository.save(found);
        System.out.println("Max capacity correctly updated");
    }

    public long count(){
        return workspacesRepository.count();
    }
}

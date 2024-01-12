package MoEzwawi.BES5L5.spring_data.services;

import MoEzwawi.BES5L5.entities.Building;
import MoEzwawi.BES5L5.exceptions.ItemNotFoundException;
import MoEzwawi.BES5L5.spring_data.repositories.BuildingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingsService {
    @Autowired
    private BuildingsRepository buildingsRepository;
    public void save(Building building){
        buildingsRepository.save(building);
        System.out.println("Building saved correctly");
    }
    public Building findById(long id) throws ItemNotFoundException {
        Optional<Building> buildingOptional = buildingsRepository.findById(id);
        if (buildingOptional.isPresent()) return buildingOptional.get();
        else throw new ItemNotFoundException("Building n° " + id + " not found");
    }
    public void deleteById(long id){
        buildingsRepository.deleteById(id);
        System.out.println("Building correctly deleted from db");
    }
    public List<Building> findAll(){
        return buildingsRepository.findAll();
    }
    public void findByIdAndUpdateName(long id, String newName){
        Building found = this.findById(id);
        found.setName(newName);
        buildingsRepository.save(found);
        System.out.println("Name correctly updated");
    }
    public long count(){
        return buildingsRepository.count();
    }
}

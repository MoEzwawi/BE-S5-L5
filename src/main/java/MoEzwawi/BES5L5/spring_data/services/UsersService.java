package MoEzwawi.BES5L5.spring_data.services;

import MoEzwawi.BES5L5.entities.User;
import MoEzwawi.BES5L5.exceptions.ItemNotFoundException;
import MoEzwawi.BES5L5.spring_data.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    public void save(User user){
        usersRepository.save(user);
        System.out.println("User saved correctly");
    }
    public User findById(long id) throws ItemNotFoundException {
        Optional<User> userOptional = usersRepository.findById(id);
        if (userOptional.isPresent()) return userOptional.get();
        else throw new ItemNotFoundException("User n° " + id + " not found");
    }
    public void deleteById(long id){
        usersRepository.deleteById(id);
        System.out.println("User correctly deleted from db");
    }
    public List<User> findAll(){
        return usersRepository.findAll();
    }
    public void findByIdAndUpdateUsername(long id, String newUsername){
        User found = this.findById(id);
        found.setUsername(newUsername);
        usersRepository.save(found);
        System.out.println("Username correctly updated");
    }
    public void findByIdAndUpdateFullName(long id, String newName){
        User found = this.findById(id);
        found.setFullName(newName);
        usersRepository.save(found);
        System.out.println("Name correctly updated");
    }
    public void findByIdAndUpdateEmail(long id, String newEmail){
        User found = this.findById(id);
        found.setEmail(newEmail);
        usersRepository.save(found);
        System.out.println("User's email correctly updated");
    }
    public long count(){
        return usersRepository.count();
    }
}


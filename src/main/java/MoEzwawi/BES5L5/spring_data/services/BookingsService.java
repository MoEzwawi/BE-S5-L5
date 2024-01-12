package MoEzwawi.BES5L5.spring_data.services;

import MoEzwawi.BES5L5.entities.Booking;
import MoEzwawi.BES5L5.exceptions.ItemNotFoundException;
import MoEzwawi.BES5L5.spring_data.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingsService {
    @Autowired
    private BookingsRepository bookingsRepository;
    public void save(Booking booking){
        bookingsRepository.save(booking);
        System.out.println("Booking saved correctly");
    }
    public Booking findById(long id) throws ItemNotFoundException {
        Optional<Booking> bookingOptional = bookingsRepository.findById(id);
        if (bookingOptional.isPresent()) return bookingOptional.get();
        else throw new ItemNotFoundException("Booking n° " + id + " not found");
    }
    public void deleteById(long id){
        bookingsRepository.deleteById(id);
        System.out.println("Booking correctly deleted from db");
    }
    public List<Booking> findAll(){
        return bookingsRepository.findAll();
    }
    public void findByIdAndUpdateDate(long id, LocalDate newDate){
        Booking found = this.findById(id);
        found.setDate(newDate);
        bookingsRepository.save(found);
        System.out.println("Date correctly updated");
    }
    public long count(){
        return bookingsRepository.count();
    }
}


package MoEzwawi.BES5L5.spring_data.services;

import MoEzwawi.BES5L5.entities.Booking;
import MoEzwawi.BES5L5.entities.User;
import MoEzwawi.BES5L5.entities.Workspace;
import MoEzwawi.BES5L5.exceptions.DateNotAvailableException;
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

    public List<Booking> filterByWorkspace(Workspace workspace){
        return bookingsRepository.findByWorkspace(workspace);
    }
    public List<Booking> filterByUser(User user){
        return bookingsRepository.findByUser(user);
    }
    private boolean isDateAvailable(Booking booking){
        return (this.filterByWorkspace(booking.getWorkspace()).stream()
                .noneMatch(b -> b.getDate().equals(booking.getDate()))
        )
                &&
                (this.filterByUser(booking.getUser()).stream()
                        .noneMatch(b -> b.getDate().equals(booking.getDate()))
                );
    }
    public void save(Booking booking){
        if(this.isDateAvailable(booking)) {
            bookingsRepository.save(booking);
            System.out.println("Booking saved correctly");
        } else {
            throw new DateNotAvailableException("Date not available");
        }
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
        if(this.isDateAvailable(found)) {
            found.setDate(newDate);
            bookingsRepository.save(found);
            System.out.println("Date correctly updated");
        } else {
            throw new DateNotAvailableException("Date not available");
        }
    }
    public long count(){
        return bookingsRepository.count();
    }
}


package MoEzwawi.BES5L5;

import MoEzwawi.BES5L5.entities.Booking;
import MoEzwawi.BES5L5.entities.Building;
import MoEzwawi.BES5L5.entities.User;
import MoEzwawi.BES5L5.entities.Workspace;
import MoEzwawi.BES5L5.entities.enums.WorkspaceType;
import MoEzwawi.BES5L5.functionalities.DateParser;
import MoEzwawi.BES5L5.spring_data.services.BookingsService;
import MoEzwawi.BES5L5.spring_data.services.BuildingsService;
import MoEzwawi.BES5L5.spring_data.services.UsersService;
import MoEzwawi.BES5L5.spring_data.services.WorkspacesService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class BookingManagementRunner implements CommandLineRunner {
    @Autowired
    private BookingsService bookingsService;
    @Autowired
    private BuildingsService buildingsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private WorkspacesService workspacesService;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Faker fakerIt = new Faker(new java.util.Locale("it"));
        Random random = new Random();
        /*buildingsService.save(new Building("The shard","London Bridge","London"));
        buildingsService.save(new Building("Burj Khalifa","Sheikh Zayed Road","Dubai"));
        buildingsService.save(new Building("Empire State Building","34th St Manhattan","New York City"));
        buildingsService.save(new Building("Bosco Verticale","Via Federico Confalonieri","Milan"));*/
       /* usersService.save(new User(faker.dragonBall().character(),fakerIt.name().fullName(),faker.internet().emailAddress(), faker.date().birthday(18,99)));
        usersService.save(new User(faker.dragonBall().character(),fakerIt.name().fullName(),faker.internet().emailAddress(), faker.date().birthday(18,99)));*/
        Building shard = buildingsService.findById(1);
        Building burj = buildingsService.findById(2);
        Building empire = buildingsService.findById(3);
        Building bosco = buildingsService.findById(4);
        /*for (int i = 0; i<10; i++){
            workspacesService.save(new Workspace("amazing", WorkspaceType.PRIVATE,25,shard));
        }
        for (int i = 0; i<10; i++){
            workspacesService.save(new Workspace("amazing", WorkspaceType.MEETING_ROOM,50,burj));
        }
        for (int i = 0; i<10; i++){
            workspacesService.save(new Workspace("amazing", WorkspaceType.OPENSPACE,75,empire));
        }
        for (int i = 0; i<10; i++){
            workspacesService.save(new Workspace("amazing", WorkspaceType.PRIVATE,35,bosco));
        }*/
        /*User u1 = usersService.findById(2);
        Workspace w1 = workspacesService.findById(53);
        Booking b1 = new Booking(DateParser.parseDateForItaly("13/03/2024"),w1,u1);
        bookingsService.save(b1);*/
        List<Workspace> li1 = workspacesService.filterByType(WorkspaceType.PRIVATE);
        System.out.println(li1.toString());
    }
}

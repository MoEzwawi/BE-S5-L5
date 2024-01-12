package MoEzwawi.BES5L5;

import MoEzwawi.BES5L5.spring_data.services.BookingsService;
import MoEzwawi.BES5L5.spring_data.services.BuildingsService;
import MoEzwawi.BES5L5.spring_data.services.UsersService;
import MoEzwawi.BES5L5.spring_data.services.WorkspacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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

    }
}

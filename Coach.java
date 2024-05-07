import java.util.ArrayList;
import java.util.List;

public class Coach extends UserBase {

    private final List<Costumer> myCostumers;

    Coach(String name, String surname, String mail, String password) {
        super(name, surname, mail, password);
        myCostumers = new ArrayList<>();
    }

    public List<Costumer> getCostumers() {
        return myCostumers;
    }
}

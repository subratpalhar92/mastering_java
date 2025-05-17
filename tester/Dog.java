import java.lang.*;

public class Dog {

    public String name = "Kerio";

    public String getName() {
        return this.name;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dog && ((Dog)obj).getName() == this.getName()) {
            return true;
        } else {
            return false;
        }
    }
}

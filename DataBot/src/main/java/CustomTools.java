import java.util.Random;

public class CustomTools {

    public CustomTools() {
    }

    //Get a random integer seeded by current system time
    public int getRandomBoundedInt(int bound) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(bound);
    }
}

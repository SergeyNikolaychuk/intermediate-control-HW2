import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class ToyShop {
    private PriorityQueue<Toy> toys;
    private Random random;

    public ToyShop() {
        this.toys = new PriorityQueue<>(Comparator.comparing(Toy::getFrequency));
        this.random = new Random();
    }

    public void put(String id, String name, int frequency) {
        toys.offer(new Toy(id, name, frequency));
    }

    public String get() {
        int sumOfFrequencies = toys.stream().mapToInt(Toy::getFrequency).sum();
        int index = random.nextInt(sumOfFrequencies);
        for (Toy toy : toys) {
            if (toy.getFrequency() > index) {
                return toy.getId();
            } else {
                index -= toy.getFrequency();
            }
        }
        throw new RuntimeException("No toys left.");
    }

    public void writeResultsToFile(int times, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < times; i++) {
                writer.write(get());
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

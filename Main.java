public class Main {
    public static void main(String[] args) {
        ToyShop shop = new ToyShop();
        shop.put("1", "Constructor", 2);
        shop.put("2", "Robot", 2);
        shop.put("3", "Doll", 6);

        shop.writeResultsToFile(10, "results.txt");
    }
}
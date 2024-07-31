public class MainBuilderPattern {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();

        System.out.println("Basic Computer: " + basicComputer);

        Computer gamingComputer = new Computer.Builder("Intel i7", "16GB")
                .storage("1TB SSD")
                .graphicsCard(true)
                .wifi(true)
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
    }
}

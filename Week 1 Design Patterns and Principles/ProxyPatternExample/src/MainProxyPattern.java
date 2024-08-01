public class MainProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("schedule.jpg");
        Image image2 = new ProxyImage("jeyakumar.jpg");

        image1.display();
        System.out.println();
        image2.display();
        System.out.println();

        image1.display();
    }
}
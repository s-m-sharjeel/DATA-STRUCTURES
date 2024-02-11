package Assignments.Assignment2.question3;

public class Demo {

    public static void main(String[] args) {

        Store wallmart = new Store();

        Customer customer1 = new Customer(1234, "sharjeel");
        Customer customer2 = new Customer(2567, "ali");
        wallmart.addCustomer(customer1);
        wallmart.addCustomer(customer2);

        Video video1 = new Video(5432, "messi", "10");
        Video video2 = new Video(3456, "cristiano", "7");
        Video video3 = new Video(1974, "neymar", "11");
        Video video4 = new Video(1975, "suarez", "9");
        wallmart.addVideo(video1);
        wallmart.addVideo(video2);
        wallmart.addVideo(video3);
        wallmart.addVideo(video4);

        customer1.rentVideo(video1);
        customer1.rentVideo(video2);
        customer1.printAllVideosRented();

        customer1.returnVideo(video1);
        customer2.rentVideo(video1);
        customer2.rentVideo(video2);
        customer2.printAllVideosRented();

        wallmart.showDetails(1974);
        wallmart.printAll();

        System.out.println(wallmart.searchVideoByID(1975));
        System.out.println(wallmart.searchVideoByTitle("Neymar"));

        wallmart.updateCustomerID(customer2, 1876);
        System.out.println(customer2);

        wallmart.printAllCustomerDetails();

        wallmart.removeCustomer(customer1);

    }

}

package Assignments.Assignment2.question3;

import java.util.Scanner;

public class Store {

    private static DoublyLinkedList<Video> videos = new DoublyLinkedList<Video>();
    private static DoublyLinkedList<Customer> customers = new DoublyLinkedList<Customer>();

    public static boolean rentVideo(Customer customer, Video video) {

        if (!customers.contains(customer)) {
            System.out.println("customer not found!");
            return false;
        }

        if (!videos.contains(video)) {
            System.out.println("video not found!");
            return false;
        }

        if (!video.isAvailable()){
            System.out.println("video not available!");
            return false;
        }

        video.setAvailable(false);
        System.out.println("video rented!");
        return true;

    }

    public static boolean returnVideo(Customer customer, Video video) {

        if (!customers.contains(customer)) {
            System.out.println("customer not found!");
            return false;
        }

        if (!videos.contains(video)) {
            System.out.println("video not found!");
            return false;
        }

        if (video.isAvailable()){
            System.out.println("video is already available!");
            return false;
        }

        video.setAvailable(true);
        System.out.println("video returned!");
        return true;

    }

    public void addVideo(Video video) {

        if (videos.contains(video)) {
            System.out.println("collection already contains video!");
            return;
        }

        videos.addSorted(video);
        System.out.println("video added successfully!");

    }

    public void removeVideo(Video video) {

        if (!videos.contains(video)) {
            System.out.println("collection does not contain video!");
            return;
        }

        videos.removeFirst(video);
        System.out.println("video removed successfully!");

    }

    public void showDetails(int ID) {

        Video video = searchVideoByID(ID);

        if (video != null)
            System.out.println(video);

    }

    public Video searchVideoByID (int ID) {

        for (int i = 0; i < videos.length(); i++) {
            if (videos.get(i).getID() == ID)
                return videos.get(i);
        }

        System.out.println("video not found!");
        return null;

    }

    public Video searchVideoByTitle (String title) {

        for (int i = 0; i < videos.length(); i++) {
            if (videos.get(i).getTitle().equalsIgnoreCase(title))
                return videos.get(i);
        }

        System.out.println("video not found!");
        return null;

    }

    public void printAll() {

        if (videos.isEmpty()) {
            System.out.println("the store is out of videos!");
            return;
        }

        System.out.println("video(s) in the store:");
        for (int i = 0; i < videos.length(); i++)
            System.out.println((i + 1) + ") " + videos.get(i));

    }

    public void addCustomer(Customer customer) {

        if (customers.contains(customer)) {
            System.out.println("database already contains customer!");
            return;
        }

        customers.addSorted(customer);
        System.out.println("customer added successfully!");

    }

    public void removeCustomer(Customer customer) {

        if (!customers.contains(customer)) {
            System.out.println("database does not contain customer!");
            return;
        }

        if (customer.hasVideos()) {
            System.out.print("customer must return the video(s) rented first!\npress 1 if you want to proceed anyway: ");
            Scanner input = new Scanner(System.in);
            String answer = input.next();
            if (!answer.equals("1"))
                return;
        }

        customers.removeFirst(customer);
        System.out.println("customer removed successfully!");

    }

    public void updateCustomerID (Customer customer, int newID) {

        if (!customers.contains(customer)) {
            System.out.println("database does not contain customer!");
            return;
        }

        for (int i = 0; i < customers.length(); i++) {
            if (customers.get(i).getID() == newID) {
                System.out.println("another customer with the same ID exists!");
                return;
            }
        }

        // in order to maintain the sorted arrangement of data
        customers.removeFirst(customer);
        customer.setID(newID);
        customers.addSorted(customer);

        System.out.println("customer ID updated successfully!");

    }

    public void printAllCustomerDetails() {

        if (customers.isEmpty()) {
            System.out.println("no customers!");
            return;
        }

        for (int i = 0; i < customers.length(); i++) {
            System.out.println("customer # " + (i + 1) + ":\n" + customers.get(i));
        }

    }

}

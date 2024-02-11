package Assignments.Assignment2.question3;

public class Customer implements Comparable<Customer>{

    private int ID;
    private String name;
    private DoublyLinkedList<Video> videos = new DoublyLinkedList<>();

    public Customer(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * rents the video by adding it to the customer's collection of videos
     * @param video is the video to be rented
     */
    public void rentVideo(Video video){

        if (videos.contains(video)) {
            System.out.println("customer already rented video!");
            return;
        }

        if (Store.rentVideo(this, video))
            videos.addSorted(video);

    }

    /**
     * returns the video by removing it from the customer's collection of videos
     * @param video is the video to be returned
     */
    public void returnVideo(Video video) {

        if (!videos.contains(video)) {
            System.out.println("video not found!");
            return;
        }

        if (Store.returnVideo(this, video))
            videos.removeFirst(video);

    }

    public void printAllVideosRented() {

        if (videos.isEmpty()) {
            System.out.println("customer has not rented any video");
            return;
        }

        System.out.println("video(s) rented by " + name + ": ");
        for (int i = 0; i < videos.length(); i++)
            System.out.println((i + 1) + ") " + videos.get(i));

    }

    public boolean hasVideos() {

        if (videos.isEmpty())
            return false;

        return true;

    }

    @Override
    public int compareTo(Customer customer) {

        return Integer.compare(this.ID, customer.ID);

    }

    @Override
    public String toString() {
        String s = "ID: " + ID + "\nName: " + name + "\nVideos Rented: \n";
        for (int i = 0; i < videos.length(); i++) {
            s += (i + 1) + ") " + videos.get(i);
        }

        return s;
    }
}

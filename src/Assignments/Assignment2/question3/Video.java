package Assignments.Assignment2.question3;

public class Video implements Comparable<Video> {

    private final int ID;
    private final String title;
    private final String description;
    private boolean available;

    public Video(int ID, String title, String description) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        available = true;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public int compareTo(Video vid) {

        return Integer.compare(this.ID, vid.ID);

    }

    @Override
    public String toString() {
        return "Video{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}

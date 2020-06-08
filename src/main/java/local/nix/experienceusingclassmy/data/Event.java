package local.nix.experienceusingclassmy.data;


public class Event extends AbstractData<Event>{

    private String title;
    private String date;
    private String address;


    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package utils;

// Data Object to handle the linked List
public class Data {
    private int id;
    private int spaces;
    private String type;

    public Data(int id, int spaces, String type) {
        this.id = id;
        this.spaces = spaces;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Method to format the data
    public String formatData(){
        if(getId()>9 && getId()<99){
            return getType()+ "0" + getId();
        }
        else if(getId()>99){
            return getType() + getId();
        }
        else {
            return getType()+ "00" + getId();
        }

    }
}

package mohan.com.chipviewcontacts.model;

public class SimpleContactWithImage {
    private int drawableId;
    private String name;
    private String email;

    public SimpleContactWithImage(int drawableId, String name, String email) {
        this.drawableId = drawableId;
        this.name = name;
        this.email = email;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return getName() + "|" + getEmail();
    }
}

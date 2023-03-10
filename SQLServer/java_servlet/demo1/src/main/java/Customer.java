public class Customer {
    private String name;
    private String dateOfBrith;
    private String address;
    private String img;

    public Customer() {
    }

    public Customer(String name, String dateOfBrith, String address, String img) {
        this.name = name;
        this.dateOfBrith = dateOfBrith;
        this.address = address;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Modol{" +
                "name='" + name + '\'' +
                ", dateOfBrith='" + dateOfBrith + '\'' +
                ", address='" + address + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}

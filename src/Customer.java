public class Customer {

    private String name;
    private String phoneNo;
    private Car car;


    public Customer(String name, String phoneNo, Car car) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

}

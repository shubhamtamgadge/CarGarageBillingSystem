import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Customer customer;

    private List<Service> servicesList;

    private double totalAmount;


    public Invoice(Customer customer) {
        this.customer = customer;
        this.servicesList = new ArrayList<>();
        this.totalAmount = 0;
    }


    public void addService(Service service){

        servicesList.add(service);
        totalAmount+=service.getPrice();

    }


    public void printInvoice(){
        System.out.println();
        System.out.println("-----------------Invoice-----------------");

        System.out.println("Customer : " + customer.getName() + "   | Phone Number : " + customer.getPhoneNo());

        System.out.println("Car Model : " + customer.getCar().getModel() + "   | Car Number : " + customer.getCar().getCarNumber());

        System.out.println();
        System.out.println("-----------------Service Done-----------------");

        int count=1;

        for(Service s : servicesList){

            System.out.println(count++  + ". " + s.getServiceName() + ": ₹" + s.getPrice());


        }

        System.out.println("----------------------------------------------");
        System.out.println("Total : " + totalAmount);
        System.out.println("------------------visit again------------------");
        System.out.println();
    }

}

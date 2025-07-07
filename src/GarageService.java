import java.io.FileNotFoundException;
import java.util.*;

public class GarageService {
    private Map<String,Customer> customersMap;
    private List<Service> availableService;

    public GarageService() throws FileNotFoundException
    {
        this.customersMap = new HashMap<>();
        this.availableService = new ArrayList<>();
        loadServices();
    }

    public void loadServices()
    {
        availableService.add(new Service("Car Wash",500));
        availableService.add(new Service("Engine Oil ",990));
        availableService.add(new Service("Oil Filter",90));
        availableService.add(new Service("Wheel Alignment",750));
        availableService.add(new Service("Tyre Replacement",3900));
        availableService.add(new Service("Puncture",150));
        availableService.add(new Service("Battery Change",5349));
        availableService.add(new Service("AC filter Change",180));
        availableService.add(new Service("Brake pads change",2400));
        availableService.add(new Service("Clutch Plate",7500));
        availableService.add(new Service("Head Light",4500));
        availableService.add(new Service("Tail Light",3490));
        availableService.add(new Service("Coolant",600));




        System.out.println();
    }

    public void addCustomer(String name,String phone,String carNUmber,String model)
    {
        Car car=new Car(carNUmber,model);
        Customer customer=new Customer(name,phone,car);
        customersMap.put(carNUmber,customer);
        System.out.println("Customer added successfully!");
    }

    public void createInvoice(String carNumber)
    {
        if(!customersMap.containsKey(carNumber))
        {
            System.out.println("No Customer Found with car number: "+carNumber);
            return;
        }
        Scanner sc=new Scanner(System.in);
        Customer customer=customersMap.get(carNumber);
        Invoice invoice=new Invoice(customer);
        System.out.println("Available Services:");
        for (int i=0;i<availableService.size();i++)
        {
            System.out.println((i+1)+". "+availableService.get(i).getServiceName()
                    + " - ₹"+availableService.get(i).getPrice());
        }

        while (true)
        {
            System.out.println();
            System.out.println("Enter Service number to add or 0 to finish");
            int choice=sc.nextInt();
            if(choice==0) break;
            if(choice>0 && choice<=availableService.size())
            {
                invoice.addService(availableService.get(choice-1));
                System.out.println("Service Done.");
            }
            else {
                System.out.println("Invalid Choice.");
            }

        }
        invoice.printInvoice();
    }
}
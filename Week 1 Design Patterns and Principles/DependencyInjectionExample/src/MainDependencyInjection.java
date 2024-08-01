public class MainDependencyInjection {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        customerService.addCustomer(new Customer("5008540", "Jeyakumar"));
        customerService.addCustomer(new Customer("5008545", "Syed Ahamed"));
        customerService.addCustomer(new Customer("5008550", "Bharath Kumar"));

        Customer customer1 = customerService.getCustomerById("5008545");
        System.out.println(customer1);

        Customer customer2 = customerService.getCustomerById("5008555");
        System.out.println(customer2);

        Customer customer3 = customerService.getCustomerById("5008540");
        System.out.println(customer3);

        Customer customer4 = customerService.getCustomerById("5008550");
        System.out.println(customer4);
    }
}
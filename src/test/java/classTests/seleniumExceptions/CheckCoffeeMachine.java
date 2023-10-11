package classTests.seleniumExceptions;

public class CheckCoffeeMachine {
    public static void main(String[] args) {
        int amountCoffee=5;
        /*
        if amountCoffee will be less than 10ml
        throw exception
         */

        if(amountCoffee<10){
            throw new NoCoffeeException("Out of coffee");
        }
        else{
            System.out.println("COffee machine has enough coffee");
        }
    }
}

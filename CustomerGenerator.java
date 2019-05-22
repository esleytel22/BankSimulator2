import java.util.ArrayList;
public class CustomerGenerator extends Thread {
    private Random_Int_Mean random_int_mean;
    private Parameters parameters;
    private int currentId;
    private Bank bank;
    private ArrayList<Thread> customerThreads;

    public CustomerGenerator(Parameters parameters) {
        this.parameters = parameters;
        Bank.initTimer();
        this.bank = new Bank(parameters);
        customerThreads = new ArrayList<>();
        random_int_mean = new Random_Int_Mean();
        currentId = 0;
    }

    public void run() {
        parameters.Print();
        while (!isSimulationEndTimeReached()) {
            try {
                Thread.sleep(getTimeToSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!isSimulationEndTimeReached()){
                generateCustomer();
            }
        }

        while (!customerThreads.isEmpty()){
            for (int i = 0; i < customerThreads.size(); i++) {
                Thread thread = customerThreads.get(i);
                if(thread.isAlive()){
                    continue;
                }else{
                    try {
                        thread.join();
                        customerThreads.remove(i);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("\nSimulation terminated after " + bank.getCustomerCount() + " customers served");
        System.out.println("Average waiting time = " + String.format( "%.2f", bank.getAverageSimulatedWorldWaitingTime() ));

    }
   
    private void generateCustomer() { 
    	Customer customerThread = new Customer(getNextId(), bank);
        customerThreads.add(customerThread);
        customerThread.start();
    }
   
    private boolean isSimulationEndTimeReached(){
        return parameters.getSimulationTime() < Bank.getElapsedTimeSimulatedWorld();
    }
    
    private int getNextId() {
        return ++currentId;
    }
   
    private int getTimeToSleep() {
        return random_int_mean.random_int(parameters.getMeanArrivalTime()  / 10) * 1000;
    }
}

public class Customer extends Thread {
	private int id;
	private Bank bank;
	
	public Customer(int id, Bank bank) {
		this.bank = bank;
		this.id = id;
	}
	
	public void printMessage(String output) {
		System.out.println("At Time \t" + Bank.getElapsedTimeSimulatedWorld() + ", Customer \t" + id + " " + output);
		
	}
	
	public void run() {
		printMessage("arrives in line");
		bank.serveCustomer(this);
		printMessage("leaves the bank");
	}

}

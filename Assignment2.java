public class Assignment2 {
	public static void main (String[] args) {
		Parameters parameters = new Parameters(); 
		parameters.setMeanArrivalTime(Integer.parseInt(args[0]));
		parameters.setMeanServiceTime(Integer.parseInt(args[1]));
		parameters.setNumOfTellers(Integer.parseInt(args[2]));
		parameters.setSimulationTime(Integer.parseInt(args[3]));
		CustomerGenerator customerGeneratorThread = new CustomerGenerator(parameters);
		customerGeneratorThread.start();
	
	}

}

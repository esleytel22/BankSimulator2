public class Parameters {
	private int numOfTellers;
	private int meanArrivalTime;
	private int meanServiceTime;
	private int simulationTime;
	
	public int getNumOfTellers() {
		return numOfTellers;
	}
	
	public int getMeanArrivalTime() {
		return meanArrivalTime;
	}
	
	public int getMeanServiceTime() {
		return meanServiceTime;
	}
	
	public int getSimulationTime() {
		return simulationTime;
	}
	
	public void setNumOfTellers(int numOfTellers) {
		this.numOfTellers = numOfTellers;	
	}
	
	public void setMeanArrivalTime(int meanArrivalTime) {
		this.meanArrivalTime = meanArrivalTime;
	}

	public void setMeanServiceTime(int meanServiceTime) {
		this.meanServiceTime = meanServiceTime;
	}

	public void setSimulationTime(int simulationTime) {
		this.simulationTime = simulationTime;	
	}
	
	public void Print() {
		System.out.println("Mean inter-arrival time: " + meanArrivalTime);
        System.out.println("Mean service time: " + meanServiceTime);
        System.out.println("Number of tellers: " + numOfTellers);
        System.out.println("Length of simulation: " + simulationTime + "\n");
	}

}

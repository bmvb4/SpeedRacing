class Car{
	private String strModel;
	private double iFuelAmount;
	private double dFuelCostForKM;
	private int iDistance;
	
	public Car(String model, int fuelAmount, double cost) {
		this.strModel = model;
		this.setFuelAmount(fuelAmount);
		this.setCost(cost);
		this.iDistance = 0;
	}
	
	public void setFuelAmount(int fuelAmount) {
		if (fuelAmount>=0) 
			this.iFuelAmount = fuelAmount;
		else 
			throw new IllegalArgumentException("Fuel Amount can't be negative.");
	}
	public void setCost(double cost) {
		if (cost>=0) 
			this.dFuelCostForKM = cost;
		else 
			throw new IllegalArgumentException("Fuel Cost can't be negative.");
	}
	public void carMove(int distance) {
		double fuelCalc = distance*this.dFuelCostForKM;
		if (fuelCalc <= this.iFuelAmount) {
			this.iFuelAmount = this.iFuelAmount - fuelCalc;
			this.iDistance = this.iDistance + distance;

		}else 
			throw new IllegalArgumentException("Insuffcient fuel for the car");
	}
	public String toString() {return this.strModel + " " + this.iFuelAmount+ " "+ this.iDistance;}
}

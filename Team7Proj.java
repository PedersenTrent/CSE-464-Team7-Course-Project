/* CSE 464 Course Project Team 7

 * Trent Pedersen

 * Esteban Osuna

 * Arthur Rogers

 * Waris Phupaibul

 * Steven Dykstra

 */



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



enum carType{

	ECONOMY(45,4,"Poor"),
	INTERMEDIATE(50,4,"Medium"),
	STANDARD(55,5,"Good"),
	VAN(70,7,"Medium");
	

	private int cost;
	private int maxPass;
	private String comfortLevel;


	public int getCost(){return cost;}
	public int getMaxPass(){return maxPass;}
	public String getComfortLevel(){return comfortLevel;}

	
	private carType(int cost, int maxPass, String comfortLevel){
		this.cost = cost;
		this.maxPass = maxPass;
		this.comfortLevel = comfortLevel;

	}	

}



class rentalCar{
	private String make;
	private String model;
	private String category;
	private double mpg;
	private carType type;

	
	public String getMake(){return make;}
	public String getModel(){return model;}
	public String getCarCategory(){return category;}
	public double getMPG(){return mpg;}
	public carType getCarType(){return type;}

	
	public rentalCar(String make, String model, String category, double mpg, carType type){
		this.make = make;
		this.model = model;
		this.category = category;
		this.mpg = mpg;
		this.type = type;

	}

	

}



public class Team7Proj{

	

	static List<rentalCar> carList = new ArrayList<rentalCar>() {

	    {

	        add(new rentalCar("Nissan","370Z","Coupe",22,carType.ECONOMY));

	        add(new rentalCar("Mitsubishi","Outlander","SUV",27.5,carType.STANDARD));

	        add(new rentalCar("Honda","Accord","Sedan",31.5,carType.INTERMEDIATE));

	        add(new rentalCar("Ford","C-MAX Energi SE","Hybrid",39,carType.INTERMEDIATE));

	        add(new rentalCar("Chevrolet","Colorado Crew Cab","Truck",22,carType.STANDARD));

	        add(new rentalCar("Dodge","Journey","Crossover",21,carType.STANDARD));

	        add(new rentalCar("Hyundai","Tuscon","Crossover",26,carType.STANDARD));

	        add(new rentalCar("Kia","Sedona","Van/Minivan",19,carType.VAN));

	        add(new rentalCar("Dodge","Grand Caravan","Van/Minivan",20,carType.VAN));

	        add(new rentalCar("Toyota","Corolla","Sedan",35,carType.INTERMEDIATE));

	        add(new rentalCar("Honda","Pilot","SUV",23.5,carType.STANDARD));

	        add(new rentalCar("GMC","Sierra","Truck",21,carType.STANDARD));

	        add(new rentalCar("RAM","ProMaster City","Van/Minivan",24,carType.VAN));

	        add(new rentalCar("Ford","Mustang","Coupe",18,carType.ECONOMY));

	        add(new rentalCar("Chrysler","Pacifica","Hybrid",22,carType.INTERMEDIATE));

	    }

	};

	

	public static void displayRental(int numPass, int numDays, double mileage) {
		ArrayList<rentalCar> rentals = new ArrayList<rentalCar>();
		// Add viable cars to "rentals"
		// Eliminate any cars that have less passengers than required
		for(int i = 0; i < carList.size(); i++) 
		{
			if(carList.get(i).getCarType().getMaxPass() >= numPass) 
			{
				rentals.add(carList.get(i));
			}
		}
		// Calculate the price for each cars
		ArrayList<Double> cost = new ArrayList<Double>();
		for(int i = 0; i < rentals.size(); i++) 
		{
			cost.add(calculateCost(rentals.get(i), numDays, mileage));
		}
		// Sort by overall cost first, then comfort level
		
		double maxCost = 1e20;
		String comfort = "";
		rentalCar choice = null;
		for(int i = 0; i < rentals.size(); i++)
		{
			rentalCar car = rentals.get(i);
			double costCar = cost.get(i);
			
			if(costCar == maxCost)
			{
				if((car.getCarType().getComfortLevel().equals("Medium") && comfort.equals("Poor")) || (car.getCarType().getComfortLevel().equals("Good") && comfort.equals("Poor") || (car.getCarType().getComfortLevel().equals("Good") && comfort.equals("Medium"))))
				{
					maxCost = costCar;
					comfort = car.getCarType().getComfortLevel();
					choice = car;
				}
			}
			else if(costCar < maxCost)
			{
				maxCost = costCar;
				comfort = car.getCarType().getComfortLevel();	
				choice = car;
			}
			
		}
		
		/*for(int i = 0; i < rentals.size(); i++)
		{
			System.out.println("Make: " + rentals.get(i).getMake());
			System.out.println("Model: " + rentals.get(i).getModel());
			System.out.println("Cost: " + cost.get(i));
			System.out.println();
		}*/
		
		if(rentals.size() == 0)
			System.out.println("Invalid number of passengers");
		else if(numDays <= 0)
			System.out.println("Cannot have negative number of days");
		else if(mileage <= 0)
			System.out.println("Cannot have negative number of miles");
		else
		{
			System.out.println("Make: " + choice.getMake());
			System.out.println("Model: " + choice.getModel());
			int passenger = choice.getCarType().getMaxPass();
			System.out.println("Number of Passengers: " + passenger);
			System.out.println("Cost: " + maxCost);
		}


		// Display the car information in sort order

		// make, model, number of passenger, total cost

	}

	

	// method to calculate the rental cost

	public static double calculateCost(rentalCar car, int numDay, double mileage) {
		// total gas in gallons * price per gallon (2.25) 
		double gasCost = (mileage/car.getMPG())*2.25;

		// rental cost = rent per day * total day
		double rentCost = numDay*car.getCarType().getCost();

		// get a free day for every multiple of 6
		double discount = (numDay/6)*car.getCarType().getCost();

		// extra charge based on new specification update
		double extra = 1.0;
		if(car.getMake() == "Honda" && (car.getCarCategory() == "Sedan" || car.getCarCategory() == "Hybrid" || car.getCarCategory() == "SUV")) {
			extra = 1.1;
		}
		if(car.getMake() == "Chevrolet" || car.getMake() == "Chrysler" || car.getMake() == "Dodge" || car.getMake() == "Ford" || car.getMake() == "GMC") {
			extra = 1.05;
		}
		// return the cost
		return gasCost+(rentCost-discount)*extra;
	}

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of passengers:");
		int passenger = console.nextInt();
		System.out.println("Enter the number of days:");
		int days = console.nextInt();
		System.out.println("Enter the approximate miles for the trip:");
		double miles = console.nextDouble();
		
		Team7Proj.displayRental(passenger, days, miles);
		console.close();
	}

}
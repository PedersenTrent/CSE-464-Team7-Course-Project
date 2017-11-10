/* CSE 464 Course Project Team 7
 * Trent Pedersen
 * Esteban Osuna
 * Arthur Rogers
 * Waris Phupaibul
 * Steven Dykstra
 */

import java.util.ArrayList;
import java.util.List;

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
	
	List<rentalCar> carList = new ArrayList<rentalCar>() {
	    {
	        add(new rentalCar("Nissan","370Z","Coupe",22,carType.ECONOMY));
	        add(new rentalCar("Mitsubishi","Outlander","SUV",27.5,carType.STANDARD));
	        add(new rentalCar("Honda","Accord","Sedan",31.5,carType.INTERMEDIATE));
	        add(new rentalCar("Ford","C-MAX Energi SE","Hybrid",39,carType.INTERMEDIATE));
	        add(new rentalCar("Chevorlet","Colorado Crew Cab","Truck",22,carType.STANDARD));
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
	
	public ArrayList<rentalCar> findRentalCar(int numPass, int numDays, int mileage){
		
		ArrayList<rentalCar> rentals = new ArrayList<rentalCar>();
		
		return rentals;
	}
	
	public void displayRentals(ArrayList<rentalCar> rentals){
		
	}
}

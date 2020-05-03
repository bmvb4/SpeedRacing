import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("********START********");
		Map<String, Car> cars = new LinkedHashMap<String, Car>();
		Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
    	if (!"End".equals(command)) {
    		int carNumber = Integer.parseInt(command);
        	for (int i = 0; i < carNumber; i++) {
        		String carName = scanner.next();
        		int carFuelAmount = scanner.nextInt();
        		double carCost = scanner.nextDouble();
        		try {
                    cars.put(carName, new Car(carName,carFuelAmount,carCost));
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                    break;
                }
    		}
		}
        while (!"End".equals(command)){
        	command = scanner.next();
        	if (command.equals("Drive")) {
        		String carModel = scanner.next();
        		int distance = scanner.nextInt();
				for (Map.Entry<String, Car> car : cars.entrySet()) {
					if (car.getKey().equals(carModel)) {
						try {
							car.getValue().carMove(distance);
		                }catch (IllegalArgumentException ex){
		                    System.out.println(ex.getMessage());
		                    break;
		                }
					}
				}
			}

        }
        for (Map.Entry<String, Car> car : cars.entrySet()) {
			System.out.println(car.getValue().toString());
		}
 
	}

}

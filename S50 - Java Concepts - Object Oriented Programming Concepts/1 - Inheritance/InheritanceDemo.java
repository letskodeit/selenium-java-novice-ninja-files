import automobile.BMW;
import automobile.Cars;

public class InheritanceDemo {

	public static void main(String[] args) {
		int speed = 10;
		
		Cars c1 = new Cars(speed);
		c1.increaseSpeed();
		c1.publicSpeed = 10;
		
		BMW bmw1 = new BMW(speed);
		bmw1.increaseSpeed();
		bmw1.headupDisplayNavigation();
	}

}

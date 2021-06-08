package builder;

import model.Car;

public class CarBuilder extends TransportBuilder<Car> {
    @Override
    public Car build() {
        return new Car(vin, this.maxSpeed, this.ecoClass, this.width, this.height, this.length);
    }
}

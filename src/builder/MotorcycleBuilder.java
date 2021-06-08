package builder;

import model.Motorcycle;

public class MotorcycleBuilder extends TransportBuilder<Motorcycle> {
    @Override
    public Motorcycle build() {
        return new Motorcycle(vin, this.maxSpeed, this.ecoClass, this.width, this.height, this.length);
    }
}

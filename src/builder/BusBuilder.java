package builder;

import model.Bus;

public class BusBuilder extends TransportBuilder<Bus> {

    @Override
    public Bus build() {
        return new Bus(vin, this.maxSpeed, this.ecoClass, this.width, this.height, this.length);
    }
}

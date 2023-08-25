package dat3.car;

import dat3.car.entity.Car;
import dat3.car.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    public void testSaveCar(){
        Car car = new Car();
        car.setBrand("TestBrand");
        car.setModel("TestModel");
        car.setPricePrDay(100.0);
        car.setBestDiscount(10);
        carRepository.save(car);

        assertNotNull(car.getId());

        Car savedCar = carRepository.findById(car.getId()).orElse(null);
        assertNotNull(savedCar);
        assertEquals("TestBrand", savedCar.getBrand());
        assertEquals("TestModel", savedCar.getModel());
        assertEquals(100.0, savedCar.getPricePrDay(), 0.01);
        assertEquals(10, savedCar.getBestDiscount());
    }


}

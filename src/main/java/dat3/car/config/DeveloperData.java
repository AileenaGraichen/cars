package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DeveloperData implements ApplicationRunner {

    private final CarRepository carRepository;
    private final MemberRepository memberRepository;
    private final Random random = new Random();

    @Autowired
    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository){
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initCars();
        initMembers();
    }

    private void initCars() {
        for (int i = 1; i <= 50; i++) {
            Car car = new Car();
            car.setBrand(getRandomBrand());
            car.setModel(getRandomModel());
            car.setPricePrDay(getRandomPrice());
            car.setBestDiscount(getRandomDiscount());
            carRepository.save(car);
        }
    }

    private void initMembers(){
        for (int i = 1; i <= 20; i++) {
            Member member = new Member(
                    getRandomUsername(),
                    getRandomPassword(),
                    "user" + i + "@example.com",
                    getRandomFirstName(),
                    getRandomLastName(),
                    getRandomStreet(),
                    getRandomCity(),
                    getRandomZip()
            );
            member.setApproved(random.nextBoolean());
            member.setRanking(random.nextInt(5) + 1);
            member.setCreated(LocalDateTime.now());
            member.setLastEdited(LocalDateTime.now());
            memberRepository.save(member);
        }
    }

    private String getRandomBrand() {
        String[] brands = {"Toyota", "Ford", "Honda", "BMW", "Chevrolet", "Nissan", "Mercedes", "Audi", "Volkswagen"};
        return brands[random.nextInt(brands.length)];
    }

    private String getRandomModel() {
        String[] models = {"Sedan", "SUV", "Hatchback", "Coupe", "Convertible", "Truck"};
        return models[random.nextInt(models.length)];
    }

    private double getRandomPrice() {
        return 50.0 + random.nextInt(100);
    }

    private int getRandomDiscount() {
        return random.nextInt(20);
    }
    //------------^cars--------------v-members--------------------//
    private String getRandomUsername() {
        return "user" + (random.nextInt(100) + 1);
    }

    private String getRandomPassword() {
        return "password" + (random.nextInt(100) + 1);
    }

    private String getRandomFirstName() {
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Emily", "Fiona"};
        return firstNames[random.nextInt(firstNames.length)];
    }

    private String getRandomLastName() {
        String[] lastNames = {"Johnson", "Smith", "Brown", "Lee", "Williams", "Davis"};
        return lastNames[random.nextInt(lastNames.length)];
    }

    private String getRandomStreet() {
        String[] streets = {"Main St", "Park Ave", "Elm St", "Maple Rd", "Oak Lane"};
        return streets[random.nextInt(streets.length)];
    }

    private String getRandomCity() {
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Miami"};
        return cities[random.nextInt(cities.length)];
    }

    private String getRandomZip() {
        return String.valueOf(10000 + random.nextInt(90000));
    }
}


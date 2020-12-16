import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceService {

    private static final double MIN_COST_PER_KM = 10.0;
    private static final int MIN_COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;
    private RideRepository rideRepository;

    public InvoiceService(){
        this.rideRepository = new RideRepository();
    }
    private static final HashMap<Integer,InvoiceSummary> UserIdHashMap = new HashMap<>();

    public double calculateFare(double distance, int time) {
        double totalfare = (distance*MIN_COST_PER_KM) + (time*MIN_COST_PER_TIME);
        return Math.max(totalfare,MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride:rides){
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}

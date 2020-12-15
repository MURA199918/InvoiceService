import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvoiceGenerator {

    private static final double MIN_COST_PER_KM = 10.0;
    private static final int MIN_COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;
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

    public List calculateFare(int id, Ride[] rides){
        double totalFare = 0;
        for(Ride ride:rides){
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        UserIdHashMap.put(id,new InvoiceSummary(rides.length, totalFare));
        InvoiceSummary mylist =  new InvoiceSummary(rides.length, totalFare);
       return Collections.singletonList(mylist);
    }

    public List calculateFareforUserId(int id){
        List<InvoiceSummary> list = UserIdHashMap.entrySet().stream().filter(e->e.getKey()==id)
                                       .map(Map.Entry::getValue).collect(Collectors.toList());
        return list;
    }
}

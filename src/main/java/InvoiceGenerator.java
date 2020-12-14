public class InvoiceGenerator {

    private static final double MIN_COST_PER_KM = 10.0;
    private static final int MIN_COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double totalfare = (distance*MIN_COST_PER_KM) + (time*MIN_COST_PER_TIME);
        if(totalfare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalfare;
    }
}

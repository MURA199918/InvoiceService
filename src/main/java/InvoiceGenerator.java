public class InvoiceGenerator {

    public double calculateFare(double distance, int time) {
        double cost = (distance*10) + (time*1);
        return cost;
    }
}

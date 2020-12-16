import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class InvoiceServiceTest {
    InvoiceService invoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceService();
    }

    @Test
    public void givenDistanceandTimeshouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenDistanceandTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                         new Ride(0.1,1)
                        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedinvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedinvoiceSummary,summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "ab.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1,1)
        };
        invoiceGenerator.addRides(userId,rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedinvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedinvoiceSummary,summary);
    }
}

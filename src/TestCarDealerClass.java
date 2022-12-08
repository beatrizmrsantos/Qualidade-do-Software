import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCarDealerClass {

    TestCarDealerClass() {
    }

    @ParameterizedTest
    @CsvSource({"FLAT,200000, 10000", "SALARY_BASED,200000,7000", "TIERED,200000,11100"})
    void testAssignmentDescription(CommissionKind kind, int sales, int expectedSalary) {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, 1000, sales), expectedSalary);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.fail;

public class TestCarDealerClass {

    TestCarDealerClass() {
    }


    //Weak Equivalence criteria
    @ParameterizedTest
    @CsvSource({"FLAT,-10000,-10000", "TIERED,35000,-10000"})
    void testErrorEquivalence(CommissionKind kind, int sales, int salary) {
        Dealer dealer = new CarDealerClass();

        try {
            dealer.salary(kind, salary, sales);
            fail();
        }
        catch (Exception e) {
            final String expected = "invalid input";
            Assertions.assertEquals(expected, e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({"SALARY_BASED,10000,10000,10300", "TIERED,10000,100000000,5999100"})
    void testEquivalence(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }


    //Simple boundary value analysis criteria
    @ParameterizedTest
    @CsvSource({"FLAT,0,100000000,5000000", "SALARY_BASED,0,100000000,3000000", "TIERED,0,100000000,5999100"})
    void testZeroBaseSalaryBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"FLAT,1,100000000,5000000", "SALARY_BASED,1,100000000,3000001", "TIERED,1,100000000,5999100"})
    void testOneBaseSalaryBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"FLAT,100000000,100000000,5000000", "SALARY_BASED,100000000,100000000,103000000", "TIERED,100000000,100000000,5999100"})
    void test100MBaseSalaryBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"FLAT,100000000,0,0", "SALARY_BASED,100000000,0,100000000", "TIERED,100000000,0,0"})
    void testZeroSalesBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"FLAT,100000000,1,0", "SALARY_BASED,100000000,1,100000000", "TIERED,100000000,1,0"})
    void testOneSalesBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"FLAT,100000000,100000000,5000000", "SALARY_BASED,100000000,100000000,103000000", "TIERED,100000000,100000000,5999100"})
    void test100MSalesBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"TIERED,100000000,10000,300", "TIERED,100000000,19999,600", "TIERED,100000000,20000,600"})
    void test1RangeSalesBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"TIERED,100000000,20001,600", "TIERED,100000000,35000,1350", "TIERED,100000000,49999,2100", "TIERED,100000000,50000,2100"})
    void test2RangeSalesBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

    @ParameterizedTest
    @CsvSource({"TIERED,100000000,50001,2100"})
    void test3RangeSalesBoundary(CommissionKind kind, int salary, int sales, int expectedSalary) throws Exception {
        Dealer dealer = new CarDealerClass();
        Assertions.assertEquals(dealer.salary(kind, salary, sales), expectedSalary);
    }

}

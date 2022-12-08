public interface Dealer {
    /**
     * Computes the salary of a car dealer employee. The salary depends on several factors. The first thing
     * to note is there are three different salary types in this car dealer: commission only, base salary plus
     * commission and tiered commission. The car dealer is testing its application for computing the monthly
     * payment for its employees. The payment depends on the commission kind, the base salary (where
     * applicable) and on the monthly sales
     * @param kind The kind of salary to be paid. See CommissionKind.
     * @param base The base salary, to be used to compute the salary, where applicable.
     * @param sales The monthly sales for that employee.
     * @return An integer representing the salary to be paid to the employee.
     * @author Miguel Goulao
     */
    int salary(CommissionKind kind, int base, int sales) throws Exception;
}

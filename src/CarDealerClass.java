/**
 * This class exemplifies a possible implementation of the salary function, described in the
 * Software Quality assignment. Note that this base implementation DOES NOT deal with what
 * happens in case of a negative base salary, or a negative sales outcome. So, it only defines
 * a "happy day scenario".
 * @author Miguel Goulao
 */
public class CarDealerClass implements Dealer{
    private static final float FLAT_RATE = 0.05f;
    private static final float BASE_SALARY_RATE = 0.03f;
    private static final float LOW_TIER_RATE = 0.03f;
    private static final float MID_TIER_RATE = 0.05f;
    private static final float HIGH_TIER_RATE = 0.06f;
    private static final int LOW_THRESHOLD = 20000;
    private static final int HIGH_THRESHOLD = 50000;

    @Override
    public int salary(CommissionKind kind, int base, int sales) {
        int result = 0;

        if(base < 0 || sales < 0 ){
            throw new Error("invalid input");
        }

        if (kind.equals(CommissionKind.FLAT)) {
            result = Math.round(FLAT_RATE * sales);
        } else if (kind.equals(CommissionKind.SALARY_BASED)) {
            result = base + Math.round(BASE_SALARY_RATE * sales);
        } else if (kind.equals(CommissionKind.TIERED)) {
            if (sales > HIGH_THRESHOLD) {
                result = Math.round((sales - HIGH_THRESHOLD) * HIGH_TIER_RATE
                        + (HIGH_THRESHOLD - LOW_THRESHOLD) * MID_TIER_RATE
                        + LOW_THRESHOLD * LOW_TIER_RATE);
            } else if (sales > LOW_THRESHOLD) {
                result = Math.round((sales - LOW_THRESHOLD) * MID_TIER_RATE + LOW_THRESHOLD * LOW_TIER_RATE);
            } else { // sales <= LOW_THRESHOLD
                result = Math.round(sales * LOW_TIER_RATE);
            }
        }
        return result;
    }
}

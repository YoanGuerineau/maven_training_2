package fr.chose;

import fr.lernejo.tester.api.TestMethod;

public class TestStatsLernejoTests {

    @TestMethod
    public void min_of_0_1_2_3_4_5_should_be_0() {
        Stats myMinTestStats = Stats.of(0,1,2,3,4,5);
        if ( myMinTestStats.min() != 0 ){
            throw new RuntimeException("min of 0,1,2,3,4,5 should be 0");
        }
    }

    @TestMethod
    public void min_of_0_1_2_3_4_negative_5_should_be_negative_() {
        Stats myMinTestStats = Stats.of(0,1,2,3,4,-5);
        if ( myMinTestStats.min() != -5 ){
            throw new RuntimeException("min of 0,1,2,3,4,-5 should be -5");
        }
    }

    @TestMethod
    public void min_of_0_1_2_3_4_5_should_not_be_5_throw_RuntimeException() {
        Stats myMinTestStats = Stats.of(0,1,2,3,4,5);
        if ( myMinTestStats.min() != 5 ){
            throw new RuntimeException("min of 0,1,2,3,4,5 should not be 5");
        }
    }

    @TestMethod
    public void max_of_0_1_2_3_4_5_should_be_5() {
        Stats myMinTestStats = Stats.of(0,1,2,3,4,5);
        if ( myMinTestStats.max() != 5 ){
            throw new RuntimeException("max of 0,1,2,3,4,5 should be 5");
        }
    }

    @TestMethod
    public void max_of_0_1_2_3_4_negative_5_should_be_4() {
        Stats myMinTestStats = Stats.of(0,1,2,3,4,-5);
        if ( myMinTestStats.max() != 4 ){
            throw new RuntimeException("max of 0,1,2,3,4,-5 should be 4");
        }
    }

    @TestMethod
    public void sum_of_0_1_2_3_4_5_should_be_15() {
        Stats myMinTestStats = Stats.of(0,1,2,3,4,5);
        if ( myMinTestStats.sum() != 15 ){
            throw new RuntimeException("sum of 0,1,2,3,4,5 should be 15");
        }
    }

    @TestMethod
    public void sum_of_0_1_2_3_4_negative_5_should_be_5() {
        Stats myMinTestStats = Stats.of(0,1,2,3,4,-5);
        if ( myMinTestStats.sum() != 5 ){
            throw new RuntimeException("sum of 0,1,2,3,4,-5 should be 5");
        }
    }


    @TestMethod
    public void avg_of_1_2_3_4_5_should_be_5() {
        Stats myMinTestStats = Stats.of(1,2,3,4,5);
        if ( myMinTestStats.avg() != 3 ){
            throw new RuntimeException("avg of 1,2,3,4,5 should be 5");
        }
    }

    @TestMethod
    public void avg_of_1_2_3_4_negative_5_should_be_1() {
        Stats myMinTestStats = Stats.of(1,2,3,4,-5);
        if ( myMinTestStats.avg() != 1 ){
            throw new RuntimeException("avg of 0,1,2,3,4,-5 should be 1");
        }
    }

}

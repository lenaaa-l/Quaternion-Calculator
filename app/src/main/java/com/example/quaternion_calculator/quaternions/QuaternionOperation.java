package com.example.quaternion_calculator.quaternions;

public class QuaternionOperation {
    /**
     * @param a First quaternion
     * @param b Second quaternion
     * @return Sum of a and b
     */
    public static Quaternion add(Quaternion a, Quaternion b) {
        return new Quaternion(
                a.getS() + b.getS(),
                a.getX() + b.getX(),
                a.getY() + b.getY(),
                a.getZ() + b.getZ()
        );
    }

    /**
     * @param a First quaternion
     * @param b Second quaternion
     * @return Difference of a and b
     */
    public static Quaternion subtract(Quaternion a, Quaternion b) {
        return add(a, b.negate());
    }

    /**
     * @param a First quaternion
     * @param b Second quaternion
     * @return Product of a and b
     */
    public static Quaternion multiply(Quaternion a, Quaternion b) {
        double s = a.getS() * b.getS() - a.getX() * b.getX() - a.getY() * b.getY() - a.getZ() * b.getZ();
        double x = a.getS() * b.getX() + a.getX() * b.getS() + a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getS() * b.getY() - a.getX() * b.getZ() + a.getY() * b.getS() + a.getZ() * b.getX();
        double z = a.getS() * b.getZ() + a.getX() * b.getY() - a.getY() * b.getX() + a.getZ() * b.getS();
        return new Quaternion(s, x, y, z);
    }

    /**
     * @param a First quaternion
     * @param b Second quaternion
     * @return Quotient of a and b --> The quotient is a * b^{-1}
     */
    public static Quaternion divide_a_b_1(Quaternion a, Quaternion b){
        return multiply(a, b.reciprocal());
    }

    /**
     * @param a First quaternion
     * @param b Second quaternion
     * @return Quotient of a and b --> The quotient is b^{-1} * a
     */
    public static Quaternion divide_b_1_a(Quaternion a, Quaternion b){
        return multiply(b.reciprocal(), a);
    }
}

package com.example.quaternion_calculator.quaternions;

import java.util.Vector;

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
    public static Quaternion divide_b_1_a(Quaternion a, Quaternion b) {
        return multiply(b.reciprocal(), a);
    }

    /**
     * @param q     Quaternion of the point to be rotated
     * @param r     Rotation axis
     * @param alpha angle in degree
     * @return rotation operator
     */
    public static Quaternion getRotationOperator(Quaternion q, Vector<Double> r, double alpha) {
        alpha = Math.toRadians(alpha);
        double s = Math.cos(alpha / 2);
        double x = Math.sin(alpha / 2) * r.get(0);
        double y = Math.sin(alpha / 2) * r.get(1);
        double z = Math.sin(alpha / 2) * r.get(2);
        return new Quaternion(s, x, y, z);
    }

    /**
     * Rotate a quaternion counterclockwise
     *
     * @param q     Quaternion of the point to be rotated
     * @param r     Rotation axis
     * @param alpha angle in degrees
     * @return quaternion caused by rotation
     */
    public static Quaternion rotate(Quaternion q, Vector<Double> r, final double alpha) {
        Quaternion rotation_operator = getRotationOperator(q, r, alpha);
        Quaternion temp = multiply(rotation_operator, q);
        return multiply(temp, rotation_operator.reciprocal());
    }
}

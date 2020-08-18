package com.example.quaternion_calculator.quaternions;

public class QuaternionOperation {
    /*
    Add two quaternions a, b and return the result
     */
    public static Quaternion add(Quaternion a, Quaternion b) {
        return new Quaternion(
                a.getS() + b.getS(),
                a.getX() + b.getX(),
                a.getY() + b.getY(),
                a.getZ() + b.getZ()
        );
    }

    /*
    Subtract two quaternions a, b and return the result
     */
    public static Quaternion subtract(Quaternion a, Quaternion b) {
        return add(a, b.negateReturn());
    }

    /*
    Multiply two quaternions a, b and return the result
     */
    public static Quaternion multiply(Quaternion a, Quaternion b) {
        double s = a.getS() * b.getS() - a.getX() * b.getX() - a.getY() * b.getY() - a.getZ() * b.getZ();
        double x = a.getS() * b.getX() + a.getX() * b.getS() + a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getS() * b.getY() - a.getX() * b.getZ() + a.getY() * b.getS() + a.getZ() * b.getX();
        double z = a.getS() * b.getZ() + a.getX() * b.getY() - a.getY() * b.getX() + a.getZ() * b.getS();
        return new Quaternion(s, x, y, z);
    }
}

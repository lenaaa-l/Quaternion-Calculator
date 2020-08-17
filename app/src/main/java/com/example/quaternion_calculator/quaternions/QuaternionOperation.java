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
}

package com.example.quaternion_calculator.quaternions;

public class Quaternion {
    // q = s + xi + yj + zk
    private double s, x, y, z;

    public Quaternion(double s, double x, double y, double z) {
        this.s = s;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Quaternion() {

    }

    /*
    Negates the quaternion without returning it --> q -> -q
     */
    public void negate() {
        negateReturn();
    }

    /*
    Negates the quaternion and returns it --> q to -q
     */
    public Quaternion negateReturn() {
        s = -s;
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}

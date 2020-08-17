package com.example.quaternion_calculator.quaternions;

public class Quaternion {
    // q = s + xi + yj + zk
    private int s, x, y, z;

    public Quaternion(int s, int x, int y, int z) {
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

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}

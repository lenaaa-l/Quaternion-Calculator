package com.example.quaternion_calculator.quaternions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    /**
     * @return Negated quaternion (q --> -q)
     */
    public Quaternion negate() {
        return new Quaternion(-s, -x, -y, -z);
    }

    /**
     * @return Return conjugated quaternion
     */
    public Quaternion conjugate(){
        return new Quaternion(s, -x, -y, -z);
    }

    /**
     * @return Norm of the quaternion
     */
    public double norm(){
        return Math.sqrt(s*s + x*x + y*y + z*z);
    }

    /**
     * @return Reciprocal of the quaternion
     */
    public Quaternion reciprocal() {
        double normSquare = Math.pow(norm(), 2);
        Quaternion conjugated = conjugate();
        double s_reciprocal = conjugated.s / normSquare;
        double x_reciprocal = conjugated.x / normSquare;
        double y_reciprocal = conjugated.y / normSquare;
        double z_reciprocal = conjugated.z / normSquare;

        return new Quaternion(s_reciprocal, x_reciprocal, y_reciprocal, z_reciprocal);
    }

    /**
     * @return Normalized quaternion
     */
    public Quaternion normalize() {
        double norm = norm();
        return new Quaternion(s / norm, x / norm, y / norm, z / norm);
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

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Quaternion))
            return false;
        Quaternion q = (Quaternion) obj;
        return q.getS() == s && q.getX() == x && q.getY() == y && q.getZ() == z;
    }

    @NonNull
    @Override
    public String toString() {
        String temp = "" + roundHelper(s, 2);
        temp += (x < 0) ? " - " : " + ";
        temp += roundHelper(Math.abs(x), 2) + " · i";
        temp += (y < 0) ? " - " : " + ";
        temp += roundHelper(Math.abs(y), 2) + " · j";
        temp += (z < 0) ? " - " : " + ";
        temp += roundHelper(Math.abs(z), 2) + " · k";
        return temp;
    }

    /**
     * @param value         Value to be rounded
     * @param decimalPlaces number of decimal places
     * @return rounded value
     */
    private double roundHelper(double value, int decimalPlaces) {
        double t = Math.pow(10, decimalPlaces);
        return Math.round(value * t) / t;
    }
}

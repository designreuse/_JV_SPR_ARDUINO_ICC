package com.company.icc.model;

/**
 * Created by leventyildiz on 27/01/16.
 */
public class Motion extends HttpStatus {

    private int motionData;

    public int getMotionData() {
        return motionData;
    }

    public void setMotionData(int motionData) {
        this.motionData = motionData;
    }

    @Override
    public String toString() {
        return "Motion{" +
                "motionData=" + motionData +
                '}';
    }
}

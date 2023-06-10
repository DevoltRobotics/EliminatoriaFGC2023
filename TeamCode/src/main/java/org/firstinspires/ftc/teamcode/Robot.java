package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot {

    public DcMotor left;
    public DcMotor right;

    public static final double WHEEL_RADIUS = 

    public void init(HardwareMap hardwareMap) {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
    }


    public void encoderDrive(double leftIn, double rightIn, double timeout) {
        ElapsedTime timer = new ElapsedTime();

        left.setTargetPosition();
    }

}

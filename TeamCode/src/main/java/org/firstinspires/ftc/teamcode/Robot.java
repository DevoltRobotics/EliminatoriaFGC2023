package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot {

    public DcMotor left;
    public DcMotor right;

    public Servo clawArm;

    public Servo clawLeft;
    public Servo clawRight;

    public static final double WHEEL_RADIUS = 2;
    public static final int TICKS_PER_REV = 1120;
    public static final double GEAR_REDUCTION = 1;

    public static final double TICKS_PER_INCH = (TICKS_PER_REV * GEAR_REDUCTION) / (WHEEL_RADIUS * 2 * 3.1415);

    public void init(HardwareMap hardwareMap) {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");

        left.setDirection(DcMotorSimple.Direction.REVERSE);

        clawArm = hardwareMap.get(Servo.class, "armclaw");

        clawLeft = hardwareMap.get(Servo.class, "clawleft");
        clawRight = hardwareMap.get(Servo.class, "clawright");

        clawArm.setPosition(0.3);

        clawLeft.setPosition(0.1);
        clawRight.setPosition(0.8);
    }

    public void encoderDrive(double leftIn, double rightIn, double timeout) {
        ElapsedTime timer = new ElapsedTime();

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setTargetPosition((int) Math.toRadians(leftIn * TICKS_PER_INCH));
        right.setTargetPosition((int) Math.toRadians(rightIn * TICKS_PER_INCH));

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(left.isBusy() && right.isBusy() && timer.seconds() < timeout);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void forward(double distance, double timeout) {
        encoderDrive(Math.abs(distance), Math.abs(distance), timeout);
    }

    public void backwards(double distance, double timeout) {
        encoderDrive(-Math.abs(distance), -Math.abs(distance), timeout);
    }

    public void turnLeft(double distance, double timeout) {
        encoderDrive(-Math.abs(distance), Math.abs(distance), timeout);
    }

    public void turnRight(double distance, double timeout) {
        encoderDrive(Math.abs(distance), -Math.abs(distance), timeout);
    }


}

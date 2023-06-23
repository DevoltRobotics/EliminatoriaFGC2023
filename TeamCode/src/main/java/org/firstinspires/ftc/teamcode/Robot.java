package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    public DcMotor left;
    public DcMotor right;

    public DcMotor clawArm;
    //public DcMotor clawArm2;

    public Servo clawLeft;
    public Servo clawRight;

    public static final double WHEEL_RADIUS = 2;
    public static final int TICKS_PER_REV = 1120;
    public static final double GEAR_REDUCTION = 1;

    public static final double TICKS_PER_INCH = (TICKS_PER_REV * GEAR_REDUCTION) / (WHEEL_RADIUS * 2 * 3.1415);

    public Telemetry telemetry;
    public boolean isAuto = false;

    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        clawArm = hardwareMap.get(DcMotor.class, "armclaw");
        //clawArm2 = hardwareMap.get(DcMotor.class, "armclaw2");

        clawLeft = hardwareMap.get(Servo.class, "clawleft");
        clawRight = hardwareMap.get(Servo.class, "clawright");


        left.setDirection(DcMotorSimple.Direction.REVERSE);
        clawArm.setDirection(DcMotorSimple.Direction.REVERSE);

        clawArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //clawArm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        clawLeft.setPosition(0.1);
        clawRight.setPosition(0.8);
    }

    public void encoderDrive(double leftIn, double rightIn, double speed, double timeout) {
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setTargetPosition((int) (leftIn * TICKS_PER_INCH));
        right.setTargetPosition((int) (rightIn * TICKS_PER_INCH));

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        ElapsedTime timer = new ElapsedTime();

        while(left.isBusy() && right.isBusy() && timer.seconds() < timeout) {
            left.setPower(Math.abs(speed));
            right.setPower(Math.abs(speed));

            telemetry.addData("left target", left.getTargetPosition());
            telemetry.addData("right target", right.getTargetPosition());

            telemetry.addData("left encoder", left.getCurrentPosition());
            telemetry.addData("right encoder", right.getCurrentPosition());
            telemetry.update();
        }

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void adelante(double distance, double speed, double timeout) {
        encoderDrive(Math.abs(distance), Math.abs(distance), speed, timeout);
        esperarSegundos(0.2);
    }

    public void atras(double distance, double speed, double timeout) {
        encoderDrive(-Math.abs(distance), -Math.abs(distance), speed, timeout);
        esperarSegundos(0.2);
    }

    public void girarIzquierda(double distance, double speed, double timeout) {
        encoderDrive(-Math.abs(distance), Math.abs(distance), speed, timeout);
        esperarSegundos(0.2);
    }

    public void girarDerecha(double distance, double speed, double timeout) {
        encoderDrive(Math.abs(distance), -Math.abs(distance), speed, timeout);
        esperarSegundos(0.2);
    }

    public void cerrarGarra() {
        clawLeft.setPosition(0.5);
        clawRight.setPosition(0.4);
        esperarSegundos(0.2);
    }

    public void abrirGarra() {
        clawLeft.setPosition(0.1);
        clawRight.setPosition(0.8);
        esperarSegundos(0.2);
    }

    public void garraMedioAbierta() {
        clawLeft.setPosition(0.4);
        clawRight.setPosition(0.5);
        esperarSegundos(0.2);
    }

    public void esperarSegundos(double segundos) {
        if(isAuto) {
            try {
                Thread.sleep((long) (segundos * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
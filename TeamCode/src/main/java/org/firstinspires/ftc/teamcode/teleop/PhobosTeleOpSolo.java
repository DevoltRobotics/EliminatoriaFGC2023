package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "TeleOp Solo")
public class PhobosTeleOpSolo extends OpMode {

    Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap, telemetry);

        // Send telemetry message to signify robot waiting;
        telemetry.addData(">", "La fiera de cucaracho");
    }

    @Override
    public void loop() {
        double y;
        double x;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forward, so negate it)
        y = -gamepad1.left_stick_y;
        x = gamepad1.right_stick_x;

        double turbo = 1.0;

        if(gamepad1.right_bumper || gamepad1.left_bumper) {
            turbo = 0.4;
        }

        robot.left.setPower((y - x) * turbo);
        robot.right.setPower((y + x) * turbo);

        telemetry.addData("x",  "%.2f", x);
        telemetry.addData("y", "%.2f", y);

        telemetry.addData("left encoder", robot.left.getCurrentPosition());
        telemetry.addData("right encoder", robot.right.getCurrentPosition());

        // START B

        robot.clawArm.setPower(0.08 + (gamepad1.left_trigger - gamepad1.right_trigger) * 0.7);
        //robot.clawArm2.setPower(-0.08+(gamepad1.right_trigger - gamepad1.left_trigger)* 0.7);

        if(gamepad1.a) {
            robot.clawLeft.setPosition(0.5);
            robot.clawRight.setPosition(0.4);
        } else if(gamepad1.b) {
            robot.clawLeft.setPosition(0.1);
            robot.clawRight.setPosition(0.8);
        } else if(gamepad1.x) {
            robot.clawLeft.setPosition(0.4);
            robot.clawRight.setPosition(0.5);
        }
    }

}

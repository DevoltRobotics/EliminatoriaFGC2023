package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "TeleOp")
public class PhobosTeleOp extends OpMode {

    Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap);

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

        double chosenTrigger = gamepad1.left_trigger;

        if(gamepad1.right_trigger >= 0.1) {
            chosenTrigger = gamepad1.right_trigger;
        }

        double turbo = 1.0 - chosenTrigger * 0.6;

        robot.left.setPower((y - x) * turbo);
        robot.right.setPower((y + x) * turbo);

        telemetry.addData("x",  "%.2f", x);
        telemetry.addData("y", "%.2f", y);
    }

}

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Autonomo")
public class Autonomo extends LinearOpMode {

    @Override
    public void runOpMode() {
        Robot robot = new Robot();
        robot.init(hardwareMap, telemetry);
        robot.isAuto = true;

        waitForStart();

        robot.clawOpen();
        robot.forward(10, 0.3, 3);

        robot.clawClose();
        robot.backwards(10, 0.3, 3);
    }

}

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Autonomo")
public class Autonomo extends LinearOpMode {

    @Override
    public void runOpMode() {
        Robot robot = new Robot();

        waitForStart();

        robot.forward(10, 3);
    }

}

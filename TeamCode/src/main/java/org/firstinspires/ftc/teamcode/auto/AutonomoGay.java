package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Autonomo Gay")
public class AutonomoGay extends LinearOpMode {

    @Override
    public void runOpMode() {
        Robot robot = new Robot();

        waitForStart();

        robot.forward(10, 3);

        sleep(100);

        robot.clawLeft.setPosition(0.1);
        robot.clawRight.setPosition(0.8);
    }

}

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

        robot.forward(50, 0.2, 10);
        robot.turnLeft(10, 0.2, 5);

        robot.clawArm.setPower(0.3);
        sleep(3000); // subir el brazo durante 3 segundos
        robot.clawArm.setPower(0.08); // stop

        robot.forward(10, 0.2, 5); // adelante

        robot.clawArm.setPower(-0.3);
        sleep(1000); // bajar el brazo durante 1 segundo
        robot.clawArm.setPower(0.08); // stop

        robot.backwards(10, 0.2, 5); // tirar caja
    }
}

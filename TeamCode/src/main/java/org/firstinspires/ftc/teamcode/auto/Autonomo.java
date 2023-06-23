package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Autonomo Gay")
public class Autonomo extends LinearOpMode {

    @Override
    public void runOpMode() {
        // NO EDITAR ESTA PARTE

        Robot robot = new Robot();
        robot.init(hardwareMap, telemetry);
        robot.isAuto = true;

        waitForStart();

        // !!! EMPIEZA AUTONOMO !!!

        robot.abrirGarra();

        robot.adelante(50, 0.2, 10); // con todo pa delante

        robot.clawArm.setPower(0.3);
        robot.esperarSegundos(1.5); // subir el brazo durante 1.5 segundos
        robot.clawArm.setPower(0.08); // stop

        robot.adelante(3, 0.2, 5); // adelante

        robot.clawArm.setPower(-0.3);
        robot.esperarSegundos(1); // bajar el brazo durante 1 segundo para anclarse a la caja
        robot.clawArm.setPower(0.08); // stop

        robot.atras(8, 0.2, 5); // tirar caja
        
        robot.clawArm.setPower(0.3);
        robot.esperarSegundos(1.5); // subir el brazo durante 1.5 segundos
        robot.clawArm.setPower(0.08); // stop

        robot.atras(8, 0.2, 5); // tirar caja
        
        robot.girarIzquierda(8, 0.3, 5); // park zona 10
        robot.adelante(10, 0.2, 5);
    }
}

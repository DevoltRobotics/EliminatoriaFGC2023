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

        robot.girarIzquierda(10, 0.2, 5); // girar hacia la caja
        robot.atras(3, 0.2, 5); // atras

        robot.clawArm.setPower(0.3);
        robot.esperarSegundos(3); // subir el brazo durante 3 segundos
        robot.clawArm.setPower(0.08); // stop

        robot.adelante(3, 0.2, 5); // adelante

        robot.clawArm.setPower(-0.3);
        robot.esperarSegundos(1); // bajar el brazo durante 1 segundo para anclarse a la caja
        robot.clawArm.setPower(0.08); // stop

        robot.girarDerecha(10, 0.2, 5); // tirar caja
    }
}

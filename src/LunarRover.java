/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mudra
 */
public class LunarRover {

    public static void main(String[] args) {
        RoverContext context = new RoverContext();

            // Movement Control Test
            System.out.println("=== Movement Control Test ===");
            context.pressLeftPedal();
            context.pressRightPedal();
            context.holdRightPedal(4);
            context.releasePedals();
            context.holdLeftPedal(4);
            context.releasePedals();

            // Camera Control Test
            System.out.println("=== Camera Control Test ===");
            context.activateCameraControl();
            context.holdButton1(5);
            context.pressButton1();
            context.holdButton1(10);
            context.pressButton2();

            // Drill Control Test
            System.out.println("=== Drill Control Test ===");
            context.activateCameraControl();
            context.pressButton1Twice();
            context.pressButton1();
            context.pressButton1();
            context.pressButton2();
        }
    }

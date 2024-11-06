/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mudra
 */
public class RoverContext {

    private RoverState state;

    public RoverContext() {
        state = new IdleState(this);
        state.enterState();
    }

    // Role: State transition manager
    public void setState(RoverState newState) {
        this.state = newState;
        state.enterState();
    }

    // Movement Control Role
    public void pressLeftPedal() {
        state.pressLeftPedal();
    }

    public void pressRightPedal() {
        state.pressRightPedal();
    }

    public void holdRightPedal(int seconds) {
        state.holdRightPedal(seconds);
    }

    public void releasePedals() {
        state.releasePedals();
    }

    public void holdLeftPedal(int seconds) {
        state.holdLeftPedal(seconds);
    }

    // Camera & Drill Control Role
    public void activateCameraControl() {
        state.activateCameraControl();
    }

    public void holdButton1(int seconds) {
        state.holdButton1(seconds);
    }

    public void pressButton1() {
        state.pressButton1();
    }

    public void pressButton2() {
        state.pressButton2();
    }

    public void pressButton1Twice() {
        state.pressButton1Twice();
    }
}

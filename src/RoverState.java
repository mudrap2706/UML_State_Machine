public interface RoverState {
    void enterState();
    void pressLeftPedal();
    void pressRightPedal();
    void holdRightPedal(int seconds);
    void releasePedals();
    void holdLeftPedal(int seconds);
    void activateCameraControl();
    void holdButton1(int seconds);
    void pressButton1();
    void pressButton2();
    void pressButton1Twice();
}

class IdleState implements RoverState {
    private final RoverContext context;

    public IdleState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Entering Idle State"); }

    @Override
    public void pressLeftPedal() {
        System.out.println("Transitioning to Accelerate Forward State");
        context.setState(new AccelerateForwardState(context));
    }

    @Override
    public void pressRightPedal() { System.out.println("No action in Idle State"); }

    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() { }

    @Override
    public void holdLeftPedal(int seconds) {
        if (seconds > 3) {
            System.out.println("Transitioning to Accelerate Backward State");
            context.setState(new AccelerateBackwardState(context));
        }
    }

    @Override
    public void activateCameraControl() {
        System.out.println("Switching to Camera & Drill Control");
        context.setState(new CameraIdleState(context));
    }

    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1() { }
    @Override public void pressButton2() { }
    @Override public void pressButton1Twice() { }
}

class AccelerateForwardState implements RoverState {
    private final RoverContext context;

    public AccelerateForwardState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Accelerating Forward"); }

    @Override
    public void pressRightPedal() {
        System.out.println("Transitioning to Decelerate State");
        context.setState(new DecelerateState(context));
    }

    @Override
    public void holdRightPedal(int seconds) {
        if (seconds > 3) {
            System.out.println("Transitioning to Constant Speed State");
            context.setState(new ConstantSpeedState(context));
        }
    }

    @Override public void pressLeftPedal() { }
    @Override public void releasePedals() { context.setState(new IdleState(context)); }
    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1() { }
    @Override public void pressButton2() { }
    @Override public void pressButton1Twice() { }
}

class AccelerateBackwardState implements RoverState {
    private final RoverContext context;

    public AccelerateBackwardState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Accelerating Backward"); }

    @Override public void pressLeftPedal() { }
    @Override public void pressRightPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() {
        System.out.println("Transitioning to Idle State");
        context.setState(new IdleState(context));
    }

    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1() { }
    @Override public void pressButton2() { }
    @Override public void pressButton1Twice() { }
}

class DecelerateState implements RoverState {
    private final RoverContext context;

    public DecelerateState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Decelerating"); }

    @Override public void pressRightPedal() { }
    @Override public void pressLeftPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() {
        System.out.println("Transitioning to Idle State");
        context.setState(new IdleState(context));
    }

    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1() { }
    @Override public void pressButton2() { }
    @Override public void pressButton1Twice() { }
}

class ConstantSpeedState implements RoverState {
    private final RoverContext context;

    public ConstantSpeedState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Maintaining Constant Speed"); }

    @Override public void pressRightPedal() { }
    @Override public void pressLeftPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() {
        System.out.println("Transitioning to Idle State");
        context.setState(new IdleState(context));
    }

    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1() { }
    @Override public void pressButton2() { }
    @Override public void pressButton1Twice() { }
}

class CameraIdleState implements RoverState {
    private final RoverContext context;

    public CameraIdleState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Entering Camera Idle State"); }

    @Override
    public void holdButton1(int seconds) {
        if (seconds == 5) {
            System.out.println("Activating Color Camera Mode");
            context.setState(new ColorCameraState(context));
        } else if (seconds == 10) {
            System.out.println("Activating 16-mm Camera Mode");
            context.setState(new SixteenMmCameraState(context));
        }
    }

    @Override
    public void pressButton1Twice() {
        System.out.println("Activating Drill Mode");
        context.setState(new DrillOffState(context));
    }

    @Override
    public void pressButton2() {
        System.out.println("Returning to Idle State");
        context.setState(new IdleState(context));
    }

    @Override public void pressLeftPedal() { }
    @Override public void pressRightPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() { }
    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void pressButton1() { }
}

class DrillOffState implements RoverState {
    private final RoverContext context;

    public DrillOffState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Drill is OFF"); }

    @Override
    public void pressButton1() {
        System.out.println("Turning Drill ON");
        context.setState(new DrillOnState(context));
    }

    @Override
    public void pressButton2() {
        System.out.println("Returning to Camera Idle State");
        context.setState(new CameraIdleState(context));
    }

    @Override public void pressLeftPedal() { }
    @Override public void pressRightPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() { }
    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1Twice() { }
}

class DrillOnState implements RoverState {
    private final RoverContext context;

    public DrillOnState(RoverContext context) {
        this.context = context;
    }

    @Override
    public void enterState() { System.out.println("Drill is ON"); }

    @Override
    public void pressButton1() {
        System.out.println("Turning Drill OFF");
        context.setState(new DrillOffState(context));
    }

    @Override
    public void pressButton2() {
        System.out.println("Returning to Camera Idle State");
        context.setState(new CameraIdleState(context));
    }

    @Override public void pressLeftPedal() { }
    @Override public void pressRightPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() { }
    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1Twice() { }
}

class ColorCameraState implements RoverState {
    private final RoverContext context;

    public ColorCameraState(RoverContext context) {
        this.context = context;
    }

    @Override public void enterState() { System.out.println("Color Camera Mode Activated"); }

    @Override public void pressButton1() { System.out.println("Taking Picture in Color Camera Mode"); }

    @Override public void pressButton2() { context.setState(new CameraIdleState(context)); }

    @Override public void pressLeftPedal() { }
    @Override public void pressRightPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() { }
    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1Twice() { }
}

class SixteenMmCameraState implements RoverState {
    private final RoverContext context;

    public SixteenMmCameraState(RoverContext context) {
        this.context = context;
    }

    @Override public void enterState() { System.out.println("16-mm Camera Mode Activated"); }

    @Override public void pressButton1() { System.out.println("Taking Picture in 16-mm Camera Mode"); }

    @Override public void pressButton2() { context.setState(new CameraIdleState(context)); }

    @Override public void pressLeftPedal() { }
    @Override public void pressRightPedal() { }
    @Override public void holdRightPedal(int seconds) { }
    @Override public void releasePedals() { }
    @Override public void holdLeftPedal(int seconds) { }
    @Override public void activateCameraControl() { }
    @Override public void holdButton1(int seconds) { }
    @Override public void pressButton1Twice() { }
}
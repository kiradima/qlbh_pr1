package command_pattern;

public class HoaDonNhapChiTietController {

    private Command command;

    /**
     *
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    public void load() {
        command.excute();
    }

}

package command_pattern;

public class LoadInfoCommand implements Command {

    private HoaDonNhap hoaDonNhap;

    /**
     *
     */
    @Override
    public void excute() {
        hoaDonNhap.getInfoFromDatabase(hoaDonNhap.getMaNhap());
    }

    /**
     *
     * @param hoaDonNhap
     */
    public LoadInfoCommand(HoaDonNhap hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }

}

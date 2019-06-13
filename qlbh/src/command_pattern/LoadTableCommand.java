package command_pattern;

import entity.HoaDonNhapChiTiet;

public class LoadTableCommand implements Command {
    
    private HoaDonNhap hoaDonNhap;

    /**
     *
     */
    @Override
    public void excute() {
        hoaDonNhap.setHoaDonNhapChiTiets(HoaDonNhapChiTiet.getAll(hoaDonNhap.getMaNhap()));
    }

    /**
     *
     * @param hoaDonNhap
     */
    public LoadTableCommand(HoaDonNhap hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.HoaDonNhap;
import entity.HoaDonNhapChiTiet;
import entity.HoaDonXuat;
import entity.HoaDonXuatChiTiet;
import entity.KhachHang;
import entity.MayTinh;
import entity.MayTinhChiTiet;
import entity.NhaCungCap;
import entity.NhanVien;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Kira
 */
public class ExcelHelper {

    public static ArrayList<HoaDonNhap> importHoaDonNhap(File file) throws Exception {
        ArrayList<HoaDonNhap> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        // get type file : 2 loại được chọn là xls và xlsx
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            HoaDonNhap o = new HoaDonNhap();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaNhap((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setMaNhanVien((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 2:
                        o.setMaNhaCungCap((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 3:
                        o.setThoiGian(cell.getDateCellValue());
                        i++;
                        break;
                    case 4:
                        o.setTongTien((double) cell.getNumericCellValue());
                        i++;
                        break;
                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<NhanVien> importNhanVien(File file) throws Exception {
        ArrayList<NhanVien> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        // get type file : 2 loại được chọn là xls và xlsx
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            NhanVien o = new NhanVien();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaNhanVien((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setTenNhanVien(cell.getStringCellValue());
                        i++;
                        break;
                    case 2:
                        o.setSdtNhanVien("0" + new DecimalFormat("##").format(cell.getNumericCellValue()));
                        i++;
                        break;
                    case 3:
                        o.setDiaChiNhanVien(cell.getStringCellValue());
                        i++;
                        break;
                    case 4:
                        o.setSoCMT(new DecimalFormat("##").format(cell.getNumericCellValue()) + "");
                        i++;
                        break;
                    case 5:
                        o.setNgaySinh(cell.getDateCellValue());
                        i++;
                        break;
                    case 6:
                        o.setGioiTinh(cell.getStringCellValue());
                        i++;
                        break;
                    case 7:
                        o.setEmailNhanVien(cell.getStringCellValue());
                        i++;
                        break;
                    case 8:
                        o.setChucVu(cell.getStringCellValue());
                        i++;
                        break;
                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<HoaDonNhapChiTiet> importHoaDonNhapChiTiet(File file) throws Exception {
        ArrayList<HoaDonNhapChiTiet> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        // get type file : 2 loại được chọn là xls và xlsx
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            HoaDonNhapChiTiet o = new HoaDonNhapChiTiet();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaNhap((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setMaMayTinhChiTiet((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 2:
                        o.setSoLuong((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 3:
                        o.setTongTien((double) cell.getNumericCellValue());
                        i++;
                        break;
                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<HoaDonXuat> importHoaDonXuat(File file) throws Exception {
        ArrayList<HoaDonXuat> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        // get type file : 2 loại được chọn là xls và xlsx
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            HoaDonXuat o = new HoaDonXuat();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaXuat((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setMaKhachHang((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 2:
                        o.setMaNhanVien((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 3:
                        o.setThoiGian(cell.getDateCellValue());
                        i++;
                        break;
                    case 4:
                        o.setTongTien((double) cell.getNumericCellValue());
                        i++;
                        break;
                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<HoaDonXuatChiTiet> importHoaDonXuatChiTiet(File file) throws Exception {
        ArrayList<HoaDonXuatChiTiet> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(file);
        // get type file : 2 loại được chọn là xls và xlsx
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            HoaDonXuatChiTiet o = new HoaDonXuatChiTiet();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaXuat((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setMaMayTinhChiTiet((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 2:
                        o.setSoLuong((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 3:
                        o.setTongTien((double) cell.getNumericCellValue());
                        i++;
                        break;
                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<MayTinh> readMayTinh(File file) throws Exception {
        ArrayList<MayTinh> list = new ArrayList<>();
        // Đọc một file XSL.
        FileInputStream inputStream = new FileInputStream(file);
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            // Đối tượng workbook cho file XSL.
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            // Đối tượng workbook cho file XLSX.
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Lấy Iterator cho tất cả các cell của dòng hiện tại.
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            MayTinh o = new MayTinh();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaMayTinh((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setTenMayTinh(cell.getStringCellValue());
                        i++;
                        break;
                    case 2:
                        o.setNhaSanXuat(cell.getStringCellValue());
                        i++;
                        break;
                    case 3:
                        o.setNamSanXuat((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 4:
                        o.setThoiGianBaoHanh((int) cell.getNumericCellValue());
                        i++;
                        break;

                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<KhachHang> readKhachHang(File file) throws Exception {
        ArrayList<KhachHang> list = new ArrayList<>();
        // Đọc một file XSL.
        FileInputStream inputStream = new FileInputStream(file);
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            // Đối tượng workbook cho file XSL.
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            // Đối tượng workbook cho file XLSX.
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Lấy Iterator cho tất cả các cell của dòng hiện tại.
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            KhachHang o = new KhachHang();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaKhachHang((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setTenKhachHang(cell.getStringCellValue());
                        i++;
                        break;
                    case 2:
                        o.setSdtKhachHang("0" + (int) cell.getNumericCellValue());
//                        System.out.println((int) cell.getNumericCellValue() + "");
                        i++;
                        break;
                    case 3:
                        o.setDiaChi(cell.getStringCellValue());
                        i++;
                        break;
                    case 4:
                        o.setSoCMT(String.valueOf((int) cell.getNumericCellValue()));
                        i++;
                        break;
                    case 5:
                        o.setNgaySinh(cell.getDateCellValue());
                        i++;
                        break;
                    case 6:
                        o.setGioiTinh(cell.getStringCellValue());
                        i++;
                        break;
                    case 7:
                        o.setEmailKhachHang(cell.getStringCellValue());
                        i++;
                        break;

                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<MayTinhChiTiet> readMayTinhChiTiet(File file) throws Exception {
        ArrayList<MayTinhChiTiet> list = new ArrayList<>();
        // Đọc một file XSL.
        FileInputStream inputStream = new FileInputStream(file);
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            // Đối tượng workbook cho file XSL.
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            // Đối tượng workbook cho file XLSX.
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Lấy Iterator cho tất cả các cell của dòng hiện tại.
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            MayTinhChiTiet o = new MayTinhChiTiet();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaMayTinhChiTiet((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setMaMayTinh((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 2:
                        o.setMoTa(cell.getStringCellValue());
                        i++;
                        break;
                    case 3:
                        o.setGiaNhap((double) cell.getNumericCellValue());
                        i++;
                        break;
                    case 4:
                        o.setGiaBan((double) cell.getNumericCellValue());
                        i++;
                        break;
                    case 5:
                        o.setCauHinh(cell.getStringCellValue());
                        i++;
                        break;
                    case 6:
                        o.setMauSac(cell.getStringCellValue());
                        i++;
                        break;
                    case 7:
                        o.setSoLuongTonKho((int) cell.getNumericCellValue());
                        i++;
                        break;

                }
            }
            list.add(o);
        }
        return list;
    }

    public static ArrayList<NhaCungCap> importNhaCungCap(File file) throws Exception {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        // Đọc một file XSL.
        FileInputStream inputStream = new FileInputStream(file);
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Iterator<Row> rowIterator = null;
        if (type.equals("xls")) {
            // Đối tượng workbook cho file XSL.
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        } else if (type.equals("xlsx")) {
            // Đối tượng workbook cho file XLSX.
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            // Lấy ra sheet đầu tiên từ workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
            rowIterator = sheet.iterator();
        }
        rowIterator.next();// tránh dòng đầu - tên của các cột
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Lấy Iterator cho tất cả các cell của dòng hiện tại.
            Iterator<Cell> cellIterator = row.cellIterator();
            int i = 0;
            NhaCungCap o = new NhaCungCap();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 0:
                        o.setMaNhaCungCap((int) cell.getNumericCellValue());
                        i++;
                        break;
                    case 1:
                        o.setTenNhaCungCap(cell.getStringCellValue());
                        i++;
                        break;
                    case 2:
                        o.setDienThoai(String.valueOf((int) cell.getNumericCellValue()));
                        i++;
                        break;
                    case 3:
                        o.setDiaChi(cell.getStringCellValue());
                        i++;
                        break;
                    case 4:
                        o.setEmail(cell.getStringCellValue());
                        i++;
                        break;

                }
            }
            list.add(o);
        }
        return list;
    }
}

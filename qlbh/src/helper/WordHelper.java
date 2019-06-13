/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import command_pattern.HoaDonNhap;
import entity.HoaDonNhapChiTiet;
import entity.HoaDonXuat;
import entity.HoaDonXuatChiTiet;
import entity.KhachHang;
import entity.MayTinh;
import entity.MayTinhChiTiet;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.TK;
import entity.TKR;
import entity.ThongKeKhachHangType;
import entity.ThongKeMayTinhType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

/**
 *
 * @author Kira
 */
public class WordHelper {

    public static void exportNhaCungCap(File file, ArrayList<NhaCungCap> list, String tittle) {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableNhaCC(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(WordHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportMayTinh(File file, ArrayList<MayTinh> list, String tittle) {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableMayTinh(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(WordHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportMayTinhChiTiet(File file,
            ArrayList<MayTinhChiTiet> list, String tittle) {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableMayTinhChiTiet(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(WordHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportKhachHang(File file, ArrayList<KhachHang> list, String tittle) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableKhachHang(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

//    public static void writeKhachHangTheoTen(File file, ArrayList<ThongKeKhachHangType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableThongKeKhachHang(document, list, "Tên khách hàng");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeKhachHangTheoGioiTinh(File file, ArrayList<ThongKeKhachHangType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableThongKeKhachHang(document, list, "Giới tính");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeKhachHangTheoDiaChi(File file, ArrayList<ThongKeKhachHangType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableThongKeKhachHang(document, list, "Địa chỉ");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeKhachHangTheoNamSinh(File file, ArrayList<ThongKeKhachHangType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableThongKeKhachHang(document, list, "Năm sinh");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeMayTinhTheoTen(File file, ArrayList<ThongKeMayTinhType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableMayTinhType(document, list, "Tên máy tính");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeMayTinhTheoNhaSanXuat(File file, ArrayList<ThongKeMayTinhType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableMayTinhType(document, list, "Nhà sản xuất");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeMayTinhTheoNamSanXuat(File file, ArrayList<ThongKeMayTinhType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableMayTinhType(document, list, "Năm sản xuất");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeMayTinhTheoThoiGianBaoHanh(File file, ArrayList<ThongKeMayTinhType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableMayTinhType(document, list, "Số tháng bảo hành");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeMayTinhTheoGiaNhap(File file, ArrayList<ThongKeMayTinhType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableMayTinhType(document, list, "Giá nhập");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeMayTinhTheoGiaBan(File file, ArrayList<ThongKeMayTinhType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableMayTinhType(document, list, "Giá bán");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
//
//    public static void writeMayTinhTheoMauSac(File file, ArrayList<ThongKeMayTinhType> list, String tittle) throws FileNotFoundException, IOException {
//        FileOutputStream out;
//        try (XWPFDocument document = loadHeader(tittle)) {
//            createTableMayTinhType(document, list, "Màu sắc");
//            loadFooter(document);
//            out = new FileOutputStream(file);
//            document.write(out);//ghi lại
//        }
//        out.close();
//    }
    public static void writeTK(File file, ArrayList<TK> list, String tittle, String thuocTinh) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableTK(document, list, thuocTinh);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

    private static void createTableNhaCC(XWPFDocument document, ArrayList<NhaCungCap> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000)); // set chiều rộng

        createNewCell(tittleRow, "Mã", 500, 1);
        createNewCell(tittleRow, "Tên nhà cung cấp", 2700, 2);
        createNewCell(tittleRow, "Số điện thoại", 2000, 3);
        createNewCell(tittleRow, "Địa chỉ", 2000, 4);
        createNewCell(tittleRow, "Email", 2000, 5);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            NhaCungCap o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaNhaCungCap() + "", false);
            format(row.getCell(2), o.getTenNhaCungCap() + "", false);
            format(row.getCell(3), o.getDienThoai() + "", false);
            format(row.getCell(4), o.getDiaChi() + "", false);
            format(row.getCell(5), o.getEmail() + "", false);

        }
    }

    private static void createTableTK(XWPFDocument document, ArrayList<TK> list, String thuocTinh) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(3000)); // set chiều rộng

        createNewCell(tittleRow, thuocTinh, 3000, 1);
        createNewCell(tittleRow, "Số lượng", 3000, 2);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            TK o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getThuocTinh() + "", false);
            format(row.getCell(2), o.getSoLuong() + "", false);
        }
    }

    public static void writeHDNCT(File file, ArrayList<HoaDonNhapChiTiet> list, String tittle,
            int maHDN, boolean isAll) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            if (isAll) {
                HoaDonNhap hoaDonNhap = HoaDonNhap.get(maHDN);
                XWPFParagraph paragraph = document.createParagraph();
                loadContentHDCT(paragraph, "Mã hóa đơn nhập: " + hoaDonNhap.getMaNhap());
                loadContentHDCT(paragraph, "Mã nhân viên : " + hoaDonNhap.getMaNhanVien()
                        + "    -    Tên nhân viên : " + NhanVien.get(hoaDonNhap.getMaNhanVien()).getTenNhanVien());
                loadContentHDCT(paragraph, "Mã nhà cung cấp : " + hoaDonNhap.getMaNhaCungCap()
                        + "    -    Tên nhà cung cấp : "
                        + NhaCungCap.get(hoaDonNhap.getMaNhaCungCap()).getTenNhaCungCap());
                loadContentHDCT(paragraph, "Ngày nhập : "
                        + new SimpleDateFormat("dd-MM-yyyy").format(hoaDonNhap.getThoiGian()));
                loadContentHDCT(paragraph, "Tổng tiền : " + new DecimalFormat("#").format(hoaDonNhap.getTongTien()));
            }
            //vẽ bảng
            createTableHDNCT(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

    private static void createTableHDNCT(XWPFDocument document, ArrayList<HoaDonNhapChiTiet> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500)); // set chiều rộng

        createNewCell(tittleRow, "Mã HĐN", 2000, 1);
        createNewCell(tittleRow, "Mã MTCT", 2000, 2);
        createNewCell(tittleRow, "Tên máy tính", 2500, 3);
        createNewCell(tittleRow, "Đơn giá", 2500, 4);
        createNewCell(tittleRow, "Số lượng", 2000, 5);
        createNewCell(tittleRow, "Thành tiền", 2500, 6);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            HoaDonNhapChiTiet o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới

            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaNhap() + "", false);
            format(row.getCell(2), o.getMaMayTinhChiTiet() + "", false);
            format(row.getCell(3), MayTinh.get(MayTinhChiTiet.get(o.getMaMayTinhChiTiet())
                    .getMaMayTinh()).getTenMayTinh() + "", false);
            format(row.getCell(4), new DecimalFormat("###")
                    .format(MayTinhChiTiet.get(o.getMaMayTinhChiTiet()).getGiaNhap()) + "", false);
            format(row.getCell(5), o.getSoLuong() + "", false);
            format(row.getCell(6), new DecimalFormat("###.#").format(o.getTongTien()) + "", false);
        }
    }

    public static void exportHoaDonNhap(File file, ArrayList<HoaDonNhap> list, String tittle) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableHDN(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

    public static void exportNhanVien(File file, ArrayList<NhanVien> list, String tittle) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableNV(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

    private static void createTableMayTinh(XWPFDocument document, ArrayList<MayTinh> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000)); // set chiều rộng

        createNewCell(tittleRow, "Mã", 500, 1);
        createNewCell(tittleRow, "Tên máy tính", 2700, 2);
        createNewCell(tittleRow, "Nhà sản xuất", 2000, 3);
        createNewCell(tittleRow, "Năm sản xuất", 2000, 4);
        createNewCell(tittleRow, "Thời gian bảo hành", 2000, 5);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            MayTinh o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaMayTinh() + "", false);
            format(row.getCell(2), o.getTenMayTinh() + "", false);
            format(row.getCell(3), o.getNhaSanXuat() + "", false);
            format(row.getCell(4), o.getNamSanXuat() + "", false);
            format(row.getCell(5), o.getThoiGianBaoHanh() + "", false);

        }
    }

    private static void createTableKhachHang(XWPFDocument document, ArrayList<KhachHang> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500)); // set chiều rộng

        createNewCell(tittleRow, "Mã", 500, 1);
        createNewCell(tittleRow, "Tên", 1500, 2);
        createNewCell(tittleRow, "SĐT", 500, 3);
        createNewCell(tittleRow, "Địa chỉ", 2000, 4);
        createNewCell(tittleRow, "CMT", 500, 5);
        createNewCell(tittleRow, "Ngày sinh ", 500, 6);
        createNewCell(tittleRow, "GT", 500, 7);
        createNewCell(tittleRow, "Email", 500, 8);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            KhachHang o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaKhachHang() + "", false);
            format(row.getCell(2), o.getTenKhachHang() + "", false);
            format(row.getCell(3), o.getSdtKhachHang() + "", false);
            format(row.getCell(4), o.getDiaChi() + "", false);
            format(row.getCell(5), o.getSoCMT() + "", false);
            format(row.getCell(6), o.getNgaySinh() + "", false);
            format(row.getCell(7), o.getGioiTinh() + "", false);
            format(row.getCell(8), o.getEmailKhachHang() + "", false);

        }
    }

    private static void createTableThongKeKhachHang(XWPFDocument document, ArrayList<ThongKeKhachHangType> list, String tieuChi) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000)); // set chiều rộng

        createNewCell(tittleRow, "" + tieuChi, 3000, 1);
        createNewCell(tittleRow, "Số lượng khách hàng ", 2900, 2);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            ThongKeKhachHangType o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getThuocTinh() + "", false);
            format(row.getCell(2), o.getSoLuong() + "", false);

        }
    }

    private static void createTableMayTinhType(XWPFDocument document, ArrayList<ThongKeMayTinhType> list, String tieuChi) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500)); // set chiều rộng
        createNewCell(tittleRow, "" + tieuChi, 2000, 1);
        createNewCell(tittleRow, "Số lượng", 1700, 2);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            ThongKeMayTinhType o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getThuocTinh() + "", false);
            format(row.getCell(2), o.getSoLuong() + "", false);

        }
    }

    private static void createTableHDN(XWPFDocument document, ArrayList<HoaDonNhap> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500)); // set chiều rộng

        createNewCell(tittleRow, "Mã HĐN", 1000, 1);
        createNewCell(tittleRow, "Nhân viên", 2500, 2);
        createNewCell(tittleRow, "Nhà cung cấp", 2500, 3);
        createNewCell(tittleRow, "Thời gian", 2500, 4);
        createNewCell(tittleRow, "Tổng tiền", 2500, 5);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            HoaDonNhap o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaNhap() + "", false);
            format(row.getCell(2), NhanVien.get(o.getMaNhanVien()).getTenNhanVien(), false);
            format(row.getCell(3), NhaCungCap.get(o.getMaNhaCungCap()).getTenNhaCungCap(), false);
            format(row.getCell(4), new SimpleDateFormat("dd-MM-yyyy")
                    .format(o.getThoiGian()), false);
            format(row.getCell(5), new DecimalFormat("###,###").format(o.getTongTien()) + "", false);
        }
    }

    public static void writeHDXCT(File file, ArrayList<HoaDonXuatChiTiet> list, String tittle,
            int maHDX) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            HoaDonXuat hoaDonXuat = HoaDonXuat.get(maHDX);

            XWPFParagraph paragraph = document.createParagraph();
            loadContentHDCT(paragraph, "Mã hóa đơn xuất: " + hoaDonXuat.getMaXuat());
            loadContentHDCT(paragraph, "Mã khách hàng : " + hoaDonXuat.getMaKhachHang()
                    + "    -    Tên khách hàng : " + KhachHang.get(hoaDonXuat.getMaKhachHang()).getTenKhachHang());
            loadContentHDCT(paragraph, "Mã nhân viên : " + hoaDonXuat.getMaNhanVien()
                    + "    -    Tên nhân viên : " + NhanVien.get(hoaDonXuat.getMaNhanVien()).getTenNhanVien());
            loadContentHDCT(paragraph, "Ngày xuất : "
                    + new SimpleDateFormat("dd-MM-yyyy").format(hoaDonXuat.getThoiGian()));
            loadContentHDCT(paragraph, "Tổng tiền : " + new DecimalFormat("#").format(hoaDonXuat.getTongTien()));
            // vẽ bảng
            createTableHDXCT(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

    private static void createTableHDXCT(XWPFDocument document, ArrayList<HoaDonXuatChiTiet> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000)); // set chiều rộng

        createNewCell(tittleRow, "Mã HĐX", 2000, 1);
        createNewCell(tittleRow, "Mã MTCT", 2000, 2);
        createNewCell(tittleRow, "Tên máy tính", 2500, 3);
        createNewCell(tittleRow, "Đơn giá", 2500, 4);
        createNewCell(tittleRow, "Số lượng", 2000, 5);
        createNewCell(tittleRow, "Thành tiền", 2500, 6);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            HoaDonXuatChiTiet o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaXuat() + "", false);
            format(row.getCell(2), o.getMaMayTinhChiTiet() + "", false);
            format(row.getCell(3), MayTinh.get(MayTinhChiTiet.get(o.getMaMayTinhChiTiet())
                    .getMaMayTinh()).getTenMayTinh() + "", false);
            format(row.getCell(4), new DecimalFormat("###")
                    .format(MayTinhChiTiet.get(o.getMaMayTinhChiTiet()).getGiaBan()) + "", false);
            format(row.getCell(5), o.getSoLuong() + "", false);
            format(row.getCell(6), new DecimalFormat("###").format(o.getTongTien()) + "", false);
        }
    }

    private static void createTableNV(XWPFDocument document, ArrayList<NhanVien> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500)); // set chiều rộng

        createNewCell(tittleRow, "Mã NV", 500, 1);
        createNewCell(tittleRow, "Tên NV", 500, 2);
        createNewCell(tittleRow, "SĐT", 500, 3);
        createNewCell(tittleRow, "Địa chỉ", 500, 4);
        createNewCell(tittleRow, "CMT", 500, 5);
        createNewCell(tittleRow, "Ngày sinh", 500, 6);
        createNewCell(tittleRow, "Giới tính", 500, 7);
//        createNewCell(tittleRow, "Email", 500, 8);
        createNewCell(tittleRow, "Chức vụ", 500, 8);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            NhanVien o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaNhanVien() + "", false);
            format(row.getCell(2), o.getTenNhanVien() + "", false);
            format(row.getCell(3), o.getSdtNhanVien() + "", false);
            format(row.getCell(4), o.getDiaChiNhanVien() + "", false);
            format(row.getCell(5), o.getSoCMT() + "", false);
            format(row.getCell(6), new SimpleDateFormat("dd-MM-yyyy").format(o.getNgaySinh()), false);
            format(row.getCell(7), o.getGioiTinh() + "", false);
//            format(row.getCell(8), o.getEmailNhanVien() + "", false);
            format(row.getCell(8), o.getChucVu() + "", false);
        }
    }

    public static void writeHDX(File file, ArrayList<HoaDonXuat> list, String tittle) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableHDX(document, list);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

    private static void createTableHDX(XWPFDocument document, ArrayList<HoaDonXuat> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000)); // set chiều rộng

        createNewCell(tittleRow, "Mã HĐX", 1000, 1);
        createNewCell(tittleRow, "Khách hàng", 2500, 2);
        createNewCell(tittleRow, "Nhân viên", 2500, 3);
        createNewCell(tittleRow, "Thời gian", 2500, 4);
        createNewCell(tittleRow, "Tổng tiền", 2000, 5);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            HoaDonXuat o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaXuat() + "", false);
            format(row.getCell(2), KhachHang.get(o.getMaKhachHang()).getTenKhachHang(), false);
            format(row.getCell(3), NhanVien.get(o.getMaNhanVien()).getTenNhanVien(), false);
            format(row.getCell(4), new SimpleDateFormat("dd-MM-yyyy")
                    .format(o.getThoiGian()), false);
            format(row.getCell(5), new DecimalFormat("###.#").format(o.getTongTien()) + "", false);
        }
    }

    private static void createTableMayTinhChiTiet(XWPFDocument document, ArrayList<MayTinhChiTiet> list) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(500)); // set chiều rộng

        createNewCell(tittleRow, MayTinhChiTiet.TT_MA_MAY_TINH_CHI_TIET, 500, 1);
        createNewCell(tittleRow, MayTinhChiTiet.TT_MA_MAY_TINH, 500, 2);
        createNewCell(tittleRow, "Tên MT", 2000, 3);
        createNewCell(tittleRow, MayTinhChiTiet.TT_MO_TA, 1500, 4);
        createNewCell(tittleRow, MayTinhChiTiet.TT_GIA_NHAP, 1000, 5);
        createNewCell(tittleRow, MayTinhChiTiet.TT_GIA_BAN, 1000, 6);
        createNewCell(tittleRow, MayTinhChiTiet.TT_CAU_HINH, 2000, 7);
        createNewCell(tittleRow, MayTinhChiTiet.TT_MAU_SAC, 1000, 8);
        createNewCell(tittleRow, MayTinhChiTiet.TT_SO_LUONG_TON_KHO, 500, 9);

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            MayTinhChiTiet o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getMaMayTinhChiTiet() + "", false);
            format(row.getCell(2), o.getMaMayTinh() + "", false);
            format(row.getCell(3), MayTinh.get(o.getMaMayTinh()).getTenMayTinh() + "", false);
            format(row.getCell(4), o.getMoTa() + "", false);
            format(row.getCell(5), new DecimalFormat("###").format(o.getGiaNhap()) + "", false);
            format(row.getCell(6), new DecimalFormat("###").format(o.getGiaBan()) + "", false);
            format(row.getCell(7), o.getCauHinh() + "", false);
            format(row.getCell(8), o.getMauSac() + "", false);
            format(row.getCell(9), o.getSoLuongTonKho() + "", false);
        }
    }

    //    tham số b là thể hiện có in đậm hay không
//    tham số s là nội dung 
    private static void format(XWPFTableCell cell, String s, boolean b) {
        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);// chính giữa theo chiều cao
        XWPFParagraph p = cell.getParagraphs().get(0);//lấy doạn văn bản
//        p.setIndentationLeft(200);// tương đượng padding left
//        p.setIndentationRight(200);// tương đượng padding right
        p.setAlignment(ParagraphAlignment.CENTER);// căn giữa văn bản
        XWPFRun r = p.createRun();// nội dung
        r.setBold(b);
        r.setFontFamily("Times New Roman");//set Kiểu chữ
        r.setFontSize(13);//set size text
        r.setColor("000000");// set color text
        r.setText(s);// set content text
    }

    private static XWPFDocument loadHeader(String tittle) throws FileNotFoundException, IOException {
        File file = new File("");
        File in = new File(file.getAbsolutePath()
                + "\\src\\files" + "\\tittle_qlbh.docx");
        FileInputStream fis = new FileInputStream(in);
        // load header
        Calendar calendar = Calendar.getInstance();
        XWPFDocument document = new XWPFDocument(fis);
        List<XWPFParagraph> paragraphList = document.getParagraphs();

        XWPFParagraph paragraphTime = paragraphList.get(6);
//        for (int i = 0; i < paragraphList.size(); i++) {
//            System.out.println(i + paragraphList.get(i).getText());
//        }

        XWPFRun runDVT = paragraphTime.createRun();
        runDVT.setBold(true);
        runDVT.setFontFamily("Times New Roman");//set Kiểu chữ
        runDVT.setFontSize(12);//set size text
        runDVT.setColor("000000");// set color text
        runDVT.setText("Đoàn Văn Tiến       "
                + "                        "
                + "                        "
                + "                         ");// set content text

        XWPFRun runTime = paragraphTime.createRun();
        runTime.setItalic(true);
        runTime.setFontFamily("Times New Roman");//set Kiểu chữ
        runTime.setFontSize(12);//set size text
        runTime.setColor("000000");// set color text
        runTime.setText("Ngày " + calendar.get(Calendar.DATE)
                + " tháng " + (calendar.get(Calendar.MONTH) + 1)
                + " năm " + calendar.get(Calendar.YEAR));// set content text

        // tạo tiêu đề biểu mẫu
        XWPFParagraph paragraphTittle = document.createParagraph();
        paragraphTittle.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runTittle = paragraphTittle.createRun();
        runTittle.setBold(true);
        runTittle.setItalic(true);
        runTittle.setFontFamily("Times New Roman");//set Kiểu chữ
        runTittle.setFontSize(16);//set size text
        runTittle.setColor("000000");// set color text
        runTittle.setText(tittle);// set content text
        runTittle.addBreak();
        return document;
    }

    private static void loadFooter(XWPFDocument document) {
        // tạo footer
        XWPFParagraph paragraphFooter = document.createParagraph();
//        paragraphFooter.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun runF1 = paragraphFooter.createRun();
        runF1.addBreak();
        runF1.setBold(true);
        runF1.setFontFamily("Times New Roman");//set Kiểu chữ
        runF1.setFontSize(12);//set size text
        runF1.setColor("000000");// set color text
        runF1.setText("                           Người lập                                            "
                + "                               Xác nhận của thủ thư");// set content text
        runF1.addBreak();

        XWPFRun runF2 = paragraphFooter.createRun();
        runF2.setItalic(true);
        runF2.setFontFamily("Times New Roman");//set Kiểu chữ
        runF2.setFontSize(12);//set size text
        runF2.setColor("000000");// set color text
        runF2.setText("                   (Ký và ghi rõ họ tên)                                            "
                + "                         (Ký và ghi rõ họ tên)");// set content text
    }

    private static void createNewCell(XWPFTableRow tittleRow, String s, int i, int stt) {
        tittleRow.addNewTableCell();// tạo cell mới
        format(tittleRow.getCell(stt), s, true);
        tittleRow.getCell(stt).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(i));
    }

    public static void setTableAlign(XWPFTable table, ParagraphAlignment align) {
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTJc jc = (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc());
        STJc.Enum en = STJc.Enum.forInt(align.getValue());
        jc.setVal(en);
    }

    public static void writeTKR(File file, ArrayList<TKR> list, String tittle, String thuocTinh) throws FileNotFoundException, IOException {
        FileOutputStream out;
        try (XWPFDocument document = loadHeader(tittle)) {
            createTableTKR(document, list, thuocTinh);
            loadFooter(document);
            out = new FileOutputStream(file);
            document.write(out);//ghi lại
        }
        out.close();
    }

    private static void createTableTKR(XWPFDocument document, ArrayList<TKR> list, String thuocTinh) {
        // tạo bảng 
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        // khi tạo 1 bảng mới thì bảng chỉ có 1 dòng và 1 cột -> row 0, col 0
        //get first row - viết tittle
        XWPFTableRow tittleRow = table.getRow(0);
        format(tittleRow.getCell(0), "TT", true);
        tittleRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000)); // set chiều rộng
        createNewCell(tittleRow, thuocTinh, 2000, 1);
        if (thuocTinh.equals(HoaDonNhap.TT_MA_NHAN_VIEN)) {
            createNewCell(tittleRow, "Tên nhân viên", 2500, 2);
            createNewCell(tittleRow, "Số lượng", 2000, 3);
            createNewCell(tittleRow, "Tổng tiền", 2000, 4);
        } else if (thuocTinh.equals(HoaDonNhap.TT_MA_NHA_CUNG_CAP)) {
            createNewCell(tittleRow, "Tên nhà cung cấp", 2500, 2);
            createNewCell(tittleRow, "Số lượng", 2000, 3);
            createNewCell(tittleRow, "Tổng tiền", 2000, 4);
        } else {
            createNewCell(tittleRow, "Số lượng", 2500, 2);
            createNewCell(tittleRow, "Tổng tiền", 2500, 3);
        }

        // đọc dữ liệu
        for (int i = 0; i < list.size(); i++) {
            TKR o = list.get(i);
            XWPFTableRow row = table.createRow();// tạo dòng mới
            format(row.getCell(0), (i + 1) + "", false);
            format(row.getCell(1), o.getTk().getThuocTinh() + "", false);
            if (thuocTinh.equals(HoaDonNhap.TT_MA_NHAN_VIEN)) {
                format(row.getCell(2), NhanVien.get(Integer.parseInt(o.getTk().getThuocTinh()))
                        .getTenNhanVien() + "", false);
                format(row.getCell(3), o.getTk().getSoLuong() + "", false);
                format(row.getCell(4), new DecimalFormat("###,###").format(o.getTongTien()) + "", false);
            } else if (thuocTinh.equals(HoaDonNhap.TT_MA_NHA_CUNG_CAP)) {
                format(row.getCell(2), NhaCungCap.get(Integer.parseInt(o.getTk().getThuocTinh()))
                        .getTenNhaCungCap() + "", false);
                format(row.getCell(3), o.getTk().getSoLuong() + "", false);
                format(row.getCell(4), new DecimalFormat("###,###").format(o.getTongTien()) + "", false);
            } else {
                format(row.getCell(2), o.getTk().getSoLuong() + "", false);
                format(row.getCell(3), new DecimalFormat("###,###").format(o.getTongTien()) + "", false);
            }

        }
    }

    public static void loadContentHDCT(XWPFParagraph paragraph, String s) {
        XWPFRun run = paragraph.createRun();
//        run.setBold(true);
        run.setFontFamily("Times New Roman");//set Kiểu chữ
        run.setFontSize(13);//set size text
        run.setColor("000000");// set color text
        run.setText("                   "
                + s);// set content text
        run.addBreak();
    }

}

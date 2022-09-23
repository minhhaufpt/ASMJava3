/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoiTuong;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class GradeOB {

    private String masv;
    private String hovaten;
    public double toan = 0;
    public double li = 0;
    public double hoa = 0;
    public double tb = (toan + li + hoa) / 3;

    public GradeOB() {
    }

    public GradeOB(String masv, String hovaten, double toan, double li, double hoa, double tb) {
        this.masv = masv;
        this.hovaten = hovaten;
        this.toan = toan;
        this.li = li;
        this.hoa = hoa;
        this.tb = tb;
    }

    public GradeOB(String masv, String hovaten) {
        this.masv = masv;
        this.hovaten = hovaten;
    }

    public GradeOB(double toan, double li, double hoa) {
        this.toan = toan;
        this.li = li;
        this.hoa = hoa;
    }

    public GradeOB(String masv, double toan, double li, double hoa) {
        this.masv = masv;
        this.toan = toan;
        this.li = li;
        this.hoa = hoa;
    }

    public void setDiem(double toan, double li, double hoa) {
        setToan(toan);
        setLi(li);
        setHoa(hoa);
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getLi() {
        return li;
    }

    public void setLi(double li) {
        this.li = li;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    public double getTb() {
        double c = (toan + li + hoa) / 3;
        return Math.round(c * 100.0) / 100.0;
    }

    public void setTb(double tb) {
//        this.tb = tb;
    }

}

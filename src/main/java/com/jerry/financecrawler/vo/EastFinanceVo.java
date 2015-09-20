package com.jerry.financecrawler.vo;

/**
 * Created by Jerry on 2015/9/18.
 */
public class EastFinanceVo {
    private String id;
    private String FINCODE;//产品编码
    private String FULLNAME;//产品全名
    private String SHORTNAME;//产品名称
    private String ESTABDATE;//产品成立日期
    private String MANAGERCODE;//管理者编码
    private String MANAGER;//管理人
    private String SMANAGER;//
    private String TRUSTEECODE;//发行人编码
    private String TRUSTEE;//发行人
    private String STRUSTEE;
    private String SCUSTDN;//托管人
    private String MGRNAME;
    private String PDATE;//净值日期
    private String NAV;//最新净值
    private String ACCNAV;//累积净值
    private String HY;
    private String Y;//近1年阶段涨幅
    private String TWY;
    private String SY;



    public void setACCNAV(String ACCNAV) {
        this.ACCNAV = ACCNAV;
    }

    public void setESTABDATE(String ESTABDATE) {
        this.ESTABDATE = ESTABDATE;
    }

    public void setFINCODE(String FINCODE) {
        this.FINCODE = FINCODE;
    }

    public void setFULLNAME(String FULLNAME) {
        this.FULLNAME = FULLNAME;
    }

    public void setHY(String HY) {
        this.HY = HY;
    }

    public void setMANAGER(String MANAGER) {
        this.MANAGER = MANAGER;
    }

    public void setMANAGERCODE(String MANAGERCODE) {
        this.MANAGERCODE = MANAGERCODE;
    }

    public void setMGRNAME(String MGRNAME) {
        this.MGRNAME = MGRNAME;
    }

    public void setNAV(String NAV) {
        this.NAV = NAV;
    }

    public void setPDATE(String PDATE) {
        this.PDATE = PDATE;
    }

    public void setSCUSTDN(String SCUSTDN) {
        this.SCUSTDN = SCUSTDN;
    }

    public void setSHORTNAME(String SHORTNAME) {
        this.SHORTNAME = SHORTNAME;
    }

    public void setSMANAGER(String SMANAGER) {
        this.SMANAGER = SMANAGER;
    }

    public void setSTRUSTEE(String STRUSTEE) {
        this.STRUSTEE = STRUSTEE;
    }

    public void setSY(String SY) {
        this.SY = SY;
    }

    public void setTRUSTEE(String TRUSTEE) {
        this.TRUSTEE = TRUSTEE;
    }

    public void setTRUSTEECODE(String TRUSTEECODE) {
        this.TRUSTEECODE = TRUSTEECODE;
    }

    public void setTWY(String TWY) {
        this.TWY = TWY;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getACCNAV() {
        return ACCNAV;
    }

    public String getESTABDATE() {
        return ESTABDATE;
    }

    public String getFINCODE() {
        return FINCODE;
    }

    public String getFULLNAME() {
        return FULLNAME;
    }

    public String getHY() {
        return HY;
    }

    public String getMANAGER() {
        return MANAGER;
    }

    public String getMANAGERCODE() {
        return MANAGERCODE;
    }

    public String getMGRNAME() {
        return MGRNAME;
    }

    public String getNAV() {
        return NAV;
    }

    public String getPDATE() {
        return PDATE;
    }

    public String getSCUSTDN() {
        return SCUSTDN;
    }

    public String getSHORTNAME() {
        return SHORTNAME;
    }

    public String getSMANAGER() {
        return SMANAGER;
    }

    public String getSTRUSTEE() {
        return STRUSTEE;
    }

    public String getSY() {
        return SY;
    }

    public String getTRUSTEE() {
        return TRUSTEE;
    }

    public String getTRUSTEECODE() {
        return TRUSTEECODE;
    }

    public String getTWY() {
        return TWY;
    }

    public String getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "EastFinanceModel{" +
                "id='" + id + '\'' +
                ", FINCODE='" + FINCODE + '\'' +
                ", FULLNAME='" + FULLNAME + '\'' +
                ", SHORTNAME='" + SHORTNAME + '\'' +
                ", ESTABDATE='" + ESTABDATE + '\'' +
                ", MANAGERCODE='" + MANAGERCODE + '\'' +
                ", MANAGER='" + MANAGER + '\'' +
                ", SMANAGER='" + SMANAGER + '\'' +
                ", TRUSTEECODE='" + TRUSTEECODE + '\'' +
                ", TRUSTEE='" + TRUSTEE + '\'' +
                ", STRUSTEE='" + STRUSTEE + '\'' +
                ", SCUSTDN='" + SCUSTDN + '\'' +
                ", MGRNAME='" + MGRNAME + '\'' +
                ", PDATE='" + PDATE + '\'' +
                ", NAV='" + NAV + '\'' +
                ", ACCNAV='" + ACCNAV + '\'' +
                ", HY='" + HY + '\'' +
                ", Y='" + Y + '\'' +
                ", TWY='" + TWY + '\'' +
                ", SY='" + SY + '\'' +
                '}';
    }
}

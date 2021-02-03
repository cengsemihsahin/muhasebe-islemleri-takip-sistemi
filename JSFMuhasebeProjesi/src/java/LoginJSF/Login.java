/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LoginJSF;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {
    
    /**
     * Creates a new instance of Login
     */
    
    /**
    String kullaniciAdi;
    String parola;

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getParola() {
        return parola;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
    
    public String dogrulama() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vt_muhasebe","root","");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from kullanici_tablosu where kullanici_adi='" + getKullaniciAdi() + "' && kullanici_parola='" + getParola() + "'");
        if (rs.next())  return "giris basarili";
        else return "tanimli olmayan kullanici_adi/kullanici_parola";
    }
    */
    
    private static final long serialVersionUID = 1094801825228386363L;
    
    private String parola;
    private String msg;
    private String kullaniciAdi;
    private int kullaniciTipi;

    public int getKullaniciTipi() {
        return kullaniciTipi;
    }

    public void setKullaniciTipi(int kullaniciTipi) {
        this.kullaniciTipi = kullaniciTipi;
    }

    public String getParola() {
        return parola;
    }

    public String getMsg() {
        return msg;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
    
    // login
    public String dogrulama() {
        boolean valid = LoginDAO.validate(kullaniciAdi, parola, kullaniciTipi);
        switch (kullaniciTipi) {
            case 1:
                if (valid) {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", kullaniciAdi);
                    return "admin";
                }
                else {
                    FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Yanlis kullanici adi, sifre veya tipi",
                        "Lutfen kullanici adinizi ve sifrenizi dogru girin"));
                    return "login";
                }
            case 2:
                if (valid) {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", kullaniciAdi);
                    return "mukellef";
                }
                else {
                    FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Yanlis kullanici adi, sifre veya tipi",
                        "Lutfen kullanici adinizi ve sifrenizi dogru girin"));
                    return "login";
                }
            default:
                    return "login";
        }
    }
    
    // logout
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
    
    public Login() {
    }
    
}

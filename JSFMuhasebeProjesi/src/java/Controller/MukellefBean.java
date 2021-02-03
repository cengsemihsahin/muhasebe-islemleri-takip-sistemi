/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.MukellefDAO;
import Entity.Mukellef;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ASUS
 */

@ManagedBean
@SessionScoped
public class MukellefBean implements Serializable {
    private MukellefDAO dao;
    private Mukellef entity;
    
    // CRUD
    
    public String mukellefBorcGoster() {
        return "";
    }
    
    public String mukellefOlustur() {
        this.getDao().mukellefOlustur(entity);
        this.entity = new Mukellef();
        return "admin";
    }
    
    // void bulundugu sayfaya geri doner
    public void mukellefSil(Mukellef m) {
        this.getDao().mukellefSil(m);
    }

    public String mukellefUpdateForm(Mukellef m) {
        this.entity = m;
        return "adminUpdateMukellef";
    }
    
    public String mukellefPaymentUpdateForm(Mukellef m) {
        this.entity = m;
        return "mukellefPayment";
    }
    
    public String mukellefGuncelle() {
        this.getDao().mukellefGuncelle(entity);
        this.entity = new Mukellef();
        return "admin";
    }
    
    public String mukellefBorcBilgisiGuncelle() {
        this.getDao().mukellefBorcBilgisiGuncelle(entity);
        this.entity = new Mukellef();
        return "mukellef";
    }
    
    public List<Mukellef> getMukellefRead() {
        return this.getDao().mukellefRead();
    }
    
    public List<Mukellef> getMukellefReadPayment() {
        return this.getDao().mukellefReadPayment();
    }
    
    public MukellefDAO getDao() {
        if (this.dao == null)
            this.dao = new MukellefDAO();
        return dao;
    }

    public void setDao(MukellefDAO dao) {
        this.dao = dao;
    }

    public Mukellef getEntity() {
        if (this.entity == null)
            this.entity = new Mukellef();
        return entity;
    }

    public void setEntity(Mukellef entity) {
        this.entity = entity;
    }

    public MukellefBean() {
    }
    
}

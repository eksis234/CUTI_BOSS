/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "berkas_cuti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BerkasCuti.findAll", query = "SELECT b FROM BerkasCuti b")
    , @NamedQuery(name = "BerkasCuti.findByIdBerkas", query = "SELECT b FROM BerkasCuti b WHERE b.idBerkas = :idBerkas")
    , @NamedQuery(name = "BerkasCuti.findByLokasiBerkas", query = "SELECT b FROM BerkasCuti b WHERE b.lokasiBerkas = :lokasiBerkas")})
public class BerkasCuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_berkas")
    private String idBerkas;
    @Basic(optional = false)
    @Column(name = "lokasi_berkas")
    private String lokasiBerkas;
    @JoinColumn(name = "id_permohonan", referencedColumnName = "id_permohonan")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permohonan idPermohonan;

    public BerkasCuti() {
    }

    public BerkasCuti(String idBerkas) {
        this.idBerkas = idBerkas;
    }

    public BerkasCuti(String idBerkas, String lokasiBerkas, Permohonan idPermohonan) {
        this.idBerkas = idBerkas;
        this.lokasiBerkas = lokasiBerkas;
        this.idPermohonan = idPermohonan;
    }

    public BerkasCuti(String idBerkas, String lokasiBerkas) {
        this.idBerkas = idBerkas;
        this.lokasiBerkas = lokasiBerkas;
    }

    public String getIdBerkas() {
        return idBerkas;
    }

    public void setIdBerkas(String idBerkas) {
        this.idBerkas = idBerkas;
    }

    public String getLokasiBerkas() {
        return lokasiBerkas;
    }

    public void setLokasiBerkas(String lokasiBerkas) {
        this.lokasiBerkas = lokasiBerkas;
    }

    public Permohonan getIdPermohonan() {
        return idPermohonan;
    }

    public void setIdPermohonan(Permohonan idPermohonan) {
        this.idPermohonan = idPermohonan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBerkas != null ? idBerkas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BerkasCuti)) {
            return false;
        }
        BerkasCuti other = (BerkasCuti) object;
        if ((this.idBerkas == null && other.idBerkas != null) || (this.idBerkas != null && !this.idBerkas.equals(other.idBerkas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.BerkasCuti[ idBerkas=" + idBerkas + " ]";
    }
    
}

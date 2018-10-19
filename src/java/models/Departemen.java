/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "departemen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departemen.findAll", query = "SELECT d FROM Departemen d")
    , @NamedQuery(name = "Departemen.findByIdDepartemen", query = "SELECT d FROM Departemen d WHERE d.idDepartemen = :idDepartemen")
    , @NamedQuery(name = "Departemen.findByNamaDepartemen", query = "SELECT d FROM Departemen d WHERE d.namaDepartemen = :namaDepartemen")})
public class Departemen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_departemen")
    private String idDepartemen;
    @Basic(optional = false)
    @Column(name = "nama_departemen")
    private String namaDepartemen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartemen", fetch = FetchType.LAZY)
    private List<Karyawan> karyawanList;

    public Departemen() {
    }

    public Departemen(String idDepartemen) {
        this.idDepartemen = idDepartemen;
    }

    public Departemen(String idDepartemen, String namaDepartemen) {
        this.idDepartemen = idDepartemen;
        this.namaDepartemen = namaDepartemen;
    }

    public String getIdDepartemen() {
        return idDepartemen;
    }

    public void setIdDepartemen(String idDepartemen) {
        this.idDepartemen = idDepartemen;
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }

    @XmlTransient
    public List<Karyawan> getKaryawanList() {
        return karyawanList;
    }

    public void setKaryawanList(List<Karyawan> karyawanList) {
        this.karyawanList = karyawanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartemen != null ? idDepartemen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departemen)) {
            return false;
        }
        Departemen other = (Departemen) object;
        if ((this.idDepartemen == null && other.idDepartemen != null) || (this.idDepartemen != null && !this.idDepartemen.equals(other.idDepartemen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Departemen[ idDepartemen=" + idDepartemen + " ]";
    }
    
}

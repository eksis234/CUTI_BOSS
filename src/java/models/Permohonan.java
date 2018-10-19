/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "permohonan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permohonan.findAll", query = "SELECT p FROM Permohonan p")
    , @NamedQuery(name = "Permohonan.findByIdPermohonan", query = "SELECT p FROM Permohonan p WHERE p.idPermohonan = :idPermohonan")
    , @NamedQuery(name = "Permohonan.findByTanggalSubmit", query = "SELECT p FROM Permohonan p WHERE p.tanggalSubmit = :tanggalSubmit")
    , @NamedQuery(name = "Permohonan.findByMulaiCuti", query = "SELECT p FROM Permohonan p WHERE p.mulaiCuti = :mulaiCuti")
    , @NamedQuery(name = "Permohonan.findBySelesaiCuti", query = "SELECT p FROM Permohonan p WHERE p.selesaiCuti = :selesaiCuti")
    , @NamedQuery(name = "Permohonan.findByCatatan", query = "SELECT p FROM Permohonan p WHERE p.catatan = :catatan")
    , @NamedQuery(name = "Permohonan.findByStatus", query = "SELECT p FROM Permohonan p WHERE p.status = :status")})
public class Permohonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_permohonan")
    private String idPermohonan;
    @Basic(optional = false)
    @Column(name = "tanggal_submit")
    @Temporal(TemporalType.DATE)
    private Date tanggalSubmit;
    @Basic(optional = false)
    @Column(name = "mulai_cuti")
    @Temporal(TemporalType.DATE)
    private Date mulaiCuti;
    @Basic(optional = false)
    @Column(name = "selesai_cuti")
    @Temporal(TemporalType.DATE)
    private Date selesaiCuti;
    @Basic(optional = false)
    @Column(name = "catatan")
    private String catatan;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_cuti", referencedColumnName = "id_cuti")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private JenisCuti idCuti;
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id_karyawan")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Karyawan idKaryawan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPermohonan", fetch = FetchType.LAZY)
    private List<BerkasCuti> berkasCutiList;

    public Permohonan() {
    }

    public Permohonan(String idPermohonan) {
        this.idPermohonan = idPermohonan;
    }

    public Permohonan(String idPermohonan, Date tanggalSubmit, Date mulaiCuti, Date selesaiCuti, String catatan, String status, JenisCuti idCuti, Karyawan idKaryawan) {
        this.idPermohonan = idPermohonan;
        this.tanggalSubmit = tanggalSubmit;
        this.mulaiCuti = mulaiCuti;
        this.selesaiCuti = selesaiCuti;
        this.catatan = catatan;
        this.status = status;
        this.idCuti = idCuti;
        this.idKaryawan = idKaryawan;
    }

    public String getIdPermohonan() {
        return idPermohonan;
    }

    public void setIdPermohonan(String idPermohonan) {
        this.idPermohonan = idPermohonan;
    }

    public Date getTanggalSubmit() {
        return tanggalSubmit;
    }

    public void setTanggalSubmit(Date tanggalSubmit) {
        this.tanggalSubmit = tanggalSubmit;
    }

    public Date getMulaiCuti() {
        return mulaiCuti;
    }

    public void setMulaiCuti(Date mulaiCuti) {
        this.mulaiCuti = mulaiCuti;
    }

    public Date getSelesaiCuti() {
        return selesaiCuti;
    }

    public void setSelesaiCuti(Date selesaiCuti) {
        this.selesaiCuti = selesaiCuti;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JenisCuti getIdCuti() {
        return idCuti;
    }

    public void setIdCuti(JenisCuti idCuti) {
        this.idCuti = idCuti;
    }

    public Karyawan getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(Karyawan idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    @XmlTransient
    public List<BerkasCuti> getBerkasCutiList() {
        return berkasCutiList;
    }

    public void setBerkasCutiList(List<BerkasCuti> berkasCutiList) {
        this.berkasCutiList = berkasCutiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermohonan != null ? idPermohonan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permohonan)) {
            return false;
        }
        Permohonan other = (Permohonan) object;
        if ((this.idPermohonan == null && other.idPermohonan != null) || (this.idPermohonan != null && !this.idPermohonan.equals(other.idPermohonan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Permohonan[ idPermohonan=" + idPermohonan + " ]";
    }
    
}

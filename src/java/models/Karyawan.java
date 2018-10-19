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
import javax.persistence.Lob;
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
@Table(name = "karyawan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findByIdKaryawan", query = "SELECT k FROM Karyawan k WHERE k.idKaryawan = :idKaryawan")
    , @NamedQuery(name = "Karyawan.findByNamaKaryawan", query = "SELECT k FROM Karyawan k WHERE k.namaKaryawan = :namaKaryawan")
    , @NamedQuery(name = "Karyawan.findByNoTlpKaryawan", query = "SELECT k FROM Karyawan k WHERE k.noTlpKaryawan = :noTlpKaryawan")
    , @NamedQuery(name = "Karyawan.findByEmailKaryawan", query = "SELECT k FROM Karyawan k WHERE k.emailKaryawan = :emailKaryawan")
    , @NamedQuery(name = "Karyawan.findByAwalGabung", query = "SELECT k FROM Karyawan k WHERE k.awalGabung = :awalGabung")
    , @NamedQuery(name = "Karyawan.findByIdManager", query = "SELECT k FROM Karyawan k WHERE k.idManager = :idManager")
    , @NamedQuery(name = "Karyawan.findByKataSandi", query = "SELECT k FROM Karyawan k WHERE k.kataSandi = :kataSandi")
    , @NamedQuery(name = "Karyawan.findBySisaCuti", query = "SELECT k FROM Karyawan k WHERE k.sisaCuti = :sisaCuti")
    , @NamedQuery(name = "Karyawan.findByBanyakCuti", query = "SELECT k FROM Karyawan k WHERE k.banyakCuti = :banyakCuti")
    , @NamedQuery(name = "Karyawan.findByStatus", query = "SELECT k FROM Karyawan k WHERE k.status = :status")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_karyawan")
    private String idKaryawan;
    @Basic(optional = false)
    @Column(name = "nama_karyawan")
    private String namaKaryawan;
    @Basic(optional = false)
    @Column(name = "no_tlp_karyawan")
    private String noTlpKaryawan;
    @Basic(optional = false)
    @Column(name = "email_karyawan")
    private String emailKaryawan;
    @Basic(optional = false)
    @Column(name = "awal_gabung")
    @Temporal(TemporalType.DATE)
    private Date awalGabung;
    @Basic(optional = false)
    @Column(name = "id_manager")
    private String idManager;
    @Basic(optional = false)
    @Column(name = "kata_sandi")
    private String kataSandi;
    @Basic(optional = false)
    @Column(name = "sisa_cuti")
    private int sisaCuti;
    @Basic(optional = false)
    @Column(name = "banyak_cuti")
    private int banyakCuti;
    @Basic(optional = false)
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKaryawan", fetch = FetchType.LAZY)
    private List<Permohonan> permohonanList;
    @JoinColumn(name = "id_departemen", referencedColumnName = "id_departemen")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departemen idDepartemen;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role idRole;

    public Karyawan() {
    }

    public Karyawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public Karyawan(String idKaryawan, String namaKaryawan, String noTlpKaryawan, String emailKaryawan, Date awalGabung, String idManager, String kataSandi, int sisaCuti, int banyakCuti, byte[] foto, String status, Departemen idDepartemen, Role idRole) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.noTlpKaryawan = noTlpKaryawan;
        this.emailKaryawan = emailKaryawan;
        this.awalGabung = awalGabung;
        this.idManager = idManager;
        this.kataSandi = kataSandi;
        this.sisaCuti = sisaCuti;
        this.banyakCuti = banyakCuti;
        this.foto = foto;
        this.status = status;
        this.idDepartemen = idDepartemen;
        this.idRole = idRole;
    }

    public Karyawan(String idKaryawan, String namaKaryawan, String noTlpKaryawan, String emailKaryawan, Date awalGabung, String idManager, int sisaCuti, int banyakCuti, byte[] foto, String status, Departemen idDepartemen, Role idRole) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.noTlpKaryawan = noTlpKaryawan;
        this.emailKaryawan = emailKaryawan;
        this.awalGabung = awalGabung;
        this.idManager = idManager;
        this.sisaCuti = sisaCuti;
        this.banyakCuti = banyakCuti;
        this.foto = foto;
        this.status = status;
        this.idDepartemen = idDepartemen;
        this.idRole = idRole;
    }

    public Karyawan(String idKaryawan, String kataSandi) {
        this.idKaryawan = idKaryawan;
        this.kataSandi = kataSandi;
    }

    
    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getNoTlpKaryawan() {
        return noTlpKaryawan;
    }

    public void setNoTlpKaryawan(String noTlpKaryawan) {
        this.noTlpKaryawan = noTlpKaryawan;
    }

    public String getEmailKaryawan() {
        return emailKaryawan;
    }

    public void setEmailKaryawan(String emailKaryawan) {
        this.emailKaryawan = emailKaryawan;
    }

    public Date getAwalGabung() {
        return awalGabung;
    }

    public void setAwalGabung(Date awalGabung) {
        this.awalGabung = awalGabung;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    public int getSisaCuti() {
        return sisaCuti;
    }

    public void setSisaCuti(int sisaCuti) {
        this.sisaCuti = sisaCuti;
    }

    public int getBanyakCuti() {
        return banyakCuti;
    }

    public void setBanyakCuti(int banyakCuti) {
        this.banyakCuti = banyakCuti;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Permohonan> getPermohonanList() {
        return permohonanList;
    }

    public void setPermohonanList(List<Permohonan> permohonanList) {
        this.permohonanList = permohonanList;
    }

    public Departemen getIdDepartemen() {
        return idDepartemen;
    }

    public void setIdDepartemen(Departemen idDepartemen) {
        this.idDepartemen = idDepartemen;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKaryawan != null ? idKaryawan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.idKaryawan == null && other.idKaryawan != null) || (this.idKaryawan != null && !this.idKaryawan.equals(other.idKaryawan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Karyawan[ idKaryawan=" + idKaryawan + " ]";
    }
    
}

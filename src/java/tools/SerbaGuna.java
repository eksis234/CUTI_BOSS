/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import models.Karyawan;

/**
 *
 * @author Lenovo
 */
public class SerbaGuna {
    
    public String dateToString(Date date){
        SimpleDateFormat formater = new SimpleDateFormat("dd-mm-yyyy");
        return formater.format(date);
    }
    
    public String generatePassword(Karyawan karyawan){
        String idKaryawan = karyawan.getIdKaryawan();
        String birthDate = dateToString(karyawan.getAwalGabung());
        String[] splitDate = birthDate.split("-");
        return idKaryawan + splitDate[0] + splitDate[1] + splitDate[2].substring(2,4);
    }
    
}

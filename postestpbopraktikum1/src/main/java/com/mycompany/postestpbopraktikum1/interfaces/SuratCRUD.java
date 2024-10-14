package com.mycompany.postestpbopraktikum1.interfaces;

import com.mycompany.postestpbopraktikum1.models.bagiansurat;
import java.util.List;

public interface SuratCRUD {
    void kirimSurat(bagiansurat surat);
    List<bagiansurat> lihatDaftarSurat();
    void updateSurat(int index, bagiansurat surat);
    void hapusSurat(int index);
}

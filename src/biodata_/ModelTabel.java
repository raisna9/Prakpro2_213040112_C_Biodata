/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata_;

/**
 *
 * @author Raisa Isna
 */
import javax.swing.table.*;
import java.util.List;

// membuat class model yang mewarisi class abstracTabelModel
// Membuat class ModelTable yang mewarisi class AbstractTableModel untuk membuat model tabel
public class ModelTabel extends AbstractTableModel {
    // Array columnNames untuk menyimpan nama-nama kolom
    private String[] columnNames = { "Nama", "Nomor HP", "Jenis Kelamin", "Alamat" };
    // Membuat List dengan nama data yang berisi Biodata untuk menyimpan data dari input
    private List<Biodata> data;

    // Constructor ModelTable dengan parameter List<Biodata> data
    public ModelTabel(List<Biodata> data) {
        // Set this.data dengan parameter data
        this.data = data;
    }

    // Fungsi untuk menambah jumlah kolom
    public int getColumnCount() {
        // Kembalikan panjang/ukuran dari array columnNames
        return columnNames.length;
    }

    // Fungsi untuk menambah jumlah baris
    public int getRowCount() {
        // Kembalikan jumlah data yang diterima/panjang dari ArrayList data
        return data.size();
    }

    // Fungsi untuk mendapatkan nama dari kolom yang dipilih dari parameter
    public String getColumnName(int col) {
        // Kembalikan elemen columnNames dengan index col
        return columnNames[col];
    }

    // Fungsi untuk mendapatkan nilai dari baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        // Menyimpan elemen dari List data dari baris yang dipilih ke Biodata rowItem
        Biodata rowItem = data.get(row);
        // Membuat variable value untuk menyimpan nilai dari kolom yang dipilih
        String value = "";

        // Switch case untuk menentukan nilai dari variable value
        switch (col) {
            // Jika col bernilai 0
            case 0:
                // Set value dengan nama dari rowItem
                value = rowItem.getNama();
                break;
            // Jika col bernilai 1
            case 1:
                // Set value dengan noTelepon dari rowItem
                value = rowItem.getNoTelepon();
                break;
            // Jika col bernilai 2
            case 2:
                // Set value dengan jenisKelamin dari rowItem
                value = rowItem.getJenisKelamin();
                break;
            // Jika col bernilai 3
            case 3:
                // Set value dengan alamat dari rowItem
                value = rowItem.getAlamat();
                break;
        }

        // Kembalikan nilai dari variable value
        return value;
    }

    // Fungsi untuk mengatur apakah cell bisa diedit atau tidak
    public boolean isCellEditable(int row, int col) {
        // Kembalikan nilai false
        return false;
    }

    // Method untuk menambah nilai ke table
    public void add(Biodata value) {
        // Menambahkan input user ke List data
        data.add(value);
        // Menambahkan elemen-elemen List data ke table
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

   // Method untuk mengubah nilai di table
public void update(Biodata value) {
    // Membuat variable i untuk menyimpan index dari data
    int i = 0;

    // Looping untuk mencari index dari data yang ingin diubah
    for (Biodata b : data) {
        // Jika id dari data sama dengan id dari value
        if (b.getId().equals(value.getId())) {
            // Modifikasi data di List data langsung
            data.set(i, value);
            // Mengubah nilai di table
            fireTableCellUpdated(i, i);
            break;  // Hentikan looping setelah menemukan data yang ingin diubah
        }
        // Increment i
        i++;
    }
}


    // Method untuk menghapus nilai di table
    public void delete(Biodata value) {
        // Membuat variable i untuk menyimpan index dari data
        int i = 0;

        // Looping untuk mencari index dari data yang ingin dihapus
        for (Biodata b : data) {
            // Jika id dari data sama dengan id dari value
            if (b.getId().equals(value.getId())) {
                // Hapus data dari List data
                data.remove(i);
                // Hentikan looping
                break;
            }
            // Increment i
            i++;
        }
        
        // Menghapus nilai di table
        fireTableRowsDeleted(data.size() - 1,
                data.size() - 1);
    }
}

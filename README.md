## Janji
Saya Fachri Najm Noer Kartiman NIM 2106515 mengerjakan soal TP 2
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan.
Aamiin.

# Tugas TP2DPBO2023
Buatlah program Java yang terkoneksi dengan database MySQL. Berikut spesifikasi program yang harus dibuat:
Program bebas, kecuali program Mahasiswa dan Book Author
Terdapat proses Create, Read, Update, dan Delete data
Terdapat proses Autentikasi (Login, Register) *
Menggunakan minimal 2 tabel pada database
Harus terdapat minimal 1 properti gambar pada class yang dibuat (gambar akan ditampilkan pada UI)
Terdapat pergantian screen pada UI
Terdapat button navigasi untuk beralih screen
List data ditampilkan menggunakan card (JPanel)
contoh card dengan JPanel link
* Boleh login dan/atau register. Tidak perlu ada enkripsi password


File README berisi desain program, penjelasan alur, dan dokumentasi saat program dijalankan (screenshot/screen record)

Submit link repository pada form berikut: [Form Pengumpulan](https://forms.gle/rvb1hKxbQVuYNbhKA) 

## Desain Program
Desain yang saya buat menggunakan 1 Class Utama:
* Mahasiswa
* Menu

`Class Mahasiswa` :
* **NIM** -> NIM mahasiswa, `string`
* **Nama** -> Nama mahasiswa, `string`
* **Nilai** -> Nilai mahasiswa, `string`
* **gender** -> Gender mahasiswa, `string`

`Class Menu` :
* **Set Tabel** -> Mengeset Tabel untuk ditampilkan, `void`
* **Insert Data** -> Menambah data, `void`
* **Update Data** -> mengubah data yang dipilih, `void`
* **Delete Data** -> menghapus data yang dipilih, `void`
* **Reset Form** -> Mereset Form, `void`

_Semua Class diatas dilengkapi dengan setter dan getternya_

## Design GUI
![JAR FILE](design.png)


## Alur Program Program GUI

Text field untuk mengisi data yang berisi nim, nama, nilai dan radio button untuk memilih gender mahasiswa

Mengisi text field dan memlih gender jika di klik `add` maka akan menambah data dan seluruh data akan ditampilkan di tabel

Mengisi text field dan memlih gender jika di klik `Cancel` maka TextField akan kosong

Memilih data jika ada data yang ingin dirubah maka rubah di text field nya atau gender radio button jika sudah maka klik `update`

Memilih data jika ada data yang ingin dihapus jika sudah maka klik `delete`

## Dokumentasi
**JAR FILE**

![JAR FILE](jar-file.png)

**Confirm Delete**
![Screenshot 2023-03-17 091422](https://user-images.githubusercontent.com/92314386/225795247-c63588f5-dc34-4781-9fc3-ee32bde74b70.png)

**Update Data**

![image](https://user-images.githubusercontent.com/92314386/225795139-feaef12f-4d59-4941-a108-e91bc4f8921e.png)


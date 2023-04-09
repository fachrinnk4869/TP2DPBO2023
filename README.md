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
Desain yang saya buat menggunakan 8 Class Utama:
* FrameMenu
* FrameAddArtis
* FrameAddFilm
* MenuArtis
* MenuFilm
* Artis
* Film
* FrameArtisFilm

## Design Class Diagram
![Screenshot 2023-04-09 231831](https://user-images.githubusercontent.com/92314386/230784265-ef12f477-a2e4-4326-b0a7-f01f30d51b17.png)


## Entitas Relasional Diagram
![image](https://user-images.githubusercontent.com/92314386/230784376-2824d317-7619-4fd6-a481-403d3f455272.png)

berdasarkan pada ERD diatas tabel `film` berelasi secara many-to-many dengan `artis`

## Alur Program Program GUI

Text field untuk mengisi data login  untuk memilih gender mahasiswa

Memilih data yang ingin ditampilkan dan CRUD pilih antara data `film` atau data `artis`

Menambah data dengan mengklik klik `add`

Memilih data jika ada data yang ingin dirubah klik `update` dan rubah di text field nya

Memilih data jika ada data yang ingin dihapus jika sudah maka klik `delete`

* untuk mencoba login dapat menggunakan akun berikut

username: mokha

password: mokha30

## Design GUI
## Dokumentasi
**Confirm Delete**
![Screenshot 2023-03-17 091422](https://user-images.githubusercontent.com/92314386/225795247-c63588f5-dc34-4781-9fc3-ee32bde74b70.png)

**Update Data**

![image](https://user-images.githubusercontent.com/92314386/225795139-feaef12f-4d59-4941-a108-e91bc4f8921e.png)


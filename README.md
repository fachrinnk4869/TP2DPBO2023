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

apa cik


## Design Class Diagram
![Screenshot 2023-04-09 231831](https://user-images.githubusercontent.com/92314386/230784265-ef12f477-a2e4-4326-b0a7-f01f30d51b17.png)

Kode tersebut merupakan implementasi dari user interface (UI) untuk melakukan login ke suatu aplikasi. Dalam implementasinya, terdapat koneksi ke database dengan menggunakan class dbConnection untuk melakukan query terhadap tabel akun dengan username dan password yang diinputkan oleh pengguna.

Pada method resetForm(), nilai dari komponen FieldUsername dan FieldPassword akan di-set kembali menjadi string kosong sehingga pada saat pengguna telah melakukan login atau keluar dari aplikasi, maka form login akan di-reset untuk menghindari username dan password sebelumnya tetap tersimpan.

Method initComponents() digunakan untuk mengatur layout dari komponen-komponen yang ada pada form login, seperti label "Username", text field FieldUsername, label "Password", password field FieldPassword, dan button ButtonLogin.

Ketika pengguna menekan button ButtonLogin, maka akan dipanggil method ButtonLoginActionPerformed() yang berisi proses validasi username dan password yang diinputkan oleh pengguna melalui method db.selectQuery(). Apabila hasil query terdapat pada database, maka akan muncul pesan selamat datang pada user dan pengguna akan diarahkan ke halaman utama (FrameMenu) dan form login akan di-close (dispose()). Jika tidak, maka akan muncul pesan kesalahan dan form login akan di-reset.

Class FrameMenu memiliki beberapa objek seperti flag yang bertipe data String dan memiliki akses modifier private, name yang bertipe data String dan memiliki akses modifier private, serta isUpdated yang bertipe data boolean dan memiliki akses modifier private. Selain itu, class FrameMenu juga memiliki beberapa objek GUI seperti mainPanel yang bertipe data JPanel, ButtonArtis yang bertipe data JButton, ButtonFilm yang bertipe data JButton, ButtonAdd yang bertipe data JButton, dan ButtonRelasi yang bertipe data JButton.

Dalam konstruktor class FrameMenu, terdapat method initComponents() yang men-generate komponen-komponen GUI pada frame tersebut seperti button dan panel. Selain itu, pada saat pembuatan objek dari FrameMenu pada konstruktor juga akan di-set name dan flag sesuai dengan parameter yang diterima oleh konstruktor. Selain itu, objek isUpdated di-set menjadi true.

Method setPanelFilm() digunakan untuk menghapus semua komponen pada mainPanel dan menambahkan objek dari class MenuFilm pada mainPanel. Setelah itu, mainPanel di-revalidate dan di-repaint, serta flag di-set menjadi "film".

Method setPanelArtis() hampir sama dengan setPanelFilm(), yaitu menghapus semua komponen pada mainPanel dan menambahkan objek dari class MenuArtis pada mainPanel. Setelah itu, mainPanel di-revalidate dan di-repaint, serta flag di-set menjadi "artis".

Method onDataUpdated() digunakan untuk merefresh data pada frame ini. Jika flag adalah "film", maka akan memanggil method setPanelFilm(), jika tidak, maka akan memanggil method setPanelArtis().

Selain itu, terdapat juga beberapa method setter dan getter untuk objek flag dan isUpdated. Dan pada method ButtonAddActionPerformed() terdapat kondisi dimana jika flag adalah "film", maka akan membuat objek dari class FrameAddFilm, jika tidak, maka akan membuat objek dari class FrameAddArtis.


## Entitas Relasional Diagram
![image](https://user-images.githubusercontent.com/92314386/230784376-2824d317-7619-4fd6-a481-403d3f455272.png)

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


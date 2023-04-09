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

`Login` --> terdiri dari komponen-komponen GUI seperti label, teks field, dan tombol yang digunakan untuk memvalidasi login pengguna dengan mengambil data username dan password dari teks field, kemudian melakukan query ke database dengan menggunakan kelas dbConnection. Jika data yang diinputkan sesuai dengan data yang terdapat di database, maka pengguna akan diarahkan ke FrameMenu. Namun, jika data tidak sesuai atau terjadi kesalahan saat melakukan query ke database, maka akan muncul pesan kesalahan dan teks field akan di-reset.

`FrameMenu` --> memiliki JScrollPane dan beberapa JButton. Kelas FrameMenu memiliki metode untuk menetapkan panel untuk menampilkan film atau artis, berdasarkan tombol mana yang diklik. Kelas ini juga memiliki metode untuk memperbarui data dalam JFrame. Selain itu, kelas FrameMenu memiliki konstruktor yang menginisialisasi komponen GUI dan mengatur variabel nama dan flag ke "film". Metode setIsUpdated () dan getIsUpdated () digunakan untuk melacak apakah data dalam GUI telah diperbarui.

`FrameAddFilm` dan `FrameAddArtis` --> memiliki fungsi untuk menampilkan data film/artis yang akan diupdate dan memberikan opsi untuk mengunggah gambar film/artis. Terdapat dua method, yaitu addData() dan updateData() yang masing-masing digunakan untuk menambahkan data baru dan mengupdate data film yang sudah ada. Terdapat pula fungsi notifyDataUpdated() yang memberikan notifikasi pada FrameMenu ketika data telah diperbarui. Program ini menggunakan dbConnection untuk koneksi database

`MenuFilm` dan `MenuArtis` --> Pada konstruktor, diinisialisasi komponen-komponen JPanel, dan kemudian memanggil method setPanel() untuk menampilkan daftar film/artis pada JPanel tersebut. Di dalam method setPanel(), JPanel dihapus lalu diatur ulang layout-nya. Kemudian, dilakukan query ke database untuk mengambil data film yang disimpan pada tabel "film"/tabel "artis". Selanjutnya, data tersebut ditampilkan dalam bentuk panel pada JPanel utama. Apabila terjadi error pada query atau proses lainnya, maka akan dicetak pesan error pada console. Terakhir, JPanel diperbarui tampilannya dengan memanggil method revalidate() dan repaint().

`Film` dan `Artis` --> memiliki beberapa method, antara lain konstruktor Film()/Artis(), notifyDataUpdated(), dan deleteData(). Pada konstruktor Film()/Artis(), program mengambil data dari database dan menampilkan informasi film berdasarkan id. Method notifyDataUpdated() digunakan untuk memberitahu FrameMenu bahwa data telah diupdate, sedangkan method deleteData() digunakan untuk menghapus data dari database dan mengupdate tampilan tabel pada FrameMenu. Selain itu, program ini juga memiliki sebuah user interface yang terdiri dari beberapa elemen seperti label, button, dan image.

`FrameArtisFilm` -->  Class yang khusus dibuat untuk menghandle relasi many-to-many dari class `Film` dan Class `Artis`. Terdapat beberapa method seperti setTable(), setComboBoxFilm(), setComboBoxArtis(), insertData(), updateData(), dan deleteData() yang digunakan untuk mengambil data dari database dan menampilkan pada UI aplikasi, serta melakukan proses tambah, update, dan hapus pada data tersebut. Objek dari class Item digunakan untuk menyimpan data pada combo box, sedangkan variabel dan objek seperti dtm, isUpdate, selectedIDFilm, selectedIDArtis, db, db2, dan dbChild digunakan untuk membantu proses CRUD.

## Entitas Relasional Diagram
![image](https://user-images.githubusercontent.com/92314386/230784376-2824d317-7619-4fd6-a481-403d3f455272.png)

berdasarkan pada ERD diatas tabel `film` berelasi secara many-to-many dengan `artis`

## Alur Program Program GUI

- Text field untuk mengisi data login  untuk memilih gender mahasiswa

- Memilih data yang ingin ditampilkan dan CRUD pilih antara data `film` atau data `artis`

- Menambah data dengan mengklik klik `add`

- Menambah relasi antara `film` dan  `artis` dengan mengklik klik `X`

- Memilih data jika ada data yang ingin dirubah klik `update` dan rubah di text field nya

- Memilih data jika ada data yang ingin dihapus jika sudah maka klik `delete`

_Untuk mencoba login dapat menggunakan akun berikut:_

username: **fachri**

password: **fachri**

## Design GUI
**Login Form**

**Frame Menu Film**

**Frame Main Artis**

**Frame Menambah Relasi**

## Dokumentasi

**Login**

**Add Data Film dan Artis**

**Update Data Film dan Artis**

**Confirm delete Film dan Artis**

**Add Data Relasi**

**Update Data Relasi**

**Confirm delete Relasi**

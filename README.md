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
![image](https://user-images.githubusercontent.com/92314386/230791982-bd24cca9-8c45-41b4-bd74-71c24fba0de7.png)

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

![image](https://user-images.githubusercontent.com/92314386/230792009-645eb703-a37f-4779-97c0-0821e2823d6e.png)

**Frame Menu Film**

![image](https://user-images.githubusercontent.com/92314386/230792042-88c7ed18-bd16-4bda-ad7d-c746f9bc3660.png)

**Frame Menu Artis**

![image](https://user-images.githubusercontent.com/92314386/230792047-87f050c2-3a9b-4bde-aafd-c4be50146831.png)

**Frame Menambah Relasi**

![image](https://user-images.githubusercontent.com/92314386/230792067-06d5ca87-689e-44dc-91f7-f25dd591d475.png)

## Dokumentasi
**Login**

![image](https://user-images.githubusercontent.com/92314386/230792091-a3a62c12-bc36-4f31-bcdd-037025109208.png)

**Add Data Film dan Artis**

![image](https://user-images.githubusercontent.com/92314386/230792132-f1393d03-bebc-4f1a-b63d-f6510c57963c.png)

![image](https://user-images.githubusercontent.com/92314386/230792193-0a73bd4f-38b6-4035-90a1-8ab8270966f4.png)

![image](https://user-images.githubusercontent.com/92314386/230792153-42e0fac3-6b43-4522-88b4-8c3cfdcae165.png)

**Update Data Film dan Artis**

![image](https://user-images.githubusercontent.com/92314386/230792240-6e715ada-3783-449f-aa72-21b4c414f30e.png)

![image](https://user-images.githubusercontent.com/92314386/230792268-a627065a-e09c-4af5-bcff-708032bdaab3.png)

![image](https://user-images.githubusercontent.com/92314386/230792253-0ea1c399-5218-41b8-bcba-e81ba4f82986.png)

**Confirm delete Film dan Artis**

![image](https://user-images.githubusercontent.com/92314386/230792285-f3f3b38a-5c36-4b71-92f2-c0cfc59f98fc.png)

**Add Data Relasi**

![image](https://user-images.githubusercontent.com/92314386/230792306-19b94f55-7fe6-4c60-92c1-daed6c0dc492.png)

![image](https://user-images.githubusercontent.com/92314386/230792319-0497a082-85e0-40da-a297-5d2607e6ef55.png)

**Update Data Relasi**

![image](https://user-images.githubusercontent.com/92314386/230792345-d26eba1b-77fa-419a-9324-4cf59582a099.png)

![image](https://user-images.githubusercontent.com/92314386/230792375-7bc02206-673e-473c-9549-8d3dfaeaae54.png)

**Confirm delete Relasi**

![image](https://user-images.githubusercontent.com/92314386/230792384-7510eaec-b5a6-49d2-ba4e-342ff590e284.png)

![image](https://user-images.githubusercontent.com/92314386/230792398-6cddb6d7-0449-4dd5-8198-d83540ff1944.png)

## Batasan Program
Sebelum menghapus antara film atau artis dikarenakan digunakan restricted relasi jadinya harus menghapus semua relasi yang berhubungan dengan film atau artis yang ingin dihapus

**Contoh ketika aku menghapus film dengan jumlah artis 1(punya satu relasi dengan artis) tidak bisa**

![image](https://user-images.githubusercontent.com/92314386/230792637-a495d32d-2cc6-4c09-8fed-391da91fd794.png)

**Contoh ketika aku menghapus film dengan jumlah artis 0(tidak punya dengan artis) bisa**

![image](https://user-images.githubusercontent.com/92314386/230792692-a30d57dc-30a7-4888-89e9-59fa57040faf.png)

![image](https://user-images.githubusercontent.com/92314386/230792710-f21d1478-44ee-4d04-b01d-a3c1405479c0.png)


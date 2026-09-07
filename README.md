# P01 - Version Control dan SOLID

Nama: Flora Cahaya Putri  
NPM: 2406350955

## 1. Apakah kode tersebut sudah menerapkan prinsip SOLID?

Kode yang dibuat sudah menerapkan prinsip SOLID melalui pemisahan tanggung jawab antara `Book`, `BookRepository`, `BookRepositoryImpl`, `BookService`, `BookServiceImpl`, dan `BookController`. Namun, penerapannya masih dapat ditingkatkan, terutama pada Dependency Inversion Principle karena `BookServiceImpl` masih membuat ketergantungan langsung terhadap implementasi `BookRepositoryImpl` melalui `getInstance()`.

## 2. Implementasi prinsip SOLID

Implementasi dilakukan dengan memisahkan abstraksi dan implementasi pada repository dan service.

1. **Single Responsibility Principle (SRP)**  
   Setiap class memiliki tanggung jawab yang berbeda. `BookRepositoryImpl` menangani pengelolaan data buku, `BookServiceImpl` menangani logika bisnis, sedangkan `BookController` menangani request dan response dari API.

2. **Open/Closed Principle (OCP)**  
   Repository dan service menggunakan interface sehingga implementasinya dapat dikembangkan atau diganti tanpa harus mengubah kode yang menggunakan abstraksi tersebut.

3. **Liskov Substitution Principle (LSP)**  
   `BookRepositoryImpl` dapat digunakan sebagai implementasi dari `BookRepository`, dan `BookServiceImpl` dapat digunakan sebagai implementasi dari `BookService` tanpa mengubah kontrak yang telah ditentukan oleh interface.

4. **Interface Segregation Principle (ISP)**  
   Interface `BookRepository` dan `BookService` dibuat sesuai kebutuhan masing-masing komponen sehingga class implementasinya hanya bergantung pada method yang relevan.

5. **Dependency Inversion Principle (DIP)**  
   `BookServiceImpl` bergantung pada abstraksi `BookRepository`, bukan langsung pada tipe konkret untuk operasi repository. Dengan demikian, detail implementasi repository dapat diganti tanpa mengubah logika bisnis pada service.

Dengan pemisahan tersebut, kode menjadi lebih terstruktur, mudah dikembangkan, dan lebih mudah di-maintain.
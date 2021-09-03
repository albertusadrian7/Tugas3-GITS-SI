/*
Nama: Albertus Adrian Susanto

Soal:
Buatlah sebuah program password generator sederhana dari nama dan tanggal lahir seseorang. Berikut ketentuan/format password yang akan dihasilkan oleh program tersebut, yaitu:
1. Format awal: Mengambil 2 karakter pertama dari string nama
2. Format tengah: Menghitung jumlah karakter yang ada pada nama, kemudian mengiterasinya secara mundur berdasarkan ketentuan berikut, yaitu:
a. Jika panjang password sudah lebih dari/sama dengan 4, maka lakukan break
b. Jika bilangan habis dibagi 2, maka kalikan iterator dengan bilangan 3
c. Jika iterator bernilai 5 atau 7, maka lakukan continue
d. Selain 3 ketentuan di atas, maka tambahkan iterator dengan bilangan 1
3. Format akhir:
a. Mengambil 2 karakter terakhir dari string nama,
b. Melakukan iterasi terhadap isi dari tanggal lahir, kemudian menjumlahkan setiap hasil iterasi tersebut. Misal: 06022002, maka 0+6+0+2+2+0+0+2 = 12

Input:
- Nama
- Tanggal lahir dengan format ddmmyyyy. Contoh: 6 Februari 2002, maka 06022002

Output:
- Nama dalam huruf kapital
- Password dengan format sesuai dengan ketentuan soal
 */

import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    println("=== Selamat datang di Program Password Generator ===")
    // Input nama panggilan atau nama lengkap
    // var nama: String = "Albertus Adrian"
    print("Masukkan Nama: ")
    var nama: String = reader.nextLine()
    nama = nama.lowercase()
    // Input tanggal lahir dengan format ddmmyyyy. Contoh: 06 Februari 2002, maka input 06022002
    // val tglLahir: String = "06022002"
    print("Masukkan Tanggal Lahir: ")
    var tglLahir: String = reader.next()
    // Variabel untuk menampung format tengah password
    var midPassword: String = ""
    // Variabel untuk menampung hasil penjumlahan masing-masing karakter tanggal lahir
    var sum: Int = 0
    println("\n=== Hasil ===")
    // Mengiterasi panjang dari nama secara mundur dan memberikan kondisi/percabangan sesuai ketentuan soal
    for (i in nama.length downTo 1){
        if (midPassword.length>=4){
            break
        } else if (i%2 == 0) {
            midPassword += "${i*2}"
        } else if (i == 5 || i == 7){
            continue
        } else {
            midPassword += "${i+1}"
        }
    }
    // Menjumlahkan masing-masing karakter dalam tanggal lahir
    var j = 0
    while (j < tglLahir.length) {
        var k = tglLahir[j].toString().toInt()
        sum += k
        j++
    }
    // Membuat variabel password yang berisi sebuah password berupa gabungan format awal, tengah, dan akhir
    var password = "${nama.take(2)}$midPassword${nama.takeLast(2)}$sum"
    // Menampilkan hasil
    println("Nama: ${nama.uppercase()}")
    println("Password: $password")
}
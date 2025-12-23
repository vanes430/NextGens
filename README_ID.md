# NextGens ⚡

**NextGens** adalah plugin Gen Tycoon generasi terbaru yang dirancang untuk performa tinggi, mendukung server **Spigot**, **Paper**, dan **Folia**. Plugin ini dilengkapi dengan fitur unik seperti sistem korupsi (corruption), sellwands, dan kustomisasi penuh.

## ✨ Fitur Utama
*   **Support Folia & Paper**: Dioptimalkan untuk server modern multi-threaded.
*   **Sistem Generator**: Generator yang dapat di-upgrade dengan drops yang bisa dikustomisasi.
*   **Corruption System**: Generator bisa "rusak" dan perlu diperbaiki oleh pemain (fitur unik untuk ekonomi).
*   **Sellwands**: Jual isi chest secara instan dengan multiplier.
*   **Autosell**: Menjual item secara otomatis dari inventory.
*   **GUI Menu**: Shop, Upgrade, dan Settings yang interaktif.
*   **Tiered Generators**: Tingkatan generator yang bisa diatur tanpa batas.

---

## 📜 Commands & Usage

Command utama: `/nextgens`, `/gens`, atau `/ngens`.

### 👤 Perintah Pemain (Player Commands)
Perintah ini biasanya tersedia untuk semua pemain secara default (tergantung konfigurasi).

| Command | Deskripsi |
| :--- | :--- |
| `/genshop` | Membuka menu toko (Shop) untuk membeli generator. |
| `/upgradegens` | Membuka menu untuk upgrade generator. |
| `/pickupgens` | Mengambil (pickup) semua generator milikmu. |
| `/repairgens` | Memperbaiki semua generator yang rusak (corrupted). |
| `/sell` | Menjual item di inventory ke server. |
| `/itemworth` | Mengecek harga jual item yang sedang dipegang. |
| `/settings` | Mengatur preferensi pribadi (misal: notifikasi). |
| `/gens view` | Melihat daftar generator aktif melalui GUI. |
| `/gens trust <add/remove> <player>` | Memberi akses generator ke pemain lain. |

### 🛠️ Perintah Admin (Admin Commands)
Membutuhkan permission `nextgens.admin`.

| Command | Deskripsi |
| :--- | :--- |
| `/gens give <player> <gen> <jumlah>` | Memberikan generator ke pemain. |
| `/gens sellwand <player> <multi> <uses>` | Memberikan Sellwand. <br>Contoh: `/gens sellwand Daffa 1.5 50` |
| `/gens addmax <player> <jumlah>` | Menambah batas maksimum slot generator pemain. |
| `/gens setmultiplier <player> <jumlah>` | Mengatur multiplier penjualan pemain. |
| `/gens reload` | Reload konfigurasi plugin (`config.yml`). |
| `/gens startevent <nama_event>` | Memulai event global (misal: 2x drops). |
| `/gens stopevent` | Menghentikan event yang berjalan. |
| `/gens removegenerators <player>` | Menghapus paksa semua generator milik pemain tertentu. |

---

## 🔒 Permissions

Berikut adalah daftar permission utama. Sebagian besar fitur pemain tidak memerlukan permission khusus kecuali diaktifkan di `config.yml`.

| Permission | Deskripsi |
| :--- | :--- |
| `nextgens.admin` | **Akses Penuh**. Mengizinkan penggunaan semua command admin (give, reload, dll). |
| `nextgens.generator.<id>` | Izin untuk menaruh generator tertentu (jika `place-permission: true` di config). |
| `nextgens.sell` | Izin untuk menggunakan command `/sell` (jika diaktifkan). |
| `nextgens.autosell` | Izin untuk menggunakan fitur Autosell. |

---

## ⚙️ Instalasi

1.  Download file `.jar` NextGens.
2.  Pastikan Anda memiliki dependency berikut:
    *   **Vault** (Wajib untuk ekonomi)
    *   **PlaceholderAPI** (Opsional, untuk placeholder)
    *   **HolographicDisplays / DecentHolograms** (Opsional, untuk hologram di atas generator)
3.  Masukkan ke folder `plugins/` di server Anda.
4.  Restart server.
5.  Edit `config.yml` dan `generators.yml` sesuai kebutuhan server Anda.
6.  Gunakan `/gens reload` setelah mengedit config.

---

## 🔧 Konfigurasi Sellwand
Jika Anda ingin memberikan sellwand, gunakan format command:
```bash
/gens sellwand <nama_player> <multiplier> <jumlah_pakai>
```
*   **Multiplier**: Angka desimal (contoh: `1.5` untuk 1.5x harga).
*   **Jumlah Pakai**: Angka bulat (contoh: `100`). Gunakan `-1` (tergantung setup) atau angka sangat besar untuk tak terbatas.
*   **Cara Pakai**: Klik Kanan pada Chest/Barrel/Shulker menggunakan Sellwand.

---

**NextGens** © 2025 - Developed by BlockSmithStudio / Modified by Vanes430

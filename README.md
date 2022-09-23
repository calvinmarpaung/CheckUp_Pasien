# CheckUp_Pasien
# CheckUp_Pasien
Aplikasi CheckUp dengan JPA, ORM, dan terkoneksi database MySQL

Screenshot Aplikasi Berjalan
![image](https://user-images.githubusercontent.com/106538712/191944657-93c8c80e-b2d6-4144-960a-1fcd1e99a5cc.png)

Screenshot Postman Create
![image](https://user-images.githubusercontent.com/106538712/191945840-8b0b1494-28b4-4772-8b57-eb2d5ba682f8.png)

Screenshot Postman Get by Status
![image](https://user-images.githubusercontent.com/106538712/191945958-84ac9795-a9cf-4d5e-bbf5-8f2b11356788.png)

Screenshot Postman Get all
![image](https://user-images.githubusercontent.com/106538712/191946034-50b3fe69-666d-4d45-9754-48d026b7e365.png)

Screenshot Postman UpdateStatus
![image](https://user-images.githubusercontent.com/106538712/191946117-25bad5f6-e87c-41c7-8267-4996b16bdd9b.png)

Screenshot Postman Delete by Id
![image](https://user-images.githubusercontent.com/106538712/191946219-049bbeac-31e9-47ee-9e06-8766f33c4779.png)

DDL Script: 
CREATE TABLE `check_up` (
  `id` int NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `complaint` varchar(255) DEFAULT NULL,
  `identity_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)

Prerequisites:
1. Ubah password di application.properties
2. Buat database (db_checkups) sesuai spring.datasource.url=jdbc:mysql://localhost:3306/db_checkups di application.properties
3. Jalankan program
4. Jalankan Postman

# Survey-Application
With this application you can create and edit surveys.

<hr>

## *Kullanımı*
#### Kullanımı için gerekenler
- Apache tomcat 7 ve üstü
- Jdk 1.7 ve üstü
- Mysql
#### Localde test etmek için
1. Projede bulunan `surveydb.sql` dosyasını mysql ' e import edin. 
2. Apache tomcat kurulumunu yaptıktan sonra ***Servers > Tomcat 8 > context.xml*** dosyasına database bağlantısı için gerekli ayarlamaları yapın.

	![1](https://cloud.githubusercontent.com/assets/6229029/26834440/066a79ea-4ade-11e7-8d79-7539247bc352.png)
	
	```xml
		<Context>
			..........
			<Resource name="jdbc/spring" auth="Container" 	type="javax.sql.DataSource" 
				maxActive="100" maxIdle="30" 	maxWait="10000" username="root" 
				password="root" driverClassName="com.mysql.jdbc.Driver" 
				url="jdbc:mysql://localhost:3306/surveydb"
			/>
		</Context>
	```

3. ***Maven > Update*** project diyerek projenin gerekli dependency lerini indirin.
4. Projeyi çalıştırabilirsiniz.Not:Kayıt olunduğunda user rolü `ROLE_USER` olarak kaydedilir.Bunu db üzerinden `ROLE_ADMIN` değeri ile değiştirip admin yetkisine sahip olabilirsiniz.

<hr>

## *Projede Kullanılanlar*
- Spring
- Spring MVC
- Spring Testing
- Spring Security
- Apache Tiles
- JSP
- Javascript
- Bootstrap
- Log4j
- Survey JS - Ayrıntılı bilgi için;[http://surveyjs.org](http://surveyjs.org)

<hr>

## *Projenin Eksiklikleri*
- Anket oluşturduktan sonra json verisini kopyalayıp `anket duzenle` kısmına tıklayarak o kısma eklemeniz gerekiyor.
- Anketin cevaplanması sonucu oluşan `json verisi` Spring MVC kısmına yollanıp burada gerekli işlemler yapılarak [Survey-Application-Hibernate](https://github.com/cihangll/Survey-Application-Hibernate) projesi ile ilişkilendirilmesi gerek.İlişkilendirdikten sonra kaydedilen verilerin analizi site üzerinde yapılmalı.
- Her kullanıcı 1 anket oluşturabilir.Birden fazla anket oluşturma hakkı tanınan kullanıcılar için düzenleme yapılmalı.

<hr>

## *Ekran Görüntüleri*

![2](https://user-images.githubusercontent.com/6229029/26835969-3921ad8c-4ae2-11e7-8f2f-eeac947cf205.png)

![3](https://user-images.githubusercontent.com/6229029/26835982-3fdb8792-4ae2-11e7-9d84-3fbab08b9b8d.png)

![4](https://user-images.githubusercontent.com/6229029/26835984-420cf9e2-4ae2-11e7-804d-fae65200a541.png)

![5](https://user-images.githubusercontent.com/6229029/26835988-467a66cc-4ae2-11e7-82f6-92284e15ff48.png)

![6](https://user-images.githubusercontent.com/6229029/26835995-49a2c916-4ae2-11e7-8476-426050785a74.png)

![7](https://user-images.githubusercontent.com/6229029/26835997-4d6f57a8-4ae2-11e7-8bda-de0601bd962a.png)

![8](https://user-images.githubusercontent.com/6229029/26836000-50372222-4ae2-11e7-85fc-bb642efe14a5.png)



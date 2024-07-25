FROM openjdk:21-jdk

COPY target/webapp.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "webapp.jar"]

#önce maven clean install yap .jar oluşur sonra Dockerfile oluştur sondaki .jarı çalıştırıyor sonra docker compose oluştur
#son olarak docker-compose up --build ile hem imajı hemde konteynerları oluştur.

#volume: Docker container'ları arasında veri paylaşımı ve depolama için kullanılan önemli bir özelliktir.
#Docker volume'leri sayesinde, veritabanı dosyaları,
#log dosyaları ve diğer veriler gibi önemli dosyaları Docker container'ları arasında paylaşabilir ve saklayabilirsiniz.

#yani veritabanını konteynır et birde uygulamayaı konteynır et veritabını bilgilerini ikisiyle paylaş.
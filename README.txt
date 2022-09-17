Proyek ini merupakan pembuatan REST API dengan menggunakan :
- JAVA 8
- DB Used PostgresSQL
- Spring boot



Mendapatkan semua movies : GET http://{{baseURL}}/movies

Mendapatkan semua movies berdasarkan category : GET http://{{baseURL}}/movies?category=action

Mendapatkan semua movies berdasarkan kategory dan sorting oldes/newst : GET http://{{baseURL}}/movies?category=action&category=newest

kata kunci untuk sorting dengan newest movies adalah = newest;

kata kunci untuk sorting dengan oldest movies adalah = oldest;

Mendapatkan movies berdasarkan id : GET http://{{baseURL}}/movies/{id}

dengan menggunakan POSTMAN maka didapatkan hasil-nya sebagai berikut :

{
    "code": 200,
    "message": null,
    "data": [
        {
            "title": "Mencuri Raden Saleh",
            "description": "Lorem Ipsum Dolor",
            "category": "comedy",
            "rating": "7.9",
            "isShareable": false,
            "isDownloadable": false
        },
        {
            "title": "Tenggelamnya Kapal Van Derwick",
            "description": "Lorem Ipsum Dolor",
            "category": "love",
            "rating": "7.9",
            "isShareable": false,
            "isDownloadable": false
        },
        {
            "title": "Resident Evil",
            "description": "Lorem Ipsum Dolor",
            "category": "comedy",
            "rating": "7.9",
            "isShareable": false,
            "isDownloadable": false
        },
        {
            "title": "Pengabdi Setan",
            "description": "Lorem Ipsum Dolor",
            "category": "horor",
            "rating": "7.9",
            "isShareable": false,
            "isDownloadable": false
        },
    ],
    "timestamp": "2021-02-15T03:08:12.210819"
}
# SpringBootRestApi
Spring Boot - Building Rest API to perform CRUD operation

Tools Used:
<blockquote>
<p><a href="https://maven.apache.org/">Maven </a></p>
<p><a href="https://spring.io/tools">STS </a></p>  
</blockquote>


# Api Call
<P>
Get User<p>
<code>
curl --location --request GET 'http://localhost:8080/api/users'
</code>

Add User<p>
<code>
curl --location --request POST 'http://localhost:8080/api/addUser' \
--header 'Content-Type: application/json' \
--data-raw '{ 
    "firstName": "ABC",
    "lastName": "XYZ",    
    "email": "ABC_XYZ@gmail.com"
}'
</code>

Get user based on id<p>
<code>
curl --location --request GET 'http://localhost:8080/api/getUser/2'
</code>

Delete user based on id<p>
<code>
curl --location --request DELETE 'http://localhost:8080/api/deleteUser/2'
</code>
</p>

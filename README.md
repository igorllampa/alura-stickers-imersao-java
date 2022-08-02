# alura-stickers-imersao-java
Project developed and based on the java immersion provided by Alura. The main role is to learn and practise java with spring.
This project is divided into two parts:
- alura-stickers : java project that can consume three API's (IMDB, NASA and Linguagens-API) and process the return provided by de API which are composed by a title and an url for an imagem. Thus, is process de content of the URL and save locally an image copy with a fixed text; 
- linguagens-api: spring java project that provides method for insert and list programming languges. Each programming language is composed by a title, a link for an image url and a ranking position; 

# Technologies

-Developed using Java with Spring Framework\
-MongoDB Database\
-Web Server: TomCat\
-IDE:Spring Tool Suite 4/Eclipse 

# Available endpoints in the API

## 1. Programming Languages Register
Method: POST\
URL: //HOST/linguagens\
JSON:\
              {    
                  "title": "Python", \
                  "image": "https://......", \
                  "ranking": 3 \
              }

## 2. List Programming Languages
Method: GET\
URL: //HOST/linguagens\
     
     
#### PS: 
- [x] The Software Postman Client was used to execute the tests with the developed REST API.
- [x]The databased used for testing is Atlas Mongo DB;
- [x]The project linguagens-api is now available for tests in Heroku platform and can acessed by the following link: https://igorllampa-linguagens-api.herokuapp.com/linguagens


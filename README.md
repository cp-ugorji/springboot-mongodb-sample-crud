# Sample RestAPI With MongoDB
This is just a sample API with MongoDB a NoSQL database

# Technologies behind this project are;
```
* JAVA 13,
* SPRINGBOOT,
* SPRING DATA,
* SWAGGER,
* LOMBOK,
* MONGO DB
```
### Steps to install Mongo DB for those whose who don't have it on their computer:
  * go to https://www.mongodb.com/download-center/community,
  * choose the version you want to download,
  * choose your operating system (in my case windows),
  * choose the file to download (msi or zip) - I downloaded the zip,
  * unzip to a directory where you prefer to have mongo db 
  * in my case 
  ``` C:\mongodb-win32-x86_64-2012plus-4.2.2 ``` 
  * but you can simply have as 
  ```C:\mongodb``` for ease
  * create a new directory called ```data\db``` in the same path where you have your mongo db (in my case ```C:\data\db```)
  * this ```data\db``` directory is mandatory/required to save the database records.
  * open command prompt or terminal as the case may be and go to the bin directory
  ```
    C:\mongodb-win32-x86_64-2012plus-4.2.2>cd bin
  ```
  * run the mongodb server
  ```
    C:\mongodb-win32-x86_64-2012plus-4.2.2\bin>mongod.exe
  ```
  * Note that MongoDB server runs on the default port: 27017
  * to test if our mongo db server is up and perform some database operations,
  * we can run the client from command prompt
  ```
    C:\mongodb-win32-x86_64-2012plus-4.2.2\bin>mongo.exe
  ```

Hurray!!!. We have successfully installed MongoDB zip version in windows.

For more info on MongoDB, refer to the documentation on https://docs.mongodb.com/manual/ 
For performing crud operations in MongoDB refer to the documentation on https://docs.mongodb.com/manual/crud/


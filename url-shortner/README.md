# url-shortner
# urlShortener
Shortening logic
- use MD5 base 64 encoding for encoding url (u)
- take first 10 chars (s1) of enncoded string (s2)
- if a shortened URL exist for s1
	- if original URL for s1 is same as u, return s1
	- else skip first character of s2 and check again
- else a unique short URL (s1) is found, return s1


Storage
- cache: hashmap <String, String> shortUrl to longUrl mapping for fast access
- persistent storage: file

Domain object
- String shortUrl
- String longUrl
- int timesAccessed
- Date lastAccessed

APIs
create
	- input: URL
	- output: Short URL
	![image](https://user-images.githubusercontent.com/15718435/148837956-132af201-22ed-4f0c-bc16-9b31184691e3.png)


view
	- input: short URL
	- output: URL
	![image](https://user-images.githubusercontent.com/15718435/148838067-4f6f924d-63c2-46b7-ae44-cf6418e4d4d0.png)


delete
	- input: short URL
	

viewALL
	- input: none
	- output: view all URLs
	![image](https://user-images.githubusercontent.com/15718435/148838255-63422932-a373-4a0d-8de9-b1f58de47cff.png)

Tests
![image](https://user-images.githubusercontent.com/15718435/148842335-a4a3e7fa-2429-4b89-b60f-40c3d83655da.png)

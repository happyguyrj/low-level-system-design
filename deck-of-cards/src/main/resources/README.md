OneBoxDrive is a tool that lets users create, upload and edit documents right in the web browser.
The service wishes to add a functionality to let users share the documents with other users.
The key requirements are:
- When users share a file, they can control whether people can edit, comment on, or only view the file.
- Files could be shared with users, or user groups by entering their individual emails in the share menu. e.g. micky.mouse@mycompany.com
- Files could be shared with user groups, or user groups by entering their individual emails in the share menu. e.g. micky.mouse@mycompany.com
- Files could be shared with user groups, by entering the group's email in the share menu. e.g. engineering@mycompany.com , all@mycompany.com
- Files may also be shared publicly. Anyone with the link to the file would be allowed to access it.
- Owner of the file can revoke access to a file they have shared earlier. 

# You are tasked to architect a system for the above requirements.
How would you go about designing such a system?
Let's start with High level design and then we can to the Low Level Design?
You can assume the infrastructure to create/edit/upload and view files already exists.

##### Additional Requirement:
- I should be able to blacklist a user, or usergroup from having access to the file.

# User
- filesShared


## shareFile
1m

## viewSharedFile
1b

# File
- view
- comment
- edit - all@someCompany
- blackList - staff@someCompany
- owner

table
fileId | Relation | email          | 
1      | owner    | C              |  
1      | blacklist| A              |
1      | view     | A              |





select * from table
where fileId = 1
and email = A


10 worker
- 
- 









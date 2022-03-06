# Design True caller 

## Come up with application that can perform
- Caller identification
- Call blocking
- Spam Detection
- Store users contacts
- Search for users contacts by name and number

## Use cases
- Users should be able to register 
- Users should be able to add contacts
- should be able to import contacts
- should be able to block contacts
- should be able to report spam
- should be able to unblock numbers
- should be notified when suspected junk caller calls
- should be able to identify caller when call comes
- should be able to upgrade to premium plans
- should be able to search for contacts by name
- should be able to search for contacts by number
- Post registration and addition of contacts register with global directory.
- should be able to search from global directory

## Domain
- User

### Enum
- UserCategory

## Service
- UserService
- BlockService
- identificationService
- lookupService
# Approach for system design interviews
## Requirements clarifications
- about the exact scope of the problem we are solving
- part to focus
- Examples
    - Will users of our service be able to post tweets and follow other people?
    - Should we also design to create and display the user’s timeline?
    - Will tweets contain photos and videos?
    - Are we focusing on the backend only or are we developing the front-end too?
    - Will users be able to search tweets?
    - Do we need to display hot trending topics?
    - Will there be any push notification for new (or important) tweets?

## System interface definition
- Define what APIs are expected from the system.
- Examples
    - postTweet(user_id, tweet_data, tweet_location, user_location, timestamp, …)
    - generateTimeline(user_id, current_time, user_location, …)
    - markTweetFavorite(user_id, tweet_id, timestamp, …)

## Back-of-the-envelope estimation
- to estimate the scale of the system we’re going to design
- will also help later when we will be focusing on scaling, partitioning, load balancing and caching.
- Example
    - What scale is expected from the system (e.g., number of new tweets, number of tweet views, number of timeline generations per sec., etc.)?
    - How much storage will we need? We will have different numbers if users can have photos and videos in their tweets.
    - What network bandwidth usage are we expecting? This will be crucial in deciding how we will manage traffic and balance load between servers.

## Defining data model
- clarify how data will flow among different components
- Example
    - User: UserID, Name, Email, DoB, CreationData, LastLogin, etc.
    - Tweet: TweetID, Content, TweetLocation, NumberOfLikes, TimeStamp, etc.
    - UserFollow: UserdID1, UserID2
    - FavoriteTweets: UserID, TweetID, TimeStamp
- Which database system should we use?
- What kind of block storage should we use to store photos and videos?

## High-level design
- identify enough components that are needed to solve the actual problem from end-to-end.

## Detailed design
- Dig deeper into two or three components
- present different approaches, their pros and cons, and explain why we will prefer one approach on the other.
- consider tradeoffs between different options while keeping system constraints in mind.
- Example
    - Since we will be storing a massive amount of data, how should we partition our data to distribute it to multiple databases? Should we try to store all the data of a user on the same database? What issue could it cause?
    - How will we handle hot users who tweet a lot or follow lots of people?
    - Since users’ timeline will contain the most recent (and relevant) tweets, should we try to store our data in such a way that is optimized for scanning the latest tweets?
    - How much and at which layer should we introduce cache to speed things up?
    - What components need better load balancing?

## Identifying and resolving bottlenecks
- Example
    - Is there any single point of failure in our system? What are we doing to mitigate it?
    - Do we have enough replicas of the data so that if we lose a few servers we can still serve our users?
    - Similarly, do we have enough copies of different services running such that a few failures will not cause total system shutdown?
    - How are we monitoring the performance of our service? Do we get alerts whenever critical components fail or their performance degrades
<h1>System Design Concepts</h1>

<h3>DNS</h3>
<ul>
<li>https://sg.indeed.com/career-advice/interviewing/dns-interview-questions
</li>
<li>DNS is short for domain name system. DNS translates domain names or URL into IP addresses, so we don't need to 
remember IP address for different websites. </li>
<li>
DNS servers convert URLs and domain names into IP addresses that computers can understand and use. This process of translation and lookup is called DNS resolution.
1.The user enters a web address or domain name into a browser.
2.The browser sends a message, called a recursive DNS query,to the network to find out which IP or network address the domain corresponds to.
3.If the recursive DNS server does not have an answer, it will query a series of other servers in the following order: DNS root name servers, top-level domain (TLD) name servers and authoritative name servers.
The recursive server stores, or caches, the A record for the domain name, which contains the IP address. The next time it receives a request for that domain name, it can respond directly to the user instead of querying other servers.
</li>
<li>
What is a DNS zone?
The DNS is broken up into many different zones. These zones differentiate between distinctly managed areas in the DNS namespace. A DNS zone is a portion of the DNS namespace that is managed by a specific organization or administrator. A DNS zone is an administrative space which allows for more granular control of DNS components, such as authoritative nameservers. The domain name space is a hierarchical tree, with the DNS root domain at the top. A DNS zone starts at a domain within the tree and can also extend down into subdomains so that multiple subdomains can be managed by one entity.
</li>
</ul>


<h3>Rest API</h3>
<ul>
<li>https://www.geeksforgeeks.org/difference-between-rest-api-and-web-socket-api/</li>
<li>What is REST?  </li>
<li>
REST stands for Representational State Transfer and REST is an architectural design pattern for developing web services, 
it uses HTTP protocol for implementation. 
It follows the stateless concept. The rest architectural requires that client states is not stored on the server
instead of each request made by client must contain all necessary information for that particular http request.
And Rest api also use http status code like 200, 300...
Rest API use HTTP Methods like Get. Post, Put, Delete to work with server-side resources.
REST supports data of multiple formats like XML, JSON

Disadvantage:
Limited real-time support: REST APIs do not support real-time communication between the server and client, 
making them less suitable for applications that require real-time updates.

Soap Only support xml, Rest also support json, one word soap are much more strict than rest

</li>
</ul>

<h3>Web Socket API</h3>
<ul>
<li>https://ably.com/topic/websocket-vs-rest</li>
<li>https://sg.indeed.com/career-advice/interviewing/dns-interview-questions</li>
<li>What is REST?  </li>
<li>
What is WebSocket API?
WebSocket API is a protocol that provides a persistent connection between a client and a server, allowing real-time communication over the web. Unlike traditional HTTP requests, which are request-response based and stateless, WebSocket connections remain open, enabling bi-directional, low-latency communication between a client and a server.
The WebSocket API allows developers to build applications that require real-time updates, such as online gaming, chat applications, financial trading platforms, and more. It also enables server-side push notifications to clients, eliminating the need for clients to continually poll the server for updates.

Disadvantage:
Complexity: WebSocket APIs are more complex to design and implement than REST APIs, requiring additional programming skills and knowledge.
Security: WebSocket APIs can be vulnerable to security threats if not properly secured.
Compatibility: WebSocket APIs are not supported by all browsers, requiring fallback mechanisms for older browsers.

</li>
</ul>

<h3>gRPC</h3>
<ul>
<li>https://www.imaginarycloud.com/blog/grpc-vs-rest/</li>
<li>What is gRPC?  </li>
<li>
What is gRPC API?
gRPC stands for Google Remote Procedure Call and is a variant based on the RPC architecture
Overall, gRPC aims to make data transmissions between microservices faster. It is based on the approach of determining a service, establishing the methods and respective parameters to enable remote calling and return types.
One of the main benefits of gRPC is its speed and efficiency. It uses binary serialization, which means that data is transmitted in a compact and optimized format, reducing network overhead and improving performance. Additionally, gRPC uses HTTP/2 as its underlying transport protocol, which enables efficient multiplexing of multiple requests and responses over a single TCP connection.
Disadvantage:


</li>
</ul>


<h3>Lambda</h3>
<ul>
<li>https://www.imaginarycloud.com/blog/grpc-vs-rest/</li>
<li>What is aws lambda?  </li>
<li>
What is aws lambda
AWS Lambda is a serverless computing service that allows developers to run code in the cloud without the need for a dedicated server. 
  Lambda functions are event-driven, meaning they are triggered by a specific event, such as a file being uploaded to Amazon S3 or a message being posted to an Amazon Simple Notification Service (SNS) topic. The code in a Lambda function is executed in response to the event, and the function can be set up to automatically scale based on the volume of events.

Lambda functions are charged based on the number of requests and the time the function runs, and can be used for a variety of use cases, such as data processing, image and video manipulation
Disadvantage:


</li>
</ul>


<h3>Mysql</h3>
<ul>

<li>1）寻找表A里的元素不在表B里。 （select id from table A where id not in (select id from table B)
方法一(仅适用单个字段)
使用 not in ,容易理解,效率低

select A.ID from A where A.ID not in (select ID from B)

方法二（适用多个字段匹配）
使用 left join...on... , "B.ID isnull" 表示左连接之后在B.ID 字段为 null的记录

select A.ID from A left join B on A.ID=B.ID where B.ID is null 
</li>
</ul>

<h3>Sql vs No Sql</h3>
<ul>
Generally speaking
SQL databases use structured query language (SQL) and have a predefined schema. NoSQL databases have dynamic schemas for unstructured data.
SQL databases are vertically scalable, while NoSQL databases are horizontally scalable.
SQL databases are table-based, while NoSQL databases are document, key-value, graph, or wide-column stores.
SQL databases are better for multi-row transactions, while NoSQL is better for unstructured data like documents or JSON.

NoSQL is preferred over SQL in many cases because it offers more flexibility and scalability. The primary benefit of using a NoSQL system is that it provides developers with the ability to store and access data quickly and easily, without the overhead of a traditional relational database. 

For example, if you need a fast, scalable, and reliable database for web applications then a NoSQL system may be preferable. On the other hand, if your application requires complex data queries and transactional support then an SQL system may be the better choice. Ultimately, there is no one-size-fits-all solution - it all comes down to what you need from your database and which type of system can provide that in the most efficient manner. It's best to research both options thoroughly before making a decision. 
<li>
</li>
</ul>

# LeetCode
https://en.wikipedia.org/wiki/Markdown
<h1>Algo</h1>
<h3>DFS</h3>

<ul>
<li>_230_KthSmallestElementinaBST</li>
<li>_1448_CountGoodNodesInBinaryTree_DFS</li>
</ul>

<h3>Quick Sort</h3>
<ul>
<li>_973_KClosestPointstoOrigin_QuickSort_PQ</li>
</ul>

<h3>TopoLogical Sort</h3>
<ul>
<li>_210_CourseSchedule2_BFS_DFS_TopoLogicalSort</li>
</ul>

<h3>Two Pointer</h3>
<ul>
<li>_75_SortColors_twopointer</li>
<li>_142_LinkedListCycle2_twopointer       ////////  Floyd's cycle detection</li>
<li>_287_FindtheDuplicateNumber_TwoPointer_Floyd</li>
<li>_340_LongestSubstringwithAtMostKDistinctCharacters_TwoPointer</li>
<li>_424_LongestRepeatingCharacterReplacement_twoPointer</li>
</ul>

<h3>Floyd's algorithm </h3>
<ul>
<li>_287_FindtheDuplicateNumber_TwoPointer_Floyd</li>
<li>_142_LinkedListCycle2_twopointer</li>
</ul>

<h3>Binary Search</h3>
<ul>
<li>_69_Sqrt_BS</li>
<li>_702_SearchinaSortedArrayofUnknownSize_BS</li>
</ul>

<h1>DataStructure</h1>

<h3>PriorityQueue</h3>
<ul>
<li>_253_MeetingRooms2</li>
<li>_358_RearrangeStringkDistanceApart_Greedy_PQ</li>
</ul>

<h3>TreeMap</h3>

<ul>
<li>_352_DataStreamAsDisjointIntervals_TreeMap</li>
<li>_729_MyCalendar_TreeMap_TreeSet</li>
</ul>

<h3>Pair</h3>
<ul>
<li>_987_VerticalOrderTraversalofaBinaryTree_FollowUp_Pair</li>
</ul>



<h3>BinaryTree</h3>

<ul>
<li>_105_ConstructBinaryTreefromPreorderandInorderTraversal_Recur</li>
<li>_106_ConstructBinaryTreefromInorderandPostorderTraversal_Recur</li>
<li>_270_ClosestBinarySearchTreeValue_Recursion_Iterative</li>
</ul>


<h4>
<li>https://stackoverflow.com/questions/2050120/why-use-two-stacks-to-make-a-queue/2050402#2050402</li>
<li>https://en.wikipedia.org/wiki/Non-blocking_algorithm</li>
</h4>


<h3>Computer Concept</h3>
<li>
In a single core system will you use multithreading or multiprocessing? Why?


https://leetcode.com/discuss/interview-question/operating-system/380838/In-a-single-core-system-will-you-use-multithreading-or-multiprocessing-Why/374598
</li>

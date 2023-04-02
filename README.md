<h1>System Design Concepts</h1>

<h3>DNS</h3>
<ul>
<li>https://sg.indeed.com/career-advice/interviewing/dns-interview-questions</li>
<li>DNS is short for domain name system. DNS translates domain names into IP addresses of websites and computers. This transformation makes internet addresses easier to remember, which can eventually increase the efficiency of different working processes</li>
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
What is REST?
REST stands for Representational State Transfer and REST is an architectural design pattern for developing web services, it uses HTTP protocol (web protocol) for implementation. Rest API use HTTP Methods like Get. Post, Put, Delete to work with server-side resources.
REST supports data of multiple formats like XML, JSON
It follows the statelessness concept where the client request and response are not dependent on others and thereby provides total assurance of getting the required data.
Disadvantage:
Limited real-time support: REST APIs do not support real-time communication between the server and client, making them less suitable for applications that require real-time updates.

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

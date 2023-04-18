![image](https://github.com/zhixinzhang/LeetCode/blob/master/Notification_System_design.PNG)

<li>Function Requirements
1. send notifications to subscribed users
2. only email
3. cron job to send noti
4. receive new events
5. we may use different strategy 
6. retry failed notif up to 3 times
7, no need to keep in order send noti
8. 3rd vendor to send email
9, support to check noti info

Non-Function Requirements
1. highly available
2. scalable
3. noti at least deliver one time
4. low latency

System Throughput Estimation 

1. 5M / 100 ~ 50K users 1kB 
2. 100K Events ~ 1kb  

Mysql DB User and Events
DynamoDB Noti data
S3 to store events image and short video

  </li>

![image](https://github.com/zhixinzhang/LeetCode/blob/master/Akli%20Stuhub%20email.PNG)


 https://cloudificationzone.com/2021/08/13/notification-system-design/
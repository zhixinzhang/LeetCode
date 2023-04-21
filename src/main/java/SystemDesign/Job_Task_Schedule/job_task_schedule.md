![image](https://user-images.githubusercontent.com/21000178/231560064-a95a2207-5860-49d3-b593-f01057231608.PNG)
<h3>Resources</h3>
<li>https://towardsdatascience.com/ace-the-system-design-interview-job-scheduling-system-b25693817950</li>
 

<ul>
Job Schedule System
F R :
create/delete job
check job status/info
check job histories
get notified
 repeating? cronTab
kill job if take too long?
auto-retry?

Non - F R:
highly available
scalable
high concurrency job / 1M job / per hour
never lost job
fault-tolerance
Traffic / DB Estimation
1 M DAU, 100 request ~ 100 M / 100k ~ 1k QPS
1 M * 10 job  10 M new jobs/per day
one server 2CPU , 16 threads/ 0.5  2 * 16 / 0.5 ~ 60 jobs/ per sever
1000 / 60 ~ 35 servers
1B recurring -> 1B / 100k ~ 10000M / 100k ~ 10K job/1s
10K * 5 ~ 50 K jobs
50k/ 30 ~ 1.7K servers

10 M jobs * 0.1MB ~ 1M MB ~ 10GB / per day
S3
AWS

MySQL
Job Table {
 job_id: PK
    user_id:FK
    job_name:
    job_des:
    job_type: recurring,  one-time
   create_time:
   last_execution_time:
   job_status: new, pending, finished, success, killed
   retry-cnt:
   crontTab : 0 4 * * sun
   next_execution_time: unix timestamp  1600000000
}

schedule_table{
 schedule_id:
    execution_time:
    job_id:
    shard:
}

execution table {
 execute_id:
    job_id:
    status:
    worker_id:
    finished_time:
}

Select * from schedule_table where execution_time > "1600"
and execution_time < "1620"
</ul>

 

#!/bin/bash

echo '{
    "logs": {
        "logs_collected": {
            "files": {
                "collect_list": [
                    {
                        "file_path": "/var/log/messages",
                        "log_group_name": "kalyan.log",
                        "log_stream_name": "{instance_id}"
                    }
                ]
            }
        }
    }
}' > "/opt/aws/amazon-cloudwatch-agent/etc/amazon-cloudwatch-agent.d/my.json"
/opt/aws/amazon-cloudwatch-agent/bin/amazon-cloudwatch-agent-ctl -a append-config
/opt/aws/amazon-cloudwatch-agent/bin/amazon-cloudwatch-agent-ctl -a stop
/opt/aws/amazon-cloudwatch-agent/bin/amazon-cloudwatch-agent-ctl -a start

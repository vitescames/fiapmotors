aws_region         = "us-east-1"
cluster_name       = "cluster"
service_name       = "fiapmotors-service"
task_family        = "fiapmotors-task"

ecr_repo_url       = "002777847910.dkr.ecr.us-east-1.amazonaws.com/fiapmotors"
#image_tag          = "latest"

subnet_ids         = ["subnet-f00064af", "subnet-9e1c4190"]
security_group_ids = ["sg-4118314d"]
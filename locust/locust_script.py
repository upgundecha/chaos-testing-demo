from locust import HttpLocust, TaskSet

def index(l):
    l.client.get("/player/all")

class ConsumerBehavior(TaskSet):
    tasks = {index: 2}

class WebsiteUser(HttpLocust):
    task_set = ConsumerBehavior
    min_wait = 5000
    max_wait = 9000
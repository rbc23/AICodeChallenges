import datetime

def convert_to_internet_time():
    now = datetime.datetime.now()
    total_seconds = (now.hour * 3600) + (now.minute * 60) + now.second
    internet_time = int((total_seconds / 86.4) % 1000)
    return internet_time

internet_time = convert_to_internet_time()
print("Swatch Internet Time:", internet_time)
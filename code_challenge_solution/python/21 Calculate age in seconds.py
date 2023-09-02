import datetime

def calculate_age_in_seconds():
    birthdate_str = input("Enter your birthdate (YYYY-MM-DD): ")
    birthdate = datetime.datetime.strptime(birthdate_str, "%Y-%m-%d")
    current_date = datetime.datetime.now()
    age_in_seconds = (current_date - birthdate).total_seconds()
    print("Your age in seconds is:", age_in_seconds)

calculate_age_in_seconds()
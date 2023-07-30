from datetime import datetime

def calculate_age_in_seconds(birth_year):
    current_year = datetime.now().year
    age_in_years = current_year - birth_year
    age_in_seconds = age_in_years * 365 * 24 * 60 * 60
    return age_in_seconds

birth_year = int(input("Enter your birth year: "))
age_in_seconds = calculate_age_in_seconds(birth_year)
print("Your age in seconds is:", age_in_seconds)
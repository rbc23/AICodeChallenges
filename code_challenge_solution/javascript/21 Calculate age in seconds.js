var ageInSeconds = function(age) {
    var secondsInMinute = 60;
    var minutesInHour = 60;
    var hoursInDay = 24;
    var daysInYear = 365;

    var seconds = age * secondsInMinute * minutesInHour * hoursInDay * daysInYear;
    return seconds;
};

console.log(ageInSeconds(30));
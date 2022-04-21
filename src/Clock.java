public class Clock {
    int hours = 0;
    int minutes = 0;
    int seconds = 0;

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void delayBySeconds(int delay) {
        this.seconds += delay;
        if (this.seconds >= 60) {
            this.minutes += (seconds / 60);
            this.seconds = seconds - ((seconds / 60) * 60);
        }
        if (this.minutes >= 60) {
            this.hours += (minutes / 60);
            this.minutes = minutes - ((minutes / 60) * 60);
        }
        if (this.hours >= 24) {
            this.hours = hours - ((hours / 24) * 24);
        }
    }

    public String toString() {
        return formatTime(hours) + ":" + formatTime(minutes) + ":" + formatTime(seconds);
    }

    public String formatTime(int timeUnit) {
        String output = String.valueOf(timeUnit);
        if (output.length() == 1)
            return "0" + output;
        else
            return output;
    }

    public void reset() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

}

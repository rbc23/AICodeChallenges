public class ASCIIDigitalClock {
    public static void main(String[] args) {
        while (true) {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);

            String hourString = String.format("%02d", hour);
            String minuteString = String.format("%02d", minute);
            String secondString = String.format("%02d", second);

            String time = hourString + ":" + minuteString + ":" + secondString;

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(" _____               _           _         ");
            System.out.println("/  __ \\             (_)         | |     ");
            System.out.println("| /  \\/_ __ ___  __ _ _ __   __| |_   _ ");
            System.out.println("| |   | '__/ _ \\/ _` | '_ \\ / _` | | | |");
            System.out.println("| \\__/\\ | |  __/ (_| | | | | (_| | |_| |");
            System.out.println(" \\____/_|  \\___|\\__,_|_| |_|\\__,_|\\__, |");
            System.out.println("                                   __/ |");
            System.out.println("                                  |___/ ");
            System.out.println("");
            System.out.println("          " + time);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

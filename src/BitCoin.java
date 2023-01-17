import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.net.*;
import java.io.*;
import java.io.IOException;
import java.io.FileReader;
    public class BitCoin {
        public static class getLive {
            String inputLine;
            double price;

            void price() throws Exception {
                URL coinDeskURL = new URL("https://api.coindesk.com/v1/bpi/currentprice.json ");
                URLConnection coinDeskUrlConnection = coinDeskURL.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(coinDeskUrlConnection.getInputStream()));

                while ((this.inputLine = in.readLine()) != null) {
                    setBTCPrice();
                }
                in.close();
            }

            void setBTCPrice() {
                String parseJSON = this.inputLine.substring(this.inputLine.indexOf("USD", this.inputLine.indexOf("bpi")), this.inputLine.indexOf("GBP"));
                this.price = Double.parseDouble(parseJSON.substring(parseJSON.indexOf("rate_float") + 13, parseJSON.indexOf("}")));
            }

            public double getBTCPrice() {
                return this.price;
            }
        }

        public static class myDate {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            public String myGetDate() {
                date = Calendar.getInstance().getTime();
                return dateFormat.format(date);
            }
        }

        public static class ledger {
            ArrayList<String>names = new ArrayList();
            public void add(String s) {
                names.add(s);
            }
            public void print() {
                System.out.println(names);
            }
            void writeIt (String Lab6) {
                try {
                    FileWriter myWriter = new FileWriter("C:\\Users\\Jessica\\Documents\\Lab6.txt");
                    for (int i = 0; i < names.size(); i++) {
                        myWriter.write(names.get(i));
                        myWriter.write("\n");
                    }
                    myWriter.close();
                    System.out.println("Successfully saved to file");
                } catch (IOException e) {
                    System.out.println("An error occurred, and did not save to file");
                    e.printStackTrace();
                }
            }
            void readIt(String Lab6) throws IOException {
                ArrayList<String>file = new ArrayList<String>();
                String Lab = "C:\\Users\\Jessica\\Documents\\Lab6.txt";
                FileReader fr = new FileReader(Lab);
                try (BufferedReader br = new BufferedReader(fr)){
                    String line;
                    while((line = br.readLine()) != null) {
                        file.add(line);
                    }
                }
                System.out.println("Here is what was in your file:");
                for (int counter = 0; counter < file.size(); counter++) {
                    System.out.println(file.get(counter));
                }
            }
        }

        public static class wallet {
            double numCoins = 0;
            public void add(double c){
                numCoins += c;
            }
            public void printIt(){
                System.out.println("Your Bitcoin balance is " + numCoins);
            }
        }

        public static void main(String[] args) throws Exception {
            getLive g = new getLive();
            wallet w = new wallet();
            myDate d = new myDate();
            ledger l = new ledger();
            double USD = 75000.0;
            String command;
            String[] commandParts;
            Scanner S = new Scanner(System.in);
            boolean notDone = true;

            while (notDone) {

                System.out.println(" ");
                System.out.println("--------------------------------------");
                g.price();
                System.out.println("Enter a command:");
                command = S.nextLine();
                System.out.println(" ");
                commandParts = command.split(" ");

                switch (commandParts[0]) {
                    case "buy" -> {
                        System.out.println("Okay, you want to buy " + commandParts[1] + " bitcoins");
                        double buyAmount = Double.parseDouble(commandParts[1]);
                        USD = USD - (buyAmount*g.getBTCPrice());
                        System.out.println("You bought " + buyAmount + " bitcoins for $" + g.getBTCPrice());
                        String historyStr = "You bought " + buyAmount + " bitcoins on " + d.myGetDate();
                        l.add(historyStr);
                        l.writeIt("lab6");
                        w.add(buyAmount);

                    }
                    case "sell" -> {
                        System.out.println("Okay, you want to sell " + commandParts[1] + " bitcoins");
                        double sellAmount = Double.parseDouble(commandParts[1]);
                        USD = USD + (sellAmount*g.getBTCPrice());
                        System.out.println("You sold " + sellAmount + " bitcoins for $" + g.getBTCPrice());
                        String historyStr = "You sold " + sellAmount + " bitcoins on " + d.myGetDate();
                        l.add(historyStr);
                        l.writeIt("Lab6");
                        w.add(-sellAmount);
                    }
                    case "price" -> {
                        System.out.println("Okay, you want to check the price of Bitcoin");
                        System.out.println("The current price of Bitcoin is: $" + g.getBTCPrice());

                    }
                    case "balance" -> {
                        System.out.println("Okay, you want to check your balance");
                        System.out.println("You have $" + USD);
                        w.printIt();
                    }
                    case "history" -> {
                        System.out.println("Okay, you want to see your history");
                        l.print();
                        l.readIt("Lab6");
                    }
                    case "add to file" -> {

                    }
                    case "exit" -> {
                        System.out.println("Have a great day!");
                        notDone = false;
                    }
                }
            }
        }
    }
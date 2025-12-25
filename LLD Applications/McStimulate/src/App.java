import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        MiniDataBase system = new MiniDataBase();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            String[] cmd = line.split(" ");

            switch (cmd[0]) {
                case "SET":
                    system.set(cmd[1], cmd[2]);
                    break;

                case "GET":
                    String val = system.get(cmd[1]);
                    System.out.println(val == null ? "null" : val);
                    break;

                case "UNSET":
                    system.unset(cmd[1]);
                    break;

                case "COUNT":
                    int cnt = system.count(cmd[1]);
                    System.out.println(cnt == 0 ? "null" : cnt);
                    break;

                case "BEGIN":
                    system.begin();
                    break;

                case "ROLLBACK":
                    system.rollback();
                    break;

                case "COMMIT":
                    system.commit();
                    break;

                default:
                    System.out.println("INVALID COMMAND");
            }
        }
    }

}

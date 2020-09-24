public class Main {
    public static void main(String[] args) {
        String file1 = FileProcessing.TxtToString(args[0]);
        String file2 = FileProcessing.TxtToString(args[1]);
        String anstext=args[2];
        double ans = SimCos.getCos(file1, file2);
        FileProcessing.writeAnswer(ans,anstext);
    }
}


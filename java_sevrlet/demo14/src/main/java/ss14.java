public class ss14 {
    public static void phuongTrinhBacHai(int a, int b,int c){
        double delta =b*b-(4*a*c);
        double x1 =0;
        double x2 =0;
        if (delta <0){
            System.out.println("phương trình vô nghiệm");
        } else if (delta ==0) {
            x1 =(-b)/(2*a);
            System.out.println("phương trình có 1 nghiêm x1 =x2 ="+x1);
        }
        else {
            x1 =(Math.sqrt(delta)-b)/2*a;
            x2 =(Math.sqrt(delta)-b)/2*a;
            System.out.println("phương trình có 2 nghiệm x1="+x1+"x2="+x2);
        }
    }

    public static void main(String[] args) {
        phuongTrinhBacHai(1,2,3);
    }
}

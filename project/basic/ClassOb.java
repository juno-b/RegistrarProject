class ClassOb {
    private String nam;
    private int tim;
    private String rom;
    private String tea;

    public static void main(String[] args) {
        ClassOb one = new ClassOb();
        one.setName("test1");
        one.setTime(1);
        one.setRoom("oneRoom");
        one.setTeach("One Prof");
        ClassOb two = new ClassOb("test2", 2, "twoRoom", "Two Prof");
        printClass(one);
        printClass(two);
    }

    public ClassOb() {
        /*
         * this.name = null;
         * this.time = null;
         * this.room = null;
         * this.teach = null;
         */
    }

    public ClassOb(String na, int ti, String ro, String te) {
        nam = na;
        tim = ti;
        rom = ro;
        tea = te;
    }

    public static void printClass(ClassOb test) {
        System.out.println(
                test.getName() + ": held in " + test.getRoom() + " at " + test.getTime() + " with " + test.getTeach());
    }

    public void setName(String n) {
        nam = n;
    }

    public void setTime(int n) {
        tim = n;
    }

    public void setRoom(String n) {
        rom = n;
    }

    public void setTeach(String n) {
        tea = n;
    }

    public String getName() {
        return nam;
    }

    public int getTime() {
        return tim;
    }

    public String getRoom() {
        return rom;
    }

    public String getTeach() {
        return tea;
    }
}
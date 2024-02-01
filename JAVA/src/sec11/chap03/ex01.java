package sec11.chap03;

public class ex01 {
    public static void main(String[] args) {
        // 그룹을 특정하지 않고 생성할땐 runnable만 들어감
        Thread thr1 = new Thread(() -> {});

        // 💡따로 그룹을 지정해주지 않은 쓰레드
        // -main 쓰레드그룹에 속함
        ThreadGroup mainThrGroup = thr1.getThreadGroup();
        String mainThrGroupName = mainThrGroup.getName();


        // 💡쓰레드 그룹 직접 생성하기
        ThreadGroup threadGroup1 = new ThreadGroup("TG_1");
        String thrGroup1Name = threadGroup1.getName();

        // 💡그룹에 속한 쓰레드를 만드는 생성자
        // 가존 방식의 쓰레브와동일하지만 그룹이름 추가
        Thread thr2 = new Thread(threadGroup1, () -> {});
        String thr2GroupName = thr2.getThreadGroup().getName();

        // 💡쓰레드 그룹안에 속한 쓰레드 그룹 만들기
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "TG_2");
        String thrGroup2 = threadGroup2.getName();
        String thrGroup2ParentaName = threadGroup2.getParent().getName();
    }
}

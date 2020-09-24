import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void SameText () {
        String s1 = FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        String s2 = FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        double mark = SimCos.getCos(s1,s2);
        assertEquals(1.0,mark,0);
    }

    @Test
    public void DifferentText_1 () {
        String s1 = FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        String s2 = FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/differentText.txt");
        double mark1 = SimCos.getCos(s1,s2);
        //查重率在0～10%
        double min = 0.0;
        double max = 0.1;
        boolean mark2 = mark1 > min && (mark1 < max);
        assertTrue(mark2);
    }

    @Test
    public void DifferentText_2 () {
        String s1 = "广工的饭堂真好吃";
        String s2 = "计算机学院课程有趣";
        double mark = SimCos.getCos(s1,s2);
        assertEquals(0,mark,0);
    }

    @Test
    public void AddText_1 () {
        String s1=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        String s2=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig_0.8_add.txt");
        double sum=SimCos.getCos(s1,s2);
        assertEquals(0.8,sum,0.1);
    }

    @Test
    public void AddText_2 () {
        String s1= "今天去饭堂吃了鸡排饭。";
        String s2= "今天我和我的舍友去了广东工业大学的二号饭堂吃了鸡排饭。";
        double sum=SimCos.getCos(s1,s2);
        assertEquals(0.8,sum,0.1);
    }

    @Test
    public void DelText_1 () {
        String s1=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        String s2=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig_0.8_del.txt");
        double sum=SimCos.getCos(s1,s2);
        Assert.assertEquals(0.8,sum,0.1);
    }

    @Test
    public void DelText () {
        String s1= "我们广东工业大学的饭堂最好吃的是鸡排饭。";
        String s2= "广工最好吃的是鸡排饭。";
        double sum=SimCos.getCos(s1,s2);
        Assert.assertEquals(0.5,sum,0.1);
    }


    @Test
    public void DisText_1() {
        String s1=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        String s2=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig_0.8_dis_1.txt");
        double sum=SimCos.getCos(s1,s2);
        Assert.assertEquals(0.8,sum,0.2);
    }

    @Test
    public void DisText_10() {
        String s1=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        String s2=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig_0.8_dis_10.txt");
        double sum=SimCos.getCos(s1,s2);
        Assert.assertEquals(0.8,sum,0.2);
    }

    @Test
    public void DisText_15() {
        String s1=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig.txt");
        String s2=FileProcessing.TxtToString("/Users/yuquanyou/Downloads/YuquanYou_PEHW/test/orig_0.8_dis_15.txt");
        double sum=SimCos.getCos(s1,s2);
        Assert.assertEquals(0.8,sum,0.2);
    }
}
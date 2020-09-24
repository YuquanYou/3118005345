
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;

import java.util.*;

public class SimCos {//余弦相似度算法

    public static double getCos(String s1, String s2) {
        Map<String, Vector<Integer>> map1 = new TreeMap<String,Vector<Integer>>();//词出现的位置
        Map<String,Vector<Integer>> map2 = new TreeMap<String,Vector<Integer> >();//按键值排序
        List<Term> termList = IndexTokenizer.segment(s1);//分词

        int p = 0;

        for (Term term : termList) {
            String s = term.toString(), news = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
                    news += c;
                }
            }
            if(map1.get(news)==null){
                Vector<Integer>off=new Vector<Integer>(100);
                off.add(p);
                map1.put(news,off);
            }
            map1.get(news).add(p);
            p++;
        }

        //相同方式处理第二个文本
        termList = IndexTokenizer.segment(s2);
        p=0;
        for (Term term : termList) {
            String s = term.toString(), news = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
                    news += c;
                }
            }
            if(map2.get(news)==null){
                Vector<Integer>off=new Vector<Integer>(100);
                off.add(p);
                map2.put(news,off);
            }
            map2.get(news).add(p);
            p++;
        }

        //计算COS
        int cnt=0;
        double nune = 0, deno1 = 0, deno2 = 0,sum=0;
        for(String key:map1.keySet()){
            Vector<Integer>off1=map1.get(key);
            Vector<Integer>off2=map2.get(key);
            if(off2!=null){//第二个文本中也存在这个词，计算向量
                nune=deno1=deno2=0;
                for(int i=0;i<off1.size()&&i<off2.size();i++){
                    nune+= off1.elementAt(i)*off2.elementAt(i);
                    deno1+= off1.elementAt(i)*off1.elementAt(i);
                    deno2+=off2.elementAt(i)*off2.elementAt(i);
                }
                deno1 = Math.sqrt(deno1);
                deno2 = Math.sqrt(deno2);
                double down = deno1 * deno2;
                if(down!=0){
                    sum+=nune/down;
                }
            }
            cnt++;
        }
        return sum/cnt;
    }
}

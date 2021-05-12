package XinxilunSYY;

/**
 * @auther Medo
 * @Time 2020 - 10 - 06 - 20:50
 */

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class SnFn
{
    private Map<Byte, String> encodeMap = new HashMap<Byte, String>();
    private Map<Byte, Node> byteCountMap = new HashMap<Byte, Node>();
    public void createHuffmanEncode(final File file) throws IOException
    {
        final FileInputStream fileInputStream = new FileInputStream(file);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s =bufferedReader.readLine();
        int len = s.length();
        int byteValue = 0;
        while ((byteValue = fileInputStream.read()) != -1)
        {
            final Byte byteObj = new Byte((byte) byteValue);
            Node count = byteCountMap.get(byteObj);

            if (count == null)
            {
                count = new Node();
                count.value = 0;
                byteCountMap.put(byteObj, count);
            }

            count.value++;
        }
        int sum = byteCountMap.size();
        Map maps = new HashMap<Byte,Double>();
        for (final Map.Entry<Byte, Node> encodeEntry : byteCountMap.entrySet())
        {
            maps.put(encodeEntry.getKey(),rate(encodeEntry.getValue().value,len));
        }
        Set set1 = maps.keySet();
        Iterator iterator = set1.iterator();
        double sumH = 0;
        double H  = 0;
        double p = 0 ;
        while (iterator.hasNext()){
            Byte by = (Byte) iterator.next();
            p = (double) maps.get(by);
            H = p * Math.log(p);
            sumH += H;
        }
        for (final Map.Entry<Byte, Node> encodeEntry : byteCountMap.entrySet())
        {
            System.out.println((char) (encodeEntry.getKey().byteValue()) + " : " + encodeEntry.getValue().value);
        }
        System.out.println("******************************");
                Set set3 = maps.keySet();
                Iterator iterator2 = set3.iterator();
                while (iterator2.hasNext()){
                    Byte by = (Byte) iterator2.next();
                    p = (double) maps.get(by);
                    System.out.println((char)by.byteValue() + " : " + p);
                }
        System.out.println("--------------------------");
        final java.util.List<Map.Entry<Byte, Node>> byteCountList = new ArrayList<Map.Entry<Byte, Node>>(
                byteCountMap.entrySet());
        Collections.sort(byteCountList, new Comparator<Map.Entry<Byte, Node>>()
        {
            @Override
            public int compare(Entry<Byte, Node> o1, Entry<Byte, Node> o2)
            {
                return o2.getValue().value - o1.getValue().value;
            }
        });
        final Node rootNode = new Node();
        spiltNodeList(rootNode, byteCountList);
        for (final Map.Entry<Byte, Node> entry : byteCountMap.entrySet())
        {
            final StringBuffer sb = new StringBuffer();
            Node tempNode = entry.getValue();
            while (tempNode != rootNode)
            {
                final Node parentNode = tempNode.parent;
                if (parentNode.left == tempNode)
                {
                    sb.append("0");
                }
                else
                {
                    sb.append("1");
                }
                tempNode = tempNode.parent;
            }

            encodeMap.put(entry.getKey(), sb.reverse().toString());
        }
        for (final Map.Entry<Byte, String> encodeEntry : encodeMap.entrySet())
        {
            System.out.println((char) (encodeEntry.getKey().byteValue()) + " : " + encodeEntry.getValue());
        }
        Set set2 = maps.keySet();
        Iterator<Map.Entry<Byte,Double>> it = maps.entrySet().iterator();
          double sumL = 0 ;
          double L  = 0;
          String ss = "";
          int l = 0;
        while (it.hasNext()){
            Byte by = (Byte) it.next().getKey();
            for (final Map.Entry<Byte, String> encodeEntry : encodeMap.entrySet())
            {
                if (by.byteValue() == encodeEntry.getKey()) {
                    ss = encodeEntry.getValue();
                    l = ss.length();
                }
            }
            p = (double) maps.get(by);
           L = p * l;
           sumL += L;
        }
        System.out.println("平均长度：" + sumL);
        System.out.println("信息熵为：" + (-sumH));
        System.out.println("译码为：" + s);
    }
    private double rate(int parseInt, int sum) {

        return parseInt*(1.0)/sum;
    }
    public static void main(String[] args) throws IOException
    {
        final File file = new File("E:\\SNFN.txt");
        new SnFn().createHuffmanEncode(file);
    }
    private void spiltNodeList(final Node rootNode, final java.util.List<Map.Entry<Byte, Node>> nodeList)
    {
        final int size = nodeList.size();
        final int mid = size / 2;
        int left = mid;
        if (left == 1)
        {
            final Map.Entry<Byte, Node> entry = nodeList.get(mid - 1);
            entry.getValue().parent = rootNode;
            rootNode.left= entry.getValue();
        }
        else
        {
            final Node leftRootNode = new Node();
            spiltNodeList(leftRootNode, nodeList.subList(0, mid));
            leftRootNode.parent = rootNode;
            rootNode.left = leftRootNode;
        }
        int right = size - mid;
        if (right == 1)
        {
            final Map.Entry<Byte, Node> entry = nodeList.get(size - 1);
            entry.getValue().parent=rootNode;
            rootNode.right = entry.getValue();
        }
        else
        {
            final Node rightRootNode = new Node();
            spiltNodeList(rightRootNode, nodeList.subList(mid, size));
            rightRootNode.parent = rootNode;
            rootNode.right = rightRootNode;
        }
    }
}
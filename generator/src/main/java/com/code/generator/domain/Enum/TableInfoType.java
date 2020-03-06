package com.code.generator.domain.Enum;

import java.util.*;
import java.util.stream.Collectors;

public enum TableInfoType {

    TABLENAME("TABLENAME"),
    TABLECOM("TABLECOMMENT"),
    ENGINE("ENGINE"),
    COLNAME("COLNAME"),
    COLCOM("COLCOMMENT"),
    PRIMARY("PRIMARYKEY");


    private String value;

    TableInfoType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
class Test {
    public static int[] so(int[] arr,int k) {
        int len=arr.length;
        for(int i=k;i>=1;--i) {
            int tmp=arr[len-1];
            for(int j=len-1;j>0;j--) {
                arr[j] = arr[j - 1];
            }
            arr[0]=tmp;

        }
        return arr;
    }

    public static int[] add (int[] arr, int target ){
        int[] rs=new int[2];
        for(int i=0;i<arr.length;i++) {
            rs[0]=i;
            int remain=target-arr[i];
            for(int j=i+1;j<arr.length;j++) {
                if (arr[j]==remain) {
                    rs[1]=j;
                    return rs;
                }
            }
        }
        return rs;
    }

    public  static int[] removeRe(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums) {
            set.add(n);
        }
        int[] rs =new int[set.size()];
        Iterator<Integer> it= set.iterator();
        int c=0;
        for (Iterator<Integer> iter = it; iter.hasNext(); ) {
            Integer i = iter.next();
            rs[c]=i;
            c++;
        }
        return rs;
    }
    public static void main(String[] args) {
       int[] a = {2,5,5,11};
      /*   a=Test.so(a,13);
        for(int n:a) {
            System.out.println(n);
        }*/
       /* int[] b=Test.add(a,10);
        for(int n:b){
            System.out.println(n);
        }*/
        System.out.println(removeRe(a).length);
    }
}
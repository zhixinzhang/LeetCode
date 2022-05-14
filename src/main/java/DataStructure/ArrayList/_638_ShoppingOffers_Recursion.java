package DataStructure.ArrayList;
import java.util.*;

//https://www.youtube.com/watch?v=hVnWYVRpiSY
//http://blog.csdn.net/huanghanqian/article/details/76686222
//给每种商品的价格、多组不同offer（每个offer内最后一个为价格，前面为每种商品在这个offer内的数量）、最终要买的个数
//要求exactly每个商品给定个数，所需要的最少钱
//遍历 + 回溯（递归）
//查看每个offer在当前needs下是否valid，如果valid就按照新的needs进行递归
public class _638_ShoppingOffers_Recursion{
	    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = Integer.MAX_VALUE;  
        for (int i = 0; i < special.size(); i++) {  
            boolean isValid = true;  
            List<Integer> offer = special.get(i);  
            for (int j = 0; j < needs.size(); j++) {  
                int remain = needs.get(j) - offer.get(j);  
                if (remain < 0) {  
                    isValid = false;  
                }  
                needs.set(j, remain);  
            }  
            if (isValid) {  
                res = Math.min(res, shoppingOffers(price, special, needs) + offer.get(needs.size()));  
            }  
            for (int j = 0; j < needs.size(); j++) {  
                needs.set(j, needs.get(j) + offer.get(j));  
            }  
        }  
        int nonOffer = 0;  
        for (int i = 0; i < needs.size(); i++) {  
            nonOffer += needs.get(i) * price.get(i);  
        }  
        return Math.min(nonOffer, res);  
    }
}
/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        //解法6：扩展
        //添加映射
        HashMap<Integer,String> maps = new HashMap<Integer,String>(){
            {
                put(3,"Fizz");
                put(5,"Buzz");
            }
        };

        for(int i=1; i<=n; i++){
            String result = "";

            for(Integer key : maps.keySet()){
                if(i % key == 0){
                    result += maps.get(key);
                }
            }

            if(result.equals("")){
                    result += Integer.toString(i);
            }

             list.add(result);
        }

       


        //解法5，使用二进制
        // for(int i=1,fizz=0,buzz=0; i<=n; i++){
        //     int res = 0;
        //     res = i % 3 == 0 ? 0b1 : 0; 
        //     res+= i % 5 == 0 ? 0b10 : 0;

        //     if (res == 0b1) list.add("Fizz");
        //     else if (res == 0b10) list.add("Buzz");
        //     else if (res == 0b11) list.add("FizzBuzz");
        //     else list.add(String.valueOf(i));
        // }

        //解法4， 不使用取余
        // for(int i=1,fizz=0,buzz=0; i<=n; i++){
        //     fizz++;
        //     buzz++;
        //     if(fizz == 3 && buzz == 5){
        //         list.add("FizzBuzz");
        //         fizz = 0;
        //         buzz = 0;
        //    }else if(fizz == 3){
        //         list.add("Fizz");
        //         fizz = 0;
        //    }else if(buzz == 5){
        //         list.add("Buzz");
        //         buzz = 0;
        //    }else{
        //         list.add(i + "");
        //    }
           
        // }

        //解法3，遍历，但是用参数来代替多次计算
        // for(int i=1 ; i<= n; i++){
        //     boolean divisibleBy3 = i % 3 == 0 ? true : false;
        //     boolean divisibleBy5 = i % 5 == 0 ? true : false;
        //     if(divisibleBy3 && divisibleBy5){
        //             list.add("FizzBuzz");
        //     }else if(divisibleBy3){
        //             list.add("Fizz");
        //     }else if(divisibleBy5){
        //             list.add("Buzz");
        //     }else{
        //         list.add(i + "");
        //     }
            
        // }

        //解法2，用while循环
        // int i = n;
        // while(n > 0){
        //     int temp = i - n + 1;
        //     if(temp % 3 == 0 || temp % 5 == 0){
        //         if(temp % 3 == 0 && temp % 5 == 0){
        //             list.add("FizzBuzz");
        //         }else if(temp % 3 == 0){
        //             list.add("Fizz");
        //         }else{
        //             list.add("Buzz");
        //         }
        //     }else{
        //         list.add(temp + "");
        //     }
        //     n--;
        // }

        //解法1，遍历
        // for(int i=1 ; i<= n; i++){
        //     if(i % 3 == 0 || i % 5 == 0){
        //         if(i % 3 == 0 && i % 5 == 0){
        //             list.add("FizzBuzz");
        //         }else if(i % 3 == 0){
        //             list.add("Fizz");
        //         }else{
        //             list.add("Buzz");
        //         }
        //     }else{
        //         list.add(i+"");
        //     }
        // } 

        return list;
    }
}
// @lc code=end


import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int setHealth = health;
        boolean recentDamege = false;
        boolean damege = false;
        int[] setBandage = bandage;
        int castingTime =  bandage[0];
        int lastKey = 0;
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        //map 저장 -> key : 공격시간, value : 피해량 
        for(int i = 0; i < attacks.length; i++){
            int[] attack = attacks[i];
            
            map.put(attack[0], attack[1]);
            lastKey = attack[0];
        }
        
        //0 ~ lastKey(총 시간) 최대체력 수정 로직
        for(int k = 1; k <= lastKey; k++ ){
            recentDamege = false;   //해당시간에 피해를 입었는지 여부
            
            // 피해를 입었을 경우 -> 최대체력 - 피해량
            for(Integer key : map.keySet()){
                if(k == key){
                    int attack = map.get(key);
                    setHealth -= attack;
                    damege = true;  // 피해를 입은상태 여부
                    recentDamege = true;
                }
            }
            
            //if 피해를 입었고 해당시간에 피해를 안 입었을경우
            if(damege && !recentDamege){
                //if 현재체력이 최대체력 이상 일 경우
                if(health <= setHealth){
                    setBandage[0] = castingTime; //시전시간 초기화
                    
                //else 붕대감기 로직
                }else{
                    // if 초당 회복량으로 전체체력을 넘길 경우
                    if(health <= setHealth + setBandage[1]){
                        setHealth = health;
                        setBandage[0] = castingTime; //시전시간 초기화
                    }else{
                        setHealth += setBandage[1];  //초당 회복
                        setBandage[0] -= 1;  //시전시간 감소
                         
                        // if 시전시간 0 일시
                        if(setBandage[0] == 0){
                            //if 추가 회복량으로 전체체력을 넘길 경우
                            if(health <= setHealth + setBandage[2]){
                                setHealth = health;
                            }else{
                                setHealth += setBandage[2];  // 추가 회복
                            }
                            
                            setBandage[0] = castingTime; //시전시간 초기화
                            
                        }
                        
                    }
                    
                }
                
            //else if 해당시간에 피해를 입을 경우 
            }else if (recentDamege){
                setBandage[0] = castingTime; //시전시간 초기화
            }
            
            // if 현재체력 0 이하 break
            if(setHealth <= 0){
                break;
            }
            
        }
        
        //현재체력 return
        return setHealth <= 0 ? -1 : setHealth;
    }
}
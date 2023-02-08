/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> settu = new HashSet<>();
        settu.add(0);
        settu=check(rooms,settu,0);
        return(settu.size()== rooms.size());
    }
    public HashSet check(List<List<Integer>> room, HashSet<Integer> set, int curr){
        for(int next:room.get(curr)){
            if(!set.contains(next)){
                set.add(next);
                check(room,set,next);
            }
        }
        return set;
    }
}

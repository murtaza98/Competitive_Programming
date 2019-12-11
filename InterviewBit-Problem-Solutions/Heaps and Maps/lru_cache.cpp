/*
Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor. 
Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 

*/

#include <list> 
#include <iterator> 

struct key_value_pair{
    int key;
    int value;
};

unordered_map<int, list<key_value_pair>::iterator> hash_map;
list<key_value_pair> cqueue;
int csize;

LRUCache::LRUCache(int capacity) {
    hash_map.clear();
    cqueue.clear();
    csize = capacity;
}

int LRUCache::get(int key) {
    if(hash_map.find(key) == hash_map.end()){
        // key not found
        return -1;
    }else{
        // key found
        key_value_pair tmp_pair = *hash_map[key];
        // put this in front of queue, since it is recently used
        cqueue.erase(hash_map[key]);
        
        cqueue.push_front(tmp_pair);
        hash_map[key] = cqueue.begin();
        
        return tmp_pair.value;
    }
}

void LRUCache::set(int key, int value) {
    if(hash_map.find(key) == hash_map.end()){
        // key not found
        if(hash_map.size() == csize){
            // cache is full, remove the LRU element, i.e last in queue
            int tmp_key = cqueue.back().key;
            cqueue.pop_back();
            hash_map.erase(tmp_key);
        }
    }else{
        // key present
        cqueue.erase(hash_map[key]);
    }
    // make a new custom pair
    key_value_pair new_pair;
    new_pair.key = key;
    new_pair.value = value;
    
    // push new pair to queue
    cqueue.push_front(new_pair);
    
    // make hash_map
    hash_map[key] = cqueue.begin();
}

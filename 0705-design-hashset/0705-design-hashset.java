class MyHashSet {

    private static final int BUCKET_SIZE=1000;

    private LinkedList<Integer>[] buckets;

    public MyHashSet(){
        buckets =new LinkedList[BUCKET_SIZE];
        for (int i=0;i<BUCKET_SIZE;i++){
            buckets[i]=new LinkedList<>();
        }
    }

    private int hash(int key){
        return key%BUCKET_SIZE;
    }

    public void add(int key){
        int bucketIndex=hash(key);
        LinkedList<Integer> bucket=buckets[bucketIndex];

        if(!bucket.contains(key)){
            bucket.add(key);
        }
    }

    public void remove(int key){
        int bucketIndex=hash(key);
        LinkedList<Integer> bucket=buckets[bucketIndex];
        bucket.remove((Integer) key);
    }
    
    public boolean contains(int key){
        int bucketIndex =hash(key);
        LinkedList<Integer> bucket=buckets[bucketIndex];
        
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
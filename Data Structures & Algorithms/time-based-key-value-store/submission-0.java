class TimeMap {

    private Map<String, List<Pair>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Pair> values = store.getOrDefault(key, new ArrayList<>());

        int l=0, r=values.size()-1;
        while(l<=r){
            int m = l + (r-l)/2;

            if(values.get(m).timestamp <= timestamp){
                res = values.get(m).value;
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return res;
    }
}

class Pair{
    int timestamp;
    String value;

    Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}

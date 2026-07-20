class Solution {
    Map<String, List<String>> adj = new HashMap<>();
    List<String> res = new ArrayList<>();
    int ticketCount =0;

    public List<String> findItinerary(List<List<String>> tickets) {
        ticketCount = tickets.size();

        for(List<String> ticket: tickets){
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
        }

        tickets.sort((a,b)-> {
            if(!a.get(0).equals(b.get(0))){
                return a.get(0).compareTo(b.get(0));
            }
            return a.get(1).compareTo(b.get(1));
        });

        for(List<String> ticket: tickets){
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        res.add("JFK");
        dfs("JFK");
        return res;
    }

    private boolean dfs(String src){

        if(res.size()==ticketCount+1){
            return true;
        }

        if(!adj.containsKey(src)){
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(src));

        for(int i=0; i<temp.size(); i++){
            String next = temp.get(i);

            adj.get(src).remove(i);
            res.add(next);

            if(dfs(next)){
                return true;
            }

            res.remove(res.size()-1);
            adj.get(src).add(i,next);
        }
        return false;
    }
}

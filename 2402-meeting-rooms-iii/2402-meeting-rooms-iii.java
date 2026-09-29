class Solution {
    class Pair implements Comparable<Pair> {
        Long first , second;

        Pair(Long first , Long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return this.first + " " + this.second + " \n";
        }

        @Override
        public int compareTo(Pair that) {
            if(this.first.compareTo(that.first) == 0)
                return this.second.compareTo(that.second);

            return this.first.compareTo(that.first);
        }
    }

    public int mostBooked(int n, int[][] meet) {
        TreeMap<Long , Long> mp = new TreeMap<>();

        for(int i = 0; i < meet.length; ++i)
             mp.put(1L * meet[i][0] , 1L * meet[i][1]);

        TreeSet<Pair> avR = new TreeSet<>();

        for(int i = 0; i < n; ++i)
             avR.add(new Pair( 1L * 0 , 1L * i ));

        TreeSet<Pair> avR1 = new TreeSet<>();

        int [] ans = new int[n];

        while(mp.size() > 0) {
            Iterator<Map.Entry<Long , Long>> it = mp.entrySet().iterator();
            Map.Entry<Long , Long> cMeet = it.next();
            it.remove();

            long start = cMeet.getKey() , end = cMeet.getValue();

            // System.out.println(start + " " + end);

            // for(Pair c : avR) {

            // }

            while(avR.size() > 0) {
                Iterator<Pair> it1 = avR.iterator();
                Pair rm = it1.next();

                if(rm.first > start)
                     break;

                it1.remove();
                avR1.add(new Pair(rm.second , rm.first));
            }

            // System.out.println(avR1 + " : xx");

            if(avR1.size() == 0) {
                Iterator<Pair> it1 = avR.iterator();
                Pair rm = it1.next();
                it1.remove();
                avR1.add(new Pair(rm.second , rm.first));
            }

            Iterator<Pair> it2 = avR1.iterator();
            Pair rm = it2.next();
            it2.remove();

            long rStart = rm.second , rInx = rm.first;

            // System.out.println(rStart + " " + rInx + " : x");

            if(rStart <= start) {
                avR.add(new Pair(end , rInx));
            } else {
                avR.add(new Pair(rStart + (end - start) , rInx));
            }

            int ix = (int)rInx;
            ans[ix]++;
        }

        // for(int i = 0; i < n; ++i)
        //     System.out.print(ans[i] + " ");
        // System.out.println();

        int mx = 0;

        for(int i = 0; i < n; ++i) {
             mx = Math.max(ans[i] , mx);
        }

        int ansInx = n;

        for(int i = n - 1; i >= 0; --i)
            if(mx == ans[i])
                ansInx = i;

        return ansInx;

    }
}
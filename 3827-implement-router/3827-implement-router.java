class Router {
    static class Packet {
        int src;
        int dest;
        int time;

        Packet(int src, int dest, int time) {
            this.src = src;
            this.dest = dest;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Packet)) {
                return false;
            }

            Packet p = (Packet) o;
            return src == p.src && dest == p.dest && time == p.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest, time);
        }
    }

    int size;
    HashMap<Integer, List<Integer>> mpp;
    Set<Packet> allPacks;
    Queue<Packet> packets;

    public Router(int memoryLimit) {
        this.size = memoryLimit;
        allPacks = new HashSet<>();
        mpp = new HashMap<>();
        packets = new LinkedList<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);

        if (allPacks.contains(p)) {
            return false;
        }

        if (packets.size() >= size) {
            forwardPacket();
        }

        packets.add(p);
        allPacks.add(p);

        List<Integer> timeArray = mpp.computeIfAbsent(destination, k -> new ArrayList<>());
        timeArray.add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        int[] info = new int[3];

        if (packets.size() == 0) {
            return new int[0];
        }

        Packet p = packets.poll();
        allPacks.remove(p);
        List<Integer> array = mpp.get(p.dest);
        array.remove(0);


        return new int[] {p.src, p.dest, p.time};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> timeArray = mpp.get(destination);

        if (timeArray != null && !timeArray.isEmpty()) {
            return upperBound(timeArray, endTime) - lowerBound(timeArray, startTime);
        }

        return 0;
    }

    private int lowerBound(List<Integer> time, int start) {
        int ans = time.size();
        int low = 0;
        int high = ans - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (time.get(mid) >= start) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int upperBound(List<Integer> time, int end) {
        int ans = time.size();
        int low = 0;
        int high = ans - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (time.get(mid) > end) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
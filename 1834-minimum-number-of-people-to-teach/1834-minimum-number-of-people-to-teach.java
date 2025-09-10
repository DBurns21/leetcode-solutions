class Solution {
    private boolean canTalk(Set<Integer> langsOne, Set<Integer> langsTwo) {
        if (langsOne.size() > langsTwo.size()) {
            return canTalk(langsTwo, langsOne);
        }

        for (int lang : langsOne) {
            if (langsTwo.contains(lang)) {
                return true;
            }
        }
        
        return false;
    }

    

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int users = languages.length;
        Set<Integer>[] userLangs = new HashSet[users + 1];

        //the only purpose of this section is to change the language array to sets so that we 
        //can be more effecient when doing lookups
        for (int i = 0; i < users; ++i) {
            userLangs[i + 1] = new HashSet<>();
            for (int lang : languages[i]) {
                userLangs[i + 1].add(lang);
            }
        }

        //Here we look for all the friendships where they don't share a language and thus can't talk
        Set<Integer> cantTalk = new HashSet<>();
        for (int[] friendship : friendships) {
            int u = friendship[0];
            int v = friendship[1];

            if (!canTalk(userLangs[u], userLangs[v])) {
                cantTalk.add(u);
                cantTalk.add(v);
            }
        }
        
        //if the set is empty then everyone shares a language so we don't need to teach any
        if (cantTalk.isEmpty()) {
            return 0;
        }

        //find the frequency of each language in the friendships that can't communicate
        int[] langFrequency = new int[n + 1];
        for (int user : cantTalk) {
            for (int lang : userLangs[user]) {
                langFrequency[lang]++;
            }
        }

        //find the language with the highest frequency
        int maxFreq = 0;
        for (int i = 1; i <= n; i++) {
            if (langFrequency[i] > maxFreq) {
                maxFreq = langFrequency[i];
            }
        }

        //so we want to only teach those who don't know the most common language so we take away the 
        //amount of people who do know it from the total amount of friends who can't talk
        return cantTalk.size() - maxFreq;
    }      
}
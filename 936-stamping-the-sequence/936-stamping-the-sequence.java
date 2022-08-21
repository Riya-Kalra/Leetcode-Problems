class Solution {
    public int[] movesToStamp(String stamp, String target) {
       	StringBuilder sb = new StringBuilder();

			for(int i = 0; i < stamp.length();i++)
				sb.append('?');

			String qMarkString = sb.toString();

			int n = stamp.length();

			int targetLen = target.length();

			boolean found = true;

			LinkedList<Integer> list = new LinkedList<>();

			while(true) {
				int index = target.indexOf(stamp);

				if(index == -1)
					break;

				list.addFirst(index);

				target = target.substring(0, index) + qMarkString + target.substring(index + n, targetLen);
			}

			boolean isWildcardFound = true;        
			boolean containsQ = false;   

			while(true) {

				isWildcardFound = true;

				for(int i = 0;i <= target.length() - n ;i++) {
					if(isWildCardFound(target.substring(i, i + n), stamp)) {
						 target = target.substring(0, i) + qMarkString + target.substring(i + n, targetLen);
						list.addFirst(i);
						isWildcardFound = false;
					}
				}

				if(containsQ(target)) {
					containsQ = true;
					break;
				}
				if(isWildcardFound)
					break;
			}

			int[] res = new int[list.size()];

			if(isWildcardFound && !containsQ)
				return new int[]{};

			for(int i = 0;i < res.length;i++)
				res[i] = list.get(i);
			return res;
		}

		public boolean containsQ(String target) {
			for(int i = 0;i < target.length();i++)
				if(target.charAt(i) != '?')
					 return false;               
			return true;
		}

		public boolean isWildCardFound(String qMarkString, String stamp) {
			int qCount = 0;
			for(int i = 0; i < qMarkString.length();i++) {
				if(qMarkString.charAt(i) != '?' && qMarkString.charAt(i) != stamp.charAt(i))
					return false;
				if(qMarkString.charAt(i) == '?')
					qCount++;
			}
			return qCount != qMarkString.length();
		} 
}
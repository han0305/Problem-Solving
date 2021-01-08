/* Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector. */

class SparseVector {
    HashMap<Integer,Integer> hm;
    SparseVector(int[] nums) {
        hm = new HashMap();
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) 
                hm.put(i,nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProd = 0;
        for(Map.Entry<Integer,Integer> ele : hm.entrySet()) {
            int index = ele.getKey();
            if(vec.hm.containsKey(index)) {
                dotProd+=hm.get(index)*vec.hm.get(index);
            }
            
        }
        return dotProd;
    }
}

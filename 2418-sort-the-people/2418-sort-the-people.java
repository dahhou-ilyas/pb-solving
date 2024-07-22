class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int size=names.length;
        String[] result=new String[size];
        Map<Integer,String> dict=new HashMap<>();
        for(int i=0;i<size;i++){
            dict.put(heights[i],names[i]);
        }
        bubbleSort(heights,size);
        for(int i=0;i<size;i++){
            result[i]=dict.get(heights[i]);
        }
        return result;

    }
    private void bubbleSort(int arr[], int n){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
}
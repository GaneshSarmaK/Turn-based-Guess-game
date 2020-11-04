public class k_thLargest {

    public int data[] = new int[1000];
    
    public void sort(String integerInput, int k)
    {
        if (k <= 0)
            System.exit(1);
        int data[] = input(integerInput);

        data = doSelectionSort(data);

        int sizeOfArray = data.length;
        
        if(k > sizeOfArray)
            System.exit(1);
        else
            System.out.println(data[k]);
        
        


    }

    public int[] doSelectionSort(int[] arr) 
    {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] > arr[index])
                    index = j;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        int arrayDuplicateRemoved[] =  new int[arr.length];
        arrayDuplicateRemoved[0] = arr[0];
        int k = 0, i = 0;
        for( i = 0; i < arr.length-1; i++)
        {
            if(arr[i] == arr[i+1])
                ;
            else
                arrayDuplicateRemoved[k++] = arr[i];
        }
        arrayDuplicateRemoved[k] = arr [i];
        return arr;
    }

    public int[] input(String argument)
    {
        int data[] = new int[100];
        String[] parts = argument.split(",");
        int sum = 0;
        int i = 0;
        for (String s : parts) {
            if (!s.trim().isEmpty()) {
                int partInt = Integer.parseInt(s.trim());
                data[i++] = partInt;
            }
        }

        return data;
    }
}
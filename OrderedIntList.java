//package cse360assign3;

public class OrderedIntList {

    private int[] array;
    private int counter;

    OrderedIntList () {
        array = new int[10];
        counter = 0;
    }

    public void insert (int inputinteger) {

        if (counter == 0) {
            array[0] = inputinteger;
            counter++;
        }
        else {
            int properindex = 0;
            boolean duplicate = false;

            while (properindex < counter && inputinteger >= array[properindex]
                    && !duplicate) {
                if (inputinteger == array[properindex]) {
                    duplicate = true;
                }
                properindex++;
            }

            if (properindex <= 9 && !duplicate) {
                if (counter < 10) {
                    for (int currentindex = counter; currentindex > properindex;
                         currentindex--) {
                        int previousindex = currentindex - 1;

                        array[currentindex] = array[previousindex];

                    }
                    array[properindex]= inputinteger;
                    counter++;
                }
                else {
                    for (int currentindex = counter - 1; currentindex >
                            properindex; currentindex--) {
                        int previousindex = currentindex - 1;

                        array[currentindex] = array[previousindex];
                    }
                    array[properindex]= inputinteger;
                }
            }
        }
    }

    public void print () {

        for (int currentindex = 0; currentindex < counter; currentindex++) {
            if (currentindex % 5 == 0 && currentindex > 0) {
                System.out.println();
            }

            System.out.print(array[currentindex] + "\t");
        }
        System.out.println();
    }

}

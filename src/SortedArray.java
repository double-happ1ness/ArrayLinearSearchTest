// this is a cut down version of the class specifically for the Linear Search test
// the complete version is in the Library folder on Moodle

public class SortedArray implements SortedADT {

    private Comparable[] objects;
    private Integer objectCount;

    public SortedArray(Integer arraySize) {
        this.objects = new Comparable[arraySize];
        this.objectCount = 0;
    }

    public String toString() {
        String arrayDetails = new String();
        if (this.objectCount != 0) {
            for (Integer index = 0; index < this.objectCount; index++) {
                arrayDetails += objects[index] + "\n";
            }
        } else {
            arrayDetails += "array is empty";
        }
        return arrayDetails;
    }

    public void insert(Comparable object) {
        // cut down version, for this test objects are added in order
        this.objects[this.objectCount] = object;
        this.objectCount++;
    }

    public Comparable find(Comparable object) throws NotFoundException {
        /* algorithm
            if array empty then
                throw not found exception
            end if
            set current position to start of array
            while object not found loop
                if object matches object at the current position then
                    object found
                else
                    if object is less than object at current position then
                        throw not found exception
                    end if
                    move to next position in the array
                    if no more objects to check then
                        throw not found exception
                    end if
                end if
            end loop
         */
        if (this.objectCount == 0) {
            throw new NotFoundException();
        }
        Comparable foundObject = null;
        Integer currentPosition = 0;
        Boolean objectFound = false;
        while (!objectFound) {
            if (object.compareTo(this.objects[currentPosition]) == 0) {
                objectFound = true;
            } else {
                if (object.compareTo(this.objects[currentPosition]) < 0) {
                    throw new NotFoundException();
                }
                currentPosition++;
                if (currentPosition == this.objectCount) {
                    throw new NotFoundException();
                }
            }
        }
        return foundObject;
    }

}

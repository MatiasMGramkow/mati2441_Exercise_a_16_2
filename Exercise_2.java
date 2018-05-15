import java.util.NoSuchElementException;
import java.util.Scanner;

class maxList
    /* Write a method called max that returns the maximum value in a list of integers. If the list is empty, it should throw a
NoSuchElementException.
*/
{
    public class List
    {


        public int data;
        public List next;

        public List()
        {
            this(0, null);
        }

        public List(int data)
        {
            this(data, null);
        }

        public List(int data, List next)
        {
            this.data = data;
            this.next = next;
        }
    }


    private List front;

    public maxList()
    {
        front = null;
    }

    public void add(int value)
    {
        if (front == null)
        {
            front = new List(value);
        } else
        {
            List current = front;

            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new List(value);
        }
    }

    public String toString()
    {
        if (front == null)
        {
            return "[]";
        } else
        {
            String result = "[" + front.data;
            List current = front.next;

            while (current != null)
            {
                result = result + ", " + current.data;
                current = current.next;
            }
            result = result + "] ";
            return result;
        }
    }

    public int max()
    {
        if (front == null)
        {
            throw new NoSuchElementException();
        } else
        {
            int maxValue = front.data;
            List current = front.next;

            while (current != null)
            {
                maxValue = Math.max(maxValue, current.data);
                current = current.next;
            }
            return maxValue;
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        maxList lil4 = new maxList();

        System.out.println("Enter a number please niggah");

        int val = scanner.nextInt();

        while (val != -1)
        {
            lil4.add(val);
            System.out.println("Enter a numper please");

            val = scanner.nextInt();
            if (val == -1)
                break;
        }

        System.out.println();
        System.out.println("The element in the list are: ");
        String string = lil4.toString();
        System.out.println(string);

        int max = lil4.max();
        System.out.println();
        System.out.println("Max value = " + max);
    }
}
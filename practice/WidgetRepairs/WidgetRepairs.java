/*
Returns: 0
2)

10
Returns: 20
3)

9
Returns: 4
4)

3
Returns: 15

*/
class WidgetRepairs {

    public int days(int[] arrivals, int numPerDay) {
        int amountDays = 0;
        int queue = 0;

        int day = 0;

        while (day < arrivals.length) {
            queue += arrivals[day];

            while (day < amountDays && day < arrivals.length - 1) {
                queue += arrivals[++day];
            }

            if (queue > 0 && queue <= numPerDay) {
                queue = 0;
                amountDays++;
            } else {
                amountDays += (queue/numPerDay);
                queue = queue % numPerDay;
            }
            day++;
        }

        if (queue > 0)
            amountDays++;

        return amountDays;
    }

    public static void main(String[] args) {
        WidgetRepairs wr = new WidgetRepairs();

        System.out.println(wr.days(new int[] {10,0,0,4,20}, 8));
        System.out.println(wr.days(new int[] {0,0,0}, 10));
        System.out.println(wr.days(new int[] { 100, 100 }, 10));
        System.out.println(wr.days(new int[] { 27, 0, 0, 0, 0, 9 }, 9));
        System.out.println(wr.days(new int[] { 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 }, 3));

    }
}

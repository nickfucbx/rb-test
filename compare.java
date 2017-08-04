import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class compare
{


    public static void main(final String[] args)
    {
        final List<DynamicEntity> list = new ArrayList<DynamicEntity>();
        list.add(new DynamicEntity(1, 1, 2, 3));
        list.add(new DynamicEntity(2, 1, 1, 3));
        list.add(new DynamicEntity(3, 1, 2, 2));
        list.add(new DynamicEntity(4, 2, 2, 3));
        list.add(new DynamicEntity(5, 2, 1, 3));
        list.add(new DynamicEntity(6, 2, 2, 1));

        final String[] fieldId = new String[3];
        final String[] sortingType = new String[3];
        fieldId[0] = "level";
        sortingType[0] = "asc";

        fieldId[1] = "salary";
        sortingType[1] = "asc";

        fieldId[2] = "years";
        sortingType[2] = "desc";

        Collections.sort(list, new Comparator<DynamicEntity>() {

            @Override
            public int compare(final DynamicEntity entity1, final DynamicEntity entity2) {
//                for (int i = 0; i < fieldId.length; i++) {
//                    final String entity1Data = entity1.getString(fieldId[i]);
//                    final String entity2Data = entity2.getString(fieldId[i]);
//                    if (entity1Data != null && entity2Data != null) {

                        int cr = 0;
                        int a = 0;
                        if(fieldId[0] != null) {
                            a = entity1.getString(fieldId[0]).compareTo(entity2.getString(fieldId[0]));
                        }
                        if(a != 0) {
                            if ("asc" == sortingType[0]) {
                                cr = (a>0)?3:-1;
                            } else {
                                cr = (a<0)?3:-1;
                            }
                        } else{
                            if(fieldId[1] != null) {
                                a = entity1.getString(fieldId[1]).compareTo(entity2.getString(fieldId[1]));
                            }
                            if(a != 0)  {
                                if ("asc" == sortingType[1]) {
                                    cr = (a>0)?2:-2;
                                } else {
                                    cr = (a<0)?2:-2;
                                }
                            } else{
                                if(fieldId[2] != null) {
                                    a = entity1.getString(fieldId[2]).compareTo(entity2.getString(fieldId[2]));
                                }
                                if(a != 0) {
                                    if ("asc" == sortingType[2]) {
                                        cr = (a>0)?1:-3;
                                    } else {
                                        cr = (a<0)?1:-3;
                                    }
                                }
                            }
                        }
                        return cr;


//                        if ("asc" == sortingType[i]) {
//                            if (compareASC(entity1Data, entity2Data) > 0) {
//                                return 1;
//                            }
//                            if (compareASC(entity1Data, entity2Data) < 0) {
//                                return -1;
//                            }
//                        } else if ("desc" == sortingType[i]) {
//                            if (compareDESC(entity1Data, entity2Data) > 0) {
//                                return 1;
//                            }
//                            if (compareDESC(entity1Data, entity2Data) < 0) {
//                                return -1;
//                            }
//                        }
//                    }
//                }
//                return 0;
            }
        });

        for (final DynamicEntity e : list) {
            System.out.println(e);
        }
    }

    public static int compareASC(final String o1, final String o2) {
        return o1.compareTo(o2) > 0 ? 1 : -1;
    }

    public static int compareDESC(final String o1, final String o2) {
        return o1.compareTo(o2) < 0 ? 1 : -1;
    }
}


class DynamicEntity
{
    int id;
    int level;
    int salary;
    int years;

    public DynamicEntity(final int id, final int level, final int salary, final int years)
    {
        this.id = id;
        this.level = level;
        this.salary = salary;
        this.years = years;
    }

    @Override
    public String toString()
    {
        return id + "  " + level + "   " + salary + "   " + years;
    }

    String getString(final String fieldId)
    {
        String value = null;
        if (fieldId == "id") {
            value = String.valueOf(this.id);
        }
        if (fieldId == "level") {
            value = String.valueOf(this.level);
        }
        if (fieldId == "salary") {
            value = String.valueOf(this.salary);
        }
        if (fieldId == "years") {
            value = String.valueOf(this.years);
        }
        return value;
    }
}
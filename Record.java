public class Record
{
    private String key;

    public Record(String k)
    {
        this.key = k;
    }
    
    public Object getKey()
    {
        return this.key;
    }
    
    public boolean equals(Object newObj)
    {
        if (newObj == this)
        {
            return true;
        }
        if ((newObj == null) || (newObj.getClass() != this.getClass()))
        {
            return false;
        }
        return (this.getKey().equals(((Record)newObj).getKey()));
    }



}

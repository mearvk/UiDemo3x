package system;

import java.util.HashMap;

public class Memory
{
    public static Memory ref;

    public HashMap<String, Object> map = new HashMap();

    public Memory()
    {
        Memory.ref = this;

        Memory.ref.push("//memory", this);
    }

    public void push(String name, Object object)
    {
        this.map.put(name, object);
    }

    public Object pull(String name)
    {
        return this.map.get(name);
    }
}

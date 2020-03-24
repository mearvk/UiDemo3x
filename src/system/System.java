package system;

public class System
{
    public Memory memory = new Memory();

    public System(String name)
    {
        Memory.ref.push(name, this);
    }
}

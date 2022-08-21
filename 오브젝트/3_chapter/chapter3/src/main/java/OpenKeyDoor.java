public class OpenKeyDoor implements OpenDoor {

    private Door door;
    private Tool tool;
    private Key key;

    public OpenKeyDoor(Door door, Tool tool, Key key) {
        this.door = door;
        this.tool = tool;
        this.key = key;
    }

    @Override
    public void OpenDoor() {
        if(!door.isOpen()){
            key.use(door);
        }
        if(!door.isOpen()){
            tool.use(door);
        }
    }

}

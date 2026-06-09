import java.util.ArrayList;
import java.util.List;

/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 23:57
 */
//文件接口
interface FileSystemComponent {
    void displayInfo();
}

//叶子节点
class File implements FileSystemComponent {
    private String name;
    public File(String name) {
        this.name = name;
    }

    @Override
    public void displayInfo() {
        System.out.println(name);
    }
}

//容器节点
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<FileSystemComponent>();
    }
    public void AddFile(FileSystemComponent file){
        components.add(file);
    }
    public void displayInfo(){
        for(FileSystemComponent component : components){
            component.displayInfo();
        }
    }

}

public class CompositeMethod {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory directory1 = new Directory("directory1");
        directory1.AddFile(file1);
        directory1.AddFile(file2);
        directory1.displayInfo();
    }
}

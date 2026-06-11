/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/11 11:13
 */
//图片接口
interface Image{
    void display();
}

class ReamImage implements Image{
    private String filename;

    public ReamImage(String filename){
        this.filename = filename;
        loadImage();

    }
    public void loadImage(){
        System.out.println("Loading image " + filename);
    }
    public void display(){
        System.out.println("Displaying image " + filename);
    }
}

// 代理
class ProxyImage implements Image{
    private String filename;
    private ReamImage reamImage;
    public ProxyImage(String filename){
        this.filename = filename;
    }
    public void display(){
        if(reamImage == null){
            reamImage = new ReamImage(filename);
        }
        reamImage.display();
    }
}


public class ProxyMethod {
    public static void main(String[] args) {
        String filename = "text.jpg";
        ProxyImage image = new ProxyImage(filename);
        //第一次加载，在此之前图片还没加载
        image.display();
        //图片已加载
        image.display();

    }
}

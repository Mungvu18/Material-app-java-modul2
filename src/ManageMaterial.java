import org.omg.CORBA.Object;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageMaterial {
    List <Material> materialList = new ArrayList<>();
    public static final String FILE_NAME = "material.obj";
    public void addNew(Material material){
        materialList.add(material);
    }
    public void showALl(){
        for (Material m: materialList) {
            System.out.println(m);
        }
    }

    public void remove(int index){
        for (int i = 0; i < materialList.size(); i++) {
            if(index==i){
                materialList.remove(index);
            }
        }
    }
    public void edit(int index, Material material){
        for (int i = 0; i < materialList.size(); i++) {
            if(index == i){
                materialList.set(index,material);
            }
        }
    }
    public void sortByCost(){
        Collections.sort(materialList,((o1, o2) -> {
            if(o1.getAmount()> o2.getAmount()) return 1;
            if(o1.getAmount()< o2.getAmount()) return -1;
            else return 0;
        }));
        showALl();
    }
    public void findByName(String name){
        boolean testName = false;
        for (Material m : materialList) {
            testName = m.getName().equalsIgnoreCase(name);
            if(testName){
                System.out.println(m);
                break;
            }
        }
        if(!testName) System.out.println("Không tồn tại đối tượng");
    }
    public void writeFile(){
        try{
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(materialList);
            oos.close();
            fos.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void readFile(){
        try{
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream oos = new ObjectInputStream(fis);
            materialList = (List<Material>) oos.readObject();
        }catch (Exception e){
            System.out.println(e);
        }
        showALl();
    }
}

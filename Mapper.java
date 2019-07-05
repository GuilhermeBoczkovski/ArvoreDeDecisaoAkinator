package akinator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import akinator.NodeControl;
import java.util.ArrayList;

public final class Mapper {
    
    private ArrayList<NodeControl> cacheTree = new ArrayList<>();
    private final String filename = "tree.tree";

    public Mapper() {
        this.load();
        this.persist();
    }

    public NodeControl get(String id) {
        int i = 0;
        for (NodeControl tree : cacheTree) {
            if (tree.getId().equals(id)) {
                break;
            } else {
                i++;
            }
        }
        return cacheTree.get(i);
    }

    public NodeControl get(int i) {
        return cacheTree.get(i);
    }

    public void put(NodeControl tree) {
        cacheTree.add(tree);
        persist();
    }

    public void exclude(int i) {
        cacheTree.remove(i);
        persist();
    }

    public void persist() {
        try {
            FileOutputStream fOut = new FileOutputStream(filename);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(cacheTree);

            oOut.flush();
            fOut.flush();

            oOut.close();
            fOut.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void load() {
        try {
            FileInputStream fIn = new FileInputStream(filename);
            ObjectInputStream oIn = new ObjectInputStream(fIn);

            this.cacheTree = (ArrayList) oIn.readObject();

            oIn.close();
            fIn.close();

        } catch (FileNotFoundException ex) {
            System.out.println("ERRO AO ENCONTRAR O ARQUIVO");
            this.persist();
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO AO ENCONTRAR O ARQUIVO");
        } catch (IOException ex) {
            System.out.println("ERRO AO ENCONTRAR O ARQUIVO");
        }
    }

    public ArrayList<NodeControl> getList() {
        return this.cacheTree;
    }
    
}

package labb5;


import org.jdom2.Element;
import org.w3c.dom.Document;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.List;

public class LifeTree extends TreeFrame {

    static String directory=".";

    static XMLParser parser = new XMLParser();

    public LifeTree(){
        super();
        //this.parser= new XMLParser();

    }

    public LifeTree(String arg){
        super();
        //this.parser= new XMLParser(arg);

    }


    // ***** create root, treeModel and tree in the new initTree
    public void initTree(){
        root=new DefaultMutableTreeNode(parser.doc.getRootElement().getName());
        treeModel= new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        buildTree();

    }

    private void buildTree() {
        org.jdom2.Element parent=parser.doc.getRootElement();
        List<Element> list = parent.getChildren();
        for (int i=0; i<list.size(); i++ )
            buildTree(list.get(i), root);
    }

    // New method
    private void buildTree( Element e, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode child =
                new DefaultMutableTreeNode( e ); // FIXA DENNA DEL
        parent.add(child);
        if ( e.getContentSize() != 0 ) {
            List<Element> list = e.getChildren();
            for ( int i = 0; i < list.size(); i++ )
                buildTree( list.get(i), child);
        }
    }

    void showDetails(TreePath path){
        if (path == null)
            return;
        String elementName = path.getLastPathComponent().toString();
        String info =elementName;
        JOptionPane.showMessageDialog(this, info);
    }









    public static void main(String[] args){
        LifeTree lifeTree = new LifeTree();


    }
}

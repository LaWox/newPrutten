package labb5;

import org.jdom2.Element;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LifeTree extends TreeFrame {

    static String directory;

    private static Map<String, Element> nodeMap = new HashMap<>();
    static XMLParser parser;

    public LifeTree(){
        super();
    }

    private static XMLParser createParser(){
        System.err.println("inne: " + directory);
        if(directory == null){
            System.err.println("ingen input");
            return new XMLParser();
        }
        else{
            System.err.println("input given");
            return new XMLParser(directory);
        }
    }

    // ***** create root, treeModel and tree in the new initTree
    public void initTree(){
        parser = createParser();

        System.err.println(parser.toString());
        Element rootElement = parser.doc.getRootElement();
        root = new DefaultMutableTreeNode(rootElement.getAttributes().get(0).getValue());

        nodeMap.put(rootElement.getAttributes().get(0).getValue(), rootElement);

        treeModel= new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        buildTree();
    }

    private void buildTree() {
        Element parent=parser.doc.getRootElement();
        nodeMap.put(parent.getAttributes().get(0).getValue(), parent);

        List<Element> list = parent.getChildren();
        for (int i=0; i<list.size(); i++ )
            buildTree(list.get(i), root);
    }

    // New method
    private void buildTree( Element e, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode child = new DefaultMutableTreeNode( e.getAttributes().get(0).getValue() ); // FIXA DENNA DEL
        parent.add(child);

        nodeMap.put(e.getAttributes().get(0).getValue(), e);

        if ( e.getContentSize() != 0 ) {
            List<Element> list = e.getChildren();
            for ( int i = 0; i < list.size(); i++ )
                buildTree( list.get(i), child);
        }
    }

    void showDetails(TreePath path){
        if (path == null)
            return;
        String name = path.getLastPathComponent().toString();
        Element node = nodeMap.get(name);
        JOptionPane.showMessageDialog(this, getInfo(node));
    }

    private String getInfo(Element e){
        String tagName = e.getName().toString();
        String attrName = e.getAttributes().get(0).getValue();
        String info = e.getContent().get(0).getValue();
        return tagName + ":" + " " + attrName + " " + info;
    }

    public static void main(String[] args){
        System.err.println(args[0]);
        if(args.length > 0){
            directory = args[0];
        }
        //System.err.println(directory);
        LifeTree lifeTree = new LifeTree();
    }
}

package labb5;

import org.jdom2.Element;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LifeTree extends TreeFrame {

    static String directory;

    private static Map<String, Element> nodeMap = new HashMap<>();
    static XMLParser parser;

    public LifeTree(){
        super();
    }

    private static XMLParser createParser(){
        if(directory == null){
            return new XMLParser();
        }
        else{
            return new XMLParser(directory);
        }
    }

    // ***** create root, treeModel and tree in the new initTree
    public void initTree(){
        parser = createParser();

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

        StringBuilder builder = new StringBuilder();
        String name = path.getLastPathComponent().toString();
        Element node = nodeMap.get(name);
        builder.append(getInfo(node));
        builder.append("\n"+"Men allt som ");

        while(path != null){
            name = path.getLastPathComponent().toString();
            node = nodeMap.get(name);
            builder.append(" är "+ node.getAttributes().get(0).getValue());
            path=path.getParentPath();
        }
        JOptionPane.showMessageDialog(this, builder);
    }

    private String getInfo(Element e){
        String tagName = e.getName().toString();
        String attrName = e.getAttributes().get(0).getValue();
        String info = e.getContent().get(0).getValue();
        return tagName + ":" + " " + attrName + " " + info;
    }

    public static void main(String[] args){
        if(args.length > 0){
            directory = args[0];
        }
        LifeTree lifeTree = new LifeTree();
    }
}

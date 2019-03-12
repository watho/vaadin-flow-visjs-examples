package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.options.physics.BarnesHut;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
   nodes = [
        {id: 1,  label: 'circle',  shape: 'circle' },
        {id: 2,  label: 'ellipse', shape: 'ellipse'},
        {id: 3,  label: 'database',shape: 'database'},
        {id: 4,  label: 'box',     shape: 'box'    },
        {id: 5,  label: 'diamond', shape: 'diamond'},
        {id: 6,  label: 'dot',     shape: 'dot'},
        {id: 7,  label: 'square',  shape: 'square'},
        {id: 8,  label: 'triangle',shape: 'triangle'},
        {id: 9,  label: 'triangleDown', shape: 'triangleDown'},
        {id: 10, label: 'text',    shape: 'text'},
        {id: 11, label: 'star',    shape: 'star'},
        {id: 21, font:{size:30},          label: 'big circle',  shape: 'circle' },
        {id: 22, font:{size:30},          label: 'big ellipse', shape: 'ellipse'},
        {id: 23, font:{size:30},          label: 'ellipse with a long label text', shape: 'ellipse'},
        {id: 24, font:{size:30},          label: 'big database',shape: 'database'},
        {id: 25, font:{size:30},          label: 'big box',     shape: 'box'    },
        {id: 26, font:{size:30}, size:40, label: 'big diamond', shape: 'diamond'},
        {id: 27, font:{size:30}, size:40, label: 'big dot',     shape: 'dot'},
        {id: 28, font:{size:30}, size:40, label: 'big square',  shape: 'square'},
        {id: 29, font:{size:30}, size:40, label: 'big triangle',shape: 'triangle'},
        {id: 30, font:{size:30}, size:40, label: 'big triangleDown', shape: 'triangleDown'},
        {id: 31, font:{size:30},          label: 'big text',    shape: 'text'},
        {id: 32, font:{size:30}, size:40, label: 'big star',    shape: 'star'}
      ];

      edges = [
      ];

      // create a network
      var container = document.getElementById('mynetwork');
      var data = {
        nodes: nodes,
        edges: edges
      };
      var options = {physics:{barnesHut:{gravitationalConstant:-4000}}};
      network = new vis.Network(container, data, options);
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class NodeStylesShapesExample extends AbstractExample {

  private final NetworkDiagram nd;

  public NodeStylesShapesExample() {
    // Set Nodes
    final Node node1 = new Node("1", "circle", Nodes.builder().withShape(Shape.circle));
    final Node node2 = new Node("2", "ellipse", Nodes.builder().withShape(Shape.ellipse));
    final Node node3 = new Node("3", "database", Nodes.builder().withShape(Shape.database));
    final Node node4 = new Node("4", "box", Nodes.builder().withShape(Shape.box));
    final Node node5 = new Node("5", "diamond", Nodes.builder().withShape(Shape.diamond));
    final Node node6 = new Node("6", "dot", Nodes.builder().withShape(Shape.dot));
    final Node node7 = new Node("7", "square", Nodes.builder().withShape(Shape.square));
    final Node node8 = new Node("8", "triangle", Nodes.builder().withShape(Shape.triangle));
    final Node node9 = new Node("9", "triangleDown", Nodes.builder().withShape(Shape.triangleDown));
    final Node node10 = new Node("10", "text", Nodes.builder().withShape(Shape.text));
    final Node node11 = new Node("11", "star", Nodes.builder().withShape(Shape.star));
    final Node node21 = new Node("21", "big circle",
        Nodes.builder().withShape(Shape.circle).withFont(Font.builder().withSize(30).build()));
    final Node node22 = new Node("22", "big ellipse",
        Nodes.builder().withShape(Shape.ellipse).withFont(Font.builder().withSize(30).build()));
    final Node node23 = new Node("23", "ellipse with a long label text",
        Nodes.builder().withShape(Shape.ellipse).withFont(Font.builder().withSize(30).build()));
    final Node node24 = new Node("24", "big database",
        Nodes.builder().withShape(Shape.database).withFont(Font.builder().withSize(30).build()));
    final Node node25 = new Node("25", "big box",
        Nodes.builder().withShape(Shape.box).withFont(Font.builder().withSize(30).build()));
    final Node node26 = new Node("26", "big diamond", Nodes.builder().withSize(40)
        .withShape(Shape.diamond).withFont(Font.builder().withSize(30).build()));
    final Node node27 = new Node("27", "big dot", Nodes.builder().withSize(40).withShape(Shape.dot)
        .withFont(Font.builder().withSize(30).build()));
    final Node node28 = new Node("28", "big square", Nodes.builder().withSize(40)
        .withShape(Shape.square).withFont(Font.builder().withSize(30).build()));
    final Node node29 = new Node("29", "big triangle", Nodes.builder().withSize(40)
        .withShape(Shape.triangle).withFont(Font.builder().withSize(30).build()));
    final Node node30 = new Node("30", "big triangleDown", Nodes.builder().withSize(40)
        .withShape(Shape.triangleDown).withFont(Font.builder().withSize(30).build()));
    final Node node31 = new Node("31", "big text",
        Nodes.builder().withShape(Shape.text).withFont(Font.builder().withSize(30).build()));
    final Node node32 = new Node("32", "big star", Nodes.builder().withSize(40)
        .withShape(Shape.star).withFont(Font.builder().withSize(30).build()));

    nd = new NetworkDiagram(Options.builder() //
        .withPhysics(Physics.builder()
            .withBarnesHut(BarnesHut.builder().withGravitationalConstant(-4000).build()).build())
        .build());
    nd.diagramSetSize("800px", "800px");
    nd.setNodes(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11,
        node21, node22, node23, node24, node25, node26, node27, node28, node29, node30, node31,
        node32);
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}

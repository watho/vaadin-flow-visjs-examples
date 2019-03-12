package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes.Builder;
import de.wathoserver.vaadin.visjs.network.options.physics.BarnesHut;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;
import de.wathoserver.vaadin.visjs.network.util.ShapeProperties;

/**
 * <pre>
<script type="text/javascript">
  nodes = [
        {id: 1, font:{size:30},          label: 'circle',  shape: 'circle' , shapeProperties:{borderDashes:[5,5]}},
        {id: 2, font:{size:30},          label: 'ellipse', shape: 'ellipse', shapeProperties:{borderDashes:[5,5]}},
        {id: 3, font:{size:30},          label: 'database',shape: 'database', shapeProperties:{borderDashes:[5,5]}},
        {id: 4, font:{size:30},          label: 'box',     shape: 'box'    , shapeProperties:{borderDashes:[5,5]}},
        {id: 5, font:{size:30}, size:40, label: 'diamond', shape: 'diamond', shapeProperties:{borderDashes:[5,5]}},
        {id: 6, font:{size:30}, size:40, label: 'dot',     shape: 'dot', shapeProperties:{borderDashes:[5,5]}},
        {id: 7, font:{size:30}, size:40, label: 'square',  shape: 'square', shapeProperties:{borderDashes:[5,5]}},
        {id: 8, font:{size:30}, size:40, label: 'triangle',shape: 'triangle', shapeProperties:{borderDashes:[5,5]}},
        {id: 9, font:{size:30}, size:40, label: 'triangleDown', shape: 'triangleDown', shapeProperties:{borderDashes:[5,5]}},
        {id: 10, font:{size:30}, size:40, label: 'star',    shape: 'star', shapeProperties:{borderDashes:true}},
        {id: 11, font:{size:30}, size:40, label: 'circularImage', shape: 'circularImage', image: '../img/indonesia/4.png', shapeProperties: {borderDashes:[15,5]}},
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
public class NodeStylesShapesWithDashedBordersExample extends AbstractExample {

  private final NetworkDiagram nd;
  private static final String IMAGEPATH = "frontend/img/indonesia/";

  public NodeStylesShapesWithDashedBordersExample() {
    // Set Nodes
    final Builder nodeBuilder = Nodes.builder()
        .withShapeProperties(
            ShapeProperties.builder().withBorderDashes(new Integer[] {5, 5}).build())
        .withFont(Font.builder().withSize(30).build());

    final Node node1 = new Node("1", "circle", nodeBuilder.withShape(Shape.circle));
    final Node node2 = new Node("2", "ellipse", nodeBuilder.withShape(Shape.ellipse));
    final Node node3 = new Node("3", "database", nodeBuilder.withShape(Shape.database));
    final Node node4 = new Node("4", "box", nodeBuilder.withShape(Shape.box));
    final Node node5 = new Node("5", "diamond", nodeBuilder.withShape(Shape.diamond).withSize(40));
    final Node node6 = new Node("6", "dot", nodeBuilder.withShape(Shape.dot).withSize(40));
    final Node node7 = new Node("7", "square", nodeBuilder.withShape(Shape.square).withSize(40));
    final Node node8 =
        new Node("8", "triangle", nodeBuilder.withShape(Shape.triangle).withSize(40));
    final Node node9 =
        new Node("9", "triangleDown", nodeBuilder.withShape(Shape.triangleDown).withSize(40));
    final Node node10 = new Node("10", "star", Nodes.builder().withShape(Shape.star).withSize(40)
        .withShapeProperties(ShapeProperties.builder().withBorderDashes(true).build()));
    final Node node11 = new Node("11", "circularImage",
        Nodes.builder().withShape(Shape.circularImage).withSize(40).withImage(IMAGEPATH + "4.png")
            .withShapeProperties(
                ShapeProperties.builder().withBorderDashes(new Integer[] {15, 5}).build()));

    nd = new NetworkDiagram(Options.builder() //
        .withPhysics(Physics.builder()
            .withBarnesHut(BarnesHut.builder().withGravitationalConstant(-4000).build()).build())
        .build());
    nd.diagramSetSize("800px", "800px");
    nd.setNodes(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11);
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}

package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.NodeColor;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;
import de.wathoserver.vaadin.visjs.network.util.ShapeProperties;

/**
 * <pre>
<script type="text/javascript">
      // create people.
      // value corresponds with the age of the person
      var DIR = '../img/indonesia/';
      nodes = [
        {id: 1,  shape: 'image', image: DIR + '1.png'},
        {id: 2,  shape: 'image', image: DIR + '2.png'},
        {id: 3,  shape: 'image', image: DIR + '3.png'},
        {id: 4,  shape: 'image', image: DIR + '4.png', label:"pictures by this guy!"},
        {id: 5,  shape: 'image', image: DIR + '5.png'},
        {id: 6,  shape: 'image', image: DIR + '6.png'},
        {id: 7,  shape: 'image', image: DIR + '7.png'},
        {id: 8,  shape: 'image', image: DIR + '8.png'},
        {id: 9,  shape: 'image', image: DIR + '9.png'},
        {id: 10, shape: 'image', image: DIR + '10.png'},
        {id: 11, shape: 'image', image: DIR + '11.png'},
        {id: 12, shape: 'image', image: DIR + '12.png'},
        {id: 13, shape: 'image', image: DIR + '13.png'},
        {id: 14, shape: 'image', image: DIR + '14.png'},
        {id: 15, shape: 'image', image: DIR + 'missing.png', brokenImage: DIR + 'missingBrokenImage.png', label:"when images\nfail\nto load"},
        {id: 16, shape: 'image', image: DIR + 'anotherMissing.png', brokenImage: DIR + '9.png', label:"fallback image in action"}
      ];

      // create connections between people
      // value corresponds with the amount of contact between two people
      edges = [
        {from: 1, to: 2},
        {from: 2, to: 3},
        {from: 2, to: 4},
        {from: 4, to: 5},
        {from: 4, to: 10},
        {from: 4, to: 6},
        {from: 6, to: 7},
        {from: 7, to: 8},
        {from: 8, to: 9},
        {from: 8, to: 10},
        {from: 10, to: 11},
        {from: 11, to: 12},
        {from: 12, to: 13},
        {from: 13, to: 14},
        {from: 9, to: 16}
      ];

      // create a network
      var container = document.getElementById('mynetwork');
      var data = {
        nodes: nodes,
        edges: edges
      };
      var options = {
        nodes: {
          borderWidth:4,
          size:30,
          color: {
            border: '#406897',
            background: '#6AAFFF'
          },
          font:{color:'#eeeeee'},
          shapeProperties: {
            useBorderWithImage:true
          }
        },
        edges: {
          color: 'lightgray'
        }
      };
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
public class NodeStylesImagesWithBordersExample extends AbstractExample {

  private final NetworkDiagram nd;
  private static final String IMAGEPATH = "frontend/img/indonesia/";

  public NodeStylesImagesWithBordersExample() {
    nd = new NetworkDiagram(Options.builder() //
        .withNodes(Nodes.builder().withBorderWidth(4).withSize(30) //
            .withColor(NodeColor.builder().withBorder("#406897").withBackground("#6AAFFF").build()) //
            .withFont(Font.builder().withColor("#eeeeee").build())//
            .withShapeProperties(ShapeProperties.builder().withUseBorderWithImage(true).build())
            .build()) //
        .withEdges(Edges.builder().withColor("lightgray").build()) //
        .build());
    nd.setSize("800px", "800px");
    this.getStyle().set("background-color", "#333333");

    // Set Nodes

    final Node node1 =
        new Node("1", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "1.png"));
    final Node node2 =
        new Node("2", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "2.png"));
    final Node node3 =
        new Node("3", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "3.png"));
    final Node node4 = new Node("4", "pictures by this guy!",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "4.png"));
    final Node node5 =
        new Node("5", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "5.png"));
    final Node node6 =
        new Node("6", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "6.png"));
    final Node node7 =
        new Node("7", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "7.png"));
    final Node node8 =
        new Node("8", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "8.png"));
    final Node node9 =
        new Node("9", Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "9.png"));
    final Node node10 = new Node("10",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "10.png"));
    final Node node11 = new Node("11",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "11.png"));
    final Node node12 = new Node("12",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "12.png"));
    final Node node13 = new Node("13",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "13.png"));
    final Node node14 = new Node("14",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "14.png"));
    final Node node15 = new Node("15", "when images\nfail\nto load",
        Node.builder().withShape(Shape.image).withImage(IMAGEPATH + "missing.png")
            .withBrokenImage(IMAGEPATH + "missingBrokenImage.png"));
    final Node node16 =
        new Node("16", "fallback image in action", Node.builder().withShape(Shape.image)
            .withImage(IMAGEPATH + "anotherMissing.png").withBrokenImage(IMAGEPATH + "9.png"));
    nd.setNodes(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11,
        node12, node13, node14, node15, node16);

    // Set Edges
    nd.setEdges("1", "2", "2", "3", "2", "4", "4", "5", "4", "10", "4", "6", "6", "7", "7", "8",
        "8", "9", "8", "10", "10", "11", "11", "12", "12", "13", "13", "14", "9", "16");
    nd.addSelectNodeListener(ev -> Notification.show("node selected"));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}

package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
    var color = 'gray';
    var len = undefined;

    var nodes = [{id: 0, label: "0", group: 0},
        {id: 1, label: "1", group: 0},
        {id: 2, label: "2", group: 0},
        {id: 3, label: "3", group: 1},
        {id: 4, label: "4", group: 1},
        {id: 5, label: "5", group: 1},
        {id: 6, label: "6", group: 2},
        {id: 7, label: "7", group: 2},
        {id: 8, label: "8", group: 2},
        {id: 9, label: "9", group: 3},
        {id: 10, label: "10", group: 3},
        {id: 11, label: "11", group: 3},
        {id: 12, label: "12", group: 4},
        {id: 13, label: "13", group: 4},
        {id: 14, label: "14", group: 4},
        {id: 15, label: "15", group: 5},
        {id: 16, label: "16", group: 5},
        {id: 17, label: "17", group: 5},
        {id: 18, label: "18", group: 6},
        {id: 19, label: "19", group: 6},
        {id: 20, label: "20", group: 6},
        {id: 21, label: "21", group: 7},
        {id: 22, label: "22", group: 7},
        {id: 23, label: "23", group: 7},
        {id: 24, label: "24", group: 8},
        {id: 25, label: "25", group: 8},
        {id: 26, label: "26", group: 8},
        {id: 27, label: "27", group: 9},
        {id: 28, label: "28", group: 9},
        {id: 29, label: "29", group: 9}
    ];
    var edges = [{from: 1, to: 0},
        {from: 2, to: 0},
        {from: 4, to: 3},
        {from: 5, to: 4},
        {from: 4, to: 0},
        {from: 7, to: 6},
        {from: 8, to: 7},
        {from: 7, to: 0},
        {from: 10, to: 9},
        {from: 11, to: 10},
        {from: 10, to: 4},
        {from: 13, to: 12},
        {from: 14, to: 13},
        {from: 13, to: 0},
        {from: 16, to: 15},
        {from: 17, to: 15},
        {from: 15, to: 10},
        {from: 19, to: 18},
        {from: 20, to: 19},
        {from: 19, to: 4},
        {from: 22, to: 21},
        {from: 23, to: 22},
        {from: 22, to: 13},
        {from: 25, to: 24},
        {from: 26, to: 25},
        {from: 25, to: 7},
        {from: 28, to: 27},
        {from: 29, to: 28},
        {from: 28, to: 0}
    ]

    // create a network
    var container = document.getElementById('mynetwork');
    var data = {
        nodes: nodes,
        edges: edges
    };
    var options = {
        nodes: {
            shape: 'dot',
            size: 30,
            font: {
                size: 32,
                color: '#ffffff'
            },
            borderWidth: 2
        },
        edges: {
            width: 2
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
@StyleSheet("https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css")
public class NodeStylesGroupsExample extends AbstractExample {

  private final NetworkDiagram nd;

  public NodeStylesGroupsExample() {
    this.getStyle().set("border", "1px solid #444444");
    this.getStyle().set("font", "12pt arial");
    this.getStyle().set("background-color", "#222222");

    // Set Nodes
    final Node node0 = new Node("0", "0", Nodes.builder().withGroup("0"));
    final Node node1 = new Node("1", "1", Nodes.builder().withGroup("0"));
    final Node node2 = new Node("2", "2", Nodes.builder().withGroup("0"));
    final Node node3 = new Node("3", "3", Nodes.builder().withGroup("1"));
    final Node node4 = new Node("4", "4", Nodes.builder().withGroup("1"));
    final Node node5 = new Node("5", "5", Nodes.builder().withGroup("1"));
    final Node node6 = new Node("6", "6", Nodes.builder().withGroup("2"));
    final Node node7 = new Node("7", "7", Nodes.builder().withGroup("2"));
    final Node node8 = new Node("8", "8", Nodes.builder().withGroup("2"));
    final Node node9 = new Node("9", "9", Nodes.builder().withGroup("3"));
    final Node node10 = new Node("10", "10", Nodes.builder().withGroup("3"));
    final Node node11 = new Node("11", "11", Nodes.builder().withGroup("3"));
    final Node node12 = new Node("12", "12", Nodes.builder().withGroup("4"));
    final Node node13 = new Node("13", "13", Nodes.builder().withGroup("4"));
    final Node node14 = new Node("14", "14", Nodes.builder().withGroup("4"));
    final Node node15 = new Node("15", "15", Nodes.builder().withGroup("5"));
    final Node node16 = new Node("16", "16", Nodes.builder().withGroup("5"));
    final Node node17 = new Node("17", "17", Nodes.builder().withGroup("5"));
    final Node node18 = new Node("18", "18", Nodes.builder().withGroup("6"));
    final Node node19 = new Node("19", "19", Nodes.builder().withGroup("6"));
    final Node node20 = new Node("20", "20", Nodes.builder().withGroup("6"));
    final Node node21 = new Node("21", "21", Nodes.builder().withGroup("7"));
    final Node node22 = new Node("22", "22", Nodes.builder().withGroup("7"));
    final Node node23 = new Node("23", "23", Nodes.builder().withGroup("7"));
    final Node node24 = new Node("24", "24", Nodes.builder().withGroup("8"));
    final Node node25 = new Node("25", "25", Nodes.builder().withGroup("8"));
    final Node node26 = new Node("26", "26", Nodes.builder().withGroup("8"));
    final Node node27 = new Node("27", "27", Nodes.builder().withGroup("9"));
    final Node node28 = new Node("28", "28", Nodes.builder().withGroup("9"));
    final Node node29 = new Node("29", "29", Nodes.builder().withGroup("9"));

    nd = new NetworkDiagram(Options.builder() //
        .withNodes(Nodes.builder().withShape(Shape.dot).withSize(30)//
            .withFont(Font.builder().withSize(32).withColor("#ffffff").build())//
            .withBorderWidth(2) //
            .build()) //
        .withEdges(Edges.builder().withWidth(2.0).build()) //
        .build());
    nd.diagramSetSize("800px", "800px");
    nd.setNodes(node0, node1, node2, node3, node4, node5, node6, node7, node8, node9, node10,
        node11, node12, node13, node14, node15, node16, node17, node18, node19, node20, node21,
        node22, node23, node24, node25, node26, node27, node28, node29);

    // Set Edges
    nd.setEdges("1", "0", "2", "0", "4", "3", "5", "4", "4", "0", "7", "6", "8", "7", "7", "0",
        "10", "9", "11", "10", "10", "4", "13", "12", "14", "13", "13", "0", "16", "15", "17", "15",
        "15", "10", "19", "18", "20", "19", "19", "4", "22", "21", "23", "22", "22", "13", "25",
        "24", "26", "25", "25", "7", "28", "27", "29", "28", "28", "0");
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}

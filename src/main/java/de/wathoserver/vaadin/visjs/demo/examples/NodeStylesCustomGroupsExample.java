package de.wathoserver.vaadin.visjs.demo.examples;


import com.google.common.collect.ImmutableMap;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.Icon;
import de.wathoserver.vaadin.visjs.network.options.nodes.Icon.Face;
import de.wathoserver.vaadin.visjs.network.options.nodes.NodeColor;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
    var nodes = [
        {id: 0, label: "0", group: 'source'},
        {id: 1, label: "1", group: 'icons'},
        {id: 2, label: "2", group: 'icons'},
        {id: 3, label: "3", group: 'icons'},
        {id: 4, label: "4", group: 'icons'},
        {id: 5, label: "5", group: 'icons'},
        {id: 6, label: "6", group: 'icons'},
        {id: 7, label: "7", group: 'icons'},
        {id: 8, label: "8", group: 'icons'},
        {id: 9, label: "9", group: 'icons'},
        {id: 10, label: "10", group: 'mints'},
        {id: 11, label: "11", group: 'mints'},
        {id: 12, label: "12", group: 'mints'},
        {id: 13, label: "13", group: 'mints'},
        {id: 14, label: "14", group: 'mints'},
        {id: 15, group: 'dotsWithLabel'},
        {id: 16, group: 'dotsWithLabel'},
        {id: 17, group: 'dotsWithLabel'},
        {id: 18, group: 'dotsWithLabel'},
        {id: 19, group: 'dotsWithLabel'},
        {id: 20, label: "diamonds", group: 'diamonds'},
        {id: 21, label: "diamonds", group: 'diamonds'},
        {id: 22, label: "diamonds", group: 'diamonds'},
        {id: 23, label: "diamonds", group: 'diamonds'},
    ];
    var edges = [
        {from: 1, to: 0},
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
        {from: 23, to: 0},
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
            size: 20,
            font: {
                size: 15,
                color: '#ffffff'
            },
            borderWidth: 2
        },
        edges: {
            width: 2
        },
        groups: {
            diamonds: {
                color: {background:'red',border:'white'},
                shape: 'diamond'
            },
            dotsWithLabel: {
                label: "I'm a dot!",
                shape: 'dot',
                color: 'cyan'
            },
            mints: {color:'rgb(0,255,140)'},
            icons: {
                shape: 'icon',
                icon: {
                    face: 'FontAwesome',
                    code: '\uf0c0',
                    size: 50,
                    color: 'orange'
                }
            },
            source: {
                color:{border:'white'}
            }
        }
    };
    var network = new vis.Network(container, data, options);

</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
@StyleSheet("http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css")
public class NodeStylesCustomGroupsExample extends AbstractExample {

  private final NetworkDiagram nd;

  public NodeStylesCustomGroupsExample() {
    this.getStyle().set("border", "1px solid #444444");
    this.getStyle().set("background-color", "#222222");
    this.addClassName("fa");

    // Set Nodes
    final Node node0 = new Node("0", "0", Nodes.builder().withGroup("source"));
    final Node node1 = new Node("1", "1", Nodes.builder().withGroup("icons"));
    final Node node2 = new Node("2", "2", Nodes.builder().withGroup("icons"));
    final Node node3 = new Node("3", "3", Nodes.builder().withGroup("icons"));
    final Node node4 = new Node("4", "4", Nodes.builder().withGroup("icons"));
    final Node node5 = new Node("5", "5", Nodes.builder().withGroup("icons"));
    final Node node6 = new Node("6", "6", Nodes.builder().withGroup("icons"));
    final Node node7 = new Node("7", "7", Nodes.builder().withGroup("icons"));
    final Node node8 = new Node("8", "8", Nodes.builder().withGroup("icons"));
    final Node node9 = new Node("9", "9", Nodes.builder().withGroup("icons"));
    final Node node10 = new Node("10", "10", Nodes.builder().withGroup("mints"));
    final Node node11 = new Node("11", "11", Nodes.builder().withGroup("mints"));
    final Node node12 = new Node("12", "12", Nodes.builder().withGroup("mints"));
    final Node node13 = new Node("13", "13", Nodes.builder().withGroup("mints"));
    final Node node14 = new Node("14", "14", Nodes.builder().withGroup("mints"));
    final Node node15 = new Node("15", Nodes.builder().withGroup("dotsWithLabel"));
    final Node node16 = new Node("16", Nodes.builder().withGroup("dotsWithLabel"));
    final Node node17 = new Node("17", Nodes.builder().withGroup("dotsWithLabel"));
    final Node node18 = new Node("18", Nodes.builder().withGroup("dotsWithLabel"));
    final Node node19 = new Node("19", Nodes.builder().withGroup("dotsWithLabel"));
    final Node node20 = new Node("20", "diamonds", Nodes.builder().withGroup("diamonds"));
    final Node node21 = new Node("21", "diamonds", Nodes.builder().withGroup("diamonds"));
    final Node node22 = new Node("22", "diamonds", Nodes.builder().withGroup("diamonds"));
    final Node node23 = new Node("23", "diamonds", Nodes.builder().withGroup("diamonds"));

    nd = new NetworkDiagram(Options.builder() //
        .withNodes(Nodes.builder().withShape(Shape.dot).withSize(20)//
            .withFont(Font.builder().withSize(15).withColor("#ffffff").build())//
            .withBorderWidth(2) //
            .build()) //
        .withEdges(Edges.builder().withWidth(2).build()) //
        .withGroups(ImmutableMap.of("diamonds",
            Nodes.builder()
                .withColor(NodeColor.builder().withBackground("red").withBorder("white").build())
                .withShape(Shape.diamond).build(),
            "dotsWithLabel",
            Nodes
                .builder().withLabel("I'm a dot").withShape(Shape.dot).withColorStr("cyan").build(),
            "mints", Nodes.builder().withColorStr("rgb(0,255,140").build(), "icons",
            Nodes.builder().withShape(Shape.icon)
                .withIcon(Icon.builder().withFace(Face.FontAwesome).withCode("\uf0c0")
                    .withSize(50)
                    .withColor("orange").build())
                .build(),
            "source",
            Nodes.builder().withColor(NodeColor.builder().withBorder("white").build()).build()))
        .build());
    nd.diagramSetSize("800px", "800px");
    nd.setNodes(node0, node1, node2, node3, node4, node5, node6, node7, node8, node9, node10,
        node11, node12, node13, node14, node15, node16, node17, node18, node19, node20, node21,
        node22, node23);

    // Set Edges
    nd.setEdges("1", "0", "2", "0", "4", "3", "5", "4", "4", "0", "7", "6", "8", "7", "7", "0",
        "10", "9", "11", "10", "10", "4", "13", "12", "14", "13", "13", "0", "16", "15", "17", "15",
        "15", "10", "19", "18", "20", "19", "19", "4", "22", "21", "23", "22", "23", "0");
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}

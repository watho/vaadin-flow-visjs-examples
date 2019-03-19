package de.wathoserver.vaadin.visjs.demo.examples;

import com.google.common.collect.ImmutableMap;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.Icon;
import de.wathoserver.vaadin.visjs.network.options.nodes.Icon.Face;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
 * <script type="text/javascript">
 * var optionsFA = {
        groups: {
          usergroups: {
            shape: 'icon',
            icon: {
              face: 'FontAwesome',
              code: '\uf0c0',
              size: 50,
              color: '#57169a'
            }
          },
          users: {
            shape: 'icon',
            icon: {
              face: 'FontAwesome',
              code: '\uf007',
              size: 50,
              color: '#aa00ff'
            }
          }
        }
      };

      // create an array with nodes
      var nodesFA = [{
        id: 1,
        label: 'User 1',
        group: 'users'
      }, {
        id: 2,
        label: 'User 2',
        group: 'users'
      }, {
        id: 3,
        label: 'Usergroup 1',
        group: 'usergroups'
      }, {
        id: 4,
        label: 'Usergroup 2',
        group: 'usergroups'
      }, {
        id: 5,
        label: 'Organisation 1',
        shape: 'icon',
        icon: {
          face: 'FontAwesome',
          code: '\uf1ad',
          size: 50,
          color: '#f0a30a'
        }
      }];

      // create an array with edges
      var edges = [{
        from: 1,
        to: 3
      }, {
        from: 1,
        to: 4
      }, {
        from: 2,
        to: 4
      }, {
        from: 3,
        to: 5
      }, {
        from: 4,
        to: 5
      }];

      // create a network
      var containerFA = document.getElementById('mynetworkFA');
      var dataFA = {
        nodes: nodesFA,
        edges: edges
      };

      var networkFA = new vis.Network(containerFA, dataFA, optionsFA);

      /*
       * Example for Ionicons
      var optionsIO = {
        groups: {
          usergroups: {
            shape: 'icon',
            icon: {
              face: 'Ionicons',
              code: '\uf47c',
              size: 50,
              color: '#57169a'
            }
          },
          users: {
            shape: 'icon',
            icon: {
              face: 'Ionicons',
              code: '\uf47e',
              size: 50,
              color: '#aa00ff'
            }
          }
        }
      };

      // create an array with nodes
      var nodesIO = [{
        id: 1,
        label: 'User 1',
        group: 'users'
      }, {
        id: 2,
        label: 'User 2',
        group: 'users'
      }, {
        id: 3,
        label: 'Usergroup 1',
        group: 'usergroups'
      }, {
        id: 4,
        label: 'Usergroup 2',
        group: 'usergroups'
      }, {
        id: 5,
        label: 'Organisation 1',
        shape: 'icon',
        icon: {
          face: 'Ionicons',
          code: '\uf276',
          size: 50,
          color: '#f0a30a'
        }
      }];


      // create a network
      var containerIO = document.getElementById('mynetworkIO');
      var dataIO = {
        nodes: nodesIO,
        edges: edges
      };

      var networkIO = new vis.Network(containerIO, dataIO, optionsIO);
    }
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
@StyleSheet("http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css")
public class NodeStylesIconsExample extends AbstractExample {

  private final NetworkDiagram ndFa;

  public NodeStylesIconsExample() {
    this.getStyle().set("border", "1px solid #444444");
    // Loads awesome fonts
    this.addClassName("fa");

    // Set Nodes
    final Node nodeFa1 = new Node("1", "Users 1", Nodes.builder().withGroup("users"));
    final Node nodeFa2 = new Node("2", "Users 2", Nodes.builder().withGroup("users"));
    final Node nodeFa3 = new Node("3", "Usergroup 1", Nodes.builder().withGroup("usergroups"));
    final Node nodeFa4 = new Node("4", "Usergroup 2", Nodes.builder().withGroup("usergroups"));
    final Node nodeFa5 = new Node("5", "Organisation 1",
        Nodes.builder().withShape(Shape.icon).withIcon(Icon.builder().withFace(Face.FontAwesome)
            .withCode("\uf1ad").withSize(50).withColor("#f0a30a").build()));

    // FontAwesome example
    ndFa = new NetworkDiagram(Options.builder() //
        .withGroups(
            ImmutableMap
                .of("usergroups",
                    Nodes.builder().withShape(Shape.icon)
                        .withIcon(Icon.builder().withFace(Face.FontAwesome).withCode("\uf0c0")
                            .withSize(50).withColor("#57169a").build())
                        .build(),
                    "users",
                    Nodes.builder().withShape(Shape.icon)
                        .withIcon(Icon.builder().withFace(Face.FontAwesome).withCode("\uf007")
                            .withSize(50).withColor("#aa00ff").build())
                        .build()))
        .build());
    ndFa.setSize("700px", "300px");
    ndFa.setNodes(nodeFa1, nodeFa2, nodeFa3, nodeFa4, nodeFa5);

    // Set Edges
    ndFa.setEdges("1", "3", "1", "4", "2", "4", "3", "5", "4", "5");

    // FontAwesome example
    final NetworkDiagram ndIo = new NetworkDiagram(Options.builder() //
        .withGroups(ImmutableMap.of("usergroups",
            Nodes.builder().withShape(Shape.icon)
                .withIcon(Icon.builder().withFace(Face.Ionicons).withCode("\uf47c").withSize(50)
                    .withColor("#57169a").build())
                .build(),
            "users",
            Nodes.builder().withShape(Shape.icon)
                .withIcon(Icon.builder().withFace(Face.Ionicons).withCode("\uf47e").withSize(50)
                    .withColor("#aa00ff").build())
                .build()))
        .build());
    ndIo.setSize("700px", "300px");
    ndIo.getStyle().set("border", "1px solid #444444");
    final Node nodeIo5 =
        new Node("5", "Organisation 1", Node.builder().withShape(Shape.icon).withIcon(Icon.builder()
            .withFace(Face.Ionicons).withCode("\uf276").withSize(50).withColor("#f0a30a").build()));
    ndIo.setNodes(nodeFa1, nodeFa2, nodeFa3, nodeFa4, nodeIo5);

    // Set Edges
    ndIo.setEdges("1", "3", "1", "4", "2", "4", "3", "5", "4", "5");

    // add to layout
    add(new Paragraph("with FontAwesome-icons"));
    add(ndFa);
    add(new Paragraph("with Ioicon-icons"));
    add(ndIo);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return ndFa;
  }

}

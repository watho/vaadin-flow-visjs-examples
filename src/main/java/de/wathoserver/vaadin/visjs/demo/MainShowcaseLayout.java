package de.wathoserver.vaadin.visjs.demo;

import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.appmenu.left.LeftNavigationComponent;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftSubMenuBuilder;
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RoutePrefix;

import de.wathoserver.vaadin.visjs.demo.showcase.views.BasicUsageView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.IntroductionView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.NodeStylesCircularImagesView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.NodeStylesColorsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.NodeStylesCustomGroupsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.NodeStylesGroupsView;
import de.wathoserver.vaadin.visjs.demo.showcase.views.NodeStylesHtmlInNodeView;

@SuppressWarnings("serial")
@RoutePrefix("showcase")
public class MainShowcaseLayout extends AppLayoutRouterLayout {

  public MainShowcaseLayout() {
    init(AppLayoutBuilder.get(Behaviour.LEFT_RESPONSIVE)
        .withTitle("Vis.js Showcase v" + MainView.RELEASE)
        .withAppMenu(
            LeftAppMenuBuilder.get().add(new LeftNavigationComponent(IntroductionView.class))
                .add(new LeftNavigationComponent(BasicUsageView.class)).add(buildNodeStylesSubMenu())
                .build())
        .build());
  }

  private Component buildNodeStylesSubMenu() {
    return LeftSubMenuBuilder.get("Node styles", VaadinIcon.CIRCLE.create())
        .add(new LeftNavigationComponent(NodeStylesCircularImagesView.class)) //
        .add(new LeftNavigationComponent(NodeStylesColorsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesCustomGroupsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesGroupsView.class)) //
        .add(new LeftNavigationComponent(NodeStylesHtmlInNodeView.class)) //
        .build();
  }
}

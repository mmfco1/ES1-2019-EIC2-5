package main.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({MainTest.class, ClientTest.class, GUIregrasTest.class, GuiTest.class, RegrasTest.class, WorkerTest.class })
public class AllTests {
}
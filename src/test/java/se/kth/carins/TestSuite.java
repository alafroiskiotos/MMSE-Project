package se.kth.carins;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClaimTest.class, CustomerFormTest.class, EmployeeTest.class, ClientTest.class })
public class TestSuite {

}
